#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "AVLvsRB.h"
#include <locale.h>

#define OPERACOES 1560320

int main() { setlocale(LC_ALL, "");

    ArvAVL *arvoreAVL = cria_ArvAVL();
    ArvRB *arvoreRB = cria_ArvRB();

    srand(time(NULL));

    clock_t inicio, fim;
    double tempoAVL, tempoRB;

    // Inserção
    printf("Inserindo elementos nas árvores AVL e RB...\n");
    /*inicio = clock();
    for (int i = 0; i < OPERACOES; i++) {
        int valor = rand() % OPERACOES;
        insere_ArvAVL(arvoreAVL, valor);
    }
    fim = clock();
    tempoAVL = ((double)(fim - inicio)) / CLOCKS_PER_SEC;
*/
    inicio = clock();
    for (int i = 0; i < OPERACOES; i++) {
        int valor = rand() % OPERACOES;
        insere_ArvRB(arvoreRB, valor);
    }
    fim = clock();
    tempoRB = ((double)(fim - inicio)) / CLOCKS_PER_SEC;

    printf("Tempo de inserção (AVL): %.6f segundos\n", tempoAVL);
    printf("Tempo de inserção (RB): %.6f segundos\n", tempoRB);

    // Busca
 /*   printf("\nBuscando elementos nas árvores AVL e RB...\n");
    int encontradosAVL = 0, encontradosRB = 0;
    inicio = clock();
    for (int i = 0; i < OPERACOES; i++) {
        int valor = rand() % OPERACOES;
        encontradosAVL += consulta_ArvAVL(arvoreAVL, valor);
    }
    fim = clock();
    tempoAVL = ((double)(fim - inicio)) / CLOCKS_PER_SEC;

    inicio = clock();
    for (int i = 0; i < OPERACOES; i++) {
        int valor = rand() % OPERACOES;
        Node *resultado = busca_ArvRB(arvoreRB, valor);
        if (resultado != NULL)
            encontradosRB++;
    }
    fim = clock();
    tempoRB = ((double)(fim - inicio)) / CLOCKS_PER_SEC;

    printf("Tempo de busca (AVL): %.6f segundos\n", tempoAVL);
    printf("Tempo de busca (RB): %.6f segundos\n", tempoRB);

    printf("\nTotal de elementos encontrados (AVL): %d\n", encontradosAVL);
    printf("Total de elementos encontrados (RB): %d\n", encontradosRB);
*/
    // Altura das árvores
    int alturaArvore = altura_ArvAVL(arvoreAVL);
    int alturaArvore2 = altura_ArvRB(arvoreRB->root, arvoreRB->nil);
    printf("\nAltura da árvore AVL: %d\n", alturaArvore);
    printf("Altura da árvore RB: %d\n", alturaArvore2);

    // Liberar memória
    liberar_ArvAVL(arvoreAVL);
    remove_ArvRB(arvoreRB);

    return 0;
}
