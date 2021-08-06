/* wap to insert data into the bank table ,updata the data and delete the data
 * display the data using rowmapper and PreparedStatementCallback.
 */

package assg1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
//import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


public class BankDAO {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public Boolean insertAcc(final Bank b)
	{
		String query="insert into bank values(?,?,?)";
		return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>()
		{
			public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				ps.setInt(1, b.getAccno());
				ps.setString(2, b.getName());
				ps.setFloat(3, b.getBal());

				return ps.execute();
			}
		});
	}
	
	public Boolean updateAccName(final Bank b)
	{
		String query="update bank set name=? where accno=?";
		return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>()
		{
			public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				ps.setInt(2, b.getAccno());
				ps.setString(1, b.getName());

				return ps.execute();
			}
		});
	}
	
	public Boolean updateAccBal(final Bank b)
	{
		String query="update bank set balance=? where accno=?";
		return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>()
		{
			public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				ps.setInt(2, b.getAccno());
				ps.setFloat(1, b.getBal());

				return ps.execute();
			}
		});
	}
	
	public Boolean delAcc(final Bank b)
	{
		String query="delete from bank where accno=?";
		return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>()
		{
			public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				ps.setInt(1, b.getAccno());

				return ps.execute();
			}
		});
	}
		
	
	public Bank getAcc(final int accno)
	{
		String query="select * from bank where accno=?";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Bank>()
		{
			public Bank doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				ps.setInt(1, accno);
				
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					Bank b = new Bank();
					b.setAccno(rs.getInt("accno"));
					b.setName(rs.getString("name"));
					b.setBal(rs.getFloat("balance"));
					
					return b;
				}
				
				return null;
				
			}
		});
	}
	

	public List<Bank> getAllAccounts(){
		return jdbcTemplate.query("select * from bank order by accno asc", new RowMapper<Bank>() {
			public Bank mapRow(ResultSet rs, int rownumber) throws SQLException {
				Bank b = new Bank();
				b.setAccno(rs.getInt("accno"));
				b.setName(rs.getString("name"));
				b.setBal(rs.getFloat("Balance"));
				return b;
			}
		});
	}
}
