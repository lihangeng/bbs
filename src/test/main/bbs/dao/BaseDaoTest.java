package bbs.dao;

import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;
/**
 * ����DAO��������Ϣ
 * @author John
 *
 */
//����dao������Ϣ�����ҳ�ʼ��dao���bean
@SpringApplicationContext({"classpath:/bbs-dao.xml"})
public class BaseDaoTest extends UnitilsJUnit4 {
   
}
