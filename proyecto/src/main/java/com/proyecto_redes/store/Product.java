package com.proyecto_redes.store;

public class Product {

    //Constantes 
    private String name;
    private String brand;
    private char category;
    private boolean isConteable;
    private String meansureUnit;

    public Product() {
        this.name = null;
        this.brand = null;
        this.category = '\0';
        this.isConteable = false;
        this.meansureUnit = null;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public char getCategory() {
        return category;
    }

    public boolean isConteable() {
        return isConteable;
    }

    public String getMeansureUnit() {
        return meansureUnit;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCategory(char category) {
        this.category = category;
    }

    public void setConteable(boolean isConteable) {
        this.isConteable = isConteable;
    }

    public void setMeansureUnit(String meansureUnit) {
        this.meansureUnit = meansureUnit;
    }
}
