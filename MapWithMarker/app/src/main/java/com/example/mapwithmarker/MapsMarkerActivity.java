
//The Android Open Source Project(2015) Android - Samples(V2)[Computer Software]
//https://github.com/googlemaps/android-samples[Accessed 29 March 2019]
//Licensed under the Apache License, Version 2.0 (the "License");
//http://www.apache.org/licenses/LICENSE-2.0

package com.example.mapwithmarker;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


import com.example.mapwithmarker.PermissionUtils;
import com.example.mapwithmarker.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



//Activity that shows the location of the user and the nightclubs in the surrounding area
public class MapsMarkerActivity extends AppCompatActivity
        implements GoogleMap.OnMyLocationButtonClickListener,
        OnMapReadyCallback,
        ActivityCompat.OnRequestPermissionsResultCallback{




    //Request code for location permission request
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;


    private boolean mPermissionDenied = false;
    private GoogleMap mMap;

    //When activity is created gets data from activity_maps.xml and creates the map
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_maps);
        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    //When the map is loaded it will be populated with markers as well as use a buttonClickListener
    //to set the users location
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Creating Nightclubs
        LatLng theAcademy = new LatLng(53.347992, -6.261025);
        googleMap.addMarker(new MarkerOptions().position(theAcademy).title("The Academy").snippet("Opening Times: 11:30a.m.-3:00a.m."));

        LatLng theGrandSocial = new LatLng(53.347070, -6.263255);
        googleMap.addMarker(new MarkerOptions().position(theGrandSocial).title("The Grand Social").snippet("Opening Times: 3:00p.m.–11:00p.m."));

        LatLng workmans = new LatLng(53.345225, -6.266558);
        googleMap.addMarker(new MarkerOptions().position(workmans).title("The Workman's Club").snippet("Opening Times: 5:00p.m.–3:00a.m."));

        LatLng copper = new LatLng(53.335134, -6.263317);
        googleMap.addMarker(new MarkerOptions().position(copper).title("Copper Face Jacks").snippet("Opening Times: 11:30a.m.-3:30a.m."));

        googleMap.moveCamera(CameraUpdateFactory.zoomTo(15));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(theAcademy));

        mMap.setOnMyLocationButtonClickListener(this);
        enableMyLocation();
    }

    //Checks to see if the app has permission to use geolocation
    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);
        }

    }

    //Code that is executed when the location button is pressed to show the users position
    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        return false;
    }

    //Code that allows for the location layer to be loaded if the needed permissions are granted
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            enableMyLocation();
        } else {
            mPermissionDenied = true;
        }
    }


    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        if (mPermissionDenied) {
            showMissingPermissionError();
            mPermissionDenied = false;
        }
    }

    //Code that will be displayed if the location permission is not granted
    private void showMissingPermissionError() {
        PermissionUtils.PermissionDeniedDialog
                .newInstance(true).show(getSupportFragmentManager(), "dialog");
    }

}
