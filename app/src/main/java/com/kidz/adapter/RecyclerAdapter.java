package com.kidz.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kidz.R;
import com.kidz.modal.pojo.VideoList;
import com.kidz.views.activity.MainActivity;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<VideoList> list=new ArrayList<>();
    private List<VideoList> oldlist=new ArrayList<>();

    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<VideoList> list,List<VideoList> oldlist)
    {
        this.list=list;
        this.oldlist=oldlist;
        notifyDataSetChanged();

    }

    class PaymentViewHolder extends RecyclerView.ViewHolder{

        public ImageView thumb;

        public PaymentViewHolder(View itemView) {
            super(itemView);
            thumb=(ImageView)itemView.findViewById(R.id.thumb);


        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewlayout, parent, false);
        viewHolder = new PaymentViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        Picasso.with(context).load("http://img.youtube.com/vi/"+getYoutubeVideoId(list.get(position).getUrl())+"/3.jpg").placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher).into(((PaymentViewHolder) holder).thumb);

        ((PaymentViewHolder) holder).thumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,MainActivity.class);
                //i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("videoId",getYoutubeVideoId(list.get(position).getUrl()));
                i.putExtra("data", (Serializable) oldlist);
                i.putExtra("position", position);
                context.startActivity(i);
                ((Activity) context).finish();
            }
        });


    }
    public static String getYoutubeVideoId(String youtubeUrl)
    {
        String video_id="";
        if (youtubeUrl != null && youtubeUrl.trim().length() > 0 && youtubeUrl.startsWith("http"))
        {

            String expression = "^.*((youtu.be"+ "\\/)" + "|(v\\/)|(\\/u\\/w\\/)|(embed\\/)|(watch\\?))\\??v?=?([^#\\&\\?]*).*"; // var regExp = /^.*((youtu.be\/)|(v\/)|(\/u\/\w\/)|(embed\/)|(watch\?))\??v?=?([^#\&\?]*).*/;
            CharSequence input = youtubeUrl;
            Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches())
            {
                String groupIndex1 = matcher.group(7);
                if(groupIndex1!=null && groupIndex1.length()==11)
                    video_id = groupIndex1;
            }
        }
        return video_id;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
