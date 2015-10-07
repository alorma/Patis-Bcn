package com.alorma.patisbcn.domain.model;

/**
 * Created by Bernat on 04/10/2015.
 */
public class Coordenades {
    public String x;
    public String y;
    public String name;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Coordenades{");
        sb.append("x='").append(x).append('\'');
        sb.append(", y='").append(y).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
