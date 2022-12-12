package com.example.spinner_gridview_autotext_search_task.Model;

public class GridModel {
    int gridimage;
    String StateName,stateLanguage,StateCM,stateParty;

    public GridModel(int gridimage, String stateName, String stateLanguage, String stateCM, String stateParty) {
        this.gridimage = gridimage;
        this.StateName = stateName;
        this.stateLanguage = stateLanguage;
       this.StateCM = stateCM;
        this.stateParty = stateParty;
    }

    public int getGridimage() {
        return gridimage;
    }

    public void setGridimage(int gridimage) {
        this.gridimage = gridimage;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public String getStateLanguage() {
        return stateLanguage;
    }

    public void setStateLanguage(String stateLanguage) {
        this.stateLanguage = stateLanguage;
    }

    public String getStateCM() {
        return StateCM;
    }

    public void setStateCM(String stateCM) {
        StateCM = stateCM;
    }

    public String getStateParty() {
        return stateParty;
    }

    public void setStateParty(String stateParty) {
        this.stateParty = stateParty;
    }
}
