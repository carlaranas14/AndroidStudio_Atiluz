package com.example.atiluz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdminVehicleEdit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_vehicle_edit);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button backBtn = findViewById(R.id.backBtn),
                nextBtn = findViewById(R.id.nextBtn);

        backBtn.setOnClickListener(v -> {
            finish();
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminVehicleEdit.this, AdminDriverEdit.class);
                startActivity(intent);
            }
        });
    }
}