package bi.infinity.semences.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bi.infinity.semences.Model.Stock;
import bi.infinity.semences.R;

public class AdapterAchat extends RecyclerView.Adapter<AdapterAchat.ViewHolder> {
    private Context context;
    ArrayList<Stock> stocks;
    private final int layoutId;



    public AdapterAchat(int layoutId,Context context) {
        this.context = context;
        this.layoutId = layoutId;
    }

    @Override
    public AdapterAchat.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new AdapterAchat.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAchat.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
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
