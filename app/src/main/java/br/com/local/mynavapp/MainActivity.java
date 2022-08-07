package br.com.local.mynavapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectFragment = null;

            switch (item.getItemId()) {
                case R.id.mFav:
                    selectFragment = new FavoriteFragment();
                    break;
                case R.id.mMusic:
                    selectFragment = new MusicFragment();
                    break;
                case R.id.mPlaces:
                    selectFragment = new PlaceFragment();
                    break;
                case R.id.mNewsPaper:
                    selectFragment = new NewsPaperFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectFragment).commit();

            return true;
        }
    };
}