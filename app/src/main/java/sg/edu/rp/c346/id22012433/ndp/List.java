package sg.edu.rp.c346.id22012433.ndp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;

public class List extends AppCompatActivity {
    ListView lvsongs;
    Button btnf,btnback;
    ArrayList<Song> alSong;
    Spinner spnSongs;
    CustomAdapter ca,ca2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lvsongs=findViewById(R.id.lv);
        btnf=findViewById(R.id.btnfilter);
        btnback=findViewById(R.id.btnback);
        spnSongs=findViewById(R.id.spinnerYear);



        DBHelper DBH=new DBHelper(List.this);
        alSong=DBH.getSongs();
        ca = new CustomAdapter(this, R.layout.row, alSong);
        lvsongs.setAdapter(ca);
        lvsongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song dsong = alSong.get(position);
                Intent i = new Intent(List.this,
                        Edit.class);
                i.putExtra("song", dsong);
                startActivity(i);
            }
        });
        btnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(List.this);
                ArrayList<Song> fiveS=new ArrayList<>();
                for (Song song: alSong) {
                    if(song.getStars()==5){
                        fiveS.add(song);

                    }
                    ca2 =new CustomAdapter(List.this, R.layout.row, fiveS);
                    lvsongs.setAdapter(ca2);
                }

            }
        });



        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(List.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
