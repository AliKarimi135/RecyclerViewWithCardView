package com.kingarmstring.listviewwithcardview;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BirdsAdapter extends RecyclerView.Adapter<BirdsAdapter.MyViewHolder> {

    private List<Drawable> imgs;
    private List<String> names;
    private List<String> desc;

    BirdsAdapter(List<Drawable> imgs, List<String> names, List<String> desc) {
        this.imgs = imgs;
        this.names = names;
        this.desc = desc;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtDesc.setText(desc.get(position));
        holder.txtCharName.setText(names.get(position));
        holder.birdImage.setImageDrawable(imgs.get(position));
    }

    @Override
    public int getItemCount() {
        return imgs.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView birdImage;
        TextView txtCharName;
        TextView txtDesc;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            birdImage = itemView.findViewById(R.id.img);
            txtCharName = itemView.findViewById(R.id.txtCharName);
            txtDesc = itemView.findViewById(R.id.txtDesc);
        }
    }
}
