package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== test 1 : seller findById ===");

		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== test 2 : seller findByDepartment ===");
		Department department = new Department(2, null);
		//list recebendo a pesquisa por departamento no banco
		List<Seller> list = sellerDao.findByDepartment(department);
		//imprimindo todos os objetos encontrados no banco
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== test 3 : seller findAll ===");
		//lista recebendo a pesquisa do todos os vendedores
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== test 4 : seller insert ===");
		//criando novo seller
		Seller newSeller = new Seller(null, "Wesley", "wesley@gmail.com", new Date(), 4000.00, department);
		//inserindo novo seller no banco
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id: " + newSeller.getId());
		
		System.out.println("\n=== test 5 : seller update ===");
		//seller recebe o resultado da pesquisa no banco
		seller = sellerDao.findById(1);
		//setando nome para seller
		seller.setName("Martha Waine");
		//atualizando seller
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}

	
}