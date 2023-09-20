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
import com.example.restmenu.Models.SubcategoryModel;
import com.example.restmenu.R;

import java.util.ArrayList;
import java.util.List;

public class MainCategoryAdapter extends RecyclerView.Adapter<MainCategoryAdapter.MainCategoryViewHolder> {

    static List<CategoryModel> mainCategories;
    static List<SubcategoryModel> subcategoryList;
    private LayoutInflater inflater;
    private Context context;

    public MainCategoryAdapter(Context context, List<CategoryModel> mainCategories) {
        this.context = context;
        this.mainCategories = mainCategories;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MainCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.categories_list, parent, false);
        return new MainCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainCategoryViewHolder holder, int position) {
        CategoryModel categoryModel = mainCategories.get(position);
        List<SubcategoryModel> subcategoryForCategories = categoryModel.getSubcategoryList();
        if(categoryModel.getSubcategoryList()!= null) {
            Log.d("testList", categoryModel.getSubcategoryList().toString());
        }
        if (categoryModel.isHasSubCategory()){
        SubcategoryAdapter subcategoryAdapter = new SubcategoryAdapter(subcategoryForCategories, context);
        holder.subCatRv.setLayoutManager(new LinearLayoutManager(context));
        holder.subCatRv.setAdapter(subcategoryAdapter);
        } else {
            List<SubcategoryModel> emptyList = new ArrayList<>();
            SubcategoryAdapter subcategoryAdapter = new SubcategoryAdapter(emptyList, context);
            holder.subCatRv.setLayoutManager(new LinearLayoutManager(context));
            holder.subCatRv.setAdapter(subcategoryAdapter);
        }


        holder.categoryNameTextView.setText(categoryModel.getCategoryName());


        boolean isExpanded = mainCategories.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CategoryModel categoryModel = mainCategories.get(position);
                categoryModel.setExpanded(!categoryModel.isExpanded());
                notifyItemChanged(position);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mainCategories.size();
    }

    public void setMainCategories(List<CategoryModel> categories) {
        mainCategories = categories;
    }


    class MainCategoryViewHolder extends RecyclerView.ViewHolder {
        TextView categoryNameTextView;
        ConstraintLayout expandableLayout;
        RecyclerView subCatRv;


        public MainCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryNameTextView = itemView.findViewById(R.id.categoryName);
            expandableLayout = itemView.findViewById(R.id.expandableLayoutcl);
            subCatRv = itemView.findViewById(R.id.subCategoryRvcl);



        }
    }
}
