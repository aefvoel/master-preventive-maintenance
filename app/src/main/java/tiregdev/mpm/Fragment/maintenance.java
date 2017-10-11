package tiregdev.mpm.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import tiregdev.mpm.Adapter.adapter_maintenance;
import tiregdev.mpm.Adapter.adapter_teknisi;
import tiregdev.mpm.Model.PerawatanUnit;
import tiregdev.mpm.Model.Teknisi;
import tiregdev.mpm.Model.item_maintenance;
import tiregdev.mpm.Model.item_teknisi;
import tiregdev.mpm.R;

/**
 * Created by Muhammad63 on 10/6/2017.
 */

public class maintenance extends Fragment {

    View v;
    RecyclerView rView;
    SwipeRefreshLayout swipeRefreshRecyclerList;
    private DatabaseReference mDatabase;
    List<PerawatanUnit> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_list_maintenance, container, false);
        swipeRefresh();
        setupAdapter();
        return v;
    }

    public void setupAdapter(){
        LinearLayoutManager lLayout = new LinearLayoutManager(getActivity());

        rView = v.findViewById(R.id.view_list);
        rView.setNestedScrollingEnabled(false);
        rView.setLayoutManager(lLayout);



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
                    String idTeknisi = value.getIdTeknisi();
                    String tglSubmit = value.getTglSubmit();
                    String status = value.getStatus();

                    fire.setNama(nama);
                    fire.setAlamat(alamat);
                    fire.setEmail(email);
                    fire.setTelepon(telepon);
                    fire.setJenisUnit(jenisUnit);
                    fire.setSerialNumber(serialNumber);
                    fire.setJamKerja(jamKerja);
                    fire.setStartBooking(startBooking);
                    fire.setFinishBooking(finishBooking);
                    fire.setIdTeknisi(idTeknisi);
                    fire.setTglSubmit(tglSubmit);
                    fire.setStatus(status);
                    list.add(fire);

                }

                adapter_maintenance rcAdapter = new adapter_maintenance(getActivity(), list);
                rView.setAdapter(rcAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
// Failed to read value
                Log.w("Hello", "Failed to read value.", databaseError.toException());
            }
        });
    }


    public void swipeRefresh(){
        swipeRefreshRecyclerList = v.findViewById(R.id.swipe_refresh_recycler_list);
        swipeRefreshRecyclerList.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                // Do your stuff on refresh
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (swipeRefreshRecyclerList.isRefreshing())
                            swipeRefreshRecyclerList.setRefreshing(false);
                    }
                }, 5000);

            }
        });
    }
}
