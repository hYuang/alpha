package com.huang.alpha.request;

import java.util.Date;

public class BaseRequest {
    private String  requestId;
    private  Date  requestTimeStart;
    private Date requestTimeEnd;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
