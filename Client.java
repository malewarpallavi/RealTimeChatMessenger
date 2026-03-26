///////////////////////////////////////////////////////////////////////////////////////////////////////
/*
                        Program:      client Server Chat Messenger
                        Description:  Client send request to Server.client send messgaes to server.
                        Author:       Pallavi Omprakash Malewar
                        Date:         22/5/2025
*/
//////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;
import java.net.*;
import java.util.*;

class Client
{
    public static void main(String A[]) throws Exception 
    {
        System.out.println("Client is ready to Connect with Server........");

        Socket sobj = new Socket("localhost",5100);

        System.out.println("Client is Connected Successfully....");

        PrintStream pobj = new PrintStream(sobj.getOutputStream());

        BufferedReader bobj1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));

        BufferedReader bobj2 = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("--------------------------------------------------------------------");
        System.out.println("-------------------Client Messenger ready to Chat-------------------");
        System.out.println("--------------------------------------------------------------------");

        String str1 = null, str2 =  null;

        while(!(str1 = bobj2.readLine()).equals("end"))
        {
            pobj.println(str1);
            
            str2 = bobj2.readLine();
            System.out.println("Server say: "+str2);

            System.out.println("Enter Your Msg For Server:");
        }
    }
}
