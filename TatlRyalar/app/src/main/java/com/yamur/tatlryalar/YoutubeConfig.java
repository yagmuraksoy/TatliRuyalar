package com.yamur.tatlryalar;

import java.security.Key;

public class YoutubeConfig {
   public YoutubeConfig()
   {

   }
    // Developers Google aracılığıyla bağlanılan youtube api'den alınan key yazılır
    private static final String API_KEY = " "; //boşluğa api key'i yazınız
    // bu metod çağırıldığında api key dönecek 
    public static String getApiKey() {
        return API_KEY;
    }
}
