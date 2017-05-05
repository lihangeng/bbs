package bbs.sample.unitils.excel;

import java.io.File;
import java.util.Arrays;
import java.util.Properties;

import org.unitils.core.UnitilsException;
import org.unitils.dbunit.datasetfactory.DataSetFactory;
import org.unitils.dbunit.util.MultiSchemaDataSet;

public class MultiSchemaXlsDataSetFactory implements DataSetFactory{
	
	protected String defaultSchemaName;

	/**
	 * 从excel文件中创建数据集
	 */
	public MultiSchemaDataSet createDataSet(File... dataSetFiles) {
		 try {  
	            MultiSchemaXlsDataSetReader xlsDataSetReader = new MultiSchemaXlsDataSetReader(  
	                    defaultSchemaName);  
	            return xlsDataSetReader.readDataSetXls(dataSetFiles);  
	        } catch (Exception e) {  
	            throw new UnitilsException("创建数据集失败: "  
	                    + Arrays.toString(dataSetFiles), e);  
	        }  
	}

	/**
	 * 获取数据集的扩展名
	 */
	public String getDataSetFileExtension() {
		
		return "xls";  
	}

	/**
	 * 初始化数据集
	 */
	public void init(Properties configuration, String defaultSchemaName) {

		this.defaultSchemaName =defaultSchemaName;
	}

}
