package com.kidz.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kidz.R;
import com.kidz.modal.pojo.Dbpojo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class WatchedRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Dbpojo> list=new ArrayList<>();

    public WatchedRecyclerAdapter(Context context,List<Dbpojo> list) {
        this.list=list;

        this.context = context;

    }



    class PaymentViewHolder extends RecyclerView.ViewHolder{

        ImageView thumb;
        TextView titile;

        public PaymentViewHolder(View itemView) {
            super(itemView);

            thumb=(ImageView)itemView.findViewById(R.id.thumb);
            titile=(TextView) itemView.findViewById(R.id.title);


        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.watchedlist, parent, false);
        viewHolder = new PaymentViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        Picasso.with(context).load("http://img.youtube.com/vi/"+list.get(position).getVideoid()+"/3.jpg").placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher).into(((PaymentViewHolder) holder).thumb);


        ((PaymentViewHolder) holder).titile.setText(list.get(position).getTitile());
       /* ((PaymentViewHolder) holder).thumb.setOnClickListener(new View.OnClickListener() {
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
        });*/

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
