package com.example.hearthstonemvvm.ViewModel;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hearthstonemvvm.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    ImageView ivCardArt;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        ivCardArt = itemView.findViewById(R.id.iv_card_art);
    }

}
