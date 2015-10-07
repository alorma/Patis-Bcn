package com.alorma.patisbcn.data.model;

import java.util.List;

/**
 * Created by Bernat on 04/10/2015.
 */
public class Acte {

    public String id;
    public String nom;
    public Lloc lloc_simple;
    public Data data;
    public String tipus_Acte;
    public String estat;
    public String estat_cicle;
    public List<Nivell> classificacions;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Acte{");
        sb.append("id='").append(id).append('\'');
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", lloc_simple=").append(lloc_simple);
        sb.append(", data=").append(data);
        sb.append(", tipus_Acte='").append(tipus_Acte).append('\'');
        sb.append(", estat='").append(estat).append('\'');
        sb.append(", estat_cicle='").append(estat_cicle).append('\'');
        sb.append(", classificacions=").append(classificacions);
        sb.append('}');
        return sb.toString();
    }
}
