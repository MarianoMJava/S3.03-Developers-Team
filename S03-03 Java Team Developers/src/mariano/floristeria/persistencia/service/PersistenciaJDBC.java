package mariano.floristeria.persistencia.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mariano.floristeria.beans.Arbol;
import mariano.floristeria.beans.Decoracion;
import mariano.floristeria.beans.Flor;
import mariano.floristeria.beans.Producto;
import mariano.floristeria.beans.Ticket;
import mariano.floristeria.main.ConfiguracionPropiedades;
import mariano.floristeria.persistencia.mysqJdbc.*;
public class PersistenciaJDBC {
	private static String arbolfile;
	private static String florfile;
	private static String decoracionfile;
	private static String listaTicketsfile;
	private   String nombre;

//  AL hacer privado el constructor esto no funciona

	//	ContextJDBC  contextJDBC = new ContextJDBC ();	

	//   LLamamos al método estático  que instanciara solo una vez la clase
	
	ContextJDBC  contextJDBC =  null;	
    
    
    JDBCProducto   productojdbc  = null;
 	JDBCArbol   arboljdbc =  null;
    JDBCFlor    florjdbc  = null;
    JDBCDecoracion   decoracionjdbc  = null;
    
    public PersistenciaJDBC( ConnectionConfig    connectionconfig  , String databasename   ) {

    	ContextJDBC conexionUno = ContextJDBC.getJDBC1(  connectionconfig  );
	    
	    conexionUno.update("CREATE DATABASE  IF NOT EXISTS " + databasename  +" ");
	    conexionUno.update("use "  + databasename );
 	    
	    productojdbc  = new JDBCProducto(); 
	 	arboljdbc =  new JDBCArbol();
	    florjdbc  = new JDBCFlor();
	    

	    decoracionjdbc  = new JDBCDecoracion();
		
	    productojdbc.createTable();
	    
	    
	    

	    florjdbc.createTable();

	    decoracionjdbc.createTable(); 
	    
	    
	    arboljdbc.createTable();


	}

	public List<Arbol>	 LeerArbol() {
		
 		
		return arboljdbc.createArbol();
 
	}	

	public void  GrabarArbol ( List<Arbol>  arbol) {
		
		arboljdbc.GrabarArbol(arbol); 
	    
	}
}
