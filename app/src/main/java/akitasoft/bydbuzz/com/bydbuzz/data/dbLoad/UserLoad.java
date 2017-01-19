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
    }

    public void load() {
        // TODO: INSERT into table
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
