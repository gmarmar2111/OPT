package tema1.taquilla.controllers;

import java.util.ArrayList;

public class RespuestaBusqueda {
    ArrayList<Obra> obraArrayList;

    public RespuestaBusqueda() {
    }

    public RespuestaBusqueda(ArrayList<Obra> obraArrayList) {
        this.obraArrayList = obraArrayList;
    }

    public ArrayList<Obra> getObraArrayList() {
        return obraArrayList;
    }

    public void setObraArrayList(ArrayList<Obra> obraArrayList) {
        this.obraArrayList = obraArrayList;
    }
}
