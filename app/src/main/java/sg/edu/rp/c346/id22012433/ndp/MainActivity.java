package sg.edu.rp.c346.id22012433.ndp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnIn,btnSl;
    RadioGroup RG;
    RadioButton RB1,RB2,RB3,RB4,RB5;
    EditText etSongTitle, etSinger, etYear;
    int stars=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIn=findViewById(R.id.btninsert);
        btnSl=findViewById(R.id.btnshowlist);
        etSongTitle=findViewById(R.id.etSongTitle);
        etSinger=findViewById(R.id.etSingers);
        etYear=findViewById(R.id.etYear);
        RG=findViewById(R.id.radioGroup);
        RB1=findViewById(R.id.radioButton1);
        RB2=findViewById(R.id.radioButton2);
        RB3=findViewById(R.id.radioButton3);
        RB4=findViewById(R.id.radioButton4);
        RB5=findViewById(R.id.radioButton5);
        btnIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);
                String songtitle=etSongTitle.getText().toString();
                String singers=etSinger.getText().toString();
                int year=Integer.parseInt(etYear.getText().toString());
                if(RB1.isChecked()){
                    stars=1;
                } else if (RB2.isChecked()) {
                    stars=2;
                }else if (RB3.isChecked()) {
                    stars=3;
                }else if (RB4.isChecked()) {
                    stars=4;
                }else if (RB5.isChecked()) {
                    stars=5;
                }
                db.insertSong(songtitle,singers,year,stars);
                Toast.makeText(MainActivity.this,"Song Added",Toast.LENGTH_SHORT).show();
            }
        });
        btnSl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, List.class);
                startActivity(intent);
            }
        });

    }
}