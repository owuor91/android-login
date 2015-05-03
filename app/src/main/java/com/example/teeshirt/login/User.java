package com.example.teeshirt.login;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class User extends ActionBarActivity {
    private static ListView listViewLV;
    private static String[] NAMES = new String[] {"Tom", "Dick", "Larry", "Page", "Kendele","Amos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        showList();
    }

    public void showList(){
        listViewLV = (ListView)findViewById(R.id.listViewLV);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.namelist, NAMES);
        listViewLV.setAdapter(adapter);
        listViewLV.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String value = (String)listViewLV.getItemAtPosition(position);
                        Toast.makeText(User.this, value, Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }

}
