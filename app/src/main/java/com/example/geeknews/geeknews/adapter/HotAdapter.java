package com.example.geeknews.geeknews.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.geeknews.geeknews.R;
import com.example.geeknews.geeknews.bean.HotBean;

import java.util.ArrayList;
import java.util.List;

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.ViewHolder> {
    private Context mContext;

    public HotAdapter(Context context) {
        mContext = context;
    }
    public List<HotBean.RecentBean>  mList = new ArrayList<>();
    public void addUI(List<HotBean.RecentBean>  mList){
        if (mList!=null){
            this.mList.addAll(mList);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.hot_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HotBean.RecentBean recentBean = mList.get(position);

        holder.tv_title.setText(recentBean.getTitle());
        Glide.with(mContext).load(recentBean.getThumbnail()).into(holder.iv_url);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_url;
        private TextView tv_title;
        public ViewHolder(View itemView) {
            super(itemView);
            iv_url = itemView.findViewById(R.id.iv_url);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
