package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	//retorno do método SellerDao(interface) porém retorna uma implementação da interface
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}

}
