package akitasoft.bydbuzz.com.bydbuzz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import akitasoft.bydbuzz.com.bydbuzz.auctions.CreateAuctions;
import akitasoft.bydbuzz.com.bydbuzz.auctions.RecyclerViewAdapter;


public class AuctionActivity extends AppCompatActivity {

    Context context;
    private RecyclerView auctions_recyclerview;
    private RecyclerView.Adapter auctions_adapter;
    private RecyclerView.LayoutManager auctions_layoutmanager;

    private List<Map<String, String>> auction_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auction);
        context = getApplicationContext();

        /* Create data */
        CreateAuctions createAuctions = new CreateAuctions();
        auction_list = createAuctions.create();

        auctions_recyclerview = (RecyclerView) findViewById(R.id.rv_auction_list);
        auctions_recyclerview.setHasFixedSize(true);

        auctions_layoutmanager = new LinearLayoutManager(this);
        auctions_recyclerview.setLayoutManager(auctions_layoutmanager);

        auctions_adapter = new RecyclerViewAdapter(context, auction_list);
        auctions_recyclerview.setAdapter(auctions_adapter);
    }
}
