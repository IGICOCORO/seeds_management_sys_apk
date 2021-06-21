package bi.infinity.semences.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import bi.infinity.semences.MainActivity;
import bi.infinity.semences.Model.Seed;
import bi.infinity.semences.R;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> {
    private final Context context;
    private final int layoutId;
    ArrayList<Seed> seeds;

    public AdapterHome(int layoutId, Context context) {
        this.context = context;
        this.layoutId = layoutId;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView image_item;
        ImageView star_icon;
        TextView txt_detail_item_name,txt_seed_item_name,txt_seed_item_owner;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_item = itemView.findViewById(R.id.image_item);
            star_icon = itemView.findViewById(R.id.star_icon);
            view = itemView;
        }
    }
}
