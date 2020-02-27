package com.e.arunkumar_profile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.arunkumar_profile.R;
import com.e.arunkumar_profile.model.EducationModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Education_Adapter extends RecyclerView.Adapter<Education_Adapter.ViewHolder> {

    Context context;
    ArrayList<EducationModel> data;

    public Education_Adapter(Context context, ArrayList<EducationModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.education_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if(holder instanceof ViewHolder){

            holder.companyname_TV.setText(data.get(position).getCollege());
            holder.designation_TV.setText(data.get(position).getDesignation());
            holder.duration_TV.setText(data.get(position).getDauration());
            holder.location_TV.setText(data.get(position).getLocation());
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.companyname_TV)
        TextView companyname_TV;

        @BindView(R.id.duration_TV)
        TextView duration_TV;

        @BindView(R.id.designation_TV)
        TextView designation_TV;

        @BindView(R.id.description_TV)
        TextView description_TV;

        @BindView(R.id.location_TV)
        TextView location_TV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
