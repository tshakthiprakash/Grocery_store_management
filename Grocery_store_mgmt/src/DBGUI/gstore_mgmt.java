package DBGUI;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

import com.github.lgooddatepicker.components.DatePicker;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.InputEvent;
//import java.awt.event.ItemListener;
import java.sql.*;
public class gstore_mgmt {
 
public static void main(String[] argv) {
 Test t= new Test();
 OracleTest dbconn = new OracleTest();
 Connection conn = dbconn.connectdb();
 JFrame jframe = new JFrame("Database 5330");
 jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 JTabbedPane tabpane=new JTabbedPane();
 tabpane.setBounds(0, 0, 1450, 1000);
 GridLayout grid = new GridLayout(3,3);
 GridLayout grid1=new GridLayout(2,1);
 grid.setHgap(1);
 grid.setVgap(3);
 JPanel outerPanel1=new JPanel(grid);
 JPanel outerPanel2=new JPanel(grid);
 JPanel panel1 = new JPanel();
 JPanel panel2 = new JPanel();
 JPanel panel3=new JPanel();
 JPanel panel4=new JPanel();
 JPanel panel5=new JPanel();
 JPanel panel6=new JPanel();
 JPanel panel5_1=new JPanel(grid);
 JPanel panel5_2=new JPanel();
 JPanel panel6_1=new JPanel(grid1);
 JButton Adduser = new JButton("Add Customer");
 JButton searchUser=new JButton("Search Customer");
 JButton Addproduct=new JButton("Add Product");
 JButton Updateproduct = new JButton("Update Product");
 JTextArea queryArea1=new JTextArea(5,20);
 JScrollPane scrollPane1 = new JScrollPane(queryArea1);
 JTextArea queryArea2=new JTextArea(5,20);
 JScrollPane scrollPane2 = new JScrollPane(queryArea2);
 JButton viewCustomers=new JButton("View Customers");
 JButton viewProducts=new JButton("View Products");
 JButton viewEmployees=new JButton("View Employees");
 JButton viewRegCust=new JButton("View Regular Customers");
 JButton viewCallCust=new JButton("View Call Order Customers");
 JButton viewSuppliers=new JButton("View Suppliers");
 JButton BG11=new JButton("Find call order delivery amount");
 JButton mostBrand=new JButton("Find most selling brand");
 JButton revenue=new JButton("Find Revenue of Stores");
 scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
 scrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
 scrollPane1.setPreferredSize(new Dimension(250, 250));
 DefaultCaret caret1 = (DefaultCaret)queryArea1.getCaret();
 caret1.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
 DefaultCaret caret2 = (DefaultCaret)queryArea2.getCaret();
 caret2.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
 scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
 scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
 scrollPane2.setPreferredSize(new Dimension(250, 250));
 Updateproduct.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e)
	   {
	         t.updateproduct(conn);
	         }
	  });
 Adduser.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent e)
   {
         t.addUser(conn);
         }
  });
 revenue.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e)
	   {
	         t.findRev(conn);
	         }
	  });
 mostBrand.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e)
	   {
	         t.findMaxProductBrand(conn,queryArea1);
	         }
	  });
 searchUser.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e)
	   {
	         t.searchUser(conn);
	         }
	  });
 JLabel lbl1 = new JLabel("Store:");
 JLabel lbl2=new JLabel("Warehouse:");
 String[] store_list = new String[] {"S01","S02","S03"};
 String[] warehouse_list=new String[] {"W01","W02","W03"};
 JComboBox<String> store_list_drop = new JComboBox<>(store_list);
 JComboBox<String> warehouse_list_drop=new JComboBox<>(warehouse_list);
 Addproduct.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e)
  {
   t.addProduct(conn,warehouse_list_drop.getSelectedItem().toString());
  }
 });
 
 JButton maxExpense=new JButton("Find max Expense store");
 JButton BG2= new JButton("Find Maximum product");
 JButton BG4=new JButton("Find Store with min call order");
 JButton BG9=new JButton("Find Products with min quantity");
 JButton freqCallOrders=new JButton("Find Frequent Call Orders location");
 JButton goldCardExpense=new JButton("Find Expenses on Gold Card");
 JButton silverCardExpense=new JButton("Find Expenses on Silver Card");
 JButton minRev=new JButton("Find Store with min Revenue");
 minRev.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent e)
	     {
	           t.findMinRevStore(conn);
	           }
	    });
 goldCardExpense.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent e)
	     {
	           t.findGoldCardExpense(conn,jframe);
	           }
	    });
silverCardExpense.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent e)
	     {
	           t.findSilverCardExpense(conn,jframe);
	           }
	    });
 freqCallOrders.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent e)
	     {
	           t.findFreqCallOrderLoc(conn,jframe);
	           }
	    });
 BG2.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
     {
           t.BG2(conn);
           }
    });
 BG4.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
     {
           t.BG4(conn);
           }
    });
 maxExpense.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
   t.findMaxExpStore(conn);
  }
 });
 viewCustomers.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent e)
	     {
	           t.viewCustomers(conn,queryArea1);
	           }
	    });
 viewRegCust.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent e)
	     {
	           t.viewRegCust(conn,queryArea1);
	           }
	    });
 viewCallCust.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent e)
	     {
	           t.viewCallCust(conn,queryArea1);
	           }
	    });
 viewEmployees.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent e)
	     {
	    		t.viewEmployees(conn,queryArea1);
	           }
	    });
 viewProducts.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent e)
	     {
	           t.viewProducts(conn,queryArea2);
	           }
	    });
 viewSuppliers.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent e)
	     {
	           t.viewSuppliers(conn,queryArea2);
	           }
	    });
 JButton minProduct=new JButton("Find warehouse with min no. of Products");
 BG9.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
   t.BG9(conn,queryArea2);
  }
 });
 minProduct.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
	   t.findMinProdWarehouse(conn, jframe);
	  }
	 });
 store_list_drop.setSize(40, 50);
 warehouse_list_drop.setSize(40,50);
 //queryArea1.setBounds(0, 0, 1000, 1000);
 //queryArea2.setBounds(0, 0, 1000, 1000);
 //panel1.setLayout(null);
 lbl1.setMaximumSize(lbl1.getPreferredSize());
 store_list_drop.setMaximumSize(store_list_drop.getPreferredSize());
 Adduser.setMaximumSize(Adduser.getPreferredSize());
 maxExpense.setMaximumSize(maxExpense.getPreferredSize());
 maxExpense.setBounds(0,20,40,50);
 panel1.setBounds(0,50,600, 50);
 panel2.setBounds(0,50,600, 50);
 panel3.setBounds(0,100,600,50);
 panel4.setBounds(0,100,600,50);
 panel1.setBackground(Color.GRAY);
 panel2.setBackground(Color.LIGHT_GRAY);
 panel5.setBackground(Color.GRAY);
 panel6.setBackground(Color.LIGHT_GRAY);
// panel1.add(lbl1);
 //panel2.add(lbl2);
// panel1.add(store_list_drop);
// panel2.add(warehouse_list_drop);
 panel1.add(Adduser);
 panel1.add(searchUser);
 panel2.add(Addproduct);
 panel2.add(Updateproduct);
 panel3.add(maxExpense);
 panel3.add(goldCardExpense);
 panel3.add(silverCardExpense);
 panel4.add(minProduct);
 panel3.add(minRev);
 panel3.add(revenue);
 panel3.add(mostBrand);
 panel4.add(BG9);
 panel3.add(BG2);
 panel3.add(BG4);
 panel3.add(BG11);
 panel3.add(freqCallOrders);
 panel5_1.add(viewCustomers);
 panel5_1.add(viewRegCust);
 panel5_1.add(viewCallCust);
 panel6_1.add(viewProducts);
 panel6_1.add(viewSuppliers);
 //panel5.add(queryArea1);
 //queryArea1.add(scrollPane1);
 panel5.add(panel5_1);
 panel5.add(scrollPane1);
 panel5.add(viewEmployees);
 //panel5.add(panel5_2);
 //panel6.add(queryArea2);
 panel6.add(panel6_1);
 panel6.add(scrollPane2);
 store_list_drop.addActionListener (new ActionListener () {
     public void actionPerformed(ActionEvent e) {
      JOptionPane.showMessageDialog(jframe,store_list_drop.getSelectedItem().toString());  
      lbl2.setText(store_list_drop.getSelectedItem().toString());
     }
 });
 
 outerPanel1.add(panel1);
 outerPanel1.add(panel3);
 outerPanel2.add(panel2);
 outerPanel2.add(panel4);
 outerPanel1.add(panel5);
 outerPanel2.add(panel6);
 jframe.setSize(900,900);
 tabpane.setBounds(0, 0, 1200, 3100);
 //panel.setBounds(0,0,1500,1500);
 
 //jframe.add(panel1);
 tabpane.addTab("Store", outerPanel1);
 tabpane.addTab("Warehouse", outerPanel2);
 //panel.add(tabpane);
 //panel.add(panel4,1,1);
 //jframe.add(panel2);
 //jframe.add(panel3);
 jframe.getContentPane().add(tabpane);
 //jframe.add(panel);
 jframe.setVisible(true);
 //jframe.pack();
 BG11.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e)
	   {
	         t.BG11(conn,queryArea1);
	         }
	  });

 
}
public void addUser(Connection conn)
{
JFrame adduserframe = new JFrame("Add User");
adduserframe.setSize(500, 500);
GridLayout grid = new GridLayout(7,2);
JPanel panel1 = new JPanel(grid);
JLabel custID = new JLabel("Customer ID");
JLabel custfName = new JLabel("First Name");
JLabel custlName = new JLabel("Last Name");
JLabel add = new JLabel("Address");
JLabel cardnum = new JLabel("Card Number");
JLabel cardType = new JLabel("Card Type");
JTextField custIDbx = new JTextField();
JTextField custfnamebx = new JTextField();
JTextField custlnamebx = new JTextField();
JTextField custaddbx = new JTextField();
JTextField cardNumbox = new JTextField();
String[] store_list = new String[] {"Gold","Silver"};
JComboBox<String> card_list_drop = new JComboBox<>(store_list);
JButton addbut = new JButton("ADD");
panel1.add(custID);
panel1.add(custIDbx);
panel1.add(custfName);
panel1.add(custfnamebx);
panel1.add(custlName);
panel1.add(custlnamebx);
panel1.add(add);
panel1.add(custaddbx);
panel1.add(cardnum);
panel1.add(cardNumbox);
panel1.add(cardType);
panel1.add(card_list_drop);
panel1.add(addbut);
addbut.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
 {
        if(conn !=null)
        {
         try {
                Statement stmt = conn.createStatement();
                Statement stmt2 = conn.createStatement();
            ResultSet rs = stmt.executeQuery("INSERT INTO F18_25_CUSTOMER (CUSTOMER_ID,FIRST_NAME,LAST_NAME) VALUES('"+custIDbx.getText()+"','"+custfnamebx.getText()+"','"+custlnamebx.getText().toString()+"')");
            ResultSet rs2 = stmt2.executeQuery("INSERT INTO F18_25_REGULAR_CUST (CUSTOMERID,ADDRESS,CONTACT,CARDNUMBER,CARDTYPE,CARDISSUEDATE) VALUES('"+custIDbx.getText()+"','"+custaddbx.getText()+"','9443145074','"+cardNumbox.getText()+"','"+card_list_drop.getSelectedItem().toString()+"',Date '2018-12-12')");
            JOptionPane.showMessageDialog(adduserframe,"Customer Added");
            rs.close();
            rs2.close();
            stmt.close();
               //
            }
            catch (SQLException de) {
     
       System.out.println("error in accessing the relation");
       de.printStackTrace();
       return;
     
      }    
        }
        }
});

adduserframe.add(panel1);
adduserframe.setVisible(true);

}
public void addProduct(Connection conn, String wid)
{
JFrame addProductframe = new JFrame("Add Product");
addProductframe.setSize(500, 500);
GridLayout grid = new GridLayout(7,2);
JPanel pan1 = new JPanel(grid);
JLabel prodID = new JLabel("Product ID");
JLabel prodName = new JLabel("Product Name");
JLabel prodBrand = new JLabel("Product Brand");
JLabel suppId = new JLabel("Supplier ID");
JLabel prodType = new JLabel("Product Type");
JLabel quantity=new JLabel("Quantitiy");
JTextField prodIDinp = new JTextField();
JTextField prodNameinp = new JTextField();
JTextField prodBrandinp = new JTextField();
JTextField suppIdinp = new JTextField();
JTextField quantityinp=new JTextField();
String[] prodType_list = new String[] {"Dairy","Beauty","Food","Cleaning"};
JComboBox<String> prodType_list_drop = new JComboBox<>(prodType_list);
JButton addprodbut = new JButton("Add Product");
pan1.add(prodID);
pan1.add(prodIDinp);
pan1.add(prodName);
pan1.add(prodNameinp);
pan1.add(prodBrand);
pan1.add(prodBrandinp);
pan1.add(suppId);
pan1.add(suppIdinp);
pan1.add(prodType);
pan1.add(prodType_list_drop);
pan1.add(quantity);
pan1.add(quantityinp);
pan1.add(addprodbut);
addprodbut.addActionListener(new ActionListener(){
 public void actionPerformed(ActionEvent e)
  {
        if(conn !=null)
        {
         try {
                Statement stmt = conn.createStatement();
                //Statement stmt2 = conn.createStatement();
            ResultSet rs = stmt.executeQuery("INSERT INTO F18_25_PRODUCT (Product_ID,Name,Brand,supp_ID,product_type) VALUES('"+prodIDinp.getText()+"','"+prodNameinp.getText()+"','"+prodBrandinp.getText()+"','"+suppIdinp.getText()+"','"+prodType_list_drop.getSelectedItem().toString()+"')");
            //ResultSet rs2 = stmt2.executeQuery("INSERT INTO F18_25_has (Warehouse_ID,Store_ID,Product_ID,Quantity_of_Reserved_Products) VALUES('"+wid+"','"+""+"','"+prodIDinp.getText()+"','"+quantityinp.getText()+"')");
            JOptionPane.showMessageDialog(addProductframe,"Product Added");
            rs.close();
            //rs2.close();
            stmt.close();
               //
            }
            catch (SQLException de) {
     
       System.out.println("error in accessing the relation");
       de.printStackTrace();
       return;
     
      }    
        }
        }
 });

addProductframe.add(pan1);
addProductframe.setVisible(true);
}
public void findMaxExpStore(Connection conn)
{
JFrame maxExpFrame=new JFrame("Store with maximum Expense");
maxExpFrame.setSize(600, 500);
GridLayout grid = new GridLayout(4,2);
JPanel pan2=new JPanel(grid);
JLabel startDateLbl=new JLabel("Start Date:");
JLabel endDateLbl=new JLabel("End Date:");
JLabel maintenanceCostLbl=new JLabel("Maintenance cost:");
//JTextField startDateTxt=new JTextField();
//JTextField endDateTxt=new JTextField();
DatePicker startDate = new DatePicker();
DatePicker endDate = new DatePicker();
JTextField maintenanceCostTxt=new JTextField();
JButton submit=new JButton("Submit");
//JTextArea result=new JTextArea();
pan2.add(startDateLbl);
//pan2.add(startDateTxt);
pan2.add(startDate);
pan2.add(endDateLbl);
pan2.add(endDate);
//pan2.add(endDateTxt);
pan2.add(maintenanceCostLbl);
pan2.add(maintenanceCostTxt);
pan2.add(submit);
//pan2.add(result);
submit.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e)
{
    if(conn !=null)
    {
     try {
            Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery("SELECT STR,EXPENSE FROM (select str,sumewage+"+Integer.parseInt(maintenanceCostTxt.getText().toString())+"+(select sum(purchase_price) as sprice from f18_25_supplier_purchase where (sup_buy_date between DATE '"+startDate.toString()+"' AND DATE '"+endDate.toString()+"')) as Expense from(select str,sum(ewage) as sumewage from(select f18_25_store.store_id as str,f18_25_employee.employmentwage as ewage from f18_25_employee,f18_25_store where f18_25_employee.storeid=f18_25_store.store_id) group by str)) WHERE EXPENSE= (SELECT MAX(EXPENSE) FROM (select str,sumewage+"+Integer.parseInt(maintenanceCostTxt.getText().toString())+"+(select sum(purchase_price) as sprice from f18_25_supplier_purchase where (sup_buy_date between DATE '"+startDate.toString()+"' AND DATE '"+endDate.toString()+"')) as Expense from(select str,sum(ewage) as sumewage from(select f18_25_store.store_id as str,f18_25_employee.employmentwage as ewage from f18_25_employee,f18_25_store where f18_25_employee.storeid=f18_25_store.store_id) group by str)))");
       while(rs.next())
        JOptionPane.showMessageDialog(maxExpFrame,"Store:"+rs.getString("str")+"\n Expense:"+rs.getString("Expense"));
       rs.close();
       stmt.close();
           //
        }
        catch (SQLException de) {
 
  System.out.println("error in accessing the relation");
  de.printStackTrace();
  return;
 
 }    
    }
    }
});
maxExpFrame.add(pan2);
maxExpFrame.setVisible(true);
}

public void BG2(Connection conn)
{
    JFrame BG2Frame = new JFrame("Find Product with Maximum Sales");
    BG2Frame.setSize(600,400);
    GridLayout grid = new GridLayout(3,2);
    JPanel pan1 = new JPanel(grid);
    JLabel lbl1 = new JLabel("From:");
    JLabel lbl2 = new JLabel("To:");
    DatePicker fromdate = new DatePicker();
    DatePicker todate = new DatePicker();
    JButton find = new JButton("FIND");
    find.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e)
          {
                if(conn !=null)
                {
                 try {
                        Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("Select product_type,cnt from (select F18_25_product.product_type as product_type,count(F18_25_cust_buys.product_id) as cnt from F18_25_product,F18_25_cust_buys where F18_25_product.product_id=F18_25_cust_buys.product_id and (F18_25_cust_buys.buy_date between date '"+fromdate.toString()+"' and date '"+todate.toString()+"')group by F18_25_product.product_type) where cnt = (select max(cnt) from (select count(F18_25_cust_buys.product_id) as cnt from F18_25_product,F18_25_cust_buys where F18_25_product.product_id=F18_25_cust_buys.product_id and (F18_25_cust_buys.buy_date between date '"+fromdate.toString()+"' and date '"+todate.toString()+"')group by F18_25_product.product_type))");
                    while(rs.next())
                        JOptionPane.showMessageDialog(BG2Frame,"Product Type: "+rs.getString("product_type")+" \nCount: "+rs.getString("cnt"));
                   
                    rs.close();
                    stmt.close();
                      // 
                    }
                    catch (SQLException de) {
           
               System.out.println("error in accessing the relation");
               de.printStackTrace();
               return;
             
              }    
                }
                }
         });
   
    pan1.add(lbl1);
    pan1.add(fromdate);
    pan1.add(lbl2);
    pan1.add(todate);
    pan1.add(find);
    BG2Frame.add(pan1);
    BG2Frame.setVisible(true);
}
public void findMinProdWarehouse(Connection conn,JFrame jf) {
JFrame jf1=jf;
if(conn !=null)
    {
     try {
            Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT warehouseid FROM (SELECT warehouse_id as warehouseid,COUNT(PRODUCT_ID) as PCNT FROM f18_25_has GROUP BY warehouse_id) where PCNT=(SELECT MIN(PCNT) FROM (SELECT warehouse_id,COUNT(PRODUCT_ID) as PCNT from f18_25_has GROUP BY warehouse_id))");
        while(rs.next())
            JOptionPane.showMessageDialog(jf1,"Warehouse ID: "+rs.getString("warehouseid"));
       
        rs.close();
        stmt.close();
          // 
        }
        catch (SQLException de) {

   System.out.println("error in accessing the relation");
   de.printStackTrace();
        }

    }
}

public void BG4(Connection conn)
{
JFrame BG4Frame = new JFrame("Find the store with minimum call orders");
    {
        try {
               Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("select str, call_order_cnt from (Select store_id as str,count(buy_type) as call_order_cnt  from F18_25_cust_buys where buy_type = 'Call'  group by store_id) where call_order_cnt = (select min(typcnt) from (Select store_id as str,count(buy_type) as typcnt  from F18_25_cust_buys  where buy_type = 'Call'  group by store_id))");
           while(rs.next())
            JOptionPane.showMessageDialog(BG4Frame,"Store: "+rs.getString("str")+" \nCount: "+rs.getString("call_order_cnt"));
         
           rs.close();
           stmt.close();
             // 
           }
           catch (SQLException de) {
 
      System.out.println("error in accessing the relation");
      de.printStackTrace();
      return;
   
     }    
       }

}

public void BG11(Connection conn,JTextArea queryArea1)
{
	
	try {
        Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT sid, sum(totalamnt) as TotalDeliveryCharge FROM (SELECT str_id as sid,stage as stg,(stage*10)+10 as stdchrg,count(stage)as stgcnt,((stage*10)+10)*(count(stage)) as totalamnt FROM f18_25_Delivery GROUP BY stage,str_id) GROUP BY sid");
    queryArea1.setText("Store    Delivery Amount\n");
    while(rs.next())
    {
    queryArea1.append(rs.getString("sid")+"      "+rs.getString("TotalDeliveryCharge")+"\n");	
    }
     rs.close();
    stmt.close();
      // 
    }
    catch (SQLException de) {

System.out.println("error in accessing the relation");
de.printStackTrace();
return;

}    
}
public void BG9(Connection conn,JTextArea queryArea2)
{
	try {
        Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT f18_25_has.warehouse_id,f18_25_has.product_id,f18_25_has.quantity_of_reserved_products from f18_25_has inner join (select f18_25_has.warehouse_id,min(Quantity_of_reserved_products) as minqnt from f18_25_has group by warehouse_id) qnt on f18_25_has.quantity_of_reserved_products=qnt.minqnt and f18_25_has.warehouse_id=qnt.warehouse_id");
    queryArea2.setEditable(false);
    queryArea2.setText("WareHouse  Product ID  Quantity\n");
    while(rs.next())
    {
    queryArea2.append(rs.getString("warehouse_id")+"              "+rs.getString("product_id")+"             "+rs.getString("quantity_of_reserved_products")+"\n");	
    }
     rs.close();
    stmt.close();
      // 
    }
    catch (SQLException de) {

System.out.println("error in accessing the relation");
de.printStackTrace();
return;

} 	

}
public void searchUser(Connection conn)
{
JFrame searchfrm = new JFrame("Search User");
GridLayout grid = new GridLayout(2,1);
searchfrm.setSize(400, 400);
JPanel outerPanel=new JPanel(grid);
JPanel panel1 = new JPanel();
JPanel panel2 = new JPanel();
panel1.setBounds(0, 0, 100, 100);
panel2.setBounds(0, 100, 100, 100);
JTextArea displayArea = new JTextArea(5,2);

JLabel custId = new JLabel("Customer ID:");
JTextField cus = new JTextField();
cus.setPreferredSize(new Dimension(40,20));
JButton srch_but = new JButton("Search");
panel1.add(custId);
panel1.add(cus);
panel1.add(srch_but);
panel1.setBackground(Color.GRAY);
panel2.add(displayArea);
outerPanel.add(panel1);
outerPanel.add(panel2);
searchfrm.add(outerPanel);
JButton del_but = new JButton("Delete");
panel2.add(del_but);
del_but.setVisible(false);
srch_but.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
     {
           if(conn !=null)
           {
            try {
                   Statement stmt = conn.createStatement();
               ResultSet rs = stmt.executeQuery("select distinct F18_25_Customer.first_name,F18_25_Customer.last_name from F18_25_REGULAR_CUST,F18_25_Customer where F18_25_Customer.customer_ID = F18_25_REGULAR_CUST.customerID and F18_25_REGULAR_CUST.customerID = '"+ cus.getText().toString()+"'");
               
               displayArea.setText("Customer Details\n");
               while(rs.next())
               {
                   displayArea.append(rs.getString("first_name")+" "+rs.getString("last_name"));
               }
                 // 
               }
               catch (SQLException de) {
      
          System.out.println("error in accessing the relation");
          de.printStackTrace();
          return;
        
         } 
          del_but.setVisible(true); 
          del_but.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                 {
                    
                    try {
                        Statement stmt = conn.createStatement();
                        stmt.executeQuery("Delete from F18_25_REGULAR_CUST where customerID ='"+cus.getText().toString()+"'");
                    	stmt.executeQuery("Delete from F18_25_Customer where customer_ID ='"+cus.getText().toString()+"'");
                    	JOptionPane.showMessageDialog(searchfrm,"Customer Deleted Successfully");
                    }
                    catch (SQLException de) {
           
               System.out.println("error in accessing the relation");
               de.printStackTrace();
               return;
             
              }
                  
                  }
                });

           
           }
           }
    });

searchfrm.setVisible(true);

}
public void viewCustomers(Connection conn,JTextArea txtArea) {
	try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from f18_25_Customer");
        txtArea.setEditable(false);
        txtArea.setText("CustomerID\tFirstname\tLastname\n========================================\n");
        while(rs.next())
        {
        	txtArea.append(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\n");	
        }
        
        rs.close();
        stmt.close();
        // 
    	}
    catch (SQLException de) {

System.out.println("error in accessing the relation");
de.printStackTrace();
return;

} 	
	
}

public void viewEmployees(Connection conn,JTextArea txtArea) {
	try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from f18_25_Employee");
        txtArea.setEditable(false);
        txtArea.setText("EMPLOYEEID\tFIRSTNAME\tLASTNAME\tSTOREID\tGENDER\tDOB\tADDRESS\t\tEMPLOYEETYPE\tEMPLOYMENTTYPE\tFROMDATE\tTODATE\tEMPLOYMENTWAGE\n=================================================================================================================================================================================================\n");
        while(rs.next())
        {
        	txtArea.append(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t\t"+rs.getString(9)+"\t\t"+rs.getString(10)+"\t"+rs.getString(11)+"\t"+rs.getString(12)+"\n");	
        }
        rs.close();
        stmt.close();
        // 
    	}
    catch (SQLException de) {

System.out.println("error in accessing the relation");
de.printStackTrace();
return;
}
}
public void viewProducts(Connection conn,JTextArea txtArea) {
	try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from f18_25_PRODUCT");
        txtArea.setEditable(false);
        txtArea.setText("PRODUCTID\tNAME\tBRAND\tSUPPLIERID\tPRODUCT_TYPE\n======================================================================\n");
        while(rs.next())
        {
        	txtArea.append(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\n");	
        }
        rs.close();
        stmt.close();
        // 
    	}
    catch (SQLException de) {

System.out.println("error in accessing the relation");
de.printStackTrace();
return;
}
}
public void viewRegCust(Connection conn,JTextArea txtArea) {
	try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from f18_25_REGULAR_Cust");
        txtArea.setEditable(false);
        txtArea.setText("CUSTOMERID\tADDRESS\t\tCONTACT\tCARDNUMBER\tCARDTYPE\tCARDISSUEDATE\n============================================================================================\n");
        while(rs.next())
        {
        	txtArea.append(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\n");	
        }
        
        rs.close();
        stmt.close();
        // 
    	}
    catch (SQLException de) {

System.out.println("error in accessing the relation");
de.printStackTrace();
return;

} 
}
public void viewCallCust(Connection conn,JTextArea txtArea) {
	try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from f18_25_Call_order_Customer");
        txtArea.setEditable(false);
        txtArea.setText("CUST_ID\tADDRESS\tCUST_CONTACT\n========================================\n");
        while(rs.next())
        {
        	txtArea.append(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\n");	
        }
        
        rs.close();
        stmt.close();
        // 
    	}
    catch (SQLException de) {

System.out.println("error in accessing the relation");
de.printStackTrace();
return;

} 
}
public void viewSuppliers(Connection conn,JTextArea txtArea) {
	try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from f18_25_Supplier");
        txtArea.setEditable(false);
        txtArea.setText("SUPPLIER_ID\tSUPPLIER_TYPE\tSUPPLIER_NAME\n===========================================================\n");
        while(rs.next())
        {
        	txtArea.append(rs.getString(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\n");	
        }
        
        rs.close();
        stmt.close();
        // 
    	}
    catch (SQLException de) {

System.out.println("error in accessing the relation");
de.printStackTrace();
return;
} 
}
public void findFreqCallOrderLoc(Connection conn,JFrame jf1) {
	if(conn !=null)
    {
     try {
            Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("Select call_order_location from (select F18_25_Call_Order_Customer.Address as call_order_location, count(F18_25_Call_Order_Customer.Address)as cadcnt	from F18_25_cust_buys,F18_25_Call_Order_Customer where F18_25_cust_buys.customerID = F18_25_Call_Order_Customer.Cust_ID group by F18_25_Call_Order_Customer.Address) where cadcnt = (Select max(cadcnt)	from (select F18_25_Call_Order_Customer.Address as cad, count(F18_25_Call_Order_Customer.Address)as cadcnt from F18_25_cust_buys,F18_25_Call_Order_Customer where F18_25_cust_buys.customerID = F18_25_Call_Order_Customer.Cust_ID group by F18_25_Call_Order_Customer.Address))");
        while(rs.next())
            JOptionPane.showMessageDialog(jf1,"Zip: "+rs.getString("call_order_location"));
       
        rs.close();
        stmt.close();
          // 
        }
        catch (SQLException de) {

   System.out.println("error in accessing the relation");
   de.printStackTrace();
        }

    }
}
public void findSilverCardExpense(Connection conn,JFrame jf1)
{
	if(conn !=null)
    {
     try {
            Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select (sum(tot)/100)*5 as silver_discount from (select cid,sum(prc) as tot,dat,ctyp from (select F18_25_cust_buys.customerID as cid,F18_25_cust_buys.buy_date as dat,F18_25_regular_cust.cardtype as ctyp,F18_25_cust_buys.price as prc from F18_25_cust_buys,F18_25_regular_cust where F18_25_regular_cust.customerID = F18_25_cust_buys.customerID) group by dat,cid,ctyp having sum(prc) >500 and ctyp = 'Silver')");
        while(rs.next())
            JOptionPane.showMessageDialog(jf1,"Silver card Expense: "+rs.getString("silver_discount"));
       
        rs.close();
        stmt.close();
          // 
        }
        catch (SQLException de) {

   System.out.println("error in accessing the relation");
   de.printStackTrace();
        }

    }
}
public void findGoldCardExpense(Connection conn,JFrame jf1)
{
	if(conn !=null)
    {
     try {
            Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select (sum(tot)/100)*10 as gold_discount from (select cid,sum(prc) as tot,dat,ctyp from (select F18_25_cust_buys.customerID as cid,F18_25_cust_buys.buy_date as dat,F18_25_regular_cust.cardtype as ctyp,F18_25_cust_buys.price as prc from F18_25_cust_buys,F18_25_regular_cust where F18_25_regular_cust.customerID = F18_25_cust_buys.customerID) group by dat,cid,ctyp having sum(prc) >800 and ctyp = 'Gold')");
        while(rs.next())
            JOptionPane.showMessageDialog(jf1,"Gold card Expense: "+rs.getString("gold_discount"));
       
        rs.close();
        stmt.close();
          // 
        }
        catch (SQLException de) {

   System.out.println("error in accessing the relation");
   de.printStackTrace();
        }

    }
}
public void findMinRevStore(Connection conn)
{
    JFrame minRevStoreFrame = new JFrame("Store with Min Revenue");
    minRevStoreFrame.setSize(600,400);
    GridLayout grid = new GridLayout(3,2);
    JPanel pan1 = new JPanel(grid);
    JLabel lbl1 = new JLabel("From:");
    JLabel lbl2 = new JLabel("To:");
    DatePicker fromdate = new DatePicker();
    DatePicker todate = new DatePicker();
    JButton find = new JButton("FIND");
    find.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e)
          {
                if(conn !=null)
                {
                 try {
                        Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("Select str from (select F18_25_cust_buys.store_id as str,sum(F18_25_cust_buys.price) as rev from F18_25_cust_buys,F18_25_product where F18_25_product.product_id=F18_25_cust_buys.product_id and (F18_25_cust_buys.buy_date between date '"+fromdate.toString()+"' and date '"+todate.toString()+"') group by F18_25_cust_buys.store_id) where rev = (Select min(rev) from (select sum(F18_25_cust_buys.price) as rev from F18_25_cust_buys,F18_25_product where F18_25_product.product_id=F18_25_cust_buys.product_id and (F18_25_cust_buys.buy_date between date '"+fromdate.toString()+"' and date '"+todate.toString()+"') group by F18_25_cust_buys.store_id))");
                    while(rs.next())
                        JOptionPane.showMessageDialog(minRevStoreFrame,"StoreID: "+rs.getString("str"));
                   
                    rs.close();
                    stmt.close();
                      // 
                    }
                    catch (SQLException de) {
           
               System.out.println("error in accessing the relation");
               de.printStackTrace();
               return;
             
              }    
                }
                }
         });
   
    pan1.add(lbl1);
    pan1.add(fromdate);
    pan1.add(lbl2);
    pan1.add(todate);
    pan1.add(find);
    minRevStoreFrame.add(pan1);
    minRevStoreFrame.setVisible(true);
}
public void findMaxProductBrand(Connection conn,JTextArea txtArea) {
	try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("Select str,brd,cnt from (select F18_25_cust_buys.store_id as str,F18_25_product.brand as brd,count(F18_25_cust_buys.product_id) as cnt from F18_25_product,F18_25_cust_buys where F18_25_product.product_id=F18_25_cust_buys.product_id group by F18_25_cust_buys.store_id,F18_25_product.brand order by F18_25_cust_buys.store_id) where cnt in (select max(cnt) from(select F18_25_cust_buys.store_id as str,F18_25_product.brand as brd,count(F18_25_cust_buys.product_id) as cnt from F18_25_product,F18_25_cust_buys where F18_25_product.product_id=F18_25_cust_buys.product_id group by F18_25_cust_buys.store_id,F18_25_product.brand order by F18_25_cust_buys.store_id) brcnt group by str)");
        txtArea.setEditable(false);
        txtArea.setText("STORE_ID\tBRAND\tNO_OF_PURCHASES\n========================================\n");
        while(rs.next())
        {
        	txtArea.append(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\n");	
        }
        
        rs.close();
        stmt.close();
        // 
    	}
    catch (SQLException de) {

System.out.println("error in accessing the relation");
de.printStackTrace();
return;
} 
}
public void findRev(Connection conn)
{
    JFrame RevenueFrame = new JFrame("Revenue of Stores");
    RevenueFrame.setSize(500,400);
    GridLayout grid = new GridLayout(3,2);
    JPanel pan1 = new JPanel(grid);
    JLabel lbl1 = new JLabel("From:");
    JLabel lbl2 = new JLabel("To:");
    DatePicker fromdate = new DatePicker();
    DatePicker todate = new DatePicker();
    JButton find = new JButton("FIND");
    JTextArea result=new JTextArea();
    find.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e)
          {
                if(conn !=null)
                {
                 try {
                        Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("select F18_25_cust_buys.store_id,sum(F18_25_cust_buys.price*F18_25_cust_buys.quantity) as revenue from F18_25_cust_buys,F18_25_product where F18_25_product.product_id=F18_25_cust_buys.product_id and (F18_25_cust_buys.buy_date between date '"+fromdate.toString()+"' and date '"+todate.toString()+"') group by F18_25_cust_buys.store_id");
                    result.setEditable(false);
                    result.setText("STORE_ID\tRevenue\n=======================\n");
                    while(rs.next())
                    {
                    	result.append(rs.getString(1)+"\t"+rs.getString(2)+"\n");	
                    }
                   
                    rs.close();
                    stmt.close();
                      // 
                    }
                    catch (SQLException de) {
           
               System.out.println("error in accessing the relation");
               de.printStackTrace();
               return;
             
              }    
                }
                }
         });
   
    pan1.add(lbl1);
    pan1.add(fromdate);
    pan1.add(lbl2);
    pan1.add(todate);
    pan1.add(find);
    pan1.add(result);
    RevenueFrame.add(pan1);
    RevenueFrame.setVisible(true);
}
public void updateproduct(Connection conn)
{
JFrame updateProductfrm = new JFrame("Update Product");
GridLayout grid = new GridLayout(2,1);
GridLayout grid2 = new GridLayout(3,2);
updateProductfrm.setSize(400, 400);
JPanel outerPanel=new JPanel(grid);
JPanel panel1 = new JPanel(grid2);
JPanel panel2 = new JPanel();
panel1.setBounds(0, 0, 100, 100);
panel2.setBounds(0, 100, 100, 100);
outerPanel.add(panel1);
outerPanel.add(panel2);
JLabel lbl1 = new JLabel("Product ID");
JLabel lbl2 = new JLabel("Product Brand");
JTextField f1 = new JTextField();
JTextField f2 = new JTextField();
panel1.add(lbl1);
panel1.add(f1);
panel1.add(lbl2);
panel1.add(f2);
JButton srch_but = new JButton("Search");
JButton update_but = new JButton("Update");
panel2.add(srch_but);
panel2.add(update_but);
updateProductfrm.add(outerPanel);
updateProductfrm.setVisible(true);
srch_but.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
     {
           if(conn !=null)
           {
            try {
                   Statement stmt = conn.createStatement();
               ResultSet rs = stmt.executeQuery("select brand from f18_25_product where product_id ='"+f1.getText().toString()+"'");
               while(rs.next())
               {
            	   f2.setText(rs.getString("brand"));
               }
               rs.close();
               stmt.close();
                 // 
               }
               catch (SQLException de) {
      
          System.out.println("error in accessing the relation");
          de.printStackTrace();
          return;
        
         }    
           }
           f1.setEditable(false);
           }
    });
update_but.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
     {
        if(f2.getText().equals(""))
        {
        	
        	JOptionPane.showMessageDialog(updateProductfrm,"Product Brand Cannot be updated if it is Empty");	
        }
        else{
    	if(conn !=null)
           {
            try {
               Statement stmt = conn.createStatement();
               stmt.executeQuery("update f18_25_product set brand='"+f2.getText().toString()+"'  where product_id ='"+f1.getText().toString()+"'");
               JOptionPane.showMessageDialog(updateProductfrm,"Update Successful");
               stmt.close();
                 // 
               }
               catch (SQLException de) {
      
          System.out.println("error in accessing the relation");
          de.printStackTrace();
          return;
        
         }    
           }
           }
     }
    });


}
}



