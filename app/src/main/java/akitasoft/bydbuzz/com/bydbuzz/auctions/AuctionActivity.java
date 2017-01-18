package akitasoft.bydbuzz.com.bydbuzz.auctions;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import akitasoft.bydbuzz.com.bydbuzz.R;
import akitasoft.bydbuzz.com.bydbuzz.data.AuctionContract;
import akitasoft.bydbuzz.com.bydbuzz.data.AuctionDbHelper;


public class AuctionActivity extends AppCompatActivity {

    Context context;
    private RecyclerView auctions_recyclerview;
    private RecyclerView.Adapter auctions_adapter;
    private RecyclerView.LayoutManager auctions_layoutmanager;

    private List<Map<String, String>> auction_list = new ArrayList<>();
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auction);
        context = getApplicationContext();

        /* Create Database */
        AuctionDbHelper dbHelper = new AuctionDbHelper(this);
        mDb = dbHelper.getWritableDatabase();

        /* Insert data */
        CreateAuctions createAuctions = new CreateAuctions(mDb);
        createAuctions.insertAll();

        /* Fetch data from DB*/
        Cursor cursor = getAllAuctions();

        /* Recycler View */
        auctions_recyclerview = (RecyclerView) findViewById(R.id.rv_auction_list);
        auctions_recyclerview.setHasFixedSize(true);

        auctions_layoutmanager = new LinearLayoutManager(this);
        auctions_recyclerview.setLayoutManager(auctions_layoutmanager);

        auctions_adapter = new RecyclerViewAdapter(this, cursor);
        auctions_recyclerview.setAdapter(auctions_adapter);
    }

    public Cursor getAllAuctions() {
        return mDb.query(AuctionContract.AuctionEntry.TABLE_NAME, null, null, null, null, null, null);
    }

}
