package com.kevin;

import com.kevin.validate.bean.IssueOrderInput;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by mypos on 2017/7/7.
 */
public class TestValidate {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void manufacturerIsNull() {
        IssueOrderInput input = new IssueOrderInput();
        input.setAppId("123");
        input.setAuthCode(100000);
        input.setEndTime("2017-10-18 12:22:09");
        input.setOrderId(1234567l);
        input.setRfid("21235682");
        input.setVin("2");
        input.setStartTime("2017-10-18 12:22:09");
        input.setFlag(6);
        Set<ConstraintViolation<IssueOrderInput>> constraintViolations =
                validator.validate(input);

        assertEquals(0, constraintViolations.size());
        System.err.println(constraintViolations.iterator().next().getMessage());
//        assertEquals(
//                "格式匹配不正确(yyyy-MM-dd HH:mm:ss)",
//                constraintViolations.iterator().next().getMessage()
//        );
    }

    @Test
    public void success() {

        IssueOrderInput input = new IssueOrderInput();
        input.setAppId("123");
        input.setAuthCode(100000);
        input.setEndTime("2017-10-18 12:22:09");
        input.setOrderId(1234567l);
        input.setRfid("21235682");
        input.setVin("2");
        input.setFlag(9);
        input.setStartTime("2017-10-18 12:22:09");
        Set<ConstraintViolation<IssueOrderInput>> constraintViolations =
                validator.validate(input);

        assertEquals(0, constraintViolations.size());


    }
}
