package akitasoft.bydbuzz.com.bydbuzz.bid;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import akitasoft.bydbuzz.com.bydbuzz.R;
import akitasoft.bydbuzz.com.bydbuzz.data.DbHelper;

public class BidActivity extends AppCompatActivity {

    public static DbHelper dbHelper;
    public static SQLiteDatabase sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bid_activity);

        dbHelper = DbHelper.getsInstance(this);
        sql = dbHelper.sql;


    }
}
