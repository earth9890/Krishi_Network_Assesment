package com.example.projectkrishi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UserProfile extends AppCompatActivity {
TextView Email,Name;
Bitmap Photo; ImageView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Email = findViewById(R.id.emailUser);
        Name = findViewById(R.id.nameUser);
        view = findViewById(R.id.viewImage1);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Name.setText(name);
        String email = intent.getStringExtra("email");
        Email.setText(email);
    Photo = (Bitmap) intent.getExtras().get("image");
       view.setImageBitmap(Photo);
        Toast.makeText(getApplicationContext(),"Welcome " + name + " your profile created successfully. ",Toast.LENGTH_SHORT).show();

    }
}