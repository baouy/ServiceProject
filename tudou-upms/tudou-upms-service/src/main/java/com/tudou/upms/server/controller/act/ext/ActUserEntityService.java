package com.tudou.upms.server.controller.act.ext;

import com.google.common.collect.Lists;
import com.tudou.upms.dao.model.UpmsRole;
import com.tudou.upms.dao.model.UpmsUser;
import com.tudou.upms.rpc.api.UpmsApiService;
import com.tudou.upms.rpc.api.UpmsUserService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.UserQueryImpl;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.IdentityInfoEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.activiti.engine.impl.persistence.entity.UserEntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class ActUserEntityService extends UserEntityManager {

	@Autowired
	private UpmsApiService upmsApiService;

	@Autowired
	private UpmsUserService upmsUserService;


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
		UpmsUser upmsUser = upmsUserService.selectByPrimaryKey(Integer.valueOf(userId));
		return toActivitiUser(upmsUser);
	}

	public void deleteUser(String userId) {
		User user = findUserById(userId);
		if (user != null) {
			upmsUserService.deleteByPrimaryKey(Integer.valueOf(userId));
		}
	}

	public List<User> findUserByQueryCriteria(UserQueryImpl query, Page page) {
		throw new RuntimeException("not implement method.");
	}

	public long findUserCountByQueryCriteria(UserQueryImpl query) {
		throw new RuntimeException("not implement method.");
	}

	public List<Group> findGroupsByUser(String userId) {
		List<Group> list = Lists.newArrayList();
		List<UpmsRole> upmsRoles = upmsApiService.selectUpmsRoleByUpmsUserIdByCache(Integer.valueOf(userId));
		for (UpmsRole upmsRole : upmsRoles){
			list.add(toActivitiGroup(upmsRole));
		}
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

	public GroupEntity toActivitiGroup(UpmsRole role){
		if (role == null){
			return null;
		}
		GroupEntity groupEntity = new GroupEntity();
		groupEntity.setId(role.getRoleId()+"");
		groupEntity.setName(role.getName());
		groupEntity.setType(role.getTitle());
		groupEntity.setRevision(1);
		return groupEntity;
	}

	public static UserEntity toActivitiUser(UpmsUser user){
		if (user == null){
			return null;
		}
		UserEntity userEntity = new UserEntity();
		userEntity.setId(user.getUserId()+"");
		userEntity.setFirstName(user.getRealname());
		userEntity.setLastName("");
		userEntity.setPassword(user.getPassword());
		userEntity.setEmail(user.getEmail());
		userEntity.setRevision(1);
		return userEntity;
	}
	
}
