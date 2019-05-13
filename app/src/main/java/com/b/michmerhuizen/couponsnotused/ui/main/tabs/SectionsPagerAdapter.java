package com.b.michmerhuizen.couponsnotused.ui.main.tabs;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LiveData;

import com.b.michmerhuizen.couponsnotused.ui.main.tabs.coupons.CouponsFragment;
import com.b.michmerhuizen.couponsnotused.R;
import com.b.michmerhuizen.couponsnotused.ui.main.tabs.vo.Tab;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private List<Tab> tabs;
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        this.tabs = new LinkedList<>();
        this.tabs.add(Tab.ADD_ME);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return CouponsFragment.newInstance(1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return this.tabs.get(position).getTitle();
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return this.tabs.size();
    }
}