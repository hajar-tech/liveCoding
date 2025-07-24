package com.livecoding.livecodingdto.dto;

public class RequestProduct {

    private String nom;

    private Long idClient;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }
}
