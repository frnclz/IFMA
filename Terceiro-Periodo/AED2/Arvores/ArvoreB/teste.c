#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include "ArvB.h"

int teste(){
    NoArvB *raiz = criarNo(5, true);

    insert(&raiz, 1);
    insert(&raiz, 40);
    insert(&raiz, 5);
    insert(&raiz, 12);
    insert(&raiz, 34);
    insert(&raiz, 11);
    insert(&raiz, 60);
    insert(&raiz, 70);
    insert(&raiz, 13);
    insert(&raiz, 22);
    insert(&raiz, 16);
    insert(&raiz, 17);
    insert(&raiz, 18);
    insert(&raiz, 45);
    insert(&raiz, 47);
    insert(&raiz, 32);
    insert(&raiz, 43);
    insert(&raiz, 21);
    insert(&raiz, 38);
    insert(&raiz, 99);
    insert(&raiz, 100);
    insert(&raiz, 200);
    insert(&raiz, 130);
    insert(&raiz, 120);
    insert(&raiz, 155);
    insert(&raiz, 134);

    printf("Estrutura da árvore B:\n");
    printArvoreB(raiz, 0);
    printf("\n");

    int alturaArvore = altura(raiz);
    printf("Altura da árvore: %d\n\n", alturaArvore);
}
