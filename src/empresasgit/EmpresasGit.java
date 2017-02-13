
package empresasgit;

import java.util.ArrayList;
import utilidades67.personas.Persona;
import utilidades67.ES.ES;
/**
 *
 * @author RafaMar
 * @since 04/02/2017
 */
public class EmpresasGit {
    

    /**
     * @param args the command line arguments
     */
    static ArrayList<Persona> listaEmpresas;
    
    public static void main(String[] args) {
        
        
        listaEmpresas = new ArrayList();
        int opcion;
        do {
            menu();

            opcion = ES.leeN("Introduzca una opcion: ");

            switch (opcion) {

                case 1:
                    listaEmpresas.add(new Empresa(pideCIF()));
                    break;

                case 2:
                    altaPersonal('e');
                    break;

                case 3:
                    altaPersonal('c');
                    break;

                case 4:
                    int opcionDS = menuDirectivoySubordinado();
                    manejaDirectivoSubordinado(opcionDS);
                    break;

                case 5:
                    //manejaBajas();
                    break;

                case 6:
                    listarEmpresas();
                    System.out.println(listaEmpresas.get(pideNoEmpresa() - 1));
                    break;

                case 7:
                    break;
                default:
                    System.out.println("¡¡Opcion Errónea!!");
                    break;
            }

        } while (opcion != 7);
        
    }
    
    
    private static void menu() {
        System.out.println("1.- Alta Empresa");
        System.out.println("2.- Alta Empleado");
        System.out.println("3.- Alta Cliente");
        System.out.println("4.- Manejar Directivos y Subordinados");
        System.out.println("5.- Manejar Bajas de la Empresa");
        System.out.println("6.- Listar Empresa");
        System.out.println("7.- Salir");
    }
    
    private static int menuDirectivoySubordinado(){
        System.out.println("*--Seleccione una opción de la lista--*");
        System.out.println("\t 1- Dar de alta un nuevo Directivo");
        System.out.println("\t 2- Dar de alta un nuevo Subordinado");
        /*System.out.println("\t 3- Convertir un Directivo en Empleado normal");
        System.out.println("\t 4- Dar de baja un Subordinado de un Directivo");*/
        System.out.println("\t 3- Volver al menu principal");
        return ES.leeN("Introduzca la opción deseada: ");
    }
    
    private static int menuEmpleado() {
        System.out.println("\t 1- Dar de alta un nuevo Empleado");
        System.out.println("\t 2- Seleccionar un Empleado de la lista");
        return ES.leeN("Introduzca la opción deseada: ");
    }
    
    private static String pideCIF() {
        return ES.leeDeTeclado("Introduzca el CIF de la Empresa: ");
    }

    private static String pideCorreo() {
        return ES.leeDeTeclado("Introduzca el E-mail: ");
    }

    private static String pideNombre() {
        return ES.leeDeTeclado("Introduzca el Nombre: ");
    }

    private static String pideApellidos() {
        return ES.leeDeTeclado("Introduzca los Apellidos: ");
    }

    private static String pideNif() {
        return ES.leeDeTeclado("Introduzca el NIF: ");
    }

    private static int pideNoEmpresa() {
        return ES.leeN("Seleccione el Nº de Empresa: ");
    }

    private static int pideNoDirectivo() {
        return ES.leeN("Seleccione el Nº de Directivo: ");
    }

    private static int pideNoEmpleado() {
        return ES.leeN("Seleccione el Nº de Empleado: ");
    }

    private static String pideCategoria() {
        return ES.leeDeTeclado("Introduzca la categoria del directivo: ");
    }


}
