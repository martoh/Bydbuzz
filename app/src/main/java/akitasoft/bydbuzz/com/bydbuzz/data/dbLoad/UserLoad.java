package akitasoft.bydbuzz.com.bydbuzz.data.dbLoad;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import akitasoft.bydbuzz.com.bydbuzz.data.contracts.UserContract;

/**
 * Created by marty on 1/18/2017.
 */

public class UserLoad {

    private SQLiteDatabase sql;

    public UserLoad(SQLiteDatabase sql) {
        this.sql = sql;
        truncate();
        load();
    }

    public void truncate() {
        sql.execSQL("DELETE FROM " + UserContract.UserEntry.TABLE_NAME);
    }

    public void load() {
        insert("Marty", "marty.lyn@gmail.com", "2017-01-01", "pass");
        insert("Mike", "xmichael.chanx@gmail.com", "2017-01-01", "pass");
        insert("Player1", "", "2017-01-01", "pass");
        insert("Player2", "", "2017-01-01", "pass");
        insert("Player3", "", "2017-01-01", "pass");
        insert("Player4", "", "2017-01-01", "pass");
        insert("Player5", "", "2017-01-01", "pass");
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
