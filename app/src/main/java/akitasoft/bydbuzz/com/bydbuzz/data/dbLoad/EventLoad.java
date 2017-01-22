package akitasoft.bydbuzz.com.bydbuzz.data.dbLoad;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import akitasoft.bydbuzz.com.bydbuzz.data.contracts.EventContract;

/**
 * Created by marty on 1/18/2017.
 */

public class EventLoad {

    private SQLiteDatabase sql;

    public EventLoad(SQLiteDatabase sql) {
        this.sql = sql;
        truncate();
        load();
    }

    public void truncate() {
        sql.execSQL("DELETE FROM " + EventContract.EventEntry.TABLE_NAME);
    }

    public void load() {
        insert("2017-01-01", 1, "Concert of a musician", "A musician singing to a crowd");
        insert("2017-01-01", 1, "Baseball game", "Toronto Blue Jays are in town");
        insert("2017-01-01", 1, "Basketball game", "Toronto Raptors are in town");
    }

    public long insert(String date, Integer venue_id, String name, String description) {
        ContentValues cv = new ContentValues();
        cv.put(EventContract.EventEntry.COLUMN_DATE, date);
        cv.put(EventContract.EventEntry.COLUMN_VENUE_ID, venue_id);
        cv.put(EventContract.EventEntry.COLUMN_NAME, name);
        cv.put(EventContract.EventEntry.COLUMN_DESCRIPTION, description);
        return sql.insert(EventContract.EventEntry.TABLE_NAME, null, cv);
    }
}
