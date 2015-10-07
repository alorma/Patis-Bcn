package com.alorma.patisbcn.data.model;

import java.util.Date;

/**
 * Created by Bernat on 04/10/2015.
 */
public class Data {
    public Date data_inici;
    public String hora_inici;
    public Date data_fi;
    public Date data_proper_acte;
    public Date data_aproximada;
    public Date data_relativa;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Data{");
        sb.append("data_inici=").append(data_inici);
        sb.append(", hora_inici='").append(hora_inici).append('\'');
        sb.append(", data_fi=").append(data_fi);
        sb.append(", data_proper_acte=").append(data_proper_acte);
        sb.append(", data_aproximada=").append(data_aproximada);
        sb.append(", data_relativa=").append(data_relativa);
        sb.append('}');
        return sb.toString();
    }
}
