package com.example.chicagocoffeeshop;


import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class contactus extends Activity {
   static final LatLng contactus = new LatLng(41.876465 , -87.621887);
   private GoogleMap googleMap;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.contactus);
      try { 
            if (googleMap == null) {
               googleMap =((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
            }
         googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
         Marker TP = googleMap.addMarker(new MarkerOptions().
         position(contactus).title("ChicagoCoffeeShop"));

      } catch (Exception e) {
         e.printStackTrace();
      }

   }

}