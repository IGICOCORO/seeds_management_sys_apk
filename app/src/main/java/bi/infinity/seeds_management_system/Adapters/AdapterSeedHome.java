package bi.infinity.seeds_management_system.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bi.infinity.seeds_management_system.Model.Seed;
import bi.infinity.seeds_management_system.R;

public class AdapterSeedHome extends RecyclerView.Adapter<AdapterSeedHome.ViewHolder> {
    private Context context;
    ArrayList<Seed> seeds;

    public AdapterSeedHome(ArrayList<Seed> seeds, Context context) {
        this.context = context;
        this.seeds = seeds;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_seeds_home, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Seed seed = seeds.get(position);
        holder.txt_detail_item_name.setText(seed.details);
        holder.txt_seed_item_name.setText(seed.nom);
        holder.txt_seed_item_owner.setText(seed.owner);
        //holder.img_seed.setText(seed.image);
    }

    @Override
    public int getItemCount() {
        return seeds.size();
    }

    public void setData(ArrayList<Seed> seeds) {
        this.seeds = seeds;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView txt_detail_item_name ,txt_seed_item_name,txt_seed_item_owner ;
        ImageView img_seed;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_detail_item_name = itemView.findViewById(R.id.txt_detail_item_name);
            txt_seed_item_name = itemView.findViewById(R.id.txt_seed_item_name);
            txt_seed_item_owner = itemView.findViewById(R.id.txt_seed_item_owner);
            img_seed = itemView.findViewById(R.id.img_seed);
            view = itemView;
        }
    }
}
