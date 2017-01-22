package akitasoft.bydbuzz.com.bydbuzz.data.dbHelper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import akitasoft.bydbuzz.com.bydbuzz.data.contracts.SessionContract;

/**
 * Created by marty on 1/18/2017.
 */

public class SessionDbHelper {

    private SQLiteDatabase sql;

    public SessionDbHelper(SQLiteDatabase sql) {
        this.sql = sql;
    }

    public void create() {
        final String SQL_CREATE_SESSION_TABLE = "CREATE TABLE " +
                SessionContract.SessionEntry.TABLE_NAME + " (" +
                SessionContract.SessionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                SessionContract.SessionEntry.COLUMN_TOKEN + " TEXT, " +
                SessionContract.SessionEntry.COLUMN_EXPIRE + " TEXT " +
                ");";
        sql.execSQL(SQL_CREATE_SESSION_TABLE);
    }

    public void truncate() {
        sql.execSQL("DELETE FROM " + SessionContract.SessionEntry.TABLE_NAME);
    }

    public void drop() {
        sql.execSQL("DROP TABLE IF EXISTS " + SessionContract.SessionEntry.TABLE_NAME);
    }

    public void load() {
        // TODO: INSERT into table
    }

    public long insert(String token, String expire) {
        ContentValues cv = new ContentValues();
        cv.put(SessionContract.SessionEntry.COLUMN_TOKEN, token);
        cv.put(SessionContract.SessionEntry.COLUMN_EXPIRE, expire);
        return sql.insert(SessionContract.SessionEntry.TABLE_NAME, null, cv);
    }
}
