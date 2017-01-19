package akitasoft.bydbuzz.com.bydbuzz.data.dbLoad;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import akitasoft.bydbuzz.com.bydbuzz.data.contracts.BidContract;

/**
 * Created by marty on 1/18/2017.
 */

public class BidLoad {

    private SQLiteDatabase sql;

    public BidLoad(SQLiteDatabase sql) {
        this.sql = sql;
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
}
