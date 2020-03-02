package com.brq.spring.cursomc;

import java.text.SimpleDateFormat;
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
import com.brq.spring.cursomc.domain.ItemPedido;
import com.brq.spring.cursomc.domain.Pagamento;
import com.brq.spring.cursomc.domain.PagamentoComBoleto;
import com.brq.spring.cursomc.domain.PagamentoComCartao;
import com.brq.spring.cursomc.domain.Pedido;
import com.brq.spring.cursomc.domain.Produto;
import com.brq.spring.cursomc.domain.enums.EstadoPagamento;
import com.brq.spring.cursomc.domain.enums.TipoCliente;
import com.brq.spring.cursomc.repository.CategoriaRepository;
import com.brq.spring.cursomc.repository.CidadeRepository;
import com.brq.spring.cursomc.repository.ClienteRepository;
import com.brq.spring.cursomc.repository.EnderecoRepository;
import com.brq.spring.cursomc.repository.EstadoRepository;
import com.brq.spring.cursomc.repository.ItemPedidoRepository;
import com.brq.spring.cursomc.repository.PagamentoRepository;
import com.brq.spring.cursomc.repository.PedidoRepository;
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
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	
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
		
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido pedido1 = Pedido.builder()
				.instante(date.parse("30/09/2019 10:32"))
				.cliente(cliente1)
				.enderecoEntrega(endereco1)
				.build();
		
		Pedido pedido2 = Pedido.builder()
				.instante(date.parse("10/10/2019 19:35"))
				.cliente(cliente1)
				.enderecoEntrega(endereco2)
				.build();
		
		Pagamento pagamento1 = PagamentoComCartao.builder()
				.estado(EstadoPagamento.QUITADO)
				.pedido(pedido1)
				.numeroParcelas(6)
				.build();
		
		pedido1.setPagamento(pagamento1);
		
		Pagamento pagamento2 = PagamentoComBoleto.builder()
				.estado(EstadoPagamento.PENDENTE)
				.pedido(pedido2)
				.dataVencimento(date.parse("24/10/2019 00:00"))
				.build();
		
		pedido2.setPagamento(pagamento2);
		
		cliente1.getPedidos().addAll(Arrays.asList(pedido1,pedido2));
		
		pedidoRepository.saveAll(Arrays.asList(pedido1,pedido2));
		pagamentoRepository.saveAll(Arrays.asList(pagamento1,pagamento2));
		
		ItemPedido itemPedido1 = ItemPedido.builder()
				.pedido(pedido1)
				.produto(p1)
				.desconto(0.00)
				.quantidade(1)
				.preco(2000.00)
				.build();
		
		ItemPedido itemPedido2 = ItemPedido.builder()
				.pedido(pedido1)
				.produto(p3)
				.desconto(0.00)
				.quantidade(2)
				.preco(80.00)
				.build();
		
		ItemPedido itemPedido3 = ItemPedido.builder()
				.pedido(pedido2)
				.produto(p2)
				.desconto(100.00)
				.quantidade(1)
				.preco(80.00)
				.build();
		pedido1.getItens().addAll(Arrays.asList(itemPedido1,itemPedido2));
		pedido2.getItens().addAll(Arrays.asList(itemPedido3));
		
		p1.getItens().addAll(Arrays.asList(itemPedido1));
		p2.getItens().addAll(Arrays.asList(itemPedido3));
		p3.getItens().addAll(Arrays.asList(itemPedido2));
		
		itemPedidoRepository.saveAll(Arrays.asList(itemPedido1,itemPedido2,itemPedido3));	
		
				
				
		
		
		
		
		
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
		
		
		
	


