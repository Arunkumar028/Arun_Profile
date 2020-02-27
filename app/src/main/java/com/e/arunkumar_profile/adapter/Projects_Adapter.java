package com.e.arunkumar_profile.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.e.arunkumar_profile.ProjectActivity;
import com.e.arunkumar_profile.R;
import com.e.arunkumar_profile.model.ProjectModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Projects_Adapter extends RecyclerView.Adapter<Projects_Adapter.ViewHolder> {

    Context context;
    ArrayList<ProjectModel> data;



    public Projects_Adapter(Context context, ArrayList<ProjectModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.project_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if(holder instanceof ViewHolder){

            holder.img.setImageResource(data.get(position).getImage());
            holder.name_TV.setText(data.get(position).getName());

            holder.adapter_LL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.e("Pos",data.get(position).getName());
                    Intent intent=new Intent(context, ProjectActivity.class);

                    intent.putExtra("name",""+data.get(position).getName());
                    intent.putExtra("image",data.get(position).getImage());
                    intent.putExtra("url",data.get(position).getUrl());
                    intent.putExtra("desc",data.get(position).getDescription());
                    Log.e("IMG", String.valueOf(data.get(position).getImage()));


                    String transitionName = context.getString(R.string.app_name);
                    View transitionView = view.findViewById(R.id.img);
                    ViewCompat.setTransitionName(transitionView, transitionName);

                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation((Activity) context, transitionView, transitionName);

                    context.startActivity(intent,options.toBundle());

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.name_TV)
        TextView name_TV;
        @BindView(R.id.adapter_LL)
        LinearLayout adapter_LL;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
