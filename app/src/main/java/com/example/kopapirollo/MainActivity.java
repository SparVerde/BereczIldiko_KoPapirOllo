package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button button1, button2, button3;
    private TextView Text1, Text2, Text3;
    private ImageView imageHp1, imageHp2, imageHp3, imageHp4, imageHp5, imageHp6, imageHp7, imageHp8;
    private int sajatValasz, gepiValasz, dontetlen, gyozelem, vereseg, jatek, sajatelet, gepielet;
    Random rnd = new Random();


    private AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        valasztas();

    }
    public void init() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        Text1 = findViewById(R.id.Text1);
        Text2 = findViewById(R.id.Text2);
        Text3 = findViewById(R.id.Text3);
        imageHp1 = findViewById(R.id.imageHp1);
        imageHp2 = findViewById(R.id.imageHp2);
        imageHp3 = findViewById(R.id.imageHp3);
        imageHp4 = findViewById(R.id.imageHp4);
        imageHp5 = findViewById(R.id.imageHp5);
        imageHp6 = findViewById(R.id.imageHp6);
        imageHp7 = findViewById(R.id.imageHp7);
        imageHp8 = findViewById(R.id.imageHp8);
        sajatValasz = 0;
        gepiValasz =0;
        dontetlen = 0;
        gyozelem =0;
        vereseg = 0;
        jatek = 0;
        sajatelet = 3;
        gepielet = 3;

    }

    public void valasztas(){
    button1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        imageHp8.setImageResource(R.drawable.rock);
        sajatValasz = 0;
        gepivalasztas();
        eredmeny();
    }
});
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageHp8.setImageResource(R.drawable.paper);
                sajatValasz = 1;
                gepivalasztas();
                eredmeny();
                            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageHp8.setImageResource(R.drawable.scissors);
                sajatValasz = 2;
                gepivalasztas();
                eredmeny();
            }
        });


    }

    public void gepivalasztas(){
        gepiValasz = rnd.nextInt(3);
        if (gepiValasz == 0){
        imageHp7.setImageResource(R.drawable.rock);}
        else if (gepiValasz == 1){
            imageHp7.setImageResource(R.drawable.paper);}
        else{imageHp7.setImageResource(R.drawable.scissors);}
    }

    public void eredmeny(){
        if (gepiValasz == sajatValasz){
            Toast.makeText(MainActivity.this,"Döntetlen", Toast.LENGTH_SHORT).show();
            dontetlen++;
            Text1.setText(String.valueOf("Döntetlenek száma: "+dontetlen));
        }
        else if (gepiValasz==0&&sajatValasz==1||gepiValasz==1&&sajatValasz==2||gepiValasz==2&&sajatValasz==0){
            Toast.makeText(MainActivity.this,"Nyertél", Toast.LENGTH_SHORT).show();
            gyozelem++;
            gepielet--;
            eletLevon();

        }
        else{
            Toast.makeText(MainActivity.this,"Vesztettél", Toast.LENGTH_SHORT).show();
            vereseg++;
            sajatelet--;
            eletLevon();

        }
    }

    public void eletLevon(){
//kicseréljük a képet set.ImageResource-al
        switch (sajatelet){
            case 2:
                imageHp4.setImageResource(R.drawable.heart1);
                break;
            case 1:
                imageHp5.setImageResource(R.drawable.heart1);
                break;
            case 0:
                imageHp6.setImageResource(R.drawable.heart1);
                AlertDialogCreate();
                alertDialog.setTitle("Vesztettél!");
                //alertDialog.create();
                alertDialog.show();
                break;
        }
        switch (gepielet){
            case 2:
                imageHp1.setImageResource(R.drawable.heart1);
                break;
            case 1:
                imageHp2.setImageResource(R.drawable.heart1);
                break;
            case 0:
                imageHp3.setImageResource(R.drawable.heart1);
                AlertDialogCreate();
                alertDialog.setTitle("Győzelem");
                //alertDialog.create();
                alertDialog.show();
                break;
        }
    }

    public void resetGame() {
        sajatelet =3;
        gepielet = 3;
        vereseg = 0;
        gyozelem = 0;
        dontetlen = 0;
        imageHp1.setImageResource(R.drawable.heart2);
        imageHp2.setImageResource(R.drawable.heart2);
        imageHp3.setImageResource(R.drawable.heart2);
        imageHp4.setImageResource(R.drawable.heart2);
        imageHp5.setImageResource(R.drawable.heart2);
        imageHp6.setImageResource(R.drawable.heart2);
        Text1.setText(String.valueOf("Döntetlenek száma: "+dontetlen));

    }

    public void AlertDialogCreate() {
        alertDialog= new AlertDialog.Builder(MainActivity.this);
        alertDialog.setMessage("Szeretne új játékot játszani?");
        alertDialog.setNegativeButton("NEM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialog.setPositiveButton("IGEN", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                resetGame();
            }
        });
    }

    }