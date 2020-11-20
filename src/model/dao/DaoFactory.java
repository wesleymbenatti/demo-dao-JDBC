package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	//retorno do m�todo SellerDao(interface) por�m retorna uma implementa��o da interface
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}

}
