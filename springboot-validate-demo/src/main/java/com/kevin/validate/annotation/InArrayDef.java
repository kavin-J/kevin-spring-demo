package com.kevin.validate.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * 实现注解校验InArray
 *
 * @author jianghaiyang
 * @create 2017-07-07
 **/
public class InArrayDef implements ConstraintValidator<InArray, Object> {

    private int[] range;

    public void initialize(InArray constraintAnnotation) {
        this.range = constraintAnnotation.range();
    }

    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        int index = Arrays.binarySearch(range, Integer.decode(value.toString()));
        if (value == null) {
            return false;
        } else if (index < 0) {
            return false;
        } else {
            return true;
        }
    }
}
