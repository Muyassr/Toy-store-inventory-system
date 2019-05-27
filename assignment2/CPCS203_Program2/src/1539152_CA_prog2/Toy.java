
package ToyStoreInventoryManagement;

public class Toy {
    
    private int serialNumber;
    private String toyName;
    private int age;
    private int group;
    private double cost;
    private String des;
    
    public Toy(int serialNumber, String toyName, int age,int group, double cost, String des) {
        this.serialNumber=serialNumber;
        this.toyName=toyName;
        this.age=age;
        this.group=group;
        this.cost=cost;
        this.des=des;
    }

    public Toy() {
         this.serialNumber=0;
        this.toyName=null;
        this.age=0;
        this.group=0;
        this.cost=0.0;
        this.des=null;
    }
    
    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    


}
