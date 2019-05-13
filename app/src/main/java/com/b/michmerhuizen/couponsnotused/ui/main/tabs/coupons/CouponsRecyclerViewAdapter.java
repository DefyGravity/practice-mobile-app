package com.b.michmerhuizen.couponsnotused.ui.main.tabs.coupons;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.b.michmerhuizen.couponsnotused.R;
import com.b.michmerhuizen.couponsnotused.ui.main.tabs.coupons.CouponsFragment.OnListFragmentInteractionListener;
import com.b.michmerhuizen.couponsnotused.ui.main.tabs.coupons.vo.Coupon;

import java.util.LinkedList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Coupon} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 *
 */
public class CouponsRecyclerViewAdapter extends RecyclerView.Adapter<CouponsRecyclerViewAdapter.CouponHolder> {

    private final List<Coupon> mValues;
    private final OnListFragmentInteractionListener mListener;

    public CouponsRecyclerViewAdapter(OnListFragmentInteractionListener listener){
        mValues = new LinkedList<>();
        mValues.add(Coupon.ADD_COUPON);
        mListener = listener;
    }
    public CouponsRecyclerViewAdapter(List<Coupon> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    public CouponsRecyclerViewAdapter add(Coupon coupon){
        mValues.add(coupon);
        this.notifyDataSetChanged();
        return this;
    }

    @Override
    public CouponHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_coupon, parent, false);

        return new CouponHolder(view);
    }

    @Override
    public void onBindViewHolder(final CouponHolder holder, int position) {
        holder.mItem = mValues.get(position);
        TextView tv = holder.mView.findViewById(R.id.item_number);
        tv.setText(holder.mItem.item_number);
        tv = holder.mView.findViewById(R.id.content);
        tv.setText(holder.mItem.content);
        if(position ==0){
            holder.mView.setOnClickListener(v -> {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class CouponHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public  Coupon mItem;

        public CouponHolder(View view) {
            super(view);
            mView = view;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mItem.details + "'";
        }
    }
}
