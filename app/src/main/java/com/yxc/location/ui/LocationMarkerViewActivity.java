package com.yxc.location.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.yxc.location.R;
import com.yxc.location.util.ColorUtil;
import com.yxc.location.util.DisplayUtil;
import com.yxc.location.util.TimeDateUtil;
import com.yxc.location.view.LocationMarker;

import org.joda.time.LocalDate;

/**
 * @author yxc
 * @since  2019/4/26
 *
 */
public class LocationMarkerViewActivity extends AppCompatActivity {

    Toolbar toolbar;
    LinearLayout container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_marker);
        initView();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolBar);
        toolbar.setTitle(TimeDateUtil.getDateStr(TimeDateUtil.localDateToTimestamp(LocalDate.now()), "M月dd日"));
        toolbar.setNavigationIcon(R.drawable.ic_chevron_left_white_45dp);
        toolbar.setTitleTextColor(ColorUtil.getResourcesColor(this, R.color.white));
        setSupportActionBar(toolbar);

        container = findViewById(R.id.ll_location_marker);
        container.addView(new LocationMarker(this, DisplayUtil.dip2px(20), "10", 15));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
