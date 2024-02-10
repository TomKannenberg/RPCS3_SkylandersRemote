package com.example.rpcs3_skylandersremote;

import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private GButtonAdapter adapter;

    private SearchView searchView;

    String villain_icon = "_Villain_Icon";

    ArrayList<String> villains = new ArrayList<>(Arrays.asList(
            "Threatpack",
            "Slobber_Trap",
            "Cross_Crow",
            "Chill_Bill",
            "Brawl_n_Chain",
            "Gulper",
            "Trolling_Thunder",
            "Shrednaught",
            "Mab_Lobs",
            "Bruiser_Cruiser",
            "Brawlrus",
            "Dr_Krankcase",
            "Masker_Mind",
            "Hood_Sickle",
            "Bone_Chompy",
            "Wolfgang",
            "Rage_Mage",
            "Pain_Yatta",
            "Bomb_Shell",
            "Lob_Goblin",
            "Eye_Five",
            "Blaster_Tron",
            "Luminous",
            "Shield_Shredder",
            "Sheep_Creep",
            "Cuckoo_Clocker",
            "Chompy",
            "Broccoli_Guy",
            "Chompy_Mage",
            "Kaos",
            "Smoke_Scream",
            "Scrap_Shooter",
            "Grinnade",
            "Chef_Pepper_Jack",
            "Tussle_Sprout",
            "Grave_Clobber",
            "Chomp_Chest",
            "Golden_Queen",
            "Tae_Kwon_Crow",
            "Fisticuffs",
            "Eye_Scream",
            "Nightshade",
            "Krankenstein",
            "Bad_Juju",
            "Dreamcatcher"
    ));

    ArrayList<GButton> gVillainButtons = new ArrayList<>(Arrays.asList(
            new GButton(R.drawable.threatpack, "Threatpack"),
            new GButton(R.drawable.slobber_trap, "Slobber_Trap"),
            new GButton(R.drawable.cross_crow, "Cross_Crow"),
            new GButton(R.drawable.chill_bill, "Chill_Bill"),
            new GButton(R.drawable.brawl_n_chain, "Brawl_&_Chain"),
            new GButton(R.drawable.gulper, "Gulper"),
            new GButton(R.drawable.trolling_thunder, "Trolling_Thunder"),
            new GButton(R.drawable.shrednaught, "Shrednaught"),
            new GButton(R.drawable.mab_lobs, "Mab_Lobs"),
            new GButton(R.drawable.bruiser_cruiser, "Bruiser_Cruiser"),
            new GButton(R.drawable.brawlrus, "Brawlrus"),
            new GButton(R.drawable.dr_krankcase, "Dr._Krankcase"),
            new GButton(R.drawable.masker_mind, "Masker_Mind"),
            new GButton(R.drawable.hood_sickle, "Hood_Sickle"),
            new GButton(R.drawable.bone_chompy, "Bone_Chompy"),
            new GButton(R.drawable.wolfgang, "Wolfgang"),
            new GButton(R.drawable.rage_mage, "Rage_Mage"),
            new GButton(R.drawable.pain_yatta, "Pain-Yatta"),
            new GButton(R.drawable.bomb_shell, "Bomb_Shell"),
            new GButton(R.drawable.lob_goblin, "Lob_Goblin"),
            new GButton(R.drawable.eye_five, "Eye_Five"),
            new GButton(R.drawable.blaster_tron, "Blaster-Tron"),
            new GButton(R.drawable.luminous, "Luminous"),
            new GButton(R.drawable.shield_shredder, "Shield_Shredder"),
            new GButton(R.drawable.sheep_creep, "Sheep_Creep"),
            new GButton(R.drawable.cuckoo_clocker, "Cuckoo_Clocker"),
            new GButton(R.drawable.chompy, "Chompy"),
            new GButton(R.drawable.broccoli_guy, "Broccoli_Guy"),
            new GButton(R.drawable.chompy_mage, "Chompy_Mage"),
            new GButton(R.drawable.kaos, "Kaos"),
            new GButton(R.drawable.smoke_scream, "Smoke_Scream"),
            new GButton(R.drawable.scrap_shooter, "Scrap_Shooter"),
            new GButton(R.drawable.grinnade, "Grinnade"),
            new GButton(R.drawable.chef_pepper_jack, "Chef_Pepper_Jack"),
            new GButton(R.drawable.tussle_sprout, "Tussle_Sprout"),
            new GButton(R.drawable.grave_clobber, "Grave_Clobber"),
            new GButton(R.drawable.chomp_chest, "Chomp_Chest"),
            new GButton(R.drawable.golden_queen, "Golden_Queen"),
            new GButton(R.drawable.tae_kwon_crow, "Tae_Kwon_Crow"),
            new GButton(R.drawable.fisticuffs, "Fisticuffs"),
            new GButton(R.drawable.eye_scream, "Eye_Scream"),
            new GButton(R.drawable.nightshade, "Nightshade"),
            new GButton(R.drawable.krankenstein, "Krankenstein"),
            new GButton(R.drawable.bad_juju, "Bad_Juju"),
            new GButton(R.drawable.dreamcatcher, "Dreamcatcher")
    ));

    ArrayList<GButton> displayedCharacters = new ArrayList<>();

    int currentState = 0; // 0 for main menu, 1 for villain characters

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        searchView = findViewById(R.id.search_view);

        // Create the "Villains" main menu button
        GButton mainMenuButton = new GButton(R.drawable.villain_image, "Villains");
        displayedCharacters.add(mainMenuButton); // Add main menu button to the list

        // Initialize the adapter with the main menu button
        adapter = new GButtonAdapter(this, displayedCharacters);
        listView.setAdapter(adapter);

        // Implement search functionality
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (currentState == 0) {
                    // If currently displaying the main menu, filter the main menu items
                    adapter.getFilter().filter(newText);
                } else {
                    // If currently displaying villains, filter the villain characters
                    ArrayList<GButton> filteredVillains = new ArrayList<>();
                    for (GButton button : gVillainButtons) {
                        if (button.getText().toLowerCase().contains(newText.toLowerCase())) {
                            filteredVillains.add(button);
                        }
                    }
                    adapter.updateList(filteredVillains);
                }
                return false;
            }
        });

        // Handle item click events
        listView.setOnItemClickListener((parent, view, position, id) -> {
            if (currentState == 0) {
                // If "Villains" is clicked, update the list to show only villain characters
                if (position == 0) {
                    displayedCharacters.clear(); // Clear the current list
                    displayedCharacters.addAll(gVillainButtons); // Add villain characters
                    adapter.notifyDataSetChanged(); // Notify adapter of the data change
                    currentState = 1; // Set state to indicate villain characters are being shown
                }
            } else {
                // If a villain character is clicked, you can handle the click event here
                // For example, you can open a details activity or perform some action
                // You can access the clicked item using position
            }
        });
    }
    @Override
    public void onBackPressed() {
        if (currentState != 0) {
            // If currently showing villain characters, go back to main menu
            displayedCharacters.clear();
            displayedCharacters.add(new GButton(R.drawable.villain_image, "Villains"));
            adapter.notifyDataSetChanged();
            currentState = 0; // Set state to main menu
        } else {
            super.onBackPressed(); // Default behavior for other states
        }
    }

}