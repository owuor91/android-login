package com.example.teeshirt.login;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class User extends ActionBarActivity {
    private static ListView listViewLV;
    private static String[] NAMES = new String[] {"Tom", "Dick", "Larry", "Page", "Kendele","Amos"};

    private static SeekBar seekbar;
    private static TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        showList();
        seeking();
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

    public void seeking(){
        seekbar = (SeekBar)findViewById(R.id.seekbar);
        tv = (TextView)findViewById(R.id.tv);
        tv.setText(seekbar.getProgress() + "/"+seekbar.getMax());

        seekbar.setOnSeekBarChangeListener(

                new SeekBar.OnSeekBarChangeListener() {
                    int progressVal;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progressVal = progress;
                        tv.setText(progressVal + "/"+seekbar.getMax());
                        Toast.makeText(User.this, "Seekbar in Progress", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        Toast.makeText(User.this, "Seekbar in StartTracking", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        tv.setText(progressVal + "/"+seekbar.getMax());
                        Toast.makeText(User.this, "Seekbar on StopTracking", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}
