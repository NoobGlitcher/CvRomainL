package com.example.cvromainl.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cvromainl.outils.MySQLiteOpenHelper;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccesLocal {

    private String nomBase ="dbProfil.sqlite";
    private Integer versionBase = 3 ;
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase bd;

    public AccesLocal (Context context){
        accesBD = new MySQLiteOpenHelper(context, nomBase,null,versionBase);
    }

    public void ajout (Sauvegarde Chapitre){
        bd = accesBD.getWritableDatabase();
        String req = "insert into Chapitre (Numero,Ouvert) values";
        req += "("+Chapitre.getNumero()+","+Chapitre.getOuvert()+")";
        bd.execSQL(req);


    }

    public Sauvegarde recupDernier(){

        bd = accesBD.getReadableDatabase();
        Sauvegarde Chapitre =null;
        String req = "select * from Chapitre";
        Cursor curseur = bd.rawQuery(req, null);
        curseur.moveToLast();
        if (!curseur.isAfterLast()) {

            Integer Numero = curseur.getInt(0);
            Integer Ouvert  = curseur.getInt(1);


            Chapitre = new Sauvegarde (Numero,Ouvert);


        }

        curseur.close();
        return Chapitre;

    }


    public void ajoutObjet (Sauvegarde Objet){
        bd = accesBD.getWritableDatabase();
        String req2 = "insert into Objet (Numero,Ouvert) values";
        req2 += "("+Objet.getNumeroObjet()+","+Objet.getOuvertObjet()+")";
        bd.execSQL(req2);


    }

    public Sauvegarde recupDernierObjet(){

        bd = accesBD.getReadableDatabase();
        Sauvegarde Objet =null;
        String req2 = "select * from Objet";
        Cursor curseur = bd.rawQuery(req2, null);
        curseur.moveToLast();
        if (!curseur.isAfterLast()) {

            Integer Numero = curseur.getInt(0);
            Integer Ouvert  = curseur.getInt(1);


            Objet = new Sauvegarde (Numero,Ouvert);


        }

        curseur.close();
        return Objet;

    }


    public void ajoutActions (Sauvegarde Actions){
        bd = accesBD.getWritableDatabase();
        String req2 = "insert into Actions (Numero,Ouvert) values";
        req2 += "("+Actions.getNumeroActions()+","+Actions.getOuvertActions()+")";
        bd.execSQL(req2);


    }

    public Sauvegarde recupDernierActions(){

        bd = accesBD.getReadableDatabase();
        Sauvegarde Actions =null;
        String req2 = "select * from Actions";
        Cursor curseur = bd.rawQuery(req2, null);
        curseur.moveToLast();
        if (!curseur.isAfterLast()) {

            Integer Numero = curseur.getInt(0);
            Integer Ouvert  = curseur.getInt(1);


            Actions = new Sauvegarde (Numero,Ouvert);


        }

        curseur.close();
        return Actions;

    }

    public List<Sauvegarde> recupTousObjets(){

        bd = accesBD.getReadableDatabase();
        List<Sauvegarde> ListObjets = new ArrayList<>();

        String req2 = "SELECT * FROM Objet";
        Cursor curseur = bd.rawQuery(req2, null);
        try {
            while (curseur.moveToNext()) {
                Integer Numero = curseur.getInt(0);
                Integer Ouvert = curseur.getInt(1);
                Sauvegarde objets = new Sauvegarde(Numero, Ouvert);
                ListObjets.add(objets);
            }
        } finally {
            curseur.close();
        }
        return ListObjets;
    }


    public List<Sauvegarde> recupToutesActions(){

        bd = accesBD.getReadableDatabase();
        List<Sauvegarde> ListActions = new ArrayList<>();

        String req2 = "SELECT * FROM Actions";
        Cursor curseur = bd.rawQuery(req2, null);
        try {
            while (curseur.moveToNext()) {
                Integer Numero = curseur.getInt(0);
                Integer Ouvert = curseur.getInt(1);
                Sauvegarde action = new Sauvegarde(Numero, Ouvert);
                ListActions.add(action);
            }
        } finally {
            curseur.close();
        }
        return ListActions;
    }

}
