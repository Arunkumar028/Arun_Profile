package com.e.arunkumar_profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.e.arunkumar_profile.adapter.Projects_Adapter;
import com.e.arunkumar_profile.model.ProjectModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProjectsFragment extends Fragment {

    @BindView(R.id.projects_RV)
    RecyclerView projects_RV;

    private StaggeredGridLayoutManager _sGridLayoutManager;

    ArrayList<ProjectModel> data;
    Projects_Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_projects,container,false);
        ButterKnife.bind(this,view);

        projectdata();

        return view;
    }

    private void projectdata() {

        data=new ArrayList<ProjectModel>();

       // data.add(new ProjectModel("My Diet",R.drawable.logo,getString(R.string.mydiet),"https://play.google.com/store/apps/details?id=com.e.cafeteria"));
        data.add(new ProjectModel("Makkal Auto",R.drawable.makkalauto,getString(R.string.makkalauto),"https://play.google.com/store/apps/details?id=com.kgislgss.mtc&hl=en_IN"));
        data.add(new ProjectModel("Quick Taxi",R.drawable.quicklogo,getString(R.string.quicktaxi),"https://play.google.com/store/apps/details?id=com.kgislgss.quicktaxi&hl=en_IN"));
        data.add(new ProjectModel("Bulls Driver app ",R.drawable.app_bulls,getString(R.string.BullsDriver),"https://play.google.com/store/apps/details?id=com.autotaxi.driver"));
        data.add(new ProjectModel("SowmiyaTravels",R.drawable.sowmiya,getString(R.string.SowmiyaTravels),"https://play.google.com/store/apps/details?id=com.kgisl.sowmya"));
        data.add(new ProjectModel("My DIET",R.drawable.mydiet,getString(R.string.mydiet),"https://play.google.com/store/apps/details?id=com.e.cafeteria"));

        _sGridLayoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        projects_RV.setLayoutManager(_sGridLayoutManager);
        adapter=new Projects_Adapter(getActivity(),data);
        projects_RV.setAdapter(adapter);
    }

}
