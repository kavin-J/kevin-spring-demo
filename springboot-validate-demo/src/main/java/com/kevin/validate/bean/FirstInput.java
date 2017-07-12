package com.kevin.validate.bean;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * Created by mypos on 2017/7/12.
 */
public class FirstInput{

    @Valid
    @NotEmpty(message = "list 不能为空")
    private List<People> list;

    public List<People> getList() {
        return list;
    }

    public void setList(List<People> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (People p : list) {
            sb.append(p.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
