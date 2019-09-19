package com.yamur.tatlryalar;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.media.MediaPlayer;
import java.util.concurrent.TimeUnit;


public class MPlayer extends Activity {
    private Button b1,b2,b3,b4;
    //MediaPlayer nesnesi oluşturmak için tanımlanır
    private MediaPlayer mediaPlayer;

    private int songId;
    private double startTime = 0;
    private double finalTime = 0;

    private Handler myHandler = new Handler();
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    private SeekBar seekbar;
    private TextView tx1,tx2,tx3;

    public static int oneTimeOnly = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mplayer);
        //verilerin diğer sayfadan çekilmesi
        Bundle extras = getIntent().getExtras();
        final String msg = extras.getString("Msg");
        final String isim = extras.getString("isim");

        //layouttaki ögelerin değişkenlere atanması
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);

        tx1 = (TextView)findViewById(R.id.textView2);
        tx2 = (TextView)findViewById(R.id.textView3);
        tx3 = (TextView)findViewById(R.id.textView4);
        tx3.setText(isim);

        //çalınacak parçanın dosyadaki indexini, ismi yoluyla almak
        songId = this.getRawResIdByName(msg);
        //id ile şarkıyla ilgili mediaplayer nesnesinin oluşturulması
        mediaPlayer = MediaPlayer.create(this, songId);
        seekbar = (SeekBar)findViewById(R.id.seekBar);
        seekbar.setClickable(false);
        b2.setEnabled(false);

        //mediaplayer'ı çalıştıracak butonun kodları
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Parça çalınıyor",Toast.LENGTH_SHORT).show();
                        mediaPlayer.start();

                //Parçanın süresi bitiş süresine atanır
                finalTime = mediaPlayer.getDuration();
                //Parçanın anlık durumu başlangıç değişkenine atanır
                startTime = mediaPlayer.getCurrentPosition();

                //Seekbar'ın uzunluğunu şarkının uzunluğuna göre ayarlanmasını sağlar
                if (oneTimeOnly == 0) {
                    seekbar.setMax((int) finalTime);
                    oneTimeOnly = 1;
                }

                //parçanın uzunluğunun string formatına döndürülmesi
                tx2.setText(String.format("%d dk, %d sn",
                        TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                        finalTime)))
                );
                //parçanın anlık konumunun string formatına döndürülmesi
                tx1.setText(String.format("%d dk, %d sn",
                        TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                        startTime)))
                );
                //seekbarın anlık konumunun şarkının anlık konumuna göre ayarlanması
                seekbar.setProgress((int)startTime);
                myHandler.postDelayed(UpdateSongTime,100);
                b2.setEnabled(true);
                b3.setEnabled(false);
            }
        });

        //Durdurma butonunun kodları
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Parça Durduruldu",Toast.LENGTH_SHORT).show();
                //MediaPlayer durdurulur
                        mediaPlayer.pause();

                //Dur butonuna kitlenir, oynat butonu açılır
                b2.setEnabled(false);
                b3.setEnabled(true);
            }
        });

        //Parça 5 sn ileri alınır
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)startTime;

                if((temp+forwardTime)<=finalTime){
                    startTime = startTime + forwardTime;
                    mediaPlayer.seekTo((int) startTime);
                    Toast.makeText(getApplicationContext(),"5 sn ileri gidildi",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"İleri alınamaz",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Parça 5 sn geri alınır
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)startTime;

                if((temp-backwardTime)>0){
                    startTime = startTime - backwardTime;
                    mediaPlayer.seekTo((int) startTime);
                    Toast.makeText(getApplicationContext(),"5 saniye geri gidildi",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Geri alınamaz",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //şarkının ismiyle raw dosyasından indexinin çekilmesini sağlayan metod
    private int getRawResIdByName(String resName){
        String pkgName=this.getPackageName();
        int resID=this.getResources().getIdentifier(resName,"raw",pkgName);
        return resID;
    }

    //Parçanın anlık hangi saniyede olduğunu çeken metod
    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            tx1.setText(String.format("%d dk, %d sn",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            //Seekbar'ın ilerlemesini parçanın süresine göre ayarlama
            seekbar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };
}