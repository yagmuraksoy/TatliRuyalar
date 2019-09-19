package com.yamur.tatlryalar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Layoutun ayarlanması
        setContentView(R.layout.activity_main);

        //layouttaki değişkenlerin id ile değişkenlere atanması
        ImageButton masalBtn = (ImageButton) findViewById(R.id.masalBtn);
        ImageButton muzikBtn = (ImageButton) findViewById(R.id.muzikBtn);
        //butona basıldığında çalışacak kodlar
        masalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Sayfa geçişinin ayarlanması(ilgili sayfa, gidilecek sayfa)
                Intent goTo = new Intent(MainActivity.this, Masal.class);
                startActivity(goTo);
            }
        });

        muzikBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goTo = new Intent(MainActivity.this, Muzik.class);
                startActivity(goTo);
            }
        });
    }
}
