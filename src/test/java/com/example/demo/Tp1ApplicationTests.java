package com.example.demo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.entities.Produit;
import com.example.demo.repository.ProduitRepository;
import com.example.demo.service.ProduitService;


@SpringBootTest
class Tp1ApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;

	@Autowired
	private ProduitService produitService ;

	@Test
	public void testCreateProduit() {
		Produit prod = new Produit("PC Hp", 3200.500, new Date());
		produitRepository.save(prod);
	}

	@Test
	public void testFindProduit() {
		Produit p = produitRepository.findById(1L).get();
		System.out.println(p);
	}

	@Test
	public void testUpdateProduit() {
		Produit p = produitRepository.findById(2L).get();
		p.setPrixProduit(3000.0);
		produitRepository.save(p);
	}

	@Test
	public void testDeleteProduit() {
		produitRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousProduits() {
		List<Produit> prods = produitRepository.findAll();
		for (Produit p : prods) {
			System.out.println(p);
		}
	}
	@Test
	public void testFindByNomProduitContains()
	{
	Page<Produit> prods = produitService.getAllProduitsParPage(0,2);
	System.out.println(prods.getSize());
	System.out.println(prods.getTotalElements());
	System.out.println(prods.getTotalPages());
	prods.getContent().forEach(p -> {System.out.println(p.toString());
	});
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	}
}
