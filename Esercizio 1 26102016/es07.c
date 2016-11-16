#include <stdio.h>
/*Esercizio 7
Dato il seguente array { 35.4, 46.7, 77.55, 11.1, 9.04, 0.75 } di elementi di tipo float,
eseguirne la MEDIA PONDERATA con pesi pari alla corrispondente posizione inversa, e stamparne il risultato a video
 */
int main() {
    float array[]= {35.4, 46.7, 77.55, 11.1, 9.04, 0.75 };
    int i;
    float sum=0;
    float peso=5;
    float n;
    int sommapesi=0;
    for (i = 0; i < 6; i++) {
        sum=sum+array[i]*peso;
        sommapesi=sommapesi+peso;
        peso--;

    }
    n=sum/sommapesi;
    printf("la media is %f",n);
}