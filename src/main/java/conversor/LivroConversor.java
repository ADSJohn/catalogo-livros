package conversor;

import dto.LivroDto;
import jakarta.enterprise.context.RequestScoped;
import orm.Livro;

import java.util.List;

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

	public Livro dtoToEntity(LivroDto livroDto) {
		return dtoToEntity(livroDto, new Livro());
	}

	public LivroDto entityToDto(Livro livro, LivroDto livroDto) {
		livroDto.setNome(livro.getNome());
		livroDto.setEditora(livro.getEditora());
		livroDto.setResumo(livro.getResumo());
		livroDto.setAnoDePublicacao(livro.getAnoDePublicacao());
		livroDto.setAutores(livro.getAutores());
		return livroDto;
	}

	public LivroDto entityToDto(Livro livro) {
		return entityToDto(livro, new LivroDto());
	}

	public List<Livro> dtoListToEntity(List<LivroDto> livros) {
		if (livros == null) return null;
		return livros.stream().map(this::dtoToEntity).toList();
	}

	public List<LivroDto> entityListToDto(List<Livro> livros) {
		if (livros == null) return null;
		return livros.stream().map(this::entityToDto).toList();
	}
}
