package bi.infinity.seeds_management_system.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import bi.infinity.seeds_management_system.Adapters.AdapterPlant;

import bi.infinity.seeds_management_system.R;

public class HomeFragmementNew extends Fragment {
    private RecyclerView horizontal_recycler_plant,vertical_recycler_plant;
    private AdapterPlant adapter;

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_new, container, false);

         horizontal_recycler_plant = view.findViewById(R.id.horizontal_recyclerView);
         adapter = new AdapterPlant(R.layout.item_horizontal_plant,getActivity());
        horizontal_recycler_plant.setAdapter(adapter);


        vertical_recycler_plant = view.findViewById(R.id.vertical_recyclerView);
        adapter = new AdapterPlant(R.layout.item_vertical_plant,getActivity());
        vertical_recycler_plant.setAdapter(adapter);
        return view;

    }
}
