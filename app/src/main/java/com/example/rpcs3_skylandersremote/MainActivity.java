package com.example.rpcs3_skylandersremote;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.rpcs3_skylandersremote.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'rpcs3_skylandersremote' library on application startup.
    static {
        System.loadLibrary("rpcs3_skylandersremote");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'rpcs3_skylandersremote' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}