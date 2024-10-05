#include <stdio.h>
#include <stdlib.h>
#include "AVLvsBIN.h"
#include <time.h>
#include <locale.h>

#define NUM_ELEMENTOS 5000000

int main() {setlocale(LC_ALL, "");
    int *lista_elementos = (int *)malloc(NUM_ELEMENTOS * sizeof(int));
    if (lista_elementos == NULL) {
        printf("Erro ao alocar memória para a lista de elementos.\n");
        return EXIT_FAILURE;
    }

    srand(time(NULL));
    for (int i = 0; i < NUM_ELEMENTOS; i++) {
        lista_elementos[i] = rand() % 1000000;
    }

    ArvBin *minha_arvore = criar_arvore();
    clock_t inicio_binaria = clock();
    for (int i = 0; i < NUM_ELEMENTOS; i++) {
        inserir_arvore(minha_arvore, lista_elementos[i]);
    }
    clock_t fim_binaria = clock();
    double tempoBin = (double)(fim_binaria - inicio_binaria) / CLOCKS_PER_SEC;
    printf("Tempo de inserção na árvore binária: %.6f segundos\n", tempoBin);
    liberar_arvore(minha_arvore);

    ArvAVL *arvore_avl = cria_ArvAVL();
    clock_t inicio_avl = clock();
    for (int i = 1; i < NUM_ELEMENTOS; i++) {
        insere_ArvAVL(arvore_avl, lista_elementos[i]);
    }
    clock_t fim_avl = clock();
    double tempo_avl = (double)(fim_avl - inicio_avl) / CLOCKS_PER_SEC;
    printf("Tempo de inserção na árvore AVL: %.6f segundos\n", tempo_avl);
    liberar_ArvAVL(arvore_avl);


    free(lista_elementos);
    return EXIT_SUCCESS;
}
