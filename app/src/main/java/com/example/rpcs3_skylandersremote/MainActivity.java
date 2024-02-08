package com.example.rpcs3_skylandersremote;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private GButtonAdapter adapter;

    String villain_icon = "_Villain_Icon";

    ArrayList<String> villains = new ArrayList<>(Arrays.asList(
            "Threatpack", "Slobber_Trap", "Cross_Crow", "Chill_Bill",

    ));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);

        // Create a list of GButton items
        ArrayList<GButton> gButtons = new ArrayList<>();
        gButtons.add(new GButton(R.drawable.image1, "Button 1"));
        gButtons.add(new GButton(R.drawable.image2, "Button 2"));
        gButtons.add(new GButton(R.drawable.image3, "Button 3"));

        gButtons.add(new GButton(R.drawable.image1, "Button 1"));
        gButtons.add(new GButton(R.drawable.image2, "Button 2"));
        gButtons.add(new GButton(R.drawable.image3, "Button 3"));

        gButtons.add(new GButton(R.drawable.image1, "Button 1"));
        gButtons.add(new GButton(R.drawable.image2, "Button 2"));
        gButtons.add(new GButton(R.drawable.image3, "Button 3"));

        gButtons.add(new GButton(R.drawable.image1, "Button 1"));
        gButtons.add(new GButton(R.drawable.image2, "Button 2"));
        gButtons.add(new GButton(R.drawable.image3, "Button 3"));

        gButtons.add(new GButton(R.drawable.image1, "Button 1"));
        gButtons.add(new GButton(R.drawable.image2, "Button 2"));
        gButtons.add(new GButton(R.drawable.image3, "Button 3"));

        // Create and set the adapter
        adapter = new GButtonAdapter(this, gButtons);
        listView.setAdapter(adapter);
    }
}