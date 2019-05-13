
package ContextoProblema;


public class Cancion {
    private int codigo;
    private String nombre;
    private String artista;
    private String album;
    private int año;
    private String letra;

    public Cancion(int codigo, String nombre, String artista, String album, int año, String letra) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.artista = artista;
        this.album = album;
        this.año = año;
        this.letra=letra;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    @Override
    public String toString() {
        return "codigo: " + codigo +"\n"
                + "nombre: " + nombre +"\n"
                + "Artista: " + artista 
                +"\n"+ "Album: " + album +"\n"
                + "Año: " + año +"\n"
                +"Letra:\n" + letra;
    }
    
    
}
