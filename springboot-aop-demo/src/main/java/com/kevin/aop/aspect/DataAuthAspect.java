package com.kevin.aop.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kevin.aop.service.DataService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 数据权限切面处理
 *
 * @author Jkevin
 * @create 2017-07-17
 **/
@Component
@Aspect
public class DataAuthAspect {
    /**
     * 日志切入点
     */
    @Autowired
    private DataService service;

    @Pointcut("@annotation(com.kevin.aop.aspect.DataAuth)")
    public void validate() {
    }

    /**
     * auth check
     *
     * @param joinPoint 连接点
     * @return 方法执行结果
     * @throws Throwable 调用出错
     */
    @Around("validate()")
    public Object saveLog(ProceedingJoinPoint joinPoint) throws Throwable {

        /**
         * 解析注解
         */
        String methodName = joinPoint.getSignature().getName();
        Method method = this.currentMethod(joinPoint, methodName);
        DataAuth auth = method.getAnnotation(DataAuth.class);

        /**
         * 解析请求,获取api入参值,只能在controller里使用
         */
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        String perm = request.getParameter("perm");

        /*
        获取方法入参值，可以在非HttpServletRequest 下获取参数值
        Object[] args = joinPoint.getArgs();
        JSONObject params;
        if (args != null && args.length == 1) {//一个参数
            params = JSON.parseObject(JSONObject.toJSONString(args[0]));
        }else{
            throw new RuntimeException("");
        }*/

        /**
         * 权限校验
         */
        if (auth != null) {
            boolean validateResult = this.service.validateAuth(perm, auth.perms());
            if (!validateResult) {
                throw new RuntimeException("数据权限校验失败!");
            }
        }

        /**
         * 方法执行
         */
        Object obj = joinPoint.proceed();

        return obj;
    }

    /**
     * 获取当前执行的方法
     *
     * @param joinPoint  连接点
     * @param methodName 方法名称
     * @return 当前执行的方法
     */
    private Method currentMethod(ProceedingJoinPoint joinPoint, String methodName) {
        //获取目标类的所有方法，找到当前要执行的方法
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        Method resultMethod = null;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                resultMethod = method;
                break;
            }
        }
        return resultMethod;
    }
}
