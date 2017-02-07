/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresasgit;

import utilidades67.personas.Persona;

/**
 *
 * @author RafaMar
 */
public class Empleado extends Persona {

    protected double sueldoBruto;
    public final float sueldoMinimo = 700;

    public Empleado(String nombre, String apellidos, String nif) {
        super(nombre, apellidos, nif);
        this.sueldoBruto = sueldoMinimo;
     }

    public Empleado(double sueldoBruto, String nombre, String apellidos, String nif) {
        super(nombre, apellidos, nif);
        this.sueldoBruto = sueldoBruto;
    }

    public Empleado(double sueldoBruto, String nombre, String apellidos, String nif, int edad, int telefono) {
        super(nombre, apellidos, nif, edad, telefono);

        this.sueldoBruto = sueldoBruto;
    }

    public double getSueldoBruto() {
        return sueldoBruto;
    }


    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    @Override
    public String toString() {
        return super.toString() + "Sueldo Bruto: " + sueldoBruto;
    }

    protected double sueldoNeto(float irpf) {

        return (this.sueldoBruto - (this.sueldoBruto * irpf) / 100);

    }

}
