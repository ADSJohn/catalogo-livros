package service;

import conversor.LivroConversor;
import dto.LivroDto;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.transaction.Transactional;
import orm.Livro;
import repository.LivroRepository;

import java.util.List;
import java.util.UUID;

@WebService
public class LivroService {

	@Inject
	LivroConversor livroConversor;

	@Inject
	LivroRepository livroRepository;

	@Transactional
	@WebMethod
	public LivroDto create(@WebParam(name = "arg0", targetNamespace = "http://service/") LivroDto livroDto) {
		var livro = livroConversor.dtoToEntity(livroDto);
		livroRepository.persist(livro);
		return livroConversor.entityToDto(livro);
	}

	@WebMethod
	public LivroDto findById(String id) {
		var livro = livroRepository.findById(UUID.fromString(id));
		return livroConversor.entityToDto(livro);
	}

}
