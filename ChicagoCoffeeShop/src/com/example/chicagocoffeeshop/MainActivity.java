package com.example.chicagocoffeeshop;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class MainActivity extends ActionBarActivity implements OnItemClickListener{

	private DrawerLayout drawerLayout;
	private ListView listview;
	
	private String[] menu;
	
	@SuppressWarnings("deprecation")
	private ActionBarDrawerToggle drawerListner;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getSupportActionBar().setDisplayShowHomeEnabled(true);

	    getSupportActionBar().setLogo(R.drawable.appicon);

	    getSupportActionBar().setDisplayUseLogoEnabled(true);
	    
		
		
		drawerLayout=(DrawerLayout) findViewById(R.id.drawerLayout);
		menu=getResources().getStringArray(R.array.menu);
		listview=(ListView) findViewById(R.id.drawerList);
		
		listview.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,menu));
	listview.setOnItemClickListener(this);
	
	drawerListner = new ActionBarDrawerToggle(this,drawerLayout,R.drawable.drawericon,R.string.drawer_open,R.string.drawer_close)
	
	{
		
@Override
public void onDrawerOpened(View drawerView) {
	// TODO Auto-generated method stub
	Toast.makeText(MainActivity.this,"Drawer Opened", Toast.LENGTH_LONG).show();
}

@Override
		public void onDrawerClosed(View drawerView) {
			// TODO Auto-generated method stub
	Toast.makeText(MainActivity.this,"Drawer Closed", Toast.LENGTH_LONG).show();
		}
	};
	
	
 drawerLayout.setDrawerListener(drawerListner);
	getSupportActionBar().setHomeButtonEnabled(true);
	getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	
	public boolean onOptionsItemSelected1(MenuItem item)
	{
		
		
		
		if (drawerListner.onOptionsItemSelected(item))
		{
		return true;

		}
			return super.onOptionsItemSelected(item);	
				
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	drawerListner.onConfigurationChanged(newConfig);
	}
	
	
@Override
protected void onPostCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onPostCreate(savedInstanceState);
drawerListner.syncState();

}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		int akshay;
		akshay=position;
		Toast.makeText(this,menu[position]+" was selected",Toast.LENGTH_LONG).show();
		selectItem(position);
		
		if (akshay==0)
		{
			Intent i = new Intent(this,aboutus.class);
			
			startActivity(i);	
			//setContentView(R.layout.activity_main);
		}
		
		
		if (akshay == 2)
				{
		Intent i = new Intent(this,reservetable.class);
		
		startActivity(i);
		//setContentView(R.layout.activity_main);
				}
		
	
		if (akshay==1)
		{
			Intent i = new Intent(this,products.class);
			
			startActivity(i);	
			//setContentView(R.layout.activity_main);
		}
		
		if (akshay == 3)
		{
Intent i = new Intent(this,contactus.class);

startActivity(i);
//setContentView(R.layout.activity_main);
		}
		
		
		
		
	}


	public void selectItem(int position) {
		listview.setItemChecked(position, true);
		setTitle(menu[position]);
	}
	
	public void setTitle(String title)
	{
		getSupportActionBar().setTitle(title);
	}	
	

	}
