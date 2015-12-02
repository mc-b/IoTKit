/** 7.1 Erstellt eine trace.h Datei wo verschiedene Trace Level eingestellt werden können.<br>
        Probiert die Verschiedenen Trace Levels aus.
*/        

#include "mbed.h"
#include "trace.h"

/** Hauptprogramm */
int main()
{
    INFO( "Test Trace" );
   
    // Initialisierung 
    INFO( "Initialisierung" );

    // Loop 
    INFO( "Loop" ); 
    while   ( 1 )
    {
        DEBUG( "In Loop" ); 
        wait    ( 1.0 );
    }
}
