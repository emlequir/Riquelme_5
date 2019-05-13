
package GestorArchivos;

import ContextoProblema.Cancion;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorArchivos {
    private ArrayList<Cancion> canciones;
    
    public GestorArchivos(){
        canciones = new ArrayList();
        añadirCancion(1,"Put You on the Game","The Game","The Documentary",2005,leerArchivo("put_you_on_the_game.txt"));
        añadirCancion(2,"Dreams","The Game","The Documentary",2005,leerArchivo("dreams.txt"));
        añadirCancion(3,"Space Bound","Eminem","Recovery",2010,leerArchivo("space_bound.txt"));
        añadirCancion(4,"Maquiavelico","Canserbero","Merte",2012,leerArchivo("maquavelico.txt"));
        menu();
    }
    
    /*
    Lee el archivo especificado
    @param string con la ruta de un archivo
    @returns string con lo contenido en el archivo
    */
    
    public static String leerArchivo(String ruta){
        Path archivo = Paths.get(ruta);
            String texto = "";
            try {
                texto = new String(Files.readAllBytes(archivo));
                return texto;
            } catch (IOException e) {
                
                texto="El archivo no fue encontrado";
                return texto;
            }
    }
    
    /*
    Menu del progrma
    @return void
    */
    
    public void menu(){
        System.out.println("Eliga una opción");
        System.out.println("1.Mostrar canción");
        System.out.println("2.Añadir canción");
        System.out.println("3.Eliminar canción");
        System.out.println("4.Salir");

        menuAccion(validarMenu());
        
    }
    
    /*
    Añade un objeto cancion al ArrayList canciones
    @param todos los parametros necesarios para crear un onjeto tipo cancion
    @return void
    */
    
    public  void añadirCancion(int codigo,String nombre,String artista,String album,int año,String letra){
        canciones.add(new Cancion(codigo,nombre,artista,album,año,letra));
    }
    
    /*
    Muestra el nombre de todas las canciones disponibles
    @return void
    */
    
    public void mostrarNombreCanciones(){
        for(int i=0;i<canciones.size();i++){
            System.out.println(canciones.get(i).getNombre());
        }
    }
    
    /*
    Lee un dato tipo int
    @return un numero int
    */
    
    public int leerInt(){
        Scanner teclado = new Scanner(System.in);
        int resp=-1;
            try{
                resp=teclado.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Dato invalido");
            } 
        return resp;
    }
    
    /*
    Valida la eleccion hecha en el menu
    @return respuesta validada
    */
    
    public int validarMenu(){
        int resp;
        do{
        resp=leerInt();
        }while(resp<1 || resp>4);
        return resp;
    }
    
    /*
    Muestra todos los datos de un objeto cancion que pertenece al ArrayList cabcuibes
    @param posiicon de la cancion en el ArrayList canciones
    @return void
    */
    
    public void mostrarCancion(int posicion){
        System.out.println(canciones.get(posicion).toString());
    }
    
    /*
    Lee un dato tipo String
    @return dato tipo String
    */
    
    public String leerString(){
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }
    
    /*
    Encuentra la posicion de un ibjeto cancion en el ArrayList canciones
    @param variable nombre tipo String asignado al objeto de tipo Cancion
    @return int con la posicion del objeto
    */
    
    public int encontrarCancion(String nombre){
        int posicion=-1;
        for(int i=0;i<canciones.size();i++){
            if(nombre.equals(canciones.get(i).getNombre())) posicion=i;
        }
        return posicion;
    }
    
    /*
    Pregunta por los datos necesarios para crear ub ojeto Cancion
    @return void
    */
    
    public void crearCancion(){
        int codigo=canciones.size()+1;
        System.out.println("Ingrese nombre de la canción");
        String nombre=leerString();
        System.out.println("Ingrese nombre del artista");
        String artista=leerString();
        System.out.println("Ingrese album de la canción");
        String album=leerString();
        System.out.println("Ingrese el año de la canción");
        int año=validarAño();
        System.out.println("Ingrese la ruta del archivo con la letra de la canción");
        String letra=validarLetra();
        añadirCancion(codigo,nombre,artista,album,año,letra);    
    }
    
    /*
    Valida si el año es correcto
    @return int con el año validado
    */
    
    public int validarAño(){
        int año=0;
        while(año<1){
            año=leerInt();
            if(año<1){
                System.out.println("Año invalido");
            }
        }
        return año;
    }
    
    /*
    Valida que la letra sea ingresada correctamente
    @return String con la letra de la cancion
    */
    
    public String validarLetra(){
        String letra;
        do{
            letra=leerArchivo(leerString());
            if(letra.equals("El archivo no fue encontrado")){
                System.out.println("Ruta invalida");            
            }
        }while(letra.equals("El archivo no fue encontrado"));
        return letra;
        
    }
    
    /*
    Elimina un objeto cancion del ArrayList canciones
    @param int con la posicion del ojeto en el ArrayList canciones
    */
    
    public void eliminarCancion(int posicion){
        canciones.remove(posicion);
    }
    
    /*
    Realiza la accion necesaria elegida en el menu
    @param int con la respuesta dada en menu
    @return void
    */
    
    public void menuAccion(int resp){
        switch(resp){
            case 1:
                System.out.println("----------------------------------"+"\n");
                if(canciones.size()!=0){
                    System.out.println("Ingrese el nombre de la canción");
                    mostrarNombreCanciones();
                    int posicion=encontrarCancion(leerString());
                    if(posicion==-1){
                        System.out.println("Canción no encontrada \n");
                    }else{
                        mostrarCancion(posicion);
                    }         
                }else{
                    System.out.println("No hay canciones disponibles");
                }
                System.out.println("----------------------------------"+"\n");
                menu();
                break;
            case 2:
                crearCancion();
                menu();
                break;
            case 3:
                System.out.println("----------------------------------"+"\n");
                if(canciones.size()!=0){
                    System.out.println("Ingrese el nombre de la canción a eliminar");
                    mostrarNombreCanciones();
                    int posicion=encontrarCancion(leerString());
                    if(posicion==-1){
                        System.out.println("Canción no encontrada \n");
                    }else{
                        eliminarCancion(posicion);
                    }         
                }else{
                    System.out.println("No hay canciones disponibles");
                }
                System.out.println("----------------------------------"+"\n");
                menu();
                break;
            case 4:
                break;
        }
    }
    
}
