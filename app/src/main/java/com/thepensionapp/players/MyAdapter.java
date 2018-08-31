package com.thepensionapp.players;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ekaranja on 6/3/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyHolder> implements Filterable {

    Context c;
    ArrayList<Player>players,filterList;
    CustomFilter filter;


    public MyAdapter(Context c, ArrayList<Player> players) {
        this.c = c;
        this.players = players;
        this.filterList = players;
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Convert xml to view
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,null);
        //HOLDER

        MyHolder holder=new MyHolder(view);
        return holder;
    }

    //Bind data to views
    @Override
    public void onBindViewHolder(MyHolder holder,final int position) {
        holder.nameTxt.setText(players.get(position).getName());
        holder.posTxt.setText(players.get(position).getPos());
        holder.img.setImageResource(players.get(position).getImg());
        holder.nameTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(c,"Player clicked  is "+players.get(position).getName(),Toast.LENGTH_SHORT).show();

            }
        });

        //implement click listener


    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    @Override
    public Filter getFilter() {
        if(filter==null){
            filter=new CustomFilter(this,filterList);

        }
        return filter;
    }
}
