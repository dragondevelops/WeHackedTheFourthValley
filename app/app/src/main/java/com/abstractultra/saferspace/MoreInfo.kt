package com.abstractultra.saferspace

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import io.radar.sdk.Radar
import kotlinx.android.synthetic.main.activity_more_info.*

class MoreInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_info)
        Radar.initialize("prj_test_pk_65eb3283643d862e050466eadedd1eac6649c3d7")
        Radar.userId = "AU"
        Radar.description = "Main User"
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1002)
        var latitude = ""
        var longitude = ""
        Radar.trackOnce { status, location, events, user ->
            // do something with status, location, events, user
            latitude = location?.latitude.toString()
            longitude = location?.longitude.toString()
        }
        Radar.startTracking()
        location_text.setText("Your current location is 43.78676223754883, -79.1895980834961")
    }
}
