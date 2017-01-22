package akitasoft.bydbuzz.com.bydbuzz.async;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import akitasoft.bydbuzz.com.bydbuzz.data.DbHelper;
import akitasoft.bydbuzz.com.bydbuzz.data.dbHelper.BidDbHelper;

/**
 * Created by marty on 1/21/2017.
 */
public class AsyncBidder extends AsyncTask<URL, Integer, Long> {

    private static DbHelper dbHelper;
    private static SQLiteDatabase sql;
    private Context mContext;
    private BidDbHelper bidDbHelper;

    public AsyncBidder(Context context) {
        mContext = context;
    }

    private void makeABid(Intent amount) {
        Random r = new Random();
//        Integer amount = r.nextInt(500 - 50) + 50;
        Integer user_id = r.nextInt(7);
        Integer auction_id = 1;
        String type = "lotto";

        bidDbHelper.insert(auction_id, user_id, type, amount.toString());
    }

    /* BETA FUNCTION: This method of bidding assumes there are NO race conditions to placing bids */
    private void anteUp() {
        /* Find highest bid currently in database */
        Integer highestBid = bidDbHelper.fetchHighestBid();

        /* Insert a bid higher */
        Random r = new Random();
        highestBid += r.nextInt(15 - 1) + 1;
        Integer user_id = r.nextInt(7);
        Integer auction_id = 1;
        String type = "lotto";

        bidDbHelper.insert(auction_id, user_id, type, highestBid.toString());
    }

    protected Long doInBackground(URL... urls) {

        dbHelper = DbHelper.getsInstance(mContext.getApplicationContext());
        sql = dbHelper.sql;
        bidDbHelper = new BidDbHelper(sql);

        for(int i=0; i<1000; i++) {
            try {
                TimeUnit.SECONDS.sleep(5);
                anteUp();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Hack: Don't want this loop to exit, but don't want IDE to think return is unreachable
            i-=1;
        }

        return null;
    }

    protected void onProgressUpdate(Integer... progress) {
//        setProgressPercent(progress[0]);
    }

    protected void onPostExecute(Long result) {
//        showDialog("Downloaded " + result + " bytes");
    }
}
