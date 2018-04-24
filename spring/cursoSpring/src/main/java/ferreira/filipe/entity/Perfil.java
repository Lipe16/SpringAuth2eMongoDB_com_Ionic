package ferreira.filipe.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Document
public class Perfil implements GrantedAuthority{

    @Id
    private String id;

    private String nome;
    
    
    
    

	public Perfil(String nome) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return nome;
	}
    
    

}
