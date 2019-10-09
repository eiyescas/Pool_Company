/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pool_cleaning_services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esmeralda.iyescas001
 */
//Customer name
//Customer address
//Size of pool Gallons
//pH pool
class Customer{
    private String name, address;
    private int gallonsEstimate;
    private double ph_Pool;
    
    public Customer(String name, String address, int gallonsEstimate, double ph_Pool){
        this.name = name;
        this.address = address;
        this.gallonsEstimate = gallonsEstimate;
        this.ph_Pool = ph_Pool;
    } // alt + insert to generate the constructor

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", address=" + address + ", gallonsEstimate=" + gallonsEstimate + ", ph_Pool=" + ph_Pool + '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPh_Pool() {
        return ph_Pool;
    }

    public void setPh_Pool(double ph_Pool) {
        this.ph_Pool = ph_Pool;
    }
    //usually read in the data from the keyboard 
    //today we will read in the data from a file 
    
}
public class Pool_Cleaning_Services {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Customer>arrayList = new ArrayList<>();
        try {
            FileReader fr = new FileReader("PoolCustomers.csv");
            Scanner scan = new Scanner(fr);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String [] elements = line.split(",");
                arrayList.add(new Customer(elements[0], elements[1], 
                Integer.parseInt(elements[2]), Double.parseDouble(elements[3])));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Pool_Cleaning_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Customer c: arrayList){
            if(c.getPh_Pool()> 7){
                System.out.println(c);
            }//this report will let us know all the customers with high pH values!
        }
    }
    
}
