package contactList1;

import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import shortTermCourseManagement.ReadData;
import shortTermCourseManagement.SaveData;

public class CLApplet extends JApplet {
	public ContactList contcs=new ContactList();
	public JApplet frame;
	public CardLayout cL=new CardLayout();
	JPanel card1=new JPanel();
	JPanel card2=new JPanel();
	JPanel card3=new JPanel();
	JPanel card4=new JPanel();
	JPanel card5=new JPanel();
	JPanel card6=new JPanel();
	JPanel card7=new JPanel();
	JPanel card8=new JPanel();
	JPanel card9=new JPanel();
	JPanel card10=new JPanel();
	JPanel card11=new JPanel();
	JPanel card12=new JPanel();
	JPanel card13=new JPanel();
	JPanel card14=new JPanel();
	private JMenu mnNewMenu;
	TextArea textArea_2 = new TextArea();
	TextArea textArea_3 = new TextArea();
	TextArea textArea_4 = new TextArea();
	TextArea textArea_9 = new TextArea();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	TextArea textArea = new TextArea();
	TextArea textArea_1 = new TextArea();
	ArrayList<Acquaintance> delacquaintance = new ArrayList<Acquaintance>();
	public DefaultListModel<String> list1=new DefaultListModel<>();
	public JList list = new JList(list1);
	public JList list_1 = new JList(list1);
	
	public void init()
	{
		try{
			frame=this;
			File f = new File("cList.dat");
			if (f.exists()) {
                	if (JOptionPane.YES_OPTION
                			== JOptionPane.
                			showConfirmDialog(new JFrame(),
                					"Read Preiously stored data?", null, JOptionPane.YES_NO_OPTION)) {
                		this.contcs = (ContactList)ReadData.read(this.contcs, "cList");
                		//window.update(acq -> true);
                	}
            	}
			initialise();
		}
		catch(Exception e)
		{
			if (e.getMessage() == null) {
                JOptionPane.showMessageDialog(new JFrame(), e.getClass().toString(), null, JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), null, JOptionPane.WARNING_MESSAGE);
            }
		}
	}

	private void initialise() {
		
		initialize();
	}
	private void initialize() {
     
		frame.setSize(646, 467);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Main menu");
		JMenu file = new JMenu("File");
		
		JMenuItem save = new JMenuItem("Save");
		
		save.addActionListener(e->{
            if(JOptionPane.YES_NO_OPTION == JOptionPane.showConfirmDialog(this.frame, "Save Data?", null, JOptionPane.YES_NO_OPTION)) {
                try {
                    SaveData.save(contcs, "cList");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this.frame, ex.getMessage(), null, JOptionPane.WARNING_MESSAGE);
                    }
                System.exit(0);
                }
        });
		file.add(save);
		JMenuItem load = new JMenuItem("Load");
		load.addActionListener(e->{
            try {
                if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this.frame, "Load Data?", null, JOptionPane.YES_NO_OPTION)) {
                        contcs= (ContactList)ReadData.read(contcs, "cList");
                       
                    }
            }
            catch(Exception ex) {
                JOptionPane.showMessageDialog(new Frame(), ex.getMessage());
            }
        });
		file.add(load);
		menuBar.add(mnNewMenu);
		menuBar.add(file);
		//CardLayout cL=new CardLayout();
		JMenuItem mntmCreateAcquaintance = new JMenuItem("Create Acquaintance");
		mntmCreateAcquaintance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			cL.show(frame.getContentPane(),"For Creating Acquaintace");
			}
		});
		mnNewMenu.add(mntmCreateAcquaintance);
		
		JMenuItem mntmDeleteAcquaintance = new JMenuItem("Delete Acquaintance");
		mntmDeleteAcquaintance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cL.show(frame.getContentPane(),"For deleting the acquaintance");
				list1.removeAllElements();
					try {
						contcs.acqsreturn().forEach(n->{
							   list1.addElement(n.name1);
});
					} catch (EmptyListException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		mnNewMenu.add(mntmDeleteAcquaintance);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Display specific list of aq");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("hi");
				cL.show(frame.getContentPane(),"For diplaying specific list of acquaintance");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Display List of acquaintance");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cL.show(frame.getContentPane(),"For displaying the entire list of acquaintances");
				try {
					textArea_9.setText("");
					contcs.acqsreturn().forEach(v->{
						//JTextArea textArea_9;
						textArea_9.append(v.toString("name")+"\n");
					System.out.println(v.toString("name"));});
			} catch (EmptyListException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmSearchAcquaintance = new JMenuItem("Search Acquaintance");
		mntmSearchAcquaintance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   cL.show(frame.getContentPane(),"For searching acquaintance");
			   list1.removeAllElements();
			   try {
				contcs.acqsreturn().forEach(m->{
					   list1.addElement(m.name1);
				   });
			} catch (EmptyListException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		mnNewMenu.add(mntmSearchAcquaintance);
		
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		cL= (CardLayout) frame.getContentPane().getLayout();
		frame.getContentPane().add(card1, "For Creating Acquaintace");
		frame.getContentPane().add(card2, "For accepting details of acquaintance");
		frame.getContentPane().add(card3, "For accepting a personal friend");
		frame.getContentPane().add(card4, "For accepting details of a casual acquaintance");
		frame.getContentPane().add(card5,"For accepting details of professional friend");
		frame.getContentPane().add(card6, "For diplaying specific list of acquaintance");
		frame.getContentPane().add(card7,"For displaying relative list");
		frame.getContentPane().add(card8, "For displaying professional friend list");
		frame.getContentPane().add(card9,"For displaying personal friend list");
		frame.getContentPane().add(card10,"For displaying casual acquaintance list");
		frame.getContentPane().add(card11,"For displaying the entire list of acquaintances");
		frame.getContentPane().add(card12,"For searching acquaintance");
		frame.getContentPane().add(card13,"For displaying search details");
		frame.getContentPane().add(card14,"For deleting the acquaintance");
		card14.setLayout(null);
		
		JLabel lblListOfAcquaintances_2 = new JLabel("List of acquaintances present to delete");
		lblListOfAcquaintances_2.setBounds(192, 11, 277, 14);
		card14.add(lblListOfAcquaintances_2);
		
		//JList list_1 = new JList();
		list_1.setBounds(49, 56, 522, 241);
		card14.add(list_1);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
					contcs.acqsreturn().removeIf(e->e.name1.equals(list_1.getSelectedValue().toString()));
					list1.remove(list_1.getSelectedIndex());
				} catch (EmptyListException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			}
		});
		btnDelete.setBounds(266, 340, 89, 23);
		card14.add(btnDelete);
		card13.setLayout(null);
		
		JLabel lblDetailsOfSearched = new JLabel("Details of searched acquaintance");
		lblDetailsOfSearched.setBounds(125, 11, 187, 14);
		card13.add(lblDetailsOfSearched);
		
		JTextArea textArea_10 = new JTextArea();
		textArea_10.setBounds(41, 56, 354, 223);
		JScrollPane jsp_10 = new JScrollPane(textArea_10);
		jsp_10.setBounds(39, 64, 380, 276);
		card13.add(jsp_10);
		card12.setLayout(null);
		
		JLabel lblListOfAcquaintances_1 = new JLabel("List of acquaintances");
		lblListOfAcquaintances_1.setBounds(170, 11, 112, 14);
		card12.add(lblListOfAcquaintances_1);
		
		//JList list = new JList();
		list.setBounds(46, 41, 345, 260);
		card12.add(list);
		
		JButton btnChoose = new JButton("CHOOSE");
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     cL.show(frame.getContentPane(),"For displaying search details");
			     textArea_10.setText("");
			     try {
					contcs.acqsreturn().stream().filter(a -> a.name1.equals(list.getSelectedValue())).forEach(a->textArea_10.append(a.toString()));
				} catch (EmptyListException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnChoose.setBounds(170, 315, 89, 23);
		card12.add(btnChoose);
		card11.setLayout(null);
		
		JLabel lblListOfAcquaintances = new JLabel("List of acquaintances");
		lblListOfAcquaintances.setBounds(116, 11, 214, 14);
		card11.add(lblListOfAcquaintances);
		
		//TextArea textArea_9 = new TextArea();
		textArea_9.setBounds(39, 57, 380, 276);
		JScrollPane jsp_9 = new JScrollPane(textArea_9);
		jsp_9.setBounds(39, 64, 380, 276);
		card11.add(jsp_9);
		card10.setLayout(null);
		
		JLabel lblCasualAcquaintanceList = new JLabel("Casual Acquaintance List");
		lblCasualAcquaintanceList.setBounds(108, 23, 203, 14);
		card10.add(lblCasualAcquaintanceList);
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setBounds(39, 64, 380, 276);
		JScrollPane jsp_8 = new JScrollPane(textArea_8);
		jsp_8.setBounds(39, 64, 380, 276);
		card10.add(jsp_8);
		card9.setLayout(null);
		
		JLabel lblPersonalFriendsList = new JLabel("Personal Friends list");
		lblPersonalFriendsList.setBounds(77, 11, 234, 14);
		
		card9.add(lblPersonalFriendsList);
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setBounds(35, 53, 380, 293);
		JScrollPane jsp_7 = new JScrollPane(textArea_7);
		jsp_7.setBounds(35, 53, 380, 293);
		card9.add(jsp_7);
		card8.setLayout(null);
		
		JLabel lblProfessionalFriendsList = new JLabel("Professional friends list");
		lblProfessionalFriendsList.setBounds(89, 11, 268, 14);
		card8.add(lblProfessionalFriendsList);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setBounds(28, 43, 380, 290);
		JScrollPane jsp_6 = new JScrollPane(textArea_6);
		jsp_6.setBounds(46, 50, 380, 296);
		card8.add(jsp_6);
		card7.setLayout(null);
		
		JLabel lblRelativesList = new JLabel("Relatives list");
		lblRelativesList.setBounds(102, 11, 133, 14);
		card7.add(lblRelativesList);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(46, 50, 380, 296);
		JScrollPane jsp_5 = new JScrollPane(textArea_5);
		jsp_5.setBounds(46, 50, 380, 296);
		card7.add(jsp_5);
		card6.setLayout(null);
		
		JLabel lblSelectTheType_1 = new JLabel("Select the type of acquaintance to display its list");
		lblSelectTheType_1.setBounds(67, 26, 278, 14);
		card6.add(lblSelectTheType_1);
		
		JButton btnNewButton = new JButton("Relative");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("hi");
				textArea_5.setText("");
				try {
					textArea_5.setText("");
					contcs.acqsreturn().stream().filter(t -> t instanceof Relative).forEach(t ->{
						textArea_5.append("Name:"+((Relative) t).name1+"\n"+"Mobile:"+((Relative)t).mobno1+"\n"+"Email:"+((Relative)t).email1+"\n"+"Birthday:"+((Relative)t).bDay+"\n"+"LastMeetingDate:"+((Relative)t).lastMeetingDate+"\n"+"-------------------------------------------"+"\n"); 
						System.out.println(((Relative) t).toString());});
					cL.show(frame.getContentPane(),"For displaying relative list");
				} catch (EmptyListException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(148, 68, 141, 23);
		
		card6.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Professional Friend");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cL.show(frame.getContentPane(),"For displaying professional friend list");
				textArea_6.setText("");
				try {
					contcs.acqsreturn().stream().filter(m->m instanceof ProfessionalFriends).forEach(m->{
						textArea_6.append("Name:"+((ProfessionalFriends) m).name1+"\n"+"Email:"+((ProfessionalFriends)m).email1+"\n"+"Common Interests:"+((ProfessionalFriends)m).comInterst+"\n"+"Mobile no:"+((ProfessionalFriends)m).mobno1+"\n"+"------------------------------------------------"+"\n");
					});
				} catch (EmptyListException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(148, 123, 141, 23);
		card6.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Personal Friend");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cL.show(frame.getContentPane(),"For displaying personal friend list");
				textArea_7.setText("");
				//String name,String email,String specificEvents,String context,String acquaintanceDate,Long mobno
				try {
					contcs.acqsreturn().stream().filter(s->s instanceof PersonalFriends).forEach(s->{
						textArea_7.append("Name:"+((PersonalFriends)s).name1+"\n"+"Email:"+((PersonalFriends)s).email1+"\n"+"Specific events:"+((PersonalFriends)s).specificEvents+"\n"+"Context:"+((PersonalFriends)s).context+"\n"+"Acquaintance date:"+((PersonalFriends)s).acquaintanceDate+"\n"+"Mobile No:"+((PersonalFriends)s).mobno1+"\n"+"-------------------------------------------------------"+"\n");
					});
				} catch (EmptyListException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(148, 183, 141, 23);
		card6.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Casual Acquaintance");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cL.show(frame.getContentPane(),"For displaying casual acquaintance list");
				textArea_8.setText("");
				//String name,Long mobileNo, String email,String date, String place, String circumstances,String otherUsefulInfo
				try {
					contcs.acqsreturn().stream().filter(s->s instanceof CasualAcquaintance).forEach(s->{
						textArea_8.append("Name:"+((CasualAcquaintance)s).name1+"\n"+"Mobile no:"+((CasualAcquaintance)s).mobno1+"\n"+"Email:"+((CasualAcquaintance)s).email1+"\n"+"Date of meeting:"+((CasualAcquaintance)s).casaqdate+"\n"+"Place of meeting"+((CasualAcquaintance)s).place1+"\n"+"Circumstances:"+((CasualAcquaintance)s).situation+"\n"+"Other useful info:"+((CasualAcquaintance)s).othrUseInf+"\n"+"---------------------------------------------------------------"+"\n");
					});
				} catch (EmptyListException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(148, 246, 141, 23);
		card6.add(btnNewButton_3);
		card5.setLayout(null);
		
		JLabel lblProfessionalFriendsDetails = new JLabel("Professional Friends details");
		lblProfessionalFriendsDetails.setBounds(38, 11, 176, 14);
		card5.add(lblProfessionalFriendsDetails);
		
		JLabel lblName_3 = new JLabel("Name");
		lblName_3.setBounds(10, 36, 46, 14);
		card5.add(lblName_3);
		
		textField_14 = new JTextField();
		textField_14.setBounds(82, 36, 310, 20);
		card5.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel lblMobileNo_3 = new JLabel("Mobile No");
		lblMobileNo_3.setBounds(10, 92, 63, 14);
		card5.add(lblMobileNo_3);
		
		textField_15 = new JTextField();
		textField_15.setBounds(82, 89, 310, 20);
		card5.add(textField_15);
		textField_15.setColumns(10);
		
		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setBounds(10, 148, 46, 14);
		card5.add(lblEmail_1);
		
		textField_16 = new JTextField();
		textField_16.setBounds(82, 145, 310, 20);
		card5.add(textField_16);
		textField_16.setColumns(10);
		
		JLabel lblCommonInterest = new JLabel("Common interest");
		lblCommonInterest.setBounds(10, 204, 91, 14);
		card5.add(lblCommonInterest);
		
		JButton btnCreate_3 = new JButton("CREATE");
		btnCreate_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///String name,String email, String comInterest,Long mobileNo
				try {
					contcs.appendaq(new ProfessionalFriends(textField_14.getText(),textField_16.getText(),textArea_4.getText(),Long.parseLong(textField_15.getText())));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 JOptionPane.showMessageDialog(null,"Acquaintance Added","Added",JOptionPane.PLAIN_MESSAGE);
				 card5.setVisible(false);
				 textField_14.setText(null);
				 textField_16.setText(null);
				 textField_15.setText(null);
				 textArea_4.setText(null);
			}
		});
		btnCreate_3.setBounds(148, 295, 89, 23);
		card5.add(btnCreate_3);
		
		//TextArea textArea_4 = new TextArea();
		textArea_4.setBounds(117, 187, 370, 57);
		card5.add(textArea_4);
		card4.setLayout(null);
		
		JLabel lblCasualAcquaintanceDetails = new JLabel("Casual Acquaintance details");
		lblCasualAcquaintanceDetails.setBounds(50, 11, 172, 14);
		card4.add(lblCasualAcquaintanceDetails);
		
		JLabel lblName_2 = new JLabel("Name");
		lblName_2.setBounds(10, 36, 46, 14);
		card4.add(lblName_2);
		
		textField_9 = new JTextField();
		textField_9.setBounds(159, 36, 322, 20);
		card4.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblMobileNo_2 = new JLabel("Mobile No");
		lblMobileNo_2.setBounds(10, 78, 70, 14);
		card4.add(lblMobileNo_2);
		
		textField_10 = new JTextField();
		textField_10.setBounds(159, 75, 322, 20);
		card4.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(10, 123, 46, 14);
		card4.add(lblNewLabel_1);
		
		textField_11 = new JTextField();
		textField_11.setBounds(159, 120, 322, 20);
		card4.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Meeting place");
		lblNewLabel_2.setBounds(10, 173, 84, 14);
		card4.add(lblNewLabel_2);
		
		textField_12 = new JTextField();
		textField_12.setBounds(159, 170, 322, 20);
		card4.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblMeetingDate = new JLabel("Meeting date");
		lblMeetingDate.setBounds(10, 211, 70, 14);
		card4.add(lblMeetingDate);
		
		textField_13 = new JTextField();
		textField_13.setBounds(159, 208, 322, 20);
		card4.add(textField_13);
		textField_13.setColumns(10);
		
		JLabel lblCircumstance = new JLabel("Circumstance");
		lblCircumstance.setBounds(10, 249, 70, 14);
		card4.add(lblCircumstance);
		
		JLabel lblOtherInfo = new JLabel("Other Info");
		lblOtherInfo.setBounds(10, 298, 70, 14);
		card4.add(lblOtherInfo);
		
		JButton btnCreate_2 = new JButton("CREATE");
		btnCreate_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String name,Long mobileNo, String email,String date, String place, String circumstances,String otherUsefulInfo
				try {
					contcs.appendaq(new CasualAcquaintance(textField_9.getText(),Long.parseLong(textField_10.getText()),textField_11.getText(),textField_13.getText(),textField_12.getText(),textArea_2.getText(),textArea_3.getText()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 JOptionPane.showMessageDialog(null,"Acquaintance Added","Added",JOptionPane.PLAIN_MESSAGE);
			card4.setVisible(false);	
			textField_9.setText(null);
			textField_10.setText(null);
			textField_11.setText(null);
			textField_12.setText(null);
			textField_13.setText(null);
			textArea_2.setText(null);
			textArea_3.setText(null);
			}
		});
		btnCreate_2.setBounds(256, 374, 89, 23);
		card4.add(btnCreate_2);
		
		//TextArea textArea_2 = new TextArea();
		textArea_2.setBounds(159, 248, 322, 44);
		card4.add(textArea_2);
		
		//TextArea textArea_3 = new TextArea();
		textArea_3.setBounds(159, 303, 332, 51);
		card4.add(textArea_3);
		card3.setLayout(null);
		
		JLabel lblPersonalFriendsDetails = new JLabel("Personal Friends details");
		lblPersonalFriendsDetails.setBounds(49, 30, 227, 14);
		card3.add(lblPersonalFriendsDetails);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(25, 65, 46, 14);
		card3.add(lblName_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(100, 62, 309, 20);
		card3.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblMobileNo_1 = new JLabel("Mobile no");
		lblMobileNo_1.setBounds(25, 107, 81, 14);
		card3.add(lblMobileNo_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(128, 104, 281, 20);
		card3.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(25, 153, 46, 14);
		card3.add(lblNewLabel);
		
		textField_7 = new JTextField();
		textField_7.setBounds(100, 150, 309, 20);
		card3.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblContext = new JLabel("Context");
		lblContext.setBounds(25, 202, 46, 14);
		card3.add(lblContext);
		
		JLabel lblAcquaintanceDate = new JLabel("Acquaintance dt(dd-mm-yyyy)");
		lblAcquaintanceDate.setBounds(24, 262, 215, 14);
		card3.add(lblAcquaintanceDate);
		
		textField_8 = new JTextField();
		textField_8.setBounds(274, 259, 244, 20);
		card3.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblSpecificEvents = new JLabel("Specific Events");
		lblSpecificEvents.setBounds(25, 320, 81, 20);
		card3.add(lblSpecificEvents);
		
		JButton btnCreate_1 = new JButton("CREATE");
		btnCreate_1.addActionListener(new ActionListener() {
			//String name,String email,String specificEvents,String context,String acquaintanceDate,Long mobno
			public void actionPerformed(ActionEvent e) {
				
			    try {
					contcs.appendaq(new PersonalFriends(textField_5.getText(),textField_7.getText(),textArea_1.getText(),textArea.getText(),textField_8.getText(),Long.parseLong(textField_6.getText())));
				} catch (AcquaintancefoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Created","Added",JOptionPane.PLAIN_MESSAGE);
				card3.setVisible(false);
				textField_5.setText(null);
				textField_7.setText(null);
				textArea_1.setText(null);
				textField_8.setText(null);
				textField_6.setText(null);
			}
		});
		btnCreate_1.setBounds(263, 374, 89, 23);
		card3.add(btnCreate_1);
		
		//TextArea textArea = new TextArea();
		textArea.setBounds(138, 186, 380, 45);
		card3.add(textArea);
		
		//TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(159, 309, 380, 53);
		card3.add(textArea_1);
		card2.setLayout(null);
		
		JLabel lblRelativesDetails = new JLabel("Relatives details");
		lblRelativesDetails.setBounds(50, 23, 133, 14);
		card2.add(lblRelativesDetails);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(57, 65, 46, 14);
		card2.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(246, 62, 272, 20);
		card2.add(textField);
		textField.setColumns(10);
		
		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setBounds(35, 134, 68, 14);
		card2.add(lblMobileNo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(246, 131, 272, 20);
		card2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(57, 184, 46, 14);
		card2.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(246, 181, 272, 20);
		card2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblBirthdayddmmyyyy = new JLabel("Birthday(dd-mm-yyyy)");
		lblBirthdayddmmyyyy.setBounds(26, 248, 173, 14);
		card2.add(lblBirthdayddmmyyyy);
		
		textField_3 = new JTextField();
		textField_3.setBounds(246, 245, 272, 20);
		card2.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblLastMeetingDate = new JLabel("Last meeting date");
		lblLastMeetingDate.setBounds(29, 304, 154, 14);
		card2.add(lblLastMeetingDate);
		
		textField_4 = new JTextField();
		textField_4.setBounds(246, 301, 272, 20);
		card2.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Relative r=new Relative(textField.getText(),Long.parseLong(textField_1.getText()),textField_2.getText(),textField_3.getText(),textField_4.getText());
                try {
                	System.out.println((contcs==null) + " "+ r.name1+" " +r.email1+" " +r.mobno1+" " +r.bDay+" " +r.lastMeetingDate);
					contcs.
					appendaq(r);
				} catch (AcquaintancefoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                JOptionPane.showMessageDialog(null,"Created","Added",JOptionPane.PLAIN_MESSAGE);
                
                card2.setVisible(false);
                textField.setText(null);
                textField_1.setText(null);
                textField_2.setText(null);
                textField_3.setText(null);
                textField_4.setText(null);
			}
				
		});
		btnCreate.setBounds(271, 374, 89, 23);
		card2.add(btnCreate);
		
		card1.setLayout(null);
		
		JButton btnRelative = new JButton("Relative");
		btnRelative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cL.show(frame.getContentPane(),"For accepting details of acquaintance");
			}
		});
		btnRelative.setBounds(215, 66, 159, 23);
		card1.add(btnRelative);
		
		JButton btnPersonalFriends = new JButton("Personal friends");
		btnPersonalFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cL.show(frame.getContentPane(),"For accepting a personal friend");
			}
		});
		btnPersonalFriends.setBounds(215, 128, 159, 23);
		card1.add(btnPersonalFriends);
		
		JButton btnProfessionalFriends = new JButton("Professional Friends");
		btnProfessionalFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cL.show(frame.getContentPane(),"For accepting details of professional friend");
			}
		});
		btnProfessionalFriends.setBounds(215, 209, 159, 23);
		card1.add(btnProfessionalFriends);
		
		JButton btnCasualAcquaintance = new JButton("Casual Acquaintance");
		btnCasualAcquaintance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cL.show(frame.getContentPane(),"For accepting details of a casual acquaintance");
			}
		});
		btnCasualAcquaintance.setBounds(215, 299, 159, 23);
		card1.add(btnCasualAcquaintance);
		
		JLabel lblSelectTheType = new JLabel("Select the type of acquaintance to create");
		lblSelectTheType.setBounds(165, 11, 270, 31);
		card1.add(lblSelectTheType);
	}
	public void destroy()
	{
		if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(new JFrame(), "Save Data?", null, JOptionPane.YES_NO_OPTION)) {
            try {
            SaveData.save(contcs, "cList");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), null, JOptionPane.WARNING_MESSAGE);
            }
        }
        System.exit(0);
	}
}
