package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewIssueBooks extends JFrame
{
    String x[]= {"Book Id","Book No","Book Name","Student Id","Student Name","Student Contact","Date"};
    JButton bt;
    String y[][]= new String[20][7];
    
    int i=0,j=0;
    JTable t;
    Font f,f1;
            
    ViewIssueBooks()
    {
        super("Issued Books' Information");
        setLocation(1,1);
        setSize(1000,400);
        
        f=new Font("Arial",Font.BOLD,15);
        
        try
        {
            ConnectionClass obj= new ConnectionClass();
            
            String q= "select * from issuebook";
            ResultSet rest= obj.stm.executeQuery(q);
            
            while(rest.next())
            {
                y[i][j++]=rest.getString("BookId");
                y[i][j++]=rest.getString("Bookno");
                y[i][j++]=rest.getString("Bookname");
                y[i][j++]=rest.getString("StudentId");
                y[i][j++]=rest.getString("Studentname");
                y[i][j++]=rest.getString("Studentcontact");
                y[i][j++]=rest.getString("Date");
                
                i++;
                j=0;                   
            }
            
            t= new JTable(y,x);
            
            t.setFont(f);
        }
            
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        JScrollPane sp=new JScrollPane(t);
        add(sp);
    }
    
    public static void main(String[] args) 
    {
        new ViewIssueBooks().setVisible(true);
    }
}