package com.uatm.codezero;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class JeuHasard extends AppCompatActivity {


    private TextView tvScore;
    private TextView tvNomFruit;
    private ImageView imgvFruit1;
    private ImageView imgvFruit2;
    private ImageView imgvFruit3;
    private ImageView imgvFruit4;

    ArrayList<String> nomFruitsList = new ArrayList<>();
    int indexImageInImgv1 = -1;
    int indexImageInImgv2 = -1;
    int indexImageInImgv3 = -1;
    int indexImageInImgv4 = -1;

    int positionBonneReponse = 0;
    int score = 0;
    int nbrEchec=0;

    int[] idImageFruitsList = {
            R.mipmap.fruit_orange,
            R.mipmap.fruit_pomme,
            R.mipmap.fruit_ananas,
            R.mipmap.fruit_fraise,
            R.mipmap.fruit_mangue,
            R.mipmap.fruit_cerise,
            R.mipmap.fruit_banane
    };


    Context context;

    MediaPlayer backgroudPlayer;
    MediaPlayer winPlayer;
    MediaPlayer lostPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu_hasard);



        initView();
        context = this;

        backgroudPlayer =MediaPlayer.create(context, R.raw.son);
        backgroudPlayer.start();



        nomFruitsList.add("Orange");
        nomFruitsList.add("Pomme");
        nomFruitsList.add("Ananas");
        nomFruitsList.add("Fraise");
        nomFruitsList.add("Mangue");
        nomFruitsList.add("Cerise");
        nomFruitsList.add("Banane");


        generateFruit();

        imgvFruit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                verification(1);

            }
        });

        imgvFruit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                verification(2);
            }
        });

        imgvFruit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                verification(3);
            }
        });

        imgvFruit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                verification(4);
            }
        });

    }

    void generateFruit() {
        Random random = new Random();
        int index = random.nextInt(nomFruitsList.size());
        tvNomFruit.setText(nomFruitsList.get(index));


        positionBonneReponse = random.nextInt(4) + 1;
        if (positionBonneReponse == 1) {
            imgvFruit1.setImageResource(idImageFruitsList[index]);
            indexImageInImgv1 = index;
            genarateImage(imgvFruit2);
            genarateImage(imgvFruit3);
            genarateImage(imgvFruit4);
        } else if (positionBonneReponse == 2) {
            imgvFruit2.setImageResource(idImageFruitsList[index]);
            indexImageInImgv2 = index;
            genarateImage(imgvFruit1);
            genarateImage(imgvFruit3);
            genarateImage(imgvFruit4);
        } else if (positionBonneReponse == 3) {
            imgvFruit3.setImageResource(idImageFruitsList[index]);
            indexImageInImgv3 = index;
            genarateImage(imgvFruit1);
            genarateImage(imgvFruit2);
            genarateImage(imgvFruit4);
        } else if (positionBonneReponse == 4) {
            imgvFruit4.setImageResource(idImageFruitsList[index]);
            indexImageInImgv4 = index;
            genarateImage(imgvFruit1);
            genarateImage(imgvFruit2);
            genarateImage(imgvFruit3);
        }
        //imgvFruit1.setImageResource(idImageFruitsList[index]);

    }

    void genarateImage(ImageView imgv) {
        int index = -1;
        do {
            Random random = new Random();
            index = random.nextInt(idImageFruitsList.length);
        } while (index == indexImageInImgv1 || index == indexImageInImgv2 || index == indexImageInImgv3 || index == indexImageInImgv4);


        if (imgv == imgvFruit1) {
            indexImageInImgv1 = index;
        } else if (imgv == imgvFruit2) {
            indexImageInImgv2 = index;
        } else if (imgv == imgvFruit3) {
            indexImageInImgv3 = index;
        } else if (imgv == imgvFruit4) {
            indexImageInImgv4 = index;
        }

        imgv.setImageResource(idImageFruitsList[index]);

    }

    void verification(int positionClicked) {

        if (positionBonneReponse == positionClicked) {
            score += 10;
            winPlayer = MediaPlayer.create(context, R.raw.win);
            winPlayer.start();
            Toast.makeText(context, "Gagné", Toast.LENGTH_SHORT).show();

        } else {
            score -= 5;
            nbrEchec++;
            lostPlayer = MediaPlayer.create(context, R.raw.lost);
            lostPlayer.start();
            Toast.makeText(context, "Perdu", Toast.LENGTH_SHORT).show();

        }
        tvScore.setText("Score : " + String.valueOf(score));
        if(nbrEchec<3){
            generateFruit();

        }else{
            backgroudPlayer.stop();
            startActivity(new Intent(JeuHasard.this, MainActivity.class));
        }
    }

    private void initView() {
        tvScore = (TextView) findViewById(R.id.tv_score);
        tvNomFruit = (TextView) findViewById(R.id.tv_nom_fruit);
        imgvFruit1 = (ImageView) findViewById(R.id.imgv_fruit1);
        imgvFruit2 = (ImageView) findViewById(R.id.imgv_fruit2);
        imgvFruit3 = (ImageView) findViewById(R.id.imgv_fruit3);
        imgvFruit4 = (ImageView) findViewById(R.id.imgv_fruit4);
    }
}