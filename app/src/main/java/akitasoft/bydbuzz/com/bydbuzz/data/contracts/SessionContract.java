package akitasoft.bydbuzz.com.bydbuzz.data.contracts;

import android.provider.BaseColumns;

/**
 * Created by marty on 1/18/2017.
 */

public class SessionContract {
    public static final class SessionEntry implements BaseColumns {

        public static final String TABLE_NAME = "sessions";

        public static final String COLUMN_TOKEN = "token";
        public static final String COLUMN_EXPIRE = "expire";
    }
}
