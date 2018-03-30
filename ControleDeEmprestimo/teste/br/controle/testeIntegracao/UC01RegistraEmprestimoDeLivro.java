package br.controle.testeIntegracao;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.controle.modelo.Emprestimo;
import br.controle.modelo.Livro;
import br.controle.modelo.Usuario;
import br.emprestimo.servico.ServicoEmprestimo;

public class UC01RegistraEmprestimoDeLivro {

	static private Livro livro;
	static private Usuario usuario, usuario2;
	static private ServicoEmprestimo servico;
	static private Emprestimo emprestimo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// cenario
		livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		usuario = new Usuario();
		usuario.setRa("11111");
		usuario.setNome("Jose da Silva");
		servico = new ServicoEmprestimo();
		emprestimo = new Emprestimo();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/*
	 * Verifica o comportamento da classe servico metodo empresta
	 */
	@Test
	public void CT01UC01FB_registra_emprestimo_com_sucesso() {
		assertNotNull(servico.empresta(livro, usuario));
	}

	@Test(expected = RuntimeException.class)
	public void CT02UC01FB_registrar_emprestimo_com_dados_invalidos() {
		servico.empresta(null, usuario);
	}

	@Test
	public void CT03UC01FB_registrar_emprestimo_com_dados_invalidos() {
		try {
			servico.empresta(null, usuario);
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			assertEquals("Dados inválidos.", e.getMessage());
		}
	}

	@Test
	public void CT02UC01FB_registra_emprestimo_com_sucesso_validacao_da_data() {
		// acao
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd-MM-YYYY");
		String dataEsperada = new DateTime().plusDays(8).toString(fmt);
		emprestimo = servico.empresta(livro, usuario);
		String dataObtida = emprestimo.getDataDevolucao();
		// verificacao
		assertTrue(dataEsperada.equals(dataObtida));
	}
	
	@Test
	public void CT05UC01CadastrarLivro_com_sucesso(){
		Livro resultadoEsperado = new Livro();
		resultadoEsperado.setIsbn("121212");
		resultadoEsperado.setTitulo("Engenharia de Software");
		resultadoEsperado.setAutor("Pressman");
		assertTrue(resultadoEsperado.equals(servico.empresta(livro, usuario).getLivro()));
		
	}
	
	@Test
	public void CT06UC01CadastrarEmprestimo_com_livro_invalido(){
		emprestimo.setLivro(null);
		
	}
	@Test
	public void CT05Verificar_o_metodo_getIsbn() {
		assertEquals("121212", livro.getIsbn());
	}

	@Test(expected = RuntimeException.class)
	public void CT06verificar_o_metodo_setIsbn_vazio() {
		livro.setIsbn("");
	}

	@Test(expected = RuntimeException.class)
	public void CT07verificar_o_metodo_setIsbn_null() {
		livro.setIsbn(null);
	}
	
	@Test
	public void CT08Verificar_o_metodo_getTitulo() {
		assertEquals("Engenharia de Software", livro.getTitulo());
	}
	
	@Test
	public void CT09Verificar_o_metodo_getLivro() {
		Livro resultadoEsperado = new Livro();
		resultadoEsperado.setIsbn("121212");
		resultadoEsperado.setTitulo("Engenharia de Software");
		resultadoEsperado.setAutor("Pressman");
		assertEquals("Emprestimo", emprestimo.getLivro());
	}
	
	@Test
	public void CT10Verificar_o_metodo_getUsuario() {
		assertEquals("Emprestimo", emprestimo.getUsuario());
	}
	
	@Test
	public void CT11Verificar_o_metodo_getAutor() {
		assertEquals("Pressman", livro.getAutor());
	}
	
	@Test
	public void CT12Verificar_o_metodo_getRa() {
		assertEquals("11111", usuario.getRa());
	}
	
	@Test
	public void CT13Verificar_o_metodo_getNome() {
		assertEquals("Jose da Silva", usuario.getNome());
	}
	
	@Test
	public void CT14Verificar_o_metodo_equals_this() {
		usuario.equals(usuario);
	}
	
	@Test
	public void CT15Verificar_o_metodo_equals_null() {
		usuario.equals(null);
	}
	
	@Test
	public void CT16Verificar_o_metodo_equals_getClass() {
		usuario.equals(getClass());
	}
	
	@Test
	public void CT17Verificar_o_metodo_equals_usuario_diferente() {

		usuario2 = new Usuario();
		usuario2.setRa("11111");
		usuario2.setNome("Jose da Silva");
		usuario.equals(usuario2);
	}
	
	@Test
	public void CT18Verificar_o_metodo_equals_usuario_diferente_nome_diferente() {

		usuario2 = new Usuario();
		usuario2.setRa("11111");
		usuario2.setNome("Jose Aguiar");
		usuario.equals(usuario2);
	}
	
	@Test
	public void CT19Verificar_o_metodo_equals_usuario_diferente_nome_null() {

		usuario2 = new Usuario();
		usuario2.setRa("11111");
		usuario2.setNome(null);
		usuario2.equals(usuario);
	}


	@Test
	public void CT20Verificar_o_metodo_equals_usuario_diferente_ra_null() {

		usuario2 = new Usuario();
		usuario2.setRa(null);
		usuario2.setNome("Jose da Silva");
		usuario2.equals(usuario);
	}
	
	@Test
	public void CT21Verificar_o_metodo_equals_usuario_diferente_ra_diferente() {

		usuario2 = new Usuario();
		usuario2.setRa("121212");
		usuario2.setNome("Jose da Silva");
		usuario2.equals(usuario);
	}
	
	@Test
	public void CT22Verificar_o_metodo_equals_getRa() {
		usuario.equals(usuario.getRa());
	}
	
	@Test
	public void CT23Verificar_o_metodo_equals_getRa() {
		usuario.equals(usuario.getRa());
	}
	
	
}
