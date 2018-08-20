package tiregdev.mpm.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import tiregdev.mpm.adapter.MaintenanceAdapter;
import tiregdev.mpm.model.PerawatanUnit;
import tiregdev.mpm.R;

/**
 * Created by Muhammad63 on 10/6/2017.
 */

public class MaintenanceFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    View v;
    RecyclerView rView;
    SwipeRefreshLayout swipeRefreshRecyclerList;
    private DatabaseReference mDatabase;
    List<PerawatanUnit> list;
    EditText searchEdit;
    MaintenanceAdapter rcAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_list_maintenance, container, false);
        setupAdapter();
        return v;
    }

    public void setupAdapter(){
        swipeRefreshRecyclerList = v.findViewById(R.id.swipe_refresh_recycler_list);
        LinearLayoutManager lLayout = new LinearLayoutManager(getActivity());
        swipeRefreshRecyclerList.setRefreshing(true);
        rView = v.findViewById(R.id.view_list);
        rView.setNestedScrollingEnabled(false);
        rView.setLayoutManager(lLayout);
        searchEdit = v.findViewById(R.id.searchEdit);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), lLayout.getOrientation());
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.line_view));
        rView.addItemDecoration(dividerItemDecoration);

        mDatabase = FirebaseDatabase.getInstance().getReference("perawatanUnit");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                list = new ArrayList<>();
                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                    PerawatanUnit value = dataSnapshot1.getValue(PerawatanUnit.class);
                    PerawatanUnit fire = new PerawatanUnit();
                    String nama = value.getNama();
                    String alamat = value.getAlamat();
                    String email = value.getEmail();
                    String telepon = value.getTelepon();
                    String jenisUnit = value.getJenisUnit();
                    String serialNumber = value.getSerialNumber();
                    String jamKerja = value.getJamKerja();
                    String startBooking = value.getStartBooking();
                    String finishBooking = value.getFinishBooking();
                    String noOrder = value.getNoOrder();
                    String tglSubmit = value.getTglSubmit();
                    String status = value.getStatus();
                    String jumlahOil = value.getJumlahOil();
                    String jumlahOilFilter = value.getJumlahOilFilter();
                    String totalPart = value.getTotalPart();
                    String totalBiaya = value.getTotalBiaya();

                    fire.setNama(nama);
                    fire.setAlamat(alamat);
                    fire.setEmail(email);
                    fire.setTelepon(telepon);
                    fire.setJenisUnit(jenisUnit);
                    fire.setSerialNumber(serialNumber);
                    fire.setJamKerja(jamKerja);
                    fire.setStartBooking(startBooking);
                    fire.setFinishBooking(finishBooking);
                    fire.setNoOrder(noOrder);
                    fire.setTglSubmit(tglSubmit);
                    fire.setStatus(status);
                    fire.setJumlahOil(jumlahOil);
                    fire.setJumlahOilFilter(jumlahOilFilter);
                    fire.setTotalPart(totalPart);
                    fire.setTotalBiaya(totalBiaya);
                    list.add(fire);

                }

                rcAdapter = new MaintenanceAdapter(getActivity(), list);
                rView.setAdapter(rcAdapter);
                swipeRefreshRecyclerList.setRefreshing(false);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
// Failed to read value
                Log.w("Hello", "Failed to read value.", databaseError.toException());
            }
        });

        searchEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        swipeRefreshRecyclerList.setRefreshing(true);
                        rcAdapter.clear();
                        list.clear();
                        list = new ArrayList<PerawatanUnit>();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            PerawatanUnit value = dataSnapshot1.getValue(PerawatanUnit.class);
                            if (value.getNama().toLowerCase().contains(searchEdit.getText().toString().trim().toLowerCase())) {
                                PerawatanUnit fire = new PerawatanUnit();
                                String nama = value.getNama();
                                String alamat = value.getAlamat();
                                String email = value.getEmail();
                                String telepon = value.getTelepon();
                                String jenisUnit = value.getJenisUnit();
                                String serialNumber = value.getSerialNumber();
                                String jamKerja = value.getJamKerja();
                                String startBooking = value.getStartBooking();
                                String finishBooking = value.getFinishBooking();
                                String noOrder = value.getNoOrder();
                                String tglSubmit = value.getTglSubmit();
                                String status = value.getStatus();
                                String jumlahOil = value.getJumlahOil();
                                String jumlahOilFilter = value.getJumlahOilFilter();
                                String totalPart = value.getTotalPart();
                                String totalBiaya = value.getTotalBiaya();

                                fire.setNama(nama);
                                fire.setAlamat(alamat);
                                fire.setEmail(email);
                                fire.setTelepon(telepon);
                                fire.setJenisUnit(jenisUnit);
                                fire.setSerialNumber(serialNumber);
                                fire.setJamKerja(jamKerja);
                                fire.setStartBooking(startBooking);
                                fire.setFinishBooking(finishBooking);
                                fire.setNoOrder(noOrder);
                                fire.setTglSubmit(tglSubmit);
                                fire.setStatus(status);
                                fire.setJumlahOil(jumlahOil);
                                fire.setJumlahOilFilter(jumlahOilFilter);
                                fire.setTotalPart(totalPart);
                                fire.setTotalBiaya(totalBiaya);
                                list.add(fire);
                            }

                        }
                        rcAdapter = new MaintenanceAdapter(getContext(), list);
                        rView.setAdapter(rcAdapter);
                        swipeRefreshRecyclerList.setRefreshing(false);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }

    @Override
    public void onRefresh() {
        setupAdapter();
    }
}
