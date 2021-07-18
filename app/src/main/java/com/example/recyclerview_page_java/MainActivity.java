package com.example.recyclerview_page_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String[] objects = {"elma", "bisiklet","harita","kalem","araba","bilgisayar"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter adapter = new MyAdapter(this, objects);
        recyclerView.setAdapter(adapter);




    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

        Context c;
        String[] objects;

        public MyAdapter(Context c, String[] objects) {
            this.c = c;
            this.objects = objects;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View view = LayoutInflater.from(c).inflate(R.layout.objects, parent, false);
            return new MyViewHolder(view);
        }


        @Override
        public void onBindViewHolder(MyViewHolder  holder, int position){
            holder.txtObjectName.setText(objects[position]);
        }

        @Override
        public int getItemCount(){
            return objects.length;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtObjectName;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtObjectName =(TextView) itemView.findViewById(R.id.txtobje) ;
        }
    }



}