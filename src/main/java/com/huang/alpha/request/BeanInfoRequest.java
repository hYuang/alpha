package com.huang.alpha.request;

public class BeanInfoRequest extends  BaseRequest {

    private  String name;
    private  Class type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }
}
