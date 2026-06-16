package com.proyecto_redes.store;

public class StokableProduct {
    private int productID;
    private Product product;
    private int numUnits;
    private double costPerUnit;
    private double pricePerUnit;

    public StokableProduct(int productID, Product product, int numUnits, double costPerUnit, double pricePerUnit) {
        this.productID = productID;
        this.product = product;
        this.numUnits = numUnits;
        this.costPerUnit = costPerUnit;
        this.pricePerUnit = pricePerUnit;
    }

    // Getters
    public int getProductID() {
        return productID;
    }

    public Product getProduct() {
        return product;
    }

    public int getNumUnits() {
        return numUnits;
    }

    public double getCostPerUnit() {
        return costPerUnit;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    // Setters
    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setNumUnits(int numUnits) {
        this.numUnits = numUnits;
    }

    public void setCostPerUnit(double costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}
