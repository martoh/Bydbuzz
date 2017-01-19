package akitasoft.bydbuzz.com.bydbuzz.seat;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import akitasoft.bydbuzz.com.bydbuzz.R;
import akitasoft.bydbuzz.com.bydbuzz.auctions.AuctionActivity;
import akitasoft.bydbuzz.com.bydbuzz.data.DbHelper;

public class SeatActivity extends AppCompatActivity {

    public static DbHelper dbHelper;
    public static SQLiteDatabase sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat);

        dbHelper = DbHelper.getsInstance(this);
        sql = dbHelper.sql;

        final Button button = (Button) findViewById(R.id.btn_bid_now);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AuctionActivity.class);
//                intent.putExtra("sampleText", "thereisnocowlevel");
                startActivity(intent);
            }
        });
    }
}
