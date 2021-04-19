package bi.infinity.seeds_management_system.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import bi.infinity.seeds_management_system.MainActivity;
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
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical_plant, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Seed seed =  seeds.get(position);
       /* holder.txt_detail_item_name.setText(seed.details);
        holder.txt_seed_item_name.setText(seed.nom);
        holder.txt_seed_item_owner.setText(seed.owner);
        Glide.with(context).load(seed.getImage(context)).into(holder.img_seed);*/

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, MainActivity.class);
                context.startActivity(i);
            }
        });
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
        ImageView image_item;
        ImageView star_icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_item = itemView.findViewById(R.id.image_item);
            star_icon = itemView.findViewById(R.id.star_icon);
            view = itemView;
        }
        }
    }