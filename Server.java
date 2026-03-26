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

class Server
{
    public static void main(String A[])throws Exception
    {
        ServerSocket ssobj = new ServerSocket(5100);
        System.out.println("Server is Waiting at Port no 5100");

        Socket sobj = ssobj.accept();

        System.out.println("Server Successfully connected with client");

        PrintStream pobj = new PrintStream(sobj.getOutputStream());

        BufferedReader bobj1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));

        BufferedReader bobj2 = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("--------------------------------------------------------------------");
        System.out.println("-------------------Server Messenger ready to Chat-------------------");
        System.out.println("--------------------------------------------------------------------");

        String str1 = null,str2 = null;
        while((str1 = bobj1.readLine()) != null )
        {
            System.out.println("Client Say: "+str1);

            System.out.println("Enter msg for Client:");

            str2 = bobj2.readLine();
            pobj.println(str2);
        }
    }
}
