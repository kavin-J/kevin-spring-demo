package com.kevin.validate.controller;

import com.kevin.validate.annotation.ApiParamValidate;
import com.kevin.validate.bean.FirstInput;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mypos on 2017/7/13.
 */
@RestController
public class TestController {
    @ApiParamValidate
    @PostMapping("validate")//@RequestBody @Valid FirstInput input
    public String validateCascade(@RequestHeader(name = "appId") String appId, FirstInput input) {

        return input.toString();
    }
}
