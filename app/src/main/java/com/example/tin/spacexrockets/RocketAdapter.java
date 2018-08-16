package com.example.tin.spacexrockets;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tin.spacexrockets.models.rocket.RocketResponse;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;


public class RocketAdapter extends RecyclerView.Adapter<RocketAdapter.ViewHolder> {

    private ArrayList<RocketResponse> mRockets;
    private Context mContext;
    private final RocketPositionListener mRocketPositionListener;
    private LayoutInflater layoutInflater;

    public RocketAdapter(Context mContext, RocketPositionListener listener) {

        mContext = mContext;
        this.mRocketPositionListener = listener;
        mRockets = new ArrayList<>();
        layoutInflater = LayoutInflater.from(mContext);
    }

    @Nullable
    @Override
    public RocketAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = layoutInflater.inflate(R.layout.rocket_list_item, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RocketAdapter.ViewHolder viewHolder, int position) {

        RocketResponse rocket = mRockets.get(position);

        viewHolder.nameTv.setText(rocket.getName());
        viewHolder.engineCountTv.setText(String.valueOf(rocket.getEngines().getNumber()));
        viewHolder.countryTv.setText(rocket.getCountry());

    }

    @Override
    public int getItemCount() {
        if (mRockets == null) {
            return 0;
        } else {
            return mRockets.size();
        }
    }

    // Here we are adding the new Rocket data, and removing the old data */
    public void addItems(List<RocketResponse> listToAdd) {

        this.mRockets.clear();
        this.mRockets.addAll(listToAdd);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final TextView nameTv;
        final TextView engineCountTv;
        final TextView countryTv;

        public ViewHolder(View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.tV_name);
            engineCountTv = itemView.findViewById(R.id.tV_engineCount);
            countryTv = itemView.findViewById(R.id.tV_country);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // getAdapterPosition() ensures we only take the item clicked on
                    mRocketPositionListener.rocketItemClick(mRockets.get(getAdapterPosition()));
                }
            });
        }
    }
}
