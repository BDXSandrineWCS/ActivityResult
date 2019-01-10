package com.wcs.activityresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE= 876;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.button_to_tab_activity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TabActivity.class);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK){
                int result = data.getIntExtra(TabActivity.getTabExtraKey(), 0);
                TextView textView= findViewById(R.id.textView_main);
                textView.setText(getString(R.string.sending_tab_text, result));
            }
        }
    }

    public static int getRequestCode() {
        return REQUEST_CODE;
    }
}
