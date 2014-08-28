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
	// Создание zip архива    
	// *********************************************

	/*
	* @dirName - путь к папке которая упаковывается
	* @zipName - путь и имя создаваемого архива
	*/


	public static boolean zipDir(String dirName, String zipName) {
      try {
          // Создадим объект ZipOutputStream для записи в него нашей структуры zip
          ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipName));
          zos.setLevel(Deflater.BEST_COMPRESSION); // укажем уровень сжатия будущего архива
          zipDir_(dirName, zos, dirName); // начнем упаковку
          zos.close(); // удалим объект из памяти
          // Здесь мы проверяем наличие созданного файла zip
			File f = new File(zipName);  
			if (f.exists()){
			  return true; // вернем в вызываему процедуру, сообщение о положительном результате выполнения
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
  * @True_path - путь к папке которая упаковывается, но он НЕ меняется при обходе папок
  * @dir2zip - путь к папке которая упаковывается, но он меняется при обходе папок
  */
	private static void zipDir_(String dir2zip, ZipOutputStream zos, String True_path) {
      try {
          // создадим новый файл в папке

          File zipDirs = new File(dir2zip);
          // получим список вложенных папок и файлов, если они есть
          String[] dirList = zipDirs.list();
          byte[] readBuffer = new byte[64*1024];//2156
          int bytesIn = 0;
          // обойдем вложенные папки и фалы
          for (int i = 0; i < dirList.length; i++) {
              File f = new File(zipDirs, dirList[i]);
              System.out.println(f.getAbsolutePath());
              if (f.isDirectory()) {
                  // если это папка, то засунем ее в архив и пойдем дальше
                  String filePath = f.getPath();
                  zipDir_(filePath, zos, True_path);
                  continue;
              }
              // Если же мы попали на файл, то создадим новую структуру файла и запишем ее в архив
              FileInputStream fis = new FileInputStream(f);
              // Создадим объект zip архива с именем упаковываемой папки или файла
              ZipEntry anEntry = new ZipEntry(f.getPath().substring(True_path.length()));
              // place the zip entry in the ZipOutputStream object
              zos.putNextEntry(anEntry);
              // now write the content of the file to the ZipOutputStream
              while ((bytesIn = fis.read(readBuffer)) != -1) {
                  zos.write(readBuffer, 0, bytesIn);
              }
              fis.close(); // удалим объект из памяти
          }
      } catch (Exception e) {
    	  System.out.print(e); // Не удалось упаковать папку в zip
      }
  }  

	// *********************************************
	// создание zip архива конец      
	// ********************************************* 
}