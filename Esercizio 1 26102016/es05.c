#include <stdio.h>

/*Esercizio 5
Dato un array con N elementi di tipo Float,
 eseguirne la sottrazione e stamparli
 a video con un numero di cifre decimali pari a 2.
 */
int main() {
    float array[10]= { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    int i;
    float sum=0;
    for (i = 0; i < 10; i++) {
        sum=sum-array[i];
    }
    printf("la somma is %.02f",sum);

}