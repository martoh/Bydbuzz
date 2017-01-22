package akitasoft.bydbuzz.com.bydbuzz.data.dbHelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import akitasoft.bydbuzz.com.bydbuzz.data.contracts.BidContract;
import akitasoft.bydbuzz.com.bydbuzz.data.contracts.UserContract;

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
                BidContract.BidEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP " +
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

    public long insert(Integer auction_id, Integer user_id, String type, String amount) {
        ContentValues cv = new ContentValues();
        cv.put(BidContract.BidEntry.COLUMN_AUCTION_ID, auction_id);
        cv.put(BidContract.BidEntry.COLUMN_USER_ID, user_id);
        cv.put(BidContract.BidEntry.COLUMN_TYPE, type);
        cv.put(BidContract.BidEntry.COLUMN_AMOUNT, amount);
//        cv.put(BidContract.BidEntry.COLUMN_TIMESTAMP, timestamp);
        return sql.insert(BidContract.BidEntry.TABLE_NAME, null, cv);
    }

    /* Refactor outside of BidDbHelper : has dependency on UserContract */
    public String fetch() {
//        String query = "SELECT " + BidContract.BidEntry.COLUMN_AMOUNT + ", " + BidContract.BidEntry.COLUMN_USER_ID + ", strftime('%Y-%m-%d', " + BidContract.BidEntry.COLUMN_TIMESTAMP + ") CREATION_DATE " +
        String query = "SELECT " + BidContract.BidEntry.COLUMN_AMOUNT + ", " + UserContract.UserEntry.COLUMN_NAME + ", " + BidContract.BidEntry.COLUMN_TIMESTAMP + " " +
                "FROM " + BidContract.BidEntry.TABLE_NAME + " b, " + UserContract.UserEntry.TABLE_NAME + " u " +
                "WHERE b." + BidContract.BidEntry.COLUMN_USER_ID + " == u." + UserContract.UserEntry._ID + " " +
                "ORDER BY amount DESC";

        Cursor cursor = sql.rawQuery(query, null);
        String rtn = "";
        if (cursor.moveToFirst()) {
            do {
                // Fetch data
                String timestamp = cursor.getString(cursor.getColumnIndex(BidContract.BidEntry.COLUMN_TIMESTAMP));
                String user_name = cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_NAME));
                Integer amount = cursor.getInt(cursor.getColumnIndex(BidContract.BidEntry.COLUMN_AMOUNT));

                // Format strings
                String entry = String.format("(%s) %s $%s", timestamp, user_name, amount.toString());
                rtn = String.format("%s\n%s", rtn, entry);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return rtn;
    }

    public Integer fetchHighestBid() {
        String query = "SELECT max(" + BidContract.BidEntry.COLUMN_AMOUNT + ") " + BidContract.BidEntry.COLUMN_AMOUNT + " " +
                "FROM " + BidContract.BidEntry.TABLE_NAME + " ";
        Cursor cursor = sql.rawQuery(query, null);
        Integer rtn = -1;
        if (cursor.moveToFirst()) {
            do {
                rtn = cursor.getInt(cursor.getColumnIndex(BidContract.BidEntry.COLUMN_AMOUNT));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return rtn;
    }
}
