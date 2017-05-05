package bbs.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBean;

import bbs.sample.unitils.excel.XlsDataSetBeanFactory;

import com.bbs.dao.BoardDao;
import com.bbs.domain.Board;

/**
 * Board的Dao测试类
 * @author John
 *
 */
public class BoardDaoTest extends BaseDaoTest {
	//注入boardDao和autowired类似（我的理解）
	@SpringBean("boardDao")
	private BoardDao boardDao;
	
	/**
	 * 测试添加版块
	 * @throws Exception
	 */
	@Test
//	@ExpectedDataSet("Board.xls")
	public void addBoard() throws Exception{
//		List<Board> boards = 
//			XlsDataSetBeanFactory.createBeans(BoardDaoTest.class, "BoardSave.xls", "t_board", Board.class);
//		
//		for(Board board:boards){
//			boardDao.save(board);
//		}
		Board board = new Board();
		board.setBoardName("体育");
		board.setBoardDesc("体育赛事");
		board.setTopicNum(50);
		boardDao.save(board);
	}
	
	/**
	 * 测试删除版块
	 */
	@Test
	public void remove(){
		Board board =boardDao.get(1);
		boardDao.remove(board);
	}
	
	/**
	 * 测试加载版块
	 */
	@Test
	public void getBoard(){
		Board board =boardDao.load(1);
		Assert.assertNotNull(board);
		
	}

}
