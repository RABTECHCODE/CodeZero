package com.uatm.codezero;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FormActivity extends AppCompatActivity {

    private EditText edtNom;
    private EditText edtTel;
    private Button btEnregistrer;
    private TextView tvEcran;
    private RecyclerView rv;


    /*  //Code pour faire un appel
      Intent intent = new Intent(Intent.ACTION_CALL);
                  intent.setData(Uri.parse("tel:+22997713235"));
      startActivity(intent);
      //Fin code pour faire un  appel*/
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        initView();
        context = this;



        btEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = edtNom.getText().toString();
                String tel = edtTel.getText().toString();
                tvEcran.setText(tvEcran.getText().toString() + nom + "\n" + tel + "\n\n-----\n\n"
                );


                //startActivity(new Intent(FormActivity.this, JeuHasard.class).putExtra("nom", edtNom.getText().toString()));
                edtNom.setText("");
                edtTel.setText("");
            }
        });
    }

    private void initView() {
        edtNom = (EditText) findViewById(R.id.edt_nom);
        edtTel = (EditText) findViewById(R.id.edt_tel);
        btEnregistrer = (Button) findViewById(R.id.bt_enregistrer);
        tvEcran = (TextView) findViewById(R.id.tv_ecran);
        rv = (RecyclerView) findViewById(R.id.rv);
    }
}