package com.example.rpcs3_skylandersremote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.rpcs3_skylandersremote.GButton;

import java.util.ArrayList;

public class GButtonAdapter extends ArrayAdapter<GButton> {

    private Context context;
    private ArrayList<GButton> gButtons;

    public GButtonAdapter(Context context, ArrayList<GButton> gButtons) {
        super(context, 0, gButtons);
        this.context = context;
        this.gButtons = gButtons;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.gbutton_item, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.image_view);
            holder.textView = convertView.findViewById(R.id.text_view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        GButton gButton = gButtons.get(position);
        holder.imageView.setImageResource(gButton.getImageResource());
        holder.textView.setText(gButton.getText());

        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}