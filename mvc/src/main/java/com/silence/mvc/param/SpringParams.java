package com.silence.mvc.param;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Size;

/**
 * Created by Silence on 2018/4/17.
 */
public class SpringParams {

    @Size(min = 1, max = 2, message = "条件过长！")
    private String condition;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

}
