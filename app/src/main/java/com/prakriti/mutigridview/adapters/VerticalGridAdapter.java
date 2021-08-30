package com.prakriti.mutigridview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.leanback.widget.HorizontalGridView;
import androidx.recyclerview.widget.RecyclerView;

import com.prakriti.mutigridview.R;

public class VerticalGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "VerticalGridAdapter";

    private Context context;
    private String[] titleList;

    public String heroes[] = new String[]{"IRON MAN", "CAPTAIN AMERICA", "SPIDERMAN", "THOR", "HULK", "BLACK WIDOW", "HAWKEYE"};
    public int heroImages[] = {R.drawable.ironman, R.drawable.captainamerica, R.drawable.spiderman, R.drawable.thor, R.drawable.hulk,
            R.drawable.blackwidow, R.drawable.hawkeye};
    public String shows[] = new String[]{"THIS IS US", "SUPERNATURAL", "MODERN FAMILY", "FRIENDS", "CRIMINAL MINDS", "COMMUNITY",
            "BROOKLYN 99"};
    public int showImages[] = {R.drawable.thisisus, R.drawable.supernatural, R.drawable.modernfamily, R.drawable.friends,
            R.drawable.criminalminds, R.drawable.community, R.drawable.b99};
    public String channels[] = new String[]{"HBO MAX", "DISNEY+ HOTSTAR", "HULU", "NETFLIX", "PRIME VIDEO", "ROKU", "YOUTUBE"};
    public int channelImages[] = {R.drawable.hbo, R.drawable.hotstar, R.drawable.hulu, R.drawable.netflix, R.drawable.prime,
            R.drawable.roku, R.drawable.youtube};

    LandscapeRailsHGV[] landscapeHGVAdapters;
    PortraitRailsHGV[] portraitHGVAdapters;


    public VerticalGridAdapter(Context context, String[] titleList) {
        this.context = context;
        this.titleList = titleList;
        landscapeHGVAdapters = new LandscapeRailsHGV[] { new LandscapeRailsHGV(context, heroes, heroImages),
                new LandscapeRailsHGV(context, shows, showImages), new LandscapeRailsHGV(context, channels, channelImages) };
        portraitHGVAdapters = new PortraitRailsHGV[] { new PortraitRailsHGV(context, heroes, heroImages),
                new PortraitRailsHGV(context, shows, showImages), new PortraitRailsHGV(context, channels, channelImages) };
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vgv_content_land, parent, false);
                return (RecyclerView.ViewHolder) new LandscapeVGV(view);
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vgv_content_port, parent, false);
                return (RecyclerView.ViewHolder) new PortraitVGV(view);
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vgv_content_land, parent, false);
                return (RecyclerView.ViewHolder) new LandscapeVGV(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof LandscapeVGV) {
            LandscapeVGV holderL = (LandscapeVGV) holder;
            holderL.getHGVTitleText().setText(titleList[position]);
            holderL.getHorizontalGridView().setAdapter(landscapeHGVAdapters[position]); // create new adapter passing all items
        }
        else if(holder instanceof PortraitVGV) {
            PortraitVGV holderP = (PortraitVGV) holder;
            holderP.getHGVTitleText().setText(titleList[position]);
            holderP.getHorizontalGridView().setAdapter(portraitHGVAdapters[position]);
        }
        //        holder.getHGVTitleText().setText(titleList[position]);
//        holder.getHorizontalGridView().setAdapter(landscapeHGVAdapters[position]);
    }

    @Override
    public int getItemCount() {
        return titleList.length * 2;
    }

    public static class LandscapeVGV extends RecyclerView.ViewHolder {

        private final TextView HGVTitleText;
        private final HorizontalGridView horizontalGridView;

        public LandscapeVGV(@NonNull View view) {
            super(view);
            horizontalGridView = view.findViewById(R.id.horizontalGridLandscape);
            HGVTitleText = view.findViewById(R.id.HGVTitleTextLandscape);
        }

        public TextView getHGVTitleText() {
            return HGVTitleText;
        }

        public HorizontalGridView getHorizontalGridView() {
            return horizontalGridView;
        }
    }

    public static class PortraitVGV extends RecyclerView.ViewHolder {

        private TextView HGVTitleText;
        private HorizontalGridView horizontalGridView;

        public PortraitVGV(@NonNull View view) {
            super(view);
            horizontalGridView = view.findViewById(R.id.horizontalGridPortrait);
            HGVTitleText = view.findViewById(R.id.HGVTitleTextPortrait);
        }

        public TextView getHGVTitleText() {
            return HGVTitleText;
        }

        public HorizontalGridView getHorizontalGridView() {
            return horizontalGridView;
        }
    }
}














/*
    @Override
    public int getCount() {
        return titleList.length;
    }

    @Override
    public Object getItem(int position) {
        return titleList[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.vgv_content_land, null);
        }
        MyVGVHolder holder = new VerticalGridAdapter.MyVGVHolder(convertView);
        // loop over Horizontal rows
        Adapter[] adapters = { new LandscapeRailsHGV(context, heroes, heroImages) };
//                horizontalGridAdapter = new LandscapeRailsHGV(context, heroes, heroImages);
        holder.horizontalGridView.setAdapter(adapters[position]);
        return convertView;
    }
*/