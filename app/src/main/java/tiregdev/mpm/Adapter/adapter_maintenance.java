package tiregdev.mpm.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

import tiregdev.mpm.Activity.detail_list_maintenance;
import tiregdev.mpm.Model.PerawatanUnit;
import tiregdev.mpm.R;

/**
 * Created by Muhammad63 on 10/6/2017.
 */

public class adapter_maintenance extends RecyclerView.Adapter<adapter_maintenance.holder_maintenance> {
    private List<PerawatanUnit> itemList;
    private Context context;

    public adapter_maintenance(Context context, List<PerawatanUnit> itemList){
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public adapter_maintenance.holder_maintenance onCreateViewHolder(ViewGroup parent, int viewType){
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_maintenance,null);
        adapter_maintenance.holder_maintenance hn = new adapter_maintenance.holder_maintenance(layoutView);
        return hn;
    }


    @Override
    public void onBindViewHolder(adapter_maintenance.holder_maintenance holder, int position){
        holder.nama.setText(itemList.get(position).getNama());
        holder.noOrder.setText(itemList.get(position).getNoOrder());
        holder.status.setText(itemList.get(position).getStatus());
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

    public class holder_maintenance extends RecyclerView.ViewHolder {
        public TextView nama, noOrder ,status;

        public holder_maintenance(View itemView){
            super(itemView);

            nama = (TextView)itemView.findViewById(R.id.namaPerusahaan);
            noOrder = (TextView)itemView.findViewById(R.id.noOrder);
            status = (TextView)itemView.findViewById(R.id.status);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent i = new Intent(context, detail_list_maintenance.class);
                    i.putExtra("NAMA", itemList.get(getAdapterPosition()).getNama());
                    i.putExtra("ALAMAT", itemList.get(getAdapterPosition()).getAlamat());
                    i.putExtra("NMR_ORDER", itemList.get(getAdapterPosition()).getNoOrder());
                    i.putExtra("EMAIL", itemList.get(getAdapterPosition()).getEmail());
                    i.putExtra("TLP", itemList.get(getAdapterPosition()).getTelepon());
                    i.putExtra("JENIS_UNIT", itemList.get(getAdapterPosition()).getJenisUnit());
                    i.putExtra("SERIAL_NUMBER", itemList.get(getAdapterPosition()).getSerialNumber());
                    i.putExtra("JAM_KERJA", itemList.get(getAdapterPosition()).getJamKerja());
                    i.putExtra("START_BOOKING", itemList.get(getAdapterPosition()).getStartBooking());
                    i.putExtra("FINISH_BOOKING", itemList.get(getAdapterPosition()).getFinishBooking());
                    i.putExtra("STATUS", itemList.get(getAdapterPosition()).getStatus());
                    i.putExtra("ORDER_OIL", itemList.get(getAdapterPosition()).getJumlahOil());
                    i.putExtra("ORDER_OIL_FILTER", itemList.get(getAdapterPosition()).getJumlahOilFilter());
                    i.putExtra("TOTAL_PART", itemList.get(getAdapterPosition()).getTotalPart());
                    i.putExtra("TOTAL_BIAYA", itemList.get(getAdapterPosition()).getTotalBiaya());
                    context.startActivity(i);
                }
            });
        }
    }

}
