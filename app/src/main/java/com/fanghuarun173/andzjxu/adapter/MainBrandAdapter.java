package com.fanghuarun173.andzjxu.adapter;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.fanghuarun173.andzjxu.R;

import com.fanghuarun173.andzjxu.http.entity.BrandEntity;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.w3c.dom.Text;

import java.util.List;

public class MainBrandAdapter extends RecyclerView.Adapter<MainBrandAdapter.MainBrandHolder> implements View.OnClickListener {

    private static  final  String TAG="main_brand_recyclelist";
    private List<BrandEntity> brands;
    private Activity mcontent;

    public MainBrandAdapter(List<BrandEntity> brands, Activity mcontent){
        this.brands=brands;
        this.mcontent=mcontent;
    }

    @NonNull
    @Override
    public MainBrandHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(mcontent).inflate(R.layout.item_main_brand,viewGroup,false);
        view.setOnClickListener(this);
        return new MainBrandHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainBrandHolder mainBrandHolder, int i) {
        BrandEntity brandEntity=brands.get(i);
        mainBrandHolder.name.setText(brandEntity.name);
        mainBrandHolder.destription.setText(brandEntity.description);
        mainBrandHolder.keywords.setText(brandEntity.keywords);
//        ImageLoader.getInstance().displayImage(brandEntity.logo,mainBrandHolder.logo);
        mainBrandHolder.logo.setText(brandEntity.logo);

    }

    @Override
    public int getItemCount() {
        if(brands != null){
            return brands.size();
        }
        return 0;
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG,"isclicked");
    }


    public class MainBrandHolder extends RecyclerView.ViewHolder{
//        public final ImageView logo;
        public  final  TextView logo;
        public final TextView name;
        public final TextView keywords;
        public final TextView destription;


        public MainBrandHolder(@NonNull View itemView) {
            super(itemView);
//            logo=(ImageView)itemView.findViewById(R.id.main_brand_logo);
            logo=(TextView) itemView.findViewById(R.id.main_brand_logo);
            name=(TextView)itemView.findViewById(R.id.main_brand_name);
            keywords=(TextView)itemView.findViewById(R.id.main_brand_keywords);
            destription=(TextView)itemView.findViewById(R.id.main_brand_destription);
        }
    }
}
