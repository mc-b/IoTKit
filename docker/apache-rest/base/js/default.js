////////////////////////////////////////////////////////////////////////////////////////////////
// Default Funktionen

/**
 * Erzeugt ein neues Fenster mit dem Bild
 * @param image 
 */

function showPhoto( image ) 
{
    fenster = window.open('image','Popupfenster');
    with( fenster ) 
    {
        document.write( '<HTML><HEAD><TITLE>Detail</TITLE></HEAD>' );
        document.write( '<BODY style="padding:0px; margin:0px; cursor:pointer"><IMG SRC="'+image+'" border="0" height="75%" onclick="window.close()"></BODY></HTML>' );
    }
    //fenster.moveTo(screen.width/2-500/2,screen.height/2-333/2);
    fenster.focus();
}