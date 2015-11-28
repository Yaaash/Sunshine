package com.udacity.yashika.sunshine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.udacity.yashika.sunshine.dummy.DummyContent;

public class SunshineActivity extends AppCompatActivity implements ForecastFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunshine);
        int mColumnCount = 1;

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            ForecastFragment forecastFragment = ForecastFragment.newInstance(mColumnCount);

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
//            forecastFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, forecastFragment).commit();
        }
    }

    @Override
    public void onListFragmentInteraction (DummyContent.DummyItem item) {

        // Do something here to display what selected on item
        Toast.makeText(SunshineActivity.this, item.toString(), Toast.LENGTH_SHORT).show();
    }
}
