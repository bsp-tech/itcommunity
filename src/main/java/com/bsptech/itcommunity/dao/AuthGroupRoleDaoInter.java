package com.bsptech.itcommunity.dao;

import com.bsptech.itcommunity.entity.AuthGroup;
import com.bsptech.itcommunity.entity.AuthGroupRole;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface AuthGroupRoleDaoInter extends CrudRepository<AuthGroupRole, Integer> {

    List<AuthGroupRole> findByGroupId(AuthGroup group);
}
