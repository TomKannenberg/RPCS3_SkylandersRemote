package com.example.rpcs3_skylandersremote;

import android.annotation.SuppressLint;
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

import static com.example.rpcs3_skylandersremote.MainActivity.bottomSwapper;
import static com.example.rpcs3_skylandersremote.MainActivity.topSwapper;

public class GButtonAdapter extends ArrayAdapter<GButton> implements Filterable {

    private Context context;
    private List<GButton> gButtons;
    private List<GButton> gButtonsFull;

    public GButtonAdapter(Context context, ArrayList<GButton> gButtons) {
        super(context, 0, gButtons);
        this.context = context;
        this.gButtons = gButtons;
        this.gButtonsFull = new ArrayList<>(gButtons);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        GButton gButton = gButtons.get(position);

        int layoutId = gButton.low ? R.layout.gbuttonb_item : R.layout.gbutton_item;

        if (gButton.swapper) {
            if (gButton.low && topSwapper != 0) {
                layoutId = R.layout.gbuttonbt_item;
            } else if (bottomSwapper != 0) {
                layoutId = R.layout.gbuttontb_item;
            }
        }

        // Check if layoutId is valid (not 0) before inflating the layout
        if (layoutId != 0) {
            convertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.image_view);
            holder.textView = convertView.findViewById(R.id.text_view);
            if (layoutId == R.layout.gbuttonbt_item || layoutId == R.layout.gbuttontb_item) {
                holder.bottomImageView = convertView.findViewById(R.id.bottom_image_view);
            }
            convertView.setTag(holder);

            if (holder != null) {
                holder.imageView.setImageResource(gButton.getImageResource());
                holder.textView.setText(gButton.getText());

                if (gButton.swapper && (layoutId == R.layout.gbuttonbt_item || layoutId == R.layout.gbuttontb_item)) {
                    if (holder.bottomImageView != null) {
                        if (gButton.low && topSwapper != 0) {
                            holder.bottomImageView.setImageResource(topSwapper);
                        } else if (bottomSwapper != 0) {
                            holder.bottomImageView.setImageResource(bottomSwapper);
                        }
                    } else {
                        System.out.println("Error 4");
                    }
                } else {
                    System.out.println("Error 3");
                }
            } else {
                System.out.println("Error 2");
            }
        } else {
            System.out.println("Error 1");
        }

        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView textView;
        ImageView bottomImageView;
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

    public void updateList(List<GButton> newButtons) {
        gButtons.clear();
        gButtons.addAll(newButtons);
        notifyDataSetChanged();
    }
}