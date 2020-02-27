package com.e.arunkumar_profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;

import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SNavigationDrawer Nvaigationdrawer;
    int color=0;
    Class fragmentclass;
    public static Fragment fragment;
    List<com.shrikanthravi.customnavigationdrawer2.data.MenuItem> drawerModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nvaigationdrawer=findViewById(R.id.navigationDrawer);

        drawerModelList=new ArrayList<>();

        Nvaigationdrawer.setAppbarTitleTV("Arunkumar");
        Nvaigationdrawer.setAppbarTitleTypeface(Typeface.create("font/banumas",Typeface.BOLD));

        drawerModelList.add(new MenuItem("Experience",R.drawable.ic_profile));
        drawerModelList.add(new MenuItem("Projects",R.drawable.ic_profile));
        drawerModelList.add(new MenuItem("Education",R.drawable.ic_profile));
        drawerModelList.add(new MenuItem("Skills",R.drawable.ic_profile));
        drawerModelList.add(new MenuItem("Profile",R.drawable.ic_profile));

        Nvaigationdrawer.setMenuItemList(drawerModelList);
        fragmentclass=MainScreen.class;

        try {
            fragment= (Fragment) fragmentclass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        if(fragment!=null){
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit();
        }

        Nvaigationdrawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {

            @Override
            public void onMenuItemClicked(int position) {

                Log.e("POS",""+position);


                switch (position){

                    case 0:
                        fragmentclass=MainScreen.class;
                        break;
                    case 1:
                        fragmentclass=ProjectsFragment.class;
                        break;
                    case 2:
                        fragmentclass=EducationFragment.class;
                        break;
                    case 3:
                        fragmentclass=SkillsFragment.class;
                        break;
                    case 4:
                        fragmentclass=ProfileFragment.class;
                        break;
                }
            }
        });

        Nvaigationdrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {
            @Override
            public void onDrawerOpening() {

            }

            @Override
            public void onDrawerClosing() {

                try {
                    fragment= (Fragment) fragmentclass.newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }

                if(fragment!=null){
                    FragmentManager fragmentManager=getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit();
                }

            }

            @Override
            public void onDrawerOpened() {

            }

            @Override
            public void onDrawerClosed() {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
