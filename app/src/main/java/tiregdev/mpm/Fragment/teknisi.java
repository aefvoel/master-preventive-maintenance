package tiregdev.mpm.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.InputFilter;
import android.text.Spanned;
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

import tiregdev.mpm.Adapter.adapter_teknisi;
import tiregdev.mpm.Model.Teknisi;
import tiregdev.mpm.Model.item_teknisi;
import tiregdev.mpm.R;

/**
 * Created by Muhammad63 on 10/5/2017.
 */

public class teknisi extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    View v;
    SwipeRefreshLayout swipeRefreshRecyclerList;
    EditText searchEdit;
    private DatabaseReference mDatabase;
    List<Teknisi> list;
    RecyclerView rView;
    adapter_teknisi rcAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_teknisi, container, false);
        swipeRefreshRecyclerList = v.findViewById(R.id.swipe_refresh_recycler_list);
        setupAdapter();
        return v;
    }

    @Override
    public void onRefresh() {
        setupAdapter();
    }


    public void setupAdapter(){

        swipeRefreshRecyclerList.setRefreshing(true);
        rView = v.findViewById(R.id.view_teknisi);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        rView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        mDatabase = FirebaseDatabase.getInstance().getReference("daftarTeknisi");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                list = new ArrayList<>();

                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                    Teknisi value = dataSnapshot1.getValue(Teknisi.class);
                    Teknisi fire = new Teknisi();
                    String nama = value.getNama();
                    String kode = value.getKode();
                    String umur = value.getUmur();
                    String status = value.getStatus();
                    String jabatan = value.getJabatan();
                    String rating = value.getRating();
                    String jadwal = value.getJadwal();
                    String biaya = value.getBiaya();
                    String history = value.getHistory();

                    fire.setNama(nama);
                    fire.setKode(kode);
                    fire.setUmur(umur);
                    fire.setStatus(status);
                    fire.setJabatan(jabatan);
                    fire.setRating(rating);
                    fire.setBiaya(biaya);
                    fire.setHistory(history);
                    fire.setJadwal(jadwal);
                    list.add(fire);

                }


                rcAdapter = new adapter_teknisi(getContext(), list);
                rView.setAdapter(rcAdapter);
                swipeRefreshRecyclerList.setRefreshing(false);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
// Failed to read value
                Log.w("Hello", "Failed to read value.", databaseError.toException());
            }
        });




    }


}
