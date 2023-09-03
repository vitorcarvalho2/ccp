package br.edu.ufj.CCP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ufj.CCP.models.Categoria;
import br.edu.ufj.CCP.models.Comentarios;
import br.edu.ufj.CCP.models.Postagem;
import br.edu.ufj.CCP.models.Usuario;
import br.edu.ufj.CCP.repositories.CategoriaDAO;
import br.edu.ufj.CCP.repositories.ComentariosDAO;
import br.edu.ufj.CCP.repositories.PostagemDAO;
import br.edu.ufj.CCP.repositories.UsuarioDAO;

@SpringBootApplication
public class CcpApplication implements CommandLineRunner {
	
    @Autowired
    private PostagemDAO postDAO;
    private UsuarioDAO userDAO;
    private ComentariosDAO commDAO;
    private CategoriaDAO catDAO;
    
	public static void main(String[] args) {
		SpringApplication.run(CcpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	     
		Categoria cat1 = new Categoria(1,"Duvida");
		catDAO.save(cat1);
		Categoria cat2 = new Categoria(2,"Completo");
		catDAO.save(cat2);
		Categoria cat3 = new Categoria(3,"Erro");
		catDAO.save(cat3);
		Usuario user1 = new Usuario(1,"vitor","vitorobala@gmail.com","vitinamaamaria");
		userDAO.save(user1);
		Postagem post1 = new Postagem(1,cat1,user1,"abuble","import vitor");
		postDAO.save(post1);
		Comentarios comm1 = new Comentarios(1,post1,user1,"muito poggers");
		commDAO.save(comm1);
	}

}
