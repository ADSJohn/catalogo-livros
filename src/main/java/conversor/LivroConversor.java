package conversor;

import dto.LivroDto;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import orm.Livro;

@RequestScoped
public class LivroConversor {

	public Livro dtoToEntity(LivroDto livroDto, Livro livro) {
		livro.setNome(livroDto.getNome());
		livro.setEditora(livroDto.getEditora());
		livro.setResumo(livroDto.getResumo());
		livro.setAnoDePublicacao(livroDto.getAnoDePublicacao());
		livro.setAutores(livroDto.getAutores());
		return livro;
	}
}
