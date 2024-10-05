#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include "GrafoTeste.h"

int main() {setlocale(LC_ALL, "");
    // Criação do grafo
    Grafo* gr = cria_Grafo(450, 450, 1); // Número de vértices e arestas
    if (gr == NULL) {
        perror("Erro ao criar o grafo");
        return EXIT_FAILURE;
    }

    // Lê o arquivo e constrói o grafo
    le_e_constroi_grafo("Benchmark-grafo.txt", gr);

    // Imprime os primeiros 10 vértices e seus pesos
    imprime(gr);

    libera_Grafo(gr);

    return EXIT_SUCCESS;
}
