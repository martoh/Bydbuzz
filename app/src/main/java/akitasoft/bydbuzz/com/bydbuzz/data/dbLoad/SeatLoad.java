package akitasoft.bydbuzz.com.bydbuzz.data.dbLoad;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import akitasoft.bydbuzz.com.bydbuzz.data.contracts.SeatContract;

/**
 * Created by marty on 1/18/2017.
 */

public class SeatLoad {

    private SQLiteDatabase sql;

    public SeatLoad(SQLiteDatabase sql) {
        this.sql = sql;
    }

    public void load() {
        insert(1, "100", "1", "1", "50");
        insert(1, "200", "1", "2", "60");
        insert(1, "300", "1", "3", "70");
        insert(1, "400", "1", "4", "80");
    }

    public long insert(Integer venue_id, String section, String row, String number, String price) {
        ContentValues cv = new ContentValues();
        cv.put(SeatContract.SeatEntry.COLUMN_VENUE_ID, venue_id);
        cv.put(SeatContract.SeatEntry.COLUMN_SECTION, section);
        cv.put(SeatContract.SeatEntry.COLUMN_ROW, row);
        cv.put(SeatContract.SeatEntry.COLUMN_NUMBER, number);
        cv.put(SeatContract.SeatEntry.COLUMN_PRICE, price);
        return sql.insert(SeatContract.SeatEntry.TABLE_NAME, null, cv);
    }
}
