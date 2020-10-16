package com.example.tazhe.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;


public abstract class RecyclerViewAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private SharedPreferences sp;
    protected int layoutResource;
    protected Context context;
    protected List data = new ArrayList();
    protected LayoutInflater layoutInflater;

    public RecyclerViewAdapter(Context context, List data, int layoutResource) {
        this.layoutResource = layoutResource;
        this.context = context;
        this.data.clear();
        this.data.addAll(data);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (getClass().getGenericSuperclass() instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
            Class cls = (Class) parameterizedType.getActualTypeArguments()[0];
            View view = layoutInflater.inflate(layoutResource, viewGroup, false);
            try {
                Constructor<VH> constructor = cls.getConstructor(View.class);
                return constructor.newInstance(view);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public void setData(List data){
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }
    public String getUser_id()
    {
        sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        return sp.getString("user_id", "");
    }

}

