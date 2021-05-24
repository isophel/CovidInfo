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
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.CovidInfo.R;

public class HomeActivity extends AppCompatActivity {
private  TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView welcome = findViewById(R.id.txthello);
         textView = findViewById(R.id.welcome);
         //methods for the animator
        recoverAnimator();
        casesAnimator();
        deathAnimator();
        String emailFromIntent = getIntent().getStringExtra("EMAIL");
        welcome.setText("Welcome ," + emailFromIntent);

        //Load Default home fragment
        loadFragment(new HomeFragment());
        //bottom navigation View
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    textView.setText("Home fragment");
                    fragment = new HomeFragment();
                    Toast.makeText(getApplicationContext(),"Home Fragment",Toast.LENGTH_LONG).show();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_vaccination:
                    textView.setText("Vaccine fragment");
                    Toast.makeText(getApplicationContext(),"vaccine Fragment",Toast.LENGTH_LONG).show();
                    fragment = new VaccineFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_Help:
                    textView.setText("Help fragment");
                    fragment = new HelpFragment();
                    Toast.makeText(getApplicationContext(),"Help Fragment",Toast.LENGTH_LONG).show();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_users:
                    textView.setText("user fragment");
                    fragment = new UserFragment();
                    Toast.makeText(getApplicationContext(),"User Fragment",Toast.LENGTH_LONG).show();
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };




    public void casesAnimator(){
        TextView cases = findViewById(R.id.txtcases);
        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues(0, 43734);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                cases.setText(String.valueOf(animation.getAnimatedValue()));
            }
        });
        animator.setDuration(10000); // here I set the duration of the anim
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
        animator.setDuration(10000); // here I set the duration of the anim
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
        animator.setDuration(10000); // here I set the duration of the anim
        animator.start();

    }
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}