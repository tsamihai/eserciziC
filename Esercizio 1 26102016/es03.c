#include <stdio.h>
/*Esercizio 3
Dato un array con N elementi di tipo Integer, eseguirne la sottrazione e stamparla a video
 */

int main() {
    int array[10]= { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    int i;
    int sum=0;
    for (i = 0; i < 10; i++) {
        sum=sum-array[i];
    }
    printf("la somma is %d",sum);
}