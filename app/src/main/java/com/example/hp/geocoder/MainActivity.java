package com.example.hp.geocoder;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText latitude,longitude;
    Button button;
    Geocoder geocoder;
    List<Address> addresses;

    Double lat;
    Double lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        latitude=findViewById(R.id.latitude);
        longitude=findViewById(R.id.longitude);
        button=findViewById(R.id.button);
    }

    public void onClickAct(View view) {
        geocoder=new Geocoder(this, Locale.getDefault());
        lat= Double.valueOf(latitude.getText().toString());
        lng= Double.valueOf(longitude.getText().toString());
        try {
            addresses=geocoder.getFromLocation(lat,lng,1);
            if (addresses.size() != 0) {

                String address = addresses.get(0).getAddressLine(0);
                textView.setText(address);
            }
            else
                Toast.makeText(this,"not found ",Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
