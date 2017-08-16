package com.example.vivekchoudhary.shakeme;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private LinearLayout mRootLinearLayout;
    private LinearLayout linearLayout;
    boolean isClicked, isSecondClicked;
    boolean toggleflag;
    private TextView mAddField;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting root linear layout id
        mRootLinearLayout = (LinearLayout) findViewById(R.id.rootll);

        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        EditText mFirstField = new EditText(this);
        mAddField = new TextView(this);
        mAddField.setId(R.id.addbuttonone);
        mAddField.setText("+");
        mAddField.setTextSize(30f);
        mRootLinearLayout.addView(linearLayout, 0);
        linearLayout.addView(mFirstField, 800, 100);
        linearLayout.addView(mAddField);
        mAddField.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.addbuttonone:
                if (!isClicked) {
                    createNewField(R.id.linearlayouttwo, R.id.edittexttwo, R.id.addbuttontwo, 1);
                    toggleflag =false;
                    toggle(R.id.addbuttonone);
                } else {
                    removeAddedField(R.id.linearlayouttwo);
                    toggleflag = true;
                    toggle(R.id.addbuttonone);
                }
                isClicked = !isClicked;
                break;
            case R.id.addbuttontwo:
                if (!isSecondClicked) {
                   createNewField(R.id.linearlayoutthree, R.id.edittextthree, R.id.addbuttonthree, 2);
                    toggleflag = false;
                    toggle(R.id.addbuttontwo);
                } else {
                   removeAddedField(R.id.linearlayoutthree);
                    toggleflag = true;
                    toggle(R.id.addbuttontwo);

                }
                isSecondClicked = !isSecondClicked;
                break;

        }
        }

    private void createNewField(int linearLayoutid, int edittextid, int buttonid, int index) {
        EditText mNewField = new EditText(this);
        mNewField.setId(edittextid);

        TextView addButton = new TextView(this);
        addButton.setText("+");
        addButton.setTextSize(30f);
        addButton.setId(buttonid);
        addButton.setOnClickListener(this);

        LinearLayout newlinearlayout = new LinearLayout(this);
        newlinearlayout.setId(linearLayoutid);
        newlinearlayout.setOrientation(LinearLayout.HORIZONTAL);
        newlinearlayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        newlinearlayout.addView(mNewField,800,100);
        newlinearlayout.addView(addButton);

        mRootLinearLayout.addView(newlinearlayout,index);

    }


    private void removeAddedField(int layoutId) {
        LinearLayout layout = (LinearLayout) findViewById(layoutId);
        mRootLinearLayout.removeView(layout);
        Log.e(TAG,"Removed"+ layout.toString());
    }

    private void toggle(int layoutId) {
        TextView textView= (TextView) findViewById(layoutId);
        if(!toggleflag) {
            textView.setText("-");
        }else{
            textView.setText("+");
        }
        toggleflag = !toggleflag;

    }


}
