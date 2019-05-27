
package ToyStoreInventoryManagement;

import java.io.PrintWriter;
import java.util.Scanner;
import sun.security.x509.SerialNumber;

public class ToyInventory {
    
    private Toy toy;
    private Manufacturer manufacturer;
    private Supplier supplier;
    private int stock;
    private double discont;
    private static int inventoriesTotal=0;
    
    public ToyInventory(Toy toy, Manufacturer manufacturer, Supplier suppleir, int stock, double discount) {
        
        this.toy=toy;
        this.manufacturer=manufacturer;
        this.supplier=suppleir;
        this.stock=stock;
        this.discont=discount;
        inventoriesTotal++;
        
    }
     

    public void DeleteToy(int i, ToyInventory toyInventoryManager[],PrintWriter write) {
      
         String s = toyInventoryManager[i].getToy().getToyName();
                        toyInventoryManager[i]=toyInventoryManager[i+1];
                        write.println("COMMAND: DELETE_TOY\n"
                        + "____________________________________________________________________\n"
                                + "The Deleted Toy is\n"+s+"\n");
        inventoriesTotal--;
    }
    
    
    public ToyInventory() {
        this.toy= new Toy();
        this.manufacturer= new Manufacturer();
        this.supplier= new Supplier();
        inventoriesTotal++;
    }

    public static int getInventoriesTotal() {
        return inventoriesTotal;
    }

    public static void setInventoriesTotal(int inventoriesTotal) {
        ToyInventory.inventoriesTotal = inventoriesTotal;
    }
    
  
    public Toy getToy() {
        return toy;
    }

    public void setToy(Toy toy) {
        this.toy = toy;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getDiscont() {
        return discont;
    }

    public void setDiscont(double discont) {
        this.discont = discont;
    }
    
//    public void ComputeDiscount(ToyInventory toyInventoryManager[],Scanner read,double cost,double discount, String toyName,int i,int a) {
//        
//        
//             
//            if (a == toyInventoryManager[i].getToy().getSerialNumber()) {
//                System.out.println("COMMAND: COMPUTE_DISCOUNT\n"
//                        + "____________________________________________________________________\n"
//                        + "The Toy Information after Calculating new discounted Cost is");
//                double result = cost - ((cost * discount) / 100);
//
//                System.out.printf("%d%-10f", toyName, result);
//
//            }
//            
//            
//        }
//      }

        
    
    
    
}
