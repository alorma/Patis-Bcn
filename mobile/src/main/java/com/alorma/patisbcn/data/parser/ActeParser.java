package com.alorma.patisbcn.data.parser;

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
    private static final String TAG_ACTE_ID = "id";
    private String ns = null;

    public List<Acte> parse(InputStream inputStream) throws XmlPullParserException, IOException {

        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(inputStream, null);

        List<Acte> actes = new ArrayList<>();

        int eventType = parser.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {

            if (eventType == XmlPullParser.START_TAG) {
                if (TAG_ACTE.equalsIgnoreCase(parser.getName())) {
                    actes.add(readActe(parser));
                }
            }
            eventType = parser.next();

        }

        return actes;
    }

    private Acte readActe(XmlPullParser parser) throws XmlPullParserException, IOException {
        Acte acte = new Acte();
        parser.require(XmlPullParser.START_TAG, ns, TAG_ACTE);
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (TAG_ACTE_ID.equals(name)) {
                acte.id = readId(parser);
            }
        }
        return acte;
    }

    private String readId(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, TAG_ACTE_ID);
        String id = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, TAG_ACTE_ID);
        return id;
    }

    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }
}
