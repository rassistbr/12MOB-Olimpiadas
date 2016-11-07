package com.example.rotorres.olimpiadas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rm31675 on 17/10/2016.
 */
public class ModalidadeDAO {
    public static List<Modalidade> listar(){
        List<Modalidade> lModalidades = new ArrayList<Modalidade>();
        lModalidades.add(new Modalidade(1, "Natação"));
        lModalidades.add(new Modalidade(2, "Judô"));
        lModalidades.add(new Modalidade(3, "Sgrima"));
        lModalidades.add(new Modalidade(4, "Futebol"));
        lModalidades.add(new Modalidade(5, "Voley"));
        lModalidades.add(new Modalidade(6, "Atletismo"));
        lModalidades.add(new Modalidade(7, "Handball"));
        return lModalidades;
    }
}
