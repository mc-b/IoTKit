/** Trace Makros
*/
#ifndef TRACE_H_
#define TRACE_H_

#include "mbed.h"

/////////////////////////////////////////////////////////////////////////////////
// Meldungen
#define OFF_LEVEL       0       // keine Meldungen
#define ERROR_LEVEL     1       // Fehler in der Programmausfuehrung
#define WARN_LEVEL      2       // Warnungen
#define INFO_LEVEL      3       // Informationen, Start, Initialisierung i.o. etc.
#define DEBUG_LEVEL     4       // Allgemeine Debug Infos
#define TRACE_LEVEL     5       // Fein Detalierte Meldungen, nur in Ausnahmefaellen zu aktivieren

/** aktueller Trace Level */
#define LOGGER_LEVEL    TRACE_LEVEL

/**
 * Error
 */
#if ( LOGGER_LEVEL >= ERROR_LEVEL )
#define ERROR(str) \
        printf( "E: %s:%d %s\n", __PRETTY_FUNCTION__, __LINE__, str );
#else
#define ERROR(str)
#endif

/**
 * Warning
 */
#if ( LOGGER_LEVEL >= WARN_LEVEL )
#define WARN(str) \
        printf( "W: %s:%d %s\n", __PRETTY_FUNCTION__, __LINE__, str );
#else
#define WARN(str)
#endif

/**
 * Info
 */
#if ( LOGGER_LEVEL >= INFO_LEVEL )
#define INFO(str) \
        printf( "I: %s:%d %s\n", __PRETTY_FUNCTION__, __LINE__, str );
#else
#define INFO(str)
#endif

#if ( LOGGER_LEVEL >= INFO_LEVEL )
#define INFO1(str, v) \
        printf( "I: %s:%d ", __PRETTY_FUNCTION__, __LINE__ ); \
        printf( str, v ); \
        printf( "\n" );
#else
#define INFO1(str, v)
#endif

#if ( LOGGER_LEVEL >= INFO_LEVEL )
#define INFO2(str, v, x ) \
        printf( "I: %s:%d \n", __PRETTY_FUNCTION__, __LINE__ ); \
        printf( str, v, x ); \
        printf( "\n" );
        
#else
#define INFO2(str, v, x)
#endif

/**
 * Debug
 */
#if ( LOGGER_LEVEL >= DEBUG_LEVEL )
#define DEBUG(str) \
        printf( "D: %s:%d %s\n", __PRETTY_FUNCTION__, __LINE__, str );
#else
#define DEBUG(str)
#endif

#if ( LOGGER_LEVEL >= DEBUG_LEVEL )
#define DEBUG1(str, v) \
        printf( "D: %s:%d ", __PRETTY_FUNCTION__, __LINE__ ); \
        printf( str, v ); \
        printf( "\n" );
#else
#define DEBUG1(str, v)
#endif

#if ( LOGGER_LEVEL >= DEBUG_LEVEL )
#define DEBUG2(str, v, x ) \
        printf( "D: %s:%d ", __PRETTY_FUNCTION__, __LINE__ ); \
        printf( str, v, x ); \
        printf( "\n" );
#else
#define DEBUG2(str, v, x)
#endif

/**
 * Trace
 */
#if ( LOGGER_LEVEL >= TRACE_LEVEL )
#define TRACE(str) \
        printf( "T: %s:%d %s\n", __PRETTY_FUNCTION__, __LINE__, str );
#else
#define TRACE(str)
#endif

#if ( LOGGER_LEVEL >= TRACE_LEVEL )
#define TRACE1(str, v) \
        printf( "T: %s:%d ", __PRETTY_FUNCTION__, __LINE__ ); \
        printf( str, v ); \
        printf( "\n" );
#else
#define TRACE1(str, v)
#endif

#if ( LOGGER_LEVEL >= TRACE_LEVEL )
#define TRACE2(str, v, x ) \
        printf( "T: %s:%d ", __PRETTY_FUNCTION__, __LINE__ ); \
        printf( str, v, x ); \
        printf( "\n" );
#else
#define TRACE2(str, v, x)
#endif

#endif /* TRACE_H_ */
