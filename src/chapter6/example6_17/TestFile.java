package chapter6.example6_17;

import java.io.*;

public class TestFile {

	public static void main(String[] args) throws Exception {
		File dir1 = new File("d:/dir1"); // 即使没有dir1，也能创建File对象
		if (!dir1.exists()) {
			dir1.mkdir();
		}

		File dir2 = new File(dir1, "dir2"); 
		if (!dir2.exists()) {
			dir2.mkdirs(); // 创建目录d:\dir1\dir2
		}

		File dir4 = new File(dir1, "dir3/dir4"); 
		if (!dir4.exists()) {
			dir4.mkdirs(); // 创建目录d:\dir1\dir3\dir4
		}

		File file = new File(dir2, "test.txt"); 
		if (!file.exists()) {
			file.createNewFile(); // 创建文件d:\dir1\dir2\test.txt
		}
		
		listDir(dir1);
		
		// delete(dir1);
	}

	public static void listDir(File dir) {
		File[] listFiles = dir.listFiles();
		// 打印当前目录下所有子目录和文件的名称
		String info = "目录:" + dir.getName() + "( ";
		for (int i = 0; i < listFiles.length; i++) {
			info += listFiles[i].getName() + " ";
			if (listFiles[i].isDirectory()) {
				listDir(listFiles[i]); 	// 递归调用
			}
		}
		info += ")";
		System.out.println(info);
	}

	public static void delete(File file) {
		if (file.isFile()) {
			file.delete();
			return;
		}
		File[] listFiles = file.listFiles();
		for (int i = 0; i < listFiles.length; i++) {
			delete(listFiles[i]);
		}
		file.delete();

	}

}
