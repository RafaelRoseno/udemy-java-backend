package com.brq.spring.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brq.spring.cursomc.domain.Categoria;
import com.brq.spring.cursomc.domain.Cidade;
import com.brq.spring.cursomc.domain.Estado;
import com.brq.spring.cursomc.domain.Produto;
import com.brq.spring.cursomc.repositories.CategoriaRepository;
import com.brq.spring.cursomc.repositories.CidadeRepository;
import com.brq.spring.cursomc.repositories.EstadoRepository;
import com.brq.spring.cursomc.repositories.ProdutoRepository;


@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		

		Produto p1 = Produto.builder()
				.nome("Computador")
				.preco(200.0)
				.build();
				
		Produto p2 = Produto.builder()
				.nome("Mouse")
				.preco(20.0)
				.build();
		
		Produto p3 = Produto.builder()
				.nome("Quadro")
				.preco(300.0)
				.build();
		
		Categoria cat1 = Categoria.builder()
				.nome("Informática")
				.produtos(Arrays.asList(p1,p2,p3))
				.build();
		
		Categoria cat2 = Categoria.builder()
				.nome("Escritório")
				.produtos(Arrays.asList(p2))
				.build();
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));	
		
//		Categoria cat1 = new Categoria(1, "Informática");
//		Categoria cat2 = new Categoria(2, "Escritório");

//		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
//		cat2.getProdutos().addAll(Arrays.asList(p2));
		
//		p1.getCategorias().addAll(Arrays.asList(cat1));
//		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
//		p3.getCategorias().addAll(Arrays.asList(cat1));
				
		
		
		//Estado est1 = new Estado(null, "Minas Gerais");
		//Estado est2 = new Estado(null, "São Paulo");
		
		//Cidade cid1 = new Cidade(null, "Uberlândia", est1 );
//		Cidade cid2 = new Cidade(null, "São Paulo", est2);
//		Cidade cid3 = new Cidade(null, "Campinas", est2);
		
		Cidade cid1 = Cidade.builder()
				.nome("Uberlândia")
				.build();
		
		Cidade cid2 = Cidade.builder()
				.nome("São Paulo")
				.build();
		
		Cidade cid3 = Cidade.builder()
				.nome("Campinas")
				.build();
		
		Estado est1 = Estado.builder()
				.nome("Minas Gerais")
				.cidades(Arrays.asList(cid1))
				.build();
		
		Estado est2 = Estado.builder()
				.nome("São Paulo")
				.cidades(Arrays.asList(cid2,cid3))
				.build();
		
//		est1.getCidades().addAll(Arrays.asList(cid1));
//		est2.getCidades().addAll(Arrays.asList(cid2,cid3));
//		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
		
		
	}

}
