package com.e.arunkumar_profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProjectActivity extends AppCompatActivity {

    @BindView(R.id.backdrop_IV)
    ImageView backdrop_IV;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.description_TV)
    TextView description_TV;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.title_TV)
    TextView title_TV;
    @BindView(R.id.back_IV)
    ImageView back_IV;

    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        ButterKnife.bind(ProjectActivity.this);

        getWindow().setSharedElementEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.shared_transition));

        String name=getIntent().getStringExtra("name");
        String desc=getIntent().getStringExtra("desc");
         url=getIntent().getStringExtra("url");
        int image=getIntent().getIntExtra("image",0);
        Log.e("Pos",image+"");
            title_TV.setText(name);
            description_TV.setText(desc);
            backdrop_IV.setImageResource(image);
    }

    @OnClick(R.id.fab)
    void playstore(View view){
        Uri uri = Uri.parse(url); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    @OnClick(R.id.back_IV)
    void back(View view){
        onBackPressed();
    }
}
