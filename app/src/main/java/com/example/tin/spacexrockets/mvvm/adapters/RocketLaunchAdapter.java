package com.example.tin.spacexrockets.mvvm.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tin.spacexrockets.R;
import com.example.tin.spacexrockets.models.rocketLaunch.RocketLaunchResponse;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;


public class RocketLaunchAdapter extends RecyclerView.Adapter<RocketLaunchAdapter.ViewHolder> {

    private ArrayList<RocketLaunchResponse> mRocketLaunchResponse;
    private Context mContext;
    private LayoutInflater layoutInflater;

    public RocketLaunchAdapter(Context mContext) {

        mContext = mContext;
        this.mRocketLaunchResponse = new ArrayList<>();
        this.layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RocketLaunchAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = layoutInflater.inflate(R.layout.rocket_launch_list_item, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RocketLaunchAdapter.ViewHolder viewHolder, int position) {

        RocketLaunchResponse rocketLaunch = mRocketLaunchResponse.get(position);

        viewHolder.launchYear.setText(rocketLaunch.getLaunchYear());
        viewHolder.missionNameTv.setText(rocketLaunch.getMissionName());
        viewHolder.launchDateTv.setText(rocketLaunch.getLaunchDateUtc());
        viewHolder.launchSuccessTv.setText(Boolean.toString(rocketLaunch.getLaunchSuccess()));
        Picasso.get().load(rocketLaunch.getLinks().getMissionPatchSmall()).into(viewHolder.missionPatchIv);

    }

    @Override
    public int getItemCount() {
        if (mRocketLaunchResponse == null) {
            return 0;
        } else {
            return mRocketLaunchResponse.size();
        }
    }

    public void addItems(ArrayList<RocketLaunchResponse> listToAdd) {

        this.mRocketLaunchResponse.clear();
        this.mRocketLaunchResponse.addAll(listToAdd);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final TextView launchYear;
        final TextView missionNameTv;
        final TextView launchDateTv;
        final TextView launchSuccessTv;
        final ImageView missionPatchIv;

        public ViewHolder(View itemView) {
            super(itemView);

            launchYear = itemView.findViewById(R.id.tV_launchYear);
            missionNameTv = itemView.findViewById(R.id.tV_missionName);
            launchDateTv = itemView.findViewById(R.id.tV_launchDate);
            launchSuccessTv = itemView.findViewById(R.id.tV_launchSuccess);
            missionPatchIv = itemView.findViewById(R.id.iV_missionPatch);

        }
    }
}
