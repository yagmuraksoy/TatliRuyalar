package com.yamur.tatlryalar;

//Kütüphane tanımlamaları
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Muzik extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Layout tanımlanır
        setContentView(R.layout.muzik);

        //Gerekli ögeler layout sayfasından id ile çekilip burada atanır
        Button kirmizi = (Button) findViewById(R.id.btnKirmizi);
        Button shark = (Button) findViewById(R.id.btnShark);
        Button kedi = (Button) findViewById(R.id.btnKedi);
        Button cirkin = (Button) findViewById(R.id.btnCirkin);
        Button gatto = (Button) findViewById(R.id.btnGatto);


        //Butonların çalışma kodları
        kirmizi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Sonraki sayfaya geçiş(ilgili sayfa, gidilecek sayfa)
                Intent i = new Intent(Muzik.this, MPlayer.class);
                //çalınacak parçanın dosyadaki adı intent ile gönderilir
                i.putExtra("Msg", "kirmizi");
                //çalınacak parçanın gösterilecek adı intent ile gönderilir
                i.putExtra("isim", "Kırmızı Balık");
                //Geçiş sağlanır
                startActivity(i);
            }
        });
        shark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Muzik.this, MPlayer.class);
                i.putExtra("Msg", "babyshark");
                i.putExtra("isim", "Baby Shark");
                startActivity(i);
            }
        });
        kedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Muzik.this, MPlayer.class);
                i.putExtra("Msg", "kedi");
                i.putExtra("isim", "Çizmeli Kedi");
                startActivity(i);
            }
        });
        gatto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Muzik.this, MPlayer.class);
                i.putExtra("Msg", "gatto");
                i.putExtra("isim", "Il Gatto Con Gli Stivali");
                startActivity(i);
            }
        });
        cirkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Muzik.this, MPlayer.class);
                i.putExtra("Msg", "cirkin");
                i.putExtra("isim", "Çirkin Ördek Yavrusu");
                startActivity(i);
            }
        });
    }
}
