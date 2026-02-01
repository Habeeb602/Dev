/*
 * Idea 
 *  - This principle is used to assign a minimal functionality to an interface
 *  - The functionality should suffice the client needs but shouldn't overwhelm with extra methods
 *  - Here we will see an example of multi-functionality printer
 */

 class Document{

 }


 // This is the not-to-do example of ISP
 interface MultiFunctionalPrinterInterface{
    void print(Document d);
    void scan(Document d);
    void fax(Document d);
 }



 // This is fine...
 class MultiFunctionalPrinter implements MultiFunctionalPrinterInterface{

    @Override
    public void fax(Document d) {
        
        System.out.println("I can print");
    }

    @Override
    public void print(Document d) {
        
        System.out.println("I can scan");
    }

    @Override
    public void scan(Document d) {
        
        System.out.println("I can fax");
    }
    
 }


 // But, in this example, we cannot use this MultiFunctionalPrinterInterface, since OldFashionedPrinter doesn't support scan and fax functionalities
 class OldFashionedPrinter implements MultiFunctionalPrinterInterface{

    @Override
    public void fax(Document d) {
        
        System.out.println("I can print");
    }

    @Override
    public void print(Document d) {
        
        System.out.println("I can't print");
    }

    @Override
    public void scan(Document d) {
        
        System.out.println("I can't fax");
    }
    
 }



 // Here is the fix

 interface Printer{
    void print(Document d);
 }

 interface Scanner{
    void scan(Document d);
 }

 interface FaxMachine{
    void fax(Document d);
 }


 // Implementation for our NewMultiFunctionalPrinter
 class NewMultiFunctionalPrinter implements Printer, Scanner, FaxMachine{
    
    @Override
    public void fax(Document d) {
        
        System.out.println("I can print");
    }

    @Override
    public void print(Document d) {
        
        System.out.println("I can scan");
    }

    @Override
    public void scan(Document d) {
        
        System.out.println("I can fax");
    }
    
 }


 // Implementation for our NewOldFashionedPrinter
 class NewOldFashionedPrinter implements Printer{

    @Override
    public void print(Document d) {
        
        System.out.println("I can print");
        
    }
    
 }



public class InterfaceSegregationPrinciple{
    public static void main(String[] args) {
        
    }
}