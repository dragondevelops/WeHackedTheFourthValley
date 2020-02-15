package com.abstractultra.saferspace

import android.Manifest
import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import io.radar.sdk.Radar
import io.radar.sdk.RadarTrackingOptions


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Radar.initialize("prj_test_pk_65eb3283643d862e050466eadedd1eac6649c3d7")
        Radar.userId = "AU"
        Radar.description = "Main User"
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1002)
        /*
        Radar.trackOnce { status, location, events, user ->
            // do something with status, location, events, user
            textView.setText(location.toString())
        }
        */
        val trackingOptions : RadarTrackingOptions = RadarTrackingOptions.Builder()
            .priority(Radar.RadarTrackingPriority.RESPONSIVENESS) // use EFFICIENCY instead to reduce location update frequency
            .offline(Radar.RadarTrackingOffline.REPLAY_STOPPED) // use REPLAY_OFF instead to disable offline replay
            .sync(Radar.RadarTrackingSync.ALL) // use ALL instead to sync all location updates
            .build()
        Radar.startTracking(trackingOptions)
        
    }

}
