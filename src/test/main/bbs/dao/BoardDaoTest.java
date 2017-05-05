package bbs.dao;

import java.util.List;

import org.unitils.spring.annotation.SpringBean;

import com.bbs.dao.BoardDao;
import com.bbs.domain.Board;


public class BoardDaoTest extends BaseDaoTest {
	
	@SpringBean("boardDao")
	private BoardDao boardDao;
	
	public void addBoard(){
//		List<Board> boards = 
//			XlsDataSetBeanFactory.	
	}

}
