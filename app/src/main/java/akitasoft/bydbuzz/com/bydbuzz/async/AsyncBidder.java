package akitasoft.bydbuzz.com.bydbuzz.async;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import akitasoft.bydbuzz.com.bydbuzz.data.DbHelper;
import akitasoft.bydbuzz.com.bydbuzz.data.dbLoad.AuctionLoad;

/**
 * Created by marty on 1/21/2017.
 */
public class AsyncBidder extends AsyncTask<URL, Integer, Long> {

    private static DbHelper dbHelper;
    private static SQLiteDatabase sql;
    private Context mContext;

    public AsyncBidder(Context context) {
        mContext = context;
    }

    protected Long doInBackground(URL... urls) {

        dbHelper = DbHelper.getsInstance(mContext.getApplicationContext());
        sql = dbHelper.sql;
        AuctionLoad auctionLoad = new AuctionLoad(sql);

        for(int i=0; i<1000; i++) {
            try {
                TimeUnit.SECONDS.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            auctionLoad.load();

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
