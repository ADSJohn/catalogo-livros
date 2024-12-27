package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;
import orm.Livro;

import java.util.UUID;

@RequestScoped
public class LivroRepository implements PanacheRepositoryBase<Livro, UUID> {
}
