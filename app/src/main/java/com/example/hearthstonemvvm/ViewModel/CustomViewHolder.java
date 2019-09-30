package com.example.hearthstonemvvm.ViewModel;

import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hearthstonemvvm.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    ImageView ivCardArt;
    TextView tvCardNumber;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        ivCardArt = itemView.findViewById(R.id.iv_card_art);
        tvCardNumber = itemView.findViewById(R.id.tv_card_number);
    }

}
