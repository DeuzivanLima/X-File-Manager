package com.xoksync.x_filemanager.utils;

import android.content.Context;
import android.view.Menu;

import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;

public class ToolbarManager {
    private Toolbar toolbar;
    private int menu_id;
    Context context;

    public ToolbarManager(Context context, Toolbar toolbar, int menu_id) {
        setMenu_id(menu_id);
        setToolbar(toolbar);
        setContext(context);
    }

    public void setup() {
        toolbar.inflateMenu(menu_id);
        toolbar.setPadding(128 + 24, 0, 0, 0);
        toolbar.setTitle("X-File Manager");
    }

    public Context getContext() {
        return context;}

    public void setContext(Context context) {
        this.context = context;
    }

    private void setup_menu() {

    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }
}
