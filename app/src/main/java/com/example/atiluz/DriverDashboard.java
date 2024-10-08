package com.example.atiluz;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class DriverDashboard extends AppCompatActivity {

    BottomNavigationView nav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_driver_dashboard);

        nav = findViewById(R.id.nav);

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.pickup:
                        break;
                    case R.id.records:
                        startActivity(new Intent(DriverDashboard.this, Records.class));
                        break;
                    case R.id.driver_chat:
                        startActivity(new Intent(DriverDashboard.this, DriverChat.class));
                        break;
                    case R.id.profile:
                        startActivity(new Intent(DriverDashboard.this, Profile.class));
                        break;
                    default:
                        return false;
                }
                item.setChecked(true);
                return true;
            }
        });
    }
}
