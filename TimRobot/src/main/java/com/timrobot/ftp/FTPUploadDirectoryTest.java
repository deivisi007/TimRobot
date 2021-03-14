package com.timrobot.ftp;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

public class FTPUploadDirectoryTest {

		 public static void main(String[] args) {
		        String server = "192.168.21.30";
		        int port = 21;
		        String user = "devi";
		        String pass = "devi123";
		 
		        FTPClient ftpClient = new FTPClient();
		        ftpClient.enterLocalPassiveMode();
		 
		        try {
		            // connect and login to the server
		            ftpClient.connect(server, port);
		            ftpClient.login(user, pass);
		 
		            // use local passive mode to pass firewall
		            ftpClient.enterLocalPassiveMode();
		 
		            System.out.println("Connected");
		            
		            String remoteDirPath = "/";
		            String localDirPath = "C:/Users/devi/Desktop/PUNA/FTP";
		 
		            FTPUtil.uploadDirectory(ftpClient, remoteDirPath, localDirPath, "");
		            
		            // log out and disconnect from the server
		            ftpClient.logout();
		            ftpClient.disconnect();
		            ftpClient.quit();
		 
		            System.out.println("Disconnected");
		        } catch (IOException ex) {
		        	System.out.println("Error: " + ex.getMessage());
//		            ex.printStackTrace();
		        } 
		            finally {
		            try {
		                if (ftpClient.isConnected()) {
		                    ftpClient.logout();
		                    ftpClient.disconnect();
		                    System.out.println("Disconnected");
		                }
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            }
		        }
		    }

	}


