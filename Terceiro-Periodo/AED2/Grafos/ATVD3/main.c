#include "ATV3.h"
#include <locale.h>

int main() {setlocale(LC_ALL, "");

    Grafo* gr = cria_Grafo(20, 20, 1);
    le_e_constroi_grafo("grafo_modificado.txt", gr);

    printf("Algoritmo de Prim:\n");
    Prim(gr, 0);

    printf("\nAlgoritmo de Kruskal:\n");
    Kruskal(gr);

    libera_Grafo(gr);
    return 0;
}
