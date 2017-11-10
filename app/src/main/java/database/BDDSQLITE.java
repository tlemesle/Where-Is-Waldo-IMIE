package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by thibault on 09/11/17.
 */

public class BDDSQLITE extends SQLiteOpenHelper {

    public static final String TABLE_LEVEL = "LEVEL";
    public static final String COL_ID = "ID";
    public static final String COL_X = "X";
    public static final String COL_Y = "Y";
    private static final String CREATE_TABLE_LEVEL =
            "CREATE TABLE " + TABLE_LEVEL + " ("
                    + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_X + " INTEGER NOT NULL, "
                    + COL_Y + " INTEGER NOT NULL);";

    public BDDSQLITE(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_LEVEL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_LEVEL +";");
        onCreate(sqLiteDatabase);
    }
}
