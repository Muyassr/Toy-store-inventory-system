
package ToyStoreInventoryManagement;

public class Manufacturer {
    
    private int manufactId;
    private String manufactName;
    private String manufactAdress;
    
    public Manufacturer(int manufactId, String manufactName, String manufactAdress) {
        this.manufactId=manufactId;
        this.manufactName=manufactName;
        this.manufactAdress=manufactAdress;
    }
 
    public Manufacturer() {
        this.manufactId=0;
        this.manufactName=null;
        this.manufactAdress=null;
    }

    public int getManufactId() {
        return manufactId;
    }

    public void setManufactId(int manufactId) {
        this.manufactId = manufactId;
    }

    public String getManufactName() {
        return manufactName;
    }

    public void setManufactName(String manufactName) {
        this.manufactName = manufactName;
    }

    public String getManufactAdress() {
        return manufactAdress;
    }

    public void setManufactAdress(String manufactAdress) {
        this.manufactAdress = manufactAdress;
    }
    
   
    
    
}
