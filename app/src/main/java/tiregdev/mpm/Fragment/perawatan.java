package tiregdev.mpm.Fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import tiregdev.mpm.Adapter.adapter_teknisi;
import tiregdev.mpm.Model.PerawatanUnit;
import tiregdev.mpm.Model.Teknisi;
import tiregdev.mpm.R;

/**
 * Created by Muhammad63 on 10/5/2017.
 */

public class perawatan extends Fragment implements View.OnClickListener {

    View v;
    TextView startPinjem, finishPinjam;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat getSdf;
    Calendar dateAndTime = Calendar.getInstance();
    Calendar dateAndTime2 = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener d =
            new DatePickerDialog.OnDateSetListener(){
                @Override
                public void onDateSet(DatePicker view, int year, int month,
                                      int day){
                    dateAndTime.set(Calendar.YEAR, year);
                    dateAndTime.set(Calendar.MONTH, month);
                    dateAndTime.set(Calendar.DAY_OF_MONTH, day);
                    updateLabel();
                }
            };

    DatePickerDialog.OnDateSetListener e =
            new DatePickerDialog.OnDateSetListener(){
                @Override
                public void onDateSet(DatePicker view, int year, int month,
                                      int day){
                    dateAndTime2.set(Calendar.YEAR, year);
                    dateAndTime2.set(Calendar.MONTH, month);
                    dateAndTime2.set(Calendar.DAY_OF_MONTH, day);
                    updateLabel2();
                }
            };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_perawatan, container, false);
        tgl();
        findViews();
        return v;
    }

    private void updateLabel(){
        startPinjem.setText(
                sdf.format(dateAndTime.getTime()));
    }

    private void updateLabel2() {
        finishPinjam.setText(
                sdf2.format(dateAndTime2.getTime()));
    }

    private void settingTanggal(){
        new DatePickerDialog(getActivity(), d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void settingTanggal2(){
        new DatePickerDialog(getActivity(), e,
                dateAndTime2.get(Calendar.YEAR),
                dateAndTime2.get(Calendar.MONTH),
                dateAndTime2.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void tgl(){
        startPinjem = v.findViewById(R.id.p8);
        startPinjem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settingTanggal();
            }
        });

        finishPinjam = v.findViewById(R.id.p9);
        finishPinjam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settingTanggal2();
            }
        });

    }

    private EditText p1;
    private EditText p2;
    private EditText p3;
    private EditText p4;
    private EditText p5;
    private EditText p6;
    private EditText p7;
    private TextView p8;
    private TextView p9;
    private Spinner p10;
    private Button daftarPart;
    private Button cekBiaya;
    private Button submit;
    private DatabaseReference mDatabase;
    private DatabaseReference mDataTeknisi;
    List<String> listTeknisi;
    List<String> listID;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-10-07 00:04:40 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        p1 = (EditText)v.findViewById( R.id.p1 );
        p2 = (EditText)v.findViewById( R.id.p2 );
        p3 = (EditText)v.findViewById( R.id.p3 );
        p4 = (EditText)v.findViewById( R.id.p4 );
        p5 = (EditText)v.findViewById( R.id.p5 );
        p6 = (EditText)v.findViewById( R.id.p6 );
        p7 = (EditText)v.findViewById( R.id.p7 );
        p8 = (TextView)v.findViewById( R.id.p8 );
        p9 = (TextView)v.findViewById( R.id.p9 );
        p10 = (Spinner) v.findViewById( R.id.p10 );
        daftarPart = (Button)v.findViewById( R.id.daftarPart );
        cekBiaya = (Button)v.findViewById( R.id.cekBiaya );
        submit = (Button)v.findViewById( R.id.submit );

        daftarPart.setOnClickListener( this );
        cekBiaya.setOnClickListener( this );
        submit.setOnClickListener( this );

        mDatabase = FirebaseDatabase.getInstance().getReference();
        getSdf = new SimpleDateFormat("dd/MM/yyyy h:mm:ss a");


        mDataTeknisi = FirebaseDatabase.getInstance().getReference("daftarTeknisi");
        mDataTeknisi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                listTeknisi = new ArrayList<String>();
                listID = new ArrayList<String>();

                for (DataSnapshot areaSnapshot: dataSnapshot.getChildren()) {
                    String namaTeknisi = areaSnapshot.child("nama").getValue(String.class);
                    String idTeknisi = areaSnapshot.getKey();
                    listTeknisi.add(namaTeknisi);
                    listID.add(idTeknisi);
                }
                ArrayAdapter<String> areasAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, listTeknisi);
                areasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                p10.setAdapter(areasAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
// Failed to read value
                Log.w("Hello", "Failed to read value.", databaseError.toException());
            }
        });
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-10-07 00:04:40 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == daftarPart ) {
            // Handle clicks for daftarPart
            Toast.makeText(getContext(), "beloman!", Toast.LENGTH_SHORT).show();
        } else if ( v == cekBiaya ) {
            // Handle clicks for cekBiaya
            Toast.makeText(getContext(), "beloman! juga", Toast.LENGTH_SHORT).show();
        } else if ( v == submit ) {
            // Handle clicks for submit
            sendData();
        }

    }
    private void sendData(){
        String nama = p1.getText().toString().trim();
        String alamat = p2.getText().toString().trim();
        String email = p3.getText().toString().trim();
        String telepon = p4.getText().toString().trim();
        String jenisUnit = p5.getText().toString().trim();
        String serialNumber = p6.getText().toString().trim();
        String jamKerja = p7.getText().toString().trim();
        String startBooking = p8.getText().toString().trim();
        String finishBooking = p9.getText().toString().trim();
        String idTeknisi = listID.get(p10.getSelectedItemPosition());
        String tglSubmit = getSdf.format(Calendar.getInstance().getTime().getTime());
        String status = "Clear";

        PerawatanUnit setPU = new PerawatanUnit(nama, alamat, email, telepon, jenisUnit, serialNumber,
                jamKerja, startBooking, finishBooking, idTeknisi, tglSubmit, status);

        mDatabase.child("perawatanUnit").push().setValue(setPU);
        Toast.makeText(getContext(), "Data berhasil dikirim!", Toast.LENGTH_SHORT).show();
    }


}
