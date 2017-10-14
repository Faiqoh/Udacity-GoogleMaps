package id.sch.smktelkom_mlg.learn.udacity_googlemaps.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import id.sch.smktelkom_mlg.learn.udacity_googlemaps.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceMarkerFragment extends Fragment implements OnMapReadyCallback {

    static final CameraPosition JTG = CameraPosition.builder()
            .target(new LatLng(-6.858623, 111.642224))
            .zoom(15)
            .bearing(0)
            .tilt(45)
            .build();

    GoogleMap m_map;
    boolean mapReady = false;
    MarkerOptions house;
    MarkerOptions quba;
    MarkerOptions pasar;
    MarkerOptions kec;
    MarkerOptions koramil;
    MarkerOptions smp;

    public PlaceMarkerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_place_marker, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int imageresources = getResources().getIdentifier("@drawable/ic_place", "drawable", getActivity().getPackageName());

        house = new MarkerOptions()
                .position(new LatLng(-6.886892, 111.654675))
                .title("My House")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));

        quba = new MarkerOptions()
                .position(new LatLng(-6.887492, 111.656472))
                .title("Masjid Ar-rahmah")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));

        pasar = new MarkerOptions()
                .position(new LatLng(-6.879152, 111.658757))
                .title("Pasar Jatirogo")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));

        kec = new MarkerOptions()
                .position(new LatLng(-6.885809, 111.658339))
                .title("Kantor Kec. Jatirogo")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));

        koramil = new MarkerOptions()
                .position(new LatLng(-6.888232, 111.662722))
                .title("Koramil Jatirogo")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));

        smp = new MarkerOptions()
                .position(new LatLng(-6.884760, 111.657529))
                .title("SMPN 1 Jatirogo")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        m_map = map;
        m_map.addMarker(house);
        m_map.addMarker(quba);
        m_map.addMarker(pasar);
        m_map.addMarker(kec);
        m_map.addMarker(koramil);
        m_map.addMarker(smp);
        flyTo(JTG);
    }

    private void flyTo(CameraPosition target) {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
