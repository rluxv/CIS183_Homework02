package com.example.homework02_program01;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorListAdapter extends BaseAdapter
{

    ArrayList<ColorInfo> listOfColors;
    Context context;

    public ColorListAdapter(Context c, ArrayList<ColorInfo> ls)
    {
        //Passed to the claim from MainActivity.java
        context = c;
        listOfColors = ls;
    }

    @Override
    public int getCount()
    {
        return listOfColors.size();
    }

    @Override
    public Object getItem(int i)
    {
        return listOfColors.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if(view == null)
        {
            LayoutInflater mInflator = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflator.inflate(R.layout.color_cell, null);
        }

        //find the gui elements in custom_cell.xml
        //TextView name = view.findViewById(R.id.tv_v_customCell_name);
        //TextView email = view.findViewById(R.id.tv_v_customCell_email);

        TextView red = view.findViewById(R.id.tv_v_c_red);
        TextView green = view.findViewById(R.id.tv_v_c_green);
        TextView blue = view.findViewById(R.id.tv_v_c_blue);
        TextView hex = view.findViewById(R.id.tv_v_c_hex);

        ColorInfo color = listOfColors.get(i);

        red.setText("Red: " + color.getRed());
        green.setText("Green: " + color.getGreen());
        blue.setText("Blue: " + color.getBlue());
        hex.setText("Hex: " + color.getHex());
        view.setBackgroundColor(Color.rgb(color.getRed(), color.getGreen(), color.getBlue()));
        if (color.getRed() < 85 && color.getGreen() < 60 && color.getBlue() < 120)
        {
            red.setTextColor(Color.rgb(255, 255, 255));
            green.setTextColor(Color.rgb(255, 255, 255));
            blue.setTextColor(Color.rgb(255, 255, 255));
            hex.setTextColor(Color.rgb(255, 255, 255));
        }

        //get the user at position i (i is passed to this function)
        //User user = listOfUsers.get(i);

        //set the gui for the custom_cell.xml
        //name.setText(user.getlName() + ", " + user.getfName());
        //email.setText(user.getEmail());

        //return the view we created
        return view;
    }
}
