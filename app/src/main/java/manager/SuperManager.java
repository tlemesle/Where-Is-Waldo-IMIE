package manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import database.BDDSQLITE;

/**
 * Created by thibault on 09/11/17.
 */

public abstract class SuperManager {

    private static final String NOM_BASE = "MyDatabase";
    private static final int VERSION_BDD= 3;
    public SQLiteDatabase bdd;
    public BDDSQLITE bddsqlite;

    public SuperManager (Context context){
        bddsqlite = new BDDSQLITE(context, NOM_BASE, null, VERSION_BDD);
    }

    public void open(){
        bdd = bddsqlite.getWritableDatabase();
    }

    public void close(){
        bdd.close();
    }

}
