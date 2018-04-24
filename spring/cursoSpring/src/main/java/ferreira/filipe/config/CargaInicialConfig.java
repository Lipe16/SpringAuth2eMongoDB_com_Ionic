package ferreira.filipe.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import ferreira.filipe.entity.Perfil;
import ferreira.filipe.entity.Usuario;
import ferreira.filipe.repository.PerfilRepository;
import ferreira.filipe.repository.UsuarioRepository;

@Component
public class CargaInicialConfig implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    UsuarioRepository usuarioRepository;
    
    @Autowired
    PerfilRepository perfilRepository;
    
    
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        List<Perfil> perfis = perfilRepository.findAll();
        
        if(perfis.isEmpty()){
            perfilRepository.save(new Perfil("ROLE_ADMIN"));
            
            Perfil perfil = perfilRepository.findByNome("ROLE_ADMIN");
            
            List<Perfil> perfisUsuario = new ArrayList<>();
            
            perfisUsuario.add(perfil);
            
            
         // Create an encoder with strength 16
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);

            
            
            
            usuarioRepository.save(new Usuario("Filipão",20, perfisUsuario, "admin",  encoder.encode("12345")));
        }
    }

}
