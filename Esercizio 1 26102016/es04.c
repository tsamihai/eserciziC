#include <stdio.h>
/*Esercizio 4
Dato un array con N elementi di tipo Float, eseguirne
 la moltiplicazione e stamparli a video con
 un numero di cifre decimali pari a 2.
 */
int main() {
    float array[]= { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    int i;
    float sum=1;
    for (i = 0; i < 10; i++) {
        sum=sum*array[i];
    }
    printf("la somma is %.02f",sum);

}