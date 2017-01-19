package akitasoft.bydbuzz.com.bydbuzz.data.dbLoad;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import akitasoft.bydbuzz.com.bydbuzz.data.contracts.VenueContract;

/**
 * Created by marty on 1/18/2017.
 */

public class VenueLoad {

    private SQLiteDatabase sql;

    public VenueLoad(SQLiteDatabase sql) {
        this.sql = sql;
    }

    public void load() {
        // TODO: INSERT into table
    }

    public long insert(String name, String geolocation, String address) {
        ContentValues cv = new ContentValues();
        cv.put(VenueContract.VenueEntry.COLUMN_NAME, name);
        cv.put(VenueContract.VenueEntry.COLUMN_GEOLOCATION, geolocation);
        cv.put(VenueContract.VenueEntry.COLUMN_ADDRESS, address);
        return sql.insert(VenueContract.VenueEntry.TABLE_NAME, null, cv);
    }
}
