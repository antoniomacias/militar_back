package com.militar.rest.modelo.POJO;

import java.util.List;

public class ZTP_RESULTADOS {
    private int idcategory;
    private String name;
    List<ZTP_RESULTADO> ls_result;


    public ZTP_RESULTADOS() {
    }
    
    public ZTP_RESULTADOS(int idcategory, String name, List<ZTP_RESULTADO> ls_result) {
        this.idcategory = idcategory;
        this.name = name;
        this.ls_result = ls_result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ZTP_RESULTADO> getLs_result() {
        return ls_result;
    }

    public void setLs_result(List<ZTP_RESULTADO> ls_result) {
        this.ls_result = ls_result;
    }

    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }
}
