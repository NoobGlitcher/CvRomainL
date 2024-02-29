package com.example.cvromainl.View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.cvromainl.R;
import com.example.cvromainl.outils.DatabaseManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class loggin extends AppCompatActivity {

    private EditText mID;
    private EditText mPassword;
    private Button mConnexion, mInscription;
    private TextView countdownTextView;
    private String username;
    private String password;
    private DatabaseManager mDatabaseManager;
    private TextView errorConnectTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

            mDatabaseManager= new DatabaseManager(getApplicationContext());
            mID = findViewById(R.id.ID);
            mPassword = findViewById(R.id.Password);
            errorConnectTextView =findViewById(R.id.errorConnectTextView);
            mConnexion = findViewById(R.id.Connexion);
            countdownTextView = findViewById(R.id.countdownTextView);
            mInscription = findViewById(R.id.Inscription);

            Calendar targetDate = Calendar.getInstance();
            targetDate.set(2023, Calendar.APRIL, 27, 21, 0, 0);

            new CountDownTimer(targetDate.getTimeInMillis() - System.currentTimeMillis(), 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    long seconds = millisUntilFinished / 1000;
                    long minutes = seconds / 60;
                    long hours = minutes / 60;
                    long days = hours / 24;
                    String timeLeft = days + " jours " + hours % 24 + " heures " + minutes % 60 + " minutes " + seconds % 60 + " secondes";
                    countdownTextView.setText(timeLeft);
                }

                @SuppressLint("SetTextI18n")
                @Override
                public void onFinish() {
                    countdownTextView.setText("Compte à rebours terminé !");
                }

            }.start();
            countdownTextView.setVisibility(View.INVISIBLE);

            mConnexion.setOnClickListener(view -> {

                username = mID.getText().toString();
                password = mPassword.getText().toString();

                connectUser();

            })

            ;

            mInscription.setOnClickListener(view -> {

                Intent CreateAccount = new Intent(getApplicationContext(), Createuser.class);
                startActivity(CreateAccount);
                finish();


            })
            ;

        }

        public void onApiResponse(JSONObject response) {
            try {
                if (response.has("username") && response.has("mail") && response.has("pays")) {
                    // Succès: les données de l'utilisateur sont disponibles
                    String username = response.getString("username");
                    String mail = response.getString("mail");
                    String pays = response.getString("pays");

                    Intent decorationActivity = new Intent(getApplicationContext(), MainActivity.class);
                    decorationActivity.putExtra("username", username);
                    decorationActivity.putExtra("mail", mail);
                    decorationActivity.putExtra("pays", pays);

                    Toast.makeText(getApplicationContext(), "Bravo ! Vous etes connecté.", Toast.LENGTH_LONG).show();


                    startActivity(decorationActivity);
                    finish();
                } else if (response.has("error")) {
                    // Erreur: un message d'erreur est retourné par le serveur
                    String error = response.getString("error");
                    errorConnectTextView.setVisibility(View.VISIBLE);
                    errorConnectTextView.setText(error);

                    Intent atelierActivity = new Intent(getApplicationContext(), Createuser.class);

                    startActivity(atelierActivity);
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            }
        }

        public void connectUser () {

            String url = "https://oribabil.myhostpoint.ch/createusers/action/connectuser.php";
            Map<String, String> params = new HashMap<>() ;
            params.put("username", username);
            params.put("password", password);
            JSONObject parameters = new JSONObject(params);

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, parameters, this::onApiResponse, error -> Toast.makeText(getApplicationContext(), "erreur de connection au serveur !!", Toast.LENGTH_LONG).show());
            mDatabaseManager.queue.add(jsonObjectRequest);
        }


}