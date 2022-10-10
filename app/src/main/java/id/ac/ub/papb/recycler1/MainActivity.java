package id.ac.ub.papb.recycler1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv1;
    public static String TAG = "RV1";
    EditText etNim,etName;
    Button bt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNim= findViewById(R.id.etNim);
        etName = findViewById(R.id.etName);
        bt1 = findViewById(R.id.bt1);
        rv1 = findViewById(R.id.rv1);
        ArrayList<Mahasiswa> data = getData();
        MahasiswaAdapter adapter = new MahasiswaAdapter(this, data);
        rv1.setAdapter(adapter);
        rv1.setLayoutManager(new LinearLayoutManager(this));
        bt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String strNim,strName;
                strName = etName.getText().toString();
                strNim = etNim.getText().toString();
                if(strNim.length()==0){
                    etNim.setError("Please Enter Your NIM");}
                if(strName.length()==0){
                    etName.setError("Please Enter Your Name");
                }else if(strNim.length()!=0&&strName.length()!=0){
                    Mahasiswa mhs = new Mahasiswa();
                    mhs.nim = strNim;
                    mhs.nama = strName;
                    data.add(mhs);
                    Toast.makeText(getApplicationContext(), "Data berhasil ditambahkan",Toast.LENGTH_LONG).show();
                }

            }
        });
    }



    public ArrayList getData() {
        ArrayList<Mahasiswa> data = new ArrayList<>();
        List<String> nim = Arrays.asList(getResources().getStringArray(R.array.nim));
        List<String> nama = Arrays.asList(getResources().getStringArray(R.array.nama));
        for (int i = 0; i < nim.size(); i++) {
            Mahasiswa mhs = new Mahasiswa();
            mhs.nim = nim.get(i);
            mhs.nama = nama.get(i);
            Log.d(TAG,"getData "+mhs.nim);
            data.add(mhs);
        }
        return data;
    }
}