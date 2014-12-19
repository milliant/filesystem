/**
 *@ClassName:XFileTest.java
 * 
 */
package com.mopaas.filesystem.test;

import java.io.*;
import com.sun.xfile.*;
import com.sun.nfs.*;

/**
 *
 * @ClassName:XFileTest.java
 * @Description:
 * @author milliant 2014年12月19日上午10:36:45
 */

public class XFileTest {

	public static void main(String av[]) {
		try {
			XFile xf = new XFile("/home/milliant/mishare");
			if(!xf.exists()){
				System.out.println("file erro \n");
				return ;
			}
			com.sun.nfs.XFileExtensionAccessor nfsx = (com.sun.nfs.XFileExtensionAccessor) xf.getExtensionAccessor();
			
//			if (!nfsx.loginPCNFSD("localhost", "root", "anchora")) {
//				System.out.println("login failed");
//				return;
//			}
			if (xf.canRead())
				System.out.println("Read permission OK");
			else
				System.out.println("No Read permission");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace(System.out);
		}
	}

}
