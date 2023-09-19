package com.example.restmenu;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MovieVH> {

    private static final String TAG = "MenuAdapter";
    List<Item> menuList;

    public MenuAdapter(List<Item> menuList) {
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public MovieVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expanded_item, parent, false);
        return new MovieVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieVH holder, int position) {

        Item item = menuList.get(position);
        holder.dishNameTextView.setText(item.getDishName());

        holder.priceTextView.setText(item.getPrice());


        boolean isExpanded = menuList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    class MovieVH extends RecyclerView.ViewHolder {

        private static final String TAG = "MenuVH";

        ConstraintLayout expandableLayout;
        TextView dishNameTextView, priceTextView;

        ImageButton dropImg;

        public MovieVH(@NonNull final View itemView) {
            super(itemView);

            dishNameTextView = itemView.findViewById(R.id.dishName);
            priceTextView = itemView.findViewById(R.id.priceTv);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            dropImg = itemView.findViewById(R.id.dropImg);


            dropImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Item item = menuList.get(getAdapterPosition());
                    item.setExpanded(!item.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });
        }
    }
}
