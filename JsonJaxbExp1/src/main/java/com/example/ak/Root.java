package com.example.ak;

import javax.xml.bind.annotation.XmlElement;


public class Root {

    protected String firstElement;
    protected String secondElement;

    public String getFirstElement() {
        return firstElement;
    }

    public void setFirstElement(String value) {
        this.firstElement = value;
    }

    public String getSecondElement() {
        return secondElement;
    }

    public void setSecondElement(String value) {
        this.secondElement = value;
    }

}
