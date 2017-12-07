package com.xdcr.framework.core.login.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xdcr.framework.core.login.dto.SysUser;

/** 
 * 创建时间：2017年11月17日 上午10:41:01 
 * 项目名称：XDCR 
 * @author hm 
 * @version 1.0   
 * @since JDK 1.7
 * 文件名称：ISysUser.java 
 * 类说明： 
 */
@Repository
public interface ISysUser extends JpaSpecificationExecutor<SysUser> ,PagingAndSortingRepository<SysUser, String> {
	
	@Query("from  SysUser a where a.usercode =:username and a.state =1 ")  
	public SysUser findUserByUserName (@Param("username") String username) ;

}
