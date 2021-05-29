package com.alfabank.alfakey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDevice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_device);
    }

    public void settingsButton (View view){
        Intent mainIntent = new Intent(this, SettingsActivity.class);
        this.startActivity(mainIntent);
    }

    public void findDevice (View view){
        Intent mainIntent = new Intent(this, DeviceList.class);
        this.startActivity(mainIntent);
    }
}