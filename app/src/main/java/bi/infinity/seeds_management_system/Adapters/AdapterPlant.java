package bi.infinity.seeds_management_system.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import bi.infinity.seeds_management_system.Dialogs.PlantPopup;
import bi.infinity.seeds_management_system.R;

public class AdapterPlant extends RecyclerView.Adapter<AdapterPlant.ViewHolder> {
    private final int layoutId;
    public AdapterPlant(int layoutId) {
        this.layoutId = layoutId;
    }


    @NonNull
    @Override
    public AdapterPlant.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new AdapterPlant.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPlant.ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // new PlantPopup().show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
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
