#include <stdio.h>
/*Esercizio 8
Dato il seguente array { 35.4, 46.7, 77.55, 11.1, 9.04, 0.75 }
 di elementi di tipo float, indicare il maggiore, il minore e il valore medio, stamparne il risultato a video
 */
int main() {
    float array[]= {35.4, 46.7, 77.55, 11.1, 9.04, 0.75 };
    int i;
    float max=0;
    int min=0;
    int j;
    float temp;
    for(i=0; i<6; i++)
    {
        min = i;

        for(j=i+1; j<6; j++)
            if(array[j] < array[min]) //cambiare questa condizione per invertire l'ordine
                min = j;

        temp=array[min];
        array[min]=array[i];
        array[i]=temp;
    }
    printf("primo elemento %f\n",array[0]);
    printf("ultimo elemento %f\n",array[5]);
    printf("mezzo elemento %f\n",array[2]);
}
