package br.edu.ufj.CCP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ufj.CCP.models.Postagem;
import br.edu.ufj.CCP.repositories.PostagemDAO;

@SpringBootApplication
public class CcpApplication implements CommandLineRunner {
	
    @Autowired
    private PostagemDAO postDAO;
    
	public static void main(String[] args) {
		SpringApplication.run(CcpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Postagem post1 = new Postagem(1,"abuble","codigo");
		postDAO.save(post1);
	}

}
