//Filename: Telephone_Project.java
/*

File Handling project to Handle Telephone Contacts
==================================================


Record Handling to store 

teleno (String or UTF)
fname (String or UTF)
lname (String or UTF)
street (String or UTF)
city (String or UTF)
state (String or UTF)
country (String or UTF)
pincode (String or UTF)



To Write data:
===============
int value use: object.writeInt(variable);
Text value use:object.writeUTF(variable);
Double value use: object.writeDouble(variable);

To Read Data
=============
for int value : variable=object.readInt();
for Text value: variable=object.readUTF();
for double value : variable=object.readDouble();

Menu driven program for
(1). Adding a contact record
(2). display all the records
(3). display all the records one by one
(4) search a record by telephone no
(5) search a record by first name
(6) search a record by last name
(7) search a record by street
(8) search a record by city
(9) search a record by state
(10) search a record by country
(11) search a record by pincode
(12). exit

*/

package telephone;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import java.io.*;
import java.util.*; //Scanner

public class P3 { //Telephone_Project
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String teleno,fname,lname,street,city,state,country,pincode;


	/*Add Student Record **********/

    // teleno (String or UTF)
    // fname (String or UTF)
    // fname (String or UTF)
    // street (String or UTF)
    // city (String or UTF)
    // state (String or UTF)
    // country (String or UTF)
    // pincode (String or UTF)
	void write()
	{
		//file to store the data is "tele1"
		try
		{
			DataOutputStream obj=new DataOutputStream(new
				BufferedOutputStream(new FileOutputStream("tele1",true)));
			// if true is given then it opens the file in "append" mode
			// if true is not given then the file is opened in "output" mode
			System.out.print("Enter telephne no ");
			teleno=br.readLine();
            System.out.print("Enter first name ");
			fname=br.readLine();
            System.out.print("Enter last name ");
			lname=br.readLine();
            System.out.print("Enter street name ");
			street=br.readLine();
            System.out.print("Enter city name ");
			city=br.readLine();
            System.out.print("Enter state name ");
			state=br.readLine();
			System.out.print("Enter country name ");
			country=br.readLine();
            System.out.print("Enter pincode name ");
			pincode=br.readLine();
			obj.writeUTF(teleno); //teleno
            obj.writeUTF(fname);//name
            obj.writeUTF(lname);//name
            obj.writeUTF(street);//name
            obj.writeUTF(city);//name
            obj.writeUTF(state);//name
            obj.writeUTF(country);//name
            obj.writeUTF(pincode);//name
		    obj.close();
		}
		catch(Exception e)
		{
			System.out.println("Error : "+e);
		}
	}


		/*Read Student Record One By One **********/

	void read()
	{
		char ch;
		try
		{
			DataInputStream in=new DataInputStream(new BufferedInputStream
			(new FileInputStream("tele1")));

			System.out.println("Student detials are from file stud");
			System.out.println();
			do
			{
				teleno=in.readUTF();
				
                fname=in.readUTF();
                lname=in.readUTF();
                street=in.readUTF();
                city=in.readUTF();
                state=in.readUTF();
                country=in.readUTF();
                pincode=in.readUTF();
                //s->small case S -> Upper case

				System.out.println("TelePhone No " + teleno);
				System.out.println("First Name " +fname);
				System.out.println("Last Name " +lname);
				System.out.println("Street  " +lname);
				System.out.println("City  " +lname);
				System.out.println("State " +lname);
				System.out.println("Country " +lname);
				System.out.println("Pincode " +lname);
				System.out.print("Like to read more (y/n) : ");
				ch=br.readLine().charAt(0);
			}while(ch=='y' || ch=='Y');
			in.close();
		}
		catch(EOFException e)
		{
		System.out.println("End of file reached");
		}
		catch(Exception e)
		{
			System.out.println("Error : "+e);
		}
	}


		/*Display All Student Records **********/

	void disp_all()
		{
			char ch;
			try
			{
				DataInputStream in=new DataInputStream(new
					BufferedInputStream(new FileInputStream("tele1")));
			System.out.println("Telephone Records");
			//s->small case S -> Upper case
			    System.out.println("=========================================================================================");
				//System.out.println("Teleno    Fname    Lname    Street     City     State     Country     Pincode");
				System.out.printf("%10S %10S %10S %10S %10S %10S %10S %10S","Teleno","Fname","Lname","Street","City","State","Country","Pincode");
				System.out.println("\n========================================================================================");
				System.out.println();
				while(true)
				{
				teleno=in.readUTF();
                fname=in.readUTF();
                lname=in.readUTF();
                street=in.readUTF();
                city=in.readUTF();
                state=in.readUTF();

                country=in.readUTF();
                pincode=in.readUTF();
				//System.out.println( teleno+ "       " + fname + "         "+lname+"       "+street+"       "+city+"       "+state+"          "+country+"        "+pincode );
				//+ => right justified
				//- => left justified
				System.out.printf("\n%10S %10S %10S %10S %10S %10S %10S %10S",teleno,fname,lname,street,city,state,country,pincode);
				}
			//	in.close();
			}
			catch(EOFException e)
			{
				System.out.println("\n========================================================================================");
			System.out.println("End of file reached");
			}
			catch(Exception e)
			{
				System.out.println("Error : "+e);
			}
	}

	/* 
		################  Seaerching By Telephone Number ##################
	*/


	void search_telephoneno()
		{
			Scanner sc=new Scanner(System.in);
			boolean z=false;
			try
			{
				DataInputStream in=new DataInputStream(new
					BufferedInputStream(new FileInputStream("tele1")));
				System.out.printf("%30S","Searching By Telephone Nubmer");
				System.out.print("\n\nEnter telephone no to search ");
				String tno=sc.next();
				System.out.println("Telephone Records");
				//s->small case S -> Upper case
			    System.out.println("=========================================================================================");
				//System.out.println("Teleno    Fname    Lname    Street     City     State     Country     Pincode");
				System.out.printf("%10S %10S %10S %10S %10S %10S %10S %10S","Teleno","Fname","Lname","Street","City","State","Country","Pincode");
				System.out.println("\n========================================================================================");
				System.out.println();
				while(true)
				{
				teleno=in.readUTF();
                fname=in.readUTF();
                lname=in.readUTF();
                street=in.readUTF();
                city=in.readUTF();
                state=in.readUTF();

                country=in.readUTF();
                pincode=in.readUTF();
				//System.out.println( teleno+ "       " + fname + "         "+lname+"       "+street+"       "+city+"       "+state+"          "+country+"        "+pincode );
				//+ => right justified
				//- => left justified
				if (teleno.equalsIgnoreCase(tno))
				{
					z=true;
					System.out.printf("\n%10S %10S %10S %10S %10S %10S %10S %10S",
						teleno,fname,lname,street,city,state,country,pincode);
				}
				
				}
			//	in.close();
			}
			catch(EOFException e)
			{
				System.out.println("\n========================================================================================");
			if (z==false)
			{
				System.out.println("Record not Found");
			}
			System.out.println("End of file reached");
			}
			catch(Exception e)
			{
				System.out.println("Error : "+e);
			}
	}

	// ####################################


	/* 
		################  Seaerching By First Name ##################
	*/


	void search_firstname()
		{
			Scanner sc=new Scanner(System.in);
			boolean z=false;
			try
			{
				DataInputStream in=new DataInputStream(new
					BufferedInputStream(new FileInputStream("tele1")));
				System.out.printf("%30S","Searching By First Name");
				System.out.print("\n\nEnter First Name to search ");
				String n=sc.next();
				System.out.println("Telephone Records");
				//s->small case S -> Upper case
			    System.out.println("=========================================================================================");
				//System.out.println("Teleno    Fname    Lname    Street     City     State     Country     Pincode");
				System.out.printf("%10S %10S %10S %10S %10S %10S %10S %10S","Teleno","Fname","Lname","Street","City","State","Country","Pincode");
				System.out.println("\n========================================================================================");
				System.out.println();
				while(true)
				{
				teleno=in.readUTF();
                fname=in.readUTF();
                lname=in.readUTF();
                street=in.readUTF();
                city=in.readUTF();
                state=in.readUTF();

                country=in.readUTF();
                pincode=in.readUTF();
				//System.out.println( teleno+ "       " + fname + "         "+lname+"       "+street+"       "+city+"       "+state+"          "+country+"        "+pincode );
				//+ => right justified
				//- => left justified
				if (fname.equalsIgnoreCase(n))
				{
					z=true;
					System.out.printf("\n%10S %10S %10S %10S %10S %10S %10S %10S",
						teleno,fname,lname,street,city,state,country,pincode);
				}
				
				}
			//	in.close();
			}
			catch(EOFException e)
			{
				System.out.println("\n========================================================================================");
			if (z==false)
			{
				System.out.println("Record not Found");
			}
			System.out.println("End of file reached");
			}
			catch(Exception e)
			{
				System.out.println("Error : "+e);
			}
	}

	// ####################################

	/* 
		################  Seaerching By Last Name ##################
	*/


	void search_lastname()
		{
			Scanner sc=new Scanner(System.in);
			boolean z=false;
			try
			{
				DataInputStream in=new DataInputStream(new
					BufferedInputStream(new FileInputStream("tele1")));
				System.out.printf("%30S","Searching By Last Name");
				System.out.print("\n\nEnter Last Name to search ");
				String n=sc.next();
				System.out.println("Telephone Records");
				//s->small case S -> Upper case
			    System.out.println("=========================================================================================");
				//System.out.println("Teleno    Fname    Lname    Street     City     State     Country     Pincode");
				System.out.printf("%10S %10S %10S %10S %10S %10S %10S %10S","Teleno","Fname","Lname","Street","City","State","Country","Pincode");
				System.out.println("\n========================================================================================");
				System.out.println();
				while(true)
				{
				teleno=in.readUTF();
                fname=in.readUTF();
                lname=in.readUTF();
                street=in.readUTF();
                city=in.readUTF();
                state=in.readUTF();

                country=in.readUTF();
                pincode=in.readUTF();
				//System.out.println( teleno+ "       " + fname + "         "+lname+"       "+street+"       "+city+"       "+state+"          "+country+"        "+pincode );
				//+ => right justified
				//- => left justified
				if (lname.equalsIgnoreCase(n))
				{
					z=true;
					System.out.printf("\n%10S %10S %10S %10S %10S %10S %10S %10S",
						teleno,fname,lname,street,city,state,country,pincode);
				}
				
				}
			//	in.close();
			}
			catch(EOFException e)
			{
				System.out.println("\n========================================================================================");
			if (z==false)
			{
				System.out.println("Record not Found");
			}
			System.out.println("End of file reached");
			}
			catch(Exception e)
			{
				System.out.println("Error : "+e);
			}
	}

	// ####################################

	/* 
		################  Seaerching By Street Name ##################
	*/


	void search_street()
		{
			Scanner sc=new Scanner(System.in);
			boolean z=false;
			try
			{
				DataInputStream in=new DataInputStream(new
					BufferedInputStream(new FileInputStream("tele1")));
				System.out.printf("%30S","Searching By Street Name");
				System.out.print("\n\nEnter Street Name to search ");
				String n=sc.next();
				System.out.println("Telephone Records");
				//s->small case S -> Upper case
			    System.out.println("=========================================================================================");
				//System.out.println("Teleno    Fname    Lname    Street     City     State     Country     Pincode");
				System.out.printf("%10S %10S %10S %10S %10S %10S %10S %10S","Teleno","Fname","Lname","Street","City","State","Country","Pincode");
				System.out.println("\n========================================================================================");
				System.out.println();
				while(true)
				{
				teleno=in.readUTF();
                fname=in.readUTF();
                lname=in.readUTF();
                street=in.readUTF();
                city=in.readUTF();
                state=in.readUTF();

                country=in.readUTF();
                pincode=in.readUTF();
				//System.out.println( teleno+ "       " + fname + "         "+lname+"       "+street+"       "+city+"       "+state+"          "+country+"        "+pincode );
				//+ => right justified
				//- => left justified
				if (street.equalsIgnoreCase(n))
				{
					z=true;
					System.out.printf("\n%10S %10S %10S %10S %10S %10S %10S %10S",
						teleno,fname,lname,street,city,state,country,pincode);
				}
				
				}
			//	in.close();
			}
			catch(EOFException e)
			{
				System.out.println("\n========================================================================================");
			if (z==false)
			{
				System.out.println("Record not Found");
			}
			System.out.println("End of file reached");
			}
			catch(Exception e)
			{
				System.out.println("Error : "+e);
			}
	}

	// ####################################


	/* 
		################  Seaerching By City Name ##################
	*/


	void search_city()
		{
			Scanner sc=new Scanner(System.in);
			boolean z=false;
			try
			{
				DataInputStream in=new DataInputStream(new
					BufferedInputStream(new FileInputStream("tele1")));
				System.out.printf("%30S","Searching By City Name");
				System.out.print("\n\nEnter City Name to search ");
				String n=sc.next();
				System.out.println("Telephone Records");
				//s->small case S -> Upper case
			    System.out.println("=========================================================================================");
				//System.out.println("Teleno    Fname    Lname    Street     City     State     Country     Pincode");
				System.out.printf("%10S %10S %10S %10S %10S %10S %10S %10S","Teleno","Fname","Lname","Street","City","State","Country","Pincode");
				System.out.println("\n========================================================================================");
				System.out.println();
				while(true)
				{
				teleno=in.readUTF();
                fname=in.readUTF();
                lname=in.readUTF();
                street=in.readUTF();
                city=in.readUTF();
                state=in.readUTF();

                country=in.readUTF();
                pincode=in.readUTF();
				//System.out.println( teleno+ "       " + fname + "         "+lname+"       "+street+"       "+city+"       "+state+"          "+country+"        "+pincode );
				//+ => right justified
				//- => left justified
				if (city.equalsIgnoreCase(n))
				{
					z=true;
					System.out.printf("\n%10S %10S %10S %10S %10S %10S %10S %10S",
						teleno,fname,lname,street,city,state,country,pincode);
				}
				
				}
			//	in.close();
			}
			catch(EOFException e)
			{
				System.out.println("\n========================================================================================");
			if (z==false)
			{
				System.out.println("Record not Found");
			}
			System.out.println("End of file reached");
			}
			catch(Exception e)
			{
				System.out.println("Error : "+e);
			}
	}

	// ####################################


	/* 
		################  Seaerching By State Name ##################
	*/


	void search_state()
		{
			Scanner sc=new Scanner(System.in);
			boolean z=false;
			try
			{
				DataInputStream in=new DataInputStream(new
					BufferedInputStream(new FileInputStream("tele1")));
				System.out.printf("%30S","Searching By State Name");
				System.out.print("\n\nEnter State Name to search ");
				String n=sc.next();
				System.out.println("Telephone Records");
				//s->small case S -> Upper case
			    System.out.println("=========================================================================================");
				//System.out.println("Teleno    Fname    Lname    Street     City     State     Country     Pincode");
				System.out.printf("%10S %10S %10S %10S %10S %10S %10S %10S","Teleno","Fname","Lname","Street","City","State","Country","Pincode");
				System.out.println("\n========================================================================================");
				System.out.println();
				while(true)
				{
					teleno=in.readUTF();
	                fname=in.readUTF();
	                lname=in.readUTF();
	                street=in.readUTF();
	                city=in.readUTF();
	                state=in.readUTF();

	                country=in.readUTF();
	                pincode=in.readUTF();
					//System.out.println( teleno+ "       " + fname + "         "+lname+"       "+street+"       "+city+"       "+state+"          "+country+"        "+pincode );
					//+ => right justified
					//- => left justified
					if (state.equalsIgnoreCase(n))
					{
						z=true;
						System.out.printf("\n%10S %10S %10S %10S %10S %10S %10S %10S",
							teleno,fname,lname,street,city,state,country,pincode);
					}
				
				}
			//	in.close();
			}
			catch(EOFException e)
			{
				System.out.println("\n========================================================================================");
			if (z==false)
			{
				System.out.println("Record not Found");
			}
			System.out.println("End of file reached");
			}
			catch(Exception e)
			{
				System.out.println("Error : "+e);
			}
	}

	// ####################################


	/* 
		################  Seaerching By Country Name ##################
	*/


	void search_country()
		{
			Scanner sc=new Scanner(System.in);
			boolean z=false;
			try
			{
				DataInputStream in=new DataInputStream(new
					BufferedInputStream(new FileInputStream("tele1")));
				System.out.printf("%30S","Searching By Country Name");
				System.out.print("\n\nEnter Country Name to search ");
				String n=sc.next();
				System.out.println("Telephone Records");
				//s->small case S -> Upper case
			    System.out.println("=========================================================================================");
				//System.out.println("Teleno    Fname    Lname    Street     City     State     Country     Pincode");
				System.out.printf("%10S %10S %10S %10S %10S %10S %10S %10S","Teleno","Fname","Lname","Street","City","State","Country","Pincode");
				System.out.println("\n========================================================================================");
				System.out.println();
				while(true)
				{
					teleno=in.readUTF();
	                fname=in.readUTF();
	                lname=in.readUTF();
	                street=in.readUTF();
	                city=in.readUTF();
	                state=in.readUTF();

	                country=in.readUTF();
	                pincode=in.readUTF();
					//System.out.println( teleno+ "       " + fname + "         "+lname+"       "+street+"       "+city+"       "+state+"          "+country+"        "+pincode );
					//+ => right justified
					//- => left justified
					if (country.equalsIgnoreCase(n))
					{
						z=true;
						System.out.printf("\n%10S %10S %10S %10S %10S %10S %10S %10S",
							teleno,fname,lname,street,city,state,country,pincode);
					}
				
				}
			//	in.close();
			}
			catch(EOFException e)
			{
				System.out.println("\n========================================================================================");
			if (z==false)
			{
				System.out.println("Record not Found");
			}
			System.out.println("End of file reached");
			}
			catch(Exception e)
			{
				System.out.println("Error : "+e);
			}
	}

	// ####################################


	/* 
		################  Seaerching By Country Name ##################
	*/


	void search_pincode()
		{
			Scanner sc=new Scanner(System.in);
			boolean z=false;
			try
			{
				DataInputStream in=new DataInputStream(new
					BufferedInputStream(new FileInputStream("tele1")));
				System.out.printf("%30S","Searching By Pincode Name");
				System.out.print("\n\nEnter Pincode Name to search ");
				String n=sc.next();
				System.out.println("Telephone Records");
				//s->small case S -> Upper case
			    System.out.println("=========================================================================================");
				//System.out.println("Teleno    Fname    Lname    Street     City     State     Country     Pincode");
				System.out.printf("%10S %10S %10S %10S %10S %10S %10S %10S","Teleno","Fname","Lname","Street","City","State","Country","Pincode");
				System.out.println("\n========================================================================================");
				System.out.println();
				while(true)
				{
					teleno=in.readUTF();
	                fname=in.readUTF();
	                lname=in.readUTF();
	                street=in.readUTF();
	                city=in.readUTF();
	                state=in.readUTF();

	                country=in.readUTF();
	                pincode=in.readUTF();
					//System.out.println( teleno+ "       " + fname + "         "+lname+"       "+street+"       "+city+"       "+state+"          "+country+"        "+pincode );
					//+ => right justified
					//- => left justified
					if (pincode.equalsIgnoreCase(n))
					{
						z=true;
						System.out.printf("\n%10S %10S %10S %10S %10S %10S %10S %10S",
							teleno,fname,lname,street,city,state,country,pincode);
					}
				
				}
			//	in.close();
			}
			catch(EOFException e)
			{
				System.out.println("\n========================================================================================");
			if (z==false)
			{
				System.out.println("Record not Found");
			}
			System.out.println("End of file reached");
			}
			catch(Exception e)
			{
				System.out.println("Error : "+e);
			}
	}

	// ####################################

    public static void main(String[] args)
	{
		P3 f=new P3();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int op=0;
		try
		{
			while(true)
			{
				//s->small case S -> Upper case
				System.out.printf("\n%30s %-50S"," ","main Menu");
				System.out.printf("\n%30s %-50s"," ","==========");
				System.out.printf("\n%30s %-50S"," ","1. Add Record ");
				System.out.printf("\n%30s %-50S"," ","2. Display records one by one");
				System.out.printf("\n%30s %-50S"," ","3. Display All record");
				System.out.printf("\n%30s %-50S"," ","4. Search by Telephone no");
				System.out.printf("\n%30s %-50S"," ","5. Search by First Name");
				System.out.printf("\n%30s %-50S"," ","6. Search by Last Name");
				System.out.printf("\n%30s %-50S"," ","7. Search by Street");
				System.out.printf("\n%30s %-50S"," ","8. Search by City");
				System.out.printf("\n%30s %-50S"," ","9. Search by State");
				System.out.printf("\n%30s %-50S"," ","10. Search by Country");
				System.out.printf("\n%30s %-50S"," ","11. Search by Pincode");
				System.out.printf("\n%30s %-50S"," ","12. Exit");
				System.out.printf("\n%30s %-50S"," ","Enter your choice  ");

				op=Integer.parseInt(br.readLine());
				switch(op)
				{
					case 1:
						f.write();
						break;
					case 2:
						f.read();
						break;
					case 3:
						f.disp_all();
						break;
					case 4:
					 	f.search_telephoneno();
					 	break;
					case 5:
					 	f.search_firstname();
					 	break;
					case 6:
					 	f.search_lastname();
					 	break;
					case 7:
					 	f.search_street();
					 	break;
					case 8:
					 	f.search_city();
					 	break;
					case 9:
					 	f.search_state();
					 	break;
					case 10:
					 	f.search_country();
					 	break;

					case 11:
					 	f.search_pincode();
					 	break;

					case 12:
						System.out.println("end of program");
						return;
					default:
						System.out.println("Invalid choice");
						break;
				}//switch
			}//while
		}//try
		catch(Exception e){}
	}//main
    
}