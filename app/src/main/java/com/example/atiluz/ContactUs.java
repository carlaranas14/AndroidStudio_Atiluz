package com.example.atiluz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class ContactUs extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout customer_dashboard, booking, tracking, contact, logout, chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contact_us);

        TextView textView = findViewById(R.id.contactFB);
        textView.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());

        TextView textView2 = findViewById(R.id.contactAddress);
        textView2.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());

        drawerLayout = findViewById(R.id.drawer_layout);
        menu = findViewById(R.id.menu);
        customer_dashboard = findViewById(R.id.customer_dashboard);
        chat = findViewById(R.id.chat);
        booking = findViewById(R.id.booking);
        tracking = findViewById(R.id.tracking);
        contact = findViewById(R.id.contact);
        logout = findViewById(R.id.logout);

        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openDrawer(drawerLayout);
            }
        });

        customer_dashboard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                redirectActivity(ContactUs.this, CustomerDashboard.class);
            }
        });
        booking.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                redirectActivity(ContactUs.this, Booking.class);
            }
        });
        chat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                redirectActivity(ContactUs.this, Chat.class);
            }
        });
        tracking.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                redirectActivity(ContactUs.this, Tracking.class);
            }
        });

        contact.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                recreate();
            }
        });

        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                redirectActivity(ContactUs.this, Login.class);
            }
        });
    }
    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public static void closeDrawer(DrawerLayout drawerLayout){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public static void redirectActivity(Activity activity, Class secondActivity){
        Intent intent = new Intent(activity, secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}