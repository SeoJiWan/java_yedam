package practice.jdbc_03_product.history;

public class History{

	/*
	 * Field
	 */
	private int productId;
	private String productCategory;
	private int productAmount;
	
	
	/*
	 * Method - getter, setter
	 */
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	
	
}
