package com.prakriti.mutigridview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.prakriti.mutigridview.R;

public class LandscapeRailsHGV extends RecyclerView.Adapter<LandscapeRailsHGV.LandscapeRailsVH> {
    // separate adapter for each row
    // get info from other activity
    private static final String TAG = "LandscapeRailsHGV";

    private Context context;
    private String[] namesArray;
    private int[] imagesArray;

    public LandscapeRailsHGV(Context context, String[] namesArray, int[] imagesArray) {
        this.context = context;
        this.namesArray = namesArray;
        this.imagesArray = imagesArray;
    }

    @NonNull
    @Override
    public LandscapeRailsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hgv_content_landscape, parent, false);
        return new LandscapeRailsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LandscapeRailsVH holder, int position) {
        holder.getMyText().setText(namesArray[position]);
        Glide.with(context).load(R.drawable.horizontal_placeholder).into(holder.getMyImage());
        holder.getMyImage().setOnClickListener(new View.OnClickListener() { // -> consider custom view
            @Override
            public void onClick(View image) {
                YoYo.with(Techniques.Pulse).duration(300).playOn(image);
                Toast.makeText(context, namesArray[position], Toast.LENGTH_SHORT).show();
            }
        });
//        holder.myText.setText(namesArray[position]);
//        holder.myImage.setImageResource(imagesArray[position]);
    }

    @Override
    public int getItemCount() {
        return imagesArray.length;
    }

    public static class LandscapeRailsVH extends RecyclerView.ViewHolder {

        private LinearLayout linearLayout;
        private ImageView myImage;
        private TextView myText;

        public LandscapeRailsVH(@NonNull View view) {
            super(view);
            myImage = view.findViewById(R.id.imgItemLandscape);
            myText = view.findViewById(R.id.txtItemLandscape);
            linearLayout = view.findViewById(R.id.landscapeLinearLayout);
        }

        public LinearLayout getLinearLayout() {
            return linearLayout;
        }

        public ImageView getMyImage() {
            return myImage;
        }

        public TextView getMyText() {
            return myText;
        }
    }

}

/*
    @Override
    public int getCount() {
        return namesArray.length;
    }

    @Override
    public Object getItem(int position) {
        return namesArray[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.hgv_content_landscape, null);
        }
        LandscapeRailsHGV.MyHGVHolder holder = new LandscapeRailsHGV.MyHGVHolder(convertView);
        holder.txtItemLandscape.setText(namesArray[position]);
        holder.myImage.setImageResource(imagesArray[position]);
        holder.myImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View image) {
                YoYo.with(Techniques.Pulse).duration(300).playOn(image);
                Toast.makeText(context, namesArray[position], Toast.LENGTH_SHORT).show();
            }
        });
        holder.landscapeLinearLayout.setOnFocusChangeListener(new View.OnFocusChangeListener() { // check this
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    holder.landscapeLinearLayout.animate().scaleX(1.15f).scaleY(1.15f);
                }
                else {
                    holder.landscapeLinearLayout.animate().scaleX(1.0f).scaleY(1.0f);
                }
            }
        });
        return convertView;
    }
*/