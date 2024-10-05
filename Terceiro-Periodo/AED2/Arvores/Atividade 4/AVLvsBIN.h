#ifndef AVLVSBIN_H_INCLUDED
#define AVLVSBIN_H_INCLUDED

typedef struct No *ArvBin;

ArvBin* criar_arvore();
void liberar_arvore(ArvBin *raiz);
int inserir_arvore(ArvBin * raiz, int valor);
int remover_arvore(ArvBin * raiz, int valor);
int arvore_vazia(ArvBin * raiz);
int altura_arvore(ArvBin * raiz);
int total_nos(ArvBin *raiz);
int consulta_arvore(ArvBin * raiz, int valor);
void preOrdem(ArvBin* raiz);
void emOrdem(ArvBin* raiz);
void posOrdem(ArvBin* raiz);
int par_arv(ArvBin *raiz);

typedef struct No* ArvAVL;

ArvAVL* cria_ArvAVL();
void liberar_ArvAVL(ArvAVL *raiz);
int insere_ArvAVL(ArvAVL * raiz, int valor);
int remove_ArvAVL(ArvAVL * raiz, int valor);
int estaVazia_ArvAVL(ArvAVL *raiz);
int altura_ArvAVL(ArvAVL * raiz);
int totalNO_ArvAVL(ArvAVL *raiz);
int consulta_ArvAVL(ArvAVL * raiz, int valor);
void preOrdem_ArvAVL(ArvAVL* raiz);
void emOrdem_ArvAVL(ArvAVL* raiz);
void posOrdem_ArvAVL(ArvAVL* raiz);


#endif // AVLVSBIN_H_INCLUDED
