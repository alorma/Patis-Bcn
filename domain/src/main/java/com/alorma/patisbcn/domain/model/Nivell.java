package com.alorma.patisbcn.domain.model;

/**
 * Created by Bernat on 04/10/2015.
 */
public class Nivell {
//     <nivell codi="0040001001">Nens i nenes, actes per a</nivell>

    public int codi;

    public String municipi;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Nivell{");
        sb.append("codi=").append(codi);
        sb.append(", municipi='").append(municipi).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
