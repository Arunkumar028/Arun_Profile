package com.e.arunkumar_profile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileFragment extends Fragment {

    @BindView(R.id.address_LL)
    LinearLayout address_LL;
    @BindView(R.id.contactnoLL)
    LinearLayout contactnoLL;
    @BindView(R.id.contactno_TV)
    TextView contactno_TV;
    @BindView(R.id.mailLL)
    LinearLayout mailLL;
    @BindView(R.id.mail_TV)
    TextView mail_TV;
    @BindView(R.id.resume)
    LinearLayout resume;
    private Object URL;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profile,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.address_LL)
    void showmap(View view){
        //10.919652, 77.489925
        Double myLatitude = 11.0573972;
        Double myLongitude = 76.9278551;
        String labelLocation = "Arunkumar";

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<" + myLatitude  + ">,<" + myLongitude + ">?q=<" + myLatitude  + ">,<" + myLongitude + ">(" + labelLocation + ")"));
        startActivity(intent);
    }
    @OnClick(R.id.contactnoLL)
    void call(View view){

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

       //
    }
    @OnClick(R.id.mailLL)
    void mail(View view){
        String[] TO = {mail_TV.getText().toString()};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Reg - Arunkumar");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Something About Arunkumar");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            getActivity().finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(),"There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
    @OnClick(R.id.resume)
        void resume(View v){
        try
        {
            URL url = new URL((String) URL);
            HttpURLConnection c = (HttpURLConnection) url.openConnection();
            c.setRequestMethod("GET");
            c.setDoOutput(true);
            c.connect();

            String PATH = Environment.getExternalStorageDirectory().toString()
                    + "/load";
            Log.v("LOG_TAG", "PATH: " + PATH);

            File file = new File(PATH);
            file.mkdirs();
            Byte[] option14 = new Byte[0];
            int i = 0;
            File outputFile;
            outputFile = new File(file, option14[i].toString());
            FileOutputStream fos = new FileOutputStream(outputFile);
            InputStream is = c.getInputStream();

            byte[] buffer = new byte[4096];
            int len1 = 0;

            while ((len1 = is.read(buffer)) != -1)
            {
                fos.write(buffer, 0, len1);
            }

            fos.close();
            is.close();

            Toast.makeText(getActivity(), " A new file is downloaded successfully",Toast.LENGTH_LONG).show();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



//            Intent intent=new Intent(getActivity(),TestActivity.class);
//            startActivity(intent);

    }
}
