package example.jaemo;

public class ProductBean {
	
	private String itemID;
    private String itemName;
    private String itemEng;
    private int itemPrice;
    private String itemDes;
    private int itemNumber;
    private String itemStat;
    private String itemCat;
    public boolean valid;

	
	
    public String getItemID() {
       return itemID;
	}
    
    public void setItemID(String newItemID) {
        itemID = newItemID;
 	}
	
    public String getItemName() {
       return itemName;
	}

    public void setItemName(String newItemName) {
       itemName = newItemName;
	}
			

    public String getItemEng() {
       return itemEng;
	}

    public void setItemEng(String newItemEng) {
       itemEng = newItemEng;
	}
	
			
    public int getItemPrice() {
       return itemPrice;
	}

    public void setItemPrice(int newItemPrice) {
       itemPrice = newItemPrice;
	}
    
    public String getItemDes() {
        return itemDes;
 	}

     public void setItemDes(String newItemDes) {
       itemDes = newItemDes;
 	}
     
    public int getItemNumber() {
         return itemNumber;
  	}

    public void setItemNumber(int newItemNumber) {
    	  itemNumber = newItemNumber;
  	}
  	
  			
    public String getItemStat() {
         return itemStat;
  	}

    public void setItemStat(String newItemStat) {
    	  itemStat = newItemStat;
  	}
      
    public String getItemCat() {
          return itemCat;
   	}

     public void setItemCat(String newItemCat) {
    	  itemCat = newItemCat;
   	}

     public boolean isValid() {
           return valid;
           
     }
     public void setValid(boolean newValid) {
           valid = newValid;
     }	
				
}