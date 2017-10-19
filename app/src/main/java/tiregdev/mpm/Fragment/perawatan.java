package tiregdev.mpm.Fragment;

import android.app.DatePickerDialog;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
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

import tiregdev.mpm.Model.PerawatanUnit;
import tiregdev.mpm.R;

/**
 * Created by Muhammad63 on 10/5/2017.
 */

public class perawatan extends Fragment implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    View v;
    TextView startPinjem, finishPinjam;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat getSdf;
    Calendar dateAndTime = Calendar.getInstance();
    Calendar dateAndTime2 = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener d =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month,
                                      int day) {
                    dateAndTime.set(Calendar.YEAR, year);
                    dateAndTime.set(Calendar.MONTH, month);
                    dateAndTime.set(Calendar.DAY_OF_MONTH, day);
                    updateLabel();
                }
            };

    DatePickerDialog.OnDateSetListener e =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month,
                                      int day) {
                    dateAndTime2.set(Calendar.YEAR, year);
                    dateAndTime2.set(Calendar.MONTH, month);
                    dateAndTime2.set(Calendar.DAY_OF_MONTH, day);
                    updateLabel2();
                }
            };
    Button cekPart;
    EditText oil, oilFilter;
    TextView totalPart, totalBiaya1, totalBiaya2;
    int totalOil = 0;
    int setTotal = 0;
    int totalOilFilter = 0;
    int totalDialog = 0;
    int teknisi = 2000000;
    int transportasi = 700000;
    int total = 0;
    String jumlahOil, jumlahOilFilter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_perawatan, container, false);
        tgl();
        setTotalBiaya();
        setDaftarPart();

        findViews();
        return v;
    }

    private void setDaftarPart() {
        cekPart = v.findViewById(R.id.daftarPart);
        cekPart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater factory = LayoutInflater.from(getActivity());
                View exitDialogView = factory.inflate(R.layout.dialog_daftar_part, null);
                final AlertDialog exitDialog = new AlertDialog.Builder(getActivity()).create();
                oil = exitDialogView.findViewById(R.id.oil);
                oilFilter = exitDialogView.findViewById(R.id.oilFilter);
                exitDialog.setView(exitDialogView);
                exitDialogView.findViewById(R.id.btnDone).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        totalOilFilter = 400000 * Integer.valueOf(oilFilter.getText().toString().trim());
                        totalOil = 500000 * Integer.valueOf(oil.getText().toString().trim());
                        jumlahOil = oil.getText().toString().trim();
                        jumlahOilFilter = oilFilter.getText().toString().trim();
                        setTextCekPart();
                        setTextBiaya();
                        exitDialog.hide();
                    }
                });
                exitDialog.show();
            }
        });
    }

    private void setTotalBiaya() {
        final Button totalBiaya = v.findViewById(R.id.biaya);
        totalBiaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final LayoutInflater factory = LayoutInflater.from(getActivity());
                final View exitDialogView = factory.inflate(R.layout.dialog_total_biaya, null);
                totalBiaya1 = exitDialogView.findViewById(R.id.total);
                TextView sukuCadang = exitDialogView.findViewById(R.id.sukuCadang);
                totalBiaya1.setText(String.valueOf(total));
                sukuCadang.setText(String.valueOf(setTotal));
                final AlertDialog exitDialog = new AlertDialog.Builder(getActivity()).create();
                exitDialog.setView(exitDialogView);
                exitDialogView.findViewById(R.id.btnClose).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        exitDialog.hide();
                    }
                });
                exitDialog.show();
            }
        });
    }

    private void setTextCekPart(){
        totalPart = v.findViewById(R.id.p11);
        setTotal = totalOil + totalOilFilter;
        String setTextTotal = setTotal+" IDR";
        totalPart.setText(setTextTotal);
    }

    private void setTextBiaya(){
        totalBiaya2 = v.findViewById(R.id.p12);
        total = teknisi+transportasi+setTotal;
        String totalText = total+" IDR";
        totalBiaya2.setText(totalText);
    }

    private void updateLabel() {
        startPinjem.setText(
                sdf.format(dateAndTime.getTime()));
    }

    private void updateLabel2() {
        finishPinjam.setText(
                sdf2.format(dateAndTime2.getTime()));
    }

    private void settingTanggal() {
        new DatePickerDialog(getActivity(), d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void settingTanggal2() {
        new DatePickerDialog(getActivity(), e,
                dateAndTime2.get(Calendar.YEAR),
                dateAndTime2.get(Calendar.MONTH),
                dateAndTime2.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void tgl() {
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
    private TextView p10;
    private Button submit;
    private DatabaseReference mDatabase;
    private DatabaseReference mDataTeknisi;
    private DatabaseReference mDataPerawatan;
    List<String> listTeknisi;
    List<String> listID;
    List<String> countID;
    ProgressBar progressBar;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-10-07 00:04:40 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        p1 = (EditText) v.findViewById(R.id.p1);
        p2 = (EditText) v.findViewById(R.id.p2);
        p3 = (EditText) v.findViewById(R.id.p3);
        p4 = (EditText) v.findViewById(R.id.p4);
        p5 = (EditText) v.findViewById(R.id.p5);
        p6 = (EditText) v.findViewById(R.id.p6);
        p7 = (EditText) v.findViewById(R.id.p7);
        p8 = (TextView) v.findViewById(R.id.p8);
        p9 = (TextView) v.findViewById(R.id.p9);
        p10 = (TextView) v.findViewById(R.id.p10);
        progressBar = (ProgressBar) v.findViewById(R.id.progressBar2);
        submit = (Button) v.findViewById(R.id.submit);

        submit.setOnClickListener(this);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        getSdf = new SimpleDateFormat("dd/MM/yyyy h:mm:ss a");


        mDataTeknisi = FirebaseDatabase.getInstance().getReference("daftarTeknisi");
        mDataTeknisi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressBar.setVisibility(View.VISIBLE);
                listTeknisi = new ArrayList<String>();
                listID = new ArrayList<String>();

                for (DataSnapshot areaSnapshot : dataSnapshot.getChildren()) {
                    String namaTeknisi = areaSnapshot.child("nama").getValue(String.class);
                    String idTeknisi = areaSnapshot.getKey();
                    listTeknisi.add(namaTeknisi);
                    listID.add(idTeknisi);
                }
                p10.setText(String.valueOf(listTeknisi.size()));
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
// Failed to read value
                Log.w("Hello", "Failed to read value.", databaseError.toException());
            }
        });

        mDataPerawatan = FirebaseDatabase.getInstance().getReference("perawatanUnit");
        mDataPerawatan.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                progressBar.setVisibility(View.VISIBLE);
                countID = new ArrayList<String>();

                for (DataSnapshot areaSnapshot : dataSnapshot.getChildren()) {
                    String key = areaSnapshot.getKey();
                    countID.add(key);


                }
                progressBar.setVisibility(View.GONE);
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
        if (v == submit) {
            // Handle clicks for submit
            sendData();
        }

    }

    private void sendData() {
        String nama = p1.getText().toString().trim();
        String alamat = p2.getText().toString().trim();
        String email = p3.getText().toString().trim();
        String telepon = p4.getText().toString().trim();
        String jenisUnit = p5.getText().toString().trim();
        String serialNumber = p6.getText().toString().trim();
        String jamKerja = p7.getText().toString().trim();
        String startBooking = p8.getText().toString().trim();
        String finishBooking = p9.getText().toString().trim();
        String noOrder = String.format("%06d", countID.size() + 1);
        String totalBiaya = totalBiaya2.getText().toString().trim();
        String totalBiayaPart = totalPart.getText().toString().trim();
        String tglSubmit = getSdf.format(Calendar.getInstance().getTime().getTime());
        String status = "Send";

        PerawatanUnit setPU = new PerawatanUnit(nama, alamat, email, telepon, jenisUnit, serialNumber,
                jamKerja, startBooking, finishBooking, noOrder, tglSubmit, status, jumlahOil, jumlahOilFilter, totalBiaya, totalBiayaPart);

        mDatabase.child("perawatanUnit").push().setValue(setPU);
        Toast.makeText(getContext(), "Data berhasil dikirim!", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onRefresh() {

    }
}
