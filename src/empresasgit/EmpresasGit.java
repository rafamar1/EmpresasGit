
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
    static ArrayList <Empresa> listaEmpresas;
    
    public static void main(String[] args) throws empresasError {
        
        
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
    
        static void altaPersonal(char tipo) throws empresasError {
        Empresa empElegida = null;
        listarEmpresas();
        int nempre;

        do {
            nempre = pideNoEmpresa();
            try {
                empElegida = (Empresa) listaEmpresas.get(nempre - 1);
            } catch (IndexOutOfBoundsException error) {
                try {
                    throw new empresasError("1");
                } catch (empresasError error2) {
                    System.out.println("¡Empresa no válida!");
                }
            }
        } while (empElegida == null);

        if (tipo == 'c') {
            generaCliente(nempre);
        } else if (tipo == 'e') {
            generaEmpleado(nempre);
        } else if (tipo == 'd') {
            generaDirectivo(nempre);
        } else if (tipo == 's') {
            generaSubordinado(nempre);
        }

    }

    private static void listarEmpresas() {
        System.out.println("\n***Listado de Empresas***");
        int i = 0;
        for (Empresa empresa : listaEmpresas) {
            System.out.println("\t" + (i + 1) + "-" + empresa.getCif());
            i++;
        }
    }
    
    /*PREGUNTAR ALGUNA MANERA PARA CONTROLAR EL ERROR AQUI DEL INDICE FUERA DE EXCEPCION*/
    private static void listarEmpleados(int nempre) {
        System.out.println("\n***Listado de Empleados***");
        int i = 0;
        for (Empleado empleado : listaEmpresas.get(nempre - 1).getEmpleados()) {
            System.out.println("\t" + (i + 1) + "- Nombre " + empleado.getNombre() + "; NIF -" + empleado.getNif());
            i++;
        }
    }

    private static void listarDirectivos(int nempre) {
        System.out.println("\n***Listado de Directivos***");
        int i = 0;
        for (Directivo directivo : listaEmpresas.get(nempre - 1).getDirectivo()) {
            System.out.println("\t" + (i + 1) + "-" + directivo.getNombre() + "; NIF: " + directivo.getNif());
            i++;
        }
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
    
        private static void manejaDirectivoSubordinado(int opcionDS) throws empresasError {
        
        switch (opcionDS) {
            case 1:
                altaPersonal('d');
                break;
            case 2:
                altaPersonal('s');
                break;
                
            case 3:
                break;
            default:
                System.out.println("La opción introducida no es válida");
                break;
        }
            
    }

   /*private static void manejaBajas() {
        DAR DE BAJA UN EMPLEADO
        DAR DE BAJA UN CLIENTE
        DAR DE BAJA UN DIRECTIVO
    }*/
    
    private static void generaSubordinado(int nempre) {
        listarDirectivos(nempre);
        int noDirectivo = pideNoDirectivo();
        System.out.println("\n**MENU SUBORDINADO**");
        System.out.println("\t¿Qué subordinado añadira a la lista del directivo "+ 
            listaEmpresas.get(nempre - 1).getDirectivo().get(noDirectivo-1).getNombre()+" ?");
        
        int opcion = menuEmpleado();
        if (opcion == 1) {
            Empleado subordinado = new Empleado(pideNombre(), pideApellidos(), pideNif());
            listaEmpresas.get(nempre - 1).altaEmpleado(subordinado);
            listaEmpresas.get(nempre - 1).getDirectivo().get(noDirectivo - 1).addSubordinado(subordinado);
            System.out.println("\nEl empleado " + subordinado.getNombre() + "ahora trabaja para el Directivo " +
                                listaEmpresas.get(nempre - 1).getDirectivo().get(noDirectivo - 1).getNombre());
        } else if (opcion == 2) {
            listarEmpleados(nempre);
            int noEmpleado = pideNoEmpleado();
            Empleado subordinado = listaEmpresas.get(nempre - 1).getEmpleados().get(noEmpleado - 1);
            listaEmpresas.get(nempre - 1).getDirectivo().get(noDirectivo - 1).addSubordinado(subordinado);
            System.out.println("\nEl empleado " + subordinado.getNombre() + "ahora trabaja para el Directivo " +
                                listaEmpresas.get(nempre - 1).getDirectivo().get(noDirectivo - 1).getNombre());
        } else {
            System.out.println("¡Opción no válida!");
        }
    }

    private static void generaDirectivo(int nempre) {
        System.out.println("**MENU DIRECTIVO**");
        int opcion = menuEmpleado();
        
        if (opcion == 1) {
            Empleado empleDirectivo = new Empleado(pideNombre(), pideApellidos(), pideNif());
            Directivo directivo = new Directivo(pideCategoria(), empleDirectivo);
            listaEmpresas.get(nempre - 1).altaDirectivo(directivo);
        } else if (opcion == 2) {
            listarEmpleados(nempre);
            int noEmpleado = pideNoEmpleado();
            Empleado empDirectivo = listaEmpresas.get(nempre - 1).getEmpleados().get(noEmpleado - 1);
            Directivo directivo = new Directivo(pideCategoria(), empDirectivo);
            listaEmpresas.get(nempre - 1).altaDirectivo(directivo);
            listaEmpresas.get(nempre - 1).getEmpleados().remove(empDirectivo);
            System.out.println("\nEl empleado " +directivo.getNombre()+" es ahora un Directivo con categoría "+directivo.getCategoria());
        } else {
            System.out.println("¡Opción no válida!");
        }
    }

    private static void generaEmpleado(int nempre) {
        Empleado empleado = new Empleado(pideNombre(), pideApellidos(), pideNif());
        listaEmpresas.get(nempre - 1).altaEmpleado(empleado);
    }

    private static void generaCliente(int nempre) {
        Cliente cliente = new Cliente(pideCorreo(), pideNombre(), pideApellidos(), pideNif());
        listaEmpresas.get(nempre - 1).altaCliente(cliente);
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
