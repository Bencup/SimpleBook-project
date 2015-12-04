import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;



public class BorrowForm {
	
	private Long id;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateBorrow;	
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateLimit;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateReturn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateBorrow() {
		return dateBorrow;
	}

	public void setDateBorrow(Date dateBorrow) {
		this.dateBorrow = dateBorrow;
	}

	public Date getDateLimit() {
		return dateLimit;
	}

	public void setDateLimit(Date dateLimit) {
		this.dateLimit = dateLimit;
	}

	public Date getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}

	@Override
	public String toString() {
		return "BorrowForm [id=" + id + ", dateBorrow=" + dateBorrow
				+ ", dateLimit=" + dateLimit + ", dateReturn=" + dateReturn
				+ "]";
	}

	

	
	
	
}
