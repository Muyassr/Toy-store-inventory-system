package ToyStoreInventoryManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/*
 Moyasr Tamim
 1539152
 moytam.uni@gmail.com
 CA
 CPCS203
 Program2
 */

public class ToyStoreInventoryManagement {

    public static void main(String[] args) throws FileNotFoundException {

        File fileInput = new File("toyinventory.txt");
        if (!fileInput.exists()) {
            System.out.println("Sorry!! File does not exist");
            System.exit(0);
        }
        Scanner read = new Scanner(fileInput);

        File fileOutput = new File("toyinventoryreport.txt");
        PrintWriter write = new PrintWriter(fileOutput);

        //creating the array
        int MaxInventorySize = read.nextInt();
        ToyInventory[] toyInventoryManager = new ToyInventory[MaxInventorySize];

        write.print("Programming Assignment 2 _______");
        java.util.Date date = new java.util.Date();
        write.println(date + "\n______________________________________________________________________");

        
        
            int manufactSerialNumbersArray[][];
            
            
        while (read.hasNext()) {

            String command = read.next();
            System.out.println(command);

            if (command.compareTo("ADD_TOY") == 0) {
                Toy tempToyArray[] = new Toy[read.nextInt()];

                for (int j = 0; j < tempToyArray.length; j++) {
                    ToyInventory toyInventory = new ToyInventory();

                    int serialNumber = read.nextInt();
                    String toyName = read.next();
                    int age = read.nextInt();
                    int group = read.nextInt();
                    double cost = read.nextDouble();
                    String des = read.nextLine();
                    int stock = read.nextInt();
                    double discount = read.nextDouble();
                    toyInventory.setStock(stock);
                    toyInventory.setDiscont(discount);

                    toyInventory.setToy(new Toy(serialNumber, toyName, age, group, cost, des));

                    toyInventoryManager[j] = toyInventory;
                    //this Array just for printing 
                    tempToyArray[j] = new Toy(serialNumber, toyName, age, group, cost, des);
                }
                
                
                PrintAllToy(command, toyInventoryManager, write);

            } else if (command.compareTo("ADD_MANUFACTURER") == 0) {
                Manufacturer tempManufactArray[] = new Manufacturer[read.nextInt()];
                read.nextLine();
                //to save serial numbers away  
                
         manufactSerialNumbersArray = new int[tempManufactArray.length][];
                String temp;
                for (int i = 0; i < tempManufactArray.length; i++) {
                    temp = read.nextLine();
                    String tempArray[] = temp.split(" ");
                    
                    int manufactId = Integer.parseInt(tempArray[0]);
                    String manufactName = tempArray[1];
                    String manufactAdress = tempArray[2];
                     
                    for (int j = 0; j<tempArray.length - 4; j++) {
                        boolean notRepeated = true;
                        for (int k = 0; k < ToyInventory.getInventoriesTotal(); k++) {
                            
                             if (toyInventoryManager[k].getToy().getSerialNumber()== Integer.parseInt(tempArray[j+3])) {
                                 
                                 
                                 toyInventoryManager[k].setManufacturer(new Manufacturer(manufactId, manufactName, manufactAdress));
                                 
                             }
                        }
                        
                    }
                    tempManufactArray[i] = new Manufacturer(manufactId, manufactName, manufactAdress);

                }
                    PrintAllManufacturer(toyInventoryManager,command,write,ToyInventory.getInventoriesTotal());
            } else if (command.compareTo("ADD_SUPPLIER") == 0) {

                Supplier tempSuppArray[] = new Supplier[read.nextInt()];
                read.nextLine();

                //String suppSerialNumbersArray[][] = new String[tempSuppArray.length][];
                
                for (int i = 0; i < tempSuppArray.length; i++) {
                    String temp = read.nextLine();
                    
                    String tempArray[] = temp.split(" ");
                    
                    int suppId = Integer.parseInt(tempArray[0]);
                    String suppName = tempArray[1];
                    String suppAdress = tempArray[2];
                    
                     for (int j = 0; j<tempArray.length - 4; j++) {
                        boolean notRepeated = true;
                        for (int k = 0; k < ToyInventory.getInventoriesTotal(); k++) {
                             if (toyInventoryManager[k].getToy().getSerialNumber()==
                                     Integer.parseInt(tempArray[j+3])) {
                                 toyInventoryManager[k].setSupplier(new Supplier(suppId, suppName, suppAdress));
                             }
                        }
                        
                    }


                }
                
                int t = ToyInventory.getInventoriesTotal();
                
                printSupplier(toyInventoryManager, command, write,t );
                write.println("");
                
               
            } else if (command.compareTo("COMPUTE_DISCOUNT") == 0) {

                while (true) {

                    int a = read.nextInt();
                    for (int i = 0; i < 9; i++) {
                        if (a == toyInventoryManager[i].getToy().getSerialNumber()) {
                            double cost = toyInventoryManager[i].getToy().getCost();
                            double discount = toyInventoryManager[i].getDiscont();
                            String toyName = toyInventoryManager[i].getToy().getToyName();
                            write.println("COMMAND: COMPUTE_DISCOUNT\n"
                                    + "____________________________________________________________________\n"
                                    + "The Toy Information after Calculating new discounted Cost is");
                            double result = cost - ((cost * discount) / 100);

                            write.println(toyName + "\t" + result + "\n");

                        }

                    }

                    if (a == -1) {
                        break;
                    }
                }

            } else if (command.compareTo("DELETE_TOY") == 0) {
                int a = read.nextInt();
                for (int i = 0; i < ToyInventory.getInventoriesTotal(); i++) {
                    if (a == toyInventoryManager[i].getToy().getSerialNumber()) {

                        toyInventoryManager[i].DeleteToy(i, toyInventoryManager, write);
                        break;
                    }
                }

            } else if (command.compareTo("SEARCH_FOR_TOY") == 0) {
                int a = read.nextInt();
                write.println("COMMAND: SEARCH_FOR_TOY\n"
                        + "____________________________________________________________________");
                if (a == 1) {
                    int sn = read.nextInt();
                    for (int i = 0; i < 8; i++) {
                        String toyName;
                        if (sn == toyInventoryManager[i].getToy().getSerialNumber()) {
                            toyName = toyInventoryManager[i].getToy().getToyName();
                            write.println("The Toy with Serial Number:  " + sn + "is FOUND and its Name is\n" + toyName + "\n");
                            break;
                        } else {
                            write.println("The Toy with Serial Number:  " + sn + " is NOT FOUND in inventory");
                            break;
                        }
                    }

                } else if (a == 2) {
                    int qq = read.nextInt();
                    String name = read.next();
                    for (int i = 0; i < 8; i++) {
                        if (name.equals(toyInventoryManager[i].getToy().getToyName())) {
                            int sn = toyInventoryManager[i].getToy().getSerialNumber();
                            write.println("The Toy with Name: " + name + " is FOUND and its Serial Number is\n" + sn);
                            break;
                        }
                    }

                } else if (a == 3) {
                    read.nextInt();
                    String s = read.next();
                    String m = read.next();
                    write.println("The Toy with attribute: " + s + " & " + m + "is FOUND and its Serial Number & Name is");
                    for (int j = 0; j < 8; j++) {
                        boolean notRepeated = true;
                        for (int i = 0; i < 8; i++) {
                            if (toyInventoryManager[j].getToy().getToyName().equals(toyInventoryManager[i].getToy().getToyName()) && j > i) {
                                notRepeated = false;
                                break;
                            }
                        }
                        if ((toyInventoryManager[j].getToy().getDes().contains(s)
                                || toyInventoryManager[j].getToy().getDes().contains(m)) && notRepeated) {
                            write.println(toyInventoryManager[j].getToy().getSerialNumber() + " " + toyInventoryManager[j].getToy().getToyName());

                        }

                    }

                }

                write.println("");

            } else if (command.compareTo("ADD_DISCOUNT") == 0) {
                int x = read.nextInt();
                double z = read.nextDouble();
                for (int i = 0; i < 8; i++) {
                    int p = toyInventoryManager[i].getToy().getSerialNumber();

                    if (x == p) {
                        toyInventoryManager[i].setDiscont(z);
                        String toyName = toyInventoryManager[i].getToy().getToyName();
                        write.println("COMMAND: ADD_DISCOUNT\n"
                                + "____________________________________________________________________\n"
                                + "The Toy Information after adding Discount is\n" + toyName + "\t" + z + "\n");
                        break;
                    }

                }

            } else if (command.compareTo("REMOVE_DISCOUNT") == 0) {
                int a = read.nextInt();
                for (int i = 0; i < ToyInventory.getInventoriesTotal(); i++) {

                    String toyName;
                    if (a == toyInventoryManager[i].getToy().getSerialNumber()) {
                        toyInventoryManager[i].setDiscont(0.0);
                        toyName = toyInventoryManager[i].getToy().getToyName();
                        write.println("COMMAND: REMOVE_DISCOUNT\n"
                                + "____________________________________________________________________\n"
                                + "The Discount for Toy has been removed.\n" + toyName + "\t" + toyInventoryManager[i].getDiscont() + "\n");
                        break;
                    }

                }

            } else if (command.compareTo("INCREASE_AMOUNT") == 0) {
                int a = read.nextInt();
                int g = read.nextInt();
                for (int i = 0; i < 8; i++) {
                    String toyName;
                    if (a == toyInventoryManager[i].getToy().getSerialNumber()) {
                        int q = g + toyInventoryManager[i].getStock();
                        toyInventoryManager[i].setStock(q);
                        toyName = toyInventoryManager[i].getToy().getToyName();
                        write.println("COMMAND: INCREASE_AMOUNT\n"
                                + "____________________________________________________________________\n"
                                + "The Toy updated amount is\n" + toyName + "\t" + q + "\n");
                        break;
                    }

                }

            } else if (command.compareTo("REDUCE_AMOUNT") == 0) {
                int a = read.nextInt();
                int g = read.nextInt();
                for (int i = 0; i < ToyInventory.getInventoriesTotal(); i++) {
                    String toyName;
                    if (a == toyInventoryManager[i].getToy().getSerialNumber()) {
                        int q = toyInventoryManager[i].getStock() - g;
                        toyInventoryManager[i].setStock(q);
                        toyName = toyInventoryManager[i].getToy().getToyName();
                        write.println("COMMAND: REDUCE_AMOUNT\n"
                                + "____________________________________________________________________\n"
                                + "The Toy updated amount is\n" + toyName + "\t" + q + "\n");
                        break;
                    }

                }

            } else if (command.compareTo("PRINT_ALL_TOYS_FOR_MANUFACTURER") == 0) {
                int a = read.nextInt();
                write.println("COMMAND: PRINT_ALL_TOYS_FOR_MANUFACTURER(SN: "+a+")\n"
                +"____________________________________________________________________");
                int why=1;
                 for (int i = 0; i < ToyInventory.getInventoriesTotal(); i++) {
                   int manufctId= toyInventoryManager[i].getManufacturer().getManufactId();
                   if(a==manufctId) {
                       write.println("Toy"+why+" = "+toyInventoryManager[i].getToy().getToyName());
                        why++;
                   }
                   
                }
                 write.println("");
//                break;
            } else if (command.compareTo("PRINT_TOYS_WITH_LESS_THAN_AMOUNT") == 0) {
                int d = read.nextInt();
                write.println("PRINT_TOYS_WITH_LESS_THAN_AMOUNT(" + d + ")\n"
                        + "____________________________________________________________________");
                int counter = 1;
                for (int i = 0; i < ToyInventory.getInventoriesTotal(); i++) {
                    boolean notRepeated = true;
                    for (int j = 0; j < ToyInventory.getInventoriesTotal(); j++) {
                        if (toyInventoryManager[i].getToy().getToyName().equals(toyInventoryManager[j].getToy().getToyName()) && i > j) {
                            notRepeated = false;
                            break;
                        }
                    }
                    if ((d >= toyInventoryManager[i].getStock()) && notRepeated) {

                        String toyName = toyInventoryManager[i].getToy().getToyName();
                        double price = toyInventoryManager[i].getToy().getCost();
                        write.println("Toy" + counter + ": " + toyName + " " + price);
                        counter++;
                    }

                }

            }

        }

        write.flush();
        write.close();
       
 
    }
    

    public static void PrintAllToy(String command, ToyInventory toyInventoryManager[], PrintWriter write) {

        write.println("COMMAND: " + command + "\n"
                + "____________________________________________________________________\n"
                + "Serial Number 	 Name 			 Age Group 	 Price 	 Description");

        for (int i = 0; i < ToyInventory.getInventoriesTotal(); i++) {
            boolean nameNotRepeated = true;
            for (int j = 0; j < ToyInventory.getInventoriesTotal(); j++) {
                if (toyInventoryManager[i].getToy().getToyName().equals(toyInventoryManager[j].getToy().getToyName()) && i > j) {
                    nameNotRepeated = false;
                    break;
                }
            }
            if (nameNotRepeated) {
                write.printf("%10d%30s%4d-%4d%12.2f%40s\n", toyInventoryManager[i].getToy().getSerialNumber(), toyInventoryManager[i].getToy().getToyName(),
                        toyInventoryManager[i].getToy().getAge(), toyInventoryManager[i].getToy().getGroup(),
                        toyInventoryManager[i].getToy().getCost(), toyInventoryManager[i].getToy().getDes());
            }

        }

        write.println("");
    }

    public static void PrintAllManufacturer(ToyInventory[] toyInventoryManager,String command, PrintWriter write, int length) {
        write.println("\nCOMMAND: " + command + "\n"
                + "_______________________________________________________________________________________________________");
        write.printf("%10s%30s%40s\n", "ID Number", "Name", "Adress");

        for (int i = 0; i < length; i++) {
            write.printf("%10d%30s%40s\n", toyInventoryManager[i].getManufacturer().getManufactId(),
                                              toyInventoryManager[i].getManufacturer().getManufactName(),
                                              toyInventoryManager[i].getManufacturer().getManufactAdress());
        }
        write.println("");
    }
    
    public static void printSupplier(ToyInventory[] ToyInventoryManager, String line, PrintWriter write, int ToyInventoryManagerCounter1) {
        write.println("\nCOMMAND: " + line);
        write.println("_______________________________________________________________________________________________________");

        write.printf("%10s%30s%40s\n", "ID Number", "Name", "Adress");
        write.printf("%10d%30s%40s\n", ToyInventoryManager[0].getSupplier().getSuppId(), ToyInventoryManager[0].getSupplier().getSuppName(), ToyInventoryManager[0].getSupplier().getSuppAdress());
        for (int i = 1; i < ToyInventoryManagerCounter1; i++) {
            write.printf("%10d%30s%40s\n", ToyInventoryManager[i].getSupplier().getSuppId(), ToyInventoryManager[i].getSupplier().getSuppName(), ToyInventoryManager[i].getSupplier().getSuppAdress());

        }

    }   




}
    
  


