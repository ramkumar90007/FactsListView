package com.view.list.facts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.view.list.R;
import com.view.list.facts.model.NewsFeed;


import java.util.List;

/**
 * Created by ramkumarpachaiyappan on 18/02/18.
 */

public class FactsAdapter extends RecyclerView.Adapter<FactsAdapter.ViewHolder> {
    private final OnItemClickListener listener;
    private List<NewsFeed> data;
    private Context context;

    public FactsAdapter(Context context, List<NewsFeed> data, OnItemClickListener listener) {
        this.data = data;
        this.listener = listener;
        this.context = context;
    }


    @Override
    public FactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_facts, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(FactsAdapter.ViewHolder holder, int position) {
        holder.click(data.get(position), listener);

        holder.tvTitle.setText(data.get(position).getTitle());

        holder.tvDescription.setText(data.get(position).getDescription());

        String images = data.get(position).getImageHref();
            Glide.with(context).load(images).into(holder.background);

    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public interface OnItemClickListener {
        void onClick(NewsFeed Item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDescription;
        ImageView background;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.textTitle);
            tvDescription = itemView.findViewById(R.id.textDescription);
            background = itemView.findViewById(R.id.ivFactImage);

        }


        public void click(final NewsFeed newsfeedData, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(newsfeedData);
                }
            });
        }
    }


}
