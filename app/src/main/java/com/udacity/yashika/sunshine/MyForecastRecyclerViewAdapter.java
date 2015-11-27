package com.udacity.yashika.sunshine;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.udacity.yashika.sunshine.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link ForecastFragment.OnListFragmentInteractionListener}. TODO: Replace the
 * implementation with code for your data type.
 */
public class MyForecastRecyclerViewAdapter extends RecyclerView.Adapter<MyForecastRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final ForecastFragment.OnListFragmentInteractionListener mListener;

    public MyForecastRecyclerViewAdapter (List<DummyItem> items, ForecastFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_forecast_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder (final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount () {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public DummyItem mItem;

        public ViewHolder (View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.list_item_forecast_text_view);
        }

        @Override
        public String toString () {
            return super.toString() + " '";
        }
    }
}
