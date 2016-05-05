package example.jaemo;

public class OrderBean {
	
	private int itemID;
	private int itemNum; 
	private int orderID; 
    private String itemName;
    private String itemEng; 
    private String shipping;
    private int totalPrice;
    private String date;
    private long cardNum;


    public int getItemID() {
       return itemID;
	}
    
    public void setItemID(int newItemID) {
        itemID = newItemID;
 	}
    
    public String getItemEng() {
        return itemEng;
 	}
     
     public void setItemEng(String newItemEng) {
         itemEng = newItemEng;
  	}
    
    public int getItemNum() {
        return itemNum;
 	}
     
     public void setItemNum(int newItemNum) {
         itemNum = newItemNum;
  	}
     
     public int getOrderID() {
         return orderID;
  	}
      
      public void setOrderID(int newOrderID) {
          orderID = newOrderID;
   	}
	
    public String getItemName() {
       return itemName;
	}

    public void setItemName(String newItemName) {
       itemName = newItemName;
	}
			

    public String getShipping() {
       return shipping;
	}

    public void setShipping(String newItemEng) {
       shipping = newItemEng;
	}
	
			
    public int getTotalPrice() {
       return totalPrice;
	}

    public void setTotalPrice(int newItemPrice) {
       totalPrice = newItemPrice;
	}
    
    public String getDate() {
        return date;
 	}

     public void setDate(String newItemDes) {
       date = newItemDes;
 	}

    public long getCardNum() {
          return cardNum;
   	}

    public void setCardNum(long newCardNum) {
    	  cardNum = newCardNum;
    }
}