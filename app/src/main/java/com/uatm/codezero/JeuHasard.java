package com.uatm.codezero;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class JeuHasard extends AppCompatActivity {

    private TextView tvNbr;
    private Button btGenerer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu_hasard);

        initView();

        btGenerer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int nbr = random.nextInt();
                Log.e("Nbr " , String.valueOf(nbr));
                tvNbr.setText(String.valueOf(nbr));
            }
        });

    }

    private void initView() {
        tvNbr = (TextView) findViewById(R.id.tv_nbr);
        btGenerer = (Button) findViewById(R.id.bt_generer);
    }
}