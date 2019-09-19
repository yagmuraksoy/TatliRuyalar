package com.yamur.tatlryalar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Masal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Layout tanımlanır
        setContentView(R.layout.masal);

        //Gerekli ögeler layout sayfasından id ile çekilip burada atanır
        Button M1 = (Button) findViewById(R.id.btnM1);
        Button M2 = (Button) findViewById(R.id.btnM2);
        Button M3 = (Button) findViewById(R.id.btnM3);
        Button mu1 = (Button) findViewById(R.id.btnMu1);
        Button mu2 = (Button) findViewById(R.id.btnMu2);
        Button mu3 = (Button) findViewById(R.id.btnMu3);
        Button mu4 = (Button) findViewById(R.id.btnMu4);

        //Butona basıldığında çalışacak kodlar
        M1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Sonraki sayfaya geçiş(ilgili sayfa, gidilecek sayfa)
                Intent i = new Intent(Masal.this, PlayerY.class);
                //çalınacak videonun yotube'daki kodu
                i.putExtra("Msg", "o9OsRljQSbw");
                //Intentin başlatılması
                startActivity(i);
            }
        });

        M2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Masal.this, PlayerY.class);
                i.putExtra("Msg", "D3HCPEjqTIk");
                startActivity(i);
            }
        });

        M3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Masal.this, PlayerY.class);
                i.putExtra("Msg", "RT-EwqgHqCk");
                startActivity(i);
            }
        });

        mu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Masal.this, PlayerY.class);
                i.putExtra("Msg", "GMlwTgzPV1E");
                startActivity(i);
            }
        });

        mu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Masal.this, PlayerY.class);
                i.putExtra("Msg", "4ZWF5AVq0VE");
                startActivity(i);
            }
        });

        mu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Masal.this, PlayerY.class);
                i.putExtra("Msg", "l3KmseUFgok");
                startActivity(i);
            }
        });

        mu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Masal.this, PlayerY.class);
                i.putExtra("Msg", "BoknFW6n2o8");
                startActivity(i);
            }
        });
    }
}
