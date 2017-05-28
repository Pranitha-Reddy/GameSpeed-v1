

public class productInfo {
  private Integer productID;
  private String productCategory;
  private String productName;
  private String Manufacturer;
  private String Retailer;
  
  private String productSpecification;
  private double cost;
  private double discount;
  private double rebate;

  /*public productInfo(Integer productID, String productCategory,
                     String productName,String Manufacturer,String Retailer,String productSpecification, double cost,double discount,double rebate) {
    setProductID(productID);
    setProductCategory(productCategory);
    setProductName(productName);
    setManufacturer(Manufacturer);
    
    setRetailer(Retailer);
    setProductSpecification(productSpecification);
    setCost(cost);
    setDiscount(discount);
    setRebate(rebate);
  }*/
    
  public Integer getProductID() {
    return(productID);
  }
 protected void setProductID(Integer productID) {
    this.productID = productID;
  }
  public String getProductCategory() {
    return(productCategory);
  }
 protected void setProductCategory(String productCategory) {
    this.productCategory = productCategory;
  }
  public String getProductName() {
    return(productName);
  }
 protected void setProductName(String productName) {
    this.productName = productName;
  }
  public String getManufacturer() {
    return(Manufacturer);
  }
 protected void setManufacturer(String Manufacturer) {
    this.Manufacturer = Manufacturer;
  }
  public String getRetailer() {
    return(Retailer);
  }

  protected void setRetailer(String Retailer) {
    this.Retailer = Retailer;
  }


  public String getProductSpecification() {
    return(productSpecification);
  }

  protected void setProductSpecification(String productSpecification) {
    this.productSpecification = productSpecification;
  }

  public double getCost() {
    return(cost);
  }
protected void setCost(double cost) {
    this.cost = cost;
  }
 public double getDiscount() {
    return(discount);
  }
protected void setDiscount(double discount) {
    this.discount = discount;
  }
 public double getRebate() {
    return(rebate);
  }
protected void setRebate(double rebate) {
    this.rebate = rebate;
  }

  
}