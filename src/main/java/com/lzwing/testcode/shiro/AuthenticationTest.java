package com.lzwing.testcode.shiro;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/23
 * Time: 16:20
 */
@Slf4j
public class AuthenticationTest {

    AuthorizingRealm realm;

    @Before
    public void addUser() {
//        simpleAccountRealm();
//        jdbcRealm();
        customRealm();
    }

    private void customRealm() {
        realm = new CustomRealm();
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1);
        realm.setCredentialsMatcher(matcher);
    }

    private void jdbcRealm() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/testdb?useUnicode = true&characterEncoding=UTF-8");
        dataSource.setUsername("mysdc");
        dataSource.setPassword("mysdc");
        realm = new JdbcRealm();
        JdbcRealm jdbcRealm = ((JdbcRealm)realm);
        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setPermissionsLookupEnabled(true);

        String sql = "select password from tt_user where user_name=?";
        jdbcRealm.setAuthenticationQuery(sql);

        String roleSql = "select role_name from tt_user_role where user_name=?";
        jdbcRealm.setUserRolesQuery(roleSql);

        String permissionSql = "select permission from tt_role_permission where role_name=?";
        jdbcRealm.setPermissionsQuery(permissionSql);

    }

    private void simpleAccountRealm() {
        realm = new SimpleAccountRealm();
        ((SimpleAccountRealm) realm).addAccount("Mark","123456","admin");
    }

    @Test
    public void testAuthentication() {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(realm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Mark", "123456");

        subject.login(token);
        System.out.println(subject.isAuthenticated());

        subject.checkRole("admin");

        subject.checkPermissions("admin:select","admin:update");

        subject.logout();
        System.out.println(subject.isAuthenticated());

    }
}
