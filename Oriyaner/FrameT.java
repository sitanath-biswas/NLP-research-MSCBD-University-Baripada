import java.awt.*;
import javax.swing.*;
import javax.swing.JFileChooser;
import java.awt.event.*;
import java.io.*;
import java.awt.color.*;
import java.awt.geom.*;
import javax.swing.text.*;
//import java.awt.image.BufferedImage;



public class FrameT implements ActionListener
{
	 private static class TestHighlightPainter extends DefaultHighlighter.DefaultHighlightPainter
	 {
	        public TestHighlightPainter()
	        {
	            super(Color.yellow);
	        }
	        public Shape paintLayer(Graphics gc, int offs0, int offs1,Shape bounds, JTextComponent c, View view)
	        {
	        	try
	        	{
	                Graphics2D g = (Graphics2D) gc;
	                Shape shape = view.modelToView(offs0, Position.Bias.Forward,
	                                               offs1, Position.Bias.Backward,
	                                               bounds);
	                Rectangle r = (shape instanceof Rectangle) ?
	                                  (Rectangle) shape : shape.getBounds();
	                g.setColor(Color.RED);
	                g.fillRect(r.x, r.y + r.height-18, r.width, 12);
	                return r;
	            }
	            catch (Exception e) {
	                e.printStackTrace();
	                return null;
	            }
	        }
    	}//End of nested class
	 private static class TestHighlightPainter1 extends DefaultHighlighter.DefaultHighlightPainter
		 {
		        public TestHighlightPainter1()
		        {
		            super(Color.yellow);
		        }
		        public Shape paintLayer(Graphics gc, int offs0, int offs1,Shape bounds, JTextComponent c, View view)
		        {
		        	try
		        	{
		                Graphics2D g = (Graphics2D) gc;
		                Shape shape = view.modelToView(offs0, Position.Bias.Forward,
		                                               offs1, Position.Bias.Backward,
		                                               bounds);
		                Rectangle r = (shape instanceof Rectangle) ?
		                                  (Rectangle) shape : shape.getBounds();
		                g.setColor(Color.magenta);
		                g.fillRect(r.x, r.y + r.height-18, r.width, 12);
		                return r;
		            }
		            catch (Exception e) {
		                e.printStackTrace();
		                return null;
		            }
		        }
    	}//End of nested class_2


	JFrame f;
	JPanel p;
	JButton b,namecolor,placecolor,recogcolor;
	JLabel l1,l2,label3;
	JTextArea t1;
	JScrollPane scrollPane;

	JMenuBar mb;
	JMenu file,edit,search;
	JMenuItem New,open,save,saveas,exit,copy,cut,paste,selectall;
	JMenuItem name1,place1,recog1,DefaultText;
	JButton name,place,recog,clear;
	//JScrollPane jsp;
	//int scroll=JTextArea.SCROLLBAR_BOTH;
	Font font1=new Font("Arial",Font.BOLD,20);
	Font font2=new Font("Arial",Font.BOLD,14);
	Font font3=new Font("utkal",Font.BOLD,14);
	//int x11=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	//int y11=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	String s3;
	String val,val2;
	String directory;
	public FrameT()
	{


		val="i live in jajpur\n prabhat pai  ";
		//val2="";

		f=new JFrame("Oriya Name Entity Recogniser");

		l1=new JLabel("Oriya Name Entity Recogniser");

		namecolor=new JButton("N");
		placecolor=new JButton("L");
		recogcolor=new JButton("O");
		l1.setForeground(Color.red);
		l1.setBackground(Color.yellow);

		l2=new JLabel("------------------------------------------------------------------------");
		l2.setBackground(Color.blue);


		t1=new JTextArea(25,80);
		scrollPane=new JScrollPane(t1);


		p=new JPanel();
		//jsp=new JScrollPane(p,x11,y11);
		name=new JButton("   NAME   ");
		place=new JButton("LOCATION");
		recog=new JButton("ORGANISATION");
		clear=new JButton("Clear");

	//	p.setLayout(null);

		p.setForeground(Color.blue);

		l1.setFont(font1);

		name.setFont(font2);
		place.setFont(font2);
		recog.setFont(font2);
		clear.setFont(font2);

		l1.setBounds(300,30,400,30);
		l2.setBounds(300,50,600,20);
		//l3.setBounds(30,80,400,20);
		scrollPane.setBounds(10,80,560,450);
		//l4.setBounds(540,100,220,30);
		name.setBounds(670,130,120,30);
		place.setBounds(670,180,120,30);
		recog.setBounds(670,230,120,30);
		clear.setBounds(670,280,80,30);
		namecolor.setBounds(650,130,20,30);
		placecolor.setBounds(650,180,20,30);
		recogcolor.setBounds(650,230,20,30);

		//Manipulation of menubar
		mb=new JMenuBar();
		file=new JMenu("File");
		edit=new JMenu("Edit");
		search=new JMenu("Search");

		New=new JMenuItem("New");
		open=new JMenuItem("Open");
		save=new JMenuItem("Save");
		saveas=new JMenuItem("Save As");
		exit=new JMenuItem("Exit");
		cut=new JMenuItem("Cut");
		copy=new JMenuItem("Copy");
		paste=new JMenuItem("Paste");
		selectall=new JMenuItem("SelectAll");
		name1=new JMenuItem("Name");
		place1=new JMenuItem("Place");
		recog1=new JMenuItem("Organisation");
		DefaultText=new JMenuItem("Default Text");


		file.add(New);
		file.addSeparator();
		file.add(open);
		file.add(save);
		file.add(saveas);
		file.addSeparator();
		file.add(exit);

		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.addSeparator();
		edit.add(selectall);

		search.add(DefaultText);
		search.addSeparator();
		search.add(name1);
		search.addSeparator();
		search.add(place1);
		search.addSeparator();
		search.add(recog1);


		mb.add(file);
		mb.add(edit);
		mb.add(search);



		p.add(l1);
		p.add(l2);
		//p.add(l3);

	//	p.add(t1);


		//p.add(l4);
		p.add(name);
		p.add(place);
		p.add(recog);
		p.add(namecolor);
		p.add(placecolor);
		p.add(recogcolor);
		p.add(clear);
		//f.add(jsp);

		p.add(scrollPane);
		f.setJMenuBar(mb);
		f.setContentPane(p);

		//f.add(p);

		name.addActionListener(this);
		place.addActionListener(this);
		recog.addActionListener(this);
		clear.addActionListener(this);
		New.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		saveas.addActionListener(this);
		exit.addActionListener(this);
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		selectall.addActionListener(this);
		name1.addActionListener(this);
		place1.addActionListener(this);
		recog1.addActionListener(this);
		DefaultText.addActionListener(this);

		f.setVisible(true);
		f.setSize(800,600);
		t1.setFont(font3);
		//t1.setForeground(Color.black);
		p.setBackground(Color.lightGray);
		namecolor.setBackground(Color.magenta);
		placecolor.setBackground(Color.red);
		recogcolor.setBackground(Color.green);
	}
 String TEMPFILE = "CUTPASTE.TMP";

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource().equals(name))
		{
			try
			{
					findname();
			}
			catch(IOException as){}


		}
		if(ae.getSource().equals(place))
		{
			try
			{
				show();
			}
			catch(IOException as){}

		}
		if(ae.getSource().equals(recog))
		{

		}
		if(ae.getSource().equals(clear))
		{
			t1.setText(null);
		}
		if(ae.getSource().equals(New))
		{
			t1.setText(null);
		}
		if(ae.getSource().equals(open))
		{
			 FileDialog f1 = new FileDialog(f, "Open File");
			 f1.setDirectory(directory);       // Set the default directory
				// Display the dialog and wait for the user's response
			  f1.show();

			  directory = f1.getDirectory();    // Remember new default directory
			  setFile(directory, f1.getFile()); // Load and display selection
			  f1.dispose();                     // Get rid of the dialog box
		}

		if(ae.getSource().equals(save))
		{
			FileDialog file = new FileDialog (f, "Save File", FileDialog.SAVE);
			    file.show(); // Blocks
			    String curFile;
			    if ((curFile = file.getFile()) != null)
			    {
			      	String filename = file.getDirectory() + curFile;
			      	//setCursor (Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			      	File f = new File (filename);
			      	try
			      	{
			      		  FileWriter fw = new FileWriter (f);
			      		  String text = t1.getText();
			      		  int textsize = text.length();
			      		  fw.write (t1.getText(), 0, textsize);
			      		  fw.close ();
			      		  //statusInfo.setText ("Saved: " + filename);
			      	}
			      	catch (IOException exc)
			      	{
			      		  //statusInfo.setText ("IOException: " + filename);
			      	}
			      	//setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    			}
		}
		if(ae.getSource().equals(saveas))
		{
			FileDialog file = new FileDialog (f, "Save File", FileDialog.SAVE);
						    file.show(); // Blocks
						    String curFile;
						    if ((curFile = file.getFile()) != null)
						    {
						      	String filename = file.getDirectory() + curFile;
						      	//setCursor (Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
						      	File f = new File (filename);
						      	try
						      	{
						      		  FileWriter fw = new FileWriter (f);
						      		  String text = t1.getText();
						      		  int textsize = text.length();
						      		  fw.write (t1.getText(), 0, textsize);
						      		  fw.close ();
						      		  //statusInfo.setText ("Saved: " + filename);
						      	}
						      	catch (IOException exc)
						      	{
						      		  //statusInfo.setText ("IOException: " + filename);
						      	}
						      	//setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    			}
		}
		if(ae.getSource().equals(exit))
		{
			System.exit(0);
		}
		if(ae.getSource().equals(cut))
		{
			try {
			        if (t1.getSelectedText() != null) {
			          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new
			              FileOutputStream(TEMPFILE), "UTF-16"));
			          bw.write(t1.getSelectedText());
			          bw.close();
			          t1.replaceSelection("");
			        }
			      }
			      catch (Exception e)
			      {
			      	  e.printStackTrace();
      			  }
		}

		if(ae.getSource().equals(copy))
		{
			try {
						        if (t1.getSelectedText() != null) {
						          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new
						              FileOutputStream(TEMPFILE), "UTF-16"));
						          bw.write(t1.getSelectedText());
						          bw.close();
						          //t1.replaceSelection("");
						    	}
				}
				catch (Exception e)
				{
					   	e.printStackTrace();
      			 }
		}
		if(ae.getSource().equals(paste))
		{
			try {
			        BufferedReader br = new BufferedReader(new InputStreamReader(new
			            FileInputStream(TEMPFILE), "UTF-16"));
			        StringBuffer text = new StringBuffer();
			        String tempString;
			        while ((tempString = br.readLine()) != null) {
			          text.append(tempString);
			        }
			        br.close();
			        t1.replaceSelection(text.toString());
			      }
			      catch (Exception e)
			      {}
		}
		if(ae.getSource().equals(selectall))
		{
			t1.select(0,t1.getText().length());
		}
		if(ae.getSource().equals(name1))
		{
			try
			{
				findname();
			}
			catch(IOException as){}
		}
		if(ae.getSource().equals(DefaultText))
		{
			t1.setText(val);

		}
		if(ae.getSource().equals(place1))
		{
			try
			{
				show();
			}
			catch(IOException as){}

		}
		if(ae.getSource().equals(recog1))
		{

		}

	}
	public void setFile(String directory, String filename)
		{

		        if ((filename == null) || (filename.length() == 0)) return;
		       	File f;
		        //FileReader in = null;
		        BufferedReader in =null;

		        // Read and display the file contents.

					try {
		            f = new File(directory, filename);
		            //in = new FileReader(f);
		            in=new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-16"));
		            char[] buffer = new char[4096];    // Read 4K characters at a time
		            int len;                           // How many chars read each time
		            t1.setText("");
		            while((len = in.read(buffer)) != -1) { // Read a batch of chars
		            String s = new String(buffer, 0, len); // Convert to a string
		             t1.append(s);                    // And display them
		            }
		            //this.setTitle("FileViewer: " + filename);
		            t1.setCaretPosition(0);              // Go to start of file
		        }
		        // Display messages if something goes wrong
		        catch (IOException e) {
		            t1.setText(e.getClass().getName() + ": " + e.getMessage());

		        }
		        // Always be sure to close the input stream!
		        finally { try { if (in!=null) in.close(); } catch (IOException e) {} }
    }

	public static void main(String ar[]) throws IOException
	{
		new FrameT();
	}


	void show() throws IOException
	{
		InputStreamReader stdin=new InputStreamReader(System.in);
		BufferedReader console=new BufferedReader(stdin);
		char testinput=' ';
		int ft[]=new int[1000];
		int lt[]=new int[1000];
		String s7;
		//converting textArea string to string array
		int len=t1.getText().length();
		int k;

			/*StringBuilder sb = new StringBuilder();

			    String str1 = t1.getText();
			    System.out.println("TEXT1 :"+str1);
			    byte[] utfBytes = str1.getBytes("UTF-16");
			    for(int i=0;i<utfBytes.length;i++)
				System.out.println("TEXT2 :"+utfBytes[i]);*/
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(TEMPFILE), "UTF-16"));
										          bw.write(t1.getText());
										          bw.close();

				BufferedReader br123 = new BufferedReader(new InputStreamReader(new FileInputStream(TEMPFILE), "UTF-16"));
							        StringBuffer text = new StringBuffer();
							        String tempString;
							        while ((tempString = br123.readLine()) != null) {
							          text.append(tempString);
							        }
			        br123.close();
			//System.out.println("Via Buffer Object :"+text);
    			//String s4 = new String(utfBytes, "ISO-8859-1");
		String s44=text.toString();
		String s4=s44.trim();

		//String s4=t1.getText();
		//System.out.println("unicode TEXT :"+s4);
		//char c1[]=new char[len];
		char c1[]=s4.toCharArray();
		int count=0;
		for(k=0;k<s4.length();k++)
		{
			//System.out.println("Character :"+c1[k]);
			if(Character.isWhitespace(c1[k])||c1[k]=='\n'||c1[k]=='\r'||c1[k]=='\u0964')
			{
				//System.out.println("i am letter of digit "+k);
				count++;
			}
			else
			{

			}
		}

		int slength=count+1;
		//System.out.println("Total String is :"+slength);
		String s5[]=new String[slength];
		int j=0;
		s5[j]="";

		for(k=0;k<s4.length();k++)
		{
			if(Character.isWhitespace(c1[k])||c1[k]=='\n'||c1[k]=='\r'||c1[k]=='\u0964')
			{
				j++;
				s5[j]="";
			}
			else   //Must be a newline
			{

				s5[j]=s5[j]+""+c1[k];
			}
		}
		//for(int i=0;i<s5.length;i++)
		//System.out.println("words :"+s5[i]);
		//converting file text to string array
		int i=0;

		//Location file conversion

		//FileReader fr=new FileReader("location.txt");
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("location.txt"), "UTF-16"));
		String sread[]=new String[100000];//suppose 100000 name are there
		while((sread[i]=br.readLine())!=null)
		{
			i++;
		}
		j=0;

		//Dictionary file conversion

		//FileReader fr1=new FileReader("oriyaDictionary.txt");
		BufferedReader br1=new BufferedReader(new InputStreamReader(new FileInputStream("oriyaDictionary2.txt"), "UTF-16"));
		String sread1[]=new String[100000];//suppose 100000 name are there
		while((sread1[j]=br1.readLine())!=null)
		{
			//System.out.println("\n"+sread1[j]);
					j++;
		}

		//for seacrhing and selecting a part of string
		int p=0;
		int arr=0;
		boolean bool;

		String jibi=""+'\u0B2F'+'\u0B3F'+'\u0B2C'+'\u0B3F';
		String jauthili=""+'\u0B2F'+'\u0B3E'+'\u0B09'+'\u0B25'+'\u0B3F'+'\u0B32'+'\u0B3F';
		String jauchi=""+'\u0B2F'+'\u0B3E'+'\u0B09'+'\u0B1B'+'\u0B3F';
		String ru=""+'\u0B30'+'\u0B41';
		String ra=""+'\u0B30';
		String re=""+'\u0B30'+'\u0B47';

		//System.out.println("This is jibi :"+jibi);
		//System.out.println("This is ru :"+stru);
		//System.out.println("Here :????");
		//t1.setText(stuni);		//CHECKING FOR A PRARTICULAR WORD jibi jaithili and jauchi

			//System.out.println("\nfile content :"+sread[p]+"\n");
			for(j=0;j<(slength);j++)
			{
				//System.out.print(s5[j]+"\t");
				try
				{
					//if(s5[j].trim().equalsIgnoreCase(jibi)||s5[j].trim().equalsIgnoreCase(jauthili)||s5[j].trim().equalsIgnoreCase(jauchi)||s5[j].trim().equalsIgnoreCase(ru)||s5[j].trim().equalsIgnoreCase(ra)||s5[j].trim().equalsIgnoreCase(re))
					if(s5[j].trim().equals(jibi)||s5[j].trim().equals(jauthili)||s5[j].trim().equals(jauchi)||s5[j].trim().equals(ru)||s5[j].trim().equals(ra)||s5[j].trim().equals(re))

					{
						j--;
						//System.out.println("\nMatch :"+s5[j]);
						p=0;
						bool=true;
						while(sread1[p]!=null)
						{


							if(s5[j].trim().equalsIgnoreCase(sread1[p].trim()))
							{
								//System.out.println("FIND INSIDE FILE :"+s5[j]);
								bool=false;
							}
							p++;
						}//end of while loop
						if(bool)
						{
							//System.out.println("file  :"+sread1[p]);
							s7=s5[j];
							ft[arr]=s4.indexOf(s7);
							int lt2=s7.length();
							lt[arr]=ft[arr]+lt2;
							//t1.select(ft[arr],(lt[arr]));
							try
							{
								t1.getHighlighter().addHighlight(ft[arr],lt[arr], new TestHighlightPainter());
							}
							catch(Exception aer){}
							arr++;
						}
						j++;

					}
				}//end of try
				catch(ArrayIndexOutOfBoundsException aeere){}
				//catch(NullPointerException aerere){}

				}//end of for loop

		//}//end of while loop
		//CHECKING FOR A WORD IN FILE for location in location text file
		p=0;
		arr=0;
		while(sread[p]!=null)
		{
			for(j=0;j<slength;j++)
			{
				try
				{
				if(s5[j].trim().equalsIgnoreCase(sread[p].trim()))
				{
					s7=s5[j];
					ft[arr]=s4.indexOf(s7);
					int lt2=s7.length();
					lt[arr]=ft[arr]+lt2;
					//t1.select(ft[arr],(lt[arr]));
					try
					{
						t1.getHighlighter().addHighlight(ft[arr],lt[arr], new TestHighlightPainter());
					}
					catch(Exception aer){}
					//t1.setBackground(Color.yellow);
					arr++;

				}
				else
				{


				}
				}
				catch(ArrayIndexOutOfBoundsException aeere){}
				//catch(NullPointerException aerere){}

			}//end of for loop
			p++;

		}//end fo while loop
		//fr.close();
		//fr1.close();


		//CHECKING FOR RE RU AND
		boolean bool2=false;
			j=0;
			for(k=0;k<s4.length();k++)
			{
				//System.out.println("Character :"+c1[k]);
				if(c1[k]==' ')
				{
					j++;
					//System.out.println("String :"+s5[j]);
				}
				try
				{
				if(c1[k]=='\u0B30')//UNICODE FOR R
				{
					k++;
					if(c1[k]=='\u0B47'||c1[k]=='\u0B41')//UNICODE FOR RU  RE
					{
						k++;
						if(Character.isWhitespace(c1[k]))
						{
							p=0;
							bool2=true;
							while(sread1[p]!=null)
							{

									if(s5[j].trim().equalsIgnoreCase(sread1[p].trim()))
									{
										//System.out.println("FIND INSIDE FILE :"+s5[j]);
										bool2=false;
									}
									p++;
							}//end of while loop
							if(bool2)
							{
									//System.out.println("file  :"+sread1[p]);
									s7=s5[j];
									ft[arr]=s4.indexOf(s7);
									int lt2=s7.length();
									lt[arr]=ft[arr]+lt2;
									//t1.select(ft[arr],(lt[arr]));
									try
									{
											t1.getHighlighter().addHighlight(ft[arr],lt[arr], new TestHighlightPainter());
									}
									catch(Exception aer){}
									arr++;
							}
						}
						k--;
					}
					k--;
				}
				}
				catch(ArrayIndexOutOfBoundsException aere){}


			}
			br.close();
		br1.close();
		}//end of function show() location

	void findname() throws IOException
	{
		InputStreamReader stdin=new InputStreamReader(System.in);
				BufferedReader console=new BufferedReader(stdin);
				char testinput=' ';
				int ft[]=new int[1000];
				int lt[]=new int[1000];
				String s7;
				//converting textArea string to string array
				int len=t1.getText().length();
				int k;

					/*StringBuilder sb = new StringBuilder();

					    String str1 = t1.getText();
					    System.out.println("TEXT1 :"+str1);
					    byte[] utfBytes = str1.getBytes("UTF-16");
					    for(int i=0;i<utfBytes.length;i++)
						System.out.println("TEXT2 :"+utfBytes[i]);*/
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(TEMPFILE), "UTF-16"));
												          bw.write(t1.getText());
												          bw.close();

						BufferedReader br123 = new BufferedReader(new InputStreamReader(new FileInputStream(TEMPFILE), "UTF-16"));
									        StringBuffer text = new StringBuffer();
									        String tempString;
									        while ((tempString = br123.readLine()) != null) {
									          text.append(tempString);
									        }
					        br123.close();
					//System.out.println("Via Buffer Object :"+text);
		    			//String s4 = new String(utfBytes, "ISO-8859-1");
				String s44=text.toString();
				String s4=s44.trim();

				//String s4=t1.getText();
				//System.out.println("unicode TEXT :"+s4);
				//char c1[]=new char[len];
				char c1[]=s4.toCharArray();
				int count=0;
				for(k=0;k<s4.length();k++)
				{
					//System.out.println("Character :"+c1[k]);
					if(Character.isWhitespace(c1[k])||c1[k]=='\n'||c1[k]=='\r'||c1[k]=='\u0964')
					{
						//System.out.println("i am letter of digit "+k);
						count++;
					}
					else
					{

					}
				}

				int slength=count+1;
				//System.out.println("Total String is :"+slength);
				String s5[]=new String[slength];
				int j=0;
				s5[j]="";

				for(k=0;k<s4.length();k++)
				{
					if(Character.isWhitespace(c1[k])||c1[k]=='\n'||c1[k]=='\r'||c1[k]=='\u0964')
					{
						j++;
						s5[j]="";
					}
					else   //Must be a newline
					{

						s5[j]=s5[j]+""+c1[k];
					}
				}
				//for(int i=0;i<s5.length;i++)
				//System.out.println("words :"+s5[i]);
				//converting file text to string array
				int i=0;

				//Location file conversion

				//FileReader fr=new FileReader("location.txt");
				BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("location.txt"), "UTF-16"));
				String sread[]=new String[100000];//suppose 100000 name are there
				while((sread[i]=br.readLine())!=null)
				{
					i++;
				}
				j=0;

				//Dictionary file conversion

				//FileReader fr1=new FileReader("oriyaDictionary.txt");
				BufferedReader br1=new BufferedReader(new InputStreamReader(new FileInputStream("oriyaDictionary2.txt"), "UTF-16"));
				String sread1[]=new String[100000];//suppose 100000 name are there
				while((sread1[j]=br1.readLine())!=null)
				{
					//System.out.println("\n"+sread1[j]);
							j++;
				}

		//for seacrhing and selecting a part of string
		int p=0;
		int arr=0;
		boolean bool=false;
		boolean bool2=false;
		//CHECKING FOR A PRARTICULAR WORD pai,tharu dwara,pakhare,pakhaku,bina
		String pai=""+'\u0B2A'+'\u0B3E'+'\u0B07'+'\u0B01';
		String pakhre=""+'\u0B2A'+'\u0B3E'+'\u0B16'+'\u0B30'+'\u0B47';
		String dwara=""+'\u0B26'+'\u0B4D'+'\u0B2C'+'\u0B3E'+'\u0B30'+'\u0B3E';
		String pakhaku=""+'\u0B2A'+'\u0B3E'+'\u0B16'+'\u0B15'+'\u0B41';
		String bina=""+'\u0B2C'+'\u0B3F'+'\u0B28'+'\u0B3E';
		String tharu=""+'\u0B20'+'\u0B3E'+'\u0B30'+'\u0B41';

		for(j=0;j<slength;j++)
		{
			//System.out.print("\t"+s5[j]);
			try
			{
				if(s5[j].trim().equalsIgnoreCase(pai)||s5[j].trim().equalsIgnoreCase(pakhre)||s5[j].trim().equalsIgnoreCase(dwara)||s5[j].trim().equalsIgnoreCase(pakhaku)||s5[j].trim().equalsIgnoreCase(bina)||s5[j].trim().equalsIgnoreCase(tharu))
				{
					j--;
											//System.out.println("\nMatch :"+s5[j]);
											p=0;
											bool=true;
											while(sread1[p]!=null)
											{


												if(s5[j].trim().equalsIgnoreCase(sread1[p].trim()))
												{
													//System.out.println("FIND INSIDE FILE :"+s5[j]);
													bool=false;
												}
												p++;
											}//end of while loop
											if(bool)
											{
												//System.out.println("file  :"+sread1[p]);
												s7=s5[j];
												ft[arr]=s4.indexOf(s7);
												int lt2=s7.length();
												lt[arr]=ft[arr]+lt2;
												//t1.select(ft[arr],(lt[arr]));
												try
												{
													t1.getHighlighter().addHighlight(ft[arr],lt[arr], new TestHighlightPainter1());
												}
												catch(Exception aer){}
												arr++;
											}
											bool=false;
						j++;
				}
			}//end of try
			catch(ArrayIndexOutOfBoundsException aeere){}
			//catch(NullPointerException asereree){}
		}//end of for loop
		bool=false;
		//CHECKING FOR KU and RA

			j=0;
			for(k=0;k<s4.length();k++)
			{
				String s8="";
				//System.out.println("Character :"+c1[k]);
				if(c1[k]==' ')
				{
					j++;
					//System.out.println("String :"+s5[j]);
				}
				try
				{
				if(c1[k]=='\u0B16')//UNICODE FOR K
				{
					k++;
					if(c1[k]=='\u0B41')//UNICODE FRO U
					{
						k++;
						if(Character.isWhitespace(c1[k]))
						{
							s7=s5[j];
							ft[arr]=s4.indexOf(s7);
							int lt2=s7.length();
							lt[arr]=ft[arr]+lt2;
							//t1.select(ft[arr],(lt[arr]));
							try
							{
								t1.getHighlighter().addHighlight(ft[arr],lt[arr], new TestHighlightPainter1());
							}
							catch(Exception aer){}
							//cheking for the previous word
							p=0;
							bool=true;
							while(sread1[p]!=null)
							{
								--j;
								if(s5[j].trim().equalsIgnoreCase(sread1[p].trim()))
								{
									//System.out.println("FIND INSIDE FILE :"+s5[j]);
									bool=false;
								}
								p++;
								j++;
							}//end of while loop
							if(bool)
							{
								--j;
								s8=s5[j];
								ft[arr]=s4.indexOf(s8);
								lt2=s8.length();
								lt[arr]=ft[arr]+lt2;
								//t1.select(ft[arr],(lt[arr]));
								try
								{
									t1.getHighlighter().addHighlight(ft[arr],lt[arr], new TestHighlightPainter1());
								}
								catch(Exception aer){}
								j++;
							}
							j++;

						}
						k--;
					}
					k--;
				}//end of if block
				if(c1[k]=='r')
				{
					k++;
					if(c1[k]=='a')
					{
						k++;
						if(Character.isWhitespace(c1[k]))
						{

								p=0;
															bool2=true;
															while(sread1[p]!=null)
															{

																	if(s5[j].trim().equalsIgnoreCase(sread1[p].trim()))
																	{
																		//System.out.println("FIND INSIDE FILE :"+s5[j]);
																		bool2=false;
																	}
																	p++;
															}//end of while loop
															if(bool2)
															{
																	//System.out.println("file  :"+sread1[p]);
																	s7=s5[j];
																	ft[arr]=s4.indexOf(s7);
																	int lt2=s7.length();
																	lt[arr]=ft[arr]+lt2;
																	//t1.select(ft[arr],(lt[arr]));
																	try
																	{
																			t1.getHighlighter().addHighlight(ft[arr],lt[arr], new TestHighlightPainter1());
																	}
																	catch(Exception aer){}
															}
									arr++;
						}
						k--;
					}
					k--;
				}//end of if block
				}//end of try block
				catch(ArrayIndexOutOfBoundsException aere){}


			}//end of for loop
			br1.close();
	}//end of funnction findname()
}//end of class FrameT
