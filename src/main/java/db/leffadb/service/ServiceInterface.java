/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.service;

import java.util.Collection;

/**
 *
 * @author m1k4
 */
public interface ServiceInterface<T> {
    T create(T object);
    T findById(Long id);
    void update(T object);
    void delete(T object);
    void delete(Long id);
    Collection<T> findAll();
}
