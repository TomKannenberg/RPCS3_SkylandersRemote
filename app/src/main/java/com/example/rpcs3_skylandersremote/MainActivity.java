package com.example.rpcs3_skylandersremote;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import javax.microedition.khronos.opengles.GL;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private GButtonAdapter adapter;

    private SearchView searchView;

    ArrayList<GButton> gMenuButtons = new ArrayList<>(Arrays.asList(
            new GButton(R.drawable.spyro, "Cores"),
            new GButton(R.drawable.swapper, "Swappers"),
            new GButton(R.drawable.snap_shot, "Trap Masters"),
            new GButton(R.drawable.undead_skull, "Traps"),
            new GButton(R.drawable.topswapper, "Swapper Tops"),
            new GButton(R.drawable.bottomswapper, "Swapper Bottoms"),
            new GButton(R.drawable.villain_image, "Villains")
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
    ArrayList<GLander> gSwapperButtons = new ArrayList<>();
    ArrayList<GLander> gSwapperTopButtons = new ArrayList<>(Arrays.asList(
            new GLander(R.drawable.wash, "Wash", GLander.GLanderElement.Water, GLander.GLanderType.SwapperTop),
            new GLander(R.drawable.freeze, "Freeze", GLander.GLanderElement.Water, GLander.GLanderType.SwapperTop),
            new GLander(R.drawable.blast, "Blast", GLander.GLanderElement.Fire, GLander.GLanderType.SwapperTop),
            new GLander(R.drawable.fire, "Fire", GLander.GLanderElement.Fire, GLander.GLanderType.SwapperTop),
            new GLander(R.drawable.grilla, "Grilla", GLander.GLanderElement.Life, GLander.GLanderType.SwapperTop),
            new GLander(R.drawable.stink, "Stink", GLander.GLanderElement.Life, GLander.GLanderType.SwapperTop),
            new GLander(R.drawable.spy, "Spy", GLander.GLanderElement.Tech, GLander.GLanderType.SwapperTop),
            new GLander(R.drawable.magna, "Magna", GLander.GLanderElement.Tech, GLander.GLanderType.SwapperTop),
            new GLander(R.drawable.hoot, "Hoot", GLander.GLanderElement.Magic, GLander.GLanderType.SwapperTop),
            new GLander(R.drawable.trap, "Trap", GLander.GLanderElement.Magic, GLander.GLanderType.SwapperTop),
            new GLander(R.drawable.night, "Night", GLander.GLanderElement.Undead, GLander.GLanderType.SwapperTop),
            new GLander(R.drawable.rattle, "Rattle", GLander.GLanderElement.Undead, GLander.GLanderType.SwapperTop),
            new GLander(R.drawable.rubble, "Rubble", GLander.GLanderElement.Earth, GLander.GLanderType.SwapperTop),
            new GLander(R.drawable.doom, "Doom", GLander.GLanderElement.Earth, GLander.GLanderType.SwapperTop),
            new GLander(R.drawable.boom, "Boom", GLander.GLanderElement.Air, GLander.GLanderType.SwapperTop),
            new GLander(R.drawable.free, "Free", GLander.GLanderElement.Air, GLander.GLanderType.SwapperTop)
    ));

    ArrayList<GLander> gSwapperBottomButtons = new ArrayList<>(Arrays.asList(
            new GLander(R.drawable.buckler, "Buckler", GLander.GLanderElement.Water, GLander.GLanderType.SwapperBottom),
            new GLander(R.drawable.blade, "Blade", GLander.GLanderElement.Water, GLander.GLanderType.SwapperBottom),
            new GLander(R.drawable.zone, "Zone", GLander.GLanderElement.Fire, GLander.GLanderType.SwapperBottom),
            new GLander(R.drawable.kraken, "Kraken", GLander.GLanderElement.Fire, GLander.GLanderType.SwapperBottom),
            new GLander(R.drawable.drilla, "Drilla", GLander.GLanderElement.Life, GLander.GLanderType.SwapperBottom),
            new GLander(R.drawable.bomb, "Bomb", GLander.GLanderElement.Life, GLander.GLanderType.SwapperBottom),
            new GLander(R.drawable.rise, "Rise", GLander.GLanderElement.Tech, GLander.GLanderType.SwapperBottom),
            new GLander(R.drawable.charge, "Charge", GLander.GLanderElement.Tech, GLander.GLanderType.SwapperBottom),
            new GLander(R.drawable.loop, "Loop", GLander.GLanderElement.Magic, GLander.GLanderType.SwapperBottom),
            new GLander(R.drawable.shadow, "Shadow", GLander.GLanderElement.Magic, GLander.GLanderType.SwapperBottom),
            new GLander(R.drawable.shift, "Shift", GLander.GLanderElement.Undead, GLander.GLanderType.SwapperBottom),
            new GLander(R.drawable.shake, "Shake", GLander.GLanderElement.Undead, GLander.GLanderType.SwapperBottom),
            new GLander(R.drawable.rouser, "Rouser", GLander.GLanderElement.Earth, GLander.GLanderType.SwapperBottom),
            new GLander(R.drawable.stone, "Stone", GLander.GLanderElement.Earth, GLander.GLanderType.SwapperBottom),
            new GLander(R.drawable.jet, "Jet", GLander.GLanderElement.Air, GLander.GLanderType.SwapperBottom),
            new GLander(R.drawable.ranger, "Ranger", GLander.GLanderElement.Air, GLander.GLanderType.SwapperBottom)
    ));

    ArrayList<GLander> gTrapMasterButtons = new ArrayList<>(Arrays.asList(

            new GLander(R.drawable.blastermind, "Blastermind", GLander.GLanderElement.Magic),
            new GLander(R.drawable.bushwhack, "Bushwhack", GLander.GLanderElement.Life),
            new GLander(R.drawable.enigma, "Enigma", GLander.GLanderElement.Magic),
            new GLander(R.drawable.gearshift, "Gearshift", GLander.GLanderElement.Tech),
            new GLander(R.drawable.gusto, "Gusto", GLander.GLanderElement.Air),
            new GLander(R.drawable.head_rush, "Head Rush", GLander.GLanderElement.Earth),
            new GLander(R.drawable.jawbreaker, "Jawbreaker", GLander.GLanderElement.Tech),
            new GLander(R.drawable.ka_boom, "Ka-Boom", GLander.GLanderElement.Fire),
            new GLander(R.drawable.knight_light, "Knight Light", GLander.GLanderElement.Light),
            new GLander(R.drawable.knight_mare, "Knight Mare", GLander.GLanderElement.Dark),
            new GLander(R.drawable.krypt_king, "Krypt King", GLander.GLanderElement.Undead),
            new GLander(R.drawable.lob_star, "Lob Star", GLander.GLanderElement.Water),
            new GLander(R.drawable.short_cut, "Short Cut", GLander.GLanderElement.Undead),
            new GLander(R.drawable.snap_shot, "Snap Shot", GLander.GLanderElement.Water),
            new GLander(R.drawable.thunderbolt, "Thunderbolt", GLander.GLanderElement.Air),
            new GLander(R.drawable.tuff_luck, "Tuff Luck", GLander.GLanderElement.Life),
            new GLander(R.drawable.wallop, "Wallop", GLander.GLanderElement.Earth),
            new GLander(R.drawable.wildfire, "Wildfire", GLander.GLanderElement.Fire)

    ));

    ArrayList<GLander> gTrapButtons = new ArrayList<>(Arrays.asList(
            new GLander(R.drawable.air_hourglass, "Tempest Timer", GLander.GLanderElement.Air, GLander.GLanderType.Special1),
            new GLander(R.drawable.air_jughead, "Drafty Decanter", GLander.GLanderElement.Air, GLander.GLanderType.Special1),
            new GLander(R.drawable.air_screamer, "Storm Warning", GLander.GLanderElement.Air, GLander.GLanderType.Special1),
            new GLander(R.drawable.air_snake, "Cloudy Cobra", GLander.GLanderElement.Air, GLander.GLanderType.Special1),
            new GLander(R.drawable.air_sword, "Air Sword", GLander.GLanderElement.Air, GLander.GLanderType.Special1),
            new GLander(R.drawable.air_toucan, "Breezy Bird", GLander.GLanderElement.Air, GLander.GLanderType.Special1),
            new GLander(R.drawable.dark_handstand, "Ghastly Grimace", GLander.GLanderElement.Dark, GLander.GLanderType.Special1),
            new GLander(R.drawable.dark_spider, "Shadow Spider", GLander.GLanderElement.Dark, GLander.GLanderType.Special1),
            new GLander(R.drawable.dark_sword, "Dark Dagger", GLander.GLanderElement.Dark, GLander.GLanderType.Special1),
            new GLander(R.drawable.earth_bunny, "Easter Rubble Trouble", GLander.GLanderElement.Earth, GLander.GLanderType.Special1),
            new GLander(R.drawable.earth_hammer, "Slag Hammer", GLander.GLanderElement.Earth, GLander.GLanderType.Special1),
            new GLander(R.drawable.earth_handstand, "Rubble Trouble", GLander.GLanderElement.Earth, GLander.GLanderType.Special1),
            new GLander(R.drawable.earth_hourglass, "Dust of Time", GLander.GLanderElement.Earth, GLander.GLanderType.Special1),
            new GLander(R.drawable.earth_orb, "Banded Boulder", GLander.GLanderElement.Earth, GLander.GLanderType.Special1),
            new GLander(R.drawable.earth_totem, "Spinning Sandstorm", GLander.GLanderElement.Earth, GLander.GLanderType.Special1),
            new GLander(R.drawable.earth_toucan, "Rock Hawk", GLander.GLanderElement.Earth, GLander.GLanderType.Special1),
            new GLander(R.drawable.earth_tousslesprout, "Red Hot Toussle Sprout", GLander.GLanderElement.Earth, GLander.GLanderType.Special1),
            new GLander(R.drawable.fire_captain, "Spark Spear", GLander.GLanderElement.Fire, GLander.GLanderType.Special1),
            new GLander(R.drawable.fire_scepter, "Fire Flower", GLander.GLanderElement.Fire, GLander.GLanderType.Special1),
            new GLander(R.drawable.fire_screamer, "Scorching Stopper", GLander.GLanderElement.Fire, GLander.GLanderType.Special1),
            new GLander(R.drawable.fire_torch, "Eternal Flame", GLander.GLanderElement.Fire, GLander.GLanderType.Special1),
            new GLander(R.drawable.fire_totem, "Searing Spinner", GLander.GLanderElement.Fire, GLander.GLanderType.Special1),
            new GLander(R.drawable.fire_yawn, "Blazing Belch", GLander.GLanderElement.Fire, GLander.GLanderType.Special1),
            new GLander(R.drawable.kaost, "Kaos Trap", GLander.GLanderElement.Kaos, GLander.GLanderType.Special1),
            new GLander(R.drawable.kaos_ultimate, "Ultimate Kaos Trap", GLander.GLanderElement.Kaos, GLander.GLanderType.Special1),
            new GLander(R.drawable.life_broccoliguy, "Steamed Broccoli Guy", GLander.GLanderElement.Life, GLander.GLanderType.Special1),
            new GLander(R.drawable.life_hammer, "Weed Whacker", GLander.GLanderElement.Life, GLander.GLanderType.Special1),
            new GLander(R.drawable.life_shieldshredder, "Riot Shield Shredder", GLander.GLanderElement.Life, GLander.GLanderType.Special1),
            new GLander(R.drawable.life_snake, "Seed Serpent", GLander.GLanderElement.Life, GLander.GLanderType.Special1),
            new GLander(R.drawable.life_sword, "Jade Blade", GLander.GLanderElement.Life, GLander.GLanderType.Special1),
            new GLander(R.drawable.life_torch, "Emerald Enery", GLander.GLanderElement.Life, GLander.GLanderType.Special1),
            new GLander(R.drawable.life_toucan, "Oak Eagle", GLander.GLanderElement.Life, GLander.GLanderType.Special1),
            new GLander(R.drawable.life_yawn, "Shrub Shrieker", GLander.GLanderElement.Life, GLander.GLanderType.Special1),
            new GLander(R.drawable.light_owl, "Heavenly Hawk", GLander.GLanderElement.Light, GLander.GLanderType.Special1),
            new GLander(R.drawable.light_rebelgoblin, "Rebel Lob Goblin", GLander.GLanderElement.Light, GLander.GLanderType.Special1),
            new GLander(R.drawable.light_rocket, "Shining Ship", GLander.GLanderElement.Light, GLander.GLanderType.Special1),
            new GLander(R.drawable.light_yawn, "Beam Scream", GLander.GLanderElement.Light, GLander.GLanderType.Special1),
            new GLander(R.drawable.magic_axe, "Axe of Illusions", GLander.GLanderElement.Magic, GLander.GLanderType.Special1),
            new GLander(R.drawable.magic_hourglass, "Arcane Hourglass", GLander.GLanderElement.Magic, GLander.GLanderType.Special1),
            new GLander(R.drawable.magic_logholder, "Biter's Bane", GLander.GLanderElement.Magic, GLander.GLanderType.Special1),
            new GLander(R.drawable.magic_rocket, "Rune Rocket", GLander.GLanderElement.Magic, GLander.GLanderType.Special1),
            new GLander(R.drawable.magic_skull, "Sorcerous Skull", GLander.GLanderElement.Magic, GLander.GLanderType.Special1),
            new GLander(R.drawable.magic_totem, "Spell Slapper", GLander.GLanderElement.Magic, GLander.GLanderType.Special1),
            new GLander(R.drawable.tech_angel, "Automatic Angel", GLander.GLanderElement.Tech, GLander.GLanderType.Special1),
            new GLander(R.drawable.tech_hand, "Grabbing Gadget", GLander.GLanderElement.Tech, GLander.GLanderType.Special1),
            new GLander(R.drawable.tech_handstand, "Topsy Techy", GLander.GLanderElement.Tech, GLander.GLanderType.Special1),
            new GLander(R.drawable.tech_helmet, "Flying Helmet", GLander.GLanderElement.Tech, GLander.GLanderType.Special1),
            new GLander(R.drawable.tech_scepter, "Factory Flower", GLander.GLanderElement.Tech, GLander.GLanderType.Special1),
            new GLander(R.drawable.tech_shreadnaught, "Steampunk Shrednaught", GLander.GLanderElement.Tech, GLander.GLanderType.Special1),
            new GLander(R.drawable.tech_tiki, "Tech Totem", GLander.GLanderElement.Tech, GLander.GLanderType.Special1),
            new GLander(R.drawable.undead_axe, "Haunted Hatched", GLander.GLanderElement.Undead, GLander.GLanderType.Special1),
            new GLander(R.drawable.undead_captain, "Dream Piercer", GLander.GLanderElement.Undead, GLander.GLanderType.Special1),
            new GLander(R.drawable.undead_hand, "Grim Gripper", GLander.GLanderElement.Undead, GLander.GLanderType.Special1),
            new GLander(R.drawable.undead_orb, "Spirit Sphere", GLander.GLanderElement.Undead, GLander.GLanderType.Special1),
            new GLander(R.drawable.undead_orb_legendary, "Legendary Spirit Sphere", GLander.GLanderElement.Undead, GLander.GLanderType.Special1),
            new GLander(R.drawable.undead_skull, "Spectral Skull", GLander.GLanderElement.Undead, GLander.GLanderType.Special1),
            new GLander(R.drawable.undead_skull_legendary, "Legendary Spectral Skull", GLander.GLanderElement.Undead, GLander.GLanderType.Special1),
            new GLander(R.drawable.undead_snake, "Spooky Snake", GLander.GLanderElement.Undead, GLander.GLanderType.Special1),
            new GLander(R.drawable.water_angel, "Soaking Staff", GLander.GLanderElement.Water, GLander.GLanderType.Special1),
            new GLander(R.drawable.water_axe, "Aqua Axe", GLander.GLanderElement.Water, GLander.GLanderType.Special1),
            new GLander(R.drawable.water_brawlnchain, "Outlaw Brawl & Chain", GLander.GLanderElement.Water, GLander.GLanderType.Special1),
            new GLander(R.drawable.water_helmet, "Frost Helm", GLander.GLanderElement.Water, GLander.GLanderType.Special1),
            new GLander(R.drawable.water_jughead, "Flood Flask", GLander.GLanderElement.Water, GLander.GLanderType.Special1),
            new GLander(R.drawable.water_jughead_legendary, "Legendary Flood Flask", GLander.GLanderElement.Water, GLander.GLanderType.Special1),
            new GLander(R.drawable.water_logholder, "Wet Walter", GLander.GLanderElement.Water, GLander.GLanderType.Special1),
            new GLander(R.drawable.water_tiki, "Tidal Tiki", GLander.GLanderElement.Water, GLander.GLanderType.Special1)
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
    public static int topSwapper = 0;
    public static int bottomSwapper = 0;
    public static String topStr = "";
    public static String botStr = "";

    ArrayList<GLander> currentList = gAllButtons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide();


        String ast;

        TCPClient client = new TCPClient("192.168.178.20", 187);

        gAllButtons.addAll(gCoreButtons);
        gAllButtons.addAll(gVillainButtons);
        gAllButtons.addAll(gSwapperTopButtons);
        gAllButtons.addAll(gSwapperBottomButtons);

        for (int i = 0; i < gSwapperTopButtons.size(); i++) {
            gSwapperButtons.add(gSwapperTopButtons.get(i));
            gSwapperButtons.add(gSwapperBottomButtons.get(i));
        }

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
                    if (currentState == 0) {
                        displayedCharacters.clear();
                        displayedCharacters.addAll(gMenuButtons);
                        adapter.notifyDataSetChanged();
                    } else {
                        displayedCharacters.clear();
                        displayedCharacters.addAll(currentList);
                        adapter.notifyDataSetChanged();
                    }
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

                        filterVillainsByElement(result, currentList, filteredSkylanders, searchText);

                        for (GLander button : gAllButtons) {
                            if (!button.getText().toLowerCase().contains(searchText.toLowerCase())) {
                                //filteredSkylanders.remove(button);
                            }
                        }
                    } else {
                        searchText.replace(" ", "");

                        for (GLander button : currentList) {
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
                displayedCharacters.clear();
                switch (position) {
                    case 0:
                        currentList = gCoreButtons;
                        break;
                    case 1:
                        currentList = gSwapperButtons;
                        break;
                    case 2:
                        currentList = gTrapMasterButtons;
                        break;
                    case 3:
                        currentList = gTrapButtons;
                        break;
                    case 4:
                        currentList = gSwapperTopButtons;
                        break;
                    case 5:
                        currentList = gSwapperBottomButtons;
                        break;
                    case 6:
                        currentList = gVillainButtons;
                        break;

                }
                currentState = position + 1;
                displayedCharacters.addAll(currentList);
                adapter.notifyDataSetChanged();
            } else if (displayedCharacters.get(position) instanceof GLander) {
                GLander g = (GLander)displayedCharacters.get(position);
                if (g.swapper) {
                    if (g.low) {
                        bottomSwapper = g.image;
                        botStr = g.name;
                        adapter.notifyDataSetChanged();
                    } else {
                        topSwapper = g.image;
                        topStr = g.name;
                        adapter.notifyDataSetChanged();
                    }
                }

                String itemName = Byte.toString(g.type.getValue()) + g.getText();
                client.sendPacket(itemName);

                if (g.swapper) {
                    String item2Name;
                    if (g.low && topSwapper != 0) {
                        item2Name = "1" + topStr;
                        client.sendPacket(item2Name);
                    } else if (bottomSwapper != 0) {
                        item2Name = "2" + botStr;
                        client.sendPacket(item2Name);
                    }
                }
            }
        });

        EditText ipEditText = findViewById(R.id.ip_address_input);

        SharedPreferences sharedPreferences = getSharedPreferences("SkyAppPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String ipnum = sharedPreferences.getString("ipAddress", "21");

        client.updateIP("192.168.178." + ipnum);

        ipEditText.setText(ipnum);

        ipEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed for this implementation
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Not needed for this implementation
            }

            SharedPreferences sharedPreferences = getSharedPreferences("SkyAppPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            @Override
            public void afterTextChanged(Editable s) {
                String ipNumberStr = s.toString();
                if (!ipNumberStr.isEmpty()) {
                    int ipNumber = Integer.parseInt(ipNumberStr);
                    if (ipNumber < 0 || ipNumber > 255) {
                        ipEditText.setText("0");
                        editor.putString("ipAddress", "0");
                    } else {
                        String fullIpAddress = "192.168.178." + ipNumberStr;
                        TextView ipAddressTextView = findViewById(R.id.ip_address_text);
                        editor.putString("ipAddress", ipNumberStr);
                        editor.apply();
                        ipAddressTextView.setText(fullIpAddress);
                        client.updateIP(fullIpAddress);
                    }
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        if (currentState != 0) {
            searchView.setQuery("", true);
            displayedCharacters.clear();
            displayedCharacters.addAll(gMenuButtons);
            adapter.notifyDataSetChanged();
            currentList = gAllButtons;
            wasState = 0;
            currentState = 0;
        } else if (wasState == 1 && currentState == 0) {
            searchView.setQuery("", true);
            displayedCharacters.clear();
            displayedCharacters.addAll(gMenuButtons);
            adapter.notifyDataSetChanged();
            currentList = gAllButtons;
            wasState = 0;
            currentState = 0;
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