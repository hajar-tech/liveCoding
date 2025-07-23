package com.livecoding.livecodingdto.dto;

public class ProduitRequestDto {

    private String nom;
    private Long clientId;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
