package com.b.michmerhuizen.couponsnotused;

import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.FragmentManager;

import com.b.michmerhuizen.couponsnotused.ui.main.tabs.coupons.CouponsFragment;
import com.b.michmerhuizen.couponsnotused.ui.main.tabs.coupons.CouponsRecyclerViewAdapter;
import com.b.michmerhuizen.couponsnotused.ui.main.tabs.coupons.vo.Coupon;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import com.b.michmerhuizen.couponsnotused.ui.main.tabs.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity implements CouponsFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, fm );

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }

    @Override
    public void onListFragmentInteraction(CouponsRecyclerViewAdapter.CouponHolder holder) {
        Log.d(holder.mItem.item_number,"clicked"+holder.mItem.item_number);
        RecyclerView rv = (RecyclerView) holder.mView.getParent();
        CouponsRecyclerViewAdapter adapter = (CouponsRecyclerViewAdapter) rv.getAdapter();
        adapter.add(new Coupon(String.valueOf(adapter.getItemCount()+1), "Scan a barcode","no barcode has been scanned yet"));


    }
}