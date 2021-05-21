package com.example.CovidInfo.activities;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.CovidInfo.R;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//
//    public static class GetExample {
//        OkHttpClient client = new OkHttpClient();
//
//        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//        String run(String url) throws IOException {
//            Request request = new Request.Builder()
//                    .url(url)
//                    .build();
//
//            try (Response response = client.newCall(request).execute()) {
//                return response.body().string();
//            }
//        }
//
//        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//        public static void main(String[] args) throws IOException {
//            GetExample example = new GetExample();
//            String response = example.run("https://www.health.go.ug/covid/");
//            System.out.println(response);
//        }
//    }
}