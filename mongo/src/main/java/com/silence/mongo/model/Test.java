package com.silence.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Silence on 2018/4/16.
 */
@Document(collection = "Test")
public class Test extends BaseMongoModel {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Test{");
        sb.append("id='");
        sb.append(super.getId());
        sb.append("',name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
