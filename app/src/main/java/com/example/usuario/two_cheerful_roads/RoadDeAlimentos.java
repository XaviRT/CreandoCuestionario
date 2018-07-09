package com.example.usuario.two_cheerful_roads;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

//import javax.annotation.Nullable;

public class RoadDeAlimentos extends AppCompatActivity {

    private static final String TAG = "RoadDeAlimentos";

    //public Button ejecutador;

    private int proridad;
    private int scoreQuiz;
    public String resp;

    public TextView scoreTextView;
    public TextView posicionQuizzes;
    public TextView preg;

    public Button chc1;
    public Button chc2;
    public Button chc3;
    public Button chc4;

    //LOS ADAPTADORES DE ARRAY QUE HARÁN FALTA.
    ArrayList<String> preguntasLs = new ArrayList<>();
    ArrayList <String> choice1Ls = new ArrayList<>();

    ArrayAdapter arrayAdapter;

    ListView listView;

    //VARIABLE "TYPEDEF" QUE HE CREADO PARA EL CUESTIONARIO.
    NutricionQuiz_1 cuestionario;

    SQLiteDatabase preguntasNutricionDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_de_alimentos);

        /*posicionQuizzes = findViewById(R.id.textoV6);

        preg = findViewById(R.id.preguntiitaa);*/

        /*chc1 = findViewById(R.id.Optn1);
        chc2 = findViewById(R.id.Optn2);
        chc3 = findViewById(R.id.Optn3);
        chc4 = findViewById(R.id.Optn4);*/

        listView = findViewById(R.id.listaContenidos);

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, preguntasLs);

        listView.setAdapter(arrayAdapter);

        scoreTextView = findViewById(R.id.textoV5);

        preguntasNutricionDB = this.openOrCreateDatabase("PregNutricion", MODE_PRIVATE, null);

        preguntasNutricionDB.execSQL("CREATE TABLE IF NOT EXISTS pregNutricion (id INTEGER PRIMARY KEY, pregunta VARCHAR, choice1 VARCHAR, choice2 VARCHAR, choice3 VARCHAR, choice4 VARCHAR, respuesta VARCHAR)");

        obtenElementosDB();

        DownloadTask task = new DownloadTask();
        task.execute("https://api.myjson.com/bins/vteyy");
    }

    public void obtenElementosDB() {

        try {

            Cursor c = preguntasNutricionDB.rawQuery("SELECT * FROM pregNutricion", null);

            int preguntasIndex = c.getColumnIndex("pregunta");
            //int choice1Index = c.getColumnIndex("choice1");

            if (c.moveToFirst()) {
                preguntasLs.clear();

                //choice1Ls.clear();

                do {
                    preguntasLs.add(c.getString(preguntasIndex));
                    //choice1Ls.add(c.getString(choice1Index));
                } while (c.moveToNext());

                arrayAdapter.notifyDataSetChanged();
            }

           /* c.moveToFirst();
                Log.i("LA OPCIÓN 1 ES -> ", c.getString(choice1Index));

                    c.moveToNext();
                    Log.i("LA OPCIÓN 1 PRÓXM -> ", c.getString(choice1Index));*/


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            String resultado = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {

                url = new URL(strings[0]);

                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();
                int aparicionesEnTry = 0;

                Log.i("APARICIONES AQUÍ -> ", String.valueOf(aparicionesEnTry));

                while (data != -1) {

                    char current = (char) data;

                    resultado += current;

                    data = reader.read();

                    }

                Log.i("URLContenido", resultado);

                JSONObject object = new JSONObject(resultado);

                String opt3 = object.getString("questions");

                Log.i("Opcciioon 3", opt3);

                JSONArray array = new JSONArray(opt3);

                String elemt = "";
                String elemt2 = "";
                String elemt3 = "";
                String elemt4 = "";
                String elemt5 = "";
                String elemt6 = "";
                int aparicionesEnFor = 0;

                for (int i = 0; i < array.length(); i++) {

                    JSONObject jsonPart = array.getJSONObject(i);

                    elemt = jsonPart.getString("pregunta");
                    elemt2 = jsonPart.getString("choice1");
                    elemt3 = jsonPart.getString("choice2");
                    elemt4 = jsonPart.getString("choice3");
                    elemt5 = jsonPart.getString("choice4");
                    elemt6 = jsonPart.getString("answer");

                    Log.i("pregunta", jsonPart.getString("pregunta"));
                    Log.i("choice1", jsonPart.getString("choice1"));
                    Log.i("choice2", jsonPart.getString("choice2"));
                    Log.i("choice3", jsonPart.getString("choice3"));
                    Log.i("choice4", jsonPart.getString("choice4"));
                    Log.i("answer", jsonPart.getString("answer"));

                    aparicionesEnFor++;
                    Log.i("APARICIONES EN FOR -> ", String.valueOf(aparicionesEnFor));
                }

                String sql = "INSERT INTO pregNutricion (pregunta, choice1, choice2, choice3, choice4, respuesta) VALUES (? , ? , ? , ? , ? , ?)";

                SQLiteStatement statement = preguntasNutricionDB.compileStatement(sql);

                statement.bindString(1, elemt);
                statement.bindString(2, elemt2);
                statement.bindString(3, elemt3);
                statement.bindString(4, elemt4);
                statement.bindString(5, elemt5);
                statement.bindString(6, elemt6);
                //ESTO ES UN TEST
                statement.execute();


            } catch (JSONException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            obtenElementosDB();

        }
    }
}






