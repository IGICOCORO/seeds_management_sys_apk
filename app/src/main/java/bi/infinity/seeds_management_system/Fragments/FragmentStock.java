package bi.infinity.seeds_management_system.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import bi.infinity.seeds_management_system.Adapters.AdapterPlant;
import bi.infinity.seeds_management_system.MainActivity;
import bi.infinity.seeds_management_system.R;

public class FragmentStock extends Fragment {
    private RecyclerView vertical_recyclerView;
    private AdapterPlant adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        vertical_recyclerView = view.findViewById(R.id.vertical_recyclerView);
        adapter = new AdapterPlant(R.layout.item_vertical_plant,getActivity());
        vertical_recyclerView.setAdapter(adapter);
        return view;
    }
}
