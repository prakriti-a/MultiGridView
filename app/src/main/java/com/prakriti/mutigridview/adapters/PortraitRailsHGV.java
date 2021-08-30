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

public class PortraitRailsHGV extends RecyclerView.Adapter<PortraitRailsHGV.PortraitRailsVH> {
    // separate adapter for each row
    // get info from other activity
    private static final String TAG = "PortraitRailsHGV";

    private Context context;
    private String[] namesArray;
    private int[] imagesArray;

    public PortraitRailsHGV(Context context, String[] namesArray, int[] imagesArray) {
        this.context = context;
        this.namesArray = namesArray;
        this.imagesArray = imagesArray;
    }

    @NonNull
    @Override
    public PortraitRailsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hgv_content_portrait, parent, false);
            return new PortraitRailsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PortraitRailsVH holder, int position) {
    holder.getMyText().setText(namesArray[position]);
    Glide.with(context).load(R.drawable.vertical_placeholder).into(holder.getMyImage());
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


    public static class PortraitRailsVH extends RecyclerView.ViewHolder {

        private LinearLayout linearLayout;
        private ImageView myImage;
        private TextView myText;

        public PortraitRailsVH(@NonNull View view) {
            super(view);
            myImage = view.findViewById(R.id.imgItemPortrait);
            myText = view.findViewById(R.id.txtItemPortrait);
            linearLayout = view.findViewById(R.id.portraitLinearLayout);
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
