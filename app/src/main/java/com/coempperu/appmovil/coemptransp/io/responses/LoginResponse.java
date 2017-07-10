package com.coempperu.appmovil.coemptransp.io.responses;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("empresa")
    private
    String id;

    @SerializedName("usuario")
    private String user;

    @SerializedName("TipoUsuario")
    private String userType;

    @SerializedName("RUC")
    private String ruc;

    @SerializedName("RazonSocial")
    private String company;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
