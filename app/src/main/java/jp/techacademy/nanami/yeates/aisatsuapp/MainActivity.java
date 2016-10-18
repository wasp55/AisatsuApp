package jp.techacademy.nanami.yeates.aisatsuapp;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

 public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mGreeting;
    private Button mPickTime;

    static final int TIME_DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGreeting = (TextView) findViewById(R.id.greeting);

        mPickTime = (Button) findViewById(R.id.button1);
        mPickTime.setOnClickListener(this);
    }
            @Override
            public void onClick(View v){
                Log.d("UI_PARTS", "ボタンをタップしました");
                showTimePickerDialog();

    }

            private void showTimePickerDialog() {
                TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute){

                                int time = hourOfDay;
                                if ((time >=2) && (time <= 10)) {
                                    mGreeting.setText("おはよう");
                                }else if((time >=10) && (time <= 18)) {
                                    mGreeting.setText("こんにちは");
                                }else if((time >=18)|| (time <= 2)) {
                                    mGreeting.setText("こんばんわ");
                                }

                            }
                        },
                        0,// 初期値（時間）
                        0,  // 初期値（分）
                        true);
                timePickerDialog.show();
            }
        }

