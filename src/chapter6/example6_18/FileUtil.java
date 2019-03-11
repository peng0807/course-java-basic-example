package chapter6.example6_18;

import java.io.*;

public class FileUtil {
	
	public static void main(String[] args) throws Exception{
		FileUtil.deleteDir("d:/dir1");
	}

	/**
	 * 静态方法，创建目录
	 * @param  path - 路径名称字符串
	 * @param ignoreIfExist - 当目录存在时，如果为true，则直接返回；如果为false，则先将原目录删除，再创建一个目录
	 */
	public static void createDir(String path, boolean ignoreIfExist) {
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			if (ignoreIfExist) {
				return ;
			} else {
				deleteDir(path);
			}
		}
		dir.mkdirs();
	}

	/**
	 * 静态方法，删除目录
	 * @param  path - 路径名称字符串
	 */
	public static void deleteDir(String path) {
		File dir = new File(path);
		if (!dir.exists() || !dir.isDirectory()) {
			return ;
		}
		File[] files = dir.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isFile()) {
					file.delete();
				} 
				if (file.isDirectory()) {
					deleteDir(file.getPath());
				}
			}
		}
		dir.delete();
	}
	
	/**
	 * 静态方法，创建文件
	 * @param  path - 路径名称字符串
	 * @param  ignoreIfExist - 当文件存在时，如果为true，则直接返回；如果为false，则先将原文件删除，再创建一个空文件
	 * @throws 但没有相关权限时，会抛出IOException
	 */
	public static void createFile(String path, boolean ignoreIfExist) throws IOException{
		File file = new File(path);
		if(file.exists()&&file.isFile()) {
			if(ignoreIfExist) {
				return ;
			} else {
				file.delete();
			}
		}
		createDir(file.getParent(), true);
		file.createNewFile();
	}
	
	/**
	 * 静态方法，删除文件
	 * @param  path - 路径名称字符串
	 */
	public static void deleteFile(String path) {
		File file = new File(path);
		if(file.exists()&&file.isFile()) {
			file.delete();
		}
	}
	
	public static void copyDir(File src, File dest) throws IOException {  
	    if (src.isDirectory()) {  
	        if (!dest.exists()) {  
	            dest.mkdir();  
	        }  
	        String files[] = src.list();  
	        for (String file : files) {  
	            File srcFile = new File(src, file);  
	            File destFile = new File(dest, file);  
	            // 递归复制  
	            copyDir(srcFile, destFile);  
	        }  
	    } else {  
	        InputStream in = new FileInputStream(src);  
	        OutputStream out = new FileOutputStream(dest);  
	  
	        byte[] buffer = new byte[1024];  
	  
	        int length;  
	          
	        while ((length = in.read(buffer)) > 0) {  
	            out.write(buffer, 0, length);  
	        }  
	        in.close();  
	        out.close();  
	    }  
	}  

}
