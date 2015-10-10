package com.alorma.patisbcn.data;

import android.location.Location;

import com.alorma.patisbcn.domain.model.Coordenades;

import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.geom.LatLon;
import gov.nasa.worldwind.geom.coords.UTMCoord;

/**
 * Created by Bernat on 10/10/2015.
 */
public class CoordinatesHelper {

    private static final int ZONE = 31;
    private static final String HEMISPHERE = AVKey.NORTH;

    public static Location convert(Coordenades coordenades) {
        Location location = new Location("");

        double x = (Long.valueOf(coordenades.x) / 1000) + 400000;
        double y = (Long.valueOf(coordenades.y) / 1000) + 4500000;

        LatLon latLon = UTMCoord.locationFromUTMCoord(ZONE, HEMISPHERE, x, y);

        location.setLatitude(dmsToDecimal(latLon.getLatitude().toDMS()));
        location.setLongitude(dmsToDecimal(latLon.getLongitude().toDMS()));

        return location;
    }

    private static double dmsToDecimal(double[] doubles) {
        double d = doubles[0];
        double m = doubles[1];
        double s = doubles[2];

        return Math.signum(d) * (Math.abs(d) + (m / 60.0) + (s / 3600.0));
    }

}
