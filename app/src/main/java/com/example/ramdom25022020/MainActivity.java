package com.example.ramdom25022020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText mEdtSomin, mEdtSomax;
    Button mBtnRandom, mBtnAddBound,mBtnReset;
    TextView mTvKetqua;
    int mSmin, mSmax, mValue;
    Random mRandom;
    String mTextMin, mTextMax;
    ArrayList<Integer> mArrayNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdtSomin = findViewById(R.id.edtSomin);
        mEdtSomax = findViewById(R.id.edtSomax);
        mBtnRandom = findViewById(R.id.btnRandom);
        mTvKetqua = findViewById(R.id.tvtKetqua);
        mBtnAddBound = findViewById(R.id.btnAddBound);
        mBtnReset = findViewById(R.id.btnReset);
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mArrayNumbers.clear();
                mEdtSomin.setEnabled(true);
                mEdtSomax.setEnabled(true);
                mBtnAddBound.setEnabled(true);
                mEdtSomax.setText("");
                mEdtSomin.setText("");
                mTvKetqua.setText("");

            }
        });

        mBtnAddBound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextMin = mEdtSomin.getText().toString();
                mTextMax = mEdtSomax.getText().toString();

                if (mTextMin.equals("") || mTextMin.equals("")) {
                    Toast.makeText(MainActivity.this, "nhập thiếu thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                mSmin = Integer.parseInt(mTextMin);
                mSmax = Integer.parseInt(mTextMax);
                if (mSmax <= mSmin) {
                    mSmax = mSmin + 1;
                    mEdtSomax.setText(String.valueOf(mSmax));
                }

                mArrayNumbers = new ArrayList<>();
                for (int i = mSmin; i <= mSmax; i++) {
                    mArrayNumbers.add(i);
                }
                mBtnAddBound.setEnabled(false);
                mEdtSomin.setEnabled(false);
                mEdtSomax.setEnabled(false);
                Toast.makeText(MainActivity.this,"thêm số thành công",Toast.LENGTH_SHORT).show();
            }
        });
        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mArrayNumbers.size() !=0){
                    mRandom = new Random();
                    int index = mRandom.nextInt(mArrayNumbers.size());
                    mValue = mArrayNumbers.get(index);
                    mTvKetqua.append(mValue + "-");
                    mArrayNumbers.remove(index);
                }else {

                    Toast.makeText(MainActivity.this,"hết số để lựa chọn",Toast.LENGTH_SHORT).show();
                    //mBtnRandom.setEnabled(false);

                }


            }
        });

    }
}
