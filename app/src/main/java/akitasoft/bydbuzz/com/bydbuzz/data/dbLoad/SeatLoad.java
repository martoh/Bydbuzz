package akitasoft.bydbuzz.com.bydbuzz.data.dbLoad;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import akitasoft.bydbuzz.com.bydbuzz.data.contracts.SeatContract;

/**
 * Created by marty on 1/18/2017.
 */

public class SeatLoad {

    private SQLiteDatabase sql;

    public SeatLoad(SQLiteDatabase sql) {
        this.sql = sql;
        truncate();
        load();
    }

    public void truncate() {
        sql.execSQL("DELETE FROM " + SeatContract.SeatEntry.TABLE_NAME);
    }

    public void load() {
        insert(1,"100","50","1","247");
        insert(1,"100","50","2","185");
        insert(1,"100","50","3","200");
        insert(1,"100","50","4","93");
        insert(1,"100","50","5","164");
        insert(1,"100","50","6","113");
        insert(1,"100","50","7","191");
        insert(1,"100","50","8","242");
        insert(1,"100","50","9","77");
        insert(1,"100","51","1","207");
        insert(1,"100","51","2","217");
        insert(1,"100","51","3","128");
        insert(1,"100","51","4","147");
        insert(1,"100","51","5","154");
        insert(1,"100","51","6","86");
        insert(1,"100","51","7","118");
        insert(1,"100","51","8","60");
        insert(1,"100","51","9","164");
        insert(1,"100","52","1","195");
        insert(1,"100","52","2","165");
        insert(1,"100","52","3","131");
        insert(1,"100","52","4","94");
        insert(1,"100","52","5","248");
        insert(1,"100","52","6","195");
        insert(1,"100","52","7","204");
        insert(1,"100","52","8","61");
        insert(1,"100","52","9","240");
        insert(1,"100","53","1","139");
        insert(1,"100","53","2","240");
        insert(1,"100","53","3","62");
        insert(1,"100","53","4","67");
        insert(1,"100","53","5","54");
        insert(1,"100","53","6","65");
        insert(1,"100","53","7","154");
        insert(1,"100","53","8","227");
        insert(1,"100","53","9","161");
        insert(1,"100","54","1","75");
        insert(1,"100","54","2","81");
        insert(1,"100","54","3","122");
        insert(1,"100","54","4","199");
        insert(1,"100","54","5","119");
        insert(1,"100","54","6","118");
        insert(1,"100","54","7","226");
        insert(1,"100","54","8","229");
        insert(1,"100","54","9","65");
        insert(1,"100","55","1","82");
        insert(1,"100","55","2","171");
        insert(1,"100","55","3","189");
        insert(1,"100","55","4","222");
        insert(1,"100","55","5","95");
        insert(1,"100","55","6","92");
        insert(1,"100","55","7","161");
        insert(1,"100","55","8","77");
        insert(1,"100","55","9","66");
        insert(1,"100","56","1","157");
        insert(1,"100","56","2","249");
        insert(1,"100","56","3","248");
        insert(1,"100","56","4","100");
        insert(1,"100","56","5","162");
        insert(1,"100","56","6","98");
        insert(1,"100","56","7","195");
        insert(1,"100","56","8","220");
        insert(1,"100","56","9","190");
        insert(1,"100","57","1","213");
        insert(1,"100","57","2","51");
        insert(1,"100","57","3","85");
        insert(1,"100","57","4","151");
        insert(1,"100","57","5","110");
        insert(1,"100","57","6","125");
        insert(1,"100","57","7","54");
        insert(1,"100","57","8","55");
        insert(1,"100","57","9","50");
        insert(1,"100","58","1","77");
        insert(1,"100","58","2","53");
        insert(1,"100","58","3","68");
        insert(1,"100","58","4","57");
        insert(1,"100","58","5","136");
        insert(1,"100","58","6","176");
        insert(1,"100","58","7","115");
        insert(1,"100","58","8","117");
        insert(1,"100","58","9","88");
        insert(1,"100","59","1","246");
        insert(1,"100","59","2","73");
        insert(1,"100","59","3","198");
        insert(1,"100","59","4","98");
        insert(1,"100","59","5","211");
        insert(1,"100","59","6","68");
        insert(1,"100","59","7","117");
        insert(1,"100","59","8","209");
        insert(1,"100","59","9","220");
    }

    public long insert(Integer venue_id, String section, String row, String number, String price) {
        ContentValues cv = new ContentValues();
        cv.put(SeatContract.SeatEntry.COLUMN_VENUE_ID, venue_id);
        cv.put(SeatContract.SeatEntry.COLUMN_SECTION, section);
        cv.put(SeatContract.SeatEntry.COLUMN_ROW, row);
        cv.put(SeatContract.SeatEntry.COLUMN_NUMBER, number);
        cv.put(SeatContract.SeatEntry.COLUMN_PRICE, price);
        return sql.insert(SeatContract.SeatEntry.TABLE_NAME, null, cv);
    }
}
