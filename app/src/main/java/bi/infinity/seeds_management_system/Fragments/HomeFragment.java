package bi.infinity.seeds_management_system.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import bi.infinity.seeds_management_system.Adapters.AdapterSeedHome;
import bi.infinity.seeds_management_system.Model.Seed;
import bi.infinity.seeds_management_system.R;


public class HomeFragment extends Fragment {


    private RecyclerView recycler_seeds;
    private ArrayList<Seed> seeds;
    private AdapterSeedHome adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recycler_seeds = view.findViewById(R.id.recycler_seeds_item);
        recycler_seeds.setLayoutManager(new GridLayoutManager(getContext(),1));

        seeds = new ArrayList<>();
        adapter = new AdapterSeedHome(seeds, getContext());
        recycler_seeds.setAdapter(adapter);
        getSeeds();
        return  view;
    }

    private void getSeeds() {
       Seed seed = new Seed("Riz","sans","Details du semence", "Nitrains", "2000", "60");
       seeds.add(seed);
       seeds.add(seed);
       seeds.add(seed);
        seeds.add(seed);
        seeds.add(seed);
       adapter.setData(seeds);
       adapter.notifyDataSetChanged();

    }

}