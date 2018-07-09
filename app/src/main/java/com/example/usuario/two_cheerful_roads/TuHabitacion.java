package com.example.usuario.two_cheerful_roads;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TuHabitacion extends AppCompatActivity {

    TextView posicion;

    Button desplazarAQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tu_habitacion);


        posicion = findViewById(R.id.posicionHabitacion);

        desplazarAQuiz = findViewById(R.id.movimOtraActiv);

        String obtenerVarb = getIntent().getStringExtra("EstadoApp");

        posicion.setText(obtenerVarb);

        desplazarAQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent roomToRoad = new Intent (TuHabitacion.this, RoadDeAlimentos.class);
                startActivity(roomToRoad);
            }
        });
    }
}
