package com.example.cvromainl.View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cvromainl.R;
import com.example.cvromainl.outils.DatabaseManager;

import java.util.Objects;

public class Eshop extends AppCompatActivity {

    private TextView mGenerateurText;
    private TextView PaysRecup;
    private DatabaseManager mDatabaseManager;
    private RadioButton mButtonSynthe;
    private RadioButton mButtonLaine;
    private RadioButton mButtonSoie;
    private Button mButtonCreation;

    private String pays, Textiletype;
    private ImageView mvioletTissus;
    private ImageView mvertTissus;
    private ImageView mimageLaine;
    private ImageView mimageSoie;
    private ImageView mimageSynthe;
    private ImageView mbleuTissus;
    private ImageView mrougeTissus;
    private ImageView mjauneTissus;
    private ImageView mMachineAnimee;
    private ImageView mMachineFixe;

    private MediaPlayer mediaPlayer;

    private Handler handler2, handler3;
    private Runnable stopPlayerRunnable;

    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (mMachineFixe.getVisibility() == View.VISIBLE) {
                mMachineFixe.setVisibility(View.GONE);
                mMachineAnimee.setVisibility(View.VISIBLE);
            } else {
                mMachineFixe.setVisibility(View.VISIBLE);
                mMachineAnimee.setVisibility(View.GONE);
            }
            handler3.postDelayed(this, 50); //changez la valeur 1000 à votre goût
        }
    };

    public Eshop() {
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eshop);






            mimageLaine = findViewById(R.id.imageLaine);

            mimageSynthe = findViewById(R.id.imageSynthe);

            mimageSoie = findViewById(R.id.imageSoie);

            mbleuTissus = findViewById(R.id.bleuTissus);
            mrougeTissus = findViewById(R.id.rougeTissus);
            mjauneTissus = findViewById(R.id.jauneTissus);
            mvertTissus = findViewById(R.id.vertTissus);
            mvioletTissus = findViewById(R.id.violetTissus);

            mrougeTissus.setVisibility(View.INVISIBLE);
            mjauneTissus.setVisibility(View.INVISIBLE);
            mbleuTissus.setVisibility(View.INVISIBLE);
            mvioletTissus.setVisibility(View.INVISIBLE);
            mvertTissus.setVisibility(View.INVISIBLE);

            mediaPlayer = MediaPlayer.create(this, R.raw.machinebruit);

            mMachineFixe = findViewById(R.id.machinefixe);

            mMachineAnimee = findViewById(R.id.machineanimee);
            mMachineAnimee.setVisibility(View.INVISIBLE);

            mDatabaseManager= new DatabaseManager(getApplicationContext());

            pays = getIntent().getStringExtra("pays");

            PaysRecup = findViewById(R.id.ChooseMessage);

            if (Objects.equals(pays, "1")){

                PaysRecup.setVisibility(View.VISIBLE);
                PaysRecup.setText("Bienvenue dans ta future création Parisienne.");

            }else {

                PaysRecup.setVisibility(View.VISIBLE);
                PaysRecup.setText("Bienvenue dans ta future création Suisse.");
            }

            final ProgressBar progressBar = findViewById(R.id.progressBar2);
            progressBar.setVisibility(View.GONE);
            mButtonCreation = findViewById(R.id.buttonCreation);

            mButtonSoie = findViewById(R.id.radioButtonSoie);
            mButtonSoie.setPadding(200, 0, 0, 0); // padding autour du bouton radio


            mButtonSoie.setOnClickListener(view -> {
                if (!mButtonSoie.isSelected()) {
                    mButtonSoie.setChecked(true);
                    mButtonSoie.setSelected(true);
                    mimageSoie.setImageResource(R.drawable.check);
                    mrougeTissus.setVisibility(View.VISIBLE);


                } else {
                    mButtonSoie.setChecked(false);
                    mButtonSoie.setSelected(false);
                    mimageSoie.setImageResource(R.drawable.nocheck);
                    mrougeTissus.setVisibility(View.INVISIBLE);

                }
            });





            mButtonSynthe = findViewById(R.id.radioButtonSynthe);
            mButtonSynthe.setPadding(200, 0, 0, 0); // padding autour du bouton radio


            mButtonSynthe.setOnClickListener(view -> {
                if (!mButtonSynthe.isSelected()) {
                    mButtonSynthe.setChecked(true);
                    mButtonSynthe.setSelected(true);
                    mimageSynthe.setImageResource(R.drawable.check);
                    mvertTissus.setVisibility(View.VISIBLE);


                } else {
                    mButtonSynthe.setChecked(false);
                    mButtonSynthe.setSelected(false);
                    mimageSynthe.setImageResource(R.drawable.nocheck);
                    mvertTissus.setVisibility(View.INVISIBLE);


                }
            });

            mButtonLaine = findViewById(R.id.radioButtonLaine);
            mButtonLaine.setPadding(200, 0, 0, 0); // padding autour du bouton radio


            mButtonLaine.setOnClickListener(view -> {
                if (!mButtonLaine.isSelected()) {
                    mButtonLaine.setChecked(true);
                    mButtonLaine.setSelected(true);
                    mimageLaine.setImageResource(R.drawable.check);
                    mvioletTissus.setVisibility(View.VISIBLE);


                } else {
                    mButtonLaine.setChecked(false);
                    mButtonLaine.setSelected(false);
                    mimageLaine.setImageResource(R.drawable.nocheck);
                    mvioletTissus.setVisibility(View.INVISIBLE);


                }
            });

            mGenerateurText = findViewById(R.id.GenerateurText);
            mGenerateurText.setVisibility(View.INVISIBLE);

            mButtonCreation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {






                    int Laine;
                    if (  mButtonLaine.isChecked()  ){

                        Laine=1; } else {Laine = 0;}


                    int Soie;
                    if (  mButtonSoie.isChecked()  ){

                        Soie=10; } else {Soie = 0;}


                    int Synthe;
                    if (  mButtonSynthe.isChecked()  ){

                        Synthe=100; } else {Synthe = 0;}


                    int TextileType;
                    TextileType= (Soie+Synthe+Laine);

                    if(TextileType < 1){

                        Toast.makeText(getApplicationContext(), "Veuillez sélectionner au moins 2 choses.", Toast.LENGTH_LONG).show();


                    }  else if (TextileType == 111 ) {

                        Toast.makeText(getApplicationContext(), "Veuillez enlever une chose.", Toast.LENGTH_LONG).show();


                    } else {

                        progressBar.setVisibility(View.VISIBLE);
                        new Handler().postDelayed(() -> progressBar.setVisibility(View.GONE), 6000);

                        //3000 milliseconds = 3 seconds

                        final Handler handler = new Handler();

                        final int duration = 8000; // Durée en millisecondes, soit 3 secondes
                        final int frequency = 700; // Fréquence en millisecondes, soit 500 millisecondes
                        final int iterations = duration / frequency;

                        final Runnable r = new Runnable() {
                            int count = 0;
                            public void run() {
                                if (mGenerateurText.getVisibility() == View.INVISIBLE) {
                                    mGenerateurText.setVisibility(View.VISIBLE);
                                } else {
                                    mGenerateurText.setVisibility(View.INVISIBLE);
                                }
                                count++;
                                if (count < iterations) {
                                    handler.postDelayed(this, frequency);
                                }
                            }
                        };

                        handler.postDelayed(r, frequency);

                        new Handler().postDelayed(() -> {

                            Textiletype = Integer.toString(TextileType);
                            Intent intent = new Intent(Eshop.this, Bidules.class);
                            intent.putExtra("type", Textiletype);
                            startActivity(intent);

                        }, 8000);


                        mediaPlayer.start();
                        handler2 = new Handler();
                        stopPlayerRunnable = () -> {
                            if (mediaPlayer.isPlaying()) {
                                mediaPlayer.stop();
                            }
                        };
                        handler2.postDelayed(stopPlayerRunnable, 8000); //6 secondes

                        handler3 = new Handler(); //initialiser l'objet handler ici


                        handler3.postDelayed(runnable, 1000); //changer la valeur 1000 à votre goût




                    }



                }
            });
        }

        @Override
        protected void onStop() {
            super.onStop();
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            handler3.removeCallbacks(runnable);
            mediaPlayer.release();
            if (handler2 != null) {
                handler2.removeCallbacks(stopPlayerRunnable);
            }
        }

    }