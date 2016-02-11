package com.bootstrap.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.bootstrap.R;

import butterknife.ButterKnife;
import roboguice.activity.RoboActionBarActivity;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Marcel Sanches on 10/11/2015.
 */
public abstract class BaseActivity extends RoboActionBarActivity {

    public interface OnbackPressedListener {
        void onBackPressed();
    }


    private Toolbar toolbar;

    protected OnbackPressedListener onBackPressedListener;


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        ButterKnife.bind(this);
        initToolbar();
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (getParentActivityName() != null) {
                navigateUp(getParentActivityName());
            } else {
                navigateBack();
            }
            return true;
        }
        return false;
    }


    public void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            setSupportActionBar(toolbar);
        }
    }

    String getParentActivityName() {
        return NavUtils.getParentActivityName(this);
    }

    void navigateBack() {
        onBackPressed();
    }

    void navigateUp(final String parentActivityName) {
        NavUtils.navigateUpFromSameTask(this);
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public void setOnBackPressedListener(OnbackPressedListener onBackPressedListener) {
        this.onBackPressedListener = onBackPressedListener;
    }


    abstract int getLayoutResource();

}
