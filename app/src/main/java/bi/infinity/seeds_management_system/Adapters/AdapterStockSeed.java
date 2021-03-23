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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import bi.infinity.seeds_management_system.Model.Stock;
import bi.infinity.seeds_management_system.R;
import bi.infinity.seeds_management_system.VendreActivity;

public class AdapterStockSeed extends RecyclerView.Adapter<AdapterStockSeed.ViewHolder> {
    private Context context;
    ArrayList<Stock> stocks;


    public AdapterStockSeed(ArrayList<Stock> stocks, Context context) {
        this.context = context;
        this.stocks = stocks;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_seeds_home, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Stock stock = stocks.get(position);
        holder.txt_detail_item_name.setText(stock.getDetails());
        holder.txt_seed_item_name.setText(stock.getNom());
        holder.txt_seed_item_owner.setText(stock.getOwner());
       // holder.txt_seed_item_owner.setText(stock.getPrix());
        //holder.txt_seed_item_owner.setText(stock.getQtt());
        Picasso.get().load(stocks.get(position).getImage()).into(holder.img_seed);


        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, VendreActivity.class);
                context.startActivity(i);
            }
        });



    }

    @Override
    public int getItemCount() {
        return stocks.size();
    }

    public void setData(ArrayList<Stock> seeds) {
        this.stocks = stocks;
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