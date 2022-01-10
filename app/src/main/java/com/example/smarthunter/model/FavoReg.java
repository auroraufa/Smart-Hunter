package com.example.smarthunter.model;

public class FavoReg {

    public int id;
    public String icon;
    public String name;
    public boolean isSelected = false;

    public FavoReg(int id, String icon, String name) {
        this.id = id;
        this.icon = icon;
        this.name = name;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isSelected() {
        return isSelected;
    }
}
