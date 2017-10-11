package tiregdev.mpm.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tiregdev.mpm.Activity.detail_teknisi;
import tiregdev.mpm.Model.Teknisi;
import tiregdev.mpm.R;

/**
 * Created by Muhammad63 on 10/5/2017.
 */

public class adapter_teknisi extends RecyclerView.Adapter<adapter_teknisi.holder_teknisi> {
    private List<Teknisi> itemList;
    private Context context;
    Teknisi listPosition;

    public adapter_teknisi(Context context, List<Teknisi> itemList){
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public adapter_teknisi.holder_teknisi onCreateViewHolder(ViewGroup parent, int viewType){
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_teknisi,null);
        adapter_teknisi.holder_teknisi hn = new holder_teknisi(layoutView);
        return hn;
    }


    @Override
    public void onBindViewHolder(adapter_teknisi.holder_teknisi holder, int position){
        listPosition = itemList.get(position);
        holder.nama.setText(listPosition.getNama());
        holder.kode.setText(listPosition.getKode());
        holder.jabatan.setText(listPosition.getJabatan());
        holder.img.setImageResource(R.drawable.teknisi);


    }

    @Override
    public int getItemCount(){
        int arr = 0;

        try{
            if(itemList.size()==0){

                arr = 0;

            }
            else{

                arr=itemList.size();
            }



        }catch (Exception e){



        }

        return arr;
    }


    public void clear() {
        itemList.clear();
        notifyDataSetChanged();
    }

    public class holder_teknisi extends RecyclerView.ViewHolder {
        public TextView nama, kode, jabatan;
        public ImageView img;

        public holder_teknisi(View itemView){
            super(itemView);

            nama = (TextView)itemView.findViewById(R.id.nama);
            kode = (TextView)itemView.findViewById(R.id.kode);
            jabatan = (TextView)itemView.findViewById(R.id.jabatan);
            img = (ImageView)itemView.findViewById(R.id.img);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(context,detail_teknisi.class);
                    i.putExtra("NAMA_KEY", itemList.get(getAdapterPosition()).getNama());
                    i.putExtra("JABATAN_KEY",itemList.get(getAdapterPosition()).getJabatan());
                    i.putExtra("RATING_KEY",itemList.get(getAdapterPosition()).getRating());
                    i.putExtra("KODE_KEY",itemList.get(getAdapterPosition()).getKode());
                    i.putExtra("UMUR_KEY",itemList.get(getAdapterPosition()).getUmur());
                    i.putExtra("STATUS_KEY",itemList.get(getAdapterPosition()).getStatus());
                    i.putExtra("JADWAL_KEY",itemList.get(getAdapterPosition()).getJadwal());
                    i.putExtra("BIAYA_KEY",itemList.get(getAdapterPosition()).getBiaya());
                    i.putExtra("HISTORY_KEY",itemList.get(getAdapterPosition()).getHistory());
                    context.startActivity(i);
                }
            });
        }

    }
}
