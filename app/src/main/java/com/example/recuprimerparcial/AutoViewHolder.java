package com.example.recuprimerparcial;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class AutoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView rvMarca;
    public TextView rvModelo;
    public View v;
    public OnClickItemView clickItem;
    public Integer index;

    public AutoViewHolder(View v, OnClickItemView clickItem) {
        super(v);
        this.rvMarca = v.findViewById(R.id.rvMarcaAuto);
        this.rvModelo = v.findViewById(R.id.rvmodeloAuto);
        this.v = v;
        this.v.setOnClickListener(this);
        this.clickItem = clickItem;
    }

    public void setIndex(int index) {
        this.index = Integer.valueOf(index);
    }

    @Override
    public void onClick(View v) {
        this.clickItem.onItemClick(index);
    }
}
