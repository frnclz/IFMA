#include <stdio.h>
#include <stdlib.h>
#include "AVLvsRB.h"

struct No{
  int info;
  int alt;
  struct No *esq;
  struct No *dir;
};

ArvAVL* cria_ArvAVL(){
    ArvAVL* raiz = (ArvAVL*)malloc(sizeof(ArvAVL));
    if(raiz != NULL)
        *raiz = NULL;
    return raiz;
}

void liberar_ArvAVL(ArvAVL* raiz) {
    if (raiz != NULL) {
        liberar_ArvAVL((*raiz)->esq);
        liberar_ArvAVL((*raiz)->dir);
        free(raiz);
    }
}

int alt_No(struct No* no){
    if(no == NULL)
        return - 1;
    else
        return no->alt;
}

int fatorBalanceamento_NO(struct No* no){
    return labs(alt_No(no->esq) - alt_No(no->dir));
}

int maior(int x, int y){
if(x > y)
    return x;
else
    return y;
}

struct No* procuraMenor(struct No* atual){
    struct No *no1 = atual, *no2 = atual->esq;
    while(no2 != NULL){
        no1 = no2;
        no2 = no2->esq;
    }
    return no1;
}

void RotacaoLL(ArvAVL *A){
  struct No *B;
    B = (*A)->esq;
     (*A)->esq = B->dir;
     B->dir = *A;
     (*A)->alt = maior(alt_No((*A)->esq),
                       alt_No((*A)->dir)) + 1;
     B->alt = maior(alt_No(B->esq), (*A)->alt) + 1;
     *A = B;
}

void RotacaoRR(ArvAVL* A){
    struct No* B;
    B = (*A)->dir;
    (*A)->dir = B->esq;
    B->esq = (*A);
    (*A)->alt = maior(alt_No((*A)->esq),
                      alt_No((*A)->dir)) + 1;
    B->alt = maior(alt_No(B->dir), (*A)->alt) + 1;
    (*A) = B;
}

void RotacaoLR(ArvAVL* A){
    RotacaoRR(&(*A)->esq);
    RotacaoLL(A);
}

void RotacaoRL(ArvAVL* raiz){
    RotacaoLL(&(*raiz)->dir);
    RotacaoRR(raiz);
}

int insere_ArvAVL(ArvAVL *raiz, int valor){
  int res;
    if(*raiz == NULL){
       struct No* novo;
       novo = (struct No*)malloc(sizeof(struct No));
       if(novo == NULL)
        return 0;

    novo->info = valor;
    novo ->alt = 0;
    novo->esq = NULL;
    novo->dir =NULL;
    *raiz = novo;
    return 1;
    }

struct No *atual = *raiz;
if(valor < atual->info){
    if((res = insere_ArvAVL(&(atual->esq), valor)) == 1){
        if(fatorBalanceamento_NO(atual) >= 2){
            if(valor < (*raiz)->esq->info)
                RotacaoLL(raiz);
            else
             RotacaoLR(raiz);
        }
    }
} else {
 if(valor > atual->info){
    if((res = insere_ArvAVL(&(atual->dir), valor)) == 1){
        if(fatorBalanceamento_NO(atual) >= 2){
            if((*raiz)->dir->info < valor)
                RotacaoRR(raiz);
            else
                RotacaoRL(raiz);
        }
    }
 } else
    return 0;
}
atual->alt=maior(alt_No(atual->esq), alt_No(atual->dir)) +1;
return res;
}

int remove_ArvAVL(ArvAVL *raiz, int valor){
    if(*raiz == NULL)
        return 0;
    int res;
    if(valor < (*raiz)->info){
        if((res = remove_ArvAVL (&(*raiz)->esq, valor)) == 1){
            if(fatorBalanceamento_NO(*raiz) >= 2){
                if(alt_No((*raiz)->dir->esq) <=
                   alt_No((*raiz)->dir->dir))
                    RotacaoRR(raiz);
                else
                 RotacaoRL;
            }
        }
    }
    if((*raiz)->info < valor){
        if((res = remove_ArvAVL(&(*raiz)->dir, valor)) == 1){
            if(fatorBalanceamento_NO(*raiz) >= 2){
                if(alt_No((*raiz)->esq->dir) <=
                   alt_No((*raiz)->esq->esq))
                   RotacaoLL(raiz);
                else
                    RotacaoLR(raiz);
            }
        }
    }
    if((*raiz)->info == valor){
        if(((*raiz)->esq == NULL || (*raiz)->dir == NULL)){
            struct No *oldNode = (*raiz);
            if((*raiz)->esq != NULL)
                *raiz = (*raiz)->esq;
            else
                *raiz = (*raiz)->dir;
            free(oldNode);
        } else{
        struct No* temp = procuraMenor((*raiz)->dir);
        (*raiz)->info = temp->info;
        remove_ArvAVL(&(*raiz)->dir, (*raiz)->info);
        if(fatorBalanceamento_NO(*raiz) >= 2){
            if(alt_No((*raiz)->esq->dir) <=
               alt_No((*raiz)->esq->esq))
                RotacaoLL(raiz);
            else
                RotacaoLR(raiz);
        }
         }
         if (*raiz != NULL)
            (*raiz) ->alt = maior(alt_No((*raiz)->esq),
                                     alt_No((*raiz)->dir))+1;
         return 1;
    }
    (*raiz)->alt=maior (alt_No((*raiz)->esq),
                           alt_No((*raiz)->dir))+1;
    return res;
}

int estaVazia_ArvAVL(ArvAVL* raiz) {
    return raiz == NULL;
}

int altura_ArvAVL(ArvAVL* raiz) {
    if (raiz == NULL || *raiz == NULL)
        return 0;
    return alt_No(*raiz);
}

int totalNO_ArvAVL(ArvAVL* raiz) {
    if (raiz == NULL)
        return 0;
    return 1 + totalNO_ArvAVL((*raiz)->esq) + totalNO_ArvAVL((*raiz)->dir);
}

int consulta_ArvAVL(ArvAVL* raiz, int valor) {
    if (raiz == NULL || *raiz == NULL)
        return 0;
    if (valor == (*raiz)->info)
        return 1;
    else if (valor < (*raiz)->info)
        return consulta_ArvAVL(&((*raiz)->esq), valor);
    else
        return consulta_ArvAVL(&((*raiz)->dir), valor);
}

void preOrdem_ArvAVL(ArvAVL* raiz) {
    if (raiz != NULL) {
        printf("%d ", (*raiz)->info);
        preOrdem_ArvAVL((*raiz)->esq);
        preOrdem_ArvAVL((*raiz)->dir);
    }
}

void emOrdem_ArvAVL(ArvAVL* raiz) {
    if (raiz != NULL) {
        emOrdem_ArvAVL((*raiz)->esq);
        printf("%d ", (*raiz)->info);
        emOrdem_ArvAVL((*raiz)->dir);
    }
}

void posOrdem_ArvAVL(ArvAVL* raiz) {
    if (raiz != NULL) {
        posOrdem_ArvAVL((*raiz)->esq);
        posOrdem_ArvAVL((*raiz)->dir);
        printf("%d ", (*raiz)->info);
    }
}
