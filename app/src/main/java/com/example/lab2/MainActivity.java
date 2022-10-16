package com.example.lab2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnsetAvatarButton(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivityProfil.class);
        startActivityForResult(intent, 0);
    }

    public void OnOpenInGoogleMaps(View view) {
        EditText teamAddres = (EditText) findViewById(R.id.teamAddressField);
        //Create a Uri from an intent string. Use the result to create an Intent.
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + teamAddres.getText());
        //Create an Intent from emmIntentUri. Set the action to ACTION_VIEW
        Intent MainActivityMap = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        // Make the Intent explicit by setting the Google Maps package
        MainActivityMap.setPackage("com.google.android.apps.maps");
        // Altempt to start an activity that can handle the Intent
        startActivity(MainActivityMap);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            return;
        }
        //Getting the Avatar Image we Show to our users
        ImageView avatarImage = (ImageView) findViewById(R.id.avatarImage);
        //Figuring out the correct image
        String drawableName = "ic_logo_00";
        switch (data.getIntExtra("imageID", R.id.teamid00)) {
            case R.id.teamid00:
                drawableName = "ic_logo_00";
                break;
            case R.id.teamid01:
                drawableName = "ic_logo_01";

                break;
            case R.id.teamid02:
                drawableName = "ic _logo_02";
                break;
            case R.id.teamid03:
                drawableName = "ic_logo_03";
                break;
            case R.id.teamid04:
                drawableName = "ic_logo_04";
                break;
            case R.id.teamid05:
                drawableName = "ic_logo_05";
                break;
            default:
                drawableName = "ic_logo_00";
                break;
        }
        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        avatarImage.setImageResource(resID);
    }
}


