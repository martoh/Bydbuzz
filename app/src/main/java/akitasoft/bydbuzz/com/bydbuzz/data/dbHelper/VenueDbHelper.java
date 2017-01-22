package akitasoft.bydbuzz.com.bydbuzz.data.dbHelper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import akitasoft.bydbuzz.com.bydbuzz.data.contracts.VenueContract;

/**
 * Created by marty on 1/18/2017.
 */

public class VenueDbHelper {

    private SQLiteDatabase sql;

    public VenueDbHelper(SQLiteDatabase sql) {
        this.sql = sql;
    }

    public void create() {
        final String SQL_CREATE_VENUE_TABLE = "CREATE TABLE " +
                VenueContract.VenueEntry.TABLE_NAME + " (" +
                VenueContract.VenueEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                VenueContract.VenueEntry.COLUMN_NAME + " TEXT, " +
                VenueContract.VenueEntry.COLUMN_GEOLOCATION + " TEXT, " +
                VenueContract.VenueEntry.COLUMN_ADDRESS + " TEXT " +
                ");";
        sql.execSQL(SQL_CREATE_VENUE_TABLE);
    }

    public void truncate() {
        sql.execSQL("DELETE FROM " + VenueContract.VenueEntry.TABLE_NAME);
    }

    public void drop() {
        sql.execSQL("DROP TABLE IF EXISTS " + VenueContract.VenueEntry.TABLE_NAME);
    }

    public void load() {
        insert("SkyDome", "", "Toronto's SkyDome");
        insert("ACC", "", "Air Canada Center");
    }

    public long insert(String name, String geolocation, String address) {
        ContentValues cv = new ContentValues();
        cv.put(VenueContract.VenueEntry.COLUMN_NAME, name);
        cv.put(VenueContract.VenueEntry.COLUMN_GEOLOCATION, geolocation);
        cv.put(VenueContract.VenueEntry.COLUMN_ADDRESS, address);
        return sql.insert(VenueContract.VenueEntry.TABLE_NAME, null, cv);
    }
}
