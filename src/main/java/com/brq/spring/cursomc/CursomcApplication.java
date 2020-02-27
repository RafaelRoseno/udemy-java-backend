package com.brq.spring.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brq.spring.cursomc.domain.Categoria;
import com.brq.spring.cursomc.domain.Cidade;
import com.brq.spring.cursomc.domain.Cliente;
import com.brq.spring.cursomc.domain.Endereco;
import com.brq.spring.cursomc.domain.Estado;
import com.brq.spring.cursomc.domain.Produto;
import com.brq.spring.cursomc.domain.enums.TipoCliente;
import com.brq.spring.cursomc.repository.CategoriaRepository;
import com.brq.spring.cursomc.repository.CidadeRepository;
import com.brq.spring.cursomc.repository.ClienteRepository;
import com.brq.spring.cursomc.repository.EnderecoRepository;
import com.brq.spring.cursomc.repository.EstadoRepository;
import com.brq.spring.cursomc.repository.ProdutoRepository;


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
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}


	/*
	 * Acessar lista de contas: Utils.CONTA()
	 * 
	 * Criar 4 endpoints para:
	 * 	- Cadastrar produto (ProdutoController)
	 *  - Cadastrar cidade (CidadeController)
	 *  - Cadastrar estado (EstadoController)
	 *  - Cadastrar categoria (CategoriaController)
	 *   -------------------------------------------------------------------!
	 *  
	 *  Retornar Categoria/Produto Dto
	 *  Entender insert na Service
	 *  TipoCliente não gera o Nº definido no h2
	 *  
	 *  
	 */
		
	@Override
	public void run(String... args) throws Exception {
		
		
		
		Categoria cat1 = Categoria.builder()
				.nome("Informática")
				.build();
		// FAZER A CATEGORIA DENTRO DE PRODUTO DTO
		
		Categoria cat2 = Categoria.builder()
				.nome("Escritório")
				.build();
		
		Produto p1 = Produto.builder()
				.nome("Computador")
				.preco(200.0)
				.categorias(Arrays.asList(cat1))
				.build();
		
		Produto p2 = Produto.builder()
				.nome("Mouse")
				.preco(20.0)
				.categorias(Arrays.asList(cat1,cat2))
				.build();
		
		Produto p3 = Produto.builder()
				.nome("Quadro")
				.preco(300.0)
				.categorias(Arrays.asList(cat1))
				.build();
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
		Estado est1 = Estado.builder()
				.nome("Minas Gerais")
				.build();
		
		Estado est2 = Estado.builder()
				.nome("São Paulo")
				.build();
		
		Cidade cid1 = Cidade.builder()
				.nome("Uberlândia")
				.estado(est1)
				.build();
		
		Cidade cid2 = Cidade.builder()
				.nome("São Paulo")
				.estado(est2)
				.build();
		
		Cidade cid3 = Cidade.builder()
				.nome("Campinas")
				.estado(est2)
				.build();
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
		
		Cliente cliente1 = Cliente.builder()
				.nome("Maria Silva")
				.email("MariaSilva@gmail.com")
				.cpfOuCnpj("123 456 789 99")
				.tipo(TipoCliente.PESSOAFISICA)
				.build();
		
		cliente1.getTelefone().addAll(Arrays.asList("10202010","99858599"));
		
		Endereco endereco1 = Endereco.builder()
				.logradouro("Rua Flores")
				.numero("451")
				.complemento("Apto 34")
				.bairro("Jardim Spinoza")
				.cep("123 456 789 99")
				.cliente(cliente1)
				.cidade(cid1)
				.build();
		
		Endereco endereco2 = Endereco.builder()
				.logradouro("Rua Barroca")
				.numero("154")
				.complemento("Apto 43")
				.bairro("Jardim Sartre")
				.cep("123 456 789 88")
				.cliente(cliente1)
				.cidade(cid2)
				.build();
				
		
		cliente1.getEnderecos().addAll(Arrays.asList(endereco1,endereco2));
		
		clienteRepository.saveAll(Arrays.asList(cliente1));
		enderecoRepository.saveAll(Arrays.asList(endereco1,endereco2));		
	}
}
		
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
		
		
//		est1.getCidades().addAll(Arrays.asList(cid1));
//		est2.getCidades().addAll(Arrays.asList(cid2,cid3));
//		
		
		
		
	


