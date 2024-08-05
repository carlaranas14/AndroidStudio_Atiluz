package com.example.atiluz;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Profile extends AppCompatActivity {

    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        nav = findViewById(R.id.nav);
        nav.setSelectedItemId(R.id.profile);

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.pickup:
                        startActivity(new Intent(Profile.this, DriverDashboard.class));
                        return true;
                    case R.id.records:
                        startActivity(new Intent(Profile.this, Records.class));
                        return true;
                    case R.id.driver_chat:
                        startActivity(new Intent(Profile.this, DriverChat.class));
                        return true;
                    case R.id.profile:
                        return true;
                    default:
                        return false;
                }
            }
        });

        TextView helpCenter = findViewById(R.id.helpCenter);

        helpCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, HelpCenter.class));
            }
        });

        TextView vehicleInfo = findViewById(R.id.vehicleInfo);

        vehicleInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, DriverVehicleInfo.class));
            }

            });

        TextView logout = findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, Login.class));
            }

        });
    }
}