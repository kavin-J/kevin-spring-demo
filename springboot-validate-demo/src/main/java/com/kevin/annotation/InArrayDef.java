package com.kevin.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * 实现注解校验InArray
 *
 * @author jianghaiyang
 * @create 2017-07-07
 **/
public class InArrayDef implements ConstraintValidator<InArray, Integer> {

    private int[] range;

    public void initialize(InArray constraintAnnotation) {
        this.range = constraintAnnotation.range();
    }

    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        System.err.println("value:" + value);
        int index = Arrays.binarySearch(range, value);
        if (value == null) {
            System.out.println("value:null");
            return false;
        } else if (index < 0) {
            System.out.println("index:-1");
            return false;
        } else {
            System.out.println("index:" + index);
            System.err.println("range:" + Arrays.toString(range));
            return true;
        }
    }
}
