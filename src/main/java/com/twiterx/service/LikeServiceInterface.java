package com.twiterx.service;

import com.twiterx.entity.Like;
import com.twiterx.entity.Post;
import com.twiterx.entity.User;

public interface LikeServiceInterface 
{

	Like likePost(Post post, User user);

	long getLikeCount(Post post);

}
