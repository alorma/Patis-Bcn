package com.alorma.patisbcn.data.parser;

import android.util.Log;

import com.alorma.patisbcn.data.model.Acte;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bernat on 04/10/2015.
 */
public class ActeParser {

    private static final String TAG_ACTE = "acte";

    public List<Acte> parse(InputStream inputStream) throws XmlPullParserException, IOException {

        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();
        xpp.setInput(inputStream, null);

        List<Acte> actes = new ArrayList<>();

        Acte currentActe = null;

        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG) {
                if (TAG_ACTE.equalsIgnoreCase(xpp.getName())) {
                    currentActe = new Acte();
                }
            } else if (eventType == XmlPullParser.END_TAG) {
                if (TAG_ACTE.equalsIgnoreCase(xpp.getName())) {
                    if (currentActe != null) {
                        actes.add(currentActe);
                    }
                }
            } else if (eventType == XmlPullParser.TEXT) {

            }
            eventType = xpp.next();
        }

        return actes;
    }

}
