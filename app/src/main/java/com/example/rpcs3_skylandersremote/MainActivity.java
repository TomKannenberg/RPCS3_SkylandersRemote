package com.example.rpcs3_skylandersremote;

import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private GButtonAdapter adapter;

    private SearchView searchView;

    ArrayList<GButton> gMenuButtons = new ArrayList<>(Arrays.asList(
            new GButton(R.drawable.villain_image, "Villains"),
            new GButton(R.drawable.spyro, "Cores")
    ));

    ArrayList<GLander> gCoreButtons = new ArrayList<>(Arrays.asList(
            new GLander(R.drawable.bash, "Bash", GLander.GLanderElement.Earth),
            new GLander(R.drawable.bat_spin, "Bat_Spin", GLander.GLanderElement.Undead),
            new GLander(R.drawable.blackout, "Blackout", GLander.GLanderElement.Dark),
            new GLander(R.drawable.blades, "Blades", GLander.GLanderElement.Air),
            new GLander(R.drawable.boomer, "Boomer", GLander.GLanderElement.Tech),
            new GLander(R.drawable.bumble_blast, "Bumble_Blast", GLander.GLanderElement.Life),
            new GLander(R.drawable.camo, "Camo", GLander.GLanderElement.Life),
            new GLander(R.drawable.chill, "Chill", GLander.GLanderElement.Water),
            new GLander(R.drawable.chopper, "Chopper", GLander.GLanderElement.Tech),
            new GLander(R.drawable.chop_chop, "Chop_Chop", GLander.GLanderElement.Undead),
            new GLander(R.drawable.cobra_cadabra, "Cobra_Cadabra", GLander.GLanderElement.Magic),
            new GLander(R.drawable.countdown, "Countdown", GLander.GLanderElement.Tech),
            new GLander(R.drawable.cynder, "Cynder", GLander.GLanderElement.Undead),
            new GLander(R.drawable.d3f_vu, "DejaVu", GLander.GLanderElement.Magic),
            new GLander(R.drawable.dino_rang, "Dino_Rang", GLander.GLanderElement.Earth),
            new GLander(R.drawable.double_trouble, "Double_Trouble", GLander.GLanderElement.Magic),
            new GLander(R.drawable.drill_sergeant, "Drill_Sergeant", GLander.GLanderElement.Tech),
            new GLander(R.drawable.drobot, "Drobot", GLander.GLanderElement.Tech),
            new GLander(R.drawable.dune_bug, "Dune_Bug", GLander.GLanderElement.Magic),
            new GLander(R.drawable.echo, "Echo", GLander.GLanderElement.Water),
            new GLander(R.drawable.eruptor, "Eruptor", GLander.GLanderElement.Fire),
            new GLander(R.drawable.fist_bump, "Fist_Bump", GLander.GLanderElement.Earth),
            new GLander(R.drawable.flameslinger, "Flameslinger", GLander.GLanderElement.Fire),
            new GLander(R.drawable.flashwing, "Flashwing", GLander.GLanderElement.Earth),
            new GLander(R.drawable.fling_kong, "Fling_Kong", GLander.GLanderElement.Air),
            new GLander(R.drawable.flip_wreck, "Flip_Wreck", GLander.GLanderElement.Water),
            new GLander(R.drawable.food_fight, "Food_Fight", GLander.GLanderElement.Life),
            new GLander(R.drawable.fright_rider, "Fright_Rider", GLander.GLanderElement.Undead),
            new GLander(R.drawable.fryno, "Fryno", GLander.GLanderElement.Fire),
            new GLander(R.drawable.funny_bone, "Funny_Bone", GLander.GLanderElement.Undead),
            new GLander(R.drawable.ghost_roaster, "Ghost_Roaster", GLander.GLanderElement.Undead),
            new GLander(R.drawable.gill_grunt, "Gill_Grunt", GLander.GLanderElement.Water),
            new GLander(R.drawable.grim_creeper, "Grim_Creeper", GLander.GLanderElement.Undead),
            new GLander(R.drawable.hex, "Hex", GLander.GLanderElement.Undead),
            new GLander(R.drawable.high_five, "High_Five", GLander.GLanderElement.Life),
            new GLander(R.drawable.hot_dog, "Hot_Dog", GLander.GLanderElement.Fire),
            new GLander(R.drawable.ignitor, "Ignitor", GLander.GLanderElement.Fire),
            new GLander(R.drawable.jet_vac, "Jet_Vac", GLander.GLanderElement.Air),
            new GLander(R.drawable.lightning_rod, "Lightning_Rod", GLander.GLanderElement.Air),
            new GLander(R.drawable.pop_fizz, "Pop_Fizz", GLander.GLanderElement.Magic),
            new GLander(R.drawable.pop_thorn, "Pop_Thorn", GLander.GLanderElement.Air),
            new GLander(R.drawable.prism_break, "Prism_Break", GLander.GLanderElement.Earth),
            new GLander(R.drawable.punk_shock, "Punk_Shock", GLander.GLanderElement.Water),
            new GLander(R.drawable.rip_tide, "Rip_Tide", GLander.GLanderElement.Water),
            new GLander(R.drawable.rocky_roll, "Rocky_Roll", GLander.GLanderElement.Earth),
            new GLander(R.drawable.roller_brawl, "Roller_Brawl", GLander.GLanderElement.Undead),
            new GLander(R.drawable.scorp, "Scorp", GLander.GLanderElement.Earth),
            new GLander(R.drawable.scratch, "Scratch", GLander.GLanderElement.Air),
            new GLander(R.drawable.shroomboom, "Shroomboom", GLander.GLanderElement.Life),
            new GLander(R.drawable.slam_bam, "Slam_Bam", GLander.GLanderElement.Water),
            new GLander(R.drawable.slobber_tooth, "Slobber_Tooth", GLander.GLanderElement.Earth),
            new GLander(R.drawable.smolderdash, "Smolderdash", GLander.GLanderElement.Fire),
            new GLander(R.drawable.sonic_boom, "Sonic_Boom", GLander.GLanderElement.Air),
            new GLander(R.drawable.spotlight, "Spotlight", GLander.GLanderElement.Light),
            new GLander(R.drawable.sprocket, "Sprocket", GLander.GLanderElement.Tech),
            new GLander(R.drawable.spyro, "Spyro", GLander.GLanderElement.Magic),
            new GLander(R.drawable.star_strike, "Star_Strike", GLander.GLanderElement.Magic),
            new GLander(R.drawable.stealth_elf, "Stealth_Elf", GLander.GLanderElement.Life),
            new GLander(R.drawable.stump_smash, "Stump_Smash", GLander.GLanderElement.Life),
            new GLander(R.drawable.sunburn, "Sunburn", GLander.GLanderElement.Fire),
            new GLander(R.drawable.terrafin, "Terrafin", GLander.GLanderElement.Earth),
            new GLander(R.drawable.torch, "Torch", GLander.GLanderElement.Fire),
            new GLander(R.drawable.trail_blazer, "Trail_Blazer", GLander.GLanderElement.Fire),
            new GLander(R.drawable.tread_head, "Tread_Head", GLander.GLanderElement.Tech),
            new GLander(R.drawable.trigger_happy, "Trigger_Happy", GLander.GLanderElement.Tech),
            new GLander(R.drawable.voodood, "Voodood", GLander.GLanderElement.Magic),
            new GLander(R.drawable.warnado, "Warnado", GLander.GLanderElement.Air),
            new GLander(R.drawable.wham_shell, "Wham_Shell", GLander.GLanderElement.Water),
            new GLander(R.drawable.whirlwind, "Whirlwind", GLander.GLanderElement.Air),
            new GLander(R.drawable.wind_up, "Wind_Up", GLander.GLanderElement.Tech),
            new GLander(R.drawable.wrecking_ball, "Wrecking_Ball", GLander.GLanderElement.Magic),
            new GLander(R.drawable.zap, "Zap", GLander.GLanderElement.Water),
            new GLander(R.drawable.zook, "Zook", GLander.GLanderElement.Life),
            new GLander(R.drawable.zoo_lou, "Zoo_Lou", GLander.GLanderElement.Life)
    ));
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

    ArrayList<GLander> gAllButtons = new ArrayList<>();

    ArrayList<GButton> displayedCharacters = new ArrayList<>();

    ArrayList<ArrayList<GButton>> lists;

    int currentState = 0; // 0 for main menu, 1 for villain characters
    int wasState = 0;     // state for search bar

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        gAllButtons.addAll(gCoreButtons);
        gAllButtons.addAll(gVillainButtons);

        TCPClient client = new TCPClient("192.168.178.25", 187);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        searchView = findViewById(R.id.search_view);

        displayedCharacters.addAll(gMenuButtons);

        adapter = new GButtonAdapter(this, displayedCharacters);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String searchText) {

                if (wasState == 0 && searchText.length() == 0) {
                    displayedCharacters.clear();
                    adapter.notifyDataSetChanged();
                    currentState = 0;
                } else {
                    wasState = 1;
                    ArrayList<GButton> filteredSkylanders = new ArrayList<>();

                    Pattern pattern = Pattern.compile("(?i)(Air|Dark|Earth|Fire|Kaos|Life|Light|Magic|Tech|Undead|Water)");
                    Matcher matcher = pattern.matcher(searchText);
                    if (matcher.find()) {
                        String match = matcher.group(1).toLowerCase();
                        GLander.GLanderElement result;
                        switch (match) {
                            case "air":
                                result = GLander.GLanderElement.Air;
                                break;
                            case "dark":
                                result = GLander.GLanderElement.Dark;
                                break;
                            case "earth":
                                result = GLander.GLanderElement.Earth;
                                break;
                            case "fire":
                                result = GLander.GLanderElement.Fire;
                                break;
                            case "kaos":
                                result = GLander.GLanderElement.Kaos;
                                break;
                            case "life":
                                result = GLander.GLanderElement.Life;
                                break;
                            case "light":
                                result = GLander.GLanderElement.Light;
                                break;
                            case "magic":
                                result = GLander.GLanderElement.Magic;
                                break;
                            case "tech":
                                result = GLander.GLanderElement.Tech;
                                break;
                            case "undead":
                                result = GLander.GLanderElement.Undead;
                                break;
                            case "water":
                                result = GLander.GLanderElement.Water;
                                break;
                            default:
                                result = GLander.GLanderElement.None;
                                break;
                        }
                        searchText.replace(match, "");
                        searchText.replace(" ", "");

                        filterVillainsByElement(result, gAllButtons, filteredSkylanders, searchText);

                        for (GButton button : gAllButtons) {
                            if (!button.getText().toLowerCase().contains(searchText.toLowerCase())) {
                                //filteredSkylanders.remove(button);
                            }
                        }
                    } else {
                        searchText.replace(" ", "");

                        for (GButton button : gAllButtons) {
                            if (button.getText().toLowerCase().contains(searchText.toLowerCase())) {
                                filteredSkylanders.add(button);
                            }
                        }
                    }

                    adapter.updateList(filteredSkylanders);
                }
                return false;
            }


        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            if (currentState == 0 && wasState == 0) {
                if (position == 0) {
                    displayedCharacters.clear();
                    displayedCharacters.addAll(gVillainButtons);
                    adapter.notifyDataSetChanged();
                    currentState = 1;
                } else if (position == 1) {
                    displayedCharacters.clear();
                    displayedCharacters.addAll(gCoreButtons);
                    adapter.notifyDataSetChanged();
                    currentState = 2;
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
            displayedCharacters.addAll(gMenuButtons);
            adapter.notifyDataSetChanged();
            currentState = 0;
        } else if (wasState == 1 && currentState == 0) {
            searchView.setQuery("", true);
            displayedCharacters.clear();
            displayedCharacters.addAll(gMenuButtons);
            adapter.notifyDataSetChanged();
            wasState = 0;
            return;
        } else {
            super.onBackPressed();
        }
    }

    private void filterVillainsByElement(GLander.GLanderElement element, List<GLander> gVillainButtons, List<GButton> filteredVillains, String searchText) {
        for (GLander button : gVillainButtons) {
            if (button.element == element) {
                filteredVillains.add(button);
            }
        }
    }

}