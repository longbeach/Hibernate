package com.hibernate.tutorial;

public class OutdoorGame extends Game {
    
    private String requiredArea;
   
    public String getRequiredArea() {
       return requiredArea;
    }

    public void setRequiredArea(String requiredArea) {
       this.requiredArea = requiredArea;
    }
}