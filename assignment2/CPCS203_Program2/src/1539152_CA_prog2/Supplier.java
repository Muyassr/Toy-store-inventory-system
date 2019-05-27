
package ToyStoreInventoryManagement;

public class Supplier {
    
    private int suppId;
    private String suppName;
    private String suppAdress;
    
    public Supplier(int suppId, String suppName, String suppAdress) {
        this.suppId=suppId;
        this.suppName=suppName;
        this.suppAdress=suppAdress;
    }

    public Supplier() {
        this.suppId=0;
        this.suppName=null;
        this.suppAdress=null;
    }
    public int getSuppId() {
        return suppId;
    }

    public void setSuppId(int suppId) {
        this.suppId = suppId;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getSuppAdress() {
        return suppAdress;
    }

    public void setSuppAdress(String suppAdress) {
        this.suppAdress = suppAdress;
    }
    
}
