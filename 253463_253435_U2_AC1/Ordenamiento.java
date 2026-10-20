public class Ordenamiento {

    public static void intercambiar(int listaOriginal[], int i, int j) {
        int aux = listaOriginal[i];
        listaOriginal[i] = listaOriginal[j];
        listaOriginal[j] = aux;
    }

    public static void ordenarQuicksort(int listaOriginal[], int inferior, int superior) {
        int i, j, central;
        double pivote;
        central = (inferior + superior) / 2;
        pivote = listaOriginal[central];
        i = inferior;
        j = superior;

        System.out.println("Limites que se analizan. Inferior: " + i + " Superior: " + j + " Pivote: " + pivote);

        do {
            while (listaOriginal[i] < pivote) i++;
            while (listaOriginal[j] > pivote) j--;
            if (i <= j) {
                intercambiar(listaOriginal, i, j);
                i++;
                j--;
            }
        } while (i <= j);
        if (inferior < j) {
            ordenarQuicksort(listaOriginal, inferior, j); //recursividad, mismo proceso con subconjunto izquierdo
        }
        if (i < superior) {
            ordenarQuicksort(listaOriginal, i, superior); //recursividad, mismo proceso con subconjunto derecho
        }
    }

}