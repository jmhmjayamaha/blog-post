package lk.hjsoft.springbootmanytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lk.hjsoft.springbootmanytomany.model.Post;
import lk.hjsoft.springbootmanytomany.model.Tag;
import lk.hjsoft.springbootmanytomany.repository.PostRepository;
import lk.hjsoft.springbootmanytomany.repository.TagRepository;

@SpringBootApplication
@EnableJpaAuditing
public class Application implements CommandLineRunner {
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private TagRepository tagRepo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Post p1 = new Post();
		p1.setTitle("first title");
		p1.setDescription("first description");
		p1.setContent("this is first content");
		
		Tag t1 = new Tag();
		t1.setName("spring");
		
		Tag t2 = new Tag();
		t2.setName("java");
		
		p1.getTags().add(t1);
		p1.getTags().add(t2);
		
		t1.getPosts().add(p1);
		t2.getPosts().add(p1);
		
		postRepo.save(p1);
	}

}
