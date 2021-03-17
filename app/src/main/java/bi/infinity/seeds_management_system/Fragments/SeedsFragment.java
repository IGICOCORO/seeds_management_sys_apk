package bi.infinity.seeds_management_system.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import bi.infinity.seeds_management_system.Adapters.AdapterStockSeed;
import bi.infinity.seeds_management_system.Dialogs.AddSeedDialog;
import bi.infinity.seeds_management_system.Model.Seed;
import bi.infinity.seeds_management_system.Model.Stock;
import bi.infinity.seeds_management_system.R;


public class SeedsFragment extends Fragment {
    private RecyclerView recycler_seeds;
    private ArrayList<Seed> seeds;
    private AdapterStockSeed adapter;
    private FloatingActionButton fb_seed_add;
    private ArrayList<Stock> stocks;

    Button btn_vente;


    public SeedsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater     inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_seeds, container, false);

        fb_seed_add = view.findViewById(R.id.fb_seed_add);
        btn_vente = view.findViewById(R.id.btn_vente);

        recycler_seeds = view.findViewById(R.id.recycler_seeds_item);
        recycler_seeds.setLayoutManager(new GridLayoutManager(getContext(),1));
        recycler_seeds.addItemDecoration(
                new DividerItemDecoration(recycler_seeds.getContext(), DividerItemDecoration.VERTICAL)
        );

        stocks = new ArrayList<>();
        adapter = new AdapterStockSeed(stocks, getContext());
        recycler_seeds.setAdapter(adapter);

        fb_seed_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AddSeedDialog(getContext()).show();
            }
        });

        getStock();
        return  view;
    }

    private void getStock() {
        Stock stock = new Stock("ibigori","sans","Details du semence", "Nitrains", "2000", "60");
        stocks.add(stock);
        stocks.add(stock);
        stocks.add(stock);
        stocks.add(stock);
        stocks.add(stock);
        adapter.setData(stocks);
        adapter.notifyDataSetChanged();
    }
}