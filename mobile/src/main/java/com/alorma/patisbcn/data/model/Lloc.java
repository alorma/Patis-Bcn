package com.alorma.patisbcn.data.model;

/**
 * Created by Bernat on 04/10/2015.
 */
public class Lloc {
    public String id;
    public String nom;
    public String seccion;
    public Adreca adreca_simple;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Lloc{");
        sb.append("id='").append(id).append('\'');
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", seccion='").append(seccion).append('\'');
        sb.append(", adreca_simple=").append(adreca_simple);
        sb.append('}');
        return sb.toString();
    }
}
