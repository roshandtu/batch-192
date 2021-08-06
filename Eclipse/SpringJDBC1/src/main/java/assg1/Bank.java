/* wap to insert data into the bank table ,updata the data and delete the data
 * display the data using rowmapper and PreparedStatementCallback.
 */

package assg1;

public class Bank {
	private int accno;
	private String name;
	private float bal;

	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public float getBal() {
		return bal;
	}
	public void setBal(float bal) {
		this.bal = bal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "A/C #" + accno + "\nName: " + name + "\nBalance: " + bal;
	}
}
