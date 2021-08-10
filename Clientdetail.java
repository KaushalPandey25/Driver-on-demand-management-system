package corejavaproject.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import corejavaproject.dbtask.CrudOperation;

import javax.swing.JButton;
import java.sql.*;


public class Clientdetail extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtmail;
	private JTextField txtphone;
	private JTextField txtaddress;
	private Connection con;
	private PreparedStatement psAdd,psUpdate,pssearch,psdelete;
	private ResultSet rssearch,rsupdate,rsdelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientdetail frame = new Clientdetail();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Clientdetail() {
		con=CrudOperation.createConnection();
		CreateGui();
	}
private void CreateGui(){setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 808, 714);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);
JLabel id = new JLabel("CLIENT ID");
id.setBounds(115, 113, 121, 34);
contentPane.add(id);
JLabel name = new JLabel("NAME");
name.setBounds(232, 204, 74, 26);
contentPane.add(name);
JLabel email = new JLabel("EMAIL");
email.setBounds(115, 251, 74, 34);
contentPane.add(email);
JLabel phone = new JLabel("PHONE NO.");
phone.setBounds(217, 323, 89, 49);
contentPane.add(phone);
JLabel address = new JLabel("ADDRESS");
address.setBounds(232, 445, 73, 34);
contentPane.add(address);
txtid = new JTextField();
txtid.setBounds(256, 121, 156, 34);
contentPane.add(txtid);
txtid.setColumns(10);
txtname = new JTextField();
txtname.setBounds(410, 196, 156, 34);
contentPane.add(txtname);
txtname.setColumns(10);
txtmail = new JTextField();
txtmail.setBounds(256, 259, 156, 34);
contentPane.add(txtmail);
txtmail.setColumns(10);
txtphone = new JTextField();
txtphone.setBounds(377, 333, 156, 29);
contentPane.add(txtphone);
txtphone.setColumns(10);
txtaddress = new JTextField();
txtaddress.setBounds(395, 450, 156, 26);
contentPane.add(txtaddress);
txtaddress.setColumns(10);
JButton btnAdd = new JButton("ADD");
btnAdd.addActionListener(this);
btnAdd.setBounds(68, 548, 133, 34);

contentPane.add(btnAdd);
JButton btnUpdate = new JButton("UPDATE");
btnUpdate.addActionListener(this);
btnUpdate.setBounds(217, 548, 108, 34);
contentPane.add(btnUpdate);
JButton btnSearch = new JButton("SEARCH");
btnSearch.addActionListener(this);
btnSearch.setBounds(350, 550, 108, 32);
contentPane.add(btnSearch);
JButton btnDelete = new JButton("DELETE");
btnDelete.addActionListener(this);
btnDelete.setBounds(481, 551, 108, 31);
contentPane.add(btnDelete);
}

@Override
public void actionPerformed(ActionEvent e) {
String id=txtid.getText();
String name=txtname.getText();
String phone=txtphone.getText();
String email=txtmail.getText();
String address=txtaddress.getText();
String caption=e.getActionCommand();
System.out.println(caption);
if(caption.equals("SEARCH"))
{if(id.isEmpty())
	JOptionPane.showMessageDialog(this,"Data Required");
else {
	try {
		
		String strsql="select * from clientdetails where ClientId=?";
			pssearch=con.prepareStatement(strsql);
			pssearch.setString(1, id);
			System.out.println(pssearch);
			rssearch=pssearch.executeQuery();
		if(rssearch.next()==true)
			
		{
				String phonenumber=	rssearch.getString("PhoneNo");
				txtphone.setText(phonenumber);
				String email1=rssearch.getString("EMAIl");
				txtmail.setText(email1);
				String name1 =rssearch.getString("NAME");
				txtname.setText(name1);
				String address1 =rssearch.getString("address");
				txtaddress.setText(address1);
				
				
				
				
			
		}
			
		else
		{
			JOptionPane.showMessageDialog(this, "No Such Email");
			
		}
			
				
				
				
			}
	
			
			catch(SQLException se)
			{
				
				System.out.println(se);
			}

			finally {
				
				try {
					if(rssearch!=null)rssearch.close();
					if(pssearch!=null)pssearch.close();
					
				}
				catch(SQLException se) {System.out.println(se);}
			}
		
		
		
	}
	
	
}
if(caption.equals("ADD"))
{if(id.isEmpty()||name.isEmpty()||phone.isEmpty()||email.isEmpty()||address.isEmpty())
	JOptionPane.showMessageDialog(this,"DataRequired");
	
else
{
	try {
		
	String strinsert="insert into  clientdetails values(?,?,?,?,?)";
			psAdd=con.prepareStatement(strinsert);//dbms compiler will compile query->ps
			psAdd.setString(1, id);
			psAdd.setString(2, name);
			psAdd.setString(4, phone);
			psAdd.setString(3, email);
			psAdd.setString(5, address);
			
			System.out.println(psAdd);
			
		int row=psAdd.executeUpdate();//insert/update//delete
			if(row>0)
			{
			JOptionPane.showMessageDialog(this, "record added");
			
		
			
			}
		
			
					
				}catch(SQLException se) {
					System.out.println(se);
				}
					
				finally {
					
					try {
						if(psAdd!=null)
							psAdd.close();
					}
					catch(SQLException se) {System.out.println(se);}
					
				}	
if(caption.equals("Update"))
{try {
	String strupdate="update clientdetails set Phoneno=?,Name=?, Address=?, Email=? where ClientId=?";
	psUpdate=con.prepareStatement(strupdate);
	String phone2=txtphone.getText();
	String name2=txtname.getText();
	String address2=txtaddress.getText();
	String Email2=txtmail.getText();
	psUpdate.setString(1, phone2);
	psUpdate.setString(5, id);
	psUpdate.setString(2, name2);
	psUpdate.setString(3, address2);
	psUpdate.setString(4, Email2);
	
	
int rw=	psUpdate.executeUpdate();

if(rw>0)
{
	
	JOptionPane.showMessageDialog(this, "REcordUpdated","updation",JOptionPane.QUESTION_MESSAGE );
}
		
	}
	catch(SQLException se) {System.out.println(se);}
		
	}
	
	
	}
	
	
}
	
}}
	
	

