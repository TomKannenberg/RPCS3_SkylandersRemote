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

    ArrayList<GLander> gVillainButtons = new ArrayList<>(Arrays.asList(
            new GLander(R.drawable.threatpack, "Threatpack", GLander.GLanderElement.Water),
            new GLander(R.drawable.slobber_trap, "Slobber_Trap", GLander.GLanderElement.Water),
            new GLander(R.drawable.cross_crow, "Cross_Crow", GLander.GLanderElement.Water),
            new GLander(R.drawable.chill_bill, "Chill_Bill", GLander.GLanderElement.Water),
            new GLander(R.drawable.brawl_n_chain, "Brawl_&_Chain", GLander.GLanderElement.Water),
            new GLander(R.drawable.gulper, "Gulper", GLander.GLanderElement.Water),
            new GLander(R.drawable.trolling_thunder, "Trolling_Thunder", GLander.GLanderElement.Tech),
            new GLander(R.drawable.shrednaught, "Shrednaught", GLander.GLanderElement.Tech),
            new GLander(R.drawable.mab_lobs, "Mab_Lobs", GLander.GLanderElement.Tech),
            new GLander(R.drawable.bruiser_cruiser, "Bruiser_Cruiser", GLander.GLanderElement.Tech),
            new GLander(R.drawable.brawlrus, "Brawlrus", GLander.GLanderElement.Tech),
            new GLander(R.drawable.dr_krankcase, "Dr._Krankcase", GLander.GLanderElement.Tech),
            new GLander(R.drawable.masker_mind, "Masker_Mind", GLander.GLanderElement.Undead),
            new GLander(R.drawable.hood_sickle, "Hood_Sickle", GLander.GLanderElement.Undead),
            new GLander(R.drawable.bone_chompy, "Bone_Chompy", GLander.GLanderElement.Undead),
            new GLander(R.drawable.wolfgang, "Wolfgang", GLander.GLanderElement.Undead),
            new GLander(R.drawable.rage_mage, "Rage_Mage", GLander.GLanderElement.Magic),
            new GLander(R.drawable.pain_yatta, "Pain-Yatta", GLander.GLanderElement.Magic),
            new GLander(R.drawable.bomb_shell, "Bomb_Shell", GLander.GLanderElement.Magic),
            new GLander(R.drawable.lob_goblin, "Lob_Goblin", GLander.GLanderElement.Light),
            new GLander(R.drawable.eye_five, "Eye_Five", GLander.GLanderElement.Light),
            new GLander(R.drawable.blaster_tron, "Blaster-Tron", GLander.GLanderElement.Light),
            new GLander(R.drawable.luminous, "Luminous", GLander.GLanderElement.Light),
            new GLander(R.drawable.shield_shredder, "Shield_Shredder", GLander.GLanderElement.Life),
            new GLander(R.drawable.sheep_creep, "Sheep_Creep", GLander.GLanderElement.Life),
            new GLander(R.drawable.cuckoo_clocker, "Cuckoo_Clocker", GLander.GLanderElement.Life),
            new GLander(R.drawable.chompy, "Chompy", GLander.GLanderElement.Life),
            new GLander(R.drawable.broccoli_guy, "Broccoli_Guy", GLander.GLanderElement.Life),
            new GLander(R.drawable.chompy_mage, "Chompy_Mage", GLander.GLanderElement.Life),
            new GLander(R.drawable.kaos, "Kaos", GLander.GLanderElement.Kaos),
            new GLander(R.drawable.smoke_scream, "Smoke_Scream", GLander.GLanderElement.Fire),
            new GLander(R.drawable.scrap_shooter, "Scrap_Shooter", GLander.GLanderElement.Fire),
            new GLander(R.drawable.grinnade, "Grinnade", GLander.GLanderElement.Fire),
            new GLander(R.drawable.chef_pepper_jack, "Chef_Pepper_Jack", GLander.GLanderElement.Fire),
            new GLander(R.drawable.tussle_sprout, "Tussle_Sprout", GLander.GLanderElement.Earth),
            new GLander(R.drawable.grave_clobber, "Grave_Clobber", GLander.GLanderElement.Earth),
            new GLander(R.drawable.chomp_chest, "Chomp_Chest", GLander.GLanderElement.Earth),
            new GLander(R.drawable.golden_queen, "Golden_Queen", GLander.GLanderElement.Earth),
            new GLander(R.drawable.tae_kwon_crow, "Tae_Kwon_Crow", GLander.GLanderElement.Dark),
            new GLander(R.drawable.fisticuffs, "Fisticuffs", GLander.GLanderElement.Dark),
            new GLander(R.drawable.eye_scream, "Eye_Scream", GLander.GLanderElement.Dark),
            new GLander(R.drawable.nightshade, "Nightshade", GLander.GLanderElement.Dark),
            new GLander(R.drawable.krankenstein, "Krankenstein", GLander.GLanderElement.Air),
            new GLander(R.drawable.bad_juju, "Bad_Juju", GLander.GLanderElement.Air),
            new GLander(R.drawable.dreamcatcher, "Dreamcatcher", GLander.GLanderElement.Air)
    ));

    ArrayList<GButton> displayedCharacters = new ArrayList<>();

    int currentState = 0; // 0 for main menu, 1 for villain characters

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TCPClient client = new TCPClient("192.168.178.25", 5555);

        client.startClient();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        searchView = findViewById(R.id.search_view);

        GButton mainMenuButton = new GButton(R.drawable.villain_image, "Villains");
        displayedCharacters.add(mainMenuButton); // Add main menu button to the list

        adapter = new GButtonAdapter(this, displayedCharacters);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (currentState == 0) {
                    adapter.getFilter().filter(newText);
                } else {
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

        listView.setOnItemClickListener((parent, view, position, id) -> {
            if (currentState == 0) {
                if (position == 0) {
                    displayedCharacters.clear();
                    displayedCharacters.addAll(gVillainButtons);
                    adapter.notifyDataSetChanged();
                    currentState = 1;
                }
            } else {
                String itemName = displayedCharacters.get(position).getText();
                client.sendPacket(itemName);
            }
        });
    }
    @Override
    public void onBackPressed() {
        if (currentState != 0) {
            displayedCharacters.clear();
            displayedCharacters.add(new GButton(R.drawable.villain_image, "Villains"));
            adapter.notifyDataSetChanged();
            currentState = 0;
        } else {
            super.onBackPressed();
        }
    }

}