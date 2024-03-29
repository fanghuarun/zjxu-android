package com.fanghuarun173.andzjxu.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;

import com.fanghuarun173.andzjxu.R;
import com.fanghuarun173.andzjxu.common.BaseFragment;

public class NavigationFragment extends BaseFragment implements View.OnClickListener{
    private ImageButton mIbHome;
    private ImageButton mIbCategory;
    private ImageButton mIbCart;
    private ImageButton mIbPersonal;
    private HomeFragment homeFragment;
    private CartFragment cartFragment;
    private CategoryFragment categoryFragment;
    private PersonFragment personFragment;

    @Override
    protected void initView(View view) {
        super.initView(view);
        mIbCart=view.findViewById(R.id.ib_cart);
        mIbCategory=view.findViewById(R.id.ib_category);
        mIbHome=view.findViewById(R.id.ib_home);
        mIbPersonal=view.findViewById(R.id.ib_personal);
        mIbHome.setOnClickListener(this);
        mIbCart.setOnClickListener(this);
        mIbCategory.setOnClickListener(this);
        mIbPersonal.setOnClickListener(this);
        select(mIbHome);
    }

    @Override
    protected void initData() {

    }
    private void select(View view){
        mIbHome.setImageResource(R.drawable.tab_item_home_normal);
        mIbCart.setImageResource(R.drawable.tab_item_cart_normal);
        mIbCategory.setImageResource(R.drawable.tab_item_category_normal);
        mIbPersonal.setImageResource(R.drawable.tab_item_personal_normal);

        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        if(homeFragment != null){
            fragmentTransaction.hide(homeFragment);
        }
        if(cartFragment != null){
            fragmentTransaction.hide(cartFragment);
        }
        if(categoryFragment != null){
            fragmentTransaction.hide(categoryFragment);
        }
        if(personFragment != null){
            fragmentTransaction.hide(personFragment);
        }

        switch (view.getId()){
            case R.id.ib_home:
                mIbHome.setImageResource(R.drawable.tab_item_home_focus);
                if(homeFragment == null){
                    homeFragment=new HomeFragment();
                    fragmentTransaction.add(R.id.fl_main_navigation,homeFragment);
                }else{
                    fragmentTransaction.show(homeFragment);
                }
                break;
            case R.id.ib_cart:
                mIbCart.setImageResource(R.drawable.tab_item_cart_focus);
                if(cartFragment == null){
                    cartFragment=new CartFragment();
                    fragmentTransaction.add(R.id.fl_main_navigation,cartFragment);
                }else{
                    fragmentTransaction.show(cartFragment);
                }

                break;
            case R.id.ib_category:
                mIbCategory.setImageResource(R.drawable.tab_item_category_focus);
                if(categoryFragment == null){
                    categoryFragment=new CategoryFragment();
                    fragmentTransaction.add(R.id.fl_main_navigation,categoryFragment);
                }else{
                    fragmentTransaction.show(categoryFragment);
                }

                break;
            case R.id.ib_personal:
                mIbPersonal.setImageResource(R.drawable.tab_item_personal_focus);
                if(personFragment == null){
                    personFragment=new PersonFragment();
                    fragmentTransaction.add(R.id.fl_main_navigation,personFragment);
                }else{
                    fragmentTransaction.show(personFragment);
                }

                break;

        }
        fragmentTransaction.commit();
    }
    @Override
    public int getContentViewId() {
        return R.layout.fragment_navigation;
    }

    @Override
    public void onClick(View v) {
        select(v);
    }
}
