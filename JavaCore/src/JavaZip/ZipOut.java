package JavaZip;

import java.io.*;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.*;
import javax.swing.JOptionPane;

public class ZipOut {
	// *********************************************
	// �������� zip ������    
	// *********************************************

	/*
	* @dirName - ���� � ����� ������� �������������
	* @zipName - ���� � ��� ������������ ������
	*/


	public static boolean zipDir(String dirName, String zipName) {
      try {
          // �������� ������ ZipOutputStream ��� ������ � ���� ����� ��������� zip
          ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipName));
          zos.setLevel(Deflater.BEST_COMPRESSION); // ������ ������� ������ �������� ������
          zipDir_(dirName, zos, dirName); // ������ ��������
          zos.close(); // ������ ������ �� ������
          // ����� �� ��������� ������� ���������� ����� zip
			File f = new File(zipName);  
			if (f.exists()){
			  return true; // ������ � ��������� ���������, ��������� � ������������� ���������� ����������
			}
			else{
			  return false;
			}
      } catch (Exception e) {
          e.printStackTrace();
          System.out.print(e);
          return false;
      }
  }

  /*
  * @True_path - ���� � ����� ������� �������������, �� �� �� �������� ��� ������ �����
  * @dir2zip - ���� � ����� ������� �������������, �� �� �������� ��� ������ �����
  */
	private static void zipDir_(String dir2zip, ZipOutputStream zos, String True_path) {
      try {
          // �������� ����� ���� � �����

          File zipDirs = new File(dir2zip);
          // ������� ������ ��������� ����� � ������, ���� ��� ����
          String[] dirList = zipDirs.list();
          byte[] readBuffer = new byte[64*1024];//2156
          int bytesIn = 0;
          // ������� ��������� ����� � ����
          for (int i = 0; i < dirList.length; i++) {
              File f = new File(zipDirs, dirList[i]);
              System.out.println(f.getAbsolutePath());
              if (f.isDirectory()) {
                  // ���� ��� �����, �� ������� �� � ����� � ������ ������
                  String filePath = f.getPath();
                  zipDir_(filePath, zos, True_path);
                  continue;
              }
              // ���� �� �� ������ �� ����, �� �������� ����� ��������� ����� � ������� �� � �����
              FileInputStream fis = new FileInputStream(f);
              // �������� ������ zip ������ � ������ ������������� ����� ��� �����
              ZipEntry anEntry = new ZipEntry(f.getPath().substring(True_path.length()));
              // place the zip entry in the ZipOutputStream object
              zos.putNextEntry(anEntry);
              // now write the content of the file to the ZipOutputStream
              while ((bytesIn = fis.read(readBuffer)) != -1) {
                  zos.write(readBuffer, 0, bytesIn);
              }
              fis.close(); // ������ ������ �� ������
          }
      } catch (Exception e) {
    	  System.out.print(e); // �� ������� ��������� ����� � zip
      }
  }  

	// *********************************************
	// �������� zip ������ �����      
	// ********************************************* 
}