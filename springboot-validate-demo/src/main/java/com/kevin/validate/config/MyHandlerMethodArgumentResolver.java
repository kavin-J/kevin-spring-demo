package com.kevin.validate.config;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectReader;
import com.kevin.validate.annotation.ApiParamValidate;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;

/**
 * Created by kevin on 2017/7/13.
 */
public class MyHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    private Logger log = LoggerFactory.getLogger(getClass());
    public boolean supportsParameter(MethodParameter methodParameter) {
        ApiParamValidate as = methodParameter.getMethodAnnotation(ApiParamValidate.class);
        return null != as;
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        Class<?> clazz = parameter.getParameterType();
        log.debug("cls:{}", clazz);
        InputStream is = request.getInputStream();
        String jsonParams = IOUtils.toString(is, "UTF-8");
        log.debug("s:{}", jsonParams);
        IOUtils.closeQuietly(is);
        ObjectReader objectReader = Jackson2ObjectMapperBuilder.json().build().reader();
        JavaType javaType = objectReader.getTypeFactory().constructType(clazz);
        Object obj = objectReader.forType(javaType).readValue(jsonParams);
        final WebDataBinder binder = webDataBinderFactory.createBinder(nativeWebRequest, obj, clazz.getName());
        binder.validate(new Object[]{obj});
        BindingResult result = binder.getBindingResult();
        //validate
        List<ObjectError> el = result.getAllErrors();
        if(null != el && el.size() > 0){
            FieldError fe = null;
            StringBuilder sb = new StringBuilder();
            for(ObjectError oe : el){
                if(oe instanceof FieldError){
                    fe = (FieldError) oe;
                    log.debug("{},{},{}", fe.getField(), fe.getObjectName(), fe.getDefaultMessage());
                    sb.append("Field:").append(fe.getField()).append(", error：").append(fe.getDefaultMessage());
                }else{
                    log.debug("{},{}", oe.getObjectName(), oe.getDefaultMessage());
                    sb.append("Object：").append(oe.getObjectName()).append(", error：").append(oe.getDefaultMessage());
                }
                sb.append(";");
            }
            throw new Exception(sb.toString());
        }
        return obj;
    }
}
