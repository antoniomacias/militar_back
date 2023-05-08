package com.fansroulette.rest.modelo;

public class ZTP_RULETA_CONFIG {

    ZTT_CONFIG_RULETA ls_config_ruleta;
    boolean disable;

    
    public ZTP_RULETA_CONFIG(ZTT_CONFIG_RULETA ls_config_ruleta, boolean disable) {
        this.ls_config_ruleta = ls_config_ruleta;
        this.disable = disable;
    }


    public ZTT_CONFIG_RULETA getLs_config_ruleta() {
        return ls_config_ruleta;
    }
    public void setLs_config_ruleta(ZTT_CONFIG_RULETA ls_config_ruleta) {
        this.ls_config_ruleta = ls_config_ruleta;
    }
    
    public void setDisable(boolean disable) {
        this.disable = disable;
    }
    public boolean isDisable() {
        return disable;
    }
}
