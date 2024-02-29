package com.example.cvromainl.Controle;

import android.content.Context;

import com.example.cvromainl.Model.AccesLocal;
import com.example.cvromainl.Model.Sauvegarde;

import java.util.List;

public final class Controle {


    private static Controle instance = null;
    private static Sauvegarde Chapitre, Objet, Actions;
    private static AccesLocal accesLocal;

    private static List<Sauvegarde> ListObjets;

    private static List<Sauvegarde> ListActions;




    private Controle () { super(); }

    /**
     * creation dínstance
     * @param context
     * @return instance
     */

    public static final Controle getInstance(Context context) {

        if (Controle.instance == null) {
            Controle.instance = new Controle();

            accesLocal = new AccesLocal(context);
            Chapitre = accesLocal.recupDernier();
            Objet = accesLocal.recupDernierObjet();
            Actions = accesLocal.recupDernierActions();
            ListObjets = accesLocal.recupTousObjets();
            ListActions = accesLocal.recupToutesActions();




        }
        return Controle.instance;
    }


    /**
     * Creation du profil
     * @param Numero
     * @param Ouvert
     */

    public void creerProfil(  Integer Numero, Integer Ouvert, Context context) {
        Chapitre = new Sauvegarde(Numero, Ouvert);

        accesLocal.ajout(Chapitre);



    }

    public void creerObjet (Integer Numero, Integer Ouvert, Context context) {

        Objet = new Sauvegarde(Numero, Ouvert);
        accesLocal.ajoutObjet(Objet);



    }

    public void creerActions (Integer Numero, Integer Ouvert, Context context) {

        Actions = new Sauvegarde(Numero, Ouvert);
        accesLocal.ajoutActions(Actions);



    }

    public Integer getNumero(){
        if (Chapitre==null){
            return null;
        }
        else {
            return  Chapitre.getNumero();

        }

    }

    public Integer getOuvert(){
        if (Chapitre==null){
            return null;
        }
        else {
            return  Chapitre.getOuvert();

        }

    }

    public Integer getNumeroObjet(){
        if (Objet==null){
            return null;
        }
        else {
            return  Objet.getNumeroObjet();

        }

    }

    public Integer getOuvertObjet(){
        if (Objet==null){
            return null;
        }
        else {
            return  Objet.getOuvertObjet();

        }

    }


    public Integer getNumeroActions(){
        if (Actions==null){
            return null;
        }
        else {
            return  Actions.getNumeroActions();

        }

    }

    public Integer getOuvertActions(){
        if (Actions==null){
            return null;
        }
        else {
            return  Actions.getOuvertActions();

        }

    }
    public List getListObjets(){
        if (ListObjets==null){
            return null;
        }
        else {
            return  ListObjets;

        }

    }

    public List getListActions(){
        if (ListActions==null){
            return null;
        }
        else {
            return  ListActions;

        }

    }



}
