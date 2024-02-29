package com.example.cvromainl.View;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cvromainl.Controle.Controle;
import com.example.cvromainl.R;

import java.util.ArrayList;
import java.util.List;

public class dataGame extends AppCompatActivity {

    private ImageView mImageBureauFerme;
    private ImageView mImageMiroir;
    private ImageView mImageStudio;
    private ImageView mFond;
    private ImageView mNext1;
    private ImageView mNext2;
    private ImageView mNext3;
    private ImageView mNext4;
    private ImageView mPrevious1;
    private ImageView mPrevious2;
    private ImageView mPrevious3;
    private ImageView mPrevious4 ;
    private ImageButton mitem1, mitem2, mitem3, mitem4, mitem5, mitem6, mitem7, mitem8, mitem9, mRetour, mPower, mCamera, mUSB;
    private Button mPC, mNews, mCoffre,mBureau, mMiroir, mStudio,mCadenas, mCoffreInterieur, mUSBInsertion;
    private RadioButton mrb1, mrb2, mrb3, mrb4, mrb5, mrb6, mrb7, mrb8, mrb9, mrb10, mrb11, mrb12, mrb13, mrb14, mrb15, mrb16, mrb17, mrb18;
    private RadioButton mrbUSB;
    private Integer iCoffre, iPC, icadenas, iPower, iNews, iCoffreInterieur, iCamera, iUSB, type;
    private TextView mNumber1, mNumber2, mNumber3, mNumber4;
    private Controle controle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_game);







            this.controle = Controle.getInstance(this);

            NewGame(1,3);


            mitem1 = findViewById(R.id.item19);
            mitem2 = findViewById(R.id.item20);
            mitem3 = findViewById(R.id.item21);
            mitem4 = findViewById(R.id.item22);
            mitem5 = findViewById(R.id.item23);
            mitem6 = findViewById(R.id.item24);
            mitem7 = findViewById(R.id.item25);
            mitem8 = findViewById(R.id.item26);
            mitem9 = findViewById(R.id.item27);

            mrb1 = findViewById(R.id.radioButton37);
            mrb2 = findViewById(R.id.radioButton38);
            mrb3 = findViewById(R.id.radioButton39);
            mrb4 = findViewById(R.id.radioButton40);
            mrb5 = findViewById(R.id.radioButton41);
            mrb6 = findViewById(R.id.radioButton42);
            mrb7 = findViewById(R.id.radioButton43);
            mrb8 = findViewById(R.id.radioButton44);
            mrb9 = findViewById(R.id.radioButton45);

            mrb10 = findViewById(R.id.radioButton46);
            mrb11 = findViewById(R.id.radioButton47);
            mrb12 = findViewById(R.id.radioButton48);
            mrb13 = findViewById(R.id.radioButton49);
            mrb14 = findViewById(R.id.radioButton50);
            mrb15 = findViewById(R.id.radioButton51);
            mrb16 = findViewById(R.id.radioButton52);
            mrb17 = findViewById(R.id.radioButton53);
            mrb18 = findViewById(R.id.radioButton54);

            mrbUSB = findViewById(R.id.radioButton55);


            iCoffre =0;
            iPC =0;
            icadenas=0;
            iPower =0;
            iNews=0;
            iCoffreInterieur=0;

            iCamera = 0;
            iUSB=0;

            mImageBureauFerme=findViewById(R.id.BureauFerme);
            mImageMiroir = findViewById(R.id.Miroir);
            mImageStudio = findViewById(R.id.Studio);
            mFond = findViewById(R.id.Fond);

            mImageStudio.setVisibility(View.INVISIBLE);
            mImageBureauFerme.setVisibility(View.INVISIBLE);
            mImageMiroir.setVisibility(View.INVISIBLE);

            mStudio= findViewById(R.id.StudioButton);
            mBureau = findViewById(R.id.BureauButton);
            mMiroir = findViewById(R.id.MiroirButton);

            mNews = findViewById(R.id.NewsButton);
            mPC = findViewById(R.id.PcButton);
            mCoffre = findViewById(R.id.CoffreButton);
            BureauProcheInvisible();

            mCadenas = findViewById(R.id.CadenasButton);
            mCadenas.setVisibility(View.INVISIBLE);

            mPrevious1 = findViewById(R.id.previous1);
            mPrevious2 = findViewById(R.id.previous2);
            mPrevious3 = findViewById(R.id.previous3);
            mPrevious4 = findViewById(R.id.previous4);

            mNext1 = findViewById(R.id.next1);
            mNext2 = findViewById(R.id.next2);
            mNext3 = findViewById(R.id.next3);
            mNext4 = findViewById(R.id.next4);

            mNumber1=findViewById(R.id.Number1);
            mNumber2=findViewById(R.id.Number2);
            mNumber3=findViewById(R.id.Number3);
            mNumber4=findViewById(R.id.Number4);

            mPower = findViewById(R.id.PowerButton);
            mPower.setVisibility(View.INVISIBLE);

            mCamera = findViewById(R.id.CameraButton);
            mUSB = findViewById(R.id.UsbButton);
            mCoffreInterieur = findViewById(R.id.CoffreInterieurButton);

            mCamera.setVisibility(View.INVISIBLE);
            mUSB.setVisibility(View.INVISIBLE);
            mCoffreInterieur.setVisibility(View.INVISIBLE);

            InvisibleCadena();

            mUSBInsertion = findViewById(R.id.UsbInsertion);
            mUSBInsertion.setVisibility(View.INVISIBLE);

            mRetour = findViewById(R.id.RetourButton);
            mRetour.setVisibility(View.INVISIBLE);

            mStudio.setOnClickListener(view -> {
                mRetour.setVisibility(View.VISIBLE);
                mImageStudio.setVisibility(View.VISIBLE);
                mFond.setVisibility(View.INVISIBLE);
                mMiroir.setVisibility(View.INVISIBLE);
                mStudio.setVisibility(View.INVISIBLE);
                mBureau.setVisibility(View.INVISIBLE);

            });
            mMiroir.setOnClickListener(view -> {
                mRetour.setVisibility(View.VISIBLE);
                mImageMiroir.setVisibility(View.VISIBLE);
                mFond.setVisibility(View.INVISIBLE);
                mMiroir.setVisibility(View.INVISIBLE);
                mStudio.setVisibility(View.INVISIBLE);
                mBureau.setVisibility(View.INVISIBLE);


            });

            mBureau.setOnClickListener(view -> {
                if (iPower ==1 ) {
                    BureauProche();

                    mImageBureauFerme.setImageResource(R.drawable.bureauprocheallume);
                }

                else {

                    BureauProche();

                }

            });

            mNews.setOnClickListener(view -> {

                BureauProcheInvisible();

            });

            mPC.setOnClickListener(view -> {

                iPC=1;

                if (mrbUSB.isSelected() && iPower==1) {

                    BureauProcheInvisible();
                    mImageBureauFerme.setImageResource(R.drawable.ordinateurusb);
                    mPower.setVisibility(View.VISIBLE);



                } else {

                    if(iPower==1){

                        BureauProcheInvisible();

                        mImageBureauFerme.setImageResource(R.drawable.ordinateurprocheallume);
                        mPower.setVisibility(View.VISIBLE);
                        mUSBInsertion.setVisibility(View.VISIBLE);

                    } else if (mrbUSB.isSelected()) {

                        BureauProcheInvisible();

                        mImageBureauFerme.setImageResource(R.drawable.ordinateurprocheeteindusb);
                        mPower.setVisibility(View.VISIBLE);

                    } else {
                        mImageBureauFerme.setImageResource(R.drawable.ordinateurprocheeteind);
                        mPower.setVisibility(View.VISIBLE);
                    }
                }

            });

            mPower.setOnClickListener(view -> {

                if (iPower == 0 && mrbUSB.isSelected()) {

                    mImageBureauFerme.setImageResource(R.drawable.ordinateurusb);
                    iPower = 1;

                }else if (iPower==0 && !mrbUSB.isSelected()) {
                    mImageBureauFerme.setImageResource(R.drawable.ordinateurprocheallume);
                    iPower = 1;
                    mUSBInsertion.setVisibility(View.VISIBLE);

                }else {
                    if (mrbUSB.isSelected()){
                        mImageBureauFerme.setImageResource(R.drawable.ordinateurprocheeteindusb);
                        iPower=0;

                    } else {

                        mImageBureauFerme.setImageResource(R.drawable.ordinateurprocheeteind);
                        iPower=0;}
                }

            });

            mCoffre.setOnClickListener(view -> {

                if (icadenas ==2) {

                    BureauProcheInvisible();
                    mCadenas.setVisibility(View.INVISIBLE);
                    mCoffreInterieur.setVisibility(View.VISIBLE);

                    mImageBureauFerme.setImageResource(R.drawable.coffreprocheouvert);

                    iCoffre =1;

                }
                else {

                    BureauProcheInvisible();
                    mCadenas.setVisibility(View.VISIBLE);

                    mImageBureauFerme.setImageResource(R.drawable.coffreproche);
                    iCoffre =1;

                }

            });

            mCadenas.setOnClickListener(view -> {

                mCadenas.setVisibility(View.INVISIBLE);
                mImageBureauFerme.setImageResource(R.drawable.cadenasproche);

                mNumber1.setVisibility(View.VISIBLE);
                mNumber2.setVisibility(View.VISIBLE);
                mNumber3.setVisibility(View.VISIBLE);
                mNumber4.setVisibility(View.VISIBLE);

                mNext1.setVisibility(View.VISIBLE);
                mNext2.setVisibility(View.VISIBLE);
                mNext3.setVisibility(View.VISIBLE);
                mNext4.setVisibility(View.VISIBLE);

                mPrevious1.setVisibility(View.VISIBLE);
                mPrevious2.setVisibility(View.VISIBLE);
                mPrevious3.setVisibility(View.VISIBLE);
                mPrevious4.setVisibility(View.VISIBLE);

                icadenas=1;
                iCoffre=0;

            });

            mCoffreInterieur.setOnClickListener(view -> {

                mImageBureauFerme.setImageResource(R.drawable.coffrefond);
                mCamera.setVisibility(View.VISIBLE);
                mUSB.setVisibility(View.VISIBLE);
                mCoffreInterieur.setVisibility(View.INVISIBLE);

                iCoffre=0;
                iCoffreInterieur =1;


            });

            // CADENAS ---------------------------------------------------------------------

            mNext1.setOnClickListener(view -> {

                int iN1 = Integer.parseInt(mNumber1.getText().toString());

                if (iN1 == 9) {

                    mNumber1.setText("0");

                } else {

                    int i2N1 = iN1 +1;
                    String sN1 = Integer.toString(i2N1);
                    mNumber1.setText(sN1);
                    Combinaison();

                }

            });

            mNext2.setOnClickListener(view -> {

                int iN2 = Integer.parseInt(mNumber2.getText().toString());

                if (iN2 == 9) {

                    mNumber2.setText("0");

                } else {

                    int i2N2 = iN2 +1;
                    String sN2 = Integer.toString(i2N2);
                    mNumber2.setText(sN2);
                    Combinaison();

                }

            });
            mNext3.setOnClickListener(view -> {

                int iN3 = Integer.parseInt(mNumber3.getText().toString());


                if (iN3 == 9) {

                    mNumber3.setText("0");

                } else {

                    int i2N3 = iN3 +1;
                    String sN3 = Integer.toString(i2N3);
                    mNumber3.setText(sN3);
                    Combinaison();

                }

            });

            mNext4.setOnClickListener(view -> {

                int iN4 = Integer.parseInt(mNumber4.getText().toString());


                if (iN4 == 9) {

                    mNumber4.setText("0");

                } else {

                    int i2N4 = iN4 +1;
                    String sN4 = Integer.toString(i2N4);
                    mNumber4.setText(sN4);
                    Combinaison();

                }

            });
            mPrevious1.setOnClickListener(view -> {

                int iN4 = Integer.parseInt(mNumber1.getText().toString());


                if (iN4 == 0) {

                    mNumber1.setText("9");

                } else {

                    int i2N4 = iN4 -1;
                    String sN4 = Integer.toString(i2N4);
                    mNumber1.setText(sN4);
                    Combinaison();

                }

            });

            mPrevious2.setOnClickListener(view -> {

                int iN2 = Integer.parseInt(mNumber2.getText().toString());


                if (iN2 == 0) {

                    mNumber2.setText("9");
                    Combinaison();


                } else {

                    int i2N2 = iN2 -1;
                    String sN2 = Integer.toString(i2N2);
                    mNumber2.setText(sN2);
                }

            });
            mPrevious3.setOnClickListener(view -> {

                int iN3 = Integer.parseInt(mNumber3.getText().toString());

                if (iN3 == 0) {

                    mNumber3.setText("9");
                    Combinaison();

                } else {

                    int i2N3 = iN3 -1;
                    String sN3 = Integer.toString(i2N3);
                    mNumber3.setText(sN3);
                }

            });

            mPrevious4.setOnClickListener(view -> {

                int iN4 = Integer.parseInt(mNumber4.getText().toString());

                if (iN4 == 0) {

                    mNumber4.setText("9");

                } else {

                    int i2N4 = iN4 -1;
                    String sN4 = Integer.toString(i2N4);
                    mNumber4.setText(sN4);
                    Combinaison();

                }

            });

            mRetour.setOnClickListener(view -> {

                if (iCoffre == 1 | iPC ==1 | iNews ==1){

                    if (iPC == 1) {

                        if (iPower == 1) {

                            if (mrbUSB.isSelected()) {

                                BureauProcheVisible();

                                mPower.setVisibility(View.INVISIBLE);

                                mImageBureauFerme.setImageResource(R.drawable.bureauprocheallumeusb);
                                iPC =0;

                            } else {
                                BureauProcheVisible();

                                mPower.setVisibility(View.INVISIBLE);

                                mImageBureauFerme.setImageResource(R.drawable.bureauprocheallume);
                                iPC =0;


                            } } else {

                            if (mrbUSB.isSelected()) {
                                BureauProcheVisible();

                                mPower.setVisibility(View.INVISIBLE);

                                mImageBureauFerme.setImageResource(R.drawable.bureauprocheeteindusb);
                                iPC =0;
                            } else {

                                BureauProcheVisible();

                                mPower.setVisibility(View.INVISIBLE);

                                mImageBureauFerme.setImageResource(R.drawable.bureauprocheeteind);
                                iPC =0;

                            }}

                    } else if (iCoffre == 1) {

                        if (iPower == 1) {

                            if (mrbUSB.isSelected()) {

                                BureauProcheVisible();

                                InvisibleCadena();
                                mImageBureauFerme.setImageResource(R.drawable.bureauprocheallumeusb);
                                iCoffre =0;

                            } else {
                                BureauProcheVisible();

                                InvisibleCadena();
                                mImageBureauFerme.setImageResource(R.drawable.bureauprocheallume);
                                iCoffre =0;


                            } } else {

                            if (mrbUSB.isSelected()) {
                                BureauProcheVisible();
                                InvisibleCadena();

                                mImageBureauFerme.setImageResource(R.drawable.bureauprocheeteindusb);
                                iCoffre =0;
                            } else {

                                BureauProcheVisible();
                                InvisibleCadena();
                                mImageBureauFerme.setImageResource(R.drawable.bureauprocheeteind);
                                iCoffre =0;

                            }}

                    }  else if (iNews == 1) {

                        if (iPower==1){
                            BureauProcheVisible();
                            mImageBureauFerme.setImageResource(R.drawable.bureauprocheallume);

                            iNews =0;
                        }else {
                            BureauProcheVisible();
                            mImageBureauFerme.setImageResource(R.drawable.bureauprocheeteind);

                            iNews =0;
                        }

                    }

                } else if (icadenas==1){

                    mCadenas.setVisibility(View.VISIBLE);

                    InvisibleCadena();

                    mImageBureauFerme.setImageResource(R.drawable.coffreproche);
                    iCoffre =1;
                    icadenas=0;

                }  else if (iCoffreInterieur==1) {

                    mImageBureauFerme.setImageResource(R.drawable.coffreprocheouvert);
                    iCoffre =1;
                    mCoffreInterieur.setVisibility(View.VISIBLE);
                    iCoffreInterieur=0;
                    mCamera.setVisibility(View.INVISIBLE);
                    mUSB.setVisibility(View.INVISIBLE);

                } else {

                    mRetour.setVisibility(View.INVISIBLE);
                    mImageStudio.setVisibility(View.INVISIBLE);
                    mImageBureauFerme.setVisibility(View.INVISIBLE);
                    mImageMiroir.setVisibility(View.INVISIBLE);
                    mFond.setVisibility(View.VISIBLE);

                    BureauProcheInvisible();

                    mMiroir.setVisibility(View.VISIBLE);
                    mStudio.setVisibility(View.VISIBLE);
                    mBureau.setVisibility(View.VISIBLE);



                    mCadenas.setVisibility(View.INVISIBLE);}
            });

            // OBJETS Selection-------------------------------------------------------------


            mCamera.setOnClickListener(view -> {

                CameraSelection();
                SauvegardeObjet(1, 1);

            });
            mUSB.setOnClickListener(view -> {

                USBSelection();
                SauvegardeObjet(2, 1);

            });


            // ACTION--------------------------------------------------------------------



            mUSBInsertion.setOnClickListener(view -> {

                int Save = 1;

                ChargementUSB(Save);

            });




            // OUTILS CAPTEURS -----------------------------------------------------

            List<View> items = new ArrayList<>();
            items.add(mitem1);
            items.add(mitem2);
            items.add(mitem3);
            items.add(mitem4);
            items.add(mitem5);
            items.add(mitem6);
            items.add(mitem7);
            items.add(mitem8);
            items.add(mitem9);
            List<RadioButton> radioButtons = new ArrayList<>();
            radioButtons.add(mrb10);
            radioButtons.add(mrb11);
            radioButtons.add(mrb12);
            radioButtons.add(mrb13);
            radioButtons.add(mrb14);
            radioButtons.add(mrb15);
            radioButtons.add(mrb16);
            radioButtons.add(mrb17);
            radioButtons.add(mrb18);

            for (int i = 0; i < items.size(); i++) {
                final int index = i;
                items.get(i).setOnClickListener(view -> {
                    for (int j = 0; j < radioButtons.size(); j++) {
                        if (j == index) {
                            radioButtons.get(j).setSelected(true);
                            GradientDrawable border = new GradientDrawable();
                            border.setStroke(4, Color.RED);
                            border.setCornerRadius(15);
                            items.get(j).setBackground(border);
                        } else {
                            radioButtons.get(j).setSelected(false);
                            GradientDrawable border = new GradientDrawable();
                            border.setStroke(2, Color.BLACK);
                            border.setCornerRadius(15);
                            items.get(j).setBackground(border);
                        }
                    }
                });
            }



        }

        public void mitemvierge1() {
            mitem1.setImageResource(R.drawable.fondvierge);
            mrb1.setSelected(false);
        }

        public void mitemvierge2() {
            mitem2.setImageResource(R.drawable.fondvierge);
            mrb2.setSelected(false);
        }

        public void mitemvierge3() {

            mitem3.setImageResource(R.drawable.fondvierge);
            mrb3.setSelected(false);
        }

        public void mitemvierge4() {
            mitem4.setImageResource(R.drawable.fondvierge);
            mrb4.setSelected(false);
        }

        public void mitemvierge5() {
            mitem5.setImageResource(R.drawable.fondvierge);
            mrb5.setSelected(false);
        }

        public void mitemvierge6() {
            mitem6.setImageResource(R.drawable.fondvierge);
            mrb6.setSelected(false);
        }

        public void mitemvierge7() {
            mitem7.setImageResource(R.drawable.fondvierge);
            mrb7.setSelected(false);
        }

        public void mitemvierge8() {
            mitem8.setImageResource(R.drawable.fondvierge);
            mrb8.setSelected(false);
        }

        public void mitemvierge9() {
            mitem9.setImageResource(R.drawable.fondvierge);
            mrb9.setSelected(false);
        }
        private void InvisibleCadena() {

            mNumber1.setVisibility(View.INVISIBLE);
            mNumber2.setVisibility(View.INVISIBLE);
            mNumber3.setVisibility(View.INVISIBLE);
            mNumber4.setVisibility(View.INVISIBLE);

            mNext1.setVisibility(View.INVISIBLE);
            mNext2.setVisibility(View.INVISIBLE);
            mNext3.setVisibility(View.INVISIBLE);
            mNext4.setVisibility(View.INVISIBLE);

            mPrevious1.setVisibility(View.INVISIBLE);
            mPrevious2.setVisibility(View.INVISIBLE);
            mPrevious3.setVisibility(View.INVISIBLE);
            mPrevious4.setVisibility(View.INVISIBLE);

        }
        private void Combinaison () {

            int iN1 = Integer.parseInt(mNumber1.getText().toString());
            int iN2 = Integer.parseInt(mNumber2.getText().toString());
            int iN3 = Integer.parseInt(mNumber3.getText().toString());
            int iN4 = Integer.parseInt(mNumber4.getText().toString());

            if (iN1==1 && iN2==9 && iN3==9 &&iN4==4) {

                mImageBureauFerme.setImageResource(R.drawable.coffreprocheouvert);
                InvisibleCadena();
                iCoffre = 1;
                icadenas =2 ;
                mCoffreInterieur.setVisibility(View.VISIBLE);

                SauvegardeActions(6,1);

            }

        }
        private void BureauProche () {
            mRetour.setVisibility(View.VISIBLE);
            mImageBureauFerme.setVisibility(View.VISIBLE);
            mFond.setVisibility(View.INVISIBLE);
            mMiroir.setVisibility(View.INVISIBLE);
            mStudio.setVisibility(View.INVISIBLE);
            mBureau.setVisibility(View.INVISIBLE);
            BureauProcheVisible();

        }
        private void BureauProcheInvisible () {
            mCoffre.setVisibility(View.INVISIBLE);
            mPC.setVisibility(View.INVISIBLE);
            mNews.setVisibility(View.INVISIBLE);

        }
        private void BureauProcheVisible () {

            mCoffre.setVisibility(View.VISIBLE);
            mPC.setVisibility(View.VISIBLE);
            mNews.setVisibility(View.VISIBLE);
            mCoffreInterieur.setVisibility(View.INVISIBLE);


        }
// STATUTS -------------------------------------------------------------

        @SuppressLint("NonConstantResourceId")
        private void StatutInventaire(RadioButton radioButton) {

            //changement du statut des autres boutons non selectiones de l'inventaire

            switch (radioButton.getId()) {
                case R.id.radioButton46:
                    mitemvierge1();
                    break;
                case R.id.radioButton47:
                    mitemvierge2();
                    break;
                case R.id.radioButton48:
                    mitemvierge3();
                    break;
                case R.id.radioButton49:
                    mitemvierge4();
                    break;
                case R.id.radioButton50:
                    mitemvierge5();
                    break;
                case R.id.radioButton51:
                    mitemvierge6();
                    break;
                case R.id.radioButton52:
                    mitemvierge7();
                    break;
                case R.id.radioButton53:
                    mitemvierge8();
                    break;
                case R.id.radioButton54:
                    mitemvierge9();
                    break;
            }

            new Handler().postDelayed(() -> {

            }, 1000);

        }

        // OUTILS SAUVEGARDE ------------------------------------------------


        // 1........ SAUVEGARDE  ----------------------------------------------------------------------


        private void NewGame(Integer Numero, Integer Ouvert) {

            this.controle.creerProfil(Numero, Ouvert, this);

        }

        private void SauvegardeObjet(Integer Numero, Integer Ouvert) {

            this.controle.creerObjet(Numero, Ouvert, this);

        }

        private void SauvegardeActions(Integer Numero, Integer Ouvert) {

            this.controle.creerActions(Numero, Ouvert, this);


        }

        //2....CHARGEMENT SAUVEGARDE-----------------------------------------------





        // OBJETS SELECTIONS ------------------------------------------------------


        private void CameraSelection() {

            mCamera.setVisibility(View.INVISIBLE);
            RadioButton[] radioButtons = {mrb1, mrb2, mrb3, mrb4, mrb5, mrb6, mrb7, mrb8, mrb9};
            for (int i = 0; i < radioButtons.length; i++) {
                if (!radioButtons[i].isSelected()) {
                    ImageView[] imageViews = {mitem1, mitem2, mitem3, mitem4, mitem5, mitem6, mitem7, mitem8, mitem9};
                    imageViews[i].setImageResource(R.drawable.camera);
                    mCamera.setImageResource(R.drawable.fondvierge);
                    radioButtons[i].setSelected(true);
                    iCamera = i + 1;
                    break;

                }
            }

        }

        private void USBSelection() {

            mUSB.setVisibility(View.INVISIBLE);
            RadioButton[] radioButtons = {mrb1, mrb2, mrb3, mrb4, mrb5, mrb6, mrb7, mrb8, mrb9};
            for (int i = 0; i < radioButtons.length; i++) {
                if (!radioButtons[i].isSelected()) {
                    ImageView[] imageViews = {mitem1, mitem2, mitem3, mitem4, mitem5, mitem6, mitem7, mitem8, mitem9};
                    imageViews[i].setImageResource(R.drawable.usb);
                    mUSB.setImageResource(R.drawable.fondvierge);
                    radioButtons[i].setSelected(true);
                    iUSB = i + 1;
                    break;

                }
            }

        }

        private void ChargementUSB(int Save) {

            if (!mrbUSB.isSelected()) {


                if (mrb10.isSelected() && !mrbUSB.isSelected()) {
                    USBInsertion(mrb10, 1,Save);
                } else if (mrb11.isSelected() && !mrbUSB.isSelected()) {
                    USBInsertion(mrb11, 2,Save);
                } else if (mrb12.isSelected() && !mrbUSB.isSelected()) {
                    USBInsertion(mrb12, 3,Save);
                } else if (mrb13.isSelected() && !mrbUSB.isSelected()) {
                    USBInsertion(mrb13, 4,Save);
                } else if (mrb14.isSelected() && !mrbUSB.isSelected()) {
                    USBInsertion(mrb14, 5,Save);
                } else if (mrb15.isSelected() && !mrbUSB.isSelected()) {
                    USBInsertion(mrb15, 6,Save);
                } else if (mrb16.isSelected() && !mrbUSB.isSelected()) {
                    USBInsertion(mrb16, 7,Save);
                } else if (mrb17.isSelected() && !mrbUSB.isSelected()) {
                    USBInsertion(mrb17, 8,Save);
                } else if (mrb18.isSelected() && !mrbUSB.isSelected()) {
                    USBInsertion(mrb18, 9,Save);
                }
            }

        }

        private void USBInsertion(RadioButton radioButton, int activityNumber, int Save) {
            if (iUSB == activityNumber) {

                if (Save ==1 ) {
                    mImageBureauFerme.setImageResource(R.drawable.ordinateurusb);
                    mrbUSB.setSelected(true);

                    StatutInventaire(radioButton);
                    SauvegardeActions(3, 1);

                    mUSBInsertion.setVisibility(View.INVISIBLE);

                } else {
                    mImageBureauFerme.setImageResource(R.drawable.ordinateurusb);
                    mrbUSB.setSelected(true);

                    StatutInventaire(radioButton);

                    mUSBInsertion.setVisibility(View.INVISIBLE);
                }






            }
        }

        private void PCusb (int type) {

            if (type ==1){

                if (iPower == 1) {

                    if (mrbUSB.isSelected()) {

                        BureauProcheVisible();

                        mPower.setVisibility(View.INVISIBLE);

                        mImageBureauFerme.setImageResource(R.drawable.bureauprocheallumeusb);
                        iPC =0;

                    } else {
                        BureauProcheVisible();

                        mPower.setVisibility(View.INVISIBLE);

                        mImageBureauFerme.setImageResource(R.drawable.bureauprocheallume);
                        iPC =0;


                    } } else {

                    if (mrbUSB.isSelected()) {
                        BureauProcheVisible();

                        mPower.setVisibility(View.INVISIBLE);

                        mImageBureauFerme.setImageResource(R.drawable.bureauprocheeteindusb);
                        iPC =0;
                    } else {

                        BureauProcheVisible();

                        mPower.setVisibility(View.INVISIBLE);

                        mImageBureauFerme.setImageResource(R.drawable.bureauprocheeteind);
                        iPC =0;

                    }}

            }}


    }
