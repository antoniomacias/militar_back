package com.militar.rest.modelo.POJO;

public class ZTP_PREGUNTAS_RESULT {
    private int idpregunta;
    private boolean rcorrecta;
    private boolean rfalsa1;
    private boolean rfalsa2;
    private boolean rfalsa3;

    
    public int getIdpregunta() {
        return idpregunta;
    }

    public ZTP_PREGUNTAS_RESULT(int idpregunta, boolean rcorrecta, boolean rfalsa1, boolean rfalsa2, boolean rfalsa3) {
        this.idpregunta = idpregunta;
        this.rcorrecta = rcorrecta;
        this.rfalsa1 = rfalsa1;
        this.rfalsa2 = rfalsa2;
        this.rfalsa3 = rfalsa3;
    }

    public ZTP_PREGUNTAS_RESULT() {
    }
    public void setIdpregunta(int idpregunta) {
        this.idpregunta = idpregunta;
    }
    public boolean isRcorrecta() {
        return rcorrecta;
    }
    public void setRcorrecta(boolean rcorrecta) {
        this.rcorrecta = rcorrecta;
    }
    public boolean isRfalsa1() {
        return rfalsa1;
    }
    public void setRfalsa1(boolean rfalsa1) {
        this.rfalsa1 = rfalsa1;
    }
    public boolean isRfalsa2() {
        return rfalsa2;
    }
    public void setRfalsa2(boolean rfalsa2) {
        this.rfalsa2 = rfalsa2;
    }
    public boolean isRfalsa3() {
        return rfalsa3;
    }
    public void setRfalsa3(boolean rfalsa3) {
        this.rfalsa3 = rfalsa3;
    }
}
