package com.uatm.codezero;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    LinearLayout layEcole;
    LinearLayout layFilieres;
    LinearLayout layContacts;
    LinearLayout layApropos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layEcole = findViewById(R.id.lay_ecole);
        layFilieres = findViewById(R.id.lay_filieres);
        layContacts = findViewById(R.id.lay_contacts);
        layApropos = findViewById(R.id.lay_a_propos);


        layEcole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, EcoleActivity.class);
                startActivity(intent);
                startActivity(new Intent(MainActivity.this, EcoleActivity.class));
            }
        });
        layFilieres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FilieresActivity.class));
            }
        });
        layContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ContactsActivity.class));
            }
        });
        layApropos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AproposActivity.class));
            }
        });
    }
}