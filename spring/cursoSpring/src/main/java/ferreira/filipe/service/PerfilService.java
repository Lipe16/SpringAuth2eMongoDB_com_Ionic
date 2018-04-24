package ferreira.filipe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ferreira.filipe.entity.Perfil;
import ferreira.filipe.repository.PerfilRepository;

@Service
public class PerfilService {

	
    @Autowired
    PerfilRepository perfilRepository;

    public List<Perfil> listaPerfil() {
        return perfilRepository.findAll();
    }

    public Page<Perfil> listaPaginada(int count, int page) {
        Pageable pages = new PageRequest(page, count);
        return perfilRepository.findAll(pages);
    }


    public Perfil salvarPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    public void deletePerfil(String id) {
        perfilRepository.deleteById(id);
    }

    public Optional<Perfil> getById(String id) {
        return perfilRepository.findById(id);
    }
}
