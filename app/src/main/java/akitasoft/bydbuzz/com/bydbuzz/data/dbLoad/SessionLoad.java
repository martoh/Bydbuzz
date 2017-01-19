package akitasoft.bydbuzz.com.bydbuzz.data.dbLoad;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import akitasoft.bydbuzz.com.bydbuzz.data.contracts.SessionContract;

/**
 * Created by marty on 1/18/2017.
 */

public class SessionLoad {

    private SQLiteDatabase sql;

    public SessionLoad(SQLiteDatabase sql) {
        this.sql = sql;
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
