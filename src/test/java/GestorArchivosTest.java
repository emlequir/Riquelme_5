/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ContextoProblema.Cancion;
import GestorArchivos.GestorArchivos;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author licho
 */
public class GestorArchivosTest {
    
    
    
    
    @Test
    public void leerArchivoTest(){
        String esperado = "El archivo no fue encontrado";
        assertEquals(esperado, GestorArchivos.leerArchivo("asd"));
    }

    @Test
    public void leerArchivoTest2(){
        String esperado = "Hola Mundo";
        assertEquals(esperado, GestorArchivos.leerArchivo("test.txt"));
        
    }
    
}
