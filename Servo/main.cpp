/** Servo am Digital Pin D9.
    Das orange Kabel (Signal) ist links.
*/
#include "mbed.h"
#include "Servo.h"

Servo servo( D9 );

int main()
{
    // Servo kalibrieren, damit er die vollen 180° verwendet.
    servo.calibrate ( 0.0009, 180.0);

    while   ( 1 )
    {
        // Servo langsam bewegen (immer in der Mitte Anfangen mit Tests, sonst besteht die Gefahr von Schäden)
        for ( float p = 0.2f; p <= 0.8f; p += 0.0001f )
        {
            servo = p;
            wait(0.001);
        }
        wait( 1.0 );
        // und die andere Seite
        for ( float p = 0.8f; p >= 0.2f; p -= 0.0001f )
        {
            servo = p;
            wait(0.001);
        }
        wait( 1.0 );
    }
}
