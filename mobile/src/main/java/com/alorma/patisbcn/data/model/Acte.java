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

}
