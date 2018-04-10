package com.silence.domain;

/**
*
*/
public class Spring {

    private static final long serialVersionUID = 1L;

    private Long id;//唯一键
    private String name;//名称
        
    public Long getId () {
        return this.id;
    }

    public void setId (Long id) {
        this.id = id;
    }
    
    public String getName () {
        return this.name;
    }

    public void setName (String name) {
        this.name = name;
    }
    
}