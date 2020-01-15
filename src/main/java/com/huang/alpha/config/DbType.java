package com.huang.alpha.config;

public enum DbType {
    
    MYSQL("mysql"),
    ELASTICSEARCH("elasticsearch"),
    REDIS("redis"),
    IGNITE("ignite");


    private String value;
    DbType(String value) {
        this.value =value;
    }

    public String getValue() {
        return value;
    }
}
