
package com.yxc.location.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import com.yxc.location.R;
import com.yxc.location.map.location.LocationActivity;
import com.yxc.location.map.location.RecordActivity;
import com.yxc.location.map.location.util.LocationConstants;
import com.yxc.location.util.TimeDateUtil;

import org.joda.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        permissionApply();
        Log.d("MainActivity", "SDCard:" + Environment.getExternalStorageDirectory());
    }


    private void permissionApply() {
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                    {android.Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE}, LOCATION_PERMISSION_REQUEST_CODE);
            return;
        }
    }

    private void initView() {
        toolbar = findViewById(R.id.toolBar);
        toolbar.setTitle(TimeDateUtil.getDateStr(TimeDateUtil.localDateToTimestamp(LocalDate.now()), "M月dd日"));
        toolbar.setNavigationIcon(R.drawable.ic_navigation_left_black_45dp);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    public void clickWaterDrop(View view) {
        startActivity(new Intent(this, LocationMarkerViewActivity.class));
    }

    public void clickGaoDeMap(View view) {
        startActivity(new Intent(this, LocationActivity.class));
    }

    public void clickGoogleMap(View view) {
        intentToRecord();
    }

    private void intentToRecord(){
        Intent intent = new Intent(this, RecordActivity.class);
        intent.putExtra(LocationConstants.KEY_RECORD_TYPE, LocationConstants.SPORT_TYPE_RUNNING);
        startActivity(intent);
    }

}
