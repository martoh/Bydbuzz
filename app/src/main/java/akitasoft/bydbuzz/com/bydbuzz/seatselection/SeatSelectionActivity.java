package akitasoft.bydbuzz.com.bydbuzz.seatselection;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import akitasoft.bydbuzz.com.bydbuzz.R;
import akitasoft.bydbuzz.com.bydbuzz.data.DbHelper;
import akitasoft.bydbuzz.com.bydbuzz.data.contracts.SeatContract;

/**
 * Created by marty on 1/21/2017.
 */
public class SeatSelectionActivity extends AppCompatActivity {

    private static DbHelper dbHelper;
    private static SQLiteDatabase sql;

    Context context;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.seat_list_activity);
        context = getApplicationContext();

        dbHelper = DbHelper.getsInstance(this);
        sql = dbHelper.sql;

        /* Fetch data from DB */
        Cursor cursor  = getAllSeats();

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_seat_list);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new SeatSelectorRVAdapter(this, cursor);
        mRecyclerView.setAdapter(mAdapter);
    }

    public Cursor getAllSeats() {
        return sql.query(SeatContract.SeatEntry.TABLE_NAME, null, null, null, null, null, null);
    }
}
