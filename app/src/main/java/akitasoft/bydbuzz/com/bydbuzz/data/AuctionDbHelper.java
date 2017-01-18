package akitasoft.bydbuzz.com.bydbuzz.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by marty on 1/17/2017.
 */

public class AuctionDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "bydbuzz.db";
    private static final int DATABASE_VERSION = 2;

    public AuctionDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_AUCTION_TABLE = "CREATE TABLE " +
                AuctionContract.AuctionEntry.TABLE_NAME + " (" +
                AuctionContract.AuctionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                AuctionContract.AuctionEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
                AuctionContract.AuctionEntry.COLUMN_TICKET_COUNT + " TEXT NOT NULL, " +
                AuctionContract.AuctionEntry.COLUMN_ITEM_PER_COST + " TEXT NOT NULL " +
                ");";

        sqLiteDatabase.execSQL(SQL_CREATE_AUCTION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + AuctionContract.AuctionEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
