package com.uatm.codezero.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uatm.codezero.DetailsFruitsActivity;
import com.uatm.codezero.R;
import com.uatm.codezero.object.Fruit;

import java.util.ArrayList;

public class RvFruitAdapter extends RecyclerView.Adapter<RvFruitAdapter.RvFruitVH> {
    ArrayList<Fruit> fruits;
    Context context;

    public RvFruitAdapter(ArrayList<Fruit> fruits, Context context) {
        this.fruits = fruits;
        this.context = context;
    }

    @NonNull
    @Override
    public RvFruitVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vue_fruit, parent, false);
        return new RvFruitVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvFruitVH holder, @SuppressLint("RecyclerView")  int position) {
        holder.tvNom.setText(fruits.get(position).getNom());
        holder.imgvImage.setImageResource(fruits.get(position).getImageLink());
        holder.layFruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, DetailsFruitsActivity.class).putExtra("Fruits",fruits.get(position)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    class RvFruitVH extends RecyclerView.ViewHolder {
        TextView tvNom;
        ImageView imgvImage;
        LinearLayout layFruit;

        public RvFruitVH(@NonNull View itemView) {
            super(itemView);
            layFruit=itemView.findViewById(R.id.lay_fruit);
            tvNom = itemView.findViewById(R.id.tv_nom_fruit);
            imgvImage = itemView.findViewById(R.id.imgv_image_fruit);
        }
    }
}
