/** Ausgabe auf Serieller Schnttstelle
*/
#include "mbed.h"

DigitalOut myled(LED_GREEN);
Serial pc(USBTX, USBRX);

int main()
{
    int i = 0;
    int u;
    pc.printf("Hello World!\n");

    while (true) 
    {
        wait(0.5f); // wait a small period of time
        pc.printf("%d \n", i); // print the value of variable i
        i++; // increment the variable
        myled = !myled; // toggle a led
        
        pc.scanf( "%d", &u );
        pc.printf("Eingabe war %d\n", u );
    }
}                   
