package com.kevin.validate.exception;

import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * Created by mypos on 2017/7/12.
 */
public class ExceptionHandle extends MethodArgumentNotValidException {
    public ExceptionHandle(MethodParameter parameter, BindingResult bindingResult) {
        super(parameter, bindingResult);
    }
}
