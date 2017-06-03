package com.example.ubcoasisfinder;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener, GoogleMap.InfoWindowAdapter {

    private GoogleMap mMap;
    final LatLngBounds UBCBound = new LatLngBounds(
            new LatLng(49.24, -123.26), new LatLng(49.28, -123.23));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        getSupportActionBar().setTitle("UBC Oasis Finder");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Restrict bound to UBC area
        mMap.setLatLngBoundsForCameraTarget(UBCBound);

        // Add a marker in UBC and move the camera
        LatLng UBC = new LatLng(49.2606, -123.2460);
        Marker ubcMarker = mMap.addMarker(new MarkerOptions().position(UBC).title("Marker in UBC").
                icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));

        LatLng ICICS = new LatLng(49.261051, -123.248901);
        Marker icicsMarker = mMap.addMarker(new MarkerOptions().position(ICICS).
                title("Marker at ICICS").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        // TODO
        // Parse json
        // create oasis objects for each json
        // make markers and set info window for each oasis object

        // the default location will be UBC with zoom-in effect
        float zoomLevel = (float) 14.0; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UBC, zoomLevel));

    }

    // TODO
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
//            case R.id.a:
//                //Write your code
//                return true;
//            case R.id.b:
//                //Write your code
//                return true;
//            case R.id.c:
//                //Write your code
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Show info window when user clicks a marker
    @Override
    public boolean onMarkerClick(Marker marker){
        marker.showInfoWindow();
        return true;
    }

    // allows you to provide a view that will be used for the entire info window.
    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    // allows you to just customize the contents of the window but still keep the default info
    // window frame and background.
    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}
