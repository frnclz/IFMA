#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <locale.h>
#include "ArvB.h"

void testeArvoreB(int m, int numOperacoes) {
    NoArvB *raiz = criarNo(m, true);
    clock_t inicio, fim;
    double tempoInsercao, tempoBusca;

    inicio = clock();
    for (int i = 0; i < numOperacoes; i++) {
        int chave = rand();
        insert(&raiz, chave);
    }
    fim = clock();
    tempoInsercao = ((double) (fim - inicio)) / CLOCKS_PER_SEC;

    // Consulta
    inicio = clock();
    for (int i = 0; i < numOperacoes; i++) {
        int chave = rand();
        search(raiz, chave);
    }
    fim = clock();
    tempoBusca = ((double) (fim - inicio)) / CLOCKS_PER_SEC;

    int alturaArvore = altura(raiz);

    printf("Árvore B (m = %d):\n", m);
    printf("Número de operações: %d\n", numOperacoes);
    printf("Tempo de inserção: %.2f segundos\n", tempoInsercao);
    printf("Tempo de busca: %.6f segundos\n", tempoBusca);
    printf("Altura da árvore: %d\n\n", alturaArvore);
}

int main() { setlocale(LC_ALL, "Portuguese");
    srand(time(NULL));

    //printf("Teste com 1.000.000 de operações:\n");
    testeArvoreB(7, 100000);
    //esteArvoreB(10, 1000000);

    /*printf("Teste com 5.000.000 de operações:\n");
    testeArvoreB(5, 5000000);
    testeArvoreB(10, 5000000);*/

    return 0;
}
