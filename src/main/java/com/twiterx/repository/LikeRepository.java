package com.twiterx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twiterx.entity.Like;
import com.twiterx.entity.Post;
import com.twiterx.entity.User;
@Repository
public interface LikeRepository extends JpaRepository<Like,Long>
{

	boolean existsByPostAndUser(Post post, User user);

	long countByPost(Post post);

}
