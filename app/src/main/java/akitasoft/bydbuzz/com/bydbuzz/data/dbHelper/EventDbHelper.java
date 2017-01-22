package akitasoft.bydbuzz.com.bydbuzz.data.dbHelper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import akitasoft.bydbuzz.com.bydbuzz.data.contracts.EventContract;

/**
 * Created by marty on 1/18/2017.
 */

public class EventDbHelper {

    private SQLiteDatabase sql;

    public EventDbHelper(SQLiteDatabase sql) {
        this.sql = sql;
    }

    public void create() {
        final String SQL_CREATE_EVENT_TABLE = "CREATE TABLE " +
                EventContract.EventEntry.TABLE_NAME + " (" +
                EventContract.EventEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                EventContract.EventEntry.COLUMN_DATE + " TEXT, " +
                EventContract.EventEntry.COLUMN_VENUE_ID + " INTEGER, " +
                EventContract.EventEntry.COLUMN_NAME + " TEXT, " +
                EventContract.EventEntry.COLUMN_DESCRIPTION + " TEXT " +
                ");";
        sql.execSQL(SQL_CREATE_EVENT_TABLE);
    }

    public void truncate() {
        sql.execSQL("DELETE FROM " + EventContract.EventEntry.TABLE_NAME);
    }

    public void drop() {
        sql.execSQL("DROP TABLE IF EXISTS " + EventContract.EventEntry.TABLE_NAME);
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
