/** Motor Beispiel
    Motor an den oberen 2 Pins einstecken.
*/
#include "mbed.h"
#include "Motor.h"

Motor m1(D3, D2, D4); // PWM, Vorwaerts, Rueckwarts

int main() 
{
    printf( "Motor Test\n" );
    while   ( 1 )
    {
        // rueckwaerts
        printf( "rueckwaerts\n" );
        for (float s = 0.5f; s < 1.0f ; s += 0.01f )
        {
           m1.speed(s * -1);
           wait(0.4);
        }
        m1.speed( 0 );
        wait( 1.0 );

        printf( "vorwaerts\n" );
        for (float s = 0.5f; s < 1.0f ; s += 0.01f )
        {
           m1.speed(s);
           wait(0.4);
        }
        m1.speed( 0 );
        wait( 1.0 );
    }
}
