package com.imie.lemesle.thibault.whereiswaldoimie.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.imie.lemesle.thibault.whereiswaldoimie.R;

import org.w3c.dom.Text;

import manager.LevelManager;
import model.Level;

/**
 * Created by thibault on 09/11/17.
 */

public class ResultActivity extends AppCompatActivity {

    public LevelManager manager;
    public int numLevel;
    public int nextLevel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Button nextLevelButton = (Button)findViewById(R.id.nextLevel);
        TextView textView = (TextView)findViewById(R.id.time);
        String time = " : "+getIntent().getExtras().getString("time");
        textView.setText(String.valueOf(time));
        numLevel = getIntent().getExtras().getInt("numLevel");
        nextLevel = numLevel+1;
        if(nextLevel > 5 ){
            nextLevelButton.setEnabled(false);
        }
    }

    public void backMenu(View view){
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void nextLevel(View view) {
        SharedPreferences sp = this. getSharedPreferences("level", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("level",nextLevel);
        editor.commit();
        manager = new LevelManager(this);
        manager.open();
        Level l = manager.getLevel(nextLevel);
        manager.close();
        Intent intent = new Intent(ResultActivity.this,FullscreenActivity.class);
        intent.putExtra("level",l);
        startActivity(intent);
        finish();
    }
}
