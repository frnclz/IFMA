#include <stdio.h>
#include <stdlib.h>
#include "AVLvsRB.h"

#define RED 0
#define BLACK 1

Node *criar_node(int chave) {
    Node *node = (Node *)malloc(sizeof(Node));
    if (node != NULL) {
        node->chave = chave;
        node->cor = RED;
        node->esq = NULL;
        node->dir = NULL;
        node->pai = NULL;
    }
    return node;
}

ArvRB *cria_ArvRB() {
    ArvRB *arv = (ArvRB *)malloc(sizeof(ArvRB));
    if (arv != NULL) {
        arv->nil = criar_node(-1);
        arv->nil->cor = BLACK;
        arv->root = arv->nil;
    }
    return arv;
}

void apagar_node(Node *node) {
    if (node != NULL) {
        apagar_node(node->esq);
        apagar_node(node->dir);
        free(node);
    }
}

void remove_ArvRB(ArvRB *arv) {
    apagar_node(arv->root);
    free(arv->nil);
    free(arv);
}

void rotacaoEsq(ArvRB *arv, Node *x) {
    Node *y = x->dir;
    x->dir = y->esq;
    if (y->esq != arv->nil)
        y->esq->pai = x;
    y->pai = x->pai;
    if (x->pai == arv->nil)
        arv->root = y;
    else if (x == x->pai->esq)
        x->pai->esq = y;
    else
        x->pai->dir = y;
    y->esq = x;
    x->pai = y;
}

void rotacaoDir(ArvRB *arv, Node *y) {
    Node *x = y->esq;
    y->esq = x->dir;
    if (x->dir != arv->nil)
        x->dir->pai = y;
    x->pai = y->pai;
    if (y->pai == arv->nil)
        arv->root = x;
    else if (y == y->pai->esq)
        y->pai->esq = x;
    else
        y->pai->dir = x;
    x->dir = y;
    y->pai = x;
}

void insere_ArvRB_fixup(ArvRB *arv, Node *z) {
    while (z->pai->cor == RED) {
        if (z->pai == z->pai->pai->esq) {
            Node *y = z->pai->pai->dir;
            if (y->cor == RED) {
                z->pai->cor = BLACK;
                y->cor = BLACK;
                z->pai->pai->cor = RED;
                z = z->pai->pai;
            } else {
                if (z == z->pai->dir) {
                    z = z->pai;
                    rotacaoEsq(arv, z);
                }
                z->pai->cor = BLACK;
                z->pai->pai->cor = RED;
                rotacaoDir(arv, z->pai->pai);
            }
        } else {
            Node *y = z->pai->pai->esq;
            if (y->cor == RED) {
                z->pai->cor = BLACK;
                y->cor = BLACK;
                z->pai->pai->cor = RED;
                z = z->pai->pai;
            } else {
                if (z == z->pai->esq) {
                    z = z->pai;
                    rotacaoDir(arv, z);
                }
                z->pai->cor = BLACK;
                z->pai->pai->cor = RED;
                rotacaoEsq(arv, z->pai->pai);
            }
        }
    }
    arv->root->cor = BLACK;
}

void insere_ArvRB(ArvRB *arv, int chave) {
    Node *z = criar_node(chave);
    Node *y = arv->nil;
    Node *x = arv->root;

    while (x != arv->nil) {
        y = x;
        if (z->chave < x->chave)
            x = x->esq;
        else
            x = x->dir;
    }

    z->pai = y;
    if (y == arv->nil)
        arv->root = z;
    else if (z->chave < y->chave)
        y->esq = z;
    else
        y->dir = z;

    z->esq = arv->nil;
    z->dir = arv->nil;
    z->cor = RED;

    insere_ArvRB_fixup(arv, z);
}

Node *busca_ArvRB(ArvRB *arv, int chave) {
    Node *atual = arv->root;
    while (atual != arv->nil) {
        if (chave == atual->chave)
            return atual;
        else if (chave < atual->chave)
            atual = atual->esq;
        else
            atual = atual->dir;
    }
    return arv->nil;
}

void rb_transplant(ArvRB *arv, Node *u, Node *v) {
    if (u->pai == arv->nil)
        arv->root = v;
    else if (u == u->pai->esq)
        u->pai->esq = v;
    else
        u->pai->dir = v;
    v->pai = u->pai;
}

void rb_delete_fixup(ArvRB *arv, Node *x) {
    while (x != arv->root && x->cor == BLACK) {
        if (x == x->pai->esq) {
            Node *w = x->pai->dir;
            if (w->cor == RED) {
                w->cor = BLACK;
                x->pai->cor = RED;
                rotacaoEsq(arv, x->pai);
                w = x->pai->dir;
            }
            if (w->esq->cor == BLACK && w->dir->cor == BLACK) {
                w->cor = RED;
                x = x->pai;
            } else {
                if (w->dir->cor == BLACK) {
                    w->esq->cor = BLACK;
                    w->cor = RED;
                    rotacaoDir(arv, w);
                    w = x->pai->dir;
                }
                w->cor = x->pai->cor;
                x->pai->cor = BLACK;
                w->dir->cor = BLACK;
                rotacaoEsq(arv, x->pai);
                x = arv->root;
            }
        } else {
            Node *w = x->pai->esq;
            if (w->cor == RED) {
                w->cor = BLACK;
                x->pai->cor = RED;
                rotacaoDir(arv, x->pai);
                w = x->pai->esq;
            }
            if (w->dir->cor == BLACK && w->esq->cor == BLACK) {
                w->cor = RED;
                x = x->pai;
            } else {
                if (w->esq->cor == BLACK) {
                    w->dir->cor = BLACK;
                    w->cor = RED;
                    rotacaoEsq(arv, w);
                    w = x->pai->esq;
                }
                w->cor = x->pai->cor;
                x->pai->cor = BLACK;
                w->esq->cor = BLACK;
                rotacaoDir(arv, x->pai);
                x = arv->root;
            }
        }
    }
    x->cor = BLACK;
}

void rb_delete(ArvRB *arv, int chave) {
    Node *z = busca_ArvRB(arv, chave);
    if (z == NULL)
        return;

    Node *y = z;
    node_cor original_cor = y->cor;
    Node *x;
    if (z->esq == arv->nil) {
        x = z->dir;
        rb_transplant(arv, z, z->dir);
    } else if (z->dir == arv->nil) {
        x = z->esq;
        rb_transplant(arv, z, z->esq);
    } else {
        y = z->dir;
        while (y->esq != arv->nil)
            y = y->esq;
        original_cor = y->cor;
        x = y->dir;
        if (y->pai == z)
            x->pai = y;
        else {
            rb_transplant(arv, y, y->dir);
            y->dir = z->dir;
            y->dir->pai = y;
        }
        rb_transplant(arv, z, y);
        y->esq = z->esq;
        y->esq->pai = y;
        y->cor = z->cor;
    }
    free(z);

    if (original_cor == BLACK)
        rb_delete_fixup(arv, x);
}

void ArvRB_print(Node *root, Node *nil) {
    if (root != nil) {
        ArvRB_print(root->esq, nil);
        printf("%d (%s)\n", root->chave, (root->cor == RED) ? "Red" : "Black");
        ArvRB_print(root->dir, nil);
    }
}

void imprime_ArvRB(ArvRB *arv) {
    ArvRB_print(arv->root, arv->nil);
}

int altura_ArvRB(Node *node, Node *nil) {
    if (node == nil) {
        return 0;
    }
    int esqAltura = altura_ArvRB(node->esq, nil);
    int dirAltura = altura_ArvRB(node->dir, nil);
    return 1 + (esqAltura > dirAltura ? esqAltura : dirAltura);
}

