package com.example.colorpicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import yuku.ambilwarna.AmbilWarnaDialog;

public class MainActivity extends AppCompatActivity {

    int DefaultColor;
    Button button;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         button=findViewById(R.id.btn);
         relativeLayout=findViewById(R.id.relative_layout);
         DefaultColor= ContextCompat.getColor(MainActivity.this,R.color.colorPrimaryDark);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    public void openDialog()
    {
      AmbilWarnaDialog dialog=new AmbilWarnaDialog(this, DefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
          @Override
          public void onCancel(AmbilWarnaDialog dialog) {

          }

          @Override
          public void onOk(AmbilWarnaDialog dialog, int color) {
            DefaultColor=color;
            relativeLayout.setBackgroundColor(DefaultColor);
          }
      });
        dialog.show();


    }
}
