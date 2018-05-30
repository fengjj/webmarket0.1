package com.sitech.util;


import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

/**
 * FTP上传文件,支持文件的上传、删除和目录的创建、删除操作
 * @author majhc 2009-12-10 16:02:17
 *
 */
public class Ftp {
	private static Logger log = Logger.getLogger(Ftp.class);
	private String errorDetail;
	private String localFileName;
	private String remoteFileName;
	private String hostName;
	public String ip;
	private int port;
	private String remotePath;
	private String localPath;
	private boolean binaryTransfer;
	private String userName;
	private String password;
	public FTPClient ftpClient;
	
	public String getErrorDetail() {
		return errorDetail;
	}

	private void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}
	
	private Ftp() {
		this.hostName = PropertiesUtil.getProperty("upload.properties","ftp.hostName");
		this.port = Integer.parseInt(PropertiesUtil.getProperty("upload.properties", "ftp.port"));
		this.localPath = PropertiesUtil.getProperty("upload.properties","ftp.localPath");
		this.remotePath = PropertiesUtil.getProperty("upload.properties","ftp.remotePath");
		this.binaryTransfer = true;
		this.ip = PropertiesUtil.getProperty("upload.properties", "ftp.ip");
		this.userName = PropertiesUtil.getProperty("upload.properties", "ftp.userName");
		this.password = PropertiesUtil.getProperty("upload.properties", "ftp.password");
		/*JavaDes des = new JavaDes();
		this.password = des.decrypt(this.password);
		GetNGBOSSConfig ngConfig = new GetNGBOSSConfig();
		try {
			String hostInfo = ngConfig.decodeHostInfo(this.hostName);
			if(!"-1".equals(hostInfo)){
				String[] hostInfoArr = hostInfo.split(",");
				if(hostInfoArr.length > 2){
					this.ip = hostInfoArr[0];
					this.userName = hostInfoArr[1];
					this.password = hostInfoArr[2];
				}
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally{
			if(null == this.ip){
				this.setErrorDetail("get .ngpasswordconfig file error!");
				log.info("get .ngpasswordconfig file error!");
			}
		}*/
	}
	
	private Ftp(String str) {//在配置文件中以某些开始的上传下载配置信息
		this.hostName = PropertiesUtil.getProperty("upload.properties",str + ".hostName");
		this.port = Integer.parseInt(PropertiesUtil.getProperty("upload.properties", str + ".port"));
		this.localPath = PropertiesUtil.getProperty("upload.properties",str + ".localPath");
		this.remotePath = PropertiesUtil.getProperty("upload.properties",str + ".remotePath");
		this.binaryTransfer = true;
		this.ip = PropertiesUtil.getProperty("upload.properties", str + ".ip");
		this.userName = PropertiesUtil.getProperty("upload.properties", str + ".userName");
 		this.password = PropertiesUtil.getProperty("upload.properties", str + ".userPassword");
 		if(null == this.ip){
			this.setErrorDetail("get .ngpasswordconfig file error!");
			log.info("get .ngpasswordconfig file error!");
		}
	}
	
	public static Ftp getInstance(String str) {//在配置文件中以某些开始的上传下载配置信息
		Ftp ftp = new Ftp(str);
		if(null == ftp.ip){
			return ftp;
		}
		if(null != ftp.remotePath && !"".equals(ftp.remotePath)){
			String lastChar = ftp.remotePath.substring(ftp.remotePath.length()-1);
			if(!"/".equals(lastChar)){
				ftp.remotePath += "/";
			}
		}
		return ftp;
	}

	public static Ftp getInstance() {
		Ftp ftp = new Ftp();
		if(null == ftp.ip){
			return ftp;
		}
		if(null != ftp.remotePath && !"".equals(ftp.remotePath)){
			String lastChar = ftp.remotePath.substring(ftp.remotePath.length()-1);
			if(!"/".equals(lastChar)){
				ftp.remotePath += "/";
			}
		}
		return ftp;
	}

	/**
	 * 与ftp主机建立连接
	 * @return
	 */
	public boolean connectServer(){
		ftpClient = new FTPClient();
		try {
			ftpClient.connect(this.ip, this.port);
			log.info("Ftp connect success");
		} catch (SocketException e) {
			log.error("Ftp connect error:"+e);
			this.setErrorDetail(e.getMessage());
			return false;
		} catch (IOException e) {
			log.error("Ftp connect error:"+e);
			this.setErrorDetail(e.getMessage());
			return false;
		}
		if(FTPReply.isPositiveCompletion(ftpClient.getReplyCode())){
			try {
				if(ftpClient.login(this.userName, this.password)){
					log.info("Ftp login sucess");
					this.setTransferFileType(this.binaryTransfer);
					this.changeWorkingDirectory(this.remotePath);
					return true;
				}else{
					log.info("Ftp login fail");
					log.info("Reply code:"+ftpClient.getReplyCode());
					return false;
				}
			} catch (IOException e) {
				log.error("Ftp login error:"+e);
				this.setErrorDetail(e.getMessage());
				return false;
			}
		}else{
			closeConnect();
			return false;
		}
		
	}
	
	public boolean setTransferFileType(boolean binaryTransfer){
		try {
			if(binaryTransfer){
				ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			}else{
				ftpClient.setFileType(FTPClient.ASCII_FILE_TYPE);
			}
			return true;
		} catch (IOException e) {
			log.error("Set transfer type error:"+e);
			this.setErrorDetail(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 断开ftp连接
	 */
	public void closeConnect(){
		if(ftpClient.isConnected()){   
			try {
				ftpClient.disconnect();
				log.info("Ftp disconnect sucess");
			} catch (IOException e) {
				this.setErrorDetail(e.getMessage());
				log.error("Ftp disconnect error:" + e);
			}
		}
	}
	
	/**
	 * 上传文件到ftp主机
	 * @param fileName
	 * @param is
	 * @return
	 */
	public boolean upload(String fileName, InputStream is) {
		String fileDirs = this.getFileDirs(fileName);
		String path = this.remotePath;
		if(!this.changeWorkingDirectory(this.remotePath+fileDirs)){
			if(this.buildDirs(fileName)){
				path = path+fileDirs;
			}
		}else{
			path = path+fileDirs;
		}
		try {
			boolean retBool = ftpClient.storeFile(path+fileName, is);
			int replyCode = ftpClient.getReplyCode();
			if(retBool){
				log.info(replyCode+":Upload file \""+path+fileName+"\" sucess");
				return true;
			}else{
				log.info(replyCode+":Upload file \""+path+fileName+"\" fail");
				this.setErrorDetail(replyCode+":Upload file \""+path+fileName+"\" fail");
				return false;
			}
			
		} catch (IOException e) {
			this.setErrorDetail(e.getMessage());
			log.error("Upload file error:" + e);
			return false;
		}
	}

	
	/**
	 * 上传文件到ftp主机
	 * @param fileName
	 * @param is
	 * @return
	 */
	public boolean uploadbyRemotePath(String fileName, InputStream is) {
		String path = this.remotePath;
		try {
			boolean retBool = ftpClient.storeFile(path+fileName, is);
			int replyCode = ftpClient.getReplyCode();
			if(retBool){
				log.info(replyCode+":Upload file \""+path+fileName+"\" sucess");
				return true;
			}else{
				log.info(replyCode+":Upload file \""+path+fileName+"\" fail");
				this.setErrorDetail(replyCode+":Upload file \""+path+fileName+"\" fail");
				return false;
			}
			
		} catch (IOException e) {
			this.setErrorDetail(e.getMessage());
			log.error("Upload file error:" + e);
			return false;
		}
	}
	
	
	/**
	 * 下载文件
	 * @param fileName
	 * @return
	 */
	public InputStream download(String fileName) {
		InputStream is;
		try {
			is = ftpClient.retrieveFileStream(this.getFilePath(fileName)+fileName);
		} catch (IOException e) {
			is = null;
			log.error("Download file error:"+e);
		}
		return is;
	}
	
	/**
	 * 删除文件
	 * @param fileName
	 * @return
	 */
	public  boolean deleteFile(String fileName){
		String path = this.getFilePath(fileName);
		try {
			boolean retBool = ftpClient.deleteFile(path+fileName);
			int replyCode = ftpClient.getReplyCode();
			if(retBool){
				log.info(replyCode+":Delete file \""+path+fileName+"\" sucess");
				return true;
			}else{
				log.info(replyCode+":Delete file \""+path+fileName+"\" fail");
				this.setErrorDetail(replyCode+":Delete file \""+path+fileName+"\" fail");
				return false;
			}
		} catch (IOException e) {
			log.error("Delete file error:"+e);
			this.setErrorDetail(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 在应用根目录下创建文件夹
	 * @param pathName
	 * @return
	 */
	public boolean makeDirectory(String pathName){
		try {
			boolean retBool = ftpClient.makeDirectory(pathName);
			int replyCode = ftpClient.getReplyCode();
			if(retBool){
				log.info(replyCode+":Make directory \""+pathName+"\" sucess");
				return true;
			}else{
				log.info(replyCode+":Make directory \""+pathName+"\" fail");
				this.setErrorDetail(replyCode+":Make directory \""+pathName+"\" fail");
				return false;
			}
		} catch (IOException e) {
			log.error("Make directory \""+pathName+"\" error:" + e);
			this.setErrorDetail(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 在应用根目录下删除文件夹
	 * @param pathName
	 * @return
	 */
	public boolean removeDirectory(String pathName){
		try {
			boolean retBool = ftpClient.removeDirectory(pathName);
			int replyCode = ftpClient.getReplyCode();
			if(retBool){
				log.info(replyCode+":Remove directory sucess");
				return true;
			}else{
				log.info(replyCode+":Remove directory fail");
				this.setErrorDetail(replyCode+":Remove directory fail");
				return false;
			}
		} catch (IOException e) {
			log.error("Remove directory error:" + e);
			this.setErrorDetail(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 改变ftp当前目录
	 * @param pathName
	 * @return
	 */
	public boolean changeWorkingDirectory(String pathName){
		boolean retBool = false;
		try {
			if(ftpClient.changeWorkingDirectory(pathName)){
				retBool = true;
			}else{
				retBool = false;
			}
		} catch (IOException e) {
			retBool = false;
			log.error("Change Directory \""+pathName+"\" error");
		}
		return retBool;
	}
	
	/**
	 * 以年月日的层级方式创建目录，分级存放文件
	 * @param fileName
	 * @return
	 * @throws IOException 
	 */
	public boolean buildDirs(String fileName) {
		String y = fileName.substring(0,4);
		String m = fileName.substring(4,6);
		String d = fileName.substring(6,8);
		String path = this.remotePath;
		boolean mdBool = true;
		
		path += y;
		if(!changeWorkingDirectory(path)){
			mdBool = mdBool && makeDirectory(y);
			changeWorkingDirectory(path);
		}

		path += "/"+m;
		if(!changeWorkingDirectory(path)){
			mdBool = mdBool && makeDirectory(m);
			changeWorkingDirectory(path);
		}

		path += "/"+d;
		if(!changeWorkingDirectory(path)){
			mdBool = mdBool && makeDirectory(d);
		}
		
		return mdBool;
	}
	
	/**
	 * 获取ftp根目录下的文件存放的目录层级
	 * @param fileName
	 * @return
	 */
	public String getFileDirs(String fileName){
		return fileName.substring(0,4)+"/"+fileName.substring(4,6)+"/"+fileName.substring(6,8)+"/";
	}
	
	/**
	 * 获取ftp根目录下的文件相对路径
	 * @param fileName
	 * @return
	 */
	public String getFilePath(String fileName){
		String fileDirs = this.getFileDirs(fileName);
		String path = this.remotePath;
		if(this.changeWorkingDirectory(path+fileDirs)){
			path = path+fileDirs;
		}
		return path;
	}
//	
//	/**
//	 * 一秒变FTP服务器
//	 * @param fileName
//	 * @return
//	 */
//	public void startServer(){
//		 FtpServerFactory serverFactory = new FtpServerFactory();
//		  BaseUser user = new BaseUser();
//		  user.setName("test");
//		  user.setPassword("123456");
//		  user.setHomeDirectory("D:/test");
//		  try {
//			  serverFactory.getUserManager().save(user);
//			  FtpServer server = serverFactory.createServer();
//			  server.start();
//		} catch (FtpException e) {
//			e.printStackTrace();
//		}
//	}
	
	public String getRemotePath() {
		return remotePath;
	}

	public void setRemotePath(String remotePath) {
		this.remotePath = remotePath;
	}

	public String getLocalPath() {
		return localPath;
	}

	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}
	public static void main(String[] arg){
		
//		 try {
//			 Connection conn = new Connection("10.163.106.120");
//			 conn.connect();
//			 boolean isAuthenticated = conn.authenticateWithPassword("cassandra", "cassandra!123");
//			    if(isAuthenticated) {
//			    	
//			    	 Session sess = conn.openSession();
//			    	 sess.requestPTY("vt100", 80, 24, 640, 480, null);
//			    	 
//			    	 Thread.sleep(4000); 
//			    	 String cmd = "cd presto/presto-server-0.75/bin" +"&";
//			    	 cmd += "./presto-cli --server 10.163.106.120:8888 --catalog cassandra --schema market"+"&";
//			    	 cmd += "show tables;";
//			    	 sess.execCommand(cmd);
//			    	 	sess.requestDumbPTY();
//			     	 	sess.startShell();
//			    	   PrintWriter pw = new PrintWriter(sess.getStdin());
//			    	   pw.println("cd presto/presto-server-0.75/bin");
//			    	   pw.println("./presto-cli --server 10.163.106.120:8888 --catalog cassandra --schema market");
//			    	   pw.println("show tables;");
//			    	   pw.close();
//			    	 
//			         System.out.println("Here is some information about the remote host:");
//			 
//			         InputStream stdout = new StreamGobbler(sess.getStdout());
//			 
//			         BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
//			 
//			           while (true)
//			           {
//			              String line = br.readLine();
//			              if (line == null)
//			                  break;
//			              System.out.println(line);
//			           }
//			 
//			          
//			 
//			           System.out.println("ExitCode: " + sess.getExitStatus());
//			 
//			          
//			 
//			           sess.close();
//			 
//			          
//			 
//			           conn.close();
//			    	
//			    	
//			    	System.out.println("验证通过");
//			    	
//			    	//验证通过就启动内置FTP服务
////				FtpServerFactory serverFactory = new FtpServerFactory();
////				 ListenerFactory factory = new ListenerFactory();
////				 factory.setPort(2222);
////				 serverFactory.addListener("default", factory.createListener());
////				  BaseUser user = new BaseUser();
////				  user.setName("test");
////				  user.setPassword("test");
////				  user.setHomeDirectory("D:/");
////				  try {
////					  serverFactory.getUserManager().save(user);
////					  FtpServer server = serverFactory.createServer();
////					  server.start();
////				} catch (FtpException e) {
////					e.printStackTrace();
////				}
//			    }else
//			    {
//			    	System.out.println("请校验服务器地址、用户名、密码是否正确");
//			    }
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 
		    
         
         
         
	}
}