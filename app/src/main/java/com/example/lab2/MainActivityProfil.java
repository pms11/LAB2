package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivityProfil extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profil);
    }
    public void SetTeamIcon(View view){
        Intent returnIntent=new Intent();
        ImageView selectedImage=(ImageView)view;
        returnIntent.putExtra("imageID",selectedImage.getId());
        setResult(RESULT_OK,returnIntent);
        finish();
    }


}

