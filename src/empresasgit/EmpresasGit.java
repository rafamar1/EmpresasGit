
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
    
}
