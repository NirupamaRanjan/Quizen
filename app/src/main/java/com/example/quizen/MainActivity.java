package com.example.quizen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private TextView mTxtQuestion;
    private Button buttonTrue;
    private  Button buttonFalse;
    private TextView txtScore;
    private ProgressBar PB;

    private int mIndx;
    private int mQuestion;
    int mscore;
    private int diff;
    MyQues questionCollection[]=new MyQues[]{
            new MyQues(R.string.q1,false),
            new MyQues(R.string.q2,false),
            new MyQues(R.string.q3,true),
            new MyQues(R.string.q4,true),
            new MyQues(R.string.q5,false),
            new MyQues(R.string.q6,true),
            new MyQues(R.string.q7,true),
            new MyQues(R.string.q8,true),
            new MyQues(R.string.q9,true),
            new MyQues(R.string.q10,false)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIndx=0;
        mscore=0;
        mTxtQuestion=findViewById(R.id.Question);
        mTxtQuestion.setText(questionCollection[mIndx].getQuestion());
        txtScore=findViewById(R.id.score);
        txtScore.setText(0+"");
       buttonFalse=findViewById(R.id.buttonF);
       PB=findViewById(R.id.progress);


       buttonFalse.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               evaluateAnswer(false);
               changemIndx();
           }
       });

         buttonTrue=findViewById(R.id.buttonT);
         buttonTrue.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 evaluateAnswer(true);
                 changemIndx();
             }
         });
        }

        public  void  changemIndx(){
              mIndx=(mIndx+1)%10;
              mTxtQuestion.setText(questionCollection[mIndx].getQuestion());
              PB.incrementProgressBy(10);

        }


        public void evaluateAnswer(boolean ans){
            if(ans==questionCollection[mIndx].isAns()){
                Toast.makeText(this,"Great!",Toast.LENGTH_SHORT).show();
                mscore+=1;
            }else{
                Toast.makeText(this,"Wrong!",Toast.LENGTH_SHORT).show();
            }
            txtScore.setText(mscore+"");
        }



    }

