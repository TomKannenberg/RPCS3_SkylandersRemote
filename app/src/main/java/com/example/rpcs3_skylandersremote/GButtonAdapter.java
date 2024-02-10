package com.example.rpcs3_skylandersremote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GButtonAdapter extends ArrayAdapter<GButton> implements Filterable {

    private Context context;
    private List<GButton> gButtons;
    private List<GButton> gButtonsFull; // To store the full list of buttons

    public GButtonAdapter(Context context, ArrayList<GButton> gButtons) {
        super(context, 0, gButtons);
        this.context = context;
        this.gButtons = gButtons;
        this.gButtonsFull = new ArrayList<>(gButtons); // Initialize the full list
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

    @Override
    public Filter getFilter() {
        return gButtonFilter;
    }

    private Filter gButtonFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<GButton> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(gButtonsFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (GButton button : gButtonsFull) {
                    if (button.getText().toLowerCase().contains(filterPattern)) {
                        filteredList.add(button);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            gButtons.clear();
            gButtons.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    // Method to update the list with a new set of buttons
    public void updateList(List<GButton> newButtons) {
        gButtons.clear();
        gButtons.addAll(newButtons);
        notifyDataSetChanged();
    }
}