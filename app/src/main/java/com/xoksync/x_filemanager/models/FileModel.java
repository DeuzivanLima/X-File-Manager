package com.xoksync.x_filemanager.models;

public class FileModel {
    public enum Type {
        TXT, IMAGE, BINARY, VIDEO,
        APK, XFM, YML, FOLDER, UNKNOW
    }

    private String name;
    private Type extension;
    private boolean is_folder;
    private int icon_id;

    public FileModel(String name, FileModel.Type type, boolean is_folder, int icon_id) {
        setName(name);
        setExtension(type);
        setIs_folder(is_folder);
        setIcon_id(icon_id);
    }

    public int getIcon_id() {
        return icon_id;
    }

    public void setIcon_id(int icon_id) {
        this.icon_id = icon_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getExtension() {
        return extension;
    }

    public void setExtension(Type extension) {
        this.extension = extension;
    }

    public boolean isIs_folder() {
        return is_folder;
    }

    public void setIs_folder(boolean is_folder) {
        this.is_folder = is_folder;
    }
}
