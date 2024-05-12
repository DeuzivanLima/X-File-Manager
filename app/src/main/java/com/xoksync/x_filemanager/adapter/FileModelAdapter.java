package com.xoksync.x_filemanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xoksync.x_filemanager.R;
import com.xoksync.x_filemanager.models.FileModel;

import java.util.List;

public class FileModelAdapter extends RecyclerView.Adapter<FileModelAdapter.ViewHolder> {
    private Context context;
    private List<FileModel> files;

    public FileModelAdapter(Context context, List<FileModel> files) {
        this.context = context;
        this.files = files;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.file_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(files.get(position).getName());
        holder.icon.setImageResource(files.get(position).getIcon_id());
    }

    @Override
    public int getItemCount() {
        return files.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView icon;
        private TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.file_icon);
            name = itemView.findViewById(R.id.file_name);
        }
    }
}
