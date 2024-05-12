package com.xoksync.x_filemanager.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

import com.xoksync.x_filemanager.R;
import com.xoksync.x_filemanager.adapter.FileModelAdapter;
import com.xoksync.x_filemanager.databinding.ActivityMainBinding;
import com.xoksync.x_filemanager.models.FileModel;
import com.xoksync.x_filemanager.utils.LoadFiles;
import com.xoksync.x_filemanager.utils.PermissionRequest;
import com.xoksync.x_filemanager.utils.ToolbarManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    static {
        System.loadLibrary("x_filemanager");
    }

    private ActivityMainBinding binding;
    private ToolbarManager toolbar_manager;
    private List<FileModel> files;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        PermissionRequest.full(MainActivity.this);
        setup();
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        files = LoadFiles.from(path);

        FileModelAdapter adapter = new FileModelAdapter(MainActivity.this, files);
        binding.filesList.setAdapter(adapter);
        binding.filesList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    private void setup() {
        toolbar_manager = new ToolbarManager(this, findViewById(R.id.toolbar_main), R.menu.menu_main);
        toolbar_manager.setup();
    }
}