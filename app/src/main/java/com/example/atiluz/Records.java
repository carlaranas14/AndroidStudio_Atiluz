package com.example.atiluz;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Arrays;
import java.util.List;

public class Records extends AppCompatActivity {

    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_records);

        nav = findViewById(R.id.nav);
        nav.setSelectedItemId(R.id.records);

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.pickup:
                        startActivity(new Intent(Records.this, DriverDashboard.class));
                        break;
                    case R.id.records:
                        break;
                    case R.id.driver_chat:
                        startActivity(new Intent(Records.this, DriverChat.class));
                        break;
                    case R.id.profile:
                        startActivity(new Intent(Records.this, Profile.class));
                        break;
                    default:
                        return false;
                }
                item.setChecked(true);
                return true;
            }
        });

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager = findViewById(R.id.viewPager);

        List<Integer> layouts = Arrays.asList(
                R.layout.activity_driver_record_ongoing,
                R.layout.activity_driver_record_completed,
                R.layout.activity_driver_record_cancelled
        );

        // Set up the adapter
        ViewPagerAdapterRecordTab pagerAdapter = new ViewPagerAdapterRecordTab(this, layouts);
        viewPager.setAdapter(pagerAdapter);

        // Link TabLayout with ViewPager2
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("On Going");
                            break;
                        case 1:
                            tab.setText("Completed");
                            break;
                        case 2:
                            tab.setText("Cancelled");
                            break;
                    }
                }).attach();
    }
}