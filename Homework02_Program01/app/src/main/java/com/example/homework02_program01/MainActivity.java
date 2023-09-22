// ==========================================================================================
// Author: Nicholas Frederick
// Date: 9-22-2023
// Description: This program allows you to choose, save, and apply colors using SeekBars.
// ==========================================================================================
package com.example.homework02_program01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_j_saveColor;
    SeekBar sb_j_red, sb_j_green, sb_j_blue;
    ListView lv_j_listOfColors;
    TextView tv_j_red, tv_j_green, tv_j_blue;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAssociations();
        registerListeners();
    }

    public void setAssociations()
    {
        btn_j_saveColor = findViewById(R.id.btn_v_saveColor);
        sb_j_red = findViewById(R.id.sb_v_red);
        sb_j_green = findViewById(R.id.sb_v_green);
        sb_j_blue = findViewById(R.id.sb_v_blue);
        tv_j_red = findViewById(R.id.tv_v_red);
        tv_j_green = findViewById(R.id.tv_v_green);
        tv_j_blue = findViewById(R.id.tv_v_blue);
        lv_j_listOfColors = findViewById(R.id.lv_v_listOfColors);
    }

    public void registerListeners()
    {
        saveColorButtonEventHandler();
        redSeekBarEventHandler();
        greenSeekBarEventHandler();
        blueSeekBarEventHandler();
        colorListViewEventHandler();
    }

    public void saveColorButtonEventHandler()
    {
        btn_j_saveColor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.d("SaveColorButtonPress", "Success");
            }
        });
    }

    public void redSeekBarEventHandler()
    {
        sb_j_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                Log.d("RedSeekBarEvent", "Progress: " + seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
                // Unused but cannot be removed
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                // Unused but cannot be removed
            }
        });
    }

    public void greenSeekBarEventHandler()
    {
        sb_j_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                Log.d("GreenSeekBarEvent", "Progress: " + seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
                // Unused but cannot be removed
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                // Unused but cannot be removed
            }
        });
    }

    public void blueSeekBarEventHandler()
    {
        sb_j_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                Log.d("BlueSeekBarEvent", "Progress: " + seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
                // Unused but cannot be removed
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                // Unused but cannot be removed
            }
        });
    }

    public void colorListViewEventHandler()
    {
        lv_j_listOfColors.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });
    }

}