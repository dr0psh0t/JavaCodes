package com.daryll.reflections.privatefieldsmethods;

public class PrivateObject {

    private String privateString = null;

    public PrivateObject(String privateString) {
        this.privateString = privateString;
    }

    public String getPrivateString() {
        return privateString;
    }
}
