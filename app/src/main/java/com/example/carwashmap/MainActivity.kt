package com.example.carwashmap

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.carwashmap.ui.viewmodels.MainViewModel
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var map : MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))

        setContentView(R.layout.activity_main)

        createMap()
        setupViewModel()


    }

    private fun createMap() {

        map = findViewById(R.id.map)
        map.setTileSource(TileSourceFactory.MAPNIK)

        val mapController = map.controller
        // зум
        map.maxZoomLevel = 20.0
        map.minZoomLevel = 9.0
        mapController.setZoom(13.0)
        // координаты Омска
        val startPoint = GeoPoint(54.9924, 73.3686)
        mapController.setCenter(startPoint)
        mapController.animateTo(startPoint)
    }

    private fun setupViewModel() {
        mainViewModel =
            ViewModelProvider(this)[MainViewModel::class.java]
    }
}