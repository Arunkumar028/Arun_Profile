package com.e.arunkumar_profile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.e.arunkumar_profile.adapter.Skills_Adapter;
import com.e.arunkumar_profile.model.SkillModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SkillsFragment extends Fragment {

    @BindView(R.id.skill_RV)
    RecyclerView skill_RV;

    ArrayList<SkillModel> data;
    Skills_Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.activity_skills_fragment,container,false);
        ButterKnife.bind(this,view);

        skillsdata();

        return view;
    }

    private void skillsdata() {

        data=new ArrayList<SkillModel>();

        data.add(new SkillModel(R.drawable.android,"Android"));
        data.add(new SkillModel(R.drawable.gradle,"Gradle"));
        data.add(new SkillModel(R.drawable.sqlite,"Sqlite"));
        data.add(new SkillModel(R.drawable.kotlin,"Kotlin"));

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2,GridLayoutManager.HORIZONTAL,false);
        skill_RV.setLayoutManager(mLayoutManager);
        adapter=new Skills_Adapter(getActivity(),data);
        skill_RV.setAdapter(adapter);
    }
}
