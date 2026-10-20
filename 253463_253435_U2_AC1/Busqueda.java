public class Busqueda {

    public static int buscar(int listaOriginal[], int valorBuscado, int inferior, int superior) {
        int central;
        if (inferior > superior) {
            return -1;
        }
        else {
            central = (inferior + superior) / 2;
            if (listaOriginal[central] == valorBuscado)
                return central;
            else if (listaOriginal[central] < valorBuscado)
                return buscar(listaOriginal, valorBuscado, central + 1, superior);
            else
                return buscar(listaOriginal, valorBuscado, inferior, central - 1);
        }
    }

}