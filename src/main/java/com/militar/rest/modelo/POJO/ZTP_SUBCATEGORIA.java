package com.militar.rest.modelo.POJO;

public class ZTP_SUBCATEGORIA {
    private int idsubcategory;
    private String subcategory;

    
    public ZTP_SUBCATEGORIA() {
    }

    public ZTP_SUBCATEGORIA(int idsubcategory, String subcategory) {
        this.idsubcategory = idsubcategory;
        this.subcategory = subcategory;
    }

    public int getIdsubcategory() {
        return idsubcategory;
    }
    public void setIdsubcategory(int idsubcategory) {
        this.idsubcategory = idsubcategory;
    }
    public String getSubcategory() {
        return subcategory;
    }
    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }
}
