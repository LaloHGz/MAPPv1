package com.aplication.mapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.aplication.mapp.R;

import java.util.List;

public class HomeViewPagerAdapter extends RecyclerView.Adapter<HomeViewPagerAdapter.SliderViewHolder>{

    private List<HomeItems> SliderItems;
    private ViewPager2 viewPager2;

    public HomeViewPagerAdapter(List<HomeItems> sliderItems, ViewPager2 viewPager2) {
        this.SliderItems = sliderItems;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.home_view_pager,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {

        holder.setImage(SliderItems.get(position));
    }

    @Override
    public int getItemCount() {
        return SliderItems.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder{


        private ImageView imageView;


        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.intro_img);
        }

        void setImage(HomeItems sliderItem)
        {
            imageView.setImageResource(sliderItem.getScreenImg());
        }


    }



}
