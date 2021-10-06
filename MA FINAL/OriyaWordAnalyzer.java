                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class OriyaWordAnalyzer implements ActionListener
{
	 JFrame frame;
 	 JPanel panel1,panel2,panel3,panel4;
	 JTextArea textarea1,textarea2;
	 JScrollPane scrollpane1,scrollpane2;
	 JButton button_identify1,button_identify2;
	 JLabel label1,label2,label3,label4,label5,label6;
	 JMenuBar mb;
	 JMenu file,edit,search;
	 JMenuItem New,open,save,saveas,exit,copy,cut,paste,selectall;
	 JMenuItem DefaultText;
	String directory,s3;
	String val="Enter your String.\ncheck parsing.";
	Font font1=new Font("ArialBlack",Font.BOLD,20);
	Font font3=new Font("utkal",Font.BOLD,14);

	OriyaWordAnalyzer()
	{
		//All objects are initialized here
		frame=new JFrame("Oriya Morphological Analyzer");
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();
		textarea1=new JTextArea(23,35);
		textarea2=new JTextArea(23,35);
		scrollpane1=new JScrollPane(textarea1);
		scrollpane2=new JScrollPane(textarea2);
		button_identify1=new JButton("   Run   ");
		button_identify2=new JButton("Oriya Morphological Analyzer");
		label1=new JLabel("INPUT SCREEN        ");
		label2=new JLabel("");
		label3=new JLabel("                               Root	       Suffix   OUTPUT SCREEN     ");
		label4=new JLabel("");


		//font setting
		label1.setFont(font1);
		label2.setFont(font1);
		label3.setFont(font1);
		label4.setFont(font1);
		label1.setForeground(Color.blue);
		label2.setForeground(Color.orange);
		label3.setForeground(Color.blue);
		label4.setForeground(Color.orange);

		textarea2.setForeground(Color.blue);
		//All menubar component
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


				mb.add(file);
				mb.add(edit);
				mb.add(search);
			panel1.setBackground(Color.gray);


		//All component are added here
		panel1.add(scrollpane1);
		panel2.add(button_identify1);
		//panel.add(button_identify2);

		panel1.add(scrollpane2);
		panel3.add(label1);
		panel4.add(label2);
		panel3.add(label3);
		panel2.add(label4);
		frame.add(panel1,BorderLayout.CENTER);
		frame.add(panel2,BorderLayout.SOUTH);
		frame.add(panel3,BorderLayout.NORTH);

		//All listerner are initialized here
		button_identify1.addActionListener(this);
		button_identify2.addActionListener(this);

		New.addActionListener(this);
				open.addActionListener(this);
				save.addActionListener(this);
				saveas.addActionListener(this);
				exit.addActionListener(this);
				cut.addActionListener(this);
				copy.addActionListener(this);
				paste.addActionListener(this);
				selectall.addActionListener(this);

		DefaultText.addActionListener(this);
		textarea1.setFont(font3);
		textarea2.setFont(font3);
		frame.setJMenuBar(mb);
		frame.setSize(400,400);
		frame.setVisible(true);

	}
	String TEMPFILE = "CUTPASTE.TMP";
	public void actionPerformed(ActionEvent ae)
	{

		if(ae.getSource().equals(button_identify1))
		{
				try
				{
					firstButton();
				}
				catch(IOException ioe){System.out.println("Exception 0");}

		}//end of if
		//menubar manipulation
		if(ae.getSource().equals(New))
		{
					textarea1.setText(null);
		}
		if(ae.getSource().equals(open))
		{
					 FileDialog f1 = new FileDialog(frame, "Open File");
					 f1.setDirectory(directory);       // Set the default directory
						// Display the dialog and wait for the user's response
					  f1.show();

					  directory = f1.getDirectory();    // Remember new default directory
					  setFile(directory, f1.getFile()); // Load and display selection
					  f1.dispose();                     // Get rid of the dialog box
		}

		if(ae.getSource().equals(save))
		{
					FileDialog file = new FileDialog (frame, "Save File", FileDialog.SAVE);
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
					      		  String text = textarea1.getText();
					      		  int textsize = text.length();
					      		  fw.write (textarea1.getText(), 0, textsize);
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
					FileDialog file = new FileDialog (frame, "Save File", FileDialog.SAVE);
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
								      		  String text = textarea1.getText();
								      		  int textsize = text.length();
								      		  fw.write (textarea1.getText(), 0, textsize);
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
								        if (textarea1.getSelectedText() != null) {
								          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new
								              FileOutputStream(TEMPFILE), "UTF-16"));
								          bw.write(textarea1.getSelectedText());
								          bw.close();
								          textarea1.replaceSelection("");
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
											        if (textarea1.getSelectedText() != null) {
											          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new
											              FileOutputStream(TEMPFILE), "UTF-16"));
											          bw.write(textarea1.getSelectedText());
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
								        textarea1.replaceSelection(text.toString());
								      }
								      catch (Exception e)
			      {}
				}
				if(ae.getSource().equals(selectall))
				{
					textarea1.select(0,textarea1.getText().length());
				}

				if(ae.getSource().equals(DefaultText))
				{
					textarea1.setText("Enter a string.");

				}

	}//end of actionPerformed() method

	public void setFile(String directory, String filename)//This method is used to open a unicode file
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
			            textarea1.setText("");
			            while((len = in.read(buffer)) != -1) { // Read a batch of chars
			            String s = new String(buffer, 0, len); // Convert to a string
			             textarea1.append(s);                    // And display them
			            }
			            //this.setTitle("FileViewer: " + filename);
			            textarea1.setCaretPosition(0);              // Go to start of file
			        }
			        // Display messages if something goes wrong
			        catch (IOException e) {
			            textarea1.setText(e.getClass().getName() + ": " + e.getMessage());

			        }
			        // Always be sure to close the input stream!
			        finally { try { if (in!=null) in.close(); } catch (IOException e) {} }
	    }

	public static void main(String arg[])//This is main method
	{
		new OriyaWordAnalyzer();
	}
	public void firstButton()throws IOException//This method handle all the necessary operation
	{
			String totalstring;
			int countstring=0;
			int j=0;
			String s4="";
			//textarea2.setText(null);
			totalstring=textarea1.getText();
			int len=totalstring.length();

			try
			{
				s4=createString(totalstring);//call method to create a linear string
			}
			catch(IOException ae){}
			//System.out.println("UNICODE STRING :"+s4);
			int lenstr=s4.length();

			countstring=countString(s4);//call countString to count total number 0f string
			//System.out.println("Total String is :"+countstring);
			String substring[]=new String[countstring];

			substring=subString(s4,lenstr);//call substring method to create array of string
			//for(int i=0;i<countstring;i++)
			//System.out.println("word"+substring[i]);

			//String notmatchstring[]=new String[10000];
			//notmatchstring=matchDictionary(substring);
			//for(int i=0;i!=null;i++)

			//OPERATION FOR STRING NOT MATCHED IN DICTIONARY
			int countnotmatch=0;
			try
			{
				countnotmatch=notMatchCount(substring,countstring);//call notMatchCount method to count not match string
			}
			catch(IOException as){System.out.println("Exception 1:");}
			//System.out.println("Not match :"+countnotmatch);
			String notmatchstring[]=new String[countnotmatch];
			try
			{
					notmatchstring=notMatchString(substring,countstring,countnotmatch);//call notMatchString method to count not match string
			}
			catch(IOException as){System.out.println("Exception 2:");}
			//for(int i=0;i<countnotmatch;i++)
			//System.out.println("Not Match :"+notmatchstring[i]);

			try
			{
					writeNotMatchString(notmatchstring,countnotmatch);//call writeString method to write not match string to file "NotMatch.txt"
			}
			catch(IOException as){System.out.println("Exception 3:");}

			//OPERATION FOR STRING MATCHED IN DICTIONARY
			int countmatch=0;
			try
			{
					countmatch=matchCount(substring,countstring);//call matchCount method to count match string
			}
			catch(IOException as){System.out.println("Exception 4:");}
			//System.out.println("Total matched String:"+countmatch);
			String matchstring[]=new String[countmatch];
			try
			{
					matchstring=matchString(substring,countstring,countmatch);//call matchString method to count match string
			}
			catch(IOException as){System.out.println("Exception 5:");}
			//for(int i=0;i<countmatch;i++)
			//System.out.println("Matched:"+matchstring[i]);
			try
			{
					writeMatchString(matchstring,countmatch);//call writeString method to write match string to file "Match.txt"
			}
			catch(IOException as){System.out.println("Exception 6:");}

			//CONTINUE OPERATION OF STRING NOT MATCHED IN DICTIONARY
			String singlestring=singleString(notmatchstring);
			//System.out.println("Not matched string is :"+singlestring);
			char c1[]=singlestring.toCharArray();
			//for(int i=0;i<singlestring.length();i++)
			//System.out.println(c1[i]);

			//THIS ARRAYLIST CONTAIN STRING WITH SUFFIX VERB
			ArrayList<String> alist1=new ArrayList<String>();
			alist1=stringWithSuffixVerb(c1,notmatchstring);
			//System.out.println("1111111111111111111111111111111111111111111111111111111");
			//System.out.println(alist1);
			int size=alist1.size();
			String verb[]=new String[size];
			verb=alist1.toArray(verb);
			try
			{
					writeVerb(verb,size);//call writeVerb method to write string to file "Verb.txt"
			}
			catch(IOException as){System.out.println("Exception 7:");}


			//THIS ARRAYLIST CONTAIN STRING WITH SUFFIX NOUN
			ArrayList<String> alist2=new ArrayList<String>();
			alist2=stringWithSuffixNoun(c1,notmatchstring);
			//System.out.println("222222222222222222222222222222222222222222222222222222222");
			//System.out.println(alist2);
			int size2=alist2.size();
			String noun[]=new String[size2];
			noun=alist2.toArray(noun);
			try
			{
					writeNoun(noun,size2);//call writeNoun method to write string to file "Noun.txt"
			}
			catch(IOException as){System.out.println("Exception 8:");}
			BufferedReader br1=new BufferedReader(new InputStreamReader(new FileInputStream("Noun.txt"), "UTF-16"));
			String str="";
			String str2="";
			while((str=br1.readLine())!=null)
			{
				str2=str2+str;
				str2=str2+'\n';
			}
			br1.close();
			str2=str2+'\n'+"***************************"+'\n';

			BufferedReader br2=new BufferedReader(new InputStreamReader(new FileInputStream("Verb.txt"), "UTF-16"));
			while((str=br2.readLine())!=null)
			{
				str2=str2+str;
				str2=str2+'\n';
			}
			textarea2.setText(str2);
			br2.close();




	}//End of firstButton method

	//OPERATION FOR WRITING STRING to FILE VERB.TXT
	void writeVerb(String verb[],int size) throws IOException
	{

			PrintWriter bw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("Verb.txt"), "UTF-16"));
			for(int i=0;i<size;i++)
			{
				bw.write(verb[i]);
				if(i==0)
				{
					bw.write('\t');bw.write('\t');
				}
				else if((i%2)!=0)
				{
					bw.println();
				}
				else
				{
					bw.write('\t');bw.write('\t');
				}
				//bw.println();
			}
			bw.close();
	}
	//OPERATION FOR WRITING STRING to FILE NOUN.TXT
	void writeNoun(String noun[],int size2) throws IOException
	{
			PrintWriter bw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("Noun.txt"), "UTF-16"));
			for(int i=0;i<size2;i++)
			{
				bw.write(noun[i]);
				if(i==0){bw.write('\t');bw.write('\t');}
				else if((i%2)!=0){bw.println();}
				else{bw.write('\t');bw.write('\t');}
				//bw.println();
			}
			bw.close();
}


//NOUN OPERATION START //NOUN OPERATION START //NOUN OPERATION START //NOUN OPERATION START //NOUN OPERATION START
	ArrayList<String> stringWithSuffixNoun(char c1[],String notmatchstring[])
	{
		ArrayList<String> alist2=new ArrayList<String>();
		int j=0;
		for(int k=0;k<c1.length;k++)
		{
			if(c1[k]==' ')
			{
				j++;
			}
			if(c1[k]=='\u0B47')//UNICODE Testing for e//111111111111111111111111111
			{
					k++;
					if(Character.isWhitespace(c1[k]))
					{
						String s2=notmatchstring[j];
						int x=s2.length();
						String s3=s2.substring(0,(x-1));
						alist2.add(s3);
						alist2.add(""+'\u0B47');
					}
					k--;
			}//End of 1st if condition//UNICODE Testing for e

			if(c1[k]=='\u0B1F')//UNICODE Testing for te,ta,tae,taku,taru,tara,tare//22222222222222222222222222222222
			{
					k++;
					if(c1[k]=='\u0B47')
					{
						k++;
						if(Character.isWhitespace(c1[k]))
						{
							String s2=notmatchstring[j];
							int x=s2.length();
							String s3=s2.substring(0,(x-2));
							alist2.add(s3);
							alist2.add(""+'\u0B1F'+'\u0B47');
						}
						k--;
					}
					if(c1[k]=='\u0B3E')
					{
						k++;
						if(Character.isWhitespace(c1[k]))
						{
							String s2=notmatchstring[j];
							int x=s2.length();
							String s3=s2.substring(0,(x-2));
							alist2.add(s3);
							alist2.add(""+'\u0B1F'+'\u0B3E');
						}
						if(c1[k]=='\u0B1F')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-3));
								alist2.add(s3);
								alist2.add(""+'\u0B1F'+'\u0B3E'+'\u0B1F');
							}
							k--;
						}
						if(c1[k]=='\u0B15')
						{
							k++;
							if(c1[k]=='\u0B41')
							{
								k++;
								if(Character.isWhitespace(c1[k]))
								{
									String s2=notmatchstring[j];
									int x=s2.length();
									String s3=s2.substring(0,(x-4));
									alist2.add(s3);
									alist2.add(""+'\u0B1F'+'\u0B3E'+'\u0B15'+'\u0B41');
								}
								k--;
							}
							k--;
						}
						if(c1[k]=='\u0B30')
						{
							k++;
							if(c1[k]=='\u0B41')
							{
								k++;
								if(Character.isWhitespace(c1[k]))
								{
									String s2=notmatchstring[j];
									int x=s2.length();
									String s3=s2.substring(0,(x-4));
									alist2.add(s3);
									alist2.add(""+'\u0B1F'+'\u0B3E'+'\u0B30'+'\u0B41');
								}
								k--;
							}
							k--;
						}
						if(c1[k]=='\u0B30')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-3));
								alist2.add(s3);
								alist2.add(""+'\u0B1F'+'\u0B3E'+'\u0B30');
							}
							if(c1[k]=='\u0B47')
							{
								k++;
								if(Character.isWhitespace(c1[k]))
								{
									String s2=notmatchstring[j];
									int x=s2.length();
									String s3=s2.substring(0,(x-4));
									alist2.add(s3);
									alist2.add(""+'\u0B1F'+'\u0B3E'+'\u0B30'+'\u0B47');
								}
								k--;
							}

							k--;
						}



					}


					k--;
			}//End of 2th if condition //UNICODE Testing for te,ta,tae,taku,taru,tara,tare

			if(c1[k]=='\u0B1F')//UNICODE Testing for ti,tira,tira,tire,tie,tiku //333333333333333333333333333333
			{
				k++;
				if(c1[k]=='\u0B3F')
				{
					k++;
					if(Character.isWhitespace(c1[k]))
					{
						String s2=notmatchstring[j];
						int x=s2.length();
						String s3=s2.substring(0,(x-2));
						alist2.add(s3);
						alist2.add(""+'\u0B1F'+'\u0B3F');
					}
					if(c1[k]=='\u0B30')
					{
						k++;
						if(Character.isWhitespace(c1[k]))
						{
							String s2=notmatchstring[j];
							int x=s2.length();
							String s3=s2.substring(0,(x-3));
							alist2.add(s3);
							alist2.add(""+'\u0B1F'+'\u0B3F'+'\u0B30');
						}
						if(c1[k]=='\u0B41')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-4));
								alist2.add(s3);
								alist2.add(""+'\u0B1F'+'\u0B3F'+'\u0B30'+'\u0B41');
							}
							k--;
						}
						if(c1[k]=='\u0B47')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-4));
								alist2.add(s3);
								alist2.add(""+'\u0B1F'+'\u0B3F'+'\u0B30'+'\u0B47');
							}
							k--;
						}
						k--;
					}
					if(c1[k]=='\u0B0F')
					{
						k++;
						if(Character.isWhitespace(c1[k]))
						{
							String s2=notmatchstring[j];
							int x=s2.length();
							String s3=s2.substring(0,(x-3));
							alist2.add(s3);
							alist2.add(""+'\u0B1F'+'\u0B3F'+'\u0B0F');
						}
						k--;
					}
					if(c1[k]=='\u0B15')
					{
						k++;
						if(c1[k]=='\u0B41')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-4));
								alist2.add(s3);
								alist2.add(""+'\u0B1F'+'\u0B3F'+'\u0B15'+'\u0B41');
							}
							k--;
						}
						k--;
					}
					k--;
				}
				k--;
			}//End of 3rd if loop//UNICODE Testing for ti,tira,tira,tire,tie,tiku

			if(c1[k]=='\u0B20')//UNICODE Testing for thare,tharu,thu,thu//444444444444444444444444444444444444444444444
			{
					k++;
					if(c1[k]=='\u0B41')
					{
						k++;
						if(Character.isWhitespace(c1[k]))
						{
							String s2=notmatchstring[j];
							int x=s2.length();
							String s3=s2.substring(0,(x-2));
							alist2.add(s3);
							alist2.add(""+'\u0B20'+'\u0B41');
						}
						if(c1[k]=='\u0B01')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-2));
								alist2.add(s3);
								alist2.add(""+'\u0B20'+'\u0B41'+'\u0B01');
							}
							k--;
						}
						k--;
					}
					if(c1[k]=='\u0B3E')
					{
						k++;
						if(c1[k]=='\u0B30')
						{
							k++;
							if(c1[k]=='\u0B47')
							{
								k++;
								if(Character.isWhitespace(c1[k]))
								{
									String s2=notmatchstring[j];
									int x=s2.length();
									String s3=s2.substring(0,(x-4));
									alist2.add(s3);
									alist2.add(""+'\u0B20'+'\u0B3E'+'\u0B30'+'\u0B47');
								}
								k--;
							}
							k--;
						}
						k--;
					}

					k--;
			}//End of 4th if block////UNICODE Testing for thare,tharu,thu,thu

			if(c1[k]=='\u0B30')//UNICODE Testing for re,ra,ru //5555555555555555555555555555555555555
			{
					k++;
					if(c1[k]=='\u0B41')
					{
						k++;
						if(Character.isWhitespace(c1[k]))
						{
							String s2=notmatchstring[j];
							int x=s2.length();
							String s3=s2.substring(0,(x-2));
							alist2.add(s3);
							alist2.add(""+'\u0B30'+'\u0B41');
						}
						k--;
					}
					if(c1[k]=='\u0B47')
					{
						k++;
						if(Character.isWhitespace(c1[k]))
						{
							String s2=notmatchstring[j];
							int x=s2.length();
							String s3=s2.substring(0,(x-2));
							alist2.add(s3);
							alist2.add(""+'\u0B30'+'\u0B47');
						}
						k--;
					}

					if(Character.isWhitespace(c1[k]))
					{
						String s2=notmatchstring[j];
						int x=s2.length();
						String s3=s2.substring(0,(x-1));
						alist2.add(s3);
						alist2.add(""+'\u0B30');
					}
					k--;
			}//End of 5th if condition//UNICODE Testing for re,ra,ru

			if(c1[k]=='\u0B2E')//UNICODE Testing for mana,mane,manaka,manaku//666666666666666666666666666666666
			{
					k++;
					if(c1[k]=='\u0B3E')
					{
						k++;
						if(c1[k]=='\u0B28')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-3));
								alist2.add(s3);
								alist2.add(""+'\u0B2E'+'\u0B3E'+'\u0B28');
							}
							if(c1[k]=='\u0B47')
							{
								k++;
								if(Character.isWhitespace(c1[k]))
								{
									String s2=notmatchstring[j];
									int x=s2.length();
									String s3=s2.substring(0,(x-4));
									alist2.add(s3);
									alist2.add(""+'\u0B2E'+'\u0B3E'+'\u0B28'+'\u0B47');
								}
								k--;
							}
							if(c1[k]=='\u0B19')
							{
								k++;
								if(c1[k]=='\u0B4D')
								{
									k++;
									if(c1[k]=='\u0B15')
									{
										k++;
										if(Character.isWhitespace(c1[k]))
										{
											String s2=notmatchstring[j];
											int x=s2.length();
											String s3=s2.substring(0,(x-6));
											alist2.add(s3);
											alist2.add(""+'\u0B2E'+'\u0B3E'+'\u0B28'+'\u0B19'+'\u0B4D'+'\u0B15');
										}
										k--;
									}
									k--;
								}
								k--;
							}
							k--;
						}
						k--;
					}
					k--;
			}//End of 6th if condition //UNICODE Testing for mana,mane,manaka,manaku

			if(c1[k]=='\u0B17')//UNICODE Testing for gurie,gurika,guriku,guraka,guraku//777777777777777777777777777777777777
			{
					k++;
					if(c1[k]=='\u0B41')
					{
						k++;
						if(c1[k]=='\u0B5E')
						{
							k++;
							if(c1[k]=='\u0B3F')
							{
								k++;
								if(c1[k]=='\u0B0F')
								{
									k++;
									if(Character.isWhitespace(c1[k]))
									{
										String s2=notmatchstring[j];
										int x=s2.length();
										String s3=s2.substring(0,(x-5));
										alist2.add(s3);
										alist2.add(""+'\u0B17'+'\u0B41'+'\u0B5E'+'\u0B3F'+'\u0B0F');
									}
									if(c1[k]=='\u0B15')
									{
										k++;
										if(Character.isWhitespace(c1[k]))
										{
											String s2=notmatchstring[j];
											int x=s2.length();
											String s3=s2.substring(0,(x-6));
											alist2.add(s3);
											alist2.add(""+'\u0B17'+'\u0B41'+'\u0B5E'+'\u0B3F'+'\u0B0F'+'\u0B15');
										}
										if(c1[k]=='\u0B41')
										{
											k++;
											if(Character.isWhitespace(c1[k]))
											{
												String s2=notmatchstring[j];
												int x=s2.length();
												String s3=s2.substring(0,(x-7));
												alist2.add(s3);
												alist2.add(""+'\u0B17'+'\u0B41'+'\u0B5E'+'\u0B3F'+'\u0B0F'+'\u0B15'+'\u0B41');
											}
											k--;
										}
										k--;
									}
									k--;
								}
								k--;
							}
							if(c1[k]=='\u0B3E')
							{
								k++;
								if(c1[k]=='\u0B15')
								{
									k++;
									if(Character.isWhitespace(c1[k]))
									{
										String s2=notmatchstring[j];
										int x=s2.length();
										String s3=s2.substring(0,(x-5));
										alist2.add(s3);
										alist2.add(""+'\u0B17'+'\u0B41'+'\u0B5E'+'\u0B3E'+'\u0B15');
									}
									if(c1[k]=='\u0B41')
									{
										k++;
										if(Character.isWhitespace(c1[k]))
										{
											String s2=notmatchstring[j];
											int x=s2.length();
											String s3=s2.substring(0,(x-6));
											alist2.add(s3);
											alist2.add(""+'\u0B17'+'\u0B41'+'\u0B5E'+'\u0B3E'+'\u0B15'+'\u0B41');
										}
										k--;
									}
									k--;
								}
								k--;
							}
							k--;
						}
						k--;
					}
					k--;
			}//End of 7th if condition //UNICODE Testing for gurie,gurika,guriku,guraka,guraku

			if(c1[k]=='\u0B15')//UNICODE Testing for ku,ki//8888888888888888888888888888888888888888
			{
					k++;
					if(c1[k]=='\u0B41')
					{
						k++;
						if(Character.isWhitespace(c1[k]))
						{
							String s2=notmatchstring[j];
							int x=s2.length();
							String s3=s2.substring(0,(x-2));
							alist2.add(s3);
							alist2.add(""+'\u0B15'+'\u0B41');
						}
						k--;
					}
					if(c1[k]=='\u0B3F')
					{
						k++;
						if(Character.isWhitespace(c1[k]))
						{
							String s2=notmatchstring[j];
							int x=s2.length();
							String s3=s2.substring(0,(x-2));
							alist2.add(s3);
							alist2.add(""+'\u0B15'+'\u0B3F');
						}
						k--;
					}

					k--;
			}//End of 8th if condition//UNICODE Testing for ku,ki
			if(c1[k]=='\u0B19')//UNICODE Testing for nka,nku//99999999999999999999999999999999
			{
					k++;
					if(c1[k]=='\u0B4D')
					{
						k++;
						if(c1[k]=='\u0B15')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-3));
								alist2.add(s3);
								alist2.add(""+'\u0B19'+'\u0B4D'+'\u0B15');
							}
							if(c1[k]=='\u0B41')
							{
								k++;
								if(Character.isWhitespace(c1[k]))
								{
									String s2=notmatchstring[j];
									int x=s2.length();
									String s3=s2.substring(0,(x-4));
									alist2.add(s3);
									alist2.add(""+'\u0B19'+'\u0B4D'+'\u0B15'+'\u0B41');
								}
								k--;
							}
							if(c1[k]=='\u0B30')
							{
								k++;
								if(Character.isWhitespace(c1[k]))
								{
									String s2=notmatchstring[j];
									int x=s2.length();
									String s3=s2.substring(0,(x-4));
									alist2.add(s3);
									alist2.add(""+'\u0B19'+'\u0B4D'+'\u0B15'+'\u0B30');
								}
								k--;
							}
							k--;
						}
						k--;
					}
					k--;
			}//End of 9th if condition //UNICODE Testing for nka,nku



		}//End of main for loop
		return alist2;
	}
	//VERB OPERATION START //VERB OPERATION START //VERB OPERATION START //VERB OPERATION START //VERB OPERATION START
	ArrayList<String> stringWithSuffixVerb(char c1[],String notmatchstring[])
	{
		ArrayList<String> alist2=new ArrayList<String>();
		int j=0;
		for(int k=0;k<c1.length;k++)
		{
			if(c1[k]==' ')
			{
				j++;
			}
			/***********************************************************************
			if(c1[k]=='\u0B30')//UNICODE Testing
			{
					k++;
					if(c1[k]=='\u0B41')
					{
						k++;
						if(Character.isWhitespace(c1[k]))
						{
							String s2=notmatchstring[j];
							int x=s2.length();
							String s3=s2.substring(0,(x-2));
							alist2.add(s3);
							alist2.add(""+'\u0B30'+'\u0B41');
						}
						k--;
					}
					k--;
			}//End of if condition

			**************************************************************************/
			if(c1[k]=='\u0B09')//UNICODE Testing for ucha,uchi,uchu,uche//111111111111111111111111111
			{
					k++;
					if(c1[k]=='\u0B1B')
					{
						k++;
						if(Character.isWhitespace(c1[k]))
						{
							String s2=notmatchstring[j];
							int x=s2.length();
							String s3=s2.substring(0,(x-2));
							alist2.add(s3);
							alist2.add(""+'\u0B09'+'\u0B1B');
						}
						if(c1[k]=='\u0B3F')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-3));
								alist2.add(s3);
								alist2.add(""+'\u0B09'+'\u0B1B'+'\u0B3F');
							}
							k--;
						}
						if(c1[k]=='\u0B41')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-3));
								alist2.add(s3);
								alist2.add(""+'\u0B09'+'\u0B1B'+'\u0B41');
							}
							k--;
						}
						if(c1[k]=='\u0B47')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-3));
								alist2.add(s3);
								alist2.add(""+'\u0B09'+'\u0B1B'+'\u0B47');
							}
							k--;
						}
						k--;
					}
					k--;
			}//End of 1st if condition //UNICODE Testing for ucha,uchi,uchu,uche

			if(c1[k]=='\u0B47')//UNICODE Testing for icha,ichu,iche,ichi //222222222222222222222222
			{
					k++;
					if(c1[k]=='\u0B1B')
					{
						k++;
						if(Character.isWhitespace(c1[k]))
						{
							String s2=notmatchstring[j];
							int x=s2.length();
							String s3=s2.substring(0,(x-3));
							alist2.add(s3);
							alist2.add(""+'\u0B47'+'\u0B1B');
						}
						if(c1[k]=='\u0B41')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-3));
								alist2.add(s3);
								alist2.add(""+'\u0B47'+'\u0B1B'+'\u0B41');
							}
							k--;
						}
						if(c1[k]=='\u0B47')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-3));
								alist2.add(s3);
								alist2.add(""+'\u0B47'+'\u0B1B'+'\u0B47');
							}
							k--;
						}
						if(c1[k]=='\u0B1B')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-3));
								alist2.add(s3);
								alist2.add(""+'\u0B47'+'\u0B1B'+'\u0B1B');
							}
							k--;
						}
						k--;
					}
					k--;
			}//End of 2st if condition //UNICODE Testing for icha,ichu,iche,ichi

			if(c1[k]=='\u0B05')//UNICODE Testing for anta,anti,antu,ante,anta//33333333333333333333333
			{
					k++;
					if(c1[k]=='\u0B28')
					{
						k++;
						if(c1[k]=='\u0B4D')
						{
							k++;
							if(c1[k]=='\u0B24')
							{
								k++;
								if(Character.isWhitespace(c1[k]))
								{
									String s2=notmatchstring[j];
									int x=s2.length();
									String s3=s2.substring(0,(x-4));
									alist2.add(s3);
									alist2.add(""+'\u0B05'+'\u0B28'+'\u0B4D'+'\u0B24');
								}
								if(c1[k]=='\u0B3F')
								{
									k++;
									if(Character.isWhitespace(c1[k]))
									{
										String s2=notmatchstring[j];
										int x=s2.length();
										String s3=s2.substring(0,(x-5));
										alist2.add(s3);
										alist2.add(""+'\u0B05'+'\u0B28'+'\u0B4D'+'\u0B24'+'\u0B3F');
									}
									k--;
								}
								if(c1[k]=='\u0B41')
								{
									k++;
									if(Character.isWhitespace(c1[k]))
									{
										String s2=notmatchstring[j];
										int x=s2.length();
										String s3=s2.substring(0,(x-5));
										alist2.add(s3);
										alist2.add(""+'\u0B05'+'\u0B28'+'\u0B4D'+'\u0B24'+'\u0B41');
									}
									k--;
								}
								if(c1[k]=='\u0B47')
								{
									k++;
									if(Character.isWhitespace(c1[k]))
									{
										String s2=notmatchstring[j];
										int x=s2.length();
										String s3=s2.substring(0,(x-5));
										alist2.add(s3);
										alist2.add(""+'\u0B05'+'\u0B28'+'\u0B4D'+'\u0B24'+'\u0B47');
									}
									k--;
								}
								if(c1[k]=='\u0B3E')
								{
									k++;
									if(Character.isWhitespace(c1[k]))
									{
										String s2=notmatchstring[j];
										int x=s2.length();
										String s3=s2.substring(0,(x-5));
										alist2.add(s3);
										alist2.add(""+'\u0B05'+'\u0B28'+'\u0B4D'+'\u0B24'+'\u0B3E');
									}
									k--;
								}
								k--;

							}
							k--;
						}
						k--;
					}
					k--;
			}//End of 3rd if condition //UNICODE Testing for anta,anti,antu,ante,anta

			if(c1[k]=='\u0B09')//UNICODE Testing for uchanti,ichanti//444444444444444444444444444444444444
			{
					k++;
					if(c1[k]=='\u0B1B')
					{
						k++;
						if(c1[k]=='\u0B28')
						{
							k++;
							if(c1[k]=='\u0B4D')
							{
								k++;
								if(c1[k]=='\u0B24')
								{
									k++;
									if(c1[k]=='\u0B3F')
									{
										k++;
										if(Character.isWhitespace(c1[k]))
										{
											String s2=notmatchstring[j];
											int x=s2.length();
											String s3=s2.substring(0,(x-6));
											alist2.add(s3);
											alist2.add(""+'\u0B09'+'\u0B1B'+'\u0B28'+'\u0B4D'+'\u0B24'+'\u0B3F');
										}
										k--;
									}
									k--;
								}
								k--;
							}
							k--;
						}
						k--;
					}
					k--;
			}//End of 4th if condition //UNICODE Testing for uchanti,ichanti

			if(c1[k]=='\u0B07')//UNICODE Testing for uchanti,ichanti//444444444444444444444444444444444444
			{
					k++;
					if(c1[k]=='\u0B1B')
					{
						k++;
						if(c1[k]=='\u0B28')
						{
							k++;
							if(c1[k]=='\u0B4D')
							{
								k++;
								if(c1[k]=='\u0B24')
								{
									k++;
									if(c1[k]=='\u0B3F')
									{
										k++;
										if(Character.isWhitespace(c1[k]))
										{
											String s2=notmatchstring[j];
											int x=s2.length();
											String s3=s2.substring(0,(x-6));
											alist2.add(s3);
											alist2.add(""+'\u0B07'+'\u0B1B'+'\u0B28'+'\u0B4D'+'\u0B24'+'\u0B3F');
										}
										k--;
									}
									k--;
								}
								k--;
							}
							k--;
						}
						k--;
					}
					k--;
			}//End of 4th if condition //UNICODE Testing for uchanti,ichanti

			if(c1[k]=='\u0B07')//UNICODE Testing for ila,ilu,ili,ila,ile//5555555555555555555555555555555
			{
					k++;
					if(c1[k]=='\u0B32')
					{
						k++;
						if(Character.isWhitespace(c1[k]))
						{
							String s2=notmatchstring[j];
							int x=s2.length();
							String s3=s2.substring(0,(x-2));
							alist2.add(s3);
							alist2.add(""+'\u0B07'+'\u0B32');
						}
						if(c1[k]=='\u0B41')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-3));
								alist2.add(s3);
								alist2.add(""+'\u0B07'+'\u0B32'+'\u0B41');
							}
							k--;
						}
						if(c1[k]=='\u0B3F')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-3));
								alist2.add(s3);
								alist2.add(""+'\u0B07'+'\u0B32'+'\u0B3F');
							}
							k--;
						}
						if(c1[k]=='\u0B3E')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-3));
								alist2.add(s3);
								alist2.add(""+'\u0B07'+'\u0B32'+'\u0B3E');
							}
							k--;
						}
						if(c1[k]=='\u0B47')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-3));
								alist2.add(s3);
								alist2.add(""+'\u0B07'+'\u0B32'+'\u0B47');
							}
							k--;
						}
						k--;
					}
					k--;
			}//End of 5th if condition //UNICODE Testing for ila,ilu,ili,ila,ile

			if(c1[k]=='\u0B09')//UNICODE Testing for uthila,uthili,uthilu,uthile//66666666666666666666666666666666
			{
					k++;
					if(c1[k]=='\u0B25')
					{
						k++;
						if(c1[k]=='\u0B3F')
						{
							k++;
							if(c1[k]=='\u0B32')
							{
								k++;
								if(Character.isWhitespace(c1[k]))
								{
									String s2=notmatchstring[j];
									int x=s2.length();
									String s3=s2.substring(0,(x-4));
									alist2.add(s3);
									alist2.add(""+'\u0B09'+'\u0B25'+'\u0B3F'+'\u0B32');
								}
								if(c1[k]=='\u0B3F')
								{
									k++;
									if(Character.isWhitespace(c1[k]))
									{
										String s2=notmatchstring[j];
										int x=s2.length();
										String s3=s2.substring(0,(x-5));
										alist2.add(s3);
										alist2.add(""+'\u0B09'+'\u0B25'+'\u0B3F'+'\u0B32'+'\u0B3F');
									}
									k--;
								}
								if(c1[k]=='\u0B41')
								{
									k++;
									if(Character.isWhitespace(c1[k]))
									{
										String s2=notmatchstring[j];
										int x=s2.length();
										String s3=s2.substring(0,(x-5));
										alist2.add(s3);
										alist2.add(""+'\u0B09'+'\u0B25'+'\u0B3F'+'\u0B32'+'\u0B41');
									}
									k--;
								}
								if(c1[k]=='\u0B47')
								{
									k++;
									if(Character.isWhitespace(c1[k]))
									{
										String s2=notmatchstring[j];
										int x=s2.length();
										String s3=s2.substring(0,(x-5));
										alist2.add(s3);
										alist2.add(""+'\u0B09'+'\u0B25'+'\u0B3F'+'\u0B32'+'\u0B47');
									}
									k--;
								}
								if(c1[k]=='\u0B3E')
								{
									k++;
									if(Character.isWhitespace(c1[k]))
									{
										String s2=notmatchstring[j];
										int x=s2.length();
										String s3=s2.substring(0,(x-5));
										alist2.add(s3);
										alist2.add(""+'\u0B09'+'\u0B25'+'\u0B3F'+'\u0B32'+'\u0B3E');
									}
									k--;
								}
								k--;

							}
							k--;
						}
						k--;
					}
					k--;
			}//End of 6th if condition //UNICODE Testing for uthila,uthili,uthilu,uthile

			if(c1[k]=='\u0B07')//UNICODE Testing for ithila,ithili,ithile,ithilu,ithila//777777777777777777777777777777
			{
					k++;
					if(c1[k]=='\u0B25')
					{
						k++;
						if(c1[k]=='\u0B3F')
						{
							k++;
							if(c1[k]=='\u0B32')
							{
								k++;
								if(Character.isWhitespace(c1[k]))
								{
									String s2=notmatchstring[j];
									int x=s2.length();
									String s3=s2.substring(0,(x-4));
									alist2.add(s3);
									alist2.add(""+'\u0B07'+'\u0B25'+'\u0B3F'+'\u0B32');
								}
								if(c1[k]=='\u0B3F')
								{
									k++;
									if(Character.isWhitespace(c1[k]))
									{
										String s2=notmatchstring[j];
										int x=s2.length();
										String s3=s2.substring(0,(x-5));
										alist2.add(s3);
										alist2.add(""+'\u0B07'+'\u0B25'+'\u0B3F'+'\u0B32'+'\u0B3F');
									}
									k--;
								}
								if(c1[k]=='\u0B41')
								{
									k++;
									if(Character.isWhitespace(c1[k]))
									{
										String s2=notmatchstring[j];
										int x=s2.length();
										String s3=s2.substring(0,(x-5));
										alist2.add(s3);
										alist2.add(""+'\u0B07'+'\u0B25'+'\u0B3F'+'\u0B32'+'\u0B41');
									}
									k--;
								}
								if(c1[k]=='\u0B47')
								{
									k++;
									if(Character.isWhitespace(c1[k]))
									{
										String s2=notmatchstring[j];
										int x=s2.length();
										String s3=s2.substring(0,(x-5));
										alist2.add(s3);
										alist2.add(""+'\u0B07'+'\u0B25'+'\u0B3F'+'\u0B32'+'\u0B47');
									}
									k--;
								}
								if(c1[k]=='\u0B3E')
								{
									k++;
									if(Character.isWhitespace(c1[k]))
									{
										String s2=notmatchstring[j];
										int x=s2.length();
										String s3=s2.substring(0,(x-5));
										alist2.add(s3);
										alist2.add(""+'\u0B07'+'\u0B25'+'\u0B3F'+'\u0B32'+'\u0B3E');
									}
									k--;
								}
								k--;

							}
							k--;
						}
						k--;
					}
					k--;
			}//End of 7th if condition //UNICODE Testing for ithila,ithili,ithile,ithilu,ithila

			if(c1[k]=='\u0B07')//UNICODE Testing for iba,iba,ibi,ibu,ibe//8888888888888888888888888888888
			{
					k++;
					if(c1[k]=='\u0B2E')
					{
						k++;
						if(Character.isWhitespace(c1[k]))
						{
							String s2=notmatchstring[j];
							int x=s2.length();
							String s3=s2.substring(0,(x-2));
							alist2.add(s3);
							alist2.add(""+'\u0B07'+'\u0B2E');
						}
						if(c1[k]=='\u0B41')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-3));
								alist2.add(s3);
								alist2.add(""+'\u0B07'+'\u0B2E'+'\u0B41');
							}
							k--;
						}
						if(c1[k]=='\u0B3F')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-3));
								alist2.add(s3);
								alist2.add(""+'\u0B07'+'\u0B2E'+'\u0B3F');
							}
							k--;
						}
						if(c1[k]=='\u0B3E')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-3));
								alist2.add(s3);
								alist2.add(""+'\u0B07'+'\u0B2E'+'\u0B3E');
							}
							k--;
						}
						if(c1[k]=='\u0B47')
						{
							k++;
							if(Character.isWhitespace(c1[k]))
							{
								String s2=notmatchstring[j];
								int x=s2.length();
								String s3=s2.substring(0,(x-3));
								alist2.add(s3);
								alist2.add(""+'\u0B07'+'\u0B2E'+'\u0B47');
							}
							k--;
						}
						k--;
					}
					k--;
			}//End of 8th if condition //UNICODE Testing for iba,iba,ibi,ibu,ibe

			if(c1[k]=='\u0B09')//UNICODE Testing for uthiba,uthiba,uthibi,uthibu,uthibe//9999999999999999999999999999999999
			{
					k++;
					if(c1[k]=='\u0B25')
					{
						k++;
						if(c1[k]=='\u0B3F')
						{
							k++;
							if(c1[k]=='\u0B2E')
							{
								k++;
								if(Character.isWhitespace(c1[k]))
								{
									String s2=notmatchstring[j];
									int x=s2.length();
									String s3=s2.substring(0,(x-4));
									alist2.add(s3);
									alist2.add(""+'\u0B09'+'\u0B25'+'\u0B3F'+'\u0B2E');
								}
								if(c1[k]=='\u0B3F')
								{
									k++;
									if(Character.isWhitespace(c1[k]))
									{
										String s2=notmatchstring[j];
										int x=s2.length();
										String s3=s2.substring(0,(x-5));
										alist2.add(s3);
										alist2.add(""+'\u0B09'+'\u0B25'+'\u0B3F'+'\u0B2E'+'\u0B3F');
									}
									k--;
								}
								if(c1[k]=='\u0B41')
								{
									k++;
									if(Character.isWhitespace(c1[k]))
									{
										String s2=notmatchstring[j];
										int x=s2.length();
										String s3=s2.substring(0,(x-5));
										alist2.add(s3);
										alist2.add(""+'\u0B09'+'\u0B25'+'\u0B3F'+'\u0B2E'+'\u0B41');
									}
									k--;
								}
								if(c1[k]=='\u0B47')
								{
									k++;
									if(Character.isWhitespace(c1[k]))
									{
										String s2=notmatchstring[j];
										int x=s2.length();
										String s3=s2.substring(0,(x-5));
										alist2.add(s3);
										alist2.add(""+'\u0B09'+'\u0B25'+'\u0B3F'+'\u0B2E'+'\u0B47');
									}
									k--;
								}
								if(c1[k]=='\u0B3E')
								{
									k++;
									if(Character.isWhitespace(c1[k]))
									{
										String s2=notmatchstring[j];
										int x=s2.length();
										String s3=s2.substring(0,(x-5));
										alist2.add(s3);
										alist2.add(""+'\u0B09'+'\u0B25'+'\u0B3F'+'\u0B2E'+'\u0B3E');
									}
									k--;
								}
								k--;

							}
							k--;
						}
						k--;
					}
					k--;
			}//End of 9th if condition //UNICODE Testing for uthiba,uthiba,uthibi,uthibu,uthibe

			if(c1[k]=='\u0B07')//UNICODE Testing for uchanti,ichanti//10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10
			{
					k++;
					if(c1[k]=='\u0B25')
					{
						k++;
						if(c1[k]=='\u0B41')
						{
							k++;
							if(c1[k]=='\u0B3F')
							{
								k++;
								if(c1[k]=='\u0B2E')
								{
									k++;
									if(Character.isWhitespace(c1[k]))
									{
										String s2=notmatchstring[j];
										int x=s2.length();
										String s3=s2.substring(0,(x-5));
										alist2.add(s3);
										alist2.add(""+'\u0B07'+'\u0B25'+'\u0B41'+'\u0B3F'+'\u0B2E');
									}
									if(c1[k]=='\u0B3E')
									{
										k++;
										if(Character.isWhitespace(c1[k]))
										{
											String s2=notmatchstring[j];
											int x=s2.length();
											String s3=s2.substring(0,(x-6));
											alist2.add(s3);
											alist2.add(""+'\u0B07'+'\u0B25'+'\u0B41'+'\u0B3F'+'\u0B2E'+'\u0B3E');
										}
										k--;
									}
									if(c1[k]=='\u0B47')
									{
										k++;
										if(Character.isWhitespace(c1[k]))
										{
											String s2=notmatchstring[j];
											int x=s2.length();
											String s3=s2.substring(0,(x-6));
											alist2.add(s3);
											alist2.add(""+'\u0B07'+'\u0B25'+'\u0B41'+'\u0B3F'+'\u0B2E'+'\u0B47');
										}
										k--;
									}
									if(c1[k]=='\u0B41')
									{
										k++;
										if(Character.isWhitespace(c1[k]))
										{
											String s2=notmatchstring[j];
											int x=s2.length();
											String s3=s2.substring(0,(x-6));
											alist2.add(s3);
											alist2.add(""+'\u0B07'+'\u0B25'+'\u0B41'+'\u0B3F'+'\u0B2E'+'\u0B41');
										}
										k--;
									}
									if(c1[k]=='\u0B3F')
									{
										k++;
										if(Character.isWhitespace(c1[k]))
										{
											String s2=notmatchstring[j];
											int x=s2.length();
											String s3=s2.substring(0,(x-6));
											alist2.add(s3);
											alist2.add(""+'\u0B07'+'\u0B25'+'\u0B41'+'\u0B3F'+'\u0B2E'+'\u0B3F');
										}
										k--;
									}

									k--;
								}
								k--;
							}
							k--;
						}
						k--;
					}
					k--;
			}//End of 10th if condition //UNICODE Testing for ithiba,ithiba,ithibe,ithibu,ithibi

			if(c1[k]=='\u0B09')//UNICODE Testing for uthanta,uthanti,uthantu,uthantu,uthante//11 11 11 11 11 11 11 11 11 11 11 11 11 11
			{
					k++;
					if(c1[k]=='\u0B25')
					{
						k++;
						if(c1[k]=='\u0B3E')
						{
							k++;
							if(c1[k]=='\u0B28')
							{
								k++;
								if(c1[k]=='\u0B4D')
								{
									k++;
									if(c1[k]=='\u0B24')
									{
										k++;
										if(Character.isWhitespace(c1[k]))
										{
											String s2=notmatchstring[j];
											int x=s2.length();
											String s3=s2.substring(0,(x-6));
											alist2.add(s3);
											alist2.add(""+'\u0B09'+'\u0B25'+'\u0B3E'+'\u0B28'+'\u0B4D'+'\u0B24');
										}
										if(c1[k]=='\u0B3E')
										{
											k++;
											if(Character.isWhitespace(c1[k]))
											{
												String s2=notmatchstring[j];
												int x=s2.length();
												String s3=s2.substring(0,(x-7));
												alist2.add(s3);
												alist2.add(""+'\u0B09'+'\u0B25'+'\u0B3E'+'\u0B28'+'\u0B4D'+'\u0B24'+'\u0B3E');
											}
											k--;
										}
										if(c1[k]=='\u0B3F')
										{
											k++;
											if(Character.isWhitespace(c1[k]))
											{
												String s2=notmatchstring[j];
												int x=s2.length();
												String s3=s2.substring(0,(x-7));
												alist2.add(s3);
												alist2.add(""+'\u0B09'+'\u0B25'+'\u0B3E'+'\u0B28'+'\u0B4D'+'\u0B24'+'\u0B3F');
											}
											k--;
										}
										if(c1[k]=='\u0B41')
										{
											k++;
											if(Character.isWhitespace(c1[k]))
											{
												String s2=notmatchstring[j];
												int x=s2.length();
												String s3=s2.substring(0,(x-7));
												alist2.add(s3);
												alist2.add(""+'\u0B09'+'\u0B25'+'\u0B3E'+'\u0B28'+'\u0B4D'+'\u0B24'+'\u0B41');
											}
											k--;
										}
										if(c1[k]=='\u0B47')
										{
											k++;
											if(Character.isWhitespace(c1[k]))
											{
												String s2=notmatchstring[j];
												int x=s2.length();
												String s3=s2.substring(0,(x-7));
												alist2.add(s3);
												alist2.add(""+'\u0B09'+'\u0B25'+'\u0B3E'+'\u0B28'+'\u0B4D'+'\u0B24'+'\u0B47');
											}
											k--;
										}

										k--;
									}
									k--;
								}
								k--;
							}
							k--;
						}
						k--;
					}
					k--;
			}//End of 11th if condition //UNICODE Testing for uthanta,uthanti,uthantu,uthantu,uthante

			if(c1[k]=='\u0B07')//UNICODE Testing for ithanta,ithanta,ithanti,ithantu,ithante//12 12 12 12 12 12 12 12 12 12
			{
					k++;
					if(c1[k]=='\u0B25')
					{
						k++;
						if(c1[k]=='\u0B3E')
						{
							k++;
							if(c1[k]=='\u0B28')
							{
								k++;
								if(c1[k]=='\u0B4D')
								{
									k++;
									if(c1[k]=='\u0B24')
									{
										k++;
										if(Character.isWhitespace(c1[k]))
										{
											String s2=notmatchstring[j];
											int x=s2.length();
											String s3=s2.substring(0,(x-6));
											alist2.add(s3);
											alist2.add(""+'\u0B07'+'\u0B25'+'\u0B3E'+'\u0B28'+'\u0B4D'+'\u0B24');
										}
										if(c1[k]=='\u0B3E')
										{
											k++;
											if(Character.isWhitespace(c1[k]))
											{
												String s2=notmatchstring[j];
												int x=s2.length();
												String s3=s2.substring(0,(x-7));
												alist2.add(s3);
												alist2.add(""+'\u0B07'+'\u0B25'+'\u0B3E'+'\u0B28'+'\u0B4D'+'\u0B24'+'\u0B3E');
											}
											k--;
										}
										if(c1[k]=='\u0B3F')
										{
											k++;
											if(Character.isWhitespace(c1[k]))
											{
												String s2=notmatchstring[j];
												int x=s2.length();
												String s3=s2.substring(0,(x-7));
												alist2.add(s3);
												alist2.add(""+'\u0B07'+'\u0B25'+'\u0B3E'+'\u0B28'+'\u0B4D'+'\u0B24'+'\u0B3F');
											}
											k--;
										}
										if(c1[k]=='\u0B41')
										{
											k++;
											if(Character.isWhitespace(c1[k]))
											{
												String s2=notmatchstring[j];
												int x=s2.length();
												String s3=s2.substring(0,(x-7));
												alist2.add(s3);
												alist2.add(""+'\u0B07'+'\u0B25'+'\u0B3E'+'\u0B28'+'\u0B4D'+'\u0B24'+'\u0B41');
											}
											k--;
										}
										if(c1[k]=='\u0B47')
										{
											k++;
											if(Character.isWhitespace(c1[k]))
											{
												String s2=notmatchstring[j];
												int x=s2.length();
												String s3=s2.substring(0,(x-7));
												alist2.add(s3);
												alist2.add(""+'\u0B07'+'\u0B25'+'\u0B3E'+'\u0B28'+'\u0B4D'+'\u0B24'+'\u0B47');
											}
											k--;
										}

										k--;
									}
									k--;
								}
								k--;
							}
							k--;
						}
						k--;
					}
					k--;
			}//End of 12th if condition //UNICODE Testing for ithanta,ithanta,ithanti,ithantu,ithante



		}//End of charater for loop
		return alist2;
	}//End of method stringWithSuffix

	String singleString(String notmatchstring[])
	{
		String single="";
		for(int i=0;i<notmatchstring.length;i++)
		{
			single=single+notmatchstring[i];
			single=single+""+' ';
		}
		return single;
	}


	//OPERATION FOR STRING NOT MATCHED IN DICTIONARY
	void writeNotMatchString(String notmatchstring[],int countnotmatch) throws IOException
	{
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("NotMatched.txt"), "UTF-16"));
			for(int i=0;i<countnotmatch;i++)
			{
				bw.write(notmatchstring[i]);
				bw.write(' ');
			}
			bw.close();
	}

	public String[] notMatchString(String substring[],int countstring,int countnotmatch)throws IOException
	{
		String notmatchstring[]=new String[countnotmatch];
		int j=0;
				int p=0;
				int q=0;
				boolean bool=false;
				BufferedReader br1=new BufferedReader(new InputStreamReader(new FileInputStream("oriyaDictionary2.txt"), "UTF-16"));
				String sread1[]=new String[100000];//suppose 100000 name are there
				while((sread1[j]=br1.readLine())!=null)
				{
						//System.out.println("\n"+sread1[j]);
						j++;
				}
				for(int i=0;i<countstring;i++)
				{
					p=0;
					bool=false;
					while(sread1[p]!=null)
					{
						if(sread1[p].trim().equals(substring[i].trim()))
						{
							bool=true;
						}
						p++;
					}
					if(bool)
					{

					}
					else
					{
						notmatchstring[q]=substring[i];
						q++;

					}
				}//End of for loop
			return notmatchstring;

	}//End of notMatchString method

	public int notMatchCount( String substring[],int countstring) throws IOException
	{
		int notmatch=0;
		int j=0;
		int p=0;
		boolean bool=false;
		BufferedReader br1=new BufferedReader(new InputStreamReader(new FileInputStream("oriyaDictionary2.txt"), "UTF-16"));
		String sread1[]=new String[100000];//suppose 100000 name are there
		while((sread1[j]=br1.readLine())!=null)
		{
				//System.out.println("\n"+sread1[j]);
				j++;
		}
		for(int i=0;i<countstring;i++)
		{
			p=0;
			bool=false;
			while(sread1[p]!=null)
			{
				if(sread1[p].trim().equals(substring[i].trim()))
				{
					bool=true;
				}
				p++;
			}
			if(bool)
			{

			}
			else
			{
				notmatch++;
			}

		}

		return notmatch;
	}//END OF notMatchCount method

	//OPERATION FOR STRING MATCHED IN DICTIONARY

	void writeMatchString(String matchstring[],int countmatch) throws IOException
		{
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("POS.txt"), "UTF-16"));
				for(int i=0;i<countmatch;i++)
				{
					bw.write(matchstring[i]);
					bw.write(' ');
				}
				bw.close();
		}

		public String[] matchString(String substring[],int countstring,int countmatch)throws IOException
		{
			String matchstring[]=new String[countmatch];
			int j=0;
					int p=0;
					int q=0;
					boolean bool=false;
					BufferedReader br1=new BufferedReader(new InputStreamReader(new FileInputStream("oriyaDictionary2.txt"), "UTF-16"));
					String sread1[]=new String[100000];//suppose 100000 name are there
					while((sread1[j]=br1.readLine())!=null)
					{
							//System.out.println("\n"+sread1[j]);
							j++;
					}
					for(int i=0;i<countstring;i++)
					{
						p=0;
						bool=false;
						while(sread1[p]!=null)
						{
							if(sread1[p].trim().equals(substring[i].trim()))
							{
								bool=true;
							}
							p++;
						}
						if(bool)
						{
							matchstring[q]=substring[i];
							q++;
						}
						else
						{


						}
					}//End of for loop
				return matchstring;

		}//End of notMatchString method

		public int matchCount( String substring[],int countstring) throws IOException
		{
			int match=0;
			int j=0;
			int p=0;
			boolean bool=false;
			BufferedReader br1=new BufferedReader(new InputStreamReader(new FileInputStream("oriyaDictionary2.txt"), "UTF-16"));
			String sread1[]=new String[100000];//suppose 100000 name are there
			while((sread1[j]=br1.readLine())!=null)
			{
					//System.out.println("\n"+sread1[j]);
					j++;
			}
			for(int i=0;i<countstring;i++)
			{
				p=0;
				bool=false;
				while(sread1[p]!=null)
				{
					if(sread1[p].trim().equals(substring[i].trim()))
					{
						bool=true;
					}
					p++;
				}
				if(bool)
				{
					match++;
				}
				else
				{

				}

			}

			return match;
	}//END OF matchCount method

	public String createString(String totalstring) throws IOException
	{
			String s4="";
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(TEMPFILE), "UTF-16"));
					bw.write(textarea1.getText());
					bw.close();
					BufferedReader br123 = new BufferedReader(new InputStreamReader(new FileInputStream(TEMPFILE), "UTF-16"));
					String temp3="";
					String tempString2;
					while ((tempString2 = br123.readLine()) != null)
					{

							temp3=temp3+tempString2.trim();
							temp3=temp3+' ';
					}
					 br123.close();
					s4=temp3.trim();
			return s4;
	}//Ene of createString method

	public int countString(String s4)
	{
		char c1[]=s4.toCharArray();
								int count=0;
								// Counting total number of string to initialize the length of string
								boolean bchar=false;
								int uni =0x0B00;//Oriya letter start from 0x0B00 to 0x0B79
								for(int k=0;k<s4.length();k++)
								{
									bchar=false;
									uni =0x0B00;
									//System.out.println("Character :"+c1[k]);
									while(uni <= 0x0B70)
									{

										if(c1[k]==uni)
										{
											bchar=true;
										}
										uni++;

										//else {System.out.println("White space ");}
									}
									if(c1[k]=='\u0964' || bchar)
									{
										//System.out.println("i am letter of digit "+k);
										//System.out.println("i am oriya letter ");

									}
									else
									{
										count++;
										//System.out.println("count value :"+count);
									}

								}

						int slength=count+1;
		return slength;
	}//End of countString method

	public String[] subString(String s4,int lenstr)//This method return a set of word
	{
		char c1[]=s4.toCharArray();
		String s5[]=new String[lenstr];
		int j=0;
		boolean bchar=false;
		int uni =0x0B00;//Oriya letter start from 0x0B00 to 0x0B79
		s5[j]="";
								//Making words by storing each character
								for(int k=0;k<s4.length();k++)
								{
									bchar=false;
									uni =0x0B00;
									while(uni <= 0x0B70)
									{

											if(c1[k]==uni)
											{
												bchar=true;
											}
											uni++;
											//else {System.out.println("White space ");}
									}
									if(bchar)
									{
										s5[j]=s5[j]+""+c1[k];
									}
									else if(c1[k]=='\u0964'){}
									else   //Must be a newline
									{

										j++;
										s5[j]="";
									}
								}

		return s5;
	}//End of subString method


}//END OF CLASS


