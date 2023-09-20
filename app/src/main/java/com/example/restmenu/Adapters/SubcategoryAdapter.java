package com.example.restmenu.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restmenu.Models.CategoryModel;
import com.example.restmenu.Models.ProductModel;
import com.example.restmenu.Models.SubcategoryModel;
import com.example.restmenu.R;

import java.util.List;

public class SubcategoryAdapter extends RecyclerView.Adapter<SubcategoryAdapter.SubcategoryViewHolder>{

    static List<SubcategoryModel> subcategoryModelList;
    private LayoutInflater inflater;
    private Context context;

    public SubcategoryAdapter(List<SubcategoryModel> subcategoryModelList, Context context) {
        this.subcategoryModelList = subcategoryModelList;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public SubcategoryAdapter.SubcategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.subcategory_list, parent, false);
        return new SubcategoryAdapter.SubcategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubcategoryAdapter.SubcategoryViewHolder holder, int position) {
        SubcategoryModel subcategoryModel = subcategoryModelList.get(position);
        List<ProductModel> productList = subcategoryModel.getProductList();

        Log.d("Subcategories", "Subcategories for " + productList.toString());

        ProductAdapter productAdapter = new ProductAdapter(productList);
        holder.productRv.setLayoutManager(new LinearLayoutManager(context));
        holder.productRv.setAdapter(productAdapter);

        holder.SubCategoryTv.setText(subcategoryModel.getSubcategoryName());

        boolean isExpanded = subcategoryModelList.get(position).isExpanded();
        holder.expandableLayoutsl.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int adapterPosition = holder.getAdapterPosition(); // Get the adapter position
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    SubcategoryModel categoryModel = subcategoryModelList.get(adapterPosition);
                    categoryModel.setExpanded(!categoryModel.isExpanded());
                    notifyItemChanged(adapterPosition);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return subcategoryModelList.size();
    }

    public class SubcategoryViewHolder extends RecyclerView.ViewHolder {

        TextView SubCategoryTv;
        ConstraintLayout expandableLayoutsl;
        RecyclerView productRv;
        public SubcategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            SubCategoryTv = itemView.findViewById(R.id.subCategoryName);
            expandableLayoutsl = itemView.findViewById(R.id.expandableLayoutsl);
            productRv = itemView.findViewById(R.id.subCategoryRvsl);

        }
    }
}
