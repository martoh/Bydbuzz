package akitasoft.bydbuzz.com.bydbuzz.data.contracts;

import android.provider.BaseColumns;

/**
 * Created by marty on 1/17/2017.
 */

public class AuctionContract {
    public static final class AuctionEntry implements BaseColumns {

        public static final String TABLE_NAME = "auctions";

        public static final String COLUMN_EVENT_ID = "event_id";
        public static final String COLUMN_SEAT_ID = "seat_id";
        public static final String COLUMN_EXPIRE = "expire";
    }
}
