
package projdb;

import java.util.Scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.io.*;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;


public class another {
    
 public static void main(String[] args) {
        Scanner input = new Scanner(System.in);   
    
Connection myconObj=null;
		Statement mystatObj=null;
		ResultSet myresObj=null;

		try
		{//start try
		myconObj=DriverManager.getConnection("jdbc:mysql://localhost:3306/fit","root","");
		mystatObj=myconObj.createStatement();
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		char resultt2;
		char resultt;
		char resultt3;
   
	do {
		System.out.println("Welcome to our GYMMERS :");
		System.out.println("Please choose a table");
		System.out.println("1) branch");
		System.out.println("2) member");
		System.out.println("3) Exit");
		System.out.println("Enter Your Choice = ");
		
		resultt = input.next().charAt(0);
		
		switch(resultt) {
		
		case '1':
			do {
			System.out.println("Branch Table");	
			System.out.println("1) Insert new branch");	
			System.out.println("2) Delete a branch");	
			System.out.println("3) Update a branch");	
			System.out.println("4) Exit");	
			 resultt2 = input.next().charAt(0);
			switch(resultt2) {
			case '1':
				//branch insert
				try{
				boolean isTrue=true;
				do{
				System.out.println("branch information:");
				
				System.out.println("ENTER  city:");
                            // String city=input.next();
                               String city ;
            while(true){
               city= input.next();
               if(isValidnate(city))
               break; 
               else
               System.out.println("Enter name just without number!!");}
            
				System.out.println("ENTER location: ");
				//String location =input.next();
                                 String location ;
            while(true){
               location= input.next();
               if(isValidnate(location))
               break; 
               else
               System.out.println("Enter location just without number!!");}
                                
				System.out.println("Enter Branch phone number:");
            int Bphone;
				String temp ;
                  while(true){
     					temp=input.next();
                  try{
                  Bphone=Integer.parseInt(temp);
                  break;}
                  catch(Exception e){
                  System.out.println("Try again! Numbers only");}}
                  
               
             
            System.out.println("ENTER BranchID:");
                                      int BranchID;
        
	
                  while(true){
     					temp=input.next();
                  try{
                  BranchID=Integer.parseInt(temp);
                  break;}
                  catch(Exception e){
                  System.out.println("Try again! Numbers only");}}
				
                                
                                boolean forpk = true;
				  while (forpk) {
				     if (BranchID== 0) {
                 System.out.println("this is primary key can not be null, try again!!"); 
                  while(true){
     					temp=input.next();
                  try{
                  BranchID=Integer.parseInt(temp);
                  break;}
                  catch(Exception e){
                  System.out.println("Try again! Numbers only");}}}
				      forpk = false; } //check pk not

                                    
				String count ="INSERT INTO branch  VALUES(" + BranchID+ ",'" + city +
				"','" + location + "'," + Bphone+")";
     				int count2 = mystatObj.executeUpdate(count);
                              
                                if (count2==0) {
					System.out.print("This insert didn't execute");
					}
                                
				System.out.println(count2 + "Number of row(s) inserted into branch table");
				
                                System.out.println("Do you want to insert new branch row( Y | N)?");
                                 char answer = input.next().charAt(0);
				if (answer == ('n') || answer == ('N')) {
				isTrue = false;
				break;
				}
				//firstwhile
				}while(isTrue);
				}//catch (SQLException e) {
				//System.out.print("Already exists try agin ");
				//}
                                catch(Exception e){

				System.out.println(e.getMessage());}
				break;
				
			case '2':
				boolean deleteB=true;
				try{
				while (deleteB){
				System.out.println("Enter branchId you want to be deleted: ");
				int branchi;
				String temp ;
                  while(true){
     					temp=input.next();
                  try{
                  branchi=Integer.parseInt(temp);
                  break;}
                  catch(Exception e){
                  System.out.println("Try again! Numbers only");}}
				int deletion1=mystatObj.executeUpdate("delete from branch where BranchID = "+branchi);
				if(deletion1==0){				
				System.out.println("This BranchID dosen't exist");				
				}
				else{
				System.out.println(deletion1+" Branch deleted successfully");}
                                
				System.out.println("Do you want to delete another branch (Y | N)? ");
				char choice2=input.next().charAt(0);
            if (choice2 == 'n' || choice2 == 'N') {
            deleteB = false; }
           else if(choice2 == 'y' || choice2 == 'Y')
            deleteB = true;
                            //    else
                              //   System.out.println("invalid just enter yes or no");       
				}//end while
				}// end try
				
                                catch(Exception e){

				System.out.println(e.getMessage());}//end Exception
				
				 break;
				
				 
					
			case '3':
				//update branch

					try {
					boolean ub=true ;
					do {
					System.out.println("Enter the branchID that you want to update ") ;
					int branciD;
               String temp ;
                  while(true){
     					temp=input.next();
                  try{
                  branciD=Integer.parseInt(temp);
                  break;}
                  catch(Exception e){
                  System.out.println("Try again! Numbers only");}}
					System.out.println("what do you want to update?\n1.branchID\n2.city\n3.location\n4.Bphone number") ;
               char br1 = input.next().charAt(0) ;
					/*int br1;
				String temp ;
                  while(true){
     					temp=input.next();
                  try{
                  br1=Integer.parseInt(temp);
                  break;}
                  catch(Exception e){
                  System.out.println("Try again! Numbers only");}}*/
					switch (br1) {
                            
					case '1': //branchiD
					System.out.println("Enter the New Branch Id") ;
					int b;
				
                  while(true){
     					temp=input.next();
                  try{
                  b=Integer.parseInt(temp);
                  break;}
                  catch(Exception e){
                  System.out.println("Try again! Numbers only");}}
					
                              
                                        
                                        Statement st22= myconObj.createStatement();
					int num22 =st22.executeUpdate("UPDATE branch SET BranchID="+b+" WHERE BranchID= "+branciD);
					
                                        if(num22==0){
					System.out.println("Can NOT find this Branch Id ");}
                                        else{
					System.out.println(num22+" Branch ID(s) update");}
					
                                        break; 
                                        
                                        
					case '2': //city
					System.out.println("Enter the New Branch city") ;
					//String cit = input.next() ;
                                       
				//String location =input.next();
                                 String cit ;
            while(true){
               cit= input.next();
               if(isValidnate(cit))
               break; 
               else
               System.out.println("Enter city just without number!!");}
            
            
					//mystatObj=myconObj.createStatement(); 
					String ub4 = ("UPDATE branch SET city= '" + cit +"'WHERE BranchID= "+branciD );
					int count4 = mystatObj.executeUpdate(ub4) ;
					if (count4 == 0)
					System.out.println("This BranchID is not exist") ;
					else
					System.out.println(count4 + " Branch city is  updated") ;
					break ;


					
               case '3': //location
					System.out.println("Enter the New Branch location") ;
				//	String locatio = input.next() ;
                                       
		                                String locatio ;
            while(true){
               locatio= input.next();
               if(isValidnate(locatio))
               break; 
               else
               System.out.println("Enter location just without number!!");}
                                        
					//mystatObj=myconObj.createStatement();
                                        
					String ub7 = ("UPDATE branch SET location= '" + locatio +"'WHERE BranchID= "+branciD );
					int count8 = mystatObj.executeUpdate(ub7) ;
					if (count8 == 0)
					System.out.println("This BranchID is not exist") ;
					else
					System.out.println(count8 + "  Branch location is  updated") ;
					break ;
					////////////////////////////
					case '4'://update Branch phone

					System.out.println("Entert the New Branch phone ");
					//int  Branch_phone = input.nextInt();
					int  Branch_phone;
				
                  while(true){
     					temp=input.next();
                  try{
                  Branch_phone=Integer.parseInt(temp);
                  break;}
                  catch(Exception e){
                  System.out.println("Try again! Numbers only");}}
                                        
                                        
                                        
					Statement st1= myconObj.createStatement();
					int num4 =st1.executeUpdate("UPDATE branch SET BPhone=  "+Branch_phone+" WHERE BranchID="+branciD);
					if(num4==0)
					System.out.println("Can NOT find this Branch ID ");
					else
					System.out.println(num4+" Branch phone is update");
					break;
					default :
						System.out.println("Invalid choice") ;
					}//end switch
					
					System.out.println("Update another new record?(yes/no)") ;
               char c=input.next().charAt(0);
            if (c == 'n' || c == 'N') {
            ub = false; }
           else if(c == 'y' || c == 'Y')
            ub = true;
            
             					} while (ub);
					}//end try
					catch (Exception ex){
						System.out.println(ex.getMessage());
						}
				
				break;
				
			default:
				System.out.println("Try again! 1,2,3 or 4 only");
			}
			
			
	
		}while(resultt2!='4');
		
		
	break;
	                   ////////////////////////////////////////////////other table	
		case '2':
			 do {
			System.out.println("Member Table");	
			System.out.println("1) Insert new member");	
			System.out.println("2) Delete a member");	
			System.out.println("3) Update a member");	
			System.out.println("4) Exit");	
			resultt3 = input.next().charAt(0);
			switch(resultt3) {
			case '1':
				//member insert
				try{
				boolean isTrue=true;
				do{
				System.out.println("member information:");
				System.out.println("ENTER member ID:");
            int ID;
				String temp ;
                  while(true){
     					temp=input.next();
                  try{
                  ID=Integer.parseInt(temp);
                  break;}
                  catch(Exception e){
                  System.out.println("Try again! Numbers only");}}
                                
            boolean forpkM = true;
				   while (forpkM) {
				     if (ID== 0) {
                 System.out.println("This is primary key can not be null,try again!!"); 
                ID=input.nextInt();}
				      forpkM = false; } //check pk not

                            
               
				System.out.println("ENTER MBranchID :");
				int MBranchID;
            
                  while(true){
     					temp=input.next();
                  try{
                  MBranchID=Integer.parseInt(temp);
                  break;}
                  catch(Exception e){
                  System.out.println("Try again! Numbers only");}}
				System.out.println("ENTER DOB date of birh:");
				String DOB;
            
             while(true){
               DOB= input.next();
               if(isValidDate(DOB))
               break; 
               else
               System.out.println("Enter DOB in correct format dd/MM/yyyy and in domain");}
				//////////////
            
            System.out.println("ENTER name:");
				//String name = input.next();
            String name ;
            while(true){
               name= input.next();
               if(isValidnate(name))
               break; 
               else
               System.out.println("Enter name just whithout number!!");}

            ////////////////////////
                                System.out.println("Enter phone ");     
                                
				int Phone_num;
         
                  while(true){
     					temp=input.next();
                  try{
                  Phone_num=Integer.parseInt(temp);
                  break;}
                  catch(Exception e){
                  System.out.println("Try again! Numbers only");}}
                                System.out.println("ENTER weight:");
				int weight;
            
                  while(true){
     					temp=input.next();
                  try{
                  weight=Integer.parseInt(temp);
                  break;}
                  catch(Exception e){
                  System.out.println("Try again! Numbers only");}}
                                System.out.println("ENTER height:");
				int  height;
            
                  while(true){
     					temp=input.next();
                  try{
                  height=Integer.parseInt(temp);
                  break;}
                  catch(Exception e){
                  System.out.println("Try again! Numbers only");}}
				
				String count ="INSERT INTO member VALUES(" + ID + "," + MBranchID +
				",'" + DOB + "','" + name+ "',"+Phone_num+","+weight+","+height+")";
				int count2 = mystatObj.executeUpdate(count);
				
				if (count2==0) {
					System.out.print("This insert didn't excute");
					}
				System.out.println(count2 + " Number of row(s) inserted into member table");
				System.out.println("Do you want to insert new recored ( Y | N)?");
				char answer = input.next().charAt(0);
				if (answer == ('n') || answer == ('N')) {
				isTrue = false;
				break;

				

				}

				//firstwhile
				}while(isTrue);
				}//catch (SQLException e) {
				//System.out.print("Already exists try agin ");
			//	}
                                catch(Exception e){

				System.out.println(e.getMessage());}
                                
                                
				break;
				
			case '2':
				
				// delete Branch
				boolean db = true;
				try {
				while (db) {
				System.out.println("Please Enter member Id that you want to delete");
				int idm;
            String temp ;
                  while(true){
     					temp=input.next();
                  try{
                  idm=Integer.parseInt(temp);
                  break;}
                  catch(Exception e){
                  System.out.println("Try again! Numbers only");}}
				int countD = mystatObj.executeUpdate("delete from member where ID = " + idm);
				if (countD == 0) {
				System.out.println("This ID member doesnt exist!"); }//end if
				else { System.out.println(countD + " Member deleted successfully"); }
				System.out.println("Delete another record ( Y | N ) ?");
				char x = input.next().charAt(0);
				if (x == 'n' || x == 'N') {
				db = false; }
				else if(x == 'y' || x == 'Y')
				db = true;
				else
				System.out.println("invalid input");//end if
				} //end while
				}//end try
				catch (Exception ex){
						System.out.println(ex.getMessage());
						}
				break;
			case '3': //update member
				try{
					boolean upm = false;
					do{
					System.out.println("Enter the member id that you want to update");
					int Mid;
               String temp ;
                  while(true){
     					temp=input.next();
                  try{
                  Mid=Integer.parseInt(temp);
                  break;}
                  catch(Exception e){
                  System.out.println("Try again! Numbers only");}}
					System.out.println("What do you want to update in member?");
					System.out.println("1 - member Id");
					System.out.println("2 - member MBranchId ");
					System.out.println("3 - member DOB");
					System.out.println("4 - member  name");
					System.out.println("5 - member  phone number");
               System.out.println("6 - member  weight");
               System.out.println("7 - member  height");
					char choice_3= input.next().charAt(0);
					switch(choice_3){
					case '1'://update member id
					System.out.println("Entert the New member ID");
					int iidM;
                
                  while(true){
     					temp=input.next();
                  try{
                  iidM=Integer.parseInt(temp);
                  break;}
                  catch(Exception e){
                  System.out.println("Try again! Numbers only");}}
					//Statement st= myconObj.createStatement();
					String um3 = "UPDATE memebr  SET ID= "+iidM+"WHERE ID="+Mid;
					int count3 = mystatObj.executeUpdate(um3) ;
					if(count3==0)
					System.out.println("Can NOT find this member Id ");
					else
					System.out.println(count3+" Member Id(s) update");
					break;
					
					case '2':// MBranchId

					System.out.println("Entert the New member  MBranchId ");
					int MB;
                
                  while(true){
     					temp=input.next();
                  try{
                  MB=Integer.parseInt(temp);
                  break;}
                  catch(Exception e){
                  System.out.println("Try again! Numbers only");}}
					String upModel="UPDATE member SET  MBranchID= "+MB+"  WHERE ID="+Mid;
					int num_2 =mystatObj.executeUpdate(upModel);
					if(num_2==0)
					System.out.println("Can NOT find this member id ");
					else
					System.out.println(num_2+" Member  MBranchID(s) update");
					break;
					case '3'://update DOB 

					System.out.println("Enter the New member DOB ");
					String DO;
               while(true){
               DO= input.next();
               if(isValidDate(DO)){
					//Statement st2= myconObj.createStatement();
                                        String u44="UPDATE member SET DOB='"+DO+"'WHERE ID="+Mid;
					int num_3 =mystatObj.executeUpdate(u44);
					if(num_3==0)
					System.out.println("Can NOT find this member id ");
					else
					System.out.println(num_3+" Branch birth of Daye (s) update");
               break; }
               else
               System.out.println("Enter DOB in correct format dd/MM/yyyy and in domain");
               }
					break;
					case '4'://name

					System.out.println("Enter the New member  name ");
					//String nameM = input.next();
                                 String nameM ;
            while(true){
              nameM= input.next();
               if(isValidnate(nameM))
               break; 
               else
               System.out.println("Enter name just without number!!");}
                                        
                                        
                                        
                                        
					mystatObj=myconObj.createStatement();
					String upp ="UPDATE member SET name= '"+nameM+"'WHERE ID="+Mid;
					int num_4=mystatObj.executeUpdate(upp);
                                        if(num_4==0)
					System.out.println("Can NOT find this memberID ");
					else
					System.out.println(num_4+" Member name update");
					break;
              case '5':// phone
					System.out.println("Enter the New member  phone number");
					int ph;
               
                  while(true){
     					temp=input.next();
                  try{
                  ph=Integer.parseInt(temp);
                  break;}
                  catch(Exception e){
                  System.out.println("Try again! Numbers only");}}
					String upModel11="UPDATE member SET Phone_num = "+ph+"  WHERE ID="+Mid;
					int num17 =mystatObj.executeUpdate(upModel11);
					if(num17==0)
					System.out.println("Can NOT find this member id ");
					else
					System.out.println(num17+" Member  phone(s) update");
					break;
              
              case '6':// weight
					System.out.println("Enter the New member  weight");
					int w;
              
                  while(true){
     					temp=input.next();
                  try{
                  w=Integer.parseInt(temp);
                  break;}
                  catch(Exception e){
                  System.out.println("Try again! Numbers only");}}
					String upModel1="UPDATE member SET  weight= "+w+"  WHERE ID="+Mid;
					int num11 =mystatObj.executeUpdate(upModel1);
					if(num11==0)
					System.out.println("Can NOT find this member id ");
					else
					System.out.println(num11+" Member  weight(s) update");
					break;
                                        
               case '7':// height

					System.out.println("Enter the New member  height ");
					int h;
                
                  while(true){
     					temp=input.next();
                  try{
                  h=Integer.parseInt(temp);
                  break;}
                  catch(Exception e){
                  System.out.println("Try again! Numbers only");}}
					String upModel2="UPDATE member SET  height= "+h+"  WHERE ID="+Mid;
					int num21 =mystatObj.executeUpdate(upModel2);
					if(num21==0)
					System.out.println("Can NOT find this member id ");
					else
					System.out.println(num21+" Member  height(s) update");
					break;
                                        
                                        
					default:
						System.out.println("Wrong input");
						}
					
						System.out.println("Another update ( Y | N ) ?");
						char another=input.next().charAt(0);
						if(another=='y'||another=='Y')
						upm=true;
						if(another=='n'||another=='N')
						upm=false;

						}while(upm);

						}catch (Exception ex){
						System.out.println(ex.getMessage());
						}
                                
                                //catch (SQLException ex){
						//System.out.println(ex.getMessage());
						//}

						//catch (NumberFormatException ex){
						//System.out.println(ex.getMessage());
						//}
						

						case '4': //exit Branch
						break;
             
             default:
             System.out.println("Try again! 1,2,3 or 4 only");
						}
			
						}while (resultt3 != 4);
                  
                  case '3':
                  break;
                  
                  default:
                  System.out.println("Try again! 1,2 or 3 only");
			
			 
		}
			
			
		}while(resultt!=3);
    }
    
    
    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());}
        catch (ParseException pe) {
            return false;
        }
        return true;
    }
    
    
  
    public static boolean isValidnate(String iname) {
int len=iname.length();
for(int i=0 ; i<len ;i++){
if(Character.isDigit(iname.charAt(i))){
return false;
}
}
return true;
}
}
