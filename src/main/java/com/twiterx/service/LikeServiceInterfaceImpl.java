package com.twiterx.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twiterx.entity.Like;
import com.twiterx.entity.Post;
import com.twiterx.entity.User;
import com.twiterx.repository.LikeRepository;

@Service
public class LikeServiceInterfaceImpl implements LikeServiceInterface
{

	
	@Autowired
    private LikeRepository likeRepository;

    public Like likePost(Post post, User user) {

        if (likeRepository.existsByPostAndUser(post, user)) {
            throw new RuntimeException("User already liked this post");
        }

        Like like = new Like();
        like.setPost(post);
        like.setUser(user);
        like.setLikedAt(LocalDateTime.now());

        return likeRepository.save(like);
    }
    
    public long getLikeCount(Post post) {
        return likeRepository.countByPost(post);
    }

}
