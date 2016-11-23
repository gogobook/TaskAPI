package com.example.lee.retrofittotask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    Button button;
    static TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        button = (Button)findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        String t1=editText1.getText().toString();
                        String t2=editText2.getText().toString();
                        try {
                            UpLoad.uploadData(t1, t2);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
//                        FileUploadManager.upload(imagePaths,task_name);
                    }
                }.start();

            }
        });
    }
}
