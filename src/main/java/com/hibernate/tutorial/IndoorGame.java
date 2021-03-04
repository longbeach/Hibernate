package com.hibernate.tutorial;

public class IndoorGame extends Game {
    
    private int numberOfPlayers;

    private String ageGroup;

    public int getNumberOfPlayers() {
       return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
       this.numberOfPlayers = numberOfPlayers;
    }
    public String getAgeGroup() {
       return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
       this.ageGroup = ageGroup;
    }
}
