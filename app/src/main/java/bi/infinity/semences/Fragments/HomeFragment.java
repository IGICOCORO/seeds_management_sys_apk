package bi.infinity.semences.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import bi.infinity.semences.Adapters.AdapterHome;
import bi.infinity.semences.R;

public class HomeFragment extends Fragment {
    private RecyclerView horizontal_recycler_plant,vertical_recycler_plant;
    private AdapterHome adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_home, container, false);
        horizontal_recycler_plant = view.findViewById(R.id.horizontal_recyclerView);
        adapter = new AdapterHome(R.layout.card_item_horizontal_seed,getActivity());
        horizontal_recycler_plant.setAdapter(adapter);


        vertical_recycler_plant = view.findViewById(R.id.vertical_recyclerView);
        adapter = new AdapterHome(R.layout.card_item_vertical_seed,getActivity());
        vertical_recycler_plant.setAdapter(adapter);
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        ActionBar supportActionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        ActionBar supportActionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.show();
    }
}