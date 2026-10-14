package com.leetjourney.taskmanager.repository;

import com.leetjourney.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}

//  org.springframework.stereotype.Repository
/*
 * @Repository
 *  Indicates that an annotated class is a "Repository".
 *  Originally defined by Domain-Driven Design (Evans, 2003) as "a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects."
 */

// import org.springframework.data.jpa.repository.JpaRepository;
/*
 * JpaRepository<Task, Long>
 *  Method Summary
 *      void deleteAllByIdInBatch(Iterable<ID> ids) : Deletes the entities identified by the given ids using a single query.
 *      void deleteAllInBatch() : Deletes all entities in a batch call.
 *      void deleteAllInBatch(Iterable<T> entities) : Deletes the given entities in a batch which means it will create a single query.
 *      <S extends T> List<S> findAll(Example<S> example)
 *      <S extends T> List<S> findAll(Example<S> example, Sort sort)
 *      void flush() : Flushes all pending changes to the database.
 *      T getReferenceById(ID id) : Returns a reference to the entity with the given identifier.
 *      <S extends T> List<S> saveAllAndFlush(Iterable<S> entities) : Saves all entities and flushes changes instantly.
 *      <S extends T> S saveAndFlush(S entity) : Saves an entity and flushes changes instantly.
 */
