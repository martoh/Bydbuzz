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

        public ViewHolder(View v) {
            super(v);
            tv_seat_description = (TextView) v.findViewById(R.id.tv_seat_description);
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

        String desc = mCursor.getString(mCursor.getColumnIndex(SeatContract.SeatEntry.COLUMN_SECTION));

        holder.tv_seat_description.setText(desc.toString());
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }
}
