package com.e.arunkumar_profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.arunkumar_profile.adapter.Education_Adapter;
import com.e.arunkumar_profile.model.EducationModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EducationFragment extends Fragment {

    @BindView(R.id.edu_RV)
    RecyclerView edu_RV;

    ArrayList<EducationModel> data;
    Education_Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_education,container,false);
        ButterKnife.bind(this,view);
        educationdata();
        return view;
    }

    private void educationdata() {

        data=new ArrayList<EducationModel>();
        data.add(new EducationModel("Sri ramakrishna mission vidyalaya ","LMW,coimbatore","Aug'2011 - May'2014","Bsc (Cs)"));
        data.add(new EducationModel("Bharathiar university ","Coimbatore","Aug'2014 - May'2016","Mba General"));

        edu_RV.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter=new Education_Adapter(getActivity(),data);
        edu_RV.setAdapter(adapter);
    }
}
