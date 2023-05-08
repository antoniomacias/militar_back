package com.fansroulette.rest.modelo;

import java.util.List;

public class ZTP_RULETA {
    
    private ZTT_RULETA ls_ruleta;
    private List<ZTT_CONFIG_RULETA> lt_config_ruleta;

    
    public ZTP_RULETA() {
    }

    public ZTP_RULETA(ZTT_RULETA ls_ruleta, List<ZTT_CONFIG_RULETA> lt_config_ruleta) {
        this.ls_ruleta = ls_ruleta;
        this.lt_config_ruleta = lt_config_ruleta;
    }

    public ZTT_RULETA getLs_ruleta() {
        return ls_ruleta;
    }
    public void setLs_ruleta(ZTT_RULETA ls_ruleta) {
        this.ls_ruleta = ls_ruleta;
    }
    public List<ZTT_CONFIG_RULETA> getLt_config_ruleta() {
        return lt_config_ruleta;
    }
    public void setLt_config_ruleta(List<ZTT_CONFIG_RULETA> lt_config_ruleta) {
        this.lt_config_ruleta = lt_config_ruleta;
    }
    
}
