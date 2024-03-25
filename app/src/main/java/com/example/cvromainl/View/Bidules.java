package com.example.cvromainl.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.cvromainl.R;
import com.example.cvromainl.outils.DatabaseManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bidules extends AppCompatActivity {

    private DatabaseManager mDatabaseManager;
    private String TextileType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bidules);
        mDatabaseManager = new DatabaseManager(getApplicationContext());

        TextileType = getIntent().getStringExtra("type");

        connectUser();
    }

    public static class ImageTextListAdapter extends BaseAdapter {
        private Context mContext;
        private ArrayList<HashMap<String, Object>> mData;

        public ImageTextListAdapter(Context context, ArrayList<HashMap<String, Object>> data) {
            mContext = context;
            mData = data;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.listtextile_view, parent, false);
                holder = new ViewHolder();
                holder.imageView = convertView.findViewById(R.id.testimage);
                holder.textView = convertView.findViewById(R.id.testtext2);
                holder.textView2 = convertView.findViewById(R.id.testtext1);
                holder.button = convertView.findViewById(R.id.buybutton);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            HashMap<String, Object> item = mData.get(position);
            holder.imageView.setImageBitmap((Bitmap) item.get("img_desc"));
            holder.textView.setText((String) item.get("img_type"));
            holder.textView2.setText((String) item.get("img_descri"));

            // Vérifiez le type de données pour décider d'afficher ou de masquer le bouton "buy"
            Object itemType = item.get("img_type");
            if (itemType instanceof String && !TextUtils.isEmpty((String) itemType)) {
                holder.button.setVisibility(View.VISIBLE); // Afficher le bouton
            } else {
                holder.button.setVisibility(View.GONE); // Masquer le bouton
            }

            holder.button.setOnClickListener(v -> {
                // Faire quelque chose lorsque le bouton est cliqué pour cet élément de la liste
                Intent intent = new Intent(mContext, Eshop.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // Ajoutez le drapeau FLAG_ACTIVITY_NEW_TASK
                mContext.startActivity(intent);

            });

            return convertView;
        }

        static class ViewHolder {
            ImageView imageView;
            TextView textView;
            TextView textView2;
            Button button;
        }
    }

    public void connectUser() {
        Map<String, String> params = new HashMap<>();
        params.put("img_type", TextileType);
        JSONObject parameters = new JSONObject(params);

        String url = "https://www.lemarchedescrateurs.ch/createusers/action/testReception.php";
        @SuppressLint("ResourceType") JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, parameters,
                response -> {
                    // Traitement de la réponse JSON
                    try {
                        JSONArray rows = response.getJSONArray("rows");
                        // Envoi des lignes à une autre activité

                        String table = rows.toString();
                        String table2 = table.replaceAll("[{}\\s]", "");
                        String table3 = table2.replaceAll("^\\[|\"\\]$", "");

                        String[] tableauString = table3.split(",");
                        ArrayList<HashMap<String, Object>> data = new ArrayList<>();
                        for (String element : tableauString) {
                            String[] keyValue = element.split(":");
                            if (keyValue.length == 2) {
                                String key = keyValue[0].replaceAll("^\"|\"$", "");
                                String value = keyValue[1].replaceAll("^\"|\"$", "");
                                // Créez une nouvelle instance de HashMap pour chaque groupe de données
                                HashMap<String, Object> map = new HashMap<>();
                                if (key.equals("img_desc")) {
                                    // Si la clé est "img_desc", chargez l'image en tant que bitmap
                                    byte[] decodedString = Base64.decode(value, Base64.DEFAULT);
                                    Bitmap bitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                                    map.put("img_desc", bitmap);
                                } else {
                                    // Sinon, ajoutez la paire clé-valeur à la HashMap
                                    map.put(key, value);
                                }
                                // Ajoutez cette instance de HashMap à la liste data
                                data.add(map);
                            } else {
                                Toast.makeText(getApplicationContext(), table, Toast.LENGTH_LONG).show();
                            }
                        }

                        // Créer une instance de l'adaptateur personnalisé
                        ImageTextListAdapter adapter = new ImageTextListAdapter(getApplicationContext(), data);

                        // Associer l'adaptateur à la ListView
                        ListView listView = findViewById(R.id.list_view2);
                        if (listView != null) {
                            listView.setDivider(getResources().getDrawable(R.xml.list_separator));
                            listView.setDividerHeight(1);
                            listView.setAdapter(adapter);
                        } else {
                            Toast.makeText(getApplicationContext(), "listview null", Toast.LENGTH_LONG).show();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    // Traitement de l'erreur
                    Toast.makeText(getApplicationContext(), "erreur de connexion au serveur !!", Toast.LENGTH_LONG).show();
                });
        mDatabaseManager.queue.add(request);
    }

}