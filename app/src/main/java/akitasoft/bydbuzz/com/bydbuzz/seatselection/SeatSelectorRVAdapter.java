package akitasoft.bydbuzz.com.bydbuzz.seatselection;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import akitasoft.bydbuzz.com.bydbuzz.R;
import akitasoft.bydbuzz.com.bydbuzz.data.contracts.SeatContract;

/**
 * Created by marty on 1/21/2017.
 */

public class SeatSelectorRVAdapter extends RecyclerView.Adapter<SeatSelectorRVAdapter.ViewHolder> {

    Context mContext;
    View mView;
    RecyclerView.ViewHolder mViewHolder;
    private Cursor mCursor;

    public SeatSelectorRVAdapter(Context context, Cursor cursor) {
        this.mContext = context;
        this.mCursor = cursor;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_seat_description;
        public TextView tv_seat_cost_per;
        public TextView tv_seat_ticket_count;

        public ViewHolder(View v) {
            super(v);
            tv_seat_description = (TextView) v.findViewById(R.id.tv_seat_description);
            tv_seat_cost_per = (TextView) v.findViewById(R.id.tv_seat_item_cost_per);
            tv_seat_ticket_count = (TextView) v.findViewById(R.id.tv_seat_item_ticket_count);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.seat_list_item, parent, false);
        mViewHolder = new ViewHolder(mView);
        return (ViewHolder) mViewHolder;
    }

    @Override
    public void onBindViewHolder(SeatSelectorRVAdapter.ViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position))
            return;

        String section = mCursor.getString(mCursor.getColumnIndex(SeatContract.SeatEntry.COLUMN_SECTION));
        String row = mCursor.getString(mCursor.getColumnIndex(SeatContract.SeatEntry.COLUMN_ROW));
        String number = mCursor.getString(mCursor.getColumnIndex(SeatContract.SeatEntry.COLUMN_NUMBER));
        String price = mCursor.getString(mCursor.getColumnIndex(SeatContract.SeatEntry.COLUMN_PRICE));

        String description = String.format("Section %s Row %s Number %s", section, row, number);
        holder.tv_seat_description.setText(description.toString());
        String price_description = String.format("$%s / each", price);
        holder.tv_seat_cost_per.setText(price_description);
        holder.tv_seat_ticket_count.setText("Number of Tickets: 1");
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }
}
