package com.example.ramdom25022020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText mEdtSomin, mEdtSomax;
    Button mBtnRandom;
    TextView mTvKetqua;
    int mSmin, mSmax, mValue;
    Random mRandom;
    String mTextMin, mTextMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdtSomin = findViewById(R.id.edtSomin);
        mEdtSomax = findViewById(R.id.edtSomax);
        mBtnRandom = findViewById(R.id.btnRandom);
        mTvKetqua = findViewById(R.id.tvtKetqua);
        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextMin = mEdtSomin.getText().toString();
                mTextMax = mEdtSomax.getText().toString();
                if (mTextMin.equals("") || mTextMax.equals("")) {
                    Toast.makeText(MainActivity.this, "bạn nhập thiếu thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                mSmin = Integer.parseInt(mTextMin);
                mSmax = Integer.parseInt(mTextMax);
                if (mSmax < mSmin) {
                    mSmax = mSmin + 1;
                }
                mEdtSomax.setText(String.valueOf(mSmax));
                mRandom = new Random();
                mValue = mRandom.nextInt(mSmax - mSmin + 1) + mSmin;
                //mTvKetqua.setText(String.valueOf(mValue));
                mTvKetqua.append(mValue +"-");

            }
        });

    }
}
