// ==========================================================================================
// Author: Nicholas Frederick
// Date: 9-22-2023
// Description: This program allows you to choose, save, and apply colors using SeekBars.
// ==========================================================================================
package com.example.homework02_program01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    Button btn_j_saveColor;
    SeekBar sb_j_red, sb_j_green, sb_j_blue;
    ListView lv_j_listOfColors;
    TextView tv_j_red, tv_j_green, tv_j_blue, tv_j_hexRep;
    ArrayList<ColorInfo> listOfColors;
    ColorListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAssociations();
        registerEventHandlers();
        listOfColors = new ArrayList<ColorInfo>();
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
        tv_j_hexRep = findViewById(R.id.tv_v_hexRep);

    }

    public void registerEventHandlers()
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
                addColor();
                fillListView();
                adapter.notifyDataSetChanged();
                resetView();
                //Log.d("SaveColorButtonPress", "Success");
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
                //Log.d("RedSeekBarEvent", "Progress: " + seekBar.getProgress());
                changeBackgroundColor();
                updateTextValues();
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
                //Log.d("GreenSeekBarEvent", "Progress: " + seekBar.getProgress());
                changeBackgroundColor();
                updateTextValues();
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
                //Log.d("BlueSeekBarEvent", "Progress: " + seekBar.getProgress());
                changeBackgroundColor();
                updateTextValues();
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
        lv_j_listOfColors.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                //Log.d("Item Click", "CLICKED");
                ColorInfo color = (ColorInfo) adapterView.getItemAtPosition(i);
                sb_j_red.setProgress(color.getRed());
                sb_j_green.setProgress(color.getGreen());
                sb_j_blue.setProgress(color.getBlue());
            }
        });
    }

    public void changeBackgroundColor()
    {
        int red = sb_j_red.getProgress();
        int green = sb_j_green.getProgress();
        int blue = sb_j_blue.getProgress();
        View mainActivityView = findViewById(R.id.main_activity);
        mainActivityView.setBackgroundColor(Color.rgb(red, green, blue));
    }

    public void updateTextValues()
    {
        int red = sb_j_red.getProgress();
        int green = sb_j_green.getProgress();
        int blue = sb_j_blue.getProgress();

        //Convert RGB to Hexadecimal
        String sRed = String.format("%02X", red);
        String sGreen = String.format("%02X", green);
        String sBlue = String.format("%02X", blue);

        tv_j_red.setText("Red: " + red);
        tv_j_green.setText("Green: " + green);
        tv_j_blue.setText("Blue: " + blue);
        tv_j_hexRep.setText("Hexadecimal Representation: " + sRed + sGreen + sBlue);

        //Change the color of the text if it is too dark or bright to see
        if (red < 85 && green < 60 && blue < 120)
        {
            tv_j_red.setTextColor(Color.rgb(255, 255, 255));
            tv_j_green.setTextColor(Color.rgb(255, 255, 255));
            tv_j_blue.setTextColor(Color.rgb(255, 255, 255));
            tv_j_hexRep.setTextColor(Color.rgb(255, 255, 255));
        } else
        {
            tv_j_red.setTextColor(Color.rgb(0, 0, 0));
            tv_j_green.setTextColor(Color.rgb(0, 0, 0));
            tv_j_blue.setTextColor(Color.rgb(0, 0, 0));
            tv_j_hexRep.setTextColor(Color.rgb(0, 0, 0));
        }
    }

    public void addColor()
    {
        int red = sb_j_red.getProgress();
        int green = sb_j_green.getProgress();
        int blue = sb_j_blue.getProgress();
        String hex = String.format("%02X", red) + String.format("%02X", green) + String.format("%02X", blue);
        ColorInfo colorToAdd = new ColorInfo(red, green, blue, hex);
        listOfColors.add(colorToAdd);
    }

    public void fillListView()
    {
        adapter = new ColorListAdapter(this, listOfColors);
        //set the listviews adapter
        lv_j_listOfColors.setAdapter(adapter);
    }

    public void resetView()
    {
        //We only need to reset the progress, all the text will automatically update.
        sb_j_red.setProgress(255);
        sb_j_green.setProgress(255);
        sb_j_blue.setProgress(255);
    }

}