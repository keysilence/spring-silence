package com.silence.mongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="SEQ")
public class SEQ {
    String seqKey;
    Long seqValue;

    public String getSeqKey() {
        return seqKey;
    }

    public void setSeqKey(String seqKey) {
        this.seqKey = seqKey;
    }

    public Long getSeqValue() {
        return seqValue;
    }

    public void setSeqValue(Long seqValue) {
        this.seqValue = seqValue;
    }
}
