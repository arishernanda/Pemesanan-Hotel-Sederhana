package id.activity.cobatubes1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class CariHotelActivity extends AppCompatActivity {
    private EditText lokasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_hotel);
        lokasi = (EditText)findViewById(R.id.lokasi);
    }

    public void lokasi(View view){String lok = lokasi.getText().toString();
        Uri lokUri = Uri.parse("geo:0,0?q=" + lok);
        Intent lokIntent = new  Intent(Intent.ACTION_VIEW, lokUri);
        if (lokIntent.resolveActivity(getPackageManager()) !=null){
            startActivity(lokIntent);
        }else {
            Log.d("Implicit Intens","Perintah Tidak bisa di lakukan");
        }

    }
}

