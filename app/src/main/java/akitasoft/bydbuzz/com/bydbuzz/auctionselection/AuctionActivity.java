package akitasoft.bydbuzz.com.bydbuzz.auctionselection;

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

    private static DbHelper dbHelper;
    private static SQLiteDatabase sql;

    Context context;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.auction_list_activity);
        context = getApplicationContext();

        dbHelper = DbHelper.getsInstance(this);
        sql = dbHelper.sql;

        /* Fetch data from DB*/
        Cursor cursor = getAllAuctions();

        /* Recycler View */
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_auction_list);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new AuctionRVAdapter(this, cursor);
        mRecyclerView.setAdapter(mAdapter);
    }

    public Cursor getAllAuctions() {
        return sql.query(AuctionContract.AuctionEntry.TABLE_NAME, null, null, null, null, null, null);
    }

}
