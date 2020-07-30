package com.example.quizapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapplication.ModelClass.QuestionClass;
import com.example.quizapplication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //set controls
    TextView tvQueConter, tvTimer, tvQue;
    Button btopt1,btopt2,btopt3,btopt4;

    //list for que
    ArrayList<QuestionClass> queList = new ArrayList<>();
    private int conter;

    CountDownTimer tm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find view by id
        tvQue = findViewById(R.id.tvQue);
        tvQueConter = findViewById(R.id.tvQueConter);
        tvTimer = findViewById(R.id.tvTimer);

        btopt1 = findViewById(R.id.btopt1);
        btopt2 = findViewById(R.id.btopt2);
        btopt3 = findViewById(R.id.btopt3);
        btopt4 = findViewById(R.id.btopt4);

        //load data
        queList.add(new QuestionClass("This is dummy que 1", "ans 1", "ans 2", "ans 3", "ans 4", "ans 1"));
        queList.add(new QuestionClass("This is dummy que 2", "ans 1", "ans 2", "ans 3", "ans 4", "ans 2"));
        queList.add(new QuestionClass("This is dummy que 3", "ans 1", "ans 2", "ans 3", "ans 4", "ans 3"));

        //init conter;
         conter = 0;
        //load ques and ans
        loadQuestions(conter);

        //countdown time
        tm = new CountDownTimer(12 * 1000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Quiz Over", Toast.LENGTH_SHORT).show();
            }
        };
    }


        public void loadQuestions(int n) {

            final QuestionClass q = queList.get(n);

            tvQueConter.setText((n+1) + "/" + queList.size());

            tvTimer.setText("" + 12);

            if(tm != null){
                tm.start();
            }

            tvQue.setText("#" + (n + 1) + " " + q.getQue());
            btopt1.setText("" + q.getOpt1());
            btopt2.setText("" + q.getOpt2());
            btopt3.setText("" + q.getOpt3());
            btopt4.setText("" + q.getOpt4());

            //btn1
            btopt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(btopt1.getText().equals(q.getRightopt())){
                        Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                    if (conter < (queList.size() - 1)){
                        tm.cancel();
                        conter++;
                        loadQuestions(conter);
                    }else{
                      Toast.makeText(MainActivity.this, "All Question Completed", Toast.LENGTH_SHORT).show();
                    }
                    }else{
                        Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            //btn2
            btopt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(btopt2.getText().equals(q.getRightopt())){
                        Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                        if (conter < (queList.size() - 1)){
                            tm.cancel();
                            conter++;
                            loadQuestions(conter);
                        }else{
                            Toast.makeText(MainActivity.this, "All Question Completed", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            //btn3
            btopt3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(btopt3.getText().equals(q.getRightopt())){
                        Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                        if (conter < (queList.size() - 1)){
                            tm.cancel();
                            conter++;
                            loadQuestions(conter);
                        }else{
                            Toast.makeText(MainActivity.this, "All Question Completed", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            //btn4
            btopt4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(btopt4.getText().equals(q.getRightopt())){
                        Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                        if (conter < (queList.size() - 1)){
                            tm.cancel();
                            conter++;
                            loadQuestions(conter);
                        }else{
                            Toast.makeText(MainActivity.this, "All Question Completed", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    }
                }
            });




        }
}
