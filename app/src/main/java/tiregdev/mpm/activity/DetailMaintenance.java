package tiregdev.mpm.activity;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import tiregdev.mpm.R;

public class DetailMaintenance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_maintenance);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findViews();
        setViews();
    }

    private TextView namaPerusahaan;
    private TextView alamat;
    private TextView noOrder;
    private TextView email;
    private TextView nmrTlp;
    private TextView jenisUnit;
    private TextView serialNumber;
    private TextView jamKerja;
    private TextView tglBooking;
    TextView status, orderOil, orderOilFilter, totalPart, totalBiaya;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-10-11 22:21:48 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        namaPerusahaan = (TextView) findViewById(R.id.namaPerusahaan);
        alamat = (TextView) findViewById(R.id.alamat);
        noOrder = (TextView) findViewById(R.id.noOrder);
        email = (TextView) findViewById(R.id.email);
        nmrTlp = (TextView) findViewById(R.id.nmrTlp);
        jenisUnit = (TextView) findViewById(R.id.jenisUnit);
        serialNumber = (TextView) findViewById(R.id.serialNumber);
        jamKerja = (TextView) findViewById(R.id.jamKerja);
        tglBooking = (TextView) findViewById(R.id.tglBooking);
        status = (TextView) findViewById(R.id.status);
        orderOil = (TextView) findViewById(R.id.orderOil);
        orderOilFilter = (TextView) findViewById(R.id.orderOilFilter);
        totalPart = (TextView) findViewById(R.id.biayaPart);
        totalBiaya = (TextView) findViewById(R.id.totalBiaya);
    }

    private void setViews() {
        namaPerusahaan.setText(getIntent().getExtras().getString("NAMA"));
        alamat.setText(getIntent().getExtras().getString("ALAMAT"));
        noOrder.setText(getIntent().getExtras().getString("NMR_ORDER"));
        email.setText(getIntent().getExtras().getString("EMAIL"));
        nmrTlp.setText(getIntent().getExtras().getString("TLP"));
        jenisUnit.setText(getIntent().getExtras().getString("JENIS_UNIT"));
        serialNumber.setText(getIntent().getExtras().getString("SERIAL_NUMBER"));
        jamKerja.setText(getIntent().getExtras().getString("JAM_KERJA"));
        tglBooking.setText(getIntent().getExtras().getString("START_BOOKING") + " s/d " + getIntent().getExtras().getString("FINISH_BOOKING"));
        status.setText(getIntent().getExtras().getString("STATUS"));
        orderOil.setText(getIntent().getExtras().getString("ORDER_OIL"));
        orderOilFilter.setText(getIntent().getExtras().getString("ORDER_OIL_FILTER"));
        totalPart.setText(getIntent().getExtras().getString("TOTAL_PART"));
        totalBiaya.setText(getIntent().getExtras().getString("TOTAL_BIAYA"));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here
                DetailMaintenance.this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
