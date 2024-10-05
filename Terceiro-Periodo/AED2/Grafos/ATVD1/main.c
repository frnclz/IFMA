#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include "GrafoTeste.h"

int main() {setlocale(LC_ALL, "");
    // Cria��o do grafo
    Grafo* gr = cria_Grafo(450, 450, 1); // N�mero de v�rtices e arestas
    if (gr == NULL) {
        perror("Erro ao criar o grafo");
        return EXIT_FAILURE;
    }

    // L� o arquivo e constr�i o grafo
    le_e_constroi_grafo("Benchmark-grafo.txt", gr);

    // Imprime os primeiros 10 v�rtices e seus pesos
    imprime(gr);

    libera_Grafo(gr);

    return EXIT_SUCCESS;
}
