package com.example.CovidInfo.activities;

import android.animation.ValueAnimator;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.CovidInfo.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView welcome = findViewById(R.id.txthello);
        TextView textView = findViewById(R.id.welcome);
        recoverAnimator();
        casesAnimator();
        deathAnimator();
                String emailFromIntent = getIntent().getStringExtra("EMAIL");
        welcome.setText("Welcome ," +emailFromIntent);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = null;
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        textView.setText("Home fragment");
                        Toast.makeText(getApplicationContext(),"Home Fragment",Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.navigation_vaccination:
                        Toast.makeText(getApplicationContext(),"Vaccination Fragment",Toast.LENGTH_LONG).show();
                        textView.setText("Vaccination  fragment");
                        return true;
                    case R.id.navigation_Help:
                        Toast.makeText(getApplicationContext(),"Help Fragment",Toast.LENGTH_LONG).show();
                        textView.setText("Help fragment");
                        return true;
                    case R.id.navigation_users:
                        Toast.makeText(getApplicationContext(),"User Fragment",Toast.LENGTH_LONG).show();
                        textView.setText("Users fragment");
                        return true;
                }
                return false;
            }
        };


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