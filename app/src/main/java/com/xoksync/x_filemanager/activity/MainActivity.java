package com.xoksync.x_filemanager.activity;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xoksync.x_filemanager.R;
import com.xoksync.x_filemanager.RecycleViewOnClick;
import com.xoksync.x_filemanager.adapter.FileModelAdapter;
import com.xoksync.x_filemanager.databinding.ActivityMainBinding;
import com.xoksync.x_filemanager.models.FileModel;
import com.xoksync.x_filemanager.utils.LoadFiles;
import com.xoksync.x_filemanager.utils.PermissionRequest;
import com.xoksync.x_filemanager.utils.ToolbarManager;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ToolbarManager toolbar_manager;
    private ArrayList<FileModel> files;
    private String current_path = "";
    private FileModelAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        PermissionRequest.full(MainActivity.this);
        files = new ArrayList<>();

        setup();
        cd(Environment.getExternalStorageDirectory().getAbsolutePath());

        binding.filesList.addOnItemTouchListener(new RecycleViewOnClick(MainActivity.this, binding.filesList, new RecycleViewOnClick.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                FileModel file = files.get(position);
                if(file.isIs_folder()) {
                    cd(files.get(position).getName());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onLongItemClick(View view, int position) {
            }
        }));
        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                cd("..");
                adapter.notifyDataSetChanged();
            }
        });

        adapter = new FileModelAdapter(MainActivity.this, files);
        binding.filesList.setAdapter(adapter);
        binding.filesList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    private void setup() {
        toolbar_manager = new ToolbarManager(this, findViewById(R.id.toolbar_main), R.menu.menu_main);
        toolbar_manager.setup();
    }



    private void cd(String to_path) {
        if(to_path.equals("..")) {
            int lastSlashIndex = current_path.lastIndexOf("/");
            if (lastSlashIndex >= 0) {
                current_path = current_path.substring(0, lastSlashIndex);
            }
        } else {
            current_path += (!current_path.isEmpty() ? "/" : "") + to_path;
        }
        files.clear();
        files.addAll(LoadFiles.from(current_path));
    }

    static {
        System.loadLibrary("x_filemanager");
    }
}