package com.uatm.codezero;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.uatm.codezero.object.Fruit;

public class DetailsFruitsActivity extends AppCompatActivity {
    private ImageView imgvImageFruit;
    private TextView tvNomFruit;
    private TextView tvBienfaitFruit;
    private Fruit fruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_fruits);
        initView();
        fruit= (Fruit) getIntent().getSerializableExtra("Fruits");
        tvNomFruit.setText(fruit.getNom());
        tvBienfaitFruit.setText(fruit.getBien_fait());
        imgvImageFruit.setImageResource(fruit.getImageLink());


    }

    private void initView() {
        imgvImageFruit = (ImageView) findViewById(R.id.imgv_image_fruit);
        tvNomFruit = (TextView) findViewById(R.id.tv_nom_fruit);
        tvBienfaitFruit = (TextView) findViewById(R.id.tv_bienfait_fruit);
    }
}