package com.xdcr.framework.core.config.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.log4j.Logger;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/** 
 * 创建时间：2017年11月17日 上午11:25:34 
 * 项目名称：XDCR 
 * @author hm 
 * @version 1.0   
 * @since JDK 1.7
 * 文件名称：ShiroConfiguration.java 
 * 类说明： 
 */
@Configuration
public class ShiroConfiguration {
	
	Logger logger = Logger.getLogger(ShiroConfiguration.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * * ShiroFilterFactoryBean 处理拦截资源文件问题。 
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在 
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager 
     * 
        Filter Chain定义说明 
       1、一个URL可以配置多个Filter，使用逗号分隔 
       2、当设置多个过滤器时，全部验证通过，才视为通过 
       3、部分过滤器可指定参数，如perms，roles 
	* <p>Title: shiroFilter</p>
	* <p>Description: </p>
	* @param manager
	* @return
	 */
	@Bean(name="shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager manager) {
        ShiroFilterFactoryBean tShiroFilterFactoryBean=new ShiroFilterFactoryBean();
        Map<String, Filter> filters = tShiroFilterFactoryBean.getFilters();
        
        filters.put("bfAuthc", new BasicFormAuthenticationFilter());
        
        tShiroFilterFactoryBean.setFilters(filters);
        tShiroFilterFactoryBean.setSecurityManager(manager);
        tShiroFilterFactoryBean.setLoginUrl("/login");
        tShiroFilterFactoryBean.setSuccessUrl("/index");
        tShiroFilterFactoryBean.setUnauthorizedUrl("/error/error");
        //拦截器.  
        LinkedHashMap<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        //配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/login", "bfAuthc");
        filterChainDefinitionMap.put("/index", "bfAuthc");
        filterChainDefinitionMap.put("/common/**", "anon");
        tShiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return tShiroFilterFactoryBean;
    }
    //配置核心安全事务管理器
    @Bean(name="securityManager")
    public DefaultWebSecurityManager securityManager() {
    	logger.info("--------------shiro已经加载----------------");
    	DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
    	manager.setRealm(authRealm());//将自己的Realm注入到securityManager中
        return manager;
    }
    //配置自定义的权限登录器
    @Bean
    public AuthRealm authRealm() {
        AuthRealm authRealm=new AuthRealm();
        authRealm.setCredentialsMatcher(credentialsMatcher());
        return authRealm;
    }
    //配置自定义的密码比较器
    @Bean
    public CredentialsMatcher credentialsMatcher() {
        return new CredentialsMatcher();
    }
    /** 
     * 凭证匹配器 
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了 
     *  所以我们需要修改下doGetAuthenticationInfo中的代码; 
     * ） 
     * @return 
     */ 
	/*@Bean 
	public HashedCredentialsMatcher hashedCredentialsMatcher(){ 
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher(); 
		hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;  
		hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5("")); 
		return hashedCredentialsMatcher;
	}*/
    /*@Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator=new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager manager) {
        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }*/
}

