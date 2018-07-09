package com.example.usuario.two_cheerful_roads;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int estado;

    TextView posicion;

    TextView tuUser;
    EditText usuario;
    TextView tuContraseña;
    EditText contraseña;
    TextView tuCorreo;
    EditText correo;


    Button pasarActiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        posicion = findViewById(R.id.posicionInicio);
        pasarActiv = findViewById(R.id.botttton);

        estado = 0;

        posicion.setText((String.valueOf(estado)));

        pasarActiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent moveToQuiz = new Intent (MainActivity.this, TuHabitacion.class);
            estado = estado + 1;
            moveToQuiz.putExtra("EstadoApp", String.valueOf(estado));
            startActivity(moveToQuiz);
            }
        });
    }


}
