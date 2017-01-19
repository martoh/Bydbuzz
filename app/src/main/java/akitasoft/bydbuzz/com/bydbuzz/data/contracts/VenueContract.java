package akitasoft.bydbuzz.com.bydbuzz.data.contracts;

import android.provider.BaseColumns;

/**
 * Created by marty on 1/18/2017.
 */

public class VenueContract {
    public static final class VenueEntry implements BaseColumns {

        public static final String TABLE_NAME = "venues";

        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_GEOLOCATION = "geolocation";
        public static final String COLUMN_ADDRESS = "address";
    }
}
