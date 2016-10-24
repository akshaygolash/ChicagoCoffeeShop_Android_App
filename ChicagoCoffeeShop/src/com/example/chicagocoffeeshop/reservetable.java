package com.example.chicagocoffeeshop;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class reservetable extends Activity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.reservetable);

      Button startBtn = (Button) findViewById(R.id.sendEmail);
      startBtn.setOnClickListener(new View.OnClickListener() {
         public void onClick(View view) {
         sendEmail();
      }
   });

   }
   protected void sendEmail() {
      Log.i("Send email", "");

      String[] TO = {"gaurav1408@gmail.com"};
      String[] CC = {"akshay.golash95@gmail.com"};
      Intent emailIntent = new Intent(Intent.ACTION_SEND);
      emailIntent.setData(Uri.parse("mailto:"));
      emailIntent.setType("text/plain");


      emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
      emailIntent.putExtra(Intent.EXTRA_CC, CC);
      emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Reserve a table");
      emailIntent.putExtra(Intent.EXTRA_TEXT, "Please enter your name:                                    " + "Please enter capacity:                                          "
      		+ "Please enter your time when you would like to reserve(AM/PM):                                                 ");

      try {
         startActivity(Intent.createChooser(emailIntent, "Send mail..."));
         finish();
         Log.i("Finished sending email...", "");
      } catch (android.content.ActivityNotFoundException ex) {
         Toast.makeText(reservetable.this, 
         "There is no email client installed.", Toast.LENGTH_SHORT).show();
      }
   }
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.main, menu);
      return true;
   }
}