package id.activity.cobatubes1;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class HotelActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView TextViewTiket;
    private SeekBar seekBar;
    private int min = 1, max = 10, current = 1;

    EditText namauser,cekin,cekot;
    RadioGroup radiojk;
    RadioButton jk;
    TextView jmlTiket, hoteluser;
    Spinner pilihHotel;

    Button buttonCheckin, buttomCheckout;
    TextView viewDate, viewDate2;
    Calendar calendarCheckin, calendarCheckout;
    DatePickerDialog dateCheckin,dateCheckout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        namauser = (EditText) findViewById(R.id.nama_pengguna);
        radiojk = (RadioGroup) findViewById(R.id.radiojk);
        jmlTiket= (TextView) findViewById(R.id.textViewTiket);
        cekin = (EditText) findViewById(R.id.masukkancekin);
        cekot = (EditText) findViewById(R.id.masukkancekout);
        viewDate = (TextView) findViewById(R.id.ViewDate);
        viewDate2 = (TextView) findViewById(R.id.ViewDate2);
        buttonCheckin = (Button) findViewById(R.id.btnCheckin);
        buttomCheckout = (Button) findViewById(R.id.btnCheckout);


        cekot.setInputType(InputType.TYPE_NULL);
        cekot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day =cldr.get(Calendar.DAY_OF_MONTH);
                int month=cldr.get(Calendar.MONTH);
                int year=cldr.get(Calendar.YEAR);

                dateCheckout = new DatePickerDialog(HotelActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        viewDate2.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                },year,month,day);
                dateCheckout.show();
            }
        });
        buttomCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDate2.setText(cekot.getText());
            }
        });
        cekin.setInputType(InputType.TYPE_NULL);
        cekin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            final Calendar cldr = Calendar.getInstance();
                int day =cldr.get(Calendar.DAY_OF_MONTH);
                int month=cldr.get(Calendar.MONTH);
                int year=cldr.get(Calendar.YEAR);

                dateCheckin = new DatePickerDialog(HotelActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        viewDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                },year,month,day);
                dateCheckin.show();
            }
        });
        buttonCheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDate.setText(cekin.getText());
            }
        });



        pilihHotel = (Spinner)findViewById(R.id.pilih_hotel);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.pilih_hotel, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pilihHotel.setAdapter(adapter);
        pilihHotel.setOnItemSelectedListener(this);
        hoteluser = (TextView) findViewById(R.id.hotel_user);



        TextViewTiket =(TextView) findViewById(R.id.textViewTiket);
        seekBar = (SeekBar) findViewById(R.id.seekBarTiket);
        seekBar.setMax(max-min);
        seekBar.setProgress(current-min);
        TextViewTiket.setText(""+current);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                current = progress + min;
                TextViewTiket.setText(""+current);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void kirimData(View view) {
        Intent intentKirimData = new Intent(HotelActivity.this,RiwayatActivity.class);
        intentKirimData.putExtra("nama", namauser.getText().toString());
        int radioId =radiojk.getCheckedRadioButtonId();
            jk = findViewById(radioId);
            intentKirimData.putExtra("jkelamin",jk.getText().toString());
        intentKirimData.putExtra("jmltiket", jmlTiket.getText().toString());
        intentKirimData.putExtra("hotel" , hoteluser.getText().toString());
        intentKirimData.putExtra("checkin" , viewDate.getText().toString());
        intentKirimData.putExtra("checkout" , viewDate2.getText().toString());
            Toast.makeText(this,"Berhasil Memesan Hotel", Toast.LENGTH_SHORT).show();
        startActivity(intentKirimData);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        hoteluser.setText(String.valueOf(text));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
