package akitasoft.bydbuzz.com.bydbuzz.auctions;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import akitasoft.bydbuzz.com.bydbuzz.R;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    List<Map<String, String>> Auctions;
    Context context;
    View view1;
    RecyclerView.ViewHolder viewHolder1;

    public RecyclerViewAdapter(Context context1, List<Map<String, String>> auction_list) {
        Auctions = auction_list;
        context = context1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_auction_description;
        public TextView tv_auction_ticket_count;

        public ViewHolder(View v) {
            super(v);
            tv_auction_description = (TextView)v.findViewById(R.id.tv_auctions_item_description);
            tv_auction_ticket_count = (TextView)v.findViewById(R.id.tv_auctions_item_ticket_count);
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
        Map<String, String> auction = Auctions.get(position);
        holder.tv_auction_description.setText(auction.get("desc"));
        holder.tv_auction_ticket_count.setText(auction.get("ticket_count"));
    }

    @Override
    public int getItemCount() {
        return Auctions.size();
    }
}