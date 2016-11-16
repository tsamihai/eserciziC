#include <stdio.h>



    /* Esercizio 1
         Dato un array con N elementi di tipo Integer, stamparli a video, con indicazione sulla posizione del singolo elemento.
         es.: [0] = 25*/

    int main() {
        int array[10]= { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int i;
        for (i = 0; i < 10; i++) {
            printf("la posizione del array[%d",i);
            printf(" ]  =%d\n",array[i]);
        }
    return 0;
}
