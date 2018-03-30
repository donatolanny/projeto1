package br.controle.testeIntegracao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.controle.modelo.Livro;

public class UC06CadastrarLivro {
	static private Livro livro;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		  livro = new Livro();
		  livro.setIsbn("121121");
		  livro.setTitulo("Engenharia de Software");
		  livro.setAutor("Pressman");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		
	}
	
	@Test(expected=RuntimeException.class)
	public void CT01UC06CadastrarLivro_com_isbn_invalido(){
		livro.setIsbn("");
		
	}

	@Test(expected=RuntimeException.class)
	public void CT02UC06CadastrarLivro_com_isbn_invalido(){
		livro.setIsbn(null);
		
	}
	
	
	@Test(expected=RuntimeException.class)
	public void CT03UC06CadastarLivro_com_sucesso(){
		assertEquals("121121",livro.getIsbn());
		
	}


	
	
	@Test(expected=RuntimeException.class)
	public void CT04UC06CadastrarLivro_com_titulo_invalido(){
		livro.setTitulo("");
		
	}

	@Test(expected=RuntimeException.class)
	public void CT05UC06CadastrarLivro_com_titulo_invalido(){
		livro.setTitulo(null);
		
	}
	
	@Test(expected=RuntimeException.class)
	public void CT06UC06CadastarLivro_com_sucesso(){
		assertEquals("Engenharia de Software",livro.getTitulo());
		
	}
	
	
	@Test(expected=RuntimeException.class)
	public void CT07UC06CadastarLivro_com_sucesso(){
		assertEquals("Pressman",livro.getAutor());
		
	}
}

