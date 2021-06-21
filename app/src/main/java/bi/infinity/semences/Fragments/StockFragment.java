package bi.infinity.semences.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import bi.infinity.semences.Adapters.AdapterStock;
import bi.infinity.semences.Host;
import bi.infinity.semences.MainActivity;
import bi.infinity.semences.Model.Stock;
import bi.infinity.semences.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class StockFragment extends Fragment {
    private AdapterStock adapter;
   private ArrayList<Stock> stocks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_stock, container, false);

        RecyclerView vertical_recycler_plant = view.findViewById(R.id.vertical_recyclerView);
        AdapterStock adapter = new AdapterStock(R.layout.card_item_vertical_seed, getActivity());
        vertical_recycler_plant.setAdapter(adapter);
        extractStock();
        return view;
    }

    private void extractStock() {
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlbuilder;
        urlbuilder = HttpUrl.parse(Host.URL + "/stock/").newBuilder();
        String url = urlbuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                getActivity().runOnUiThread(() -> {
                    Toast.makeText(getActivity(), "Erreur de connexion", Toast.LENGTH_SHORT).show();
                });
                Log.i("=====STOCK=====",e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String json = response.body().string();
                try {
                    JSONArray json_array = new JSONArray(json);
                    Stock stock;
                    stocks = new ArrayList<>();
                    for (int i=0; i < json_array.length(); i++){
                        JSONObject item = json_array.getJSONObject(i);
                        stock = new Stock(
                                item.getString("nom"),
                                item.getString("image"),
                                item.getString("details"),
                                item.getString("owner"),
                                item.getString("prix"),
                                item.getString("qtt")
                        );
                        stocks.add(stock);
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(),"Une exception de chargement",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}