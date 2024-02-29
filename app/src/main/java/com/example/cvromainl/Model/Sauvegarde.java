package com.example.cvromainl.Model;


import java.io.Serializable;

public class Sauvegarde implements Serializable {

    private final Integer Numero;
    private final Integer Ouvert;


    public Sauvegarde(Integer Numero, Integer Ouvert) {

        this.Numero = Numero;
        this.Ouvert = Ouvert;



    }

    public Integer getNumero() {
        return Numero;
    }

    public Integer getOuvert() {
        return Ouvert;
    }

    public Integer getNumeroObjet() {
        return Numero;
    }

    public Integer getOuvertObjet() {
        return Ouvert;
    }

    public Integer getNumeroActions() {
        return Numero;
    }

    public Integer getOuvertActions() {
        return Ouvert;
    }






}
