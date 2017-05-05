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
 * Board��Dao������
 * @author John
 *
 */
public class BoardDaoTest extends BaseDaoTest {
	//ע��boardDao��autowired���ƣ��ҵ���⣩
	@SpringBean("boardDao")
	private BoardDao boardDao;
	
	/**
	 * ������Ӱ��
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
		board.setBoardName("����");
		board.setBoardDesc("��������");
		board.setTopicNum(50);
		boardDao.save(board);
	}
	
	/**
	 * ����ɾ�����
	 */
	@Test
	public void remove(){
		Board board =boardDao.get(1);
		boardDao.remove(board);
	}
	
	/**
	 * ���Լ��ذ��
	 */
	@Test
	public void getBoard(){
		Board board =boardDao.load(1);
		Assert.assertNotNull(board);
		
	}

}
