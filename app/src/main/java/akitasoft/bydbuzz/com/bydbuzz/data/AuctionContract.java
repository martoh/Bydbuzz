package akitasoft.bydbuzz.com.bydbuzz.data;

import android.provider.BaseColumns;

/**
 * Created by marty on 1/17/2017.
 */

public class AuctionContract {
    public static final class AuctionEntry implements BaseColumns {

        public static final String TABLE_NAME = "auctions";

        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_TICKET_COUNT = "ticket_count";
        public static final String COLUMN_ITEM_PER_COST = "item_per_cost";
    }
}
