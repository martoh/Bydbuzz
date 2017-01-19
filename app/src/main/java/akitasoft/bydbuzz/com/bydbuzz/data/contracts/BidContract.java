package akitasoft.bydbuzz.com.bydbuzz.data.contracts;

import android.provider.BaseColumns;

/**
 * Created by marty on 1/18/2017.
 */

public class BidContract {
    public static final class BidEntry implements BaseColumns {

        public static final String TABLE_NAME = "bids";

        public static final String COLUMN_AUCTION_ID = "auction_id";
        public static final String COLUMN_USER_ID = "user_id";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_AMOUNT = "amount";
        public static final String COLUMN_TIMESTAMP = "timestamp";
    }
}
