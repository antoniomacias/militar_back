package com.militar.rest.modelo.POJO;

import java.util.List;

public class ZTP_CATEGORIA {
    private int idcategory;
    private String category;
    private List<ZTP_SUBCATEGORIA> ls_category;

    
    public ZTP_CATEGORIA() {
    }

    public ZTP_CATEGORIA(int idcategory, String category, List<ZTP_SUBCATEGORIA> ls_category) {
        this.idcategory = idcategory;
        this.category = category;
        this.ls_category = ls_category;
    }

    public int getIdcategory() {
        return idcategory;
    }
    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public List<ZTP_SUBCATEGORIA> getLs_category() {
        return ls_category;
    }
    public void setLs_category(List<ZTP_SUBCATEGORIA> ls_category) {
        this.ls_category = ls_category;
    }
}
