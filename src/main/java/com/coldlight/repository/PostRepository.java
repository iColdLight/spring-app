package com.coldlight.repository;

import com.coldlight.model.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PostRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Post> findAll() {
        return entityManager.createQuery("from Post", Post.class).getResultList();
    }

    public Post save(Post post) {
        if (post.getId() == null) {
            entityManager.persist(post);
        } else {
            entityManager.merge(post);
        }
        return post;
    }

    public Post findById(Long id) {
        return entityManager.find(Post.class, id);
    }

    public void delete(Post post) {
        entityManager.remove(entityManager.contains(post) ? post : entityManager.merge(post));
    }
}
