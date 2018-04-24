package ferreira.filipe.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ferreira.filipe.entity.Perfil;


public interface PerfilRepository extends MongoRepository<Perfil, String>{

	Perfil findByNome(String role_admin);


}
