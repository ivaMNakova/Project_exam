package com.example.project_exam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    public interface ItemClickListener {
        void onItemClick(int position);
    }

    private ItemClickListener clickListener;

    void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    private ArrayList<Cat> cats;

    public MyRecyclerViewAdapter ( ArrayList<Cat> cats) {
        this.cats = cats;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cat, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final Cat cat = cats.get(position);
        holder.catName.setText(cat.getName());
        holder.catBreed.setText(cat.getBreed());
        holder.actionButton.setVisibility(cat.getStatus() ? View.VISIBLE : View.INVISIBLE);
        holder.actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cats.remove(cat);
                notifyDataSetChanged();
            }
        });
        holder.root.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(position);
            }
        });
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return cats.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout root;
        TextView catName;
        TextView catBreed;
        Button actionButton;

        ViewHolder(View itemView) {
            super(itemView);
            root = itemView.findViewById(R.id.root);
            catName = itemView.findViewById(R.id.cat_name);
            catBreed = itemView.findViewById(R.id.cat_breed);
            actionButton = itemView.findViewById(R.id.cat_status);
        }
    }




}
