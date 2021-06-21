package bi.infinity.semences.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import bi.infinity.semences.Adapters.AdapterAchat;
import bi.infinity.semences.R;

public class AchatFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_stock, container, false);

        RecyclerView vertical_recycler_plant = view.findViewById(R.id.vertical_recyclerView);
        AdapterAchat adapter = new AdapterAchat(R.layout.card_item_vertical_seed, getActivity());
        vertical_recycler_plant.setAdapter(adapter);
        return view;
    }
}