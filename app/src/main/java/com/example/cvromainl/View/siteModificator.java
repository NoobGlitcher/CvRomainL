package com.example.cvromainl.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.cvromainl.R;
import com.example.cvromainl.outils.DatabaseManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;


public class siteModificator extends AppCompatActivity {
    private WebView webView;
    private Button bModificator;
    private ImageButton mLogo, mLeft, mRight;
    private TextView tLogo, tLeft, tRight, tContact, tvalidation;
    private ImageView iLogo, iLeft, iRight;
    private EditText eTextContact;
    private static final int REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE = 123;
    private RadioButton mrb1, mrb2, mrb3;
    private DatabaseManager mdatabasemanager;
    private String ContactDescri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_modificator);

        webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true); // Activer JavaScript si nécessaire

        // Configuration de WebViewClient pour ouvrir les liens dans cette WebView, pas dans le navigateur par défaut
        webView.setWebViewClient(new WebViewClient());

        // Charger l'URL du site web
        webView.loadUrl("https://oribabil.myhostpoint.ch");

        mdatabasemanager= new DatabaseManager(getApplicationContext());


        iLogo = findViewById(R.id.imgLogo);



        mLogo = findViewById(R.id.LogoSearch);

        bModificator = findViewById(R.id.buttonModificator);

        bModificator.setEnabled(false); // Désactive les clics
        bModificator.setClickable(false);


        tLogo = findViewById(R.id.logoText);

        tContact = findViewById(R.id.textContact);
        tvalidation = findViewById(R.id.textValidation);

        tvalidation.setVisibility(View.INVISIBLE);

        eTextContact = findViewById(R.id.editTextContact);

        eTextContact.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not used
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Called when the text in the EditText changes
                if (s.length() > 0) {
                    BoutonOK(); // Enable the button if there is text
                } else {
                    // Disable the button if there is no text
                    BoutonPasOK();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not used
            }
        });

        mrb1 = findViewById(R.id.radioButtonLogo);
        mrb2 = findViewById(R.id.radioButtonLeft);
        mrb3 = findViewById(R.id.radioButtonRight);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission non accordée, il faut la demander
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE);
        } else {
            // La permission est déjà accordée
        }

        mLogo.setOnClickListener(v -> {

            mrb1.setSelected(true);
            mrb2.setSelected(false);
            mrb3.setSelected(false);

            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, 1);
        });



        bModificator.setOnClickListener(view -> {


            ContactDescri = eTextContact.getText().toString();
            Drawable iLogoEnvoie = iLogo.getDrawable();




// Vérification si le Drawable est une instance de BitmapDrawable (c'est-à-dire une image bitmap)
            if (iLogoEnvoie instanceof BitmapDrawable) {



                        LogoEnvoie (iLogoEnvoie, ContactDescri);

                        iLogo.setImageBitmap(null); }

                             else {
                            String url = "https://oribabil.myhostpoint.ch/createusers/action/siteModificator.php";

                            Map<String, String> params = new HashMap<>();
                            params.put("texteContact", ContactDescri);
                            JSONObject parameters = new JSONObject(params);
                            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, parameters, this::onApiResponse, error -> Toast.makeText(getApplicationContext(), "erreur de connection au serveur !!", Toast.LENGTH_LONG).show());
                            mdatabasemanager.queue.add(jsonObjectRequest);
                        }








// Créez un objet Handler
            Handler handler = new Handler();

// Postez un message après un délai de 5 secondes
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Code à exécuter après le délai de 5 secondes
                    webView.reload();
                }
            }, 5000); // 5000 millisecondes équivalent à 5 secondes

            BoutonPasOK();
            eTextContact.setText("");






        });
            }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {

            Uri selectedImage = data.getData();

            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = this.getContentResolver().query(selectedImage, filePathColumn, null, null, null);

            if (cursor != null) {
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String imgPath = cursor.getString(columnIndex);
                cursor.close();

                Bitmap originalImage = BitmapFactory.decodeFile(imgPath);

                if (originalImage != null) {
                    // Calculate the maximum image size for transfer
                    int maxSize = 3024; // Set your desired maximum size here (in KB)

                    int originalSize = originalImage.getByteCount() / 3024; // Size in KB

                    // Check if the original image size exceeds the maximum size
                    if (originalSize > maxSize) {
                        // Calculate the new width and height to maintain aspect ratio
                        int newWidth = (int) (originalImage.getWidth() * (float) maxSize / originalSize);
                        int newHeight = (int) (originalImage.getHeight() * (float) maxSize / originalSize);

                        // Resize the original image
                        Bitmap resizedImage = Bitmap.createScaledBitmap(originalImage, newWidth, newHeight, true);

                        if (mrb1.isSelected()) {

                            iLogo.setImageBitmap(resizedImage);
                            BoutonOK();


                        } else if (mrb2.isSelected()) {

                            iLeft.setImageBitmap(resizedImage);
                            BoutonOK();


                        } else {

                            iRight.setImageBitmap(resizedImage);
                            BoutonOK();

                        }


                    } else {
                        // If the image size is already within the maximum limit, proceed with the original image

                        if (mrb1.isSelected()) {

                            iLogo.setImageBitmap(originalImage);
                            BoutonOK();


                        } else if (mrb2.isSelected()) {

                            iLeft.setImageBitmap(originalImage);
                            BoutonOK();


                        } else {

                            iRight.setImageBitmap(originalImage);
                            BoutonOK();

                        }

                    }
                } else {
                    // Handle the case where the image could not be decoded
                    Toast.makeText(this, "Impossible de décoder l'image sélectionnée", Toast.LENGTH_LONG).show();
                }
            } else {
                // Handle the case where cursor is null
                Toast.makeText(this, "Cursor est null", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(this, "Aucune image sélectionnée", Toast.LENGTH_LONG).show();
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // La permission a été accordée
                Toast.makeText(this, "Permission accordée pour accéder au stockage externe", Toast.LENGTH_SHORT).show();
            } else {
                // La permission a été refusée
                Toast.makeText(this, "Permission refusée pour accéder au stockage externe", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BoutonOK() {
            bModificator.setEnabled(true); // Désactive les clics
            bModificator.setClickable(true); // Le rend non cliquable visuellement
        }

    public void BoutonPasOK() {
        bModificator.setEnabled(false); // Désactive les clics
        bModificator.setClickable(false); // Le rend non cliquable visuellement
    }



    @SuppressLint("SetTextI18n")
    public void onApiResponse(JSONObject response) {

        boolean success;
        String error = "";


        try {
            success = response.getBoolean("success");


            if (success) {


                tvalidation.setVisibility(View.VISIBLE);
                tvalidation.setText("Site modifié!");

            } else {
                tvalidation.setVisibility(View.VISIBLE);
                tvalidation.setText(error);


            }

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "BRAVO !!", Toast.LENGTH_LONG).show();
        }
    }

    public void LogoEnvoie(Drawable iLogoEnvoie, String ContactDescri) {

        // Conversion du Drawable en BitmapDrawable
        BitmapDrawable bitmapDrawableLogo = (BitmapDrawable) iLogoEnvoie;
        // Récupération du Bitmap à partir du BitmapDrawable
        Bitmap bitmapLogo = bitmapDrawableLogo.getBitmap();

        // Maintenant, vous avez le Bitmap de l'image affichée dans iLogo, que vous pouvez utiliser selon vos besoins.
        ByteArrayOutputStream ByteStreamLogo = new ByteArrayOutputStream();
        bitmapLogo.compress(Bitmap.CompressFormat.PNG, 100, ByteStreamLogo);
        byte[] bLogo = ByteStreamLogo.toByteArray();
        String donneeLogo = Base64.encodeToString(bLogo, Base64.DEFAULT);


        String url = "https://oribabil.myhostpoint.ch/createusers/action/siteModificator.php";

        Map<String, String> params = new HashMap<>();

        params.put("headerlogo", donneeLogo);
        params.put("texteContact", ContactDescri);

        JSONObject parameters = new JSONObject(params);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, parameters, this::onApiResponse, error -> Toast.makeText(getApplicationContext(), "erreur de connection au serveur !!", Toast.LENGTH_LONG).show());

        mdatabasemanager.queue.add(jsonObjectRequest);




    }
    public void LeftEnvoie(Drawable iLeftEnvoie, String ContactDescri) {

        BitmapDrawable bitmapDrawableLeft = (BitmapDrawable) iLeftEnvoie;

        // Récupération du Bitmap à partir du BitmapDrawable
        Bitmap bitmapLeft = bitmapDrawableLeft.getBitmap();

        // Maintenant, vous avez le Bitmap de l'image affichée dans iLogo, que vous pouvez utiliser selon vos besoins.
        ByteArrayOutputStream ByteStreamLeft = new ByteArrayOutputStream();
        bitmapLeft.compress(Bitmap.CompressFormat.PNG, 100, ByteStreamLeft);
        byte[] bLeft = ByteStreamLeft.toByteArray();
        String donneeLeft = Base64.encodeToString(bLeft, Base64.DEFAULT);


        String url = "https://oribabil.myhostpoint.ch/createusers/action/siteModificator.php";

        Map<String, String> params = new HashMap<>();

        params.put("headerleft", donneeLeft);
        params.put("texteContact", ContactDescri);

        JSONObject parameters = new JSONObject(params);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, parameters, this::onApiResponse, error -> Toast.makeText(getApplicationContext(), "erreur de connection au serveur !!", Toast.LENGTH_LONG).show());

        mdatabasemanager.queue.add(jsonObjectRequest);

    }
    public void RightEnvoie(Drawable iRightEnvoie, String ContactDescri) {

        BitmapDrawable bitmapDrawableRight = (BitmapDrawable) iRightEnvoie;

        // Récupération du Bitmap à partir du BitmapDrawable
        Bitmap bitmapRight = bitmapDrawableRight.getBitmap();

        // Maintenant, vous avez le Bitmap de l'image affichée dans iLogo, que vous pouvez utiliser selon vos besoins.
        ByteArrayOutputStream ByteStreamRight = new ByteArrayOutputStream();
        bitmapRight.compress(Bitmap.CompressFormat.PNG, 100, ByteStreamRight);
        byte[] bRight = ByteStreamRight.toByteArray();
        String donneeRight = Base64.encodeToString(bRight, Base64.DEFAULT);


        String url = "https://oribabil.myhostpoint.ch/createusers/action/siteModificator.php";

        Map<String, String> params = new HashMap<>();

        params.put("headerright", donneeRight);
        params.put("texteContact", ContactDescri);

        JSONObject parameters = new JSONObject(params);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, parameters, this::onApiResponse, error -> Toast.makeText(getApplicationContext(), "erreur de connection au serveur !!", Toast.LENGTH_LONG).show());

        mdatabasemanager.queue.add(jsonObjectRequest);



    }






}

