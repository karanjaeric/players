package com.thepensionapp.players;

import android.widget.Filter;

import java.util.ArrayList;

/**
 * Created by ekaranja on 6/3/18.
 */

public class CustomFilter  extends Filter{
    MyAdapter adapter;
    ArrayList<Player>filterList;

    public CustomFilter(MyAdapter adapter, ArrayList<Player> filterList) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    //Filtering occurs here
    @Override
    protected FilterResults performFiltering(CharSequence constratint) {
        FilterResults results=new FilterResults();
        //check constraint validity
        if(constratint !=null && constratint.length()>0){

            //change to upper
            constratint=constratint.toString().toUpperCase();
            ArrayList<Player>filteredPlayers=new ArrayList<>();//store filtered players
            for(int i=0;i<filterList.size();i++){

                if(filterList.get(i).getName().toUpperCase().contains(constratint)){
                    //add player to filtered player
                    filteredPlayers.add(filterList.get(i));

                }
            }
            results.count=filteredPlayers.size();
            results.values=filteredPlayers;

        }else{

            results.count=filterList.size();
            results.values=filterList;

        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        adapter.players= (ArrayList<Player>) filterResults.values;
        adapter.notifyDataSetChanged();

    }
}
