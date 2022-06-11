package com.example.fall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fall.retrofit.response.Poet;

import java.util.List;

public class PoetListAdapter extends RecyclerView.Adapter<PoetsListViewHolder> {
    public PoetListAdapter(Context context, List<Poet> poetList) {
        this.context = context;
        this.mPoetList = poetList;
    }

    Context context;
    List<Poet> mPoetList;

    @NonNull
    @Override
    public PoetsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PoetsListViewHolder(LayoutInflater.from(context).inflate(R.layout.item_poet, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PoetsListViewHolder holder, int position) {
        Poet poet = mPoetList.get(position);
        holder.textViewName.setText(poet.name);
        holder.textViewTavalood.setText("سال تولد: " + poet.birthYearInLHijri);
        holder.textViewVafaat.setText("سال وفات: " + poet.deathYearInLHijri);
        holder.textViewPlaceBirth.setText("مکان تولد: " + poet.birthPlace);
        holder.textViewPlaceDead.setText("مکان وفات: " + poet.deathPlace);
    }

    @Override
    public int getItemCount() {
        return mPoetList.size();
    }
}
