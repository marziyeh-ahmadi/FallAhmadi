package com.example.fall;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PoetsListViewHolder extends RecyclerView.ViewHolder {
    TextView textViewName;
    TextView textViewTavalood;
    TextView textViewVafaat;
    TextView textViewPlaceBirth;
    TextView textViewPlaceDead;

    public PoetsListViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewName = itemView.findViewById(R.id.textViewName);
        textViewTavalood = itemView.findViewById(R.id.textViewTavalood);
        textViewVafaat = itemView.findViewById(R.id.textViewVafaat);
        textViewPlaceBirth = itemView.findViewById(R.id.textViewPlaceBirth);
        textViewPlaceDead = itemView.findViewById(R.id.textViewPlaceDead);
    }
}
