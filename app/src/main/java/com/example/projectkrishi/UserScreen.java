package com.example.projectkrishi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import android.provider.MediaStore;
import android.view.View;

import android.widget.ImageView;

import android.util.Patterns;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserScreen extends AppCompatActivity {

    EditText etMail,name;
private final int CAMERA_REQ_CODE =100;
    TextView photoClick;
    // Button to validate the Email address
    TextView bValidate;
    int Flag = 0; Bitmap photo;

ImageView viewImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        // register all the UI elements
        // with their appropriate IDs
        etMail = findViewById(R.id.email);
        name = findViewById(R.id.name);
        bValidate = findViewById(R.id.submit);
        photoClick = findViewById(R.id.photoClick);
        viewImage = findViewById(R.id.viewImage1);
        photoClick.setOnClickListener(v -> {

            // Create the camera_intent ACTION_IMAGE_CAPTURE
            // it will open the camera for capture the image
            Intent camera_intent
                    = new Intent(MediaStore
                    .ACTION_IMAGE_CAPTURE);

            // Start the activity with camera_intent,
            // and request pic id
            startActivityForResult(camera_intent, CAMERA_REQ_CODE);
        });
      bValidate.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              int check = emailValidator(etMail);
              if(check == 1)
              {
                  Toast.makeText(getApplicationContext(),"Email Verified !" , Toast.LENGTH_SHORT).show();
                  Intent intent = new Intent(UserScreen.this,UserProfile.class);
                 intent.putExtra("image",photo);
                  String email = etMail.getText().toString();
                  String namee = name.getText().toString();
                  intent.putExtra("email",email);
                  intent.putExtra("name",namee);
                  Toast.makeText(getApplicationContext(),"Creating User Profile ! ",Toast.LENGTH_SHORT).show();
                  startActivity(intent);
              }
              else
              {
                  Toast.makeText(getApplicationContext(), "Enter valid Email address !", Toast.LENGTH_SHORT).show();
              }
          }
      });
    }

    // This method will help to retrieve the image
    protected void onActivityResult(int requestCode,int resultCode,
                                    Intent data) {

        // Match the request 'pic id with requestCode
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQ_CODE) {

            // BitMap is data structure of image file
            // which store the image in memory
             photo = (Bitmap) data.getExtras().get("data");

            // Set the image in imageview for display
            viewImage.setImageBitmap(photo);
        }
    }
    public int emailValidator(EditText etMail) {

        // extract the entered data from the EditText
        String emailToText = etMail.getText().toString();

        // Android offers the inbuilt patterns which the entered
        // data from the EditText field needs to be compared with
        // In this case the the entered data needs to compared with
        // the EMAIL_ADDRESS, which is implemented same below
        if (!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches()) {
            Toast.makeText(this, "Email Verified !", Toast.LENGTH_SHORT).show();
            Flag = 1;
        } else {
            Toast.makeText(this, "Enter valid Email address !", Toast.LENGTH_SHORT).show();
            Flag =0;
        }
        return Flag;
    }

}