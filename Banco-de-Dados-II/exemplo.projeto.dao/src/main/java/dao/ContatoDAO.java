package dao;

import java.util.List;

import dados.Contato;

public interface ContatoDAO {
	void add(Contato contato);
	void removeContatoBy(int id);
	List<Contato> buscaGeral(String texto);
	Object buscaAvançada(Contato contato);
	Contato getContatoBy(int id);
	List<Contato> all();
	void close();
}
