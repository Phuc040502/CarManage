package com.example.demo1.model;

public class ResponeseObject {
    private String stutus;
    private String messages;
    private Object data;

    public ResponeseObject(){}

    public ResponeseObject(String stutus, String messages, Object data) {
        this.stutus = stutus;
        this.messages = messages;
        this.data = data;
    }

    public String getStutus() {
        return stutus;
    }

    public void setStutus(String stutus) {
        this.stutus = stutus;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
