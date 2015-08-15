/** Beispiel fuer das Auslesen von RFID Tags mittels RFID Reader
*/
#include "mbed.h"
#include "MFRC522.h"

// NFC/RFID Reader (SPI)
MFRC522    rfidReader( D11, D12, D13, D10, D8 );

int main()
{
    printf("RFID Reader MFRC522 Test\n");
    rfidReader.PCD_Init();

    while   ( 1 ) 
    {
        // RFID Reader
        if ( rfidReader.PICC_IsNewCardPresent())
            if ( rfidReader.PICC_ReadCardSerial()) 
            {
                // Print Card UID (2-stellig mit Vornullen, Hexadecimal)
                printf("Card UID: ");
                for ( int i = 0; i < rfidReader.uid.size; i++ )
                    printf("%02X:", rfidReader.uid.uidByte[i]);
                printf("\n");
                
                // Print Card type
                int piccType = rfidReader.PICC_GetType(rfidReader.uid.sak);
                printf("PICC Type: %s \n", rfidReader.PICC_GetTypeName(piccType) );
            }
        wait( 0.2f );
    }
}