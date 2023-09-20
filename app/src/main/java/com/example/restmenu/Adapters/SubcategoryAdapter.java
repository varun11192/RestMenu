package com.example.restmenu.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
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

        holder.SubCategoryTv.setText(SubcategoryModel.getSubcategoryName());

        boolean isExpanded = subcategoryModelList.get(position).isExpanded();
        holder.expandableLayoutsl.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return subcategoryModelList.size();
    }

    public class SubcategoryViewHolder extends RecyclerView.ViewHolder {

        TextView SubCategoryTv;
        ConstraintLayout expandableLayoutsl;
        ImageButton dropImgsl;
        public SubcategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            SubCategoryTv = itemView.findViewById(R.id.subCategoryName);
            expandableLayoutsl = itemView.findViewById(R.id.expandableLayoutsl);
            dropImgsl = itemView.findViewById(R.id.dropImgsl);

            dropImgsl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    SubcategoryModel categoryModel = subcategoryModelList.get(getAdapterPosition());
                    categoryModel.setExpanded(!categoryModel.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });

        }
    }
}
