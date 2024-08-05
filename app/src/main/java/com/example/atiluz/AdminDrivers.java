package com.example.atiluz;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class AdminDrivers extends AppCompatActivity {

    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_drivers);

        nav = findViewById(R.id.nav);
        nav.setSelectedItemId(R.id.drivers);

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.database:
                        startActivity(new Intent(AdminDrivers.this, AdminDashboard.class));
                        break;
                    case R.id.passengers:
                        startActivity(new Intent(AdminDrivers.this, AdminPassengers.class));
                        break;
                    case R.id.drivers:
                        break;
                    case R.id.profileAdmin:
                        startActivity(new Intent(AdminDrivers.this, AdminProfile.class));
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