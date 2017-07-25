package com.kevin.aop.service;

import org.springframework.stereotype.Service;

/**
 * 数据权限校验
 *
 * @author jianghaiyang
 * @create 2017-07-17
 **/
@Service
public class DataService {
    /**
     * 校验数据权限
     *
     * @param hasPerm 已有的权限
     * @param perms   需要的权限
     * @return 有权限返回true，否则返回false
     */
    public boolean validateAuth(String hasPerm, String... perms) {
        for (String perm : perms) {
            if (perm.equals(hasPerm)) {
                return true;
            }
        }
        return false;
    }
}
