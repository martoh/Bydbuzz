package akitasoft.bydbuzz.com.bydbuzz.auctions;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import akitasoft.bydbuzz.com.bydbuzz.R;

/**
 * Created by marty on 1/16/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    String[] SubjectValues;
    Context context;
    View view1;
    RecyclerView.ViewHolder viewHolder1;
    TextView textView;

    public RecyclerViewAdapter(Context context1, String[] SubjectValues1) {
        SubjectValues = SubjectValues1;
        context = context1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ViewHolder(View v) {
            super(v);
            textView = (TextView)v.findViewById(R.id.tv_auctions_item_description);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view1 = LayoutInflater.from(context).inflate(R.layout.auctions_list_item, parent, false);
        viewHolder1 = new ViewHolder(view1);
        return (ViewHolder) viewHolder1;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(SubjectValues[position]);
    }

    @Override
    public int getItemCount() {
        return SubjectValues.length;
    }
}