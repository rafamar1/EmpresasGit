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
public class Empresa {

    private ArrayList<Empleado> empleados;
    private ArrayList<Cliente> clientes;
    private ArrayList<Directivo> directivos;
    private String Cif;

    public Empresa(String Cif) {
        this.Cif = Cif;
        empleados = new ArrayList();
        clientes = new ArrayList();
        directivos = new ArrayList();
    }

    public Empresa(ArrayList<Empleado> empleados, String Cif) {
        this.empleados.addAll(empleados);
        this.Cif = Cif;
        clientes = new ArrayList();
        directivos = new ArrayList();
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Directivo> getDirectivo() {
        return directivos;
    }

    public void setDirectivo(ArrayList<Directivo> directivo) {
        this.directivos = directivo;
    }

    public String getCif() {
        return Cif;
    }

    public void setCif(String Cif) {
        this.Cif = Cif;
    }

    public void altaEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
    }

    public void altaCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void altaDirectivo(Directivo directivo) {
        this.directivos.add(directivo);
    }

   
    @Override
    public String toString() {
        return "Empresa: CIF de la Empresa: " + Cif + "\nPersonal:"; // + listaMiembros();
    }

}
