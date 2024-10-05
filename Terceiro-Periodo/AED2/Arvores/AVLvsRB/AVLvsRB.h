#ifndef AVLVSRB_H_INCLUDED
#define AVLVSRB_H_INCLUDED
#ifndef AVLVSBIN_H_INCLUDED
#define AVLVSBIN_H_INCLUDED

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

typedef enum { vermelho, preto } node_cor;

typedef struct Node{
    int chave;
    node_cor cor;
    struct Node *pai;
    struct Node *esq;
    struct Node *dir;
} Node;

typedef struct ArvRB {
    Node *root;
    Node *nil;
} ArvRB;

ArvRB *cria_ArvRB();
void remove_ArvRB(ArvRB *arv);
void insere_ArvRB(ArvRB *arv, int chave);
void libera_ArvRB(ArvRB *arv, int chave);
Node *busca_ArvRB(ArvRB *arv, int chave);
void imprime_ArvRB(ArvRB *arv);

#endif // AVLVSBIN_H_INCLUDED



#endif // AVLVSRB_H_INCLUDED
