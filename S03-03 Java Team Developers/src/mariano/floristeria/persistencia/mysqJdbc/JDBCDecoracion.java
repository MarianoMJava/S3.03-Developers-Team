package mariano.floristeria.persistencia.mysqJdbc;

public class JDBCDecoracion implements GenericDao {
    ContextJDBC conexionUno = ContextJDBC.getJDBC1();
	public JDBCDecoracion() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	} 
	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		conexionUno.update("CREATE TABLE IF NOT EXISTS  `decoracion` ("
				  +"`id` INT NOT NULL,"
				  +"`material` VARCHAR(45) NOT NULL,"
				  +"`Producto_id` INT NOT NULL,"
				  +"UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,"
				  +"PRIMARY KEY (`id`),"
				  +"INDEX `fk_decoracion_Producto1_idx` (`Producto_id` ASC) VISIBLE,"
				  +"UNIQUE INDEX `Producto_id_UNIQUE` (`Producto_id` ASC) VISIBLE,"
				  +"CONSTRAINT `fk_decoracion_Producto1`"
				  +"  FOREIGN KEY (`Producto_id`)"
				  +"  REFERENCES `foristeria`.`Producto` (`id`)"
				  +"  ON DELETE NO ACTION "
				  +"  ON UPDATE NO ACTION)"
				  +"ENGINE = InnoDB;");
		
		System.out.println( "decoracion tablas");
		
       
	}
}
