package com.javatpoint;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDao {
	
	private JdbcTemplate jdbcTemplate;


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) 
	{
		this.jdbcTemplate =  jdbcTemplate; 
	}

	public int saveEmployee(Employee e){
		String query = "insert into employee2 values('"+e.getId()+"','"+e.getName()+"','"+e.getSalary()+"')";
		return jdbcTemplate.update(query);
	}
	public int updateEmployee(Employee e){
		String query = "update employee2 set name='"+e.getName()+"',salary='"+e.getSalary()+"' where id='"+e.getId()+"' ";
		return jdbcTemplate.update(query);
	}
	public int deleteEmployee(Employee e){
		String query = "delete from employee2 where id='"+e.getId()+"' ";
		return jdbcTemplate.update(query);
	}
	
	
	public List<Employee> getAllEmployees()
	{
		return jdbcTemplate.query("select * from employee2",new ResultSetExtractor<List<Employee>>()
		{
//			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException,DataAccessException 
			{
				List<Employee> list=new ArrayList<Employee>();
				while(rs.next())
				{
					Employee e = new Employee();
					e.setId(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setSalary(rs.getInt(3));
					list.add(e);
				}
				return list;
			}
		});
	}
	
	public Boolean saveEmployeeByPreparedStatement(final Employee e)
	{
		String query="insert into employee2 values(?,?,?)";
		return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>()
		{
			public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				ps.setInt(1, e.getId());
				ps.setString(2, e.getName());
				ps.setFloat(3, e.getSalary());

				return ps.execute();

			}
		});
	}
	
	public List<Employee> getAllEmployeesRowMapper(){
		return jdbcTemplate.query("select * from employee2", new RowMapper<Employee>(){
			public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getInt(3));
				System.out.println(rownumber);
				return e;
			}
		});
	}
	
	/* wap to insert data into the bank table ,updata the data and delete the data
	 * display the data using rowmapper and PreparedStatementCallback.
	 */

}
