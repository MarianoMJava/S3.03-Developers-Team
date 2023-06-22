package mariano.floristeria.persistencia.mysqJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
 

 

public class JDBCProducto implements GenericDao {
    ContextJDBC conexionUno = ContextJDBC.getJDBC1();
	public JDBCProducto() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	} 
	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
//
//  	    conexionUno.update("CREATE TABLE IF NOT EXISTS  Producto (" 
//	    		+  " id  INT NOT NULL, nombre  VARCHAR(45) NULL,precio  DECIMAL(12,2) NULL ," 
//	    		+  " cantidad  INT NULL,  PRIMARY KEY ( id), UNIQUE INDEX  id_UNIQUE  (id ASC) VISIBLE)");
//	//    		ENGINE = InnoDB;	
  	    
  	    
  	  conexionUno.update("CREATE TABLE IF NOT EXISTS  `Producto` ("
  			  +" `id` INT NOT NULL,"
  			  +"`nombre` VARCHAR(45) NULL,"
  			  +"`precio` DECIMAL(12,2) NULL,"
  			  +"`cantidad` INT NULL,"
  			  +"PRIMARY KEY (`id`),"
  			  +"UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)"
  			+"ENGINE = InnoDB");

  	    
  	    
  	    
  	    
	}
}
