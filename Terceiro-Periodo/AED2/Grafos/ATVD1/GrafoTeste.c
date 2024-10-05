#include <stdio.h>
#include <stdlib.h>
#include "GrafoTeste.h"

struct grafo{
    int eh_ponderado;
    int nro_vert;
    int Gmax;
    int** arestas;
    float** pesos;
    int* grau;
};

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
        printf("Coordenadas do vértice %d: (%d, %d)\n", i + 1, coords_x[i], coords_y[i]);
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
            printf("Distância entre %d e %d: %f\n", i + 1, j + 1, dist);
        }
    }

    free(coords_x);
    free(coords_y);
    fclose(fp);
}

void imprime(const Grafo* gr) {
    printf("Imprimindo os primeiros 10 vértices e seus pesos:\n");
    for (int i = 0; i < 10 && i < gr->nro_vert; i++) {
        printf("Vértice %d:\n", i + 1);
        for (int j = 0; j < gr->grau[i]; j++) {
            int adj = gr->arestas[i][j];
            float peso = gr->eh_ponderado ? gr->pesos[i][j] : 0.0;
            printf("  -> Vértice %d, Peso: %.2f\n", adj + 1, peso);
        }
    }
}
