/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.service;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author m1k4
 */
public class RepositoryService<T> implements ServiceInterface<T> {

    protected JpaRepository<T, Long> repository;

    @Override
    public JpaRepository<T, Long> getRepository() {
        return repository;
    }

    public void setRepository(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = false)
    public T create(T object) {
        return repository.save(object);
    }

    @Override
    @Transactional(readOnly = true)
    public T findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(T object) {
        repository.save(object);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(T object) {
        repository.delete(object);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<T> findAll() {
        return repository.findAll();
    }
}
