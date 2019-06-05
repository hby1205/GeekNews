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
import com.example.geeknews.geeknews.bean.ThemeBean;

import java.util.ArrayList;
import java.util.List;

public class ThemeAdapter extends RecyclerView.Adapter<ThemeAdapter.ViewHolder> {
    private Context mContext;

    public ThemeAdapter(Context context) {
        mContext = context;
    }
    private List<ThemeBean.DataBean> mList = new ArrayList<>();
    public void addUI(List<ThemeBean.DataBean> mList){
        if (mList!=null){
            this.mList.addAll(mList);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.theme_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ThemeBean.DataBean dataBean = mList.get(position);


        holder.tv_name.setText(dataBean.getName());
        Glide.with(mContext).load(dataBean.getThumbnail()).into(holder.iv_thumbnail);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_thumbnail;
        private TextView tv_name;
        public ViewHolder(View itemView) {
            super(itemView);
            iv_thumbnail = itemView.findViewById(R.id.iv_thumbnail);
            tv_name = itemView.findViewById(R.id.tv_name);
        }
    }
}
