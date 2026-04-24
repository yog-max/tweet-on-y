package com.twiterx.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twiterx.entity.User;
import com.twiterx.repository.UserRepository;

@Service
public class ServiceInterfaceImpl implements UserServiceInterface
{

	@Autowired
	private UserRepository repo;
	
	@Override
	public User save(User user) {
		
		return repo.save(user);
	}

	@Override
	public List<User> findAll() {
		
		return repo.findAll();
	}

	@Override
	public String updateById(long userId, User update) 
	{
	 Optional<User> exist = repo.findById(userId);
	 
	 if(exist.isPresent())
	 {
		 User existing = exist.get();
		 existing.setUserName(update.getUserName());
		 existing.setIsPremium(update.getIsPremium());
		 return "user details updated: "+repo.save(existing);
	 }
	 else
	 {
		 return "user does not exist";
	 }
		
		
	}

	@Override
	public String deleteById(long userId) {
		
		Optional<User> exist = repo.findById(userId);
		
		if(exist.isPresent())
		{
			repo.deleteById(userId);
			return "user deleted successfully: " ;

		}
		else
		{
			return "user id does not exist";
		}
	}

	@Override
	public Optional<User> findById(long userId) {
		
		return repo.findById(userId);
	}

}
