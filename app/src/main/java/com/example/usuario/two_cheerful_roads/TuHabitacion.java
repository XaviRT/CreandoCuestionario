package com.example.usuario.two_cheerful_roads;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TuHabitacion extends AppCompatActivity {

    TextView posicion;

    Button desplazarAQuiz;

    boolean estaActuandoTimer;

    CountDownTimer cuentaRegresiva;
    TextView tiempoRestante;

    public static final long TIEMPO_EN_MILLIS = 600000;

    public long timeLeftInMillis = TIEMPO_EN_MILLIS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tu_habitacion);


        posicion = findViewById(R.id.posicionHabitacion);

        desplazarAQuiz = findViewById(R.id.movimOtraActiv);

        tiempoRestante = findViewById(R.id.textoTimer);

        empiezaTimer();

        String obtenerVarb = getIntent().getStringExtra("EstadoApp");

        posicion.setText(obtenerVarb);

        desplazarAQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent roomToRoad = new Intent(TuHabitacion.this, RoadDeAlimentos.class);
                startActivity(roomToRoad);
            }
        });
    }

    public void empiezaTimer() {
        cuentaRegresiva = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }
                .start();
        estaActuandoTimer = true;
    }

     public void updateTimer (){
            int minutos = (int) timeLeftInMillis / 60000;
            int segundos = (int) timeLeftInMillis % 60000 / 1000;

            String timeLeftText;

            timeLeftText = "" + minutos;
            timeLeftText += ":";
            if (segundos < 10) timeLeftText += "0";
            timeLeftText += segundos;

            tiempoRestante.setText(timeLeftText);
    }
}
