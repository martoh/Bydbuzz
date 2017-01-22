package akitasoft.bydbuzz.com.bydbuzz.data.dbHelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import akitasoft.bydbuzz.com.bydbuzz.data.contracts.BidContract;

/**
 * Created by marty on 1/18/2017.
 */

public class BidDbHelper {

    private SQLiteDatabase sql;

    public BidDbHelper(SQLiteDatabase sql) {
        this.sql = sql;
    }

    public void create() {

        /* Drop if it exists */
        drop();

        final String SQL_CREATE_BID_TABLE = "CREATE TABLE " +
                BidContract.BidEntry.TABLE_NAME + " (" +
                BidContract.BidEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                BidContract.BidEntry.COLUMN_AUCTION_ID + " INTEGER, " +
                BidContract.BidEntry.COLUMN_USER_ID + " INTEGER, " +
                BidContract.BidEntry.COLUMN_TYPE + " TEXT, " +
                BidContract.BidEntry.COLUMN_AMOUNT + " INTEGER, " +
                BidContract.BidEntry.COLUMN_TIMESTAMP + " TEXT " +
                ");";
        sql.execSQL(SQL_CREATE_BID_TABLE);
    }

    public void truncate() {
        sql.execSQL("DELETE FROM " + BidContract.BidEntry.TABLE_NAME);
    }

    public void drop() {
        sql.execSQL("DROP TABLE IF EXISTS " + BidContract.BidEntry.TABLE_NAME);
    }

    public void load() {
        // TODO: INSERT into table
    }

    public long insert(Integer auction_id, Integer user_id, String type, String amount, String timestamp) {
        ContentValues cv = new ContentValues();
        cv.put(BidContract.BidEntry.COLUMN_AUCTION_ID, auction_id);
        cv.put(BidContract.BidEntry.COLUMN_USER_ID, user_id);
        cv.put(BidContract.BidEntry.COLUMN_TYPE, type);
        cv.put(BidContract.BidEntry.COLUMN_AMOUNT, amount);
        cv.put(BidContract.BidEntry.COLUMN_TIMESTAMP, timestamp);
        return sql.insert(BidContract.BidEntry.TABLE_NAME, null, cv);
    }

    public String fetch() {
        String query = "SELECT * " +
                "FROM " + BidContract.BidEntry.TABLE_NAME + " " +
                "ORDER BY amount DESC";

        Cursor cursor = sql.rawQuery(query, null);
        String rtn = "";
        if (cursor.moveToFirst()) {
            do {
                // Fetch data
                String timestamp = cursor.getString(cursor.getColumnIndex(BidContract.BidEntry.COLUMN_TIMESTAMP));
                Integer user_id = cursor.getInt(cursor.getColumnIndex(BidContract.BidEntry.COLUMN_USER_ID));
                Integer amount = cursor.getInt(cursor.getColumnIndex(BidContract.BidEntry.COLUMN_AMOUNT));

                // Format strings
                String entry = String.format("%s %s %s", timestamp, user_id.toString(), amount.toString());
                rtn = String.format("%s\n%s", rtn, entry);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return rtn;
    }
}
