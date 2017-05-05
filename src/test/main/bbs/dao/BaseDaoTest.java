package bbs.dao;

import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;
/**
 * 加载DAO层配置信息
 * @author John
 *
 */
//加载dao配置信息，并且初始化dao层的bean
@SpringApplicationContext({"classpath:/bbs-dao.xml"})
public class BaseDaoTest extends UnitilsJUnit4 {
   
}
