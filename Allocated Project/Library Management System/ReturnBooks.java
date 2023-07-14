package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ReturnBooks extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JButton bt1,bt2;
    JPanel p1,p2;
    Font f,f1;
    JTextField tf1,tf2;
    
    ReturnBooks()
    {
        super("Return Book");
        setSize(650,200);
        setLocation(0,0);
        
        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Arial",Font.BOLD,20);
        
        l1=new JLabel("Return Books");
        l2=new JLabel("Book No");
        l3=new JLabel("Student Id");
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.WHITE);
        
        tf1= new JTextField();
        tf2= new JTextField();
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        
         bt1=new JButton("Return Book");
        bt2=new JButton("Cancel");
        
        bt1.setFont(f1);
        bt2.setFont(f1);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        tf1.setFont(f1);
        tf2.setFont(f1);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        p1.setBackground(Color.BLUE);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(3,2,10,10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(tf2);
        p2.add(bt1);
        p2.add(bt2);
        
        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"South");
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String bookno= tf1.getText();
        int stuid= Integer.parseInt(tf2.getText());
        
        if(e.getSource()==bt1)
        {
            try
            {
                ConnectionClass obj= new ConnectionClass();
            
                String q= "delete from issuebook where Bookno='"+bookno+"' and StudentId='"+Integer.toString(stuid)+"'";
                int res=obj.stm.executeUpdate(q);
                
                if(res==0)
                {
                    JOptionPane.showMessageDialog(null,"Book isn't issued");
                    this.setVisible(false);
                }
                
                else
                {
                    String q1="update addbook set Issuebook=Issuebook-1 where Bookno='"+bookno+"'";
                    String q2="update addbook set Quantity=Quantity+1 where Bookno='"+bookno+"'";      
                    
                    int aa=obj.stm.executeUpdate(q1);
                    int aaa=obj.stm.executeUpdate(q2);
                    
                    if(aa==1)
                    {
                        if(aaa==1)
                        {
                            JOptionPane.showMessageDialog(null,"Your book is successfully updated");
                            this.setVisible(false);
                        }            
                            
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Please!, Fill all the details carefully");
                        }
                    }
                    
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Please!, Fill all the details carefully");
                    }
                }
            }
            
             catch(Exception ee)
            {
                ee.printStackTrace();
            }
        }
        
        if(e.getSource()==bt2)
        {
            System.exit(0);
        }
    }
    
    public static void main(String[] args)
    {
        new ReturnBooks().setVisible(true);        
    }
}
