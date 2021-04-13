package application;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char condicao = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Price: ");
			double preco = sc.nextDouble();
			if (condicao == 'i') {
				System.out.print("Customs fee: ");
				double taxaAlfandega = sc.nextDouble();
				list.add(new ImportedProduct(nome, preco, taxaAlfandega));
				}
			else if(condicao == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				java.util.Date data = sdf.parse(sc.next());
				list.add(new UsedProduct(nome, preco, data));
				}
			else {
				list.add(new Product(nome, preco));
				}
			}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product x : list) {
			System.out.println(x.priceTag());
		}
		
		sc.close();
	}

}
