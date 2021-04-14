package bi.infinity.seeds_management_system.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import bi.infinity.seeds_management_system.Adapters.AdapterSeedHome;
import bi.infinity.seeds_management_system.Host;
import bi.infinity.seeds_management_system.Model.Seed;
import bi.infinity.seeds_management_system.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class HomeFragment extends Fragment {


    private final Context context;
    private RecyclerView recycler_seeds;
    private ArrayList<Seed> seeds;
    private AdapterSeedHome adapter;


    public HomeFragment(Context context) {
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recycler_seeds = view.findViewById(R.id.recycler_seeds_item);
        recycler_seeds.setLayoutManager(new GridLayoutManager(getContext(),1));

        seeds = new ArrayList<Seed>();
        adapter = new AdapterSeedHome(seeds, getContext());
        recycler_seeds.setAdapter(adapter);
        fetchSeeds();
        return  view;
    }

    private void fetchSeeds() {

        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Host.URL +"/semences/").newBuilder();
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
                    Seed seed;
                    for (int i = 0; i<results.length(); i++) {
                        JSONObject item = results.getJSONObject(i);
                        seed = new Seed(
                                item.getString("plant"),
                                item.getString("photo"),
                                item.getString("etat_sanitaire"),
                                item.getString("variety")
                        );
                        seeds.add(seed);
                        Log.i("======JSON====",seeds.toString());


                    }
                    getActivity().runOnUiThread(() -> {
                        adapter.setData(seeds);
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