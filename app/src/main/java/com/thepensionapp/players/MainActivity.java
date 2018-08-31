package com.thepensionapp.players;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SearchView sv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sv= (SearchView) findViewById(R.id.mSearch);
        RecyclerView rv= (RecyclerView) findViewById(R.id.recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        //adapter
        final MyAdapter myAdapter=new MyAdapter(this,getPlayers());
        rv.setAdapter(myAdapter);

        //search manenos
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                //filter as you type
                myAdapter.getFilter().filter(query);
                return false;
            }
        });

    }

    private ArrayList<Player> getPlayers(){
        ArrayList<Player>players=new ArrayList<>();



        Player p=new Player();
        p.setName("alexanser");
        p.setPos("Midfielder");
        p.setImg(R.drawable.alexanser);
        players.add(p);

        p=new Player();
        p.setName("Hazard");
        p.setPos("Foward");
        p.setImg(R.drawable.hazard);
        players.add(p);

        p=new Player();
        p.setName("Kaka");
        p.setPos("Defender");
        p.setImg(R.drawable.kaka);
        players.add(p);

        p=new Player();
        p.setName("Kapienga");
        p.setPos("Defender");
        p.setImg(R.drawable.kapienga);
        players.add(p);

        p=new Player();
        p.setName("Ronaldo");
        p.setPos("Forward");
        p.setImg(R.drawable.ronaldo);
        players.add(p);
        p=new Player();

        p.setName("Roberto");
        p.setPos("Forward");
        p.setImg(R.drawable.roberto);
        players.add(p);

        p=new Player();
        p.setName("Quadrado");
        p.setPos("Forward");
        p.setImg(R.drawable.quadrado);
        players.add(p);

        p=new Player();
        p.setName("Oscar");
        p.setPos("Midfileder");
        p.setImg(R.drawable.oscar);
        players.add(p);

        p=new Player();
        p.setName("Mata");
        p.setPos("Forward");
        p.setImg(R.drawable.mata);
        players.add(p);
        p=new Player();
        p.setName("Martinez");
        p.setPos("Forward");
        p.setImg(R.drawable.kartinez);
        players.add(p);


        return players;

    }
}
