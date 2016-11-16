#include <stdio.h>
/*
 * Esercizio 6
Dato il seguente array { 35.4, 46.7, 77.55, 11.1, 9.04, 0.75 } di elementi di tipo float,
eseguirne la MEDIA ARITMETICA e stamparne il risultato a video

 */
int main() {
    float array[]= {35.4, 46.7, 77.55, 11.1, 9.04, 0.75 };
    int i;
    float sum=0;
    for (i = 0; i < 6; i++) {
        sum=sum+array[i];

    }
    printf("la somma is %f\n",sum);
    float media;
    media=sum/6;
    printf("la media is %f",media);
}