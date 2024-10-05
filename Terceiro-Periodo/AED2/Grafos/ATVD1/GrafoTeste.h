#ifndef GRAFOTESTE_H_INCLUDED
#define GRAFOTESTE_H_INCLUDED

    typedef struct grafo Grafo;
    Grafo* cria_Grafo(int nro_vert, int Gmax, int eh_ponderado);
    void libera_Grafo(Grafo* gr);
    int insereAresta(Grafo* gr, int orig, int dest, int digrafo, float peso);
    int removeAresta(Grafo* gr, int orig, int dest, int digrafo);


#endif // GRAFOTESTE_H_INCLUDED
