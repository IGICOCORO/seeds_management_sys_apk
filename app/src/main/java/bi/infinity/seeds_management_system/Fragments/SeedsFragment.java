package bi.infinity.seeds_management_system.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import bi.infinity.seeds_management_system.Adapters.AdapterStockSeed;
import bi.infinity.seeds_management_system.Model.Seed;
import bi.infinity.seeds_management_system.Model.Stock;
import bi.infinity.seeds_management_system.R;


public class SeedsFragment extends Fragment {
    private RecyclerView recycler_seeds;
    private ArrayList<Stock> stocks;
    private AdapterStockSeed adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_seeds, container, false);

        recycler_seeds = view.findViewById(R.id.recycler_seeds_item);
        recycler_seeds.setLayoutManager(new GridLayoutManager(getContext(),1));

        stocks = new ArrayList<>();
        adapter = new AdapterStockSeed(stocks, getContext());
        recycler_seeds.setAdapter(adapter);
        getStock();
        return  view;
    }

    private void getStock() {
        Stock stock = new Stock("Riz","sans","Details du semence", "Nitrains", "2000", "60");
        stocks.add(stock);
        stocks.add(stock);
        stocks.add(stock);
        stocks.add(stock);
        stocks.add(stock);
        adapter.setData(stocks);
        adapter.notifyDataSetChanged();
    }
}