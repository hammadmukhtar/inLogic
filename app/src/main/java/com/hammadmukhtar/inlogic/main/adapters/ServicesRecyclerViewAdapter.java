package com.hammadmukhtar.inlogic.main.adapters;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hammadmukhtar.inlogic.R;
import com.hammadmukhtar.inlogic.api.ServicesAPI;
import com.hammadmukhtar.inlogic.api.models.Service;
import com.hammadmukhtar.inlogic.main.MainActivity;
import com.hammadmukhtar.inlogic.main.ServicesFragment.OnListFragmentInteractionListener;

import java.util.List;

import javax.inject.Inject;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Service.Data} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class ServicesRecyclerViewAdapter extends RecyclerView.Adapter<ServicesRecyclerViewAdapter.ViewHolder> {

    private final List<Service.Data> mValues;
    private final OnListFragmentInteractionListener mListener;
    private final int columnCount;
    @Inject
    ServicesAPI servicesAPI;

    public ServicesRecyclerViewAdapter(List<Service.Data> items, OnListFragmentInteractionListener listener, int columnCount) {
        mValues = items;
        mListener = listener;
        this.columnCount = columnCount;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_service, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(String.valueOf(mValues.get(position).getId()));
        holder.mContentView.setText(mValues.get(position).getName());

        if (holder.recyclerView instanceof RecyclerView) {
            if (columnCount <= 1) {
                holder.recyclerView.setLayoutManager(new LinearLayoutManager((MainActivity)mListener));
            } else {
                holder.recyclerView.setLayoutManager(new GridLayoutManager((MainActivity)mListener, columnCount));
            }
            holder.recyclerView.setAdapter(new SubServicesRecyclerViewAdapter(holder.mItem.getSubServices()));
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public final RecyclerView recyclerView;
        public Service.Data mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
            recyclerView = view.findViewById(R.id.sub_list);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
