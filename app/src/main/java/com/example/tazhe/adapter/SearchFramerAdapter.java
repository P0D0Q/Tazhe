package com.example.tazhe.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tazhe.R;
import com.example.tazhe.activity.UserActivity;
import com.example.tazhe.beans.SearchFramer;
import com.example.tazhe.beans.SearchUser;

import java.util.List;

public class SearchFramerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<SearchFramer> list;
    private Context context;
    private LayoutInflater layoutInflater;

    public SearchFramerAdapter(Context context, List<SearchFramer> list) {
        this.context = context;
        this.list=list;
        layoutInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= layoutInflater.inflate(R.layout.item_search,parent,false);
        return new SearchFramerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final SearchFramer searchFramerList = list.get(position);
        if (searchFramerList == null)
            return;

        ViewHolder viewHolder = (ViewHolder)holder;
//

        //setText里是String，id是int
        viewHolder.searchtext.setText(searchFramerList.getFramername());;

        //按钮响应事件；点击按钮，跳转页面，显示店铺详情
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), UserActivity.class);
                intent.putExtra("framerid",searchFramerList.getFramer_id());
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(list==null)
            return 0;
        else return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView searchtext;
        public ViewHolder(View view) {
            super(view);
            searchtext = (TextView) view.findViewById(R.id.searchtext);

        }
    }
}
