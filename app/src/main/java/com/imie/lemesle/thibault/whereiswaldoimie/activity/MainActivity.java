package com.imie.lemesle.thibault.whereiswaldoimie.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.imie.lemesle.thibault.whereiswaldoimie.R;

import java.util.ArrayList;

import manager.LevelManager;
import model.Level;



public class MainActivity extends AppCompatActivity {

    public boolean init;
    public LevelManager manager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = new LevelManager(this);
        SharedPreferences sp = this. getSharedPreferences("loadBDD", MODE_PRIVATE);
        init = sp.getBoolean("loadBDD", false);
        if(!init){
            boolean ajout = manager.populateLevel();
            if(ajout){
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("loadBDD",true);
                editor.commit();
            }
        }else{
            Log.e("Erreur bdd", "Objet deja dans la base");
        }

    }

    public void newGame(View view) {
        //Level level = new Level(1,745,275);
        manager.open();
        Level level =  manager.getLevel(1);
        manager.close();
        SharedPreferences sp = this. getSharedPreferences("level", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("level",1);
        editor.commit();
        Intent intent = new Intent(MainActivity.this, FullscreenActivity.class);
        intent.putExtra("level",level);
        startActivity(intent);
        finish();
    }


    public void loadGame(View view) {
        SharedPreferences sp = this. getSharedPreferences("level", MODE_PRIVATE);
        int numlevel = sp.getInt("level",0);
        manager.open();
        Level level =  manager.getLevel(numlevel);
        manager.close();
        Intent intent = new Intent(MainActivity.this, FullscreenActivity.class);
        intent.putExtra("level",level);
        startActivity(intent);
        finish();
    }
}
