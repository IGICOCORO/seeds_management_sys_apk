package bi.infinity.seeds_management_system.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import bi.infinity.seeds_management_system.Adapters.AdapterStockSeed;
import bi.infinity.seeds_management_system.Dialogs.AddSeedDialog;
import bi.infinity.seeds_management_system.Host;
import bi.infinity.seeds_management_system.Model.Seed;
import bi.infinity.seeds_management_system.Model.Stock;
import bi.infinity.seeds_management_system.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class SeedsFragment extends Fragment {
    private RecyclerView recycler_seeds;
    private Seed seeds;
    private AdapterStockSeed adapter;
    private FloatingActionButton fb_seed_add;
    private ArrayList<Stock> stocks;

    Button btn_vente;
    private Context context;


    public SeedsFragment(Context context) {
        this.context=context;
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
        fetchStock();
        return  view;
    }
    public void fetchStock() {

        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Host.URL + "/stock/").newBuilder();
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
               // .header("Authorization", "Bearer "+ Host.getSessionValue(context, "token"))
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("======JSON====",e.getMessage());
                //getActivity().runOnUiThread(() -> {
                 //   Toast.makeText(context, "you are offline", Toast.LENGTH_SHORT).show();
                //});
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                try {
                    JSONArray results = new JSONArray(json);
                    Stock stock;
                    for (int i = 0; i<results.length(); i++) {
                        JSONObject item = results.getJSONObject(i);
                        stock = new Stock(
                                item.getString("nom"),
                                item.getString("photo"),
                                item.getString("etat_sanitaire"),
                                item.getString("variety")
                        );
                        stocks.add(stock);
                        Log.i("======JSON====",stock.toString());


                    }
                    getActivity().runOnUiThread(() -> {
                        adapter.setData(stocks);
                        adapter.notifyDataSetChanged();
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.i("======JSON====",e.getMessage());
                    getActivity().runOnUiThread(() -> {
                       // Toast.makeText(context, "format incorrect", Toast.LENGTH_SHORT).show();
                    });
                }
            }
        });
    }
}