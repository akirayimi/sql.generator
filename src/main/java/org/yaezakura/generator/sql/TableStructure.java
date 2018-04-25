package org.yaezakura.generator.sql;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.yaezakura.generator.sql.exception.CreateTableSqlException;
import org.yaezakura.generator.sql.type.Type;

public class TableStructure {
	private StringBuilder createTableSql;
	private String tableName;
	private List<Field> fields;
	
	private String[] fieldsSource;
	
	
	
	public TableStructure(String createTableSql){
		createTableSql = createTableSql.replace("`", "");
		
		checkValid(new StringBuilder(createTableSql));
		
		this.createTableSql = new StringBuilder(createTableSql);
		
		tableName = parseTabName();
		fields = parseFields();
	}
	
	public String tableName(){
		return tableName;
	}
	
	public List<Field> fields(){
		return fields;
	}
	
	/**
	 * 检查建表语句是否有语法错误
	 * @param createTableSql
	 */
	private void checkValid(StringBuilder createTableSql) {
		checkHead(createTableSql);
		checkBody(createTableSql);
	}
	
	

	private final static Pattern headPattern = Pattern.compile("[cC][rR][eE][aA][tT][eE]\\s+[tT][aA][bB][lL][eE]\\s+[_a-zA-Z]+");
	private void checkHead(StringBuilder createTableSql){
		if (!headPattern.matcher(createTableSql).find())
			throw new CreateTableSqlException("建表语句有误, 请检查sql语句是否是[create table + 表名](不区分大小写)开头.");
	}
	
	private void checkBody(StringBuilder sql) {
		int start = sql.indexOf("(");
		int end = sql.lastIndexOf(")");
		if (start == -1 || end == -1)
			throw new CreateTableSqlException("建表语法错误, 请用括号将表结构语句包围.");
		String body = sql.substring(start + 1, end);
		String[] fields = body.split(",");
		if (fields == null || fields.length == 0)
			throw new CreateTableSqlException("没有有效的字段.");
		
		for (String field : fields){
			String[] fieldDefine = field.split("\\s+");
			if (fieldDefine == null || fieldDefine.length < 2){
				throw new CreateTableSqlException("表字段定义错误.");
			}
		}
		
		fieldsSource = fields;
	}
	
	private String parseTabName(){
		String ret = ""	;
		Matcher m = headPattern.matcher(createTableSql);
		while(m.find()){
			String complex = m.group();
			String[] cs = complex.split(" ");
			ret = cs[cs.length - 1];
			break;
		}
		return ret;
	}
	
	private List<Field> parseFields(){
		List<Field> list = new ArrayList<Field>();
		for (String fieldStr : fieldsSource){
			String[] detail = fieldStr.trim().split("\\s+");
			Type type = Type.getType(detail[1]);
			if (type == null)
				continue;
			String filedName = detail[0];
			Field field = new Field(filedName, type);
			list.add(field);
		}
		return list;
	}
	
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("D:/development/workspace/generator.sql/target/classes/org/yaezakura/generator/sql/createTable.sql"), "r");
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = raf.readLine()) != null)
			sb.append(line).append("\r\n");
		String sql = sb.toString();
		TableStructure ts = new TableStructure(sql);
		System.out.println(ts.tableName());
		for (Field type : ts.fields()){
			System.out.println(type);
		}
	}
}
