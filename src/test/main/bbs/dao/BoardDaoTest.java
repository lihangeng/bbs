package bbs.dao;

import java.util.List;

import org.junit.Test;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBean;

import bbs.sample.unitils.excel.XlsDataSetBeanFactory;

import com.bbs.dao.BoardDao;
import com.bbs.domain.Board;


public class BoardDaoTest extends BaseDaoTest {
	
	@SpringBean("boardDao")
	private BoardDao boardDao;
	
	@Test
	@ExpectedDataSet("Board.xls")
	public void addBoard() throws Exception{
		List<Board> boards = 
			XlsDataSetBeanFactory.createBeans(BoardDaoTest.class, "BoardSave.xls", "t_board", Board.class);
		
		for(Board board:boards){
			boardDao.save(board);
		}
	}

}
