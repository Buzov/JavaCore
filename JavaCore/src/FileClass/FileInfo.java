package FileClass;

import java.io.File; 

public class FileInfo { 
  static void p(String s) { 
    System.out.println(s); 
  } 
  
  String PachToFileInfo;
  FileInfo (String PachToFile) { 
	PachToFileInfo = PachToFile;
    File f1 = new File(PachToFileInfo); 
 
    p("File Name (Имя файла): " + f1.getName()); 
    p("Path (Путь): " + f1.getPath()); 
    p("Abs Path (Абсолютный путь): " + f1.getAbsolutePath()); 
    p("Parent (Родительский каталог): " + f1.getParent()); 
    p(f1.exists() ? "Exists (Существует)" : "Does not exist (Не существует)"); 
    p(f1.canWrite() ? "Is writeable (Доступен для записи)" : "Is not writeable (Не доступен для записи)"); 
    p(f1.canRead() ? "Is readable (Доступен для чтения)" : "Is not readable (Не доступен для чтения)"); 
    p("Is " + (f1.isDirectory() ? "" : "not (Не)" + " a directory (является каталогом)")); 
    p(f1.isFile() ? "Is normal file (Обычный файл)" : "Might be a named pipe (Именованный каталог)"); 
    p(f1.isAbsolute() ? "Is absolute (Абсолютный)" : "Is not absolute (Не абсолютный)"); 
    p("File last modified (Время модификации): " + f1.lastModified()); 
    p("File size (Размер файла): " + f1.length() + " Bytes"); 
  } 
}

