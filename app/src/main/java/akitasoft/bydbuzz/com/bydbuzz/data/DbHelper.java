package akitasoft.bydbuzz.com.bydbuzz.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import akitasoft.bydbuzz.com.bydbuzz.data.dbHelper.AuctionDbHelper;
import akitasoft.bydbuzz.com.bydbuzz.data.dbHelper.BidDbHelper;
import akitasoft.bydbuzz.com.bydbuzz.data.dbHelper.EventDbHelper;
import akitasoft.bydbuzz.com.bydbuzz.data.dbHelper.SeatDbHelper;
import akitasoft.bydbuzz.com.bydbuzz.data.dbHelper.SessionDbHelper;
import akitasoft.bydbuzz.com.bydbuzz.data.dbHelper.UserDbHelper;
import akitasoft.bydbuzz.com.bydbuzz.data.dbHelper.VenueDbHelper;

/**
 * Created by marty on 1/17/2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static DbHelper sInstance;
    public static SQLiteDatabase sql;

    private static final String DATABASE_NAME = "bydbuzz.db";
    private static final int DATABASE_VERSION = 14;

    private AuctionDbHelper auctionDbHelper;
    private BidDbHelper bidDbHelper;
    private EventDbHelper eventDbHelper;
    private SeatDbHelper seatDbHelper;
    private SessionDbHelper sessionDbHelper;
    private UserDbHelper userDbHelper;
    private VenueDbHelper venueDbHelper;

    public static synchronized DbHelper getsInstance(Context context) {
        if (sInstance == null) {
            Log.i("DbHelper", "Initializing new DbHelper");
            sInstance = new DbHelper(context.getApplicationContext());

            Log.i("DbHelper", "Initializing new database");
            sql = sInstance.getReadableDatabase();
        }
        return sInstance;
    }

    private DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        /* INSTANTIATE ALL DB HELPERS*/
        Log.i("DbHelper:onCreate", "Initializing tables");
        auctionDbHelper = new AuctionDbHelper(sqLiteDatabase);
        bidDbHelper = new BidDbHelper(sqLiteDatabase);
        eventDbHelper = new EventDbHelper(sqLiteDatabase);
        sessionDbHelper = new SessionDbHelper(sqLiteDatabase);
        seatDbHelper = new SeatDbHelper(sqLiteDatabase);
        userDbHelper = new UserDbHelper(sqLiteDatabase);
        venueDbHelper = new VenueDbHelper(sqLiteDatabase);

        /* CREATE TABLES */
        Log.i("DbHelper:onCreate", "Create all tables");
        auctionDbHelper.create();
        bidDbHelper.create();
        eventDbHelper.create();
        sessionDbHelper.create();
        seatDbHelper.create();
        userDbHelper.create();
        venueDbHelper.create();

        /* LOAD DATA INTO TABLES */
        Log.i("DbHelper:onCreate", "Load all tables");
        auctionDbHelper.load();
        bidDbHelper.load();
        eventDbHelper.load();
        sessionDbHelper.load();
        seatDbHelper.load();
        userDbHelper.load();
        venueDbHelper.load();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        /* INSTANTIATE ALL DB HELPERS*/
        Log.i("DbHelper:onUpgrade", "Initializing tables");
        auctionDbHelper = new AuctionDbHelper(sqLiteDatabase);
        bidDbHelper = new BidDbHelper(sqLiteDatabase);
        eventDbHelper = new EventDbHelper(sqLiteDatabase);
        sessionDbHelper = new SessionDbHelper(sqLiteDatabase);
        seatDbHelper = new SeatDbHelper(sqLiteDatabase);
        userDbHelper = new UserDbHelper(sqLiteDatabase);
        venueDbHelper = new VenueDbHelper(sqLiteDatabase);

        /* Drop all of the tables */
        Log.i("DbHelper:onUpgrade", "Droping tables");
        auctionDbHelper.drop();
        bidDbHelper.drop();
        eventDbHelper.drop();
        sessionDbHelper.drop();
        seatDbHelper.drop();
        userDbHelper.drop();
        venueDbHelper.drop();

        /* Create all of the tables */
        Log.i("DbHelper:onUpgrade", "Creating all tables");
        auctionDbHelper.create();
        bidDbHelper.create();
        eventDbHelper.create();
        sessionDbHelper.create();
        seatDbHelper.create();
        userDbHelper.create();
        venueDbHelper.create();

        /* Re-load all the data */
        Log.i("DbHelper:onUpgrade", "Re-loading data into tables");
        auctionDbHelper.load();
        bidDbHelper.load();
        eventDbHelper.load();
        sessionDbHelper.load();
        seatDbHelper.load();
        userDbHelper.load();
        venueDbHelper.load();
    }
}
