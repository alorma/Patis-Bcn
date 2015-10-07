package com.alorma.patisbcn.data.parser;

import com.alorma.patisbcn.data.model.Acte;
import com.alorma.patisbcn.data.model.Adreca;
import com.alorma.patisbcn.data.model.Coordenades;
import com.alorma.patisbcn.data.model.Lloc;

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
    private static final String TAG_ACTE_NOM = "nom";

    private static final String TAG_ACTE_LLOC_SIMPLE = "lloc_simple";
    private static final String TAG_LLOC_ID = "id";
    private static final String TAG_LLOC_NOM = "nom";
    private static final String TAG_LLOC_SECCIO = "seccio";

    private static final String TAG_ADRECA_SIMPLE = "adreca_simple";
    private static final String TAG_ADRECA_CARRER = "carrer";
    private static final String TAG_ADRECA_NUMERO = "numero";
    private static final String TAG_ADRECA_DISTRICTE = "districte";
    private static final String TAG_ADRECA_CP = "codi_postal";
    private static final String TAG_ADRECA_MUNICIPI = "municipi";
    private static final String TAG_ADRECA_COORDENADES = "coordenades";
    private static final String TAG_GEO = "geocodificacio";

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
                acte.id = readTag(parser, TAG_ACTE_ID);
            } else if (TAG_ACTE_NOM.equals(name)) {
                acte.nom = readTag(parser, TAG_ACTE_NOM);
            } else if (TAG_ACTE_LLOC_SIMPLE.equals(name)) {
                acte.lloc_simple = readLlocSimple(parser);
            }
        }
        return acte;
    }

    private Lloc readLlocSimple(XmlPullParser parser) throws IOException, XmlPullParserException {
        Lloc lloc = new Lloc();
        parser.require(XmlPullParser.START_TAG, ns, TAG_ACTE_LLOC_SIMPLE);
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (TAG_LLOC_ID.equals(name)) {
                lloc.id = readTag(parser, TAG_LLOC_ID);
            } else if (TAG_LLOC_NOM.equals(name)) {
                lloc.nom = readTag(parser, TAG_LLOC_NOM);
            } else if (TAG_LLOC_SECCIO.equals(name)) {
                lloc.seccion = readTag(parser, TAG_LLOC_SECCIO);
            } else if (TAG_ADRECA_SIMPLE.equals(name)) {
                lloc.adreca_simple = readAdrecaSimple(parser);
            }
        }
        return lloc;
    }

    private Adreca readAdrecaSimple(XmlPullParser parser) throws IOException, XmlPullParserException {
        Adreca adreca = new Adreca();
        parser.require(XmlPullParser.START_TAG, ns, TAG_ADRECA_SIMPLE);
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (TAG_ADRECA_CARRER.equals(name)) {
                adreca.carrer = readTag(parser, TAG_ADRECA_CARRER);
            } else if (TAG_ADRECA_CP.equals(name)) {
                adreca.codi_postal = readTag(parser, TAG_ADRECA_CP);
            } else if (TAG_ADRECA_DISTRICTE.equals(name)) {
                adreca.districtre_codi = readTag(parser, TAG_ADRECA_DISTRICTE);
            } else if (TAG_ADRECA_NUMERO.equals(name)) {
                adreca.numero = readTag(parser, TAG_ADRECA_NUMERO);
            } else if (TAG_ADRECA_MUNICIPI.equals(name)) {
                adreca.municipi = readTag(parser, TAG_ADRECA_MUNICIPI);
            } else if (TAG_ADRECA_COORDENADES.equals(name)) {
                adreca.coordenades = readCoordenades(parser);
            }
        }
        return adreca;
    }

    private Coordenades readCoordenades(XmlPullParser parser) throws IOException, XmlPullParserException {
        Coordenades coordenades = new Coordenades();
        parser.require(XmlPullParser.START_TAG, ns, TAG_ADRECA_COORDENADES);
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (TAG_GEO.equals(name)) {
                coordenades.x = parser.getAttributeValue(null, "x");
                coordenades.y = parser.getAttributeValue(null, "y");
            }
        }
        return coordenades;
    }

    private String readTag(XmlPullParser parser, String tag) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, tag);
        String id = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, tag);
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
