/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresasgit;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author RafaMar
 */
public class Directivo extends Empleado {

    private String categoria;
    private ArrayList<Empleado> listaSubordinados;

    public Directivo(String categoria, Empleado directivo) {
        super(directivo.getNombre(), directivo.getApellidos(), directivo.getNif());
        this.categoria = categoria;
        listaSubordinados = new ArrayList();
    }

    public void setListaSubordinados(ArrayList<Empleado> listaSubordinados) {
        this.listaSubordinados = listaSubordinados;
    }

    public ArrayList getListaSubordinados() {
        return listaSubordinados;
    }

    public void addSubordinado(Empleado subordinado) {
        this.listaSubordinados.add(subordinado);
    }

    public void removeSubordinado(Empleado subordinado) {
        if (listaSubordinados.contains(subordinado)) {
            this.listaSubordinados.remove(subordinado);
        }
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public double getSueldoBruto() {
        return sueldoBruto;
    }

    @Override
    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto * 1.2;
    }
    
    String listaSubordinados() {
        String listado = "\n\t **\\Lista de Subordinados del Directivo " + nombre +" //**" ;
        Iterator<Empleado> iterator = listaSubordinados.iterator();
        while (iterator.hasNext()) {
            listado += "\n\t\t*" + iterator.next().getNif();
        }
        return listado;
    }

    @Override
    public String toString() {
        return super.toString() + " Categoria:" + categoria+ listaSubordinados();
    }

}
