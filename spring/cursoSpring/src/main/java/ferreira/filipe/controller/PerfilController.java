package ferreira.filipe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ferreira.filipe.entity.Perfil;
import ferreira.filipe.entity.Usuario;
import ferreira.filipe.service.PerfilService;
import ferreira.filipe.service.UsuarioService;

@RestController
public class PerfilController {
	
    @Autowired
    PerfilService perfilService;

    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public List<Perfil> listPerfil() {
        return this.perfilService.listaPerfil();
    }
    
    
    @RequestMapping(value = "/perfil", method = RequestMethod.POST)
    public Perfil listPerfil(@RequestBody Perfil perfil) {
        return this.perfilService.salvarPerfil(perfil);
    }
    
    @RequestMapping(value = "/perfil", method = RequestMethod.PUT)
    public Perfil editarPerfil(@RequestBody Perfil perfil) {
        return this.perfilService.salvarPerfil(perfil);
    }
    
    @RequestMapping(value = "/perfil/{id}", method = RequestMethod.DELETE)
    public void deletarPerfil(@PathVariable String id) {
        this.perfilService.deletePerfil(id);
    }
    
    @RequestMapping(value = "/perfil/{id}", method = RequestMethod.GET)
    public Optional<Perfil> consultarPerfil(@PathVariable String id) {
        return this.perfilService.getById(id);
    }
    
    @RequestMapping(value = "/perfil/{page}/{count}", method = RequestMethod.GET)
    public Page<Perfil> listaPerfil(@PathVariable int page, @PathVariable int count) {
        return this.perfilService.listaPaginada(count, page);
    }

}
