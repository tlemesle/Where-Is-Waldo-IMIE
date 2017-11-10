package manager;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

import database.BDDSQLITE;
import model.Level;

public class LevelManager extends SuperManager {

    public LevelManager(Context context) {
        super(context);
    }

    public long insertLevel(Level l){
        ContentValues ctv = new ContentValues();
        ctv.put(BDDSQLITE.COL_ID,l.getId());
        ctv.put(BDDSQLITE.COL_X,l.getSolutionX());
        ctv.put(BDDSQLITE.COL_Y,l.getSolutionY());
        return bdd.insert(BDDSQLITE.TABLE_LEVEL, null, ctv);
    }

    public Cursor getLevel(){
        Cursor c = bdd.rawQuery("SELECT "+BDDSQLITE.COL_ID+" AS _id, "
                +BDDSQLITE.COL_X+" AS _x, "
                +BDDSQLITE.COL_Y+" AS _y; ", null);

        return c;
    }

    public boolean populateLevel(){
        boolean ok = false;
        Level level1 = new Level(1,745,275);
        Level level2 = new Level(2,155,150);
        Level level3 = new Level(3,245,135);
        Level level4 = new Level(4,570,500);
        Level level5 = new Level(5,848,416);

        //Level[] levelAInserer = {animal1, animal2, animal3, animal4};
        Level[] levelAInserer = {level1, level2, level3,level4,level5};
        open();
        bdd.beginTransaction();
        try{
            for (Level level : levelAInserer){
                if(insertLevel(level) > -1){
                    Log.e("INSERT","LEVEL INSERE DANS LA BDD");
                }
            }
            bdd.setTransactionSuccessful();
            ok = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        bdd.endTransaction();
        close();
        return ok;
    }

    public Level getLevel(int id){
        Cursor c = bdd.rawQuery("SELECT "+BDDSQLITE.COL_ID+" AS _id, "
                +BDDSQLITE.COL_X+" AS _X, "
                +BDDSQLITE.COL_Y+" AS _Y FROM "+ BDDSQLITE.TABLE_LEVEL+" WHERE _id = "+ String.valueOf(id)+" ; "
                , null);

        c.moveToFirst();
        Level l = new Level(c.getInt(0),c.getInt(1),c.getInt(2));

        return l;
    }
}
