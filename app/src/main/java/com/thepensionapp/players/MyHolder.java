package com.thepensionapp.players;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ekaranja on 6/3/18.
 */

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    //our views
    ImageView img;
    TextView nameTxt,posTxt;
    ItemClickListener itemClickListener;

    //our constructor

    public MyHolder(View itemView) {
        super(itemView);

        this.img=itemView.findViewById(R.id.playerImage);
        this.nameTxt=itemView.findViewById(R.id.nameTxt);
        this.posTxt=itemView.findViewById(R.id.posTxt);
       // this.nameTxt.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //this.itemClickListener.onItemClick(view,getLayoutPosition());
        Toast.makeText(view.getContext(),"Player clicked  is"+this.nameTxt.toString(),Toast.LENGTH_SHORT).show();

    }
    public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener=ic;
    }

}
