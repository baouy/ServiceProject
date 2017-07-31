package com.tudou.act.service.ext;

import com.google.common.collect.Lists;
import com.tudou.upms.dao.model.UpmsUser;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.UserQueryImpl;
import org.activiti.engine.impl.persistence.entity.IdentityInfoEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.activiti.engine.impl.persistence.entity.UserEntityManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Activiti User Entity Service
 */
@Service
public class ActUserEntityService extends UserEntityManager {


	public User createNewUser(String userId) {
		return new UserEntity(userId);
	}

	public void insertUser(User user) {
		throw new RuntimeException("not implement method.");
	}

	public void updateUser(UserEntity updatedUser) {
		throw new RuntimeException("not implement method.");
	}

	public UserEntity findUserById(String userId) {

		return  null;
//		return ActUtils.toActivitiUser(getSystemService().getUserByLoginName(userId));
	}

	public void deleteUser(String userId) {
		throw new RuntimeException("not implement method.");
	}

	public List<User> findUserByQueryCriteria(UserQueryImpl query, Page page) {
		throw new RuntimeException("not implement method.");
	}

	public long findUserCountByQueryCriteria(UserQueryImpl query) {
		throw new RuntimeException("not implement method.");
	}

	public List<Group> findGroupsByUser(String userId) {
		List<Group> list = Lists.newArrayList();
		return list;
	}

	public UserQuery createNewUserQuery() {
		throw new RuntimeException("not implement method.");
	}

	public IdentityInfoEntity findUserInfoByUserIdAndKey(String userId, String key) {
		throw new RuntimeException("not implement method.");
	}

	public List<String> findUserInfoKeysByUserIdAndType(String userId, String type) {
		throw new RuntimeException("not implement method.");
	}

	public Boolean checkPassword(String userId, String password) {
		throw new RuntimeException("not implement method.");
	}

	public List<User> findPotentialStarterUsers(String proceDefId) {
		throw new RuntimeException("not implement method.");

	}

	public List<User> findUsersByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
		throw new RuntimeException("not implement method.");
	}

	public long findUserCountByNativeQuery(Map<String, Object> parameterMap) {
		throw new RuntimeException("not implement method.");
	}

	public  UserEntity toActivitiUser(UpmsUser user){
		if (user == null){
			return null;
		}
		UserEntity userEntity = new UserEntity();
		userEntity.setId(user.getUsername());
		userEntity.setFirstName(user.getRealname());
		userEntity.setLastName("");
		userEntity.setPassword(user.getPassword());
		userEntity.setEmail(user.getEmail());
		userEntity.setRevision(1);
		return userEntity;
	}
	
}
