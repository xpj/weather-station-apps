package cz.xpj.weatherstation.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.security.access.prepost.PreAuthorize;

import java.io.Serializable;

@NoRepositoryBean
@PreAuthorize("hasRole('ROLE_USER')")
public interface SecuredCrudRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {

    @PreAuthorize("hasRole('ROLE_PUSH')")
    <S extends T> S save(S entity);

    @PreAuthorize("hasRole('ROLE_PUSH')")
    <S extends T> Iterable<S> save(Iterable<S> entities);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(ID id);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(T entity);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Iterable<? extends T> entities);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteAll();

}
