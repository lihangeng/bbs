package bbs.service;

import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.junit.Before;
import org.junit.Test;
import org.unitils.spring.annotation.SpringBean;

import com.bbs.domain.User;
import com.bbs.exception.UserExistException;
import com.bbs.service.UserService;
/**
 * 
 * @author John
 *
 */
public class UserServiceTest extends BaseServiceTest {

	@SpringBean("userService")
	private UserService userService;
	
	/**
	 * �ڲ��Գ�ʼ���У�����hibernate�������棬����Ӱ����ԣ���ʱ���о�һ�¶�������Ĵ洢����
	 */
	@SuppressWarnings("unchecked")
	@Before
	public void init(){
		SessionFactory sf = hibernateTemplate.getSessionFactory();
		Map<String,CollectionMetadata> roleMap = sf.getAllCollectionMetadata();
		for(String roleName:roleMap.keySet()){
			sf.evictCollection(roleName);
		}
		Map<String,ClassMetadata> entityMap = sf.getAllClassMetadata();
		for(String entityName:entityMap.keySet()){
			sf.evictEntity(entityName);
		}
		sf.evictQueries();
	}
	/**
	 * ����Serviceע��һ���û�
	 * @throws UserExistException
	 */
	@Test
	public void registerTest() throws UserExistException{
		User user = new User();
		user.setUserName("leilei");
		user.setCredit(1);
		user.setLocked(0);
		user.setUserIp("10.2.8.111");
		user.setPassword("123456");
		userService.register(user);
	}
}
