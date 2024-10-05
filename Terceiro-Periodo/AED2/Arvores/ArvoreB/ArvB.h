#ifndef ARVB_H_INCLUDED
#define ARVB_H_INCLUDED

#include <stdbool.h>


typedef struct NoArvB {
    int *chave;
    int m;
    struct NoArvB **F;
    int n;
    bool folha;
} NoArvB;

NoArvB *criarNo(int t, bool folha);
void traverse(NoArvB *raiz);
NoArvB *search(NoArvB *raiz, int k);
void insert(NoArvB **raiz, int k);
void removeChave(NoArvB *raiz, int k);


#endif // ARVB_H_INCLUDED
