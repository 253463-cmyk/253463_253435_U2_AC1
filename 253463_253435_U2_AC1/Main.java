import java.util.Scanner;

public class Main {

    public static void generarNumeros(int listaOriginal[]) {
        int number;
        System.out.println("Lista original:");
        for (int i = 0; i < listaOriginal.length; i++) {
            //Generar numeros entre 1 y 50
            number = (int) (Math.random() * 50 + 1);
            listaOriginal[i] = number;
            System.out.println(listaOriginal[i]);
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[] listaOriginal = new int[20];
        boolean numerosGenerados = false;
        boolean listaOrdenada = false;
        int opcion;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Generar numeros aleatorios");
            System.out.println("2. Ordenar");
            System.out.println("3. Buscar");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");
            opcion = teclado.nextInt();

            if (opcion == 1) {
                generarNumeros(listaOriginal);
                numerosGenerados = true;
                listaOrdenada = false;
            }
            else if (opcion == 2) {
                if (numerosGenerados == false) {
                    System.out.println("Primero genera los numeros (1)");
                } else {
                    Ordenamiento.ordenarQuicksort(listaOriginal, 0, listaOriginal.length - 1);
                    listaOrdenada = true;
                    System.out.println("Lista ordenada:");
                    for (int i = 0; i < listaOriginal.length; i++) {
                        System.out.println(listaOriginal[i]);
                    }
                }
            }
            else if (opcion == 3) {
                if (listaOrdenada == false) {
                    System.out.println("Primero genera (1) y ordena (2) la lista");
                } else {
                    System.out.print("Que numero quieres buscar? ");
                    int numeroABuscar = teclado.nextInt();
                    int posicion = Busqueda.buscar(listaOriginal, numeroABuscar, 0, listaOriginal.length - 1);

                    if (posicion == -1) {
                        System.out.println("El numero " + numeroABuscar + " no esta en el arreglo");
                    } else {
                        int mitad = listaOriginal.length / 2;
                        if (posicion < mitad) {
                            System.out.println("Encontrado en la posicion " + posicion + ", lado IZQUIERDO.");
                        } else {
                            System.out.println("Encontrado en la posicion " + posicion + ", lado DERECHO.");
                        }
                    }
                }
            }
            else if (opcion == 4) {
                System.out.println("Saliendo del programa...");
            }
            else {
                System.out.println("Opcion invalida");
            }

        } while (opcion != 4);

        teclado.close();
    }

}