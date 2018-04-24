package ferreira.filipe.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import ferreira.filipe.entity.Usuario;


public interface UsuarioRepository extends MongoRepository<Usuario, String>{

	List<Usuario> findByNomeLikeIgnoreCase(String nome);

	Usuario findByEmail(String name);

	

}
