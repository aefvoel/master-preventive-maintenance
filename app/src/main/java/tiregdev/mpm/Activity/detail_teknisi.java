package tiregdev.mpm.Activity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import tiregdev.mpm.R;

public class detail_teknisi extends AppCompatActivity {

    ImageView placePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_teknisi);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setCollaps();
        setupToolbar();
        findViews();
        setViews();
    }

    private CoordinatorLayout detailContent;
    private AppBarLayout appbar;
    private CollapsingToolbarLayout collapsingToolbar;
    private Toolbar toolbar;
    private TextView nama;
    private TextView jabatan;
    private TextView rating;
    private TextView kode;
    private TextView umur;
    private TextView status;
    private TextView job;
    private TextView biaya;
    private TextView history;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-10-07 09:12:49 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        detailContent = (CoordinatorLayout)findViewById( R.id.detail_content );
        appbar = (AppBarLayout)findViewById( R.id.appbar );
        collapsingToolbar = (CollapsingToolbarLayout)findViewById( R.id.collapsing_toolbar );
        toolbar = (Toolbar)findViewById( R.id.toolbar );
        nama = (TextView)findViewById( R.id.nama );
        jabatan = (TextView)findViewById( R.id.jabatan );
        rating = (TextView)findViewById( R.id.rating );
        kode = (TextView)findViewById( R.id.kode );
        umur = (TextView)findViewById( R.id.umur );
        status = (TextView)findViewById( R.id.status );
        job = (TextView)findViewById( R.id.job );
        biaya = (TextView)findViewById( R.id.biaya );
        history = (TextView)findViewById( R.id.history );
    }

    private void setViews(){
        nama.setText(getIntent().getExtras().getString("NAMA_KEY"));
        jabatan.setText(getIntent().getExtras().getString("JABATAN_KEY"));
        rating.setText(getIntent().getExtras().getString("RATING_KEY"));
        kode.setText(getIntent().getExtras().getString("KODE_KEY"));
        umur.setText(getIntent().getExtras().getString("UMUR_KEY"));
        status.setText(getIntent().getExtras().getString("STATUS_KEY"));
        job.setText(getIntent().getExtras().getString("JADWAL_KEY"));
        biaya.setText(getIntent().getExtras().getString("BIAYA_KEY"));
        history.setText(getIntent().getExtras().getString("HISTORY_KEY"));
    }


    public void setCollaps(){
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        placePicture = (ImageView) findViewById(R.id.image);
        placePicture.setImageResource(R.drawable.teknisi);

        collapsingToolbar.setTitle("Abdul Halim");
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.transperent));
        collapsingToolbar.setCollapsedTitleTextColor(Color.rgb(255, 255, 255));
    }

    public void setupToolbar(){
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

                detail_teknisi.this.finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
