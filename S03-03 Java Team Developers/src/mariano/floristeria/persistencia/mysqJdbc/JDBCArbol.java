package mariano.floristeria.persistencia.mysqJdbc;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import mariano.floristeria.beans.Arbol;
import java.util.ArrayList;
import java.util.List;



public class JDBCArbol implements GenericDao {
	
    ContextJDBC conexionUno = ContextJDBC.getJDBC1();
	public JDBCArbol() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	} 
	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		

//	  	  conexionUno.update("CREATE TABLE IF NOT EXISTS arbol " +
//	  	  	       "(altura DECIMAL(10,2) NULL,arbolcol  INT NOT NULL, Producto_id INT NOT NULL, PRIMARY KEY ( arbolcol )," +
//	  	  			"  INDEX fk_arbol_Producto_idx  (Producto_id ASC) VISIBLE," +
//	  	  			 " UNIQUE INDEX Producto_id_UNIQUE  (Producto_id  ASC) VISIBLE, " +
//	  	  			 " UNIQUE INDEX arbolcol_UNIQUE  (arbolcol ASC) VISIBLE,    " + 
//	  	  			 " CONSTRAINT fk_arbol_Producto   FOREIGN KEY (Producto_id)  " + 
//	  	  			 "   REFERENCES Producto (id )  ");
//		//	 "   REFERENCES Producto (id ) ON DELETE CASCADE  ON UPDATE  CASCADE ");
//	  	  
	  	  	  	  
//	  	conexionUno.update("CREATE TABLE IF NOT EXISTS `arbol` ("
//	  		  +"`altura` DECIMAL(10,2) NULL, "
//	  		  +"`arbolcol` INT NOT NULL, "
//	  		  +"`Producto_id` INT NOT NULL,"
//	  		  +"PRIMARY KEY (`arbolcol`) "
//	  		  +"INDEX `fk_arbol_Producto_idx` (`Producto_id` ASC) VISIBLE,"
//	  		  +"UNIQUE INDEX `Producto_id_UNIQUE` (`Producto_id` ASC) VISIBLE,"
//	  		  +"UNIQUE INDEX `arbolcol_UNIQUE` (`arbolcol` ASC) VISIBLE,"
//	  		  +"CONSTRAINT `fk_arbol_Producto`    "
//	  		    +"FOREIGN KEY (`Producto_id`)     "
//	  		    +"REFERENCES   `Producto` (`id`) ;"
//	  		    +"ON DELETE NO ACTION "
//	  		    +"ON UPDATE NO ACTION) ");
//	  		    
	  		    
//	  		+"ENGINE = InnoDB;");
//	  	  
	  	  
	  	   
	  	
	  	conexionUno.update("CREATE TABLE IF NOT EXISTS `flores_copy1` (  "
	  		+"  `Id` INT NOT NULL,  "
	  		+"    `color` VARCHAR(45) NULL,  "
	  		+"    `Producto_id` INT NOT NULL, "
	  		  +"  PRIMARY KEY (`Id`),"
	  		  +"  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC) VISIBLE,"
	  		  +"  INDEX `fk_flores_Producto1_idx` (`Producto_id` ASC) VISIBLE,"
	  		  +"  UNIQUE INDEX `Producto_id_UNIQUE` (`Producto_id` ASC) VISIBLE,"
	  		  +"  CONSTRAINT `fk_flores_Producto10' "
	  		    +"  FOREIGN KEY (`Producto_id`) "
	  		  +"    REFERENCES  `Producto` (`id`) "
	  		 +"     "
	  		 +"      ");
 
	  	
	  	
	  	
	  	  
	}

	
	public List<Arbol>  createArbol() {
		
			List<Arbol>  arbol  = new ArrayList<>();	
//			//---    Eligemos la tabla producto y un campo de la tabla 
//		    String sql = "SELECT  C.* ,   O.* " +
//				 " FROM producto  C LEFT JOIN arbol O ON  C.ID    = O.Producto_id " ;
//
//		
//			ResultSet rsProduct = conexionUno.query( sql);
////			ResultSet rsProduct = conexionUno.query("SELECT * FROM Product WHERE id=" + id); 
//
//			try {
//				while (rsProduct.next()) {
// 
//					System.out.println( rsProduct.getInt("id")  );
//					System.out.println( rsProduct.getInt("cantidad")  );
//					System.out.println( rsProduct.getDouble("precio")  );
//					System.out.println( rsProduct.getString("nombre")  );
//					System.out.println( rsProduct.getDouble("altura")  );
//					
//					Arbol arbol2 = new Arbol(rsProduct.getString("nombre"),rsProduct.getDouble("precio"),rsProduct.getDouble("altura"),rsProduct.getInt("cantidad"));
//					arbol2.setId( rsProduct.getInt("id"));
//					arbol.add( arbol2 );
//				
//				}
//			} catch (SQLException e) {
//				System.out.println(">>>WARNING (JDBCProductDAO:read): " + e.getMessage());
//			}
			return arbol;
	
	}
	
	public void  GrabarArbol( List<Arbol> arbol) {
	
//		conexionUno.update("INSERT Category VALUES (" + category.getId() + ", '" + category.getName() + "', '"
//				+ category.getDescription() + "')");
	
		// ----   Sin contemplaciones  ------
//		conexionUno.update("SET SQL_SAFE_UPDATES = 0");
//		conexionUno.update("SET FOREIGN_KEY_CHECKS=0");
//		
//		conexionUno.update("DELETE FROM producto where id in ( SELECT  Producto_id  FROM arbol ) ");
//		conexionUno.update("DELETE FROM arbol ");
//		
//		    int   pi = arbol.size()  + 10;
////			
//		    for( int  a = 0; a< arbol.size() ; a++ ) {
//		    	
//				conexionUno.update("INSERT producto  VALUES (" + arbol.get(a).getId() + pi + ", '" + arbol.get(a).getNombre()  + "', " +
//						 arbol.get(a).getPrecio() +  " ," +   arbol.get(a).getCantidad()   + ")");
//		    	
//		    	
//				conexionUno.update("INSERT arbol   VALUES (" +  arbol.get(a).getAltura()  + "," + arbol.get(a).getId() + pi + ", '" + arbol.get(a).getId() + pi   + "')"); 
//						
//		    	
//		    }
//		    
 
	}
}
