package com.silence.mvc.param;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by Silence on 2018/4/17.
 */
public class SpringParams {

    @NotEmpty(message = "名称不能为空！")
    @Size(min = 1, max = 5, message = "名称至少一个字，最多五个字！")
    private String name;

    @Size(min = 1, max = 2, message = "条件过长！")
    private String condition;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

}
