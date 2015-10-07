package com.alorma.patisbcn.data.model;

/**
 * Created by Bernat on 04/10/2015.
 */
public class Adreca {
    public String carrer;
    public String numero;
    public String districtre_codi;
    public String codi_postal;

    public int codi;
    public String municipi;
    public Coordenades coordenades;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Adreca{");
        sb.append("carrer='").append(carrer).append('\'');
        sb.append(", numero='").append(numero).append('\'');
        sb.append(", districtre_codi='").append(districtre_codi).append('\'');
        sb.append(", codi_postal='").append(codi_postal).append('\'');
        sb.append(", codi=").append(codi);
        sb.append(", municipi='").append(municipi).append('\'');
        sb.append(", coordenades=").append(coordenades);
        sb.append('}');
        return sb.toString();
    }
}
