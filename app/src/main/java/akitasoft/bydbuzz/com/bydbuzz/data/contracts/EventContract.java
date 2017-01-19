package akitasoft.bydbuzz.com.bydbuzz.data.contracts;

import android.provider.BaseColumns;

/**
 * Created by marty on 1/18/2017.
 */

public class EventContract {
    public static final class EventEntry implements BaseColumns {

        public static final String TABLE_NAME = "events";

        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_VENUE_ID = "venue_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";

    }
}
