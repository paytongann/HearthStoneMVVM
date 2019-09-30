package com.example.hearthstonemvvm.ViewModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hearthstonemvvm.Model.CardPojo;
import com.example.hearthstonemvvm.Model.ResultsPojo;
import com.example.hearthstonemvvm.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    ResultsPojo dataSet;
    Context context;

    public CustomAdapter(Context context, ResultsPojo dataSet) {
        this.context = context;
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tvCardNumber.setText(dataSet.basic.get(position).cardId);
        if (dataSet.basic.get(position).img != null){
            Glide.with(context).load(dataSet.basic.get(position).img).into(holder.ivCardArt);
        } else {
            holder.ivCardArt.setImageResource(R.drawable.noimagefound);
        }
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.basic.size() : 0;
    }
}
