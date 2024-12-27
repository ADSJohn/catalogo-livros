package service;

import conversor.LivroConversor;
import dto.LivroDto;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.transaction.Transactional;
import repository.LivroRepository;

import java.util.List;

@WebService
public class LivroService {

	@Inject
	LivroConversor livroConversor;

	@Inject
	LivroRepository livroRepository;

	@Transactional
	@WebMethod
	public LivroDto create(LivroDto livroDto) {
		var livro = livroConversor.dtoToEntity(livroDto);
		livroRepository.persist(livro);
		return livroConversor.entityToDto(livro);
	}
}
