package com.example.atiluz;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class DriverChat extends AppCompatActivity {

    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_driver_chat);

        nav = findViewById(R.id.nav);
        nav.setSelectedItemId(R.id.driver_chat);

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.pickup:
                        startActivity(new Intent(DriverChat.this, DriverDashboard.class));
                        return true;
                    case R.id.records:
                        startActivity(new Intent(DriverChat.this, Records.class));
                        return true;
                    case R.id.driver_chat:
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(DriverChat.this, Profile.class));
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
}