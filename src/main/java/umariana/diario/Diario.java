/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package umariana.diario;

import Entrada.Entrada;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author DANNA LAGOS
 */
public class Diario {

    private ArrayList<Entrada> misEntradas;
    private Scanner lector;

public Diario() {
        //Permite inicializar los productos de una clase
        misEntradas = new ArrayList<>();
        lector = new Scanner(System.in);
    }
    //Muestra el Menu de Opciones
    public void mostrarMenu() {
        boolean activo = true;
        
        do {
            //Imprimir el Menu
            System.out.println("====== Menu de opciones ======");
            System.out.println("1. Agregar Entrada");
            System.out.println("2. Consultar Entrada");
            System.out.println("3. Eliminar Entrada");
            System.out.println("4. Modificar Entrada");
            System.out.println("5. Salir");
            System.out.println("Digite su opción");
            System.out.println("=======================================");
            
            
            //Lee las opciones del usuario
            int opcion = lector.nextInt();
                //Ejecuta la accion, de opcion selecionada
                switch (opcion) {
                case 1:
                    agregarEntrada();
                    break;
                case 2:
                    if (misEntradas.size() == 0) {
                        System.out.println("No hay productos agregados.");
                    } else {
                        //Llama al metodo que llama al Inventario
                        consultarEntrada();
                    }
                    break;
                case 3:
                    if (misEntradas.size() == 0) {
                        System.out.println("No hay productos agregados.");
                    } else {
                        eliminarEntrada();                       
                    }
                    break;
                case 4:
                    if(misEntradas.size()==0){
                        System.out.println("No hay productos agregados");
                    } else {
                        //Llama al metodo y elimina el producto 
                       modificarEntrada();
                    }
                    break;
                case 5:
                    //Cambia la variable para salir del menu
                    activo = false;
                    System.out.println("Programa terminado");
                    break;
                default:
                    //Para opciones invalidas
                    System.out.println("opcion no valida");
            }
        } 
        //Bucle para cuando se cumple las variables
        while (activo);
    }
    
    //Agrega nuevo Producto
   private void agregarEntrada() {
        //Llama al metodo que Agrega el Producto 
        lector.nextLine();
        //Obtener la descripción
        System.out.println("Ingrese la Descripcion de la Entrada: ");
        String descripcion =lector.nextLine();
        System.out.println("===========================================");
        //Obtener el ultimo idEntrada ingresado
        int nuevoIdEntrada = 1;
        if (!misEntradas.isEmpty()) {
        Entrada ultimaEntrada = misEntradas.get(misEntradas.size() - 1);
        nuevoIdEntrada = ultimaEntrada.getIdEntrada() + 1;
        }
        //Obtener la fecha del sistema
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = formatoFecha.format(fechaActual);
        // Crear una nueva entrada y agregarla a la lista
        Entrada nuevaEntrada = new Entrada(nuevoIdEntrada, fecha, descripcion);
        misEntradas.add(nuevaEntrada);
        
        // Imprimir el idEntrada y la fecha de la nueva entrada agregada
        System.out.println("ID de Entrada: " + nuevoIdEntrada);
        System.out.println("Fecha de la Entrada: " + fecha);
        System.out.println("La Descripcion de la Entrada es: " + descripcion);
        System.out.println("Entrada agregada satisfactoriamente!");
    
   }

    //Muestra el inventario
    private void consultarEntrada() {
    System.out.print("Ingrese la fecha de la Entrada que desea consultar (dd-MM-yyyy): ");
    String fechaBuscada = lector.nextLine(); // El usuario ingresa la fecha
    lector.nextLine();
    boolean entradaEncontrada = false;
    // Verificar si hay entradas en esa fecha
    for (Entrada entrada : misEntradas) {
        if (entrada.getFecha().equals(fechaBuscada)) {
            // Se encontró al menos una entrada con la fecha especificada
            System.out.println("ID: " + entrada.getIdEntrada() 
                    + " | Fecha: " + entrada.getFecha() 
                    + " | Descripción: " 
                    + entrada.getDescripcion());
            entradaEncontrada = true;
        }
    }
    // Si no se encontró ninguna entrada con la fecha especificada, mostrar un mensaje
    if (!entradaEncontrada) {
        System.out.println("No se encontraron entradas para la fecha especificada.");
    }
    }

    public void eliminarEntrada(){
        System.out.println("Digite el Id del la Entrada que quiere eliminar");
                    int id = lector.nextInt();
                        for(Entrada e: misEntradas){
                        if(e.getIdEntrada()== id){
		                    System.out.println("¿Esta seguro de eliminar esta Entrada?");
		                    System.out.println("Ingrese: 1 para eliminar o 2 para Salir: ");
		                    int opcion = lector.nextInt();
		                    if (opcion == 1) {
		                        misEntradas.remove(e);
		                        System.out.println("La Entrada con Id: " + id + " ha sido eliminado.");
		                    } else if(opcion==2){
		                        System.out.println("La Entrada no ha sido eliminado.");
		                    }
		                    break;
		                } else{
		                System.out.println("No se encontro ninguna Entrada con ese Id.");
		            }
		            
		            }
		        }
  
    public void modificarEntrada(){
              System.out.println("Digite el Id de la entrada que quiere modificar");
        int id = lector.nextInt();
        boolean encontrado = false;

        for (Entrada e : misEntradas) {
            if (e.getIdEntrada() == id) {
                System.out.println("Ingrese la nueva descripción:");
                lector.nextLine(); // Consume la nueva línea pendiente
                String nuevaDescripcion = lector.nextLine();
                e.setDescripcion(nuevaDescripcion);
                encontrado = true;
                System.out.println("Entrada modificada satisfactoriamente");
   
              break;   
            }
        }
        }
    //Entrada del Programa
    public static void main(String[] args) {
        //Crea un Objeto de la clase tienda1
        Diario organizador = new Diario();
        //Llama al metodo de mostrarmenu de Opciones para la ejecutacion
        organizador.mostrarMenu();
    }
}

        


