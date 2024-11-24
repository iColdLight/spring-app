package com.coldlight.repository;

import com.coldlight.model.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CommentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Comment> findAll() {
        return entityManager.createQuery("from Comment", Comment.class).getResultList();
    }

    public Comment save(Comment comment) {
        if (comment.getId() == null) {
            entityManager.persist(comment);
        } else {
            entityManager.merge(comment);
        }
        return comment;
    }

    public Comment findById(Long id) {
        return entityManager.find(Comment.class, id);
    }

    public void delete(Comment comment) {
        entityManager.remove(entityManager.contains(comment) ? comment : entityManager.merge(comment));
    }
}
