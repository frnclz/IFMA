#include <stdio.h>
#include <stdlib.h>
#include "AVLvsBIN.h"

struct No{
  int info;
  struct No *esq;
  struct No *dir;
};

ArvBin* criar_arvore(){
    ArvBin* raiz = (ArvBin*) malloc(sizeof(ArvBin));
    if (raiz != NULL)
        *raiz = NULL;
    return raiz;
}

void liberar_no(struct No* no){
    if(no == NULL)
        return;
    liberar_no(no->esq);
    liberar_no(no->dir);
    free(no);
    no = NULL;
}

void liberar_arvore(ArvBin* raiz){
    if(raiz == NULL)
        return;
    liberar_no(*raiz);
    free(raiz);
}

int arvore_vazia(ArvBin *raiz){
    if (raiz == NULL)
        return 1;
    if (*raiz == NULL)
        return 1;
    return 0;
}

int total_nos(ArvBin *raiz){
    if(raiz==NULL)
        return 0;
    if(*raiz == NULL)
        return 0;
    int total_esq = total_nos(&((*raiz)->esq));
    int total_dir = total_nos(&((*raiz)->dir));
    return (total_esq + total_dir + 1);
}

int altura_arvore(ArvBin *raiz){
    if (raiz == NULL)
        return 0;
    if (*raiz == NULL)
        return 0;
    int alt_esq = altura_arvore(&((*raiz)->esq));
    int alt_dir = altura_arvore(&((*raiz)->dir));
    if (alt_esq > alt_dir)
        return (alt_esq + 1);
    else
        return (alt_dir + 1);
}

void preOrdem(ArvBin *raiz){
    if(raiz == NULL)
        return;

    if(*raiz != NULL){
        printf("%d ", (*raiz)->info);
        preOrdem(&((*raiz)->esq));
        preOrdem(&((*raiz)->dir));
    }
}

void emOrdem(ArvBin *raiz){
    if(raiz == NULL)
        return;
    if(*raiz != NULL){
        emOrdem(&((*raiz)->esq));
        printf("%d ", (*raiz)->info);
        emOrdem(&((*raiz)->dir));
    }
}


void posOrdem(ArvBin *raiz){
    if(raiz == NULL)
        return;
    if(*raiz != NULL){
        posOrdem(&((*raiz)->esq));
        posOrdem(&((*raiz)->dir));
        printf("%d ", (*raiz)->info);
    }
}

int inserir_arvore(ArvBin* raiz, int valor){
    if(raiz == NULL)
        return 0;
    struct No *novo;
    novo = (struct No*) malloc(sizeof(struct No));
    if (novo == NULL)
        return 0;
    novo->info = valor;
    novo->esq = NULL;
    novo->dir = NULL;

    if(*raiz == NULL)
        *raiz = novo;
    else{
        struct No* atual = *raiz;
        struct No* ant = NULL;
        while(atual != NULL){
            ant = atual;
            if(valor == atual->info){
                free(novo);
                return 0;
            }
            if(valor > atual->info)
                atual = atual->dir;
            else
                atual = atual->esq;
        }
        if (valor > ant->info)
            ant->dir = novo;
        else
            ant->esq = novo;
    }
    return 1;
}

struct No* remover_atual(struct No* atual){
    struct No *no1, *no2;
    if(atual->esq == NULL){
        no2 = atual->dir;
        free(atual);
        return no2;
    }
    no1 = atual;
    no2 = atual->esq;
    while(no2->dir != NULL){
        no1 = no2;
        no2 = no2->dir;
    }
    if(no1 != atual){
        no1->dir = no2->esq;
        no2->esq = atual->esq;
    }
    no2->dir = atual->dir;
    free(atual);
    return no2;
}

int remover_arvore(ArvBin *raiz, int valor){
    if(raiz == NULL)
        return 0;
    struct No *ant = NULL;
    struct No *atual = *raiz;
    while(atual != NULL){
        if(valor == atual->info){
            if (valor == (*raiz)->info)
                *raiz = remover_atual(atual);
            else{
                if(ant->dir == atual)
                    ant->dir = remover_atual(atual);
                else
                    ant->esq = remover_atual(atual);
            }
            return 1;
        }
        ant = atual;
        if(valor > atual->info)
            atual = atual->dir;
        else
            atual = atual->esq;
    }
    return 0;
}

int consulta_arvore(ArvBin *raiz, int valor){
    if(raiz == NULL)
        return 0;
    struct No* atual = *raiz;
    while(atual != NULL){
        if(valor == atual->info)
            return 1;
        if(valor > atual->info)
            atual = atual->dir;
        else
            atual = atual->esq;
    }
    return 0;
}

int par_arv(ArvBin *raiz){
    if(raiz == NULL){
        return 0;
    }
    int contpar = 0;

    if(*raiz != NULL){
        contpar += par_arv(&((*raiz)->dir));
        contpar += par_arv(&((*raiz)->esq));

        if((*raiz)->info % 2 == 0){
            contpar+=1;
        }
    }
    return contpar;
}
