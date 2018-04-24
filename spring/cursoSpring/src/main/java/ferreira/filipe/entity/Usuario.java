package ferreira.filipe.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.password.PasswordEncoder;

@Document
public class Usuario {
	@Id
	private String id;
	private String nome;
    private int idade;
    private String email;
    private String senha;
    
    @Autowired
    PasswordEncoder passwordEncoder;

   
    
    @DBRef
    private List<Perfil> perfis;
    
    
    
    
    
    
    
    public Usuario() {
	}
    
    public Usuario(Usuario usuario) {
		this.nome = usuario.getNome();
		this.idade = usuario.getIdade();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}

    public Usuario(String nome,int idade,List<Perfil> perfis, String email, String senha) {
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.perfis = perfis;
		this.senha = passwordEncoder.encode(senha);
	}
    
    public void limparSenha() {
    	this.senha = "";
    }
    
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = passwordEncoder.encode(senha);
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
