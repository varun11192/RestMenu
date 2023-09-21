package com.example.restmenu.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restmenu.Models.ProductModel;
import com.example.restmenu.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MenuVH> {

    private static final String TAG = "MenuAdapter";
    List<ProductModel> menuList;

    public ProductAdapter(List<ProductModel> menuList) {
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public MenuVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expanded_item, parent, false);
        return new MenuVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuVH holder, int position) {

        ProductModel item = menuList.get(position);
        holder.dishNameTextView.setText(item.getProductName());
        holder.isVeg.setText(item.isVeg() ? "true" : "false");
        holder.inStock.setText(item.isInStock() ? "true" : "false");
        holder.hasCustom.setText(item.isHasCustomization() ? "true" : "false");
        holder.hasAddOn.setText(item.isHasAddOn() ? "true" : "false");
        holder.prodDesc.setText(item.getProductDesc());


        boolean isExpanded = menuList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProductModel item = menuList.get(position);
                item.setExpanded(!item.isExpanded());
                notifyItemChanged(position);

            }
        });

    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    class MenuVH extends RecyclerView.ViewHolder {

        private static final String TAG = "MenuVH";

        ConstraintLayout expandableLayout;
        TextView dishNameTextView, priceTextView, isVeg, inStock, hasCustom, hasAddOn, prodDesc;

        public MenuVH(@NonNull final View itemView) {
            super(itemView);

            dishNameTextView = itemView.findViewById(R.id.dishName);
            priceTextView = itemView.findViewById(R.id.priceTv);
            expandableLayout = itemView.findViewById(R.id.expandableLayoutcl);
            isVeg = itemView.findViewById(R.id.isVegTv);
            inStock = itemView.findViewById(R.id.inStockTv);
            hasCustom = itemView.findViewById(R.id.hasCustom);
            hasAddOn = itemView.findViewById(R.id.hasAddOn);
            prodDesc = itemView.findViewById(R.id.descriptionTv);

        }
    }
}
