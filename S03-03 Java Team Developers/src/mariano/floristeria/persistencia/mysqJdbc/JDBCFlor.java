package mariano.floristeria.persistencia.mysqJdbc;

public class JDBCFlor implements GenericDao {
    ContextJDBC conexionUno = ContextJDBC.getJDBC1();
	public JDBCFlor() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	} 
	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
		conexionUno.update("-- -----------------------------------------------------\r\n"
	  			+ "-- Table `flores`\r\n"
	  			+ "-- -----------------------------------------------------\r\n"
	  			+ "CREATE TABLE IF NOT EXISTS `flores` (\r\n"
	  			+ "  `Id` INT NOT NULL,\r\n"
	  			+ "  `color` VARCHAR(45) NULL,\r\n"
	  			+ "  `Producto_id` INT NOT NULL,\r\n"
	  			+ "  PRIMARY KEY (`Id`),\r\n"
	  			+ "  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC) VISIBLE,\r\n"
	  			+ "  INDEX `fk_flores_Producto1_idx` (`Producto_id` ASC) VISIBLE,\r\n"
	  			+ "  UNIQUE INDEX `Producto_id_UNIQUE` (`Producto_id` ASC) VISIBLE,\r\n"
	  			+ "  CONSTRAINT `fk_flores_Producto1`\r\n"
	  			+ "    FOREIGN KEY (`Producto_id`)\r\n"
	  			+ "    REFERENCES `foristeria`.`Producto` (`id`)\r\n"
	  			+ "    ON DELETE NO ACTION\r\n"
	  			+ "    ON UPDATE NO ACTION)\r\n"
	  			+ "ENGINE = InnoDB;\r\n"
	  			+ "");
	  

	}
}
