#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>
#include "ATV3.h"


typedef struct {
    int origem, destino;
    float peso;
} Aresta;

    Grafo* cria_Grafo(int nro_vert, int Gmax, int eh_ponderado) {
    Grafo *gr;
    gr = (Grafo*) malloc(sizeof(struct grafo));
    if(gr != NULL) {
        int i;
        gr->nro_vert = nro_vert;
        gr->Gmax = Gmax;
        gr->eh_ponderado = (eh_ponderado != 0) ? 1 : 0;
        gr->grau = (int*)calloc(nro_vert, sizeof(int));

        gr->arestas = (int**)malloc(nro_vert * sizeof(int*));
        for(i = 0; i < nro_vert; i++)
            gr->arestas[i] = (int*)malloc(Gmax * sizeof(int));

        if(gr->eh_ponderado) {
            gr->pesos = (float**)malloc(nro_vert * sizeof(float*));
            for(i = 0; i < nro_vert; i++)
                gr->pesos[i] = (float*)malloc(Gmax * sizeof(float));
        }
    }
    return gr;
}

void libera_Grafo(Grafo* gr) {
    if(gr != NULL) {
        int i;
        for(i = 0; i < gr->nro_vert; i++)
            free(gr->arestas[i]);
        free(gr->arestas);

        if(gr->eh_ponderado) {
            for(i = 0; i < gr->nro_vert; i++)
                free(gr->pesos[i]);
            free(gr->pesos);
        }
        free(gr->grau);
        free(gr);
    }
}

int insereAresta(Grafo* gr, int orig, int dest, int digrafo, float peso) {
    if(gr == NULL)
        return 0;
    if(orig < 0 || orig >= gr->nro_vert)
        return 0;
    if(dest < 0 || dest >= gr->nro_vert)
        return 0;

    if(gr->grau[orig] == gr->Gmax)
        return 0;

    gr->arestas[orig][gr->grau[orig]] = dest;
    if(gr->eh_ponderado)
        gr->pesos[orig][gr->grau[orig]] = peso;

    gr->grau[orig]++;
    if(digrafo == 0)
        return insereAresta(gr, dest, orig, 1, peso);
    return 1;
}

int removeAresta(Grafo* gr, int orig, int dest, int eh_digrafo) {
    if (gr == NULL)
        return 0;    if (orig < 0 || orig >= gr->nro_vert)
        return 0;
    if (dest < 0 || dest >= gr->nro_vert)
        return 0;

    int i = 0;
    while (i < gr->grau[orig] && gr->arestas[orig][i] != dest)
        i++;

    if (i == gr->grau[orig]) // elemento não encontrado
        return 0;

    gr->grau[orig]--;
    gr->arestas[orig][i] = gr->arestas[orig][gr->grau[orig]];

    if (gr->eh_ponderado)
        gr->pesos[orig][i] = gr->pesos[orig][gr->grau[orig]];

    if (eh_digrafo == 0)
        removeAresta(gr, dest, orig, 1);

    return 1;
}

void le_e_constroi_grafo(const char* arquivo, Grafo* gr) {
    FILE* fp = fopen(arquivo, "r");
    if (fp == NULL) {
        perror("Erro ao abrir o arquivo");
        return;
    }

    int nro_vert, nro_arestas;
    fscanf(fp, "%d %d", &nro_vert, &nro_arestas);

    int* coords_x = (int*)malloc(nro_vert * sizeof(int));
    int* coords_y = (int*)malloc(nro_vert * sizeof(int));

    // Leitura das coordenadas dos vértices
    for (int i = 0; i < nro_vert; i++) {
        fscanf(fp, "%*s %d %d", &coords_x[i], &coords_y[i]);
        //printf("Coordenadas do vértice %d: (%d, %d)\n", i + 1, coords_x[i], coords_y[i]);
    }

    // Construção do grafo
    for (int i = 0; i < nro_vert; i++) {
        for (int j = i + 1; j < nro_vert; j++) {
            int xd = coords_x[i] - coords_x[j];
            int yd = coords_y[i] - coords_y[j];
            float dist = round(sqrt(xd * xd + yd * yd));
            if (dist > 0) {
                insereAresta(gr, i, j, 0, dist);
                insereAresta(gr, j, i, 0, dist); // Como não é um digrafo
            }
            //printf("Distância entre %d e %d: %f\n", i + 1, j + 1, dist);
        }
    }

    free(coords_x);
    free(coords_y);
    fclose(fp);
}

#define INF 100 // valor muito alto

void Prim(Grafo* gr, int start) {
    int n = gr->nro_vert;
    int* visitado = (int*)calloc(n, sizeof(int));
    int* pai = (int*)malloc(n * sizeof(int));
    float* custo = (float*)malloc(n * sizeof(float));

    for (int i = 0; i < n; i++) {
        custo[i] = INF;
        pai[i] = -1;
    }

    custo[start] = 0;

    for (int i = 0; i < n; i++) {
        int u = -1;
        for (int j = 0; j < n; j++) {
            if (!visitado[j] && (u == -1 || custo[j] < custo[u]))
                u = j;
        }

        visitado[u] = 1;

        for (int j = 0; j < gr->grau[u]; j++) {
            int v = gr->arestas[u][j];
            float peso = gr->pesos[u][j];

            if (!visitado[v] && peso < custo[v]) {
                custo[v] = peso;
                pai[v] = u;
            }
        }
    }

    printf("Árvore Mínima\n");
    for (int i = 1; i < n; i++) {
        printf("%d - %d (Peso: %2.f)\n", pai[i] + 1, i + 1, custo[i]);
    }

    free(visitado);
    free(pai);
    free(custo);
}

int comparaArestas(const void* a, const void* b) {
    Aresta* arestaA = (Aresta*)a;
    Aresta* arestaB = (Aresta*)b;
    return (arestaA->peso > arestaB->peso) - (arestaA->peso < arestaB->peso);
}

int encontra(int* conjunto, int vertice) {
    if (conjunto[vertice] == vertice)
        return vertice;
    return conjunto[vertice] = encontra(conjunto, conjunto[vertice]);
}

void une(int* conjunto, int* rank, int v1, int v2) {
    v1 = encontra(conjunto, v1);
    v2 = encontra(conjunto, v2);
    if (rank[v1] < rank[v2])
        conjunto[v1] = v2;
    else if (rank[v1] > rank[v2])
        conjunto[v2] = v1;
    else {
        conjunto[v2] = v1;
        rank[v1]++;
    }
}

void Kruskal(Grafo* gr) {
    int n = gr->nro_vert;
    Aresta* arestas = (Aresta*)malloc(gr->Gmax * sizeof(Aresta));
    int* conjunto = (int*)malloc(n * sizeof(int));
    int* rank = (int*)calloc(n, sizeof(int));

    int k = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < gr->grau[i]; j++) {
            if (i < gr->arestas[i][j]) {
                arestas[k].origem = i;
                arestas[k].destino = gr->arestas[i][j];
                arestas[k].peso = gr->pesos[i][j];
                k++;
            }
        }
    }

    qsort(arestas, k, sizeof(Aresta), comparaArestas);

    for (int i = 0; i < n; i++)
        conjunto[i] = i;

    printf("Árvore Mínima\n");
    int contador = 0;
    for (int i = 0; i < k && contador < n - 1; i++) {
        int u = arestas[i].origem;
        int v = arestas[i].destino;
        float peso = arestas[i].peso;

        if (encontra(conjunto, u) != encontra(conjunto, v)) {
            printf("%d - %d (Peso: %2.f)\n", u + 1, v + 1, peso);
            une(conjunto, rank, u, v);
            contador++;
        }
    }

    free(arestas);
    free(conjunto);
    free(rank);
}
