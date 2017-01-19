package akitasoft.bydbuzz.com.bydbuzz.data.contracts;

import android.provider.BaseColumns;

/**
 * Created by marty on 1/18/2017.
 */

public class SeatContract {
    public static final class SeatEntry implements BaseColumns {

        public static final String TABLE_NAME = "seats";

        public static final String COLUMN_VENUE_ID = "venue_id";
        public static final String COLUMN_SECTION = "section";
        public static final String COLUMN_ROW = "row";
        public static final String COLUMN_NUMBER = "number";
        public static final String COLUMN_PRICE = "price";

    }
}
