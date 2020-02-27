package com.e.arunkumar_profile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.e.arunkumar_profile.adapter.Experience_Adapter;
import com.e.arunkumar_profile.model.ExperienceModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainScreen extends Fragment {

    @BindView(R.id.contactno_TV)
    TextView contactno_TV;

    @BindView(R.id.mail_TV)
    TextView mail_TV;

    @BindView(R.id.experienceinfo_RL)
    RecyclerView experienceinfo_RL;

    ArrayList<ExperienceModel> data;
    Experience_Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_main_screen,container,false);
        ButterKnife.bind(this,view);

        experience_data();

        return view;
    }

    private void experience_data() {

        data=new ArrayList<ExperienceModel>();

        data.add(new ExperienceModel("KG Information Systems","Coimbatore,TamilNadu","DEC'2017 - Till Present","Android Application Developer",getString(R.string.desc_kg)));
        data.add(new ExperienceModel("Dayffofills Technology ","Coimbatore,TamilNadu","AUG'2016 - OCT'2017","Android Application Developer",getString(R.string.desc_indus)));
//        data.add(new ExperienceModel("Open Source Academy","Coimbatore,TamilNadu","Feb'2016 - Sep'2018","Android Application Developer",getString(R.string.osa)));

        experienceinfo_RL.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter=new Experience_Adapter(getActivity(),data);
        experienceinfo_RL.setAdapter(adapter);

    }

    @OnClick(R.id.contactno_TV)
    public void contactcall(View view){
        View view1 = getLayoutInflater().inflate(R.layout.include_call_msg, null);
        BottomSheetDialog dialog = new BottomSheetDialog(getActivity());
        ImageView callaction=view1.findViewById(R.id.call_action);
        ImageView msgaction=view1.findViewById(R.id.msg_action);
        ImageView whatsappaction=view1.findViewById(R.id.whatsappaction);
        callaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", contactno_TV.getText().toString(), null)));
            }
        });
        msgaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", contactno_TV.getText().toString());
                smsIntent.putExtra("sms_body","");
                startActivity(smsIntent);
            }
        });
        whatsappaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://api.whatsapp.com/send?phone="+contactno_TV.getText().toString();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        dialog.setContentView(view1);
        dialog.show();
    }

    @OnClick(R.id.mail_TV)
    public void sendmail(View view){
        String[] TO = {mail_TV.getText().toString()};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Reg - Aravindkumar Raj");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Something About Aravind");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            getActivity().finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(),"There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
