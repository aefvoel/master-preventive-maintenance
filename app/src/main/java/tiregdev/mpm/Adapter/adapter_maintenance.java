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

import tiregdev.mpm.Model.PerawatanUnit;
import tiregdev.mpm.Model.item_maintenance;
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

    public class holder_maintenance extends RecyclerView.ViewHolder {
        public TextView nama, status;

        public holder_maintenance(View itemView){
            super(itemView);

            nama = (TextView)itemView.findViewById(R.id.namaPerusahaan);
            status = (TextView)itemView.findViewById(R.id.status);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Toast.makeText(context, "SUKSES", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
