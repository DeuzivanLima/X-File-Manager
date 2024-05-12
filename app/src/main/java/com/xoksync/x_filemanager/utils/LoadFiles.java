package com.xoksync.x_filemanager.utils;

import com.xoksync.x_filemanager.R;
import com.xoksync.x_filemanager.models.FileModel;

import java.io.File;
import java.util.ArrayList;

public class LoadFiles {
    public static ArrayList<FileModel> from(String path) {
        File[] arr_file = (new File(path)).listFiles();
        ArrayList<FileModel> files = new ArrayList<FileModel>();

        assert arr_file != null;
        for(File file : arr_file) {
            boolean is_folder = file.isDirectory();
            files.add(new FileModel(file.getName(),
                    is_folder ? FileModel.Type.FOLDER : FileModel.Type.TXT,
                    is_folder, is_folder ? R.drawable.icon_folder : R.drawable.icon_file));
        }

        return files;
    }
}
