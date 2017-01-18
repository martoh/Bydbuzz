package akitasoft.bydbuzz.com.bydbuzz.auctions;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import akitasoft.bydbuzz.com.bydbuzz.data.AuctionContract;

/**
 * Created by marty on 1/16/2017.
 */

public class CreateAuctions {

    SQLiteDatabase mDb;

    public CreateAuctions(SQLiteDatabase db) {
       this.mDb = db;
    }

    private long addAuction(String desc, String ticket_count, String cost_per) {
        ContentValues cv = new ContentValues();
        cv.put(AuctionContract.AuctionEntry.COLUMN_DESCRIPTION, desc);
        cv.put(AuctionContract.AuctionEntry.COLUMN_TICKET_COUNT, ticket_count);
        cv.put(AuctionContract.AuctionEntry.COLUMN_ITEM_PER_COST, cost_per);

        return mDb.insert(AuctionContract.AuctionEntry.TABLE_NAME, null, cv);
    }

    public void insertAll() {

        this.mDb.execSQL("DELETE FROM " + AuctionContract.AuctionEntry.TABLE_NAME);

        addAuction("400 Level 415", "Row 3 2-4 Tickets", "$25/each");
        addAuction("400 Level 418", "Row 3 2-4 Tickets", "$25/each");
        addAuction("400 Level 417", "Row 3 2-4 Tickets", "$25/each");
        addAuction("400 Level 416", "Row 3 2-4 Tickets", "$25/each");
        addAuction("400 Level 415", "Row 3 2-4 Tickets", "$25/each");
        addAuction("400 Level 414", "Row 3 2-4 Tickets", "$25/each");
        addAuction("400 Level 413", "Row 3 2-4 Tickets", "$25/each");
        addAuction("300 Level 315", "Row 3 2-4 Tickets", "$25/each");
        addAuction("300 Level 318", "Row 3 2-4 Tickets", "$25/each");
        addAuction("300 Level 314", "Row 3 2-4 Tickets", "$25/each");
        addAuction("300 Level 317", "Row 3 2-4 Tickets", "$25/each");
        addAuction("300 Level 316", "Row 3 2-4 Tickets", "$25/each");
        addAuction("300 Level 315", "Row 3 2-4 Tickets", "$25/each");
        addAuction("300 Level 313", "Row 3 2-4 Tickets", "$25/each");
        addAuction("200 Level 215", "Row 3 2-4 Tickets", "$25/each");
        addAuction("200 Level 218", "Row 3 2-4 Tickets", "$25/each");
        addAuction("200 Level 217", "Row 3 2-4 Tickets", "$25/each");
        addAuction("200 Level 216", "Row 3 2-4 Tickets", "$25/each");
        addAuction("200 Level 215", "Row 3 2-4 Tickets", "$25/each");
        addAuction("200 Level 214", "Row 3 2-4 Tickets", "$25/each");
        addAuction("200 Level 213", "Row 3 2-4 Tickets", "$25/each");
    }

}
