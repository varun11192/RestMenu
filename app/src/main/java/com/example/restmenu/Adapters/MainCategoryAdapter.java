package com.example.restmenu.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restmenu.Models.CategoryModel;
import com.example.restmenu.Models.YourResponseModel;
import com.example.restmenu.R;

import java.util.List;

public class MainCategoryAdapter extends RecyclerView.Adapter<MainCategoryAdapter.MainCategoryViewHolder> {

    private List<CategoryModel> mainCategories;


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

        // Set the data for the main category item
        holder.categoryNameTextView.setText(categoryModel.getCategoryName());

        // You can also set an OnClickListener for each main category item if needed
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle item click here
                // You can navigate to subcategories or perform some action
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


    static class MainCategoryViewHolder extends RecyclerView.ViewHolder {
        TextView categoryNameTextView;

        public MainCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryNameTextView = itemView.findViewById(R.id.categoryName);
            // Initialize other views if necessary
        }
    }
}
