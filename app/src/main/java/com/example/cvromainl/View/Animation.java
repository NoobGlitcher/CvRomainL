package com.example.cvromainl.View;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cvromainl.R;

public class Animation extends AppCompatActivity {



        private Handler handler3, handler4;
        private int screenHeight;
        private ImageView colombefixe, colombeanimee,colombefixe2, colombeanimee2, nuage;
        private ImageView piece1;
        private Button mTest;

        private final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (colombefixe.getVisibility() == View.VISIBLE) {
                    colombefixe.setVisibility(View.GONE);
                    colombeanimee.setVisibility(View.VISIBLE);
                } else {
                    colombefixe.setVisibility(View.VISIBLE);
                    colombeanimee.setVisibility(View.GONE);
                }
                handler3.postDelayed(this, 75); //changez la valeur 1000 à votre goût
            }
        };

        private final Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                if (colombefixe2.getVisibility() == View.VISIBLE) {
                    colombefixe2.setVisibility(View.GONE);
                    colombeanimee2.setVisibility(View.VISIBLE);
                } else {
                    colombefixe2.setVisibility(View.VISIBLE);
                    colombeanimee2.setVisibility(View.GONE);
                }
                handler4.postDelayed(this, 75); //changez la valeur 1000 à votre goût
            }
        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

            setContentView(R.layout.activity_animation);

            mTest = findViewById(R.id.button);

            colombefixe = findViewById(R.id.ColombeFixe);
            colombeanimee = findViewById(R.id.ColombeAnimee);
            colombeanimee.setVisibility(View.INVISIBLE);

            colombefixe2 = findViewById(R.id.ColombeFixe2);
            colombeanimee2 = findViewById(R.id.ColombeAnimee2);
            colombeanimee2.setVisibility(View.INVISIBLE);

            piece1 = findViewById(R.id.Piece);

            nuage = findViewById(R.id.nuage);
            nuage.setVisibility(View.INVISIBLE);

            mTest.setOnClickListener(view -> {

                mTest.setVisibility(View.INVISIBLE);

                handler3 = new Handler(); //initialiser l'objet handler ici
                handler3.postDelayed(runnable, 0); //changer la valeur 1000 à votre goût

                handler4 = new Handler(); //initialiser l'objet handler ici
                handler4.postDelayed(runnable2, 0); //changer la valeur 1000 à votre goût

                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                screenHeight = displayMetrics.heightPixels;

                // Lancement de l'animation
                startAnimation();
                startAnimation2();
                startAnimation3();
                startAnimation4();

            });
        }

        private void startAnimation() {
            // Créer un objet AnimatorSet pour coordonner les animations
            AnimatorSet set = new AnimatorSet();

            // Créer une animation de réduction de la taille pour les deux images
            ObjectAnimator scaleDownX1 = ObjectAnimator.ofFloat(colombefixe, "scaleX", 1f, 0.5f);
            ObjectAnimator scaleDownY1 = ObjectAnimator.ofFloat(colombefixe, "scaleY", 1f, 0.5f);
            ObjectAnimator scaleDownX2 = ObjectAnimator.ofFloat(colombeanimee, "scaleX", 1f, 0.5f);
            ObjectAnimator scaleDownY2 = ObjectAnimator.ofFloat(colombeanimee, "scaleY", 1f, 0.5f);
            scaleDownX1.setDuration(1000);
            scaleDownY1.setDuration(1000);
            scaleDownX2.setDuration(1000);
            scaleDownY2.setDuration(1000);
            scaleDownX1.setStartDelay(2000); // Ajouter un délai de 2 secondes
            scaleDownY1.setStartDelay(2000);
            scaleDownX2.setStartDelay(2000);
            scaleDownY2.setStartDelay(2000);

            // Créer une animation de déplacement en diagonale pour les deux images
            ObjectAnimator moveDiagonal1 = ObjectAnimator.ofFloat(colombefixe, "translationX", 0f, -300f);
            moveDiagonal1.setDuration(2000);
            moveDiagonal1.setInterpolator(new AccelerateInterpolator());
            ObjectAnimator moveDiagonal2 = ObjectAnimator.ofFloat(colombeanimee, "translationX", 0f, -300f);
            moveDiagonal2.setDuration(2000);
            moveDiagonal2.setInterpolator(new AccelerateInterpolator());
            ObjectAnimator moveDiagonal3 = ObjectAnimator.ofFloat(colombefixe, "translationY", 0f, -300f);
            moveDiagonal3.setDuration(2000);
            moveDiagonal3.setInterpolator(new AccelerateInterpolator());
            ObjectAnimator moveDiagonal4 = ObjectAnimator.ofFloat(colombeanimee, "translationY", 0f, -300f);
            moveDiagonal4.setDuration(2000);
            moveDiagonal4.setInterpolator(new AccelerateInterpolator());

            ObjectAnimator scaleDownX3 = ObjectAnimator.ofFloat(colombefixe, "scaleX", 0.5f, 0f);
            ObjectAnimator scaleDownY3 = ObjectAnimator.ofFloat(colombefixe, "scaleY", 0.5f, 0f);
            ObjectAnimator scaleDownX4 = ObjectAnimator.ofFloat(colombeanimee, "scaleX", 0.5f, 0f);
            ObjectAnimator scaleDownY4 = ObjectAnimator.ofFloat(colombeanimee, "scaleY", 0.5f, 0f);
            scaleDownX3.setDuration(2000);
            scaleDownY3.setDuration(2000);
            scaleDownX4.setDuration(2000);
            scaleDownY4.setDuration(2000);
            scaleDownX3.setStartDelay(5000); // Ajouter un délai de 4 secondes
            scaleDownY3.setStartDelay(5000);
            scaleDownX4.setStartDelay(5000);
            scaleDownY4.setStartDelay(5000);

            ObjectAnimator scaleDownX5 = ObjectAnimator.ofFloat(colombefixe2, "scaleX", 1f, 0.5f);
            ObjectAnimator scaleDownY5 = ObjectAnimator.ofFloat(colombefixe2, "scaleY", 1f, 0.5f);
            ObjectAnimator scaleDownX6 = ObjectAnimator.ofFloat(colombeanimee2, "scaleX", 1f, 0.5f);
            ObjectAnimator scaleDownY6 = ObjectAnimator.ofFloat(colombeanimee2, "scaleY", 1f, 0.5f);
            scaleDownX5.setDuration(1000);
            scaleDownY5.setDuration(1000);
            scaleDownX6.setDuration(1000);
            scaleDownY6.setDuration(1000);
            scaleDownX5.setStartDelay(2000); // Ajouter un délai de 2 secondes
            scaleDownY5.setStartDelay(2000);
            scaleDownX6.setStartDelay(2000);
            scaleDownY6.setStartDelay(2000);

            // Créer une animation de déplacement en diagonale pour les deux images
            ObjectAnimator moveDiagonal5 = ObjectAnimator.ofFloat(colombefixe2, "translationX", 0f, 300f);
            moveDiagonal5.setDuration(2000);
            moveDiagonal5.setInterpolator(new AccelerateInterpolator());
            ObjectAnimator moveDiagonal6 = ObjectAnimator.ofFloat(colombeanimee2, "translationX", 0f, 300f);
            moveDiagonal6.setDuration(2000);
            moveDiagonal6.setInterpolator(new AccelerateInterpolator());
            ObjectAnimator moveDiagonal7 = ObjectAnimator.ofFloat(colombefixe2, "translationY", 0f, -300f);
            moveDiagonal7.setDuration(2000);
            moveDiagonal7.setInterpolator(new AccelerateInterpolator());
            ObjectAnimator moveDiagonal8 = ObjectAnimator.ofFloat(colombeanimee2, "translationY", 0f, -300f);
            moveDiagonal8.setDuration(2000);
            moveDiagonal8.setInterpolator(new AccelerateInterpolator());

            ObjectAnimator scaleDownX7 = ObjectAnimator.ofFloat(colombefixe2, "scaleX", 0.5f, 0f);
            ObjectAnimator scaleDownY7 = ObjectAnimator.ofFloat(colombefixe2, "scaleY", 0.5f, 0f);
            ObjectAnimator scaleDownX8 = ObjectAnimator.ofFloat(colombeanimee2, "scaleX", 0.5f, 0f);
            ObjectAnimator scaleDownY8 = ObjectAnimator.ofFloat(colombeanimee2, "scaleY", 0.5f, 0f);
            scaleDownX7.setDuration(2000);
            scaleDownY7.setDuration(2000);
            scaleDownX8.setDuration(2000);
            scaleDownY8.setDuration(2000);
            scaleDownX7.setStartDelay(7000); // Ajouter un délai de 4 secondes
            scaleDownY7.setStartDelay(7000);
            scaleDownX8.setStartDelay(7000);
            scaleDownY8.setStartDelay(7000);

            // Ajouter les animations à l'objet AnimatorSet
            set.play(scaleDownX1).with(scaleDownY1).with(scaleDownX2).with(scaleDownY2);
            set.play(scaleDownX5).with(scaleDownY5).with(scaleDownX6).with(scaleDownY6);

            set.play(moveDiagonal1).with(moveDiagonal3).with(moveDiagonal2).with(moveDiagonal4).after(scaleDownX1);
            set.play(moveDiagonal5).with(moveDiagonal7).with(moveDiagonal6).with(moveDiagonal8).after(scaleDownX5);

            set.play(scaleDownX3).with(scaleDownY3).with(scaleDownX4).with(scaleDownY4);
            set.play(scaleDownX7).with(scaleDownY7).with(scaleDownX8).with(scaleDownY8);

            // Ajouter un écouteur d'événements pour alterner les images
            set.addListener(new Animator.AnimatorListener() {
                private boolean isImage1 = true;

                @Override
                public void onAnimationStart(Animator animator) {
                    // Ne rien faire
                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    // Alterner les images
                    if (isImage1) {
                        colombeanimee.setVisibility(View.INVISIBLE);
                        colombeanimee.setVisibility(View.VISIBLE);
                        colombeanimee2.setVisibility(View.INVISIBLE);
                        colombeanimee2.setVisibility(View.VISIBLE);
                        isImage1 = false;
                    } else {
                        colombeanimee.setVisibility(View.INVISIBLE);
                        colombefixe.setVisibility(View.VISIBLE);
                        colombeanimee2.setVisibility(View.INVISIBLE);
                        colombefixe2.setVisibility(View.VISIBLE);
                        isImage1 = true;
                    }
                }

                @Override
                public void onAnimationCancel(Animator animator) {
                    // Ne rien faire

                }

                @Override
                public void onAnimationRepeat(Animator animator) {
                    // Ne rien faire
                }
            });

            set.start();

        }
        private void startAnimation2() {

            ObjectAnimator animation = ObjectAnimator.ofFloat(piece1, "translationY", 0f, screenHeight);
            animation.setDuration(3000); // Durée de l'animation en millisecondes
            animation.setInterpolator(new AccelerateInterpolator()); // Accélération de l'animation

            // Définition de l'action à la fin de l'animation
            animation.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    piece1.setVisibility(View.GONE); // Fait disparaître l'image view
                }
            });
            // Démarrer l'animation
            animation.start();
        }


        private void startAnimation3() {

            new Handler().postDelayed(() -> {
                // Créer l'animation de translation verticale
                ObjectAnimator translationAnimator = ObjectAnimator.ofFloat(nuage, View.TRANSLATION_Y, -nuage.getHeight(), 0);
                translationAnimator.setDuration(7000);

                // Créer l'animation d'alpha pour le fondu enchaîné
                //ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(nuage, View.ALPHA, 0f, 1f);
                //alphaAnimator.setDuration(5000);

                // Combinez les deux animations
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(translationAnimator);
                animatorSet.start();

                // Rendre l'image visible après le début de l'animation
                nuage.setVisibility(View.VISIBLE);
            }, 2000); // Délai de 6 secondes en millisecondes (6000 = 6 secondes)
        }

        private void startAnimation4() {






        }
    }
