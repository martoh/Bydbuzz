package akitasoft.bydbuzz.com.bydbuzz.data.dbHelper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import akitasoft.bydbuzz.com.bydbuzz.data.contracts.UserContract;

/**
 * Created by marty on 1/18/2017.
 */

public class UserDbHelper {

    private SQLiteDatabase sql;

    public UserDbHelper(SQLiteDatabase sql) {
        this.sql = sql;
    }

    public void create() {
        final String SQL_CREATE_USER_TABLE = "CREATE TABLE " +
                UserContract.UserEntry.TABLE_NAME + " (" +
                UserContract.UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                UserContract.UserEntry.COLUMN_NAME + " TEXT, " +
                UserContract.UserEntry.COLUMN_EMAIL + " TEXT, " +
                UserContract.UserEntry.COLUMN_DATE_JOINED + " TEXT, " +
                UserContract.UserEntry.COLUMN_PASSWORD + " TEXT " +
                ");";
        sql.execSQL(SQL_CREATE_USER_TABLE);
    }

    public void truncate() {
        sql.execSQL("DELETE FROM " + UserContract.UserEntry.TABLE_NAME);
    }

    public void drop() {
        sql.execSQL("DROP TABLE IF EXISTS " + UserContract.UserEntry.TABLE_NAME);
    }

    public void load() {
        insert("Marty", "marty.lyn@gmail.com", "2017-01-01", "pass");
        insert("Molly", "molly.molly@gmail.com", "2017-01-01", "pass");
        insert("Player1", "", "2017-01-01", "pass");
        insert("Player2", "", "2017-01-01", "pass");
        insert("Player3", "", "2017-01-01", "pass");
        insert("Player4", "", "2017-01-01", "pass");
        insert("Player5", "", "2017-01-01", "pass");
        insert("MIKE", "", "2017-01-01", "pass");
    }

    public long insert(String name, String email, String date_joined, String password) {
        ContentValues cv = new ContentValues();
        cv.put(UserContract.UserEntry.COLUMN_NAME, name);
        cv.put(UserContract.UserEntry.COLUMN_EMAIL, email);
        cv.put(UserContract.UserEntry.COLUMN_DATE_JOINED, date_joined);
        cv.put(UserContract.UserEntry.COLUMN_PASSWORD, password);
        return sql.insert(UserContract.UserEntry.TABLE_NAME, null, cv);
    }
}
