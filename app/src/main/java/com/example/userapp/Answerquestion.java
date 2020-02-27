package com.example.userapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Answerquestion extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;
    TextView title;  //제목
    TextView writer;  //작성자
    TextView contents;   //내용
    String existingtitle;    // 기존제목
    String existingwriter;   //기존작성자
    String existingcontents; //기존내용
    EditText answercontents;
    String answercontentsvalue;
    Button answerbtn; //답변하기버튼
    Button confirmbtn ; //확인버튼
    String existinganswercontents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answerquestion);



        answerbtn=(Button)findViewById(R.id.answerbtn);
        confirmbtn=(Button)findViewById(R.id.confirmbtn);
        title = (TextView) findViewById(R.id.title1);
        writer = (TextView) findViewById(R.id.writer);
        answercontents = (EditText) findViewById(R.id.answercontents);
        contents = (TextView) findViewById(R.id.contents);


        database=  FirebaseDatabase.getInstance(); // Firebase database 연동
        reference =database.getReference("users");// DB 테이블 연결

        Bundle extras = getIntent().getExtras(); //QuestionList에서 받아온 정보를 가져옴
        if(extras != null){
            existingtitle = extras.getString("title");  //기존에 저장되어있던 제목 가져옴
            existingwriter = extras.getString("writer"); //기존에 저장되어있던 작성자 가져옴
            existingcontents = extras.getString("contents"); //기존에 저장되어있던 내용 가져옴
             existinganswercontents= extras.getString("answercontents"); //새로받아온 답변내용;


            title.setText(existingtitle);
            writer.setText(existingwriter);
            contents.setText(existingcontents);

            answercontents.setText(existinganswercontents);

        }

        answerbtn.setOnClickListener(new View.OnClickListener() { //답변하기 버튼 클릭 시
            @Override
            public void onClick(View v) {
                answercontentsvalue = answercontents.getText().toString(); //적은 답변내용 가져오기
                Intent intent = new Intent();

                intent.putExtra("answercontents",answercontentsvalue); //답변한 내용을 intent를사용하여 보냄
                setResult(RESULT_OK,intent);
                finish();

            }
        });

        confirmbtn.setOnClickListener(new View.OnClickListener() { //확인버튼 클릭 시
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }
}
