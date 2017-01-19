package akitasoft.bydbuzz.com.bydbuzz.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import akitasoft.bydbuzz.com.bydbuzz.data.contracts.AuctionContract;
import akitasoft.bydbuzz.com.bydbuzz.data.contracts.BidContract;
import akitasoft.bydbuzz.com.bydbuzz.data.contracts.EventContract;
import akitasoft.bydbuzz.com.bydbuzz.data.contracts.SeatContract;
import akitasoft.bydbuzz.com.bydbuzz.data.contracts.SessionContract;
import akitasoft.bydbuzz.com.bydbuzz.data.contracts.UserContract;
import akitasoft.bydbuzz.com.bydbuzz.data.contracts.VenueContract;
import akitasoft.bydbuzz.com.bydbuzz.data.dbLoad.AuctionLoad;
import akitasoft.bydbuzz.com.bydbuzz.data.dbLoad.BidLoad;
import akitasoft.bydbuzz.com.bydbuzz.data.dbLoad.EventLoad;
import akitasoft.bydbuzz.com.bydbuzz.data.dbLoad.SeatLoad;
import akitasoft.bydbuzz.com.bydbuzz.data.dbLoad.SessionLoad;
import akitasoft.bydbuzz.com.bydbuzz.data.dbLoad.UserLoad;
import akitasoft.bydbuzz.com.bydbuzz.data.dbLoad.VenueLoad;

/**
 * Created by marty on 1/17/2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static DbHelper sInstance;
    public static SQLiteDatabase sql;

    private static final String DATABASE_NAME = "bydbuzz.db";
    private static final int DATABASE_VERSION = 2;

    private AuctionLoad auctionLoad;
    private BidLoad bidLoad;
    private EventLoad eventLoad;
    private SeatLoad seatLoad;
    private SessionLoad sessionLoad;
    private UserLoad userLoad;
    private VenueLoad venueLoad;

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

        Log.i("DbHelper:onCreate", "Creating tables");

        /* AUCTIONS */
        final String SQL_CREATE_AUCTION_TABLE = "CREATE TABLE " +
                AuctionContract.AuctionEntry.TABLE_NAME + " (" +
                AuctionContract.AuctionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                AuctionContract.AuctionEntry.COLUMN_EVENT_ID + " INTEGER, " +
                AuctionContract.AuctionEntry.COLUMN_SEAT_ID + " INTEGER, " +
                AuctionContract.AuctionEntry.COLUMN_EXPIRE + " TEXT " +
                ");";
        sqLiteDatabase.execSQL(SQL_CREATE_AUCTION_TABLE);

        /* BIDS */
        final String SQL_CREATE_BID_TABLE = "CREATE TABLE " +
                BidContract.BidEntry.TABLE_NAME + " (" +
                BidContract.BidEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                BidContract.BidEntry.COLUMN_AUCTION_ID + " INTEGER, " +
                BidContract.BidEntry.COLUMN_USER_ID + " INTEGER, " +
                BidContract.BidEntry.COLUMN_TYPE + " TEXT, " +
                BidContract.BidEntry.COLUMN_AMOUNT + " TEXT, " +
                BidContract.BidEntry.COLUMN_TIMESTAMP + " TEXT " +
                ");";
        sqLiteDatabase.execSQL(SQL_CREATE_BID_TABLE);

        /* EVENTS */
        final String SQL_CREATE_EVENT_TABLE = "CREATE TABLE " +
                EventContract.EventEntry.TABLE_NAME + " (" +
                EventContract.EventEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                EventContract.EventEntry.COLUMN_DATE + " TEXT, " +
                EventContract.EventEntry.COLUMN_VENUE_ID + " INTEGER, " +
                EventContract.EventEntry.COLUMN_NAME + " TEXT, " +
                EventContract.EventEntry.COLUMN_DESCRIPTION + " TEXT " +
                ");";
        sqLiteDatabase.execSQL(SQL_CREATE_EVENT_TABLE);

        /* SEATS */
        final String SQL_CREATE_SEAT_TABLE = "CREATE TABLE " +
                SeatContract.SeatEntry.TABLE_NAME + " (" +
                SeatContract.SeatEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                SeatContract.SeatEntry.COLUMN_VENUE_ID + " INTEGER, " +
                SeatContract.SeatEntry.COLUMN_SECTION + " TEXT, " +
                SeatContract.SeatEntry.COLUMN_ROW + " TEXT, " +
                SeatContract.SeatEntry.COLUMN_NUMBER + " TEXT, " +
                SeatContract.SeatEntry.COLUMN_PRICE + " TEXT " +
                ");";
        sqLiteDatabase.execSQL(SQL_CREATE_SEAT_TABLE);

        /* SESSIONS */
        final String SQL_CREATE_SESSION_TABLE = "CREATE TABLE " +
                SessionContract.SessionEntry.TABLE_NAME + " (" +
                SessionContract.SessionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                SessionContract.SessionEntry.COLUMN_TOKEN + " TEXT, " +
                SessionContract.SessionEntry.COLUMN_EXPIRE + " TEXT " +
                ");";
        sqLiteDatabase.execSQL(SQL_CREATE_SESSION_TABLE);

        /* USERS */
        final String SQL_CREATE_USER_TABLE = "CREATE TABLE " +
                UserContract.UserEntry.TABLE_NAME + " (" +
                UserContract.UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                UserContract.UserEntry.COLUMN_NAME + " TEXT, " +
                UserContract.UserEntry.COLUMN_EMAIL + " TEXT, " +
                UserContract.UserEntry.COLUMN_DATE_JOINED + " TEXT, " +
                UserContract.UserEntry.COLUMN_PASSWORD + " TEXT " +
                ");";
        sqLiteDatabase.execSQL(SQL_CREATE_USER_TABLE);

        /* VENUE */
        final String SQL_CREATE_VENUE_TABLE = "CREATE TABLE " +
                VenueContract.VenueEntry.TABLE_NAME + " (" +
                VenueContract.VenueEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                VenueContract.VenueEntry.COLUMN_NAME + " TEXT, " +
                VenueContract.VenueEntry.COLUMN_GEOLOCATION + " TEXT, " +
                VenueContract.VenueEntry.COLUMN_ADDRESS + " TEXT " +
                ");";
        sqLiteDatabase.execSQL(SQL_CREATE_VENUE_TABLE);

        /* LOAD ALL TABLES */
        Log.i("DbHelper:onCreate", "Filling Tables");
        auctionLoad = new AuctionLoad(sqLiteDatabase);
        bidLoad = new BidLoad(sqLiteDatabase);
        eventLoad = new EventLoad(sqLiteDatabase);
        sessionLoad = new SessionLoad(sqLiteDatabase);
        seatLoad = new SeatLoad(sqLiteDatabase);
        userLoad = new UserLoad(sqLiteDatabase);
        venueLoad = new VenueLoad(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        /* Drop all of the tables */
        Log.i("DbHelper:onUpgrade", "Droping tables");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + AuctionContract.AuctionEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + BidContract.BidEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + EventContract.EventEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SeatContract.SeatEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SessionContract.SessionEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + UserContract.UserEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + VenueContract.VenueEntry.TABLE_NAME);

        /* Create all of the tables */
        onCreate(sqLiteDatabase);

        /* Re-load all the data */
        Log.i("DbHelper:onCreate", "Re-loading data into tables");
        auctionLoad = new AuctionLoad(sqLiteDatabase);
        bidLoad = new BidLoad(sqLiteDatabase);
        eventLoad = new EventLoad(sqLiteDatabase);
        sessionLoad = new SessionLoad(sqLiteDatabase);
        seatLoad = new SeatLoad(sqLiteDatabase);
        userLoad = new UserLoad(sqLiteDatabase);
        venueLoad = new VenueLoad(sqLiteDatabase);
    }
}
