package com.example.project_exam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Cat> cats;

    public MyRecyclerViewAdapter (Context context, ArrayList<Cat> cats) {
        this.mInflater = LayoutInflater.from(context);
        this.cats = cats;
    }
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;


    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_main, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Cat cat = cats.get(position);
        holder.recyclerView.setText(cat);
        holder.recyclerView(cats.getBreed());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return cats.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        RecyclerView recyclerView;

        ViewHolder(View itemView) {
            super(itemView);

            recyclerView = itemView.findViewById(R.id.recyclerView);
            itemView.setOnClickListener(this);
        }

        public RecyclerView getName() { return recyclerView; }



        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Cat getItem(int id) {
        return cats.get(id);
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
