package akitasoft.bydbuzz.com.bydbuzz.data.contracts;

import android.provider.BaseColumns;

/**
 * Created by marty on 1/18/2017.
 */

public class UserContract {
    public static final class UserEntry implements BaseColumns {

        public static final String TABLE_NAME = "users";

        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_DATE_JOINED = "date_joined";
        public static final String COLUMN_PASSWORD = "password";
    }
}
