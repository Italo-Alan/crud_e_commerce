package com.full_stack.crud.e_commerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.full_stack.crud.e_commerce.model.Product;
import com.full_stack.crud.e_commerce.model.Store;
import com.full_stack.crud.e_commerce.repository.StoreRepository;

@SpringBootApplication
public class CrudECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudECommerceApplication.class, args);

	}

	@Bean
	CommandLineRunner initDataBase(StoreRepository storeRepository){
		return args -> {
			storeRepository.deleteAll();

			Store s = new Store();
			s.setName("Informática sem chamado LTDA");
			s.setCnpj("10000000000001");
			s.setLineOfBusiness("Tecnologia");
			
			Product p = new Product();
			p.setName("Novo Echo Dot 5ª geração");
			p.setDescription("O Echo Dot com o melhor som já lançado");
			p.setPrice(407);
			p.setCode("07300012");
			p.setStock(500);
			p.setUrlImage("https://m.media-amazon.com/images/I/61I8k9mTZ7L._AC_SL1000_.jpg");
			p.setStore(s);
			
			s.getProducts().add(p);
			
			Product p1 = new Product();
			p1.setName("Novo Echo Dot 6ª geração");
			p1.setDescription("O Echo Dot com o melhor som já lançado");
			p1.setPrice(408);
			p1.setCode("07300011");
			p1.setStock(550);
			p1.setUrlImage("https://m.media-amazon.com/images/I/61I8k9mTZ7L._AC_SL1000_.jpg");
			p1.setStore(s);
			
			s.getProducts().add(p1);
			
			storeRepository.save(s);
			
			Store s1 = new Store();
			s1.setName("Tudo do bom e do melhor LTDA");
			s1.setCnpj("20000000000002");
			s1.setLineOfBusiness("Alimentício");

			Product p2 = new Product();
			p2.setName("Leite em Pó Ninho Integral Forti+");
			p2.setDescription("Leite integral, vitaminas (C, A e D) e pirofosfato férrico.");
			p2.setPrice(39);
			p2.setCode("07300012");
			p2.setStock(150);
			p2.setUrlImage("https://m.media-amazon.com/images/I/81PXAUB7R8S.__AC_SX300_SY300_QL70_ML2_.jpg");
			p2.setStore(s1);
			
			s1.getProducts().add(p2);
			
			Product p3 = new Product();
			p3.setName("Azeite Andorinha - Extra virgem 500ml");
			p3.setDescription("Azeite de Oliva Extra Virgem. Acidez <=0,5%; Indice de peroxidos <=20,00 mEq 02/Kg; Extinção Especifica no Ultravioleta 270 nm <=0,22; 232 nm<=2,50; Delta K <= 0,01;");
			p3.setPrice(28);
			p3.setCode("07300011");
			p3.setStock(123);
			p3.setUrlImage("https://m.media-amazon.com/images/I/615hQfE1hVL._AC_SY679_.jpg");
			p3.setStore(s1);
			
			s1.getProducts().add(p3);

			storeRepository.save(s1);
		};
	}
}
