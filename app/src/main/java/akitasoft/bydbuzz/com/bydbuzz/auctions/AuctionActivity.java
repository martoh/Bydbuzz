package akitasoft.bydbuzz.com.bydbuzz.auctions;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import akitasoft.bydbuzz.com.bydbuzz.R;
import akitasoft.bydbuzz.com.bydbuzz.data.DbHelper;
import akitasoft.bydbuzz.com.bydbuzz.data.contracts.AuctionContract;


public class AuctionActivity extends AppCompatActivity {

    public static DbHelper dbHelper;
    public static SQLiteDatabase sql;

    Context context;
    private RecyclerView auctions_recyclerview;
    private RecyclerView.Adapter auctions_adapter;
    private RecyclerView.LayoutManager auctions_layoutmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auction);
        context = getApplicationContext();

        dbHelper = DbHelper.getsInstance(this);
        sql = dbHelper.sql;

        /* Insert data */
//        CreateAuctions createAuctions = new CreateAuctions(sql);
//        createAuctions.insertAll();

        /* Fetch data from DB*/
        Cursor cursor = getAllAuctions();

        /* Recycler View */
        auctions_recyclerview = (RecyclerView) findViewById(R.id.rv_auction_list);
        auctions_recyclerview.setHasFixedSize(true);

        auctions_layoutmanager = new LinearLayoutManager(this);
        auctions_recyclerview.setLayoutManager(auctions_layoutmanager);

        auctions_adapter = new AuctionRecyclerViewAdapter(this, cursor);
        auctions_recyclerview.setAdapter(auctions_adapter);
    }

    public Cursor getAllAuctions() {
        return sql.query(AuctionContract.AuctionEntry.TABLE_NAME, null, null, null, null, null, null);
    }

}
