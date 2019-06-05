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
import com.example.geeknews.geeknews.bean.RiBaoBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class XclMyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private final int ONE_BANNER = 0;
    private final int TWO = 1;

    public XclMyAdapter(Context context) {
        mContext = context;
    }

    public List<RiBaoBean.StoriesBean> mList = new ArrayList<>();
    public List<RiBaoBean.TopStoriesBean> mBannerList = new ArrayList<>();

    public void addBannerUI(List<RiBaoBean.TopStoriesBean> mBannerList) {
        if (mBannerList != null) {
            this.mBannerList.addAll(mBannerList);
            notifyDataSetChanged();
        }
    }

    public void addUI(List<RiBaoBean.StoriesBean> mList) {
        if (mList != null) {
            this.mList.addAll(mList);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case ONE_BANNER:
                View inflate = LayoutInflater.from(mContext).inflate(R.layout.ribao_item_banner, parent, false);
                return new BannerViewHolder(inflate);
            case TWO:
                View inflate1 = LayoutInflater.from(mContext).inflate(R.layout.ribao_item_list, parent,false);
                return new ListViewHolder(inflate1);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case ONE_BANNER:
                BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
                bannerViewHolder.ban.setImages(mBannerList).setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        RiBaoBean.TopStoriesBean topStoriesBean = (RiBaoBean.TopStoriesBean) path;
                        Glide.with(context).load(topStoriesBean.getImage()).into(imageView);
                    }
                }).start();
                break;
            case TWO:
                int currentPosition;
                if(mBannerList.size()>0){
                    currentPosition = position-1;
                }else{
                    currentPosition = position;
                }
                ListViewHolder listViewHolder = (ListViewHolder) holder;
                listViewHolder.tv_title.setText(mList.get(currentPosition).getTitle());
                String s = mList.get(currentPosition).getImages().get(0);
                Glide.with(mContext).load(s).into(listViewHolder.iv_imageurl);

                break;
        }
    }

    @Override
    public int getItemCount() {
        if (mBannerList.size() > 0 && mBannerList != null) {
            return mList.size() + 1;
        } else {
            return mList.size();
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ONE_BANNER;
        } else {
            return TWO;
        }
    }
    class BannerViewHolder extends RecyclerView.ViewHolder{
            private Banner ban;
        public BannerViewHolder(View itemView) {
            super(itemView);
            ban = itemView.findViewById(R.id.ban);
        }
    }

    class ListViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv_imageurl;
        private TextView tv_title;
        public ListViewHolder(View itemView) {
            super(itemView);
            iv_imageurl = itemView.findViewById(R.id.iv_imageurl);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
