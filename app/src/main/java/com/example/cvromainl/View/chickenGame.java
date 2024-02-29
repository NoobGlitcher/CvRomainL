package com.example.cvromainl.View;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cvromainl.Controle.Controle;
import com.example.cvromainl.R;

import java.util.ArrayList;
import java.util.List;

public class chickenGame extends AppCompatActivity {


        private ImageView mCuisine, mSang;
        private ImageButton mitem1, mitem2, mitem3, mitem4, mitem5, mitem6, mitem7, mitem8, mitem9, mPouletVivant, mCouteau, mAllumettes, mBois, mRetour;
        private RadioButton mrb1, mrb2, mrb3, mrb4, mrb5, mrb6, mrb7, mrb8, mrb9, mrb10, mrb11, mrb12, mrb13, mrb14, mrb15, mrb16, mrb17, mrb18;
        private RadioButton mrbCru, mrbBois, mrbAlummettes, mrbFourOuvert, mrbCuit, mrbCouteau, mrbDecoupe, mrbburger;
        private Integer ipouletcru, ipouletcuit, iburger, iallumettes, icouteau, ibois, icouteau2, idecoupe, ifeu;

        private Handler handler2, handler3;
        private MediaPlayer mediaPlayer2;
        private Runnable stopPlayerRunnable;
        private Button mCuisineProche, mFour;

        private Controle controle;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

            setContentView(R.layout.activity_chicken_game);

            this.controle = Controle.getInstance(this);



            // DECLARATION DES OBJETS ANDROID -----------------------------------------------


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

            mrbCru = findViewById(R.id.radioButton55);
            mrbBois = findViewById(R.id.radioButton56);
            mrbAlummettes = findViewById(R.id.radioButton57);
            mrbFourOuvert = findViewById(R.id.radioButton58);
            mrbCuit = findViewById(R.id.radioButton59);
            mrbCouteau = findViewById(R.id.radioButton60);
            mrbDecoupe = findViewById(R.id.radioButton61);
            mrbburger = findViewById(R.id.radioButton62);

            icouteau = 0;
            icouteau2 = 0;
            ipouletcru = 0;
            idecoupe = 0;
            ipouletcuit = 0;
            iallumettes = 0;
            iburger = 0;
            ifeu = 0;
            ibois = 0;

            mediaPlayer2 = MediaPlayer.create(this, R.raw.inventaire);

            mCuisine = findViewById(R.id.Cuisine);
            mCuisineProche = findViewById(R.id.CuisineProche);
            mPouletVivant = findViewById(R.id.PouletVivant);

            mSang = findViewById(R.id.Sang);
            mSang.setVisibility(View.INVISIBLE);

            mCouteau = findViewById(R.id.Couteau);
            mAllumettes = findViewById(R.id.Allumettes);
            mBois = findViewById(R.id.Bois);

            mRetour = findViewById(R.id.ButtonRetour);
            mRetour.setVisibility(View.INVISIBLE);

            mFour = findViewById(R.id.ButtonFourOuvert);
            mFour.setVisibility(View.INVISIBLE);





            // ACTIONS ENVIRONNEMENT ------------------------------------------------------------

            mCuisineProche.setOnClickListener(view -> {

                mCuisine.setImageResource(R.drawable.cuisineproche);
                mRetour.setVisibility(View.VISIBLE);
                mFour.setVisibility(View.VISIBLE);
                mCouteau.getVisibility();
                mCouteau.setVisibility(View.INVISIBLE);
                mAllumettes.setVisibility(View.INVISIBLE);
                mBois.setVisibility(View.INVISIBLE);
                mPouletVivant.setVisibility(View.INVISIBLE);
                mCuisineProche.setVisibility(View.INVISIBLE);
                mSang.setVisibility(View.INVISIBLE);
            });
            mRetour.setOnClickListener(view -> {
                mCuisine.setImageResource(R.drawable.cuisine);
                mRetour.setVisibility(View.INVISIBLE);
                mFour.setVisibility(View.INVISIBLE);
                mCouteau.setVisibility(View.VISIBLE);
                mAllumettes.setVisibility(View.VISIBLE);
                mBois.setVisibility(View.VISIBLE);
                mPouletVivant.setVisibility(View.VISIBLE);
                mCuisineProche.setVisibility(View.VISIBLE);
                if (mrbCru.isSelected()) {
                    mSang.setVisibility(View.VISIBLE);
                }
            });


            // ACTIONS OBJETS environnement ------------------------------------------------------------

            mFour.setOnClickListener(view -> {

                int Save = 1;

                FourActions(Save);


            });

            mPouletVivant.setOnClickListener(view -> {

                int Save = 1;


                PouletActions(Save);

            });


            // OBJETS SELECTION ------------------------------------------------------


            mCouteau.setOnClickListener(view -> {
                CouteauSelection();
                inventaire();

            });
            mAllumettes.setOnClickListener(view -> {
                AllumettesSelection();
                inventaire();


            });
            mBois.setOnClickListener(view -> {
                BoisSelection();
                inventaire();
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


        // OBJETS MODIFIES --------------------------------------------------

        private void pouletDecoupe(int Save) {

            if (Save == 1) {
                PouletSelection();
                inventaire();


            } else {
                PouletSelection();
            }

        }


        @SuppressLint("NonConstantResourceId")
        private void PouletTue(RadioButton radioButton, int activityNumber, int Save) {
            if (icouteau == activityNumber) {

                if (Save == 1) {
                    mPouletVivant.setImageResource(R.drawable.poulercru);
                    mrbCru.setSelected(true);
                    mrbCouteau.setSelected(true);
                    mSang.setVisibility(View.VISIBLE);

                    StatutInventaire(radioButton);

                    CouteauSelection2();
                    inventaire();




                } else {
                    mPouletVivant.setImageResource(R.drawable.poulercru);
                    mrbCru.setSelected(true);
                    mrbCouteau.setSelected(true);
                    mSang.setVisibility(View.VISIBLE);

                    StatutInventaire(radioButton);

                    CouteauSelection2();

                }


            }
        }

        @SuppressLint("NonConstantResourceId")
        private void pouletCru(RadioButton radioButton, int activityNumber, int Save) {

            if (icouteau2 == activityNumber) {

                if (Save == 1) {

                    mPouletVivant.setImageResource(R.drawable.pouletdecoupe);
                    mrbDecoupe.setSelected(true);

                    StatutInventaire(radioButton);



                } else {

                    mPouletVivant.setImageResource(R.drawable.pouletdecoupe);
                    mrbDecoupe.setSelected(true);

                    StatutInventaire(radioButton);


                }


            }
        }

        @SuppressLint("NonConstantResourceId")
        private void Bois(RadioButton radioButton, int activityNumber, int Save) {


            if (ibois == activityNumber) {

                if (Save == 1) {

                    mCuisine.setImageResource(R.drawable.cuisineprochebois);
                    mrbBois.setSelected(true);

                    StatutInventaire(radioButton);



                }else {
                    mCuisine.setImageResource(R.drawable.cuisineprochebois);
                    mrbBois.setSelected(true);

                    StatutInventaire(radioButton);
                }


            } else {

                FourFerme();

            }


        }

        @SuppressLint("NonConstantResourceId")
        private void Feu(RadioButton radioButton, int activityNumber, int Save) {


            if (iallumettes == activityNumber) {

                if (Save == 1) {
                    mCuisine.setImageResource(R.drawable.cuisineprochefeu);
                    mrbAlummettes.setSelected(true);

                    StatutInventaire(radioButton);



                }else {
                    mCuisine.setImageResource(R.drawable.cuisineprochefeu);
                    mrbAlummettes.setSelected(true);

                    StatutInventaire(radioButton);
                }

            } else {

                FourFerme();

            }
        }

        private void PouletCuit(RadioButton radioButton, int activityNumber, int Save) {
            if (idecoupe == activityNumber) {

                if (Save == 1) {

                    mCuisine.setImageResource(R.drawable.cuisineproche);
                    mrbCuit.setSelected(true);
                    mrbFourOuvert.setSelected(false);

                    StatutInventaire(radioButton);



                }else {
                    mCuisine.setImageResource(R.drawable.cuisineproche);
                    mrbCuit.setSelected(true);
                    mrbFourOuvert.setSelected(false);

                    StatutInventaire(radioButton);
                }


            } else {

                FourFerme();

            }
        }


        // SON ----------------------------------------------------------------


        private void inventaire() {

            mediaPlayer2.start();
            handler3 = new Handler();
            stopPlayerRunnable = () -> {
                if (mediaPlayer2.isPlaying()) {
                    mediaPlayer2.stop();
                }
            };
            handler3.postDelayed(stopPlayerRunnable, 8000);
        }


        // OBJETS SELECTIONS ------------------------------------------------------


        private void CouteauSelection() {

            mCouteau.setVisibility(View.INVISIBLE);
            RadioButton[] radioButtons = {mrb1, mrb2, mrb3, mrb4, mrb5, mrb6, mrb7, mrb8, mrb9};
            for (int i = 0; i < radioButtons.length; i++) {
                if (!radioButtons[i].isSelected()) {
                    ImageView[] imageViews = {mitem1, mitem2, mitem3, mitem4, mitem5, mitem6, mitem7, mitem8, mitem9};
                    imageViews[i].setImageResource(R.drawable.couteau);
                    mCouteau.setImageResource(R.drawable.fondvierge);
                    radioButtons[i].setSelected(true);
                    icouteau = i + 1;
                    break;

                }
            }

        }

        private void BoisSelection() {

            mBois.setVisibility(View.INVISIBLE);
            RadioButton[] radioButtons = {mrb1, mrb2, mrb3, mrb4, mrb5, mrb6, mrb7, mrb8, mrb9};
            for (int i = 0; i < radioButtons.length; i++) {
                if (!radioButtons[i].isSelected()) {
                    ImageView[] imageViews = {mitem1, mitem2, mitem3, mitem4, mitem5, mitem6, mitem7, mitem8, mitem9};
                    imageViews[i].setImageResource(R.drawable.bois);
                    mBois.setImageResource(R.drawable.fondvierge);
                    radioButtons[i].setSelected(true);
                    ibois = i + 1;
                    break;
                }
            }

        }


        private void AllumettesSelection() {

            mAllumettes.setVisibility(View.INVISIBLE);
            RadioButton[] radioButtons = {mrb1, mrb2, mrb3, mrb4, mrb5, mrb6, mrb7, mrb8, mrb9};
            for (int i = 0; i < radioButtons.length; i++) {
                if (!radioButtons[i].isSelected()) {
                    ImageView[] imageViews = {mitem1, mitem2, mitem3, mitem4, mitem5, mitem6, mitem7, mitem8, mitem9};
                    imageViews[i].setImageResource(R.drawable.allemettes);
                    mAllumettes.setImageResource(R.drawable.fondvierge);
                    radioButtons[i].setSelected(true);
                    iallumettes = i + 1;
                    break;
                }
            }

        }

        private void PouletSelection() {

            mPouletVivant.setVisibility(View.INVISIBLE);
            RadioButton[] radioButtons = {mrb1, mrb2, mrb3, mrb4, mrb5, mrb6, mrb7, mrb8, mrb9};
            for (
                    int i = 0;
                    i < radioButtons.length; i++) {
                if (!radioButtons[i].isSelected()) {
                    ImageView[] imageViews = {mitem1, mitem2, mitem3, mitem4, mitem5, mitem6, mitem7, mitem8, mitem9};
                    imageViews[i].setImageResource(R.drawable.pouletdecoupe);
                    mPouletVivant.setImageResource(R.drawable.fondvierge);
                    radioButtons[i].setSelected(true);
                    idecoupe = i + 1;
                    break;
                }
            }

        }

        private void CouteauSelection2() {


            RadioButton[] radioButtons = {mrb1, mrb2, mrb3, mrb4, mrb5, mrb6, mrb7, mrb8, mrb9};
            for (int i = 0; i < radioButtons.length; i++) {
                if (!radioButtons[i].isSelected()) {
                    ImageView[] imageViews = {mitem1, mitem2, mitem3, mitem4, mitem5, mitem6, mitem7, mitem8, mitem9};
                    imageViews[i].setImageResource(R.drawable.couteau);
                    radioButtons[i].setSelected(true);
                    icouteau2 = i + 1;
                    break;
                }
            }
        }




        private void PourletCuitSelection() {

            mCuisine.setImageResource(R.drawable.cuisineprocheouverte);
            mrbFourOuvert.setSelected(true);
            mrbCuit.setSelected(false);
            mrbburger.setSelected(true);
            RadioButton[] radioButtons = {mrb1, mrb2, mrb3, mrb4, mrb5, mrb6, mrb7, mrb8, mrb9};
            for (int i = 0; i < radioButtons.length; i++) {
                if (!radioButtons[i].isSelected()) {
                    ImageView[] imageViews = {mitem1, mitem2, mitem3, mitem4, mitem5, mitem6, mitem7, mitem8, mitem9};
                    imageViews[i].setImageResource(R.drawable.pouletcuit);
                    mCouteau.setImageResource(R.drawable.fondvierge);
                    radioButtons[i].setSelected(true);
                    ipouletcuit = i + 1;
                    break;
                }
            }
        }


        // ACTIONS ------------------------------------------------------

        private void FourActions(int Save) {

            if (mrbFourOuvert.isSelected()) {
                //si bois selectionné
                if (!mrbBois.isSelected()) {
                    if (mrb10.isSelected()) {
                        Bois(mrb10, 1, Save);
                    } else if (mrb11.isSelected()) {
                        Bois(mrb11, 2, Save);
                    } else if (mrb12.isSelected()) {
                        Bois(mrb12, 3, Save);
                    } else if (mrb13.isSelected()) {
                        Bois(mrb13, 4, Save);
                    } else if (mrb14.isSelected()) {
                        Bois(mrb14, 5, Save);
                    } else if (mrb15.isSelected()) {
                        Bois(mrb15, 6, Save);
                    } else if (mrb16.isSelected()) {
                        Bois(mrb16, 7, Save);
                    } else if (mrb17.isSelected()) {
                        Bois(mrb17, 8, Save);
                    } else if (mrb18.isSelected()) {
                        Bois(mrb18, 9, Save);
                    } else {

                        FourFerme();

                    }
                } else {
                    if (!mrbAlummettes.isSelected()) {
                        if (mrb10.isSelected()) {
                            Feu(mrb10, 1, Save);
                        } else if (mrb11.isSelected()) {
                            Feu(mrb11, 2, Save);
                        } else if (mrb12.isSelected()) {
                            Feu(mrb12, 3, Save);
                        } else if (mrb13.isSelected()) {
                            Feu(mrb13, 4, Save);
                        } else if (mrb14.isSelected()) {
                            Feu(mrb14, 5, Save);
                        } else if (mrb15.isSelected()) {
                            Feu(mrb15, 6, Save);
                        } else if (mrb16.isSelected()) {
                            Feu(mrb16, 7, Save);
                        } else if (mrb17.isSelected()) {
                            Feu(mrb17, 8, Save);
                        } else if (mrb18.isSelected()) {
                            Feu(mrb18, 9, Save);
                        } else {

                            FourFerme();
                        }
                    } else {
                        if (!mrbCuit.isSelected()) {
                            if (mrb10.isSelected()) {
                                PouletCuit(mrb10, 1, Save);
                            } else if (mrb11.isSelected()) {
                                PouletCuit(mrb11, 2, Save);
                            } else if (mrb12.isSelected()) {
                                PouletCuit(mrb12, 3, Save);
                            } else if (mrb13.isSelected()) {
                                PouletCuit(mrb13, 4, Save);
                            } else if (mrb14.isSelected()) {
                                PouletCuit(mrb14, 5, Save);
                            } else if (mrb15.isSelected()) {
                                PouletCuit(mrb15, 6, Save);
                            } else if (mrb16.isSelected()) {
                                PouletCuit(mrb16, 7, Save);
                            } else if (mrb17.isSelected()) {
                                PouletCuit(mrb17, 8, Save);
                            } else if (mrb18.isSelected()) {
                                PouletCuit(mrb18, 9, Save);
                            } else {
                                FourFerme();
                            }
                        } else {
                            FourFerme();
                        }
                    }
                }

            } else {
                if (mrbBois.isSelected()) {

                    if (mrbAlummettes.isSelected()) {

                        if (mrbCuit.isSelected() && !mrbburger.isSelected()) {


                            PourletCuitSelection();
                            inventaire();


                        } else if (mrbburger.isSelected()) {
                            mCuisine.setImageResource(R.drawable.cuisineprocheouverte);
                            mrbFourOuvert.setSelected(true);
                        } else {
                            mCuisine.setImageResource(R.drawable.cuisineprochefeu);
                            mrbFourOuvert.setSelected(true);
                        }
                    } else {

                        mCuisine.setImageResource(R.drawable.cuisineprochebois);
                        mrbFourOuvert.setSelected(true);
                    }
                } else {
                    mCuisine.setImageResource(R.drawable.cuisineprocheouverte);
                    mrbFourOuvert.setSelected(true);
                }
            }

        }


        private void PouletActions(int Save) {

            if (mrbDecoupe.isSelected()) {
                pouletDecoupe(Save);
            } else if (mrb10.isSelected() && !mrbCru.isSelected()) {
                PouletTue(mrb10, 1, Save);
            } else if (mrb11.isSelected() && !mrbCru.isSelected()) {
                PouletTue(mrb11, 2, Save);
            } else if (mrb12.isSelected() && !mrbCru.isSelected()) {
                PouletTue(mrb12, 3, Save);
            } else if (mrb13.isSelected() && !mrbCru.isSelected()) {
                PouletTue(mrb13, 4, Save);
            } else if (mrb14.isSelected() && !mrbCru.isSelected()) {
                PouletTue(mrb14, 5, Save);
            } else if (mrb15.isSelected() && !mrbCru.isSelected()) {
                PouletTue(mrb15, 6, Save);
            } else if (mrb16.isSelected() && !mrbCru.isSelected()) {
                PouletTue(mrb16, 7, Save);
            } else if (mrb17.isSelected() && !mrbCru.isSelected()) {
                PouletTue(mrb17, 8, Save);
            } else if (mrb18.isSelected() && !mrbCru.isSelected()) {
                PouletTue(mrb18, 9, Save);
            } else {

                if (mrb10.isSelected() && mrbCru.isSelected()) {
                    pouletCru(mrb10, 1, Save);
                } else if (mrb11.isSelected() && mrbCru.isSelected()) {
                    pouletCru(mrb11, 2, Save);
                } else if (mrb12.isSelected() && mrbCru.isSelected()) {
                    pouletCru(mrb12, 3, Save);
                } else if (mrb13.isSelected() && mrbCru.isSelected()) {
                    pouletCru(mrb13, 4, Save);
                } else if (mrb14.isSelected() && mrbCru.isSelected()) {
                    pouletCru(mrb14, 5, Save);
                } else if (mrb15.isSelected() && mrbCru.isSelected()) {
                    pouletCru(mrb15, 6, Save);
                } else if (mrb16.isSelected() && mrbCru.isSelected()) {
                    pouletCru(mrb16, 7, Save);
                } else if (mrb17.isSelected() && mrbCru.isSelected()) {
                    pouletCru(mrb17, 8, Save);
                } else if (mrb18.isSelected() && mrbCru.isSelected()) {
                    pouletCru(mrb18, 9, Save);
                }
            }

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

        private void FourFerme() {

            mCuisine.setImageResource(R.drawable.cuisineproche);
            mrbFourOuvert.setSelected(false);

        }



}