package ferreira.filipe.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import ferreira.filipe.entity.Usuario;
import ferreira.filipe.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
    public List<Usuario> listaUsuario() {
    	
        return usuarioRepository.findAll();
    }
    
   
    
    public Page<Usuario> listaPaginada(int count, int page) {
        Pageable pages = new PageRequest(page, count, Direction.ASC, "id");
        return usuarioRepository.findAll(pages);
    }

    public List<Usuario> buscaPorNome(String nome) {
        return usuarioRepository.findByNomeLikeIgnoreCase(nome);
    }
    
    

    public Usuario save(Usuario usuario) {

    	return usuarioRepository.save(usuario);
    }
    
    public void deletar(String id) {

    	usuarioRepository.deleteById(id);
    }
    
    public Optional<Usuario> consultar(String id) {

    	return usuarioRepository.findById(id);
    }



	public Usuario retornarUsuarioPorEmail(String username) {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario();
		usuario =  usuarioRepository.findByEmail(username);
		
		usuario.limparSenha();
	
		return usuario;
	}
    
}
