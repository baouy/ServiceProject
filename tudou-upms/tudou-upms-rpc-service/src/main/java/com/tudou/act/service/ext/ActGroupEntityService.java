package com.tudou.act.service.ext;

import com.google.common.collect.Lists;
import com.tudou.upms.dao.model.UpmsRole;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.GroupQuery;
import org.activiti.engine.impl.GroupQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Activiti Group Entity Service
 */
@Service
public class ActGroupEntityService extends GroupEntityManager {

	public Group createNewGroup(String groupId) {
		return new GroupEntity(groupId);
	}

	public void insertGroup(Group group) {
		throw new RuntimeException("not implement method.");
	}

	public void updateGroup(GroupEntity updatedGroup) {
		throw new RuntimeException("not implement method.");
	}

	public void deleteGroup(String groupId) {
		throw new RuntimeException("not implement method.");
	}

	public GroupQuery createNewGroupQuery() {
		throw new RuntimeException("not implement method.");
	}

	public List<Group> findGroupByQueryCriteria(GroupQueryImpl query, Page page) {
		throw new RuntimeException("not implement method.");
	}

	public long findGroupCountByQueryCriteria(GroupQueryImpl query) {
		throw new RuntimeException("not implement method.");
	}

	public List<Group> findGroupsByUser(String userId) {
		List<Group> list = Lists.newArrayList();
		return list;
	}

	public List<Group> findGroupsByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
		throw new RuntimeException("not implement method.");
	}

	public long findGroupCountByNativeQuery(Map<String, Object> parameterMap) {
		throw new RuntimeException("not implement method.");
	}

	public GroupEntity toActivitiGroup(UpmsRole role){
		if (role == null){
			return null;
		}
		GroupEntity groupEntity = new GroupEntity();
		groupEntity.setId(role.getRoleId().toString());
		groupEntity.setName(role.getName());
		groupEntity.setType(role.getTitle());
		groupEntity.setRevision(1);
		return groupEntity;
	}

}