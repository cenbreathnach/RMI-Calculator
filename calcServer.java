/**
Must be run from commandline/terminal. Compile with javac calcServer.java
Run with java calcServer


Server class for RMI Calculator assignmenet
Allows clients to call methods and returns correct answer to them
**/

import java.rmi.*;
import java.rmi.Naming.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;
import java.net.UnknownHostException;
import java.util.*;
import java.awt.*;
import java.net.InetAddress;

public class calcServer extends UnicastRemoteObject implements calcInterface
{
    //initializes server GUI
    public Frame serverGUI = new Frame("Server GUI"); 
    public TextArea serverConsole = new TextArea();


	public calcServer() throws RemoteException
	{
    
    serverGUI.setVisible(true);//makes gui visable
    serverGUI.setSize(300,300);//set size
    serverConsole.setBounds(30,240,250,110);
    serverConsole.setEditable(false);//uneditable text area
    serverGUI.add(serverConsole);
    serverConsole.append("\nStarting Server...");
    }

    /**
    Returns a+b & adds content to servers gui
    **/
    public int add(int a,int b, int clientNo)
    {
      
    	try {
			serverConsole.append("\nRecieved "+ a + "+" + b + " from client number " +clientNo+ " @ " + InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
    	 serverConsole.append("\nComputing....");
    	serverConsole.append("\nSending result back to the client!");
    	return(a+b);

	}
   /**
    Returns a-b & adds content to servers gui
    **/
	public int subt(int a,int b, int clientNo)
	{
  try {
      serverConsole.append("\nRecieved "+ a + "-" + b + " from client number " +clientNo+ " @ " + InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }    
    	serverConsole.append("\nComputing....");
    	serverConsole.append("\nSending result back to the client!");
			return(a-b);
	}
   /**
    Returns a*b & adds content to servers gui
    **/
	public int mult(int a,int b, int clientNo)
	{
  try {
      serverConsole.append("\nRecieved "+ a + "*" + b + " from client number " +clientNo+ " @ " + InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }    	 serverConsole.append("\nComputing....");
    	serverConsole.append("\nSending result back to the client!");
			return(a*b);
	}
   /**
    Returns a/b & adds content to servers gui
    **/
	public int div(int a,int b, int clientNo)
	{
    try {
      serverConsole.append("\nRecieved "+ a + "/" + b + " from client number " +clientNo+ " @ " + InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
    	serverConsole.append("\nComputing....");
    	serverConsole.append("\nSending result back to the client!");
			return(a/b);
	}
   /**
   Creates new calcServer
    **/
	public static void main(String args[])
	{
		try
		{
		calcServer cs=new calcServer();
		java.rmi.Naming.rebind("calcServer",cs);
		System.out.println("Calc Server Ready");
	 }
	    catch(RemoteException RE)
	    {
			System.out.println("Remote Server Error:"+ RE.getMessage());
			System.exit(0);
		}
		catch(MalformedURLException ME)
		{
			System.out.println("Invalid URL!!");
		}
	}
}