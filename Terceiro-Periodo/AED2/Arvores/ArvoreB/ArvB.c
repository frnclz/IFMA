#include <stdio.h>
#include <stdlib.h>
#include "ArvB.h"

NoArvB *criarNo(int m, bool folha) {
    NoArvB *node = (NoArvB *)malloc(sizeof(NoArvB));
    node->m = m;
    node->folha = folha;
    node->chave = (int *)malloc(sizeof(int) * (2 * m - 1));
    node->F = (NoArvB **)malloc(sizeof(NoArvB *) * (2 * m));
    node->n = 0;
    return node;
}

void traverse(NoArvB *raiz) {
    int i;
    for (i = 0; i < raiz->n; i++) {
        if (!raiz->folha) {
            traverse(raiz->F[i]);
        }
        printf(" %d", raiz->chave[i]);
    }
    if (!raiz->folha) {
        traverse(raiz->F[i]);
    }
}

NoArvB *search(NoArvB *raiz, int k) {
    int i = 0;
    while (i < raiz->n && k > raiz->chave[i]) {
        i++;
    }
    if (raiz->chave[i] == k) {
        return raiz;
    }
    if (raiz->folha) {
        return NULL;
    }
    return search(raiz->F[i], k);
}

void split(NoArvB *x, int i, NoArvB *y) {
    int m = y->m;
    NoArvB *z = criarNo(m, y->folha);
    z->n = m - 1;

    for (int j = 0; j < m - 1; j++) {
        z->chave[j] = y->chave[j + m];
    }

    if (!y->folha) {
        for (int j = 0; j < m; j++) {
            z->F[j] = y->F[j + m];
        }
    }

    y->n = m - 1;

    for (int j = x->n; j >= i + 1; j--) {
        x->F[j + 1] = x->F[j];
    }

    x->F[i + 1] = z;

    for (int j = x->n - 1; j >= i; j--) {
        x->chave[j + 1] = x->chave[j];
    }

    x->chave[i] = y->chave[m - 1];
    x->n = x->n + 1;
}

void insertNonFull(NoArvB *x, int k) {
    int i = x->n - 1;

    if (x->folha) {
        while (i >= 0 && x->chave[i] > k) {
            x->chave[i + 1] = x->chave[i];
            i--;
        }
        x->chave[i + 1] = k;
        x->n = x->n + 1;
    } else {
        while (i >= 0 && x->chave[i] > k) {
            i--;
        }
        if (x->F[i + 1]->n == 2 * x->m - 1) {
            split(x, i + 1, x->F[i + 1]);
            if (x->chave[i + 1] < k) {
                i++;
            }
        }
        insertNonFull(x->F[i + 1], k);
    }
}

void insert(NoArvB **raiz, int k) {
    NoArvB *r = *raiz;
    if (r->n == 2 * r->m - 1) {
        NoArvB *s = criarNo(r->m, false);
        s->F[0] = r;
        split(s, 0, r);
        int i = 0;
        if (s->chave[0] < k) {
            i++;
        }
        insertNonFull(s->F[i], k);
        *raiz = s;
    } else {
        insertNonFull(r, k);
    }
}

int encontrarChave(NoArvB *raiz, int k) {
    int idx = 0;
    while (idx < raiz->n && raiz->chave[idx] < k) {
        ++idx;
    }
    return idx;
}

void removeChave(NoArvB *raiz, int k) {
    int idx = encontrarChave(raiz, k);

    if (idx < raiz->n && raiz->chave[idx] == k) {
        if (raiz->folha) {
            for (int i = idx + 1; i < raiz->n; ++i) {
                raiz->chave[i - 1] = raiz->chave[i];
            }
            raiz->n--;
        } else {
            if (raiz->F[idx]->n >= raiz->m) {
                NoArvB *cur = raiz->F[idx];
                while (!cur->folha) {
                    cur = cur->F[cur->n];
                }
                int pred = cur->chave[cur->n - 1];
                raiz->chave[idx] = pred;
                removeChave(raiz->F[idx], pred);
            } else if (raiz->F[idx + 1]->n >= raiz->m) {
                NoArvB *cur = raiz->F[idx + 1];
                while (!cur->folha) {
                    cur = cur->F[0];
                }
                int succ = cur->chave[0];
                raiz->chave[idx] = succ;
                removeChave(raiz->F[idx + 1], succ);
            } else {
                NoArvB *child = raiz->F[idx];
                NoArvB *sibling = raiz->F[idx + 1];
                child->chave[raiz->m - 1] = raiz->chave[idx];
                for (int i = 0; i < sibling->n; ++i) {
                    child->chave[i + raiz->m] = sibling->chave[i];
                }
                if (!child->folha) {
                    for (int i = 0; i <= sibling->n; ++i) {
                        child->F[i + raiz->m] = sibling->F[i];
                    }
                }
                for (int i = idx + 1; i < raiz->n; ++i) {
                    raiz->chave[i - 1] = raiz->chave[i];
                }
                for (int i = idx + 2; i <= raiz->n; ++i) {
                    raiz->F[i - 1] = raiz->F[i];
                }
                child->n += sibling->n + 1;
                raiz->n--;
                free(sibling->chave);
                free(sibling->F);
                free(sibling);
                removeChave(child, k);
            }
        }
    } else {
        if (raiz->folha) {
            return;
        }
        bool flag = ((idx == raiz->n) ? true : false);
        if (raiz->F[idx]->n < raiz->m) {
            NoArvB *child = raiz->F[idx];
            NoArvB *sibling = (idx != raiz->n) ? raiz->F[idx + 1] : raiz->F[idx - 1];
            if (sibling->n >= raiz->m) {
                if (idx != raiz->n) {
                    for (int i = child->n - 1; i >= 0; --i) {
                        child->chave[i + 1] = child->chave[i];
                    }
                    if (!child->folha) {
                        for (int i = child->n; i >= 0; --i) {
                            child->F[i + 1] = child->F[i];
                        }
                    }
                    child->chave[0] = raiz->chave[idx];
                    if (!child->folha) {
                        child->F[0] = sibling->F[sibling->n];
                    }
                    raiz->chave[idx] = sibling->chave[sibling->n - 1];
                    child->n++;
                    sibling->n--;
                } else {
                    child->chave[child->n] = raiz->chave[idx - 1];
                    if (!child->folha) {
                        child->F[child->n + 1] = sibling->F[0];
                    }
                    raiz->chave[idx - 1] = sibling->chave[0];
                    for (int i = 1; i < sibling->n; ++i) {
                        sibling->chave[i - 1] = sibling->chave[i];
                    }
                    if (!sibling->folha) {
                        for (int i = 1; i <= sibling->n; ++i) {
                            sibling->F[i - 1] = sibling->F[i];
                        }
                    }
                    child->n++;
                    sibling->n--;
                }
            } else {
                if (idx != raiz->n) {
                    child->chave[child->n] = raiz->chave[idx];
                    for (int i = 0; i < sibling->n; ++i) {
                        child->chave[i + child->n + 1] = sibling->chave[i];
                    }
                    if (!child->folha) {
                        for (int i = 0; i <= sibling->n; ++i) {
                            child->F[i + child->n + 1] = sibling->F[i];
                        }
                    }
                    for (int i = idx + 1; i < raiz->n; ++i) {
                        raiz->chave[i - 1] = raiz->chave[i];
                    }
                    for (int i = idx + 2; i <= raiz->n; ++i) {
                        raiz->F[i - 1] = raiz->F[i];
                    }
                    child->n += sibling->n + 1;
                    raiz->n--;
                    free(sibling->chave);
                    free(sibling->F);
                    free(sibling);
                } else {
                    sibling->chave[sibling->n] = raiz->chave[idx - 1];
                    for (int i = 0; i < child->n; ++i) {
                        sibling->chave[i + sibling->n + 1] = child->chave[i];
                    }
                    if (!sibling->folha) {
                        for (int i = 0; i <= child->n; ++i) {
                            sibling->F[i + sibling->n + 1] = child->F[i];
                        }
                    }
                    raiz->n--;
                    free(child->chave);
                    free(child->F);
                    free(child);
                }
            }
        }
        if (flag && idx > raiz->n) {
            removeChave(raiz->F[idx - 1], k);
        } else {
            removeChave(raiz->F[idx], k);
        }
    }
}

int altura(NoArvB *raiz) {
    if (raiz == NULL) {
        return 0;
    }
    if (raiz->folha) {
        return 1;
    }
    return 1 + altura(raiz->F[0]);
}

void printArvoreB(NoArvB *raiz, int nivel) {
    if (raiz == NULL) return;

    for (int i = 0; i < raiz->n; i++) {
        if (!raiz->folha) {
            printArvoreB(raiz->F[i], nivel + 1);
        }
        for (int j = 0; j < nivel; j++) {
            printf("   ");
        }
        printf("%d\n", raiz->chave[i]);
    }
    if (!raiz->folha) {
        printArvoreB(raiz->F[raiz->n], nivel + 1);
    }
}
