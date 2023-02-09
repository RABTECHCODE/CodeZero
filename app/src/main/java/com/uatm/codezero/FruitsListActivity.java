package com.uatm.codezero;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uatm.codezero.adapter.RvFruitAdapter;
import com.uatm.codezero.object.Fruit;

import java.util.ArrayList;

public class FruitsListActivity extends AppCompatActivity {
    Context context;
    private RecyclerView rvFruits;
    ArrayList<Fruit> fruits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits_list);

        initView();

        context =this;

        fruits.add(new Fruit(R.mipmap.fruit_ananas, "Ananas",""));
        fruits.add(new Fruit(R.mipmap.fruit_orange, "Orange",""));
        fruits.add(new Fruit(R.mipmap.fruit_fraise, "Fraise",""));
        fruits.add(new Fruit(R.mipmap.fruit_mangue, "Mangue",""));
        fruits.add(new Fruit(R.mipmap.fruit_banane, "Banane",""));
        fruits.add(new Fruit(R.mipmap.fruit_cerise, "Cerise",""));
        fruits.add(new Fruit(R.mipmap.fruit_pomme, "Pomme", context.getString(R.string.str_historique_uatm)));


        rvFruits.setAdapter(new RvFruitAdapter(fruits, context));
        rvFruits.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

    }

    private void initView() {
        rvFruits = (RecyclerView) findViewById(R.id.rv_fruits);
    }
}