/**
 *@ClassName:NFStry.java
 * 
 */
package com.mopaas.filesystem.test;

import net.sf.jftp.net.BasicConnection;
import net.sf.jftp.net.ConnectionListener;
import net.sf.jftp.system.logging.Log;
import net.sf.jftp.system.logging.Logger;
//import net.sf.jftp.net.wrappers.NfsConnection;

/**
 *
 * @ClassName:NFStry.java
 * @Description:
 * @author milliant
 * 2014年12月18日下午2:33:37
 */

public class NFStry implements Logger,ConnectionListener{

	
	 // is the connection established?
	 private boolean isThere = false;
	 // connection pool, not necessary but you should take a look at this class
	 // if you want to use multiple event based ftp transfers.
//	 private ConnectionHandler handler = new ConnectionHandler();
	 
	 public NFStry(String host){
	
			// create a NfsConnection - note that it does *not* connect instantly
			NfsConnection con = new NfsConnection(host); 
			// set updatelistener, interface methods are below
			con.addConnectionListener(this);
			Log.setLogger(this);
			// connect and login. this is from where connectionFailed() may be called for example
			con.login("root","anchora");
			while(!isThere)
			{
				System.out.println("connecting...");
				try { Thread.sleep(100); }
				catch(Exception ex) { ex.printStackTrace(); }
			}
			
			con.chdir("nfs://home/nfs/mifile.text");
			con.mkdir("milliant");

	 }
	 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NFStry("nfs://10.0.0.253/home/nfs");
	}

	@Override
	public void actionFinished(BasicConnection arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectionFailed(BasicConnection arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectionInitialized(BasicConnection arg0) {
		// TODO Auto-generated method stub
		isThere = true;
	}

	@Override
	public void updateProgress(String arg0, String arg1, long arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRemoteDirectory(BasicConnection arg0) {
		// TODO Auto-generated method stub
		
	}

    // method for logger
	@Override
	public void debug(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void debug(String arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void debugRaw(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void error(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void error(String arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void fatal(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void fatal(String arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void info(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void info(String arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void warn(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void warn(String arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

}
