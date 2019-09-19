package com.yamur.tatlryalar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//Youtube api ile ilgili kütüphaneler
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class PlayerY extends YouTubeBaseActivity {
    //Youtube'dan çekilen videonun gösterileceği player
    YouTubePlayerView yTPW;
    Button btnPlay;
    //Youtube'un başlatılması için kullanılacak listener
    YouTubePlayer.OnInitializedListener yOIL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Layout ayarlanması
        setContentView(R.layout.playery);
        //intentle önceki sayfadan gönderilen verilerin alınması
        Bundle extras = getIntent().getExtras();
        final String msg = extras.getString("Msg");

        btnPlay = (Button) findViewById(R.id.btnPlay);
        yTPW = (YouTubePlayerView) findViewById(R.id.youtubePlay);

        //youtube player başlatıldığında çalışacak
        yOIL = new YouTubePlayer.OnInitializedListener() {
            //başlatma başarılıysa çalışacak. Provider youtube player instance getirir
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                //playera video yükler
                youTubePlayer.loadVideo(msg, 0);
            }
            //hata varsa çalışacak
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        //play tuşuna basıldığında YouTubePlayerView, YoutubeConfig sayfasına kaydedilmiş key ile videoyu başlatacak
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yTPW.initialize(YoutubeConfig.getApiKey(), yOIL);

            }
        });
    }
}

