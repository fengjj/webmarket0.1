package com.sitech.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNLogEntryPath;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.fs.FSRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

/**
 * @describe 读取FTP上的文件
 * @auto li.wang
 * @date 2013-11-18 下午4:07:34
 */
public class FtpUtil {

 private FTPClient ftpClient;
 private String fileName, strencoding;
 private String ip;        // 服务器IP地址
 private String userName;        // 用户名
 private String userPwd;        // 密码
 private int port;      // 端口号
 public FTPClient getFtpClient() {
	return ftpClient;
}

public void setFtpClient(FTPClient ftpClient) {
	this.ftpClient = ftpClient;
}

public String getStrencoding() {
	return strencoding;
}

public void setStrencoding(String strencoding) {
	this.strencoding = strencoding;
}

private String path;        // 读取文件的存放目录

 /**
  * init ftp servere
  */
 public FtpUtil() {
	 strencoding = "UTF-8";
 }

 public void reSet() {
  // 以当前系统时间拼接文件名
  strencoding = "UTF-8";
  this.connectServer(ip, port, userName, userPwd, path);
 }

 /**
  * @param ip
  * @param port
  * @param userName
  * @param userPwd
  * @param path
  * @throws SocketException
  * @throws IOException function:连接到服务器
  */
 public void connectServer(String ip, int port, String userName, String userPwd, String path) {
  ftpClient = new FTPClient();
  try {
   // 连接
   ftpClient.connect(ip, port);
   // 登录
   ftpClient.login(userName, userPwd);
   if (path != null && path.length() > 0) {
    // 跳转到指定目录
    ftpClient.changeWorkingDirectory(path);
   }
  } catch (SocketException e) {
   e.printStackTrace();
  } catch (IOException e) {
   e.printStackTrace();
  }
 }

 public String getFileName() {
	return fileName;
}

public void setFileName(String fileName) {
	this.fileName = fileName;
}

public String getIp() {
	return ip;
}

public void setIp(String ip) {
	this.ip = ip;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getUserPwd() {
	return userPwd;
}

public void setUserPwd(String userPwd) {
	this.userPwd = userPwd;
}

public int getPort() {
	return port;
}

public void setPort(int port) {
	this.port = port;
}

public String getPath() {
	return path;
}

public void setPath(String path) {
	this.path = path;
}

/**
  * @throws IOException function:关闭连接
  */
 public void closeServer() {
  if (ftpClient.isConnected()) {
   try {
    ftpClient.logout();
    ftpClient.disconnect();
   } catch (IOException e) {
    e.printStackTrace();
   }
  }
 }

 /**
  * @param path
  * @return function:读取指定目录下的文件名
  * @throws IOException
  */
 public List<String> getFileList(String path) {
  List<String> fileLists = new ArrayList<String>();
  // 获得指定目录下所有文件名
  FTPFile[] ftpFiles = null;
  try {
   ftpFiles = ftpClient.listFiles(path);
  } catch (IOException e) {
   e.printStackTrace();
  }
  for (int i = 0; ftpFiles != null && i < ftpFiles.length; i++) {
   FTPFile file = ftpFiles[i];
   if (file.isFile()) {
    fileLists.add(file.getName());
   }
  }
  return fileLists;
 }

 /**
  * @param fileName
  * @return function:从服务器上读取指定的文件
  * @throws ParseException
  * @throws IOException
  */
 public String readFile() throws ParseException {
  InputStream ins = null;
  StringBuilder builder = null;
  try {
   // 从服务器上读取指定的文件
   ins = ftpClient.retrieveFileStream(fileName);
   BufferedReader reader = new BufferedReader(new InputStreamReader(ins, strencoding));
   String line;
   builder = new StringBuilder(150);
   while ((line = reader.readLine()) != null) {
    System.out.println(line);
    builder.append(line);
   }
   reader.close();
   if (ins != null) {
    ins.close();
   }
   // 主动调用一次getReply()把接下来的226消费掉. 这样做是可以解决这个返回null问题
   ftpClient.getReply();
  } catch (IOException e) {
   e.printStackTrace();
  }
  return builder.toString();
 }

 /**
  * @param fileName function:删除文件
  */
 public void deleteFile(String fileName) {
  try {
   ftpClient.deleteFile(fileName);
  } catch (IOException e) {
   e.printStackTrace();
  }
 }

 /**
  * @param args
  * @throws ParseException
  */
 public static void main(String[] args) throws ParseException {
	 //根据svn用户名获取提交的文件自动提交到ftp,返回提交的文件方便发送邮件
	 //svn地址
	 String url = "http://172.16.9.106:9001/svn/CRMPD_MSP/MARKET/%E7%89%88%E6%9C%AC%E7%A0%94%E5%8F%91/%E4%BA%A7%E5%93%81%E5%B7%A5%E7%A8%8B/%E5%BC%80%E5%8F%91%E5%8C%BA/appmarket";
     //svn用户名
	 String name = "tangll";
	//svn密码(nodes密码)
     String password = "806172";
     //找不到自己提交的最新信息的话则需要改大
     int number = 20;
     //ftp登录信息
     String ip = "10.163.106.110";
     int port  = 21;
     String ftpUser = "mktapp";
     String ftpPassword = "mktapp!123";
     //ftp应用的代码目录
     String ftppath = "/app/mysql/mktapp/applications/appmarket/";
     //获取svn登录用户最近的一个版本所有提交的文件
     List local_path  = get_local_commit_path(url,name,password,number);
     FtpUtil ftp = new FtpUtil();
     try {
    	 //获取的SVN文件转化成本地文件提交ftp
		ftp.uploadFile(ip,port,ftpUser,ftpPassword,local_path, ftppath);
	} catch (SocketException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
     
 }
 	
 
 public static List get_local_commit_path(String url,String name,String password,int number)
 {
 	
      long startRevision = 0;
      long endRevision = -1;
      setupLibrary();
      SVNRepository repository = null;
      try {
          repository = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(url));
      } catch (SVNException svne) {
      	svne.printStackTrace();
      	System.exit(1);
      }
      //身份认证
      ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(name, password);
      repository.setAuthenticationManager(authManager);
      try {
          endRevision = repository.getLatestRevision();
         // System.out.println("最新版本号"+repository.getLatestRevision());
      } catch (SVNException svne) {
          System.err.println("error while fetching the latest repository revision: " + svne.getMessage());
          System.exit(1);
      }
      Collection logEntries = null;
      try {
      	//每个版本间隔不一定是1
          logEntries = repository.log(new String[] {""}, null,endRevision-number, endRevision, true, true);
      } catch (SVNException svne) {
          System.out.println("error while collecting log information for '"
                  + url + "': " + svne.getMessage());
          System.exit(1);
      }
      SVNLogEntry logEntry = null;
      Object[] obj = logEntries.toArray();
      for(int i = obj.length-1 ; i >=0 ; i--)
      {
      	SVNLogEntry temp = (SVNLogEntry) obj[i];
      	//System.out.println(temp.getRevision());
      	String author = temp.getAuthor();
      	if(author.equals(name))
      	{
      		logEntry = temp;
      		break;
      	}
      }
      if(logEntry == null)
      {
      	System.out.println("没有找到"+name+"提交信息");
      	System.exit(1);
      }
      System.out.println("版本"  + logEntry.getRevision());
      System.out.println("提交者" + logEntry.getAuthor());
      List svn_commit_path = new ArrayList();
      Map pathmap = logEntry.getChangedPaths();
      if(pathmap.size()>0)
      {
      	
      	//System.out.println("提交路径");
      	Set changedPathsSet = pathmap.keySet();
          for (Iterator changedPaths = changedPathsSet.iterator(); changedPaths.hasNext();) 
          {
          	 SVNLogEntryPath entryPath = (SVNLogEntryPath) pathmap.get(changedPaths.next());
          	 svn_commit_path.add(entryPath.getPath());
          	 //System.out.println("svn提交地址"+entryPath.getPath());
          }
       }
	     String workspace = System.getProperty("user.dir");
	     //System.out.println("本地路径"+workspace);
	     String project = workspace.split("\\\\")[workspace.split("\\\\").length-1];
	      
	     List local_commit_path = new ArrayList();
	     for(int i = 0 ; i<svn_commit_path.size(); i++)
	     {
	    	 String temp = svn_commit_path.get(i).toString();
	    	 temp = temp.split(project)[1].replace("/", "\\").replace("src", "WebRoot\\WEB-INF\\classes").replace(".java", ".class");
	    	 String file_path = workspace + temp ;
	    	 local_commit_path.add(file_path);
	    	// System.out.println(file_path);
	     }
	     
	     return local_commit_path;
 }
 
 
 private static void setupLibrary() {
     DAVRepositoryFactory.setup();
     SVNRepositoryFactoryImpl.setup();
     FSRepositoryFactory.setup();
 }
 
 
 
 	
	 public void uploadFile(String ip , int port, String ftpUser,String ftpPassword,List local_commit_path , String uploadpath) throws SocketException, IOException
	 {
		 List upload_ok = new ArrayList();
		 List upload_error = new ArrayList();
		 FTPClient ftpClient = new FTPClient();
		 ftpClient.connect(ip, 21);
		 ftpClient.login(ftpUser, ftpPassword);
		 //重要啊
		 ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
		 ftpClient.cwd(uploadpath);
		 if(ftpClient.getReplyCode() != 250)
		 {
			 System.out.println("切换项目目录"+uploadpath+"失败");
			 return;
		 }
		 //以项目为分割符取后面路径
		 String workspace = System.getProperty("user.dir");
 	     String project = workspace.split("\\\\")[workspace.split("\\\\").length-1];
 	     for(int i = 0 ; i < local_commit_path.size() ; i++)
 	     {
 	    	 
 	    	 String local_file = local_commit_path.get(i).toString();
 	    	 File file = new File(local_file);
 	    	 String[] local_file_temp = local_file.split(project)[1].split("\\\\");
 	    	 boolean isupload = true;
 	    	 //切换到上传文件的目录然后上传,目录不存在会新建文件夹
 	    	 for(int j = 0; j <local_file_temp.length;j++)
 	    	 {
 	    		 if(local_file_temp[j].length()>0 & local_file_temp[j].equals("WebRoot")!=true)
 	    		 {
 	    			 
 	    			if(j != local_file_temp.length - 1)
 	    			{
 	    				//System.out.println("cd:"+local_file_temp[j]);
 	 	 	    		ftpClient.cwd(local_file_temp[j]);
 	 	 	    		if(ftpClient.getReplyCode() != 250)
 	 	 	    		{
 	 	 	    			
 	 	 	    			ftpClient.mkd(local_file_temp[j]);
 	 	 	    			//System.out.println(ftpClient.getReplyCode());
 	 	 	 	    		if(ftpClient.getReplyCode() != 257)
 	 	 	 	    		{
 	 	 	 	    			System.out.println("无法创建文件,请检查权限");
 	 	 	 	    			System.out.println("跳过文件"+local_file);
 	 	 	 	    			upload_error.add(file.getAbsolutePath());
 	 	 	 	    			isupload = false;
 	 	 	 	    		}else
 	 	 	 	    		{
 	 	 	 	    			ftpClient.cwd(local_file_temp[j]);
 	 	 	 	    		}
 	 	 	    		}
 	    			}
 	 	    		
 	    		 }
 	    		
 	    	 }
 	    	//切换目录正确后上传文件即可
 	    	 if(isupload)
 	    	 {
 	    		ftpClient.pwd();
 	 	    	 System.out.println("ftp服务器地址"+ftpClient.getReplyString().split(" ")[1].replace("\"", "").replace("\r\n", ""));
 	 	    	 System.out.println("上传的本地文件"+file.getAbsolutePath());
 	 	    	//上传文件到FTP
 	 	    	 FileInputStream in = new FileInputStream(file);
 	 	    	 ftpClient.storeFile(file.getName(), in);
 	 	    	 if(ftpClient.getReplyCode() != 226)
 	 	    	 {
 	 	    		System.out.println("本地文件上传失败"+file.getAbsolutePath());
 	 	    		upload_error.add(file.getAbsolutePath());
 	 	    	 }
 	 	    	upload_ok.add(file.getAbsolutePath());
 	 	    	 in.close();
 	 	    	 //地址重置
 	 	    	ftpClient.cwd(uploadpath);
 	    	 }
 	    	 System.out.println("---------------分割线---------------");
 	     }
 	    System.out.println("上传完毕输出上传信息");
 	    System.out.println("上传成功文件");
 	    for(int i = 0 ; i <upload_ok.size();i++)
 	    {
 	    	System.out.println(upload_ok.get(i).toString());
 	    }
 	    
 	    if(upload_error.size()>0)
 	    {
 	 	    System.out.println("上传失败文件");
 		    for(int i = 0 ; i <upload_error.size();i++)
 		    {
 		    	System.out.println(upload_error.get(i).toString());
 		    }
 	    }
 	    
 	     //循环完关闭
 	     if (ftpClient.isConnected()) {
	 	       try {
	 	    	   ftpClient.logout();
	 	    	   ftpClient.disconnect();
	 	       } catch (IOException e) {
	 	    	   e.printStackTrace();
	 	       }
 	      }
 	     
	 }
 
 
}
