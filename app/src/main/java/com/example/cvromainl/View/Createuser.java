package com.example.cvromainl.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.cvromainl.Controle.Controle;
import com.example.cvromainl.R;
import com.example.cvromainl.outils.DatabaseManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Createuser extends AppCompatActivity {

    private EditText mIDtext;
    private EditText mPassword2;
    private EditText mPassword3;
    private EditText mClef;
    private EditText mCity;
    private Button mConnexion, mRetour;
    private ImageView mFrance;
    private ImageView mSuisse;
    private TextView mErrorConnexion ;
    private RadioButton mFranceBoutton;
    private RadioButton mSuisseBoutton;
    private ProgressBar progressBar;
    private String username;
    private String password;
    private String mail;
    private String pays;

    private DatabaseManager databasemanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createuser);




            mIDtext = findViewById(R.id.ID2);
            mPassword2 = findViewById(R.id.Password2);
            mPassword3 = findViewById(R.id.Password3);
            mClef = findViewById(R.id.Clef);
            mCity = findViewById(R.id.City);
            mFranceBoutton = findViewById(R.id.franceBoutton);
            mSuisseBoutton = findViewById(R.id.suisseBoutton);
            mFrance = findViewById(R.id.DrapeauFrance);
            mSuisse = findViewById(R.id.DrapeauSuisse);
            mRetour =findViewById(R.id.retourButton);

            mErrorConnexion = findViewById(R.id.ErrorMessage);



            databasemanager= new DatabaseManager(getApplicationContext());

            final ProgressBar progressBar = findViewById(R.id.progressBar);
            progressBar.setVisibility(View.GONE);



            mConnexion = findViewById(R.id.Connexion);


            mConnexion.setOnClickListener(view -> {

                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(() -> progressBar.setVisibility(View.GONE), 4000);

                username = mIDtext.getText().toString();
                password = mPassword2.getText().toString();
                mail = mClef.getText().toString();
                int Pays;



                if (  mFranceBoutton.isChecked()  ){

                    Pays=1; } else {Pays = 0;}

                pays = Integer.toString(Pays);

                createAccount();
            });

            mRetour.setOnClickListener(view -> {
                Intent CreateAccount = new Intent(Createuser.this, loggin.class);
                startActivity(CreateAccount);
                finish();
            });
        }

        public void onApiResponse(JSONObject response) {

            boolean success ;
            String error;

            try {
                success = response.getBoolean("success");

                if (success) {

                    Intent DecorationActivity = new Intent(getApplicationContext(), loggin.class);
                    DecorationActivity.putExtra("username", username);
                    DecorationActivity.putExtra("pays", pays);
                    startActivity(DecorationActivity);
                    finish();

                } else {
                    error = response.getString("error");
                    mErrorConnexion.setVisibility(View.VISIBLE);
                    mErrorConnexion.setText(error);
                }

            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "BRAVO !!", Toast.LENGTH_LONG).show();
            }}

        public void createAccount () {

            String url = "https://oribabil.myhostpoint.ch/createusers/action/createaccount.php";

            Map<String, String> params = new HashMap<>() ;

            params.put("username", username);
            params.put("password", password);
            params.put("mail", mail);
            params.put("pays", pays);
            JSONObject parameters = new JSONObject(params);

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, parameters, response -> {

                onApiResponse(response);
                Toast.makeText(getApplicationContext(), "Successs", Toast.LENGTH_LONG).show();

            }, error -> Toast.makeText(getApplicationContext(), "erreur de connection au serveur !!", Toast.LENGTH_LONG).show());

            databasemanager.queue.add(jsonObjectRequest);
        }
    }