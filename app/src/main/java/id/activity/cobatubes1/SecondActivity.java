package id.activity.cobatubes1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void kirimCariHotel(View view){
        Intent intentRiwayat = new Intent(SecondActivity.this, CariHotelActivity.class);
            Toast.makeText(this,"Berhasil Memilih Menu", Toast.LENGTH_SHORT).show();
        startActivity(intentRiwayat);
    }
    public void kirimHotel(View view){
        Intent intentHotel = new Intent(SecondActivity.this, HotelActivity.class);
            Toast.makeText(this,"Berhasil memilih Menu", Toast.LENGTH_SHORT).show();
        startActivity(intentHotel);
    }

    public void tombolKembali(View view){
        Intent intentKembali = new Intent(SecondActivity.this, MainActivity.class);
             Toast.makeText(this,"Berhasil Keluar", Toast.LENGTH_SHORT).show();
        startActivity(intentKembali);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.pilihan1:
                Toast.makeText(this,"Jika ada pertanyaan silahkan hubungi sprari26@gmail.com untuk info lebih lanjut", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.pilihan2:
                Toast.makeText(this,"Aplikasi ini merupakan Tugas Akhir dari Matakuliah Pemrograman Mobile", Toast.LENGTH_SHORT).show();
                return true;

            default:
        return super.onOptionsItemSelected(item);
        }
    }

    public void kirimInfo(View view) {
        Intent intentInfo = new Intent(SecondActivity.this, InfoActivity.class);
            Toast.makeText(this,"Berhasil memilih Menu", Toast.LENGTH_SHORT).show();
        startActivity(intentInfo);
    }
}
