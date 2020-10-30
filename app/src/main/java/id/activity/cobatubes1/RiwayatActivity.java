package id.activity.cobatubes1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RiwayatActivity extends AppCompatActivity {
    TextView txt1,txt2,txt3,txt4,txt5,txt6;
    Button buttonSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat);
        txt1 = (TextView) findViewById(R.id.showNama);
        txt2 = (TextView) findViewById(R.id.showJK);
        txt3 = (TextView) findViewById(R.id.showTiket);
        txt4 = (TextView) findViewById(R.id.showHotel);
        txt5 = (TextView) findViewById(R.id.showCheckin);
        txt6 = (TextView) findViewById(R.id.showCheckout);
        buttonSimpan = (Button) findViewById(R.id.tombolSimpan);
        buttonSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        String st1 = getIntent().getStringExtra("nama");
        txt1.setText("Nama Lengkap  : " + st1);

        String st2 = getIntent().getStringExtra("jkelamin");
        txt2.setText("Jenis kelamin : " + st2);

        String st3 = getIntent().getStringExtra("jmltiket");
        txt3.setText("Jumlah Tiket  : " + st3 );

        String st4 = getIntent().getStringExtra("hotel");
        txt4.setText("Pilihan hotel : " + st4);

        String st5 = getIntent().getStringExtra("checkin");
        txt5.setText("Check-In       : " + st5);

        String st6 = getIntent().getStringExtra("checkout");
        txt6.setText("Check-out     : " + st6);

    }
    private void showDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("SIMPAN DATA");

        alertDialogBuilder
                .setMessage("Apakah anda akan menyimpan?")
                .setPositiveButton("YA", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Data Berhasil Disimpan",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("SKIP", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Pilihan SKIP sudah diklik",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Data tidak disimpan",Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
