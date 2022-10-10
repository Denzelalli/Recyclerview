package id.ac.ub.papb.recycler1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView tvNim2,tvNama2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        tvNim2 = findViewById(R.id.tvNim2);
        tvNama2 = findViewById(R.id.tvNama2);


        Bundle b1 =  getIntent().getExtras();
        String s1 = b1.getString ("NIM");
        String s2 = b1.getString ("Nama");

        tvNim2.setText("NIM : "+s1);
        tvNama2.setText("Nama : "+s2);




    }
}