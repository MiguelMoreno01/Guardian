package com.example.guardianapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class getLocation extends AppCompatActivity {

    Button location, confirmation;
    TextView textView1, textView2, textView3, textView4, textView5;
    FusedLocationProviderClient fusedLocationProviderClient;
    private String state;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_location);
        location = findViewById(R.id.findLocation);
        textView1 = findViewById(R.id.text_view1);
        textView2 = findViewById(R.id.text_view2);
        textView3 = findViewById(R.id.text_view3);
        textView4 = findViewById(R.id.text_view4);
        textView5 = findViewById(R.id.text_view5);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(getLocation.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                    getCurrentLocation();

                } else {
                    ActivityCompat.requestPermissions(getLocation.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }
            }

        });
        confirmation = (Button) findViewById(R.id.confirmation);
        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //city = cityInput.getText().toString();
                openDataofState();
            }
        });
    }

    private void getCurrentLocation() {
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location != null) {
                    try {
                        Geocoder geocoder = new Geocoder(getLocation.this,
                                Locale.getDefault());
                        List<Address> addresses = geocoder.getFromLocation(
                                location.getLatitude(), location.getLongitude(), 1
                        );
                        textView1.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Latitude :</b><br></font>"
                                        + addresses.get(0).getLatitude()
                        ));
                        textView2.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Longitude :</b><br></font>"
                                        + addresses.get(0).getLatitude()
                        ));
                        textView3.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Postal Code :</b><br></font>"
                                        + addresses.get(0).getPostalCode()
                        ));
                        textView4.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Locality :</b><br></font>"
                                        + addresses.get(0).getAdminArea()
                        ));
                        state = addresses.get(0).getAdminArea();
                        state = getAbre(state);
                        textView5.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Address :</b><br></font>"
                                        + addresses.get(0).getAddressLine(0)
                        ));


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    public void openDataofState() {
        Intent intent = new Intent(this, DataofState.class);
        intent.putExtra("State", state);
        startActivity(intent);
    }
    public String getAbre(String abr) {
        if (abr.equals("Alabama")) {
            return "AL";
        } else if (abr.equals("Alaska")) {
            return "AK";
        } else if (abr.equals("Arizona")) {
            return "AZ";
        } else if (abr.equals("Arkansas")) {
            return "AR";
        } else if (abr.equals("California")) {
            return "CA";
        } else if (abr.equals("Colorado")) {
            return "CO";
        } else if (abr.equals("Connecticut")) {
            return "CT";
        } else if (abr.equals("Delaware")) {
            return "DE";
        } else if (abr.equals("Georgia")) {
            return "GA";
        } else if (abr.equals("Florida")) {
            return "FL";
        } else if (abr.equals("Hawaii")) {
            return "HI";
        } else if (abr.equals("Idaho")) {
            return "ID";
        } else if (abr.equals("Illinois")) {
            return "IL";
        } else if (abr.equals("Iowa")) {
            return "IA";
        } else if (abr.equals("Indiana")) {
            return "IN";
        } else if (abr.equals("Kansas")) {
            return "KS";
        } else if (abr.equals("Kentucky")) {
            return "KY";
        } else if (abr.equals("Louisiana")) {
            return "LA";
        } else if (abr.equals("Maine")) {
            return "ME";
        } else if (abr.equals("Maryland")) {
            return "MD";
        } else if (abr.equals("Massachusetts")) {
            return "MA";
        } else if (abr.equals("Michigan")) {
            return "MI";
        } else if (abr.equals("Minnesota")) {
            return "MN";
        } else if (abr.equals("Mississippi")) {
            return "MS";
        } else if (abr.equals("Missouri")) {
            return "MO";
        } else if (abr.equals("Montana")) {
            return "MT";
        } else if (abr.equals("Nebraska")) {
            return "NE";
        } else if (abr.equals("Nevada")) {
            return "NV";
        } else if (abr.equals("New Hampshire")) {
            return "NH";
        } else if (abr.equals("New Jersey")) {
            return "NJ";
        } else if (abr.equals("New Mexico")) {
            return "NM";
        } else if (abr.equals("New York")) {
            return "NY";
        } else if (abr.equals("North Carolina")) {
            return "NC";
        } else if (abr.equals("North Dakota")) {
            return "ND";
        } else if (abr.equals("Ohio")) {
            return "OH";
        } else if (abr.equals("Oklahoma")) {
            return "OK";
        } else if (abr.equals("Oregon")) {
            return "OR";
        } else if (abr.equals("Pennsylvania")) {
            return "PA";
        } else if (abr.equals("Rhode Island")) {
            return "RI";
        } else if (abr.equals("South Carolina")) {
            return "SC";
        } else if (abr.equals("South Dakota")) {
            return "SD";
        } else if (abr.equals("Tennessee")) {
            return "TN";
        } else if (abr.equals("Texas")) {
            return "TX";
        }else if (abr.equals("Utah")) {
            return "UT";
        } else if (abr.equals("Vermont")) {
            return "VT";
        } else if (abr.equals("Virginia")) {
            return "VA";
        } else if (abr.equals("Washington")) {
            return "WA";
        } else if (abr.equals("West Virginia")) {
            return "WV";
        } else if (abr.equals("Wisconsin")) {
            return "WI";
        } else if (abr.equals("Wyoming")) {
            return "WY";
        }
        return "Inserted Unknown State Abreviation";
    }
}
