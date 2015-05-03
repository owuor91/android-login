package com.example.teeshirt.login;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class User extends ActionBarActivity {
    private static ListView listViewLV;
    private static String[] NAMES = new String[] {"Tom", "Dick", "Larry", "Page", "Kendele"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        listView();
    }

    public void listView(){
        listViewLV = (ListView)findViewById(R.id.listViewLV);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.namelist, NAMES);
        listViewLV.setAdapter(adapter);

    }

}
