package com.example.CovidInfo.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

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
        TextView news = findViewById(R.id.news);
        TextView txthello  = findViewById(R.id.txthello);


        String emailFromIntent = getIntent().getStringExtra("EMAIL");
        txthello.setText(emailFromIntent);
        casesAnimator();
        recoverAnimator();
        deathAnimator();


         class GetExample {
            OkHttpClient client = new OkHttpClient();

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            String run(String url) throws IOException {
                Request request = new Request.Builder()
                        .url(url)
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    return response.body().string();
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void main(String[] args) throws IOException {
                GetExample example = new GetExample();
                String response = example.run("https://www.health.go.ug/covid/");
                //System.out.println(response);
                news.setText(response);
            }
        }
    }

    public void casesAnimator(){
        TextView cases = findViewById(R.id.txtcases);
        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues(0, 43734);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                cases.setText(String.valueOf(animation.getAnimatedValue()));
            }
        });
        animator.setDuration(10000); // here you set the duration of the anim
        animator.start();

    }
    public void recoverAnimator(){
        TextView recovered = findViewById(R.id.txtrecover);
        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues(0, 15147);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                recovered.setText(String.valueOf(animation.getAnimatedValue()));
            }
        });
        animator.setDuration(10000); // here you set the duration of the anim
        animator.start();

    }
    public void deathAnimator(){
        TextView death = findViewById(R.id.textdeath);
        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues(0, 357);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                death.setText(String.valueOf(animation.getAnimatedValue()));
            }
        });
        animator.setDuration(10000); // here you set the duration of the anim
        animator.start();

    }
}