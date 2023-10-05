package com.pragyan.ioesyllabusapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerItemAdapter extends RecyclerView.Adapter<RecyclerItemAdapter.ViewHolder> {
    ArrayList<ItemStructure> mArrayList;
    Context context;
    LayoutInflater layoutInflater;
    public RecyclerItemAdapter(Context context, ArrayList<ItemStructure> arrayList ) {
        this.mArrayList=arrayList;
        this.context=context;
        layoutInflater=LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.img_itemlist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(mArrayList.get(position).getImgId());
        holder.title.setText(mArrayList.get(position).getTitle());
        holder.description.setText(mArrayList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        TextView description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            title=itemView.findViewById(R.id.tvItemTitle);
            description=itemView.findViewById(R.id.tvItemDescription);
        }
    }
}
