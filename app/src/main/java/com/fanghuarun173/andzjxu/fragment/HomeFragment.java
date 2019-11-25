package com.fanghuarun173.andzjxu.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.fanghuarun173.andzjxu.R;
import com.fanghuarun173.andzjxu.adapter.MainBrandAdapter;
import com.fanghuarun173.andzjxu.common.BaseFragment;
import com.fanghuarun173.andzjxu.http.entity.BrandEntity;
import com.fanghuarun173.andzjxu.http.entity.CategoryEntity;
import com.fanghuarun173.andzjxu.http.presenter.BrandPresenter;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

public class HomeFragment extends BaseFragment implements View.OnClickListener{
    public int getContentViewId() {
        return R.layout.fragment_home;
    }


    private static  final String TAG="fragment_home";
    private List<BrandEntity> brands;
    private MainBrandAdapter adapter;

    private RecyclerView mainBrandRecyclerView;
    private SwipeRefreshLayout mainBrandSwipeRefreshLayout;
    private TextView nodata;

    private View view;
    private OnItemClickListenter onItemClickListenter;

    @Override
    protected void initView(View view) {
        super.initView(view);
        mainBrandSwipeRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.main_brand_swipe_refresh);
        mainBrandRecyclerView=(RecyclerView)view.findViewById(R.id.main_brand_recyclerview);
        nodata=(TextView)view.findViewById(R.id.main_brand_nodata) ;
        brands=new ArrayList<BrandEntity>();
        Log.d(TAG,"LOAD DATA");
        loadData();
        nodata.setVisibility(View.GONE);
        mainBrandSwipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        //下拉刷新监听器
        mainBrandSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
                //下拉刷新
                loadData();
            }
        });

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        mainBrandRecyclerView.setLayoutManager(linearLayoutManager);

        adapter=new MainBrandAdapter(brands,getActivity());
        mainBrandRecyclerView.setAdapter(adapter);
        view.setOnClickListener(this);

    }

    public void setOnItemClickListenter(OnItemClickListenter onItemClickListenter) {
        this.onItemClickListenter = onItemClickListenter;
    }

    @Override
    protected void initData() {
        super.initData();
        loadData();
    }


    private void loadData(){
        BrandPresenter.getBrandList(new Subscriber<List<BrandEntity>>() {
            @Override
            public void onCompleted() {
                mainBrandSwipeRefreshLayout.setRefreshing(false);

            }

            @Override
            public void onError(Throwable e) {
                nodata.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNext(List<BrandEntity> brandEntities) {
                nodata.setVisibility(View.GONE);
                brands.addAll(brandEntities);
                Log.d(TAG,new Integer(brandEntities.size()).toString());
                adapter.notifyDataSetChanged();

            }
        });
    }

    @Override
    public void onClick(View v) {
        if(onItemClickListenter != null){
            int position=(int) v.getTag();
            BrandEntity brandEntity=brands.get(position);
            onItemClickListenter.onItemClick(view,position,brandEntity);
        }
    }

    public interface OnItemClickListenter{
        void onItemClick(View view, int position, BrandEntity entity);
    }
}
