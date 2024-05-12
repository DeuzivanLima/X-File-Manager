package com.xoksync.x_filemanager.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.xoksync.x_filemanager.R;
import com.xoksync.x_filemanager.databinding.ActivityMainBinding;
import com.xoksync.x_filemanager.utils.ToolbarManager;

public class MainActivity extends AppCompatActivity {
    static {
        System.loadLibrary("x_filemanager");
    }

    private ActivityMainBinding binding;
    private ToolbarManager toolbar_manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setup();
    }

    private void setup() {
        toolbar_manager = new ToolbarManager(this, findViewById(R.id.toolbar_main), R.menu.menu_main);
        toolbar_manager.setup();
    }
}