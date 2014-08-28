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
 
    p("File Name (��� �����): " + f1.getName()); 
    p("Path (����): " + f1.getPath()); 
    p("Abs Path (���������� ����): " + f1.getAbsolutePath()); 
    p("Parent (������������ �������): " + f1.getParent()); 
    p(f1.exists() ? "Exists (����������)" : "Does not exist (�� ����������)"); 
    p(f1.canWrite() ? "Is writeable (�������� ��� ������)" : "Is not writeable (�� �������� ��� ������)"); 
    p(f1.canRead() ? "Is readable (�������� ��� ������)" : "Is not readable (�� �������� ��� ������)"); 
    p("Is " + (f1.isDirectory() ? "" : "not (��)" + " a directory (�������� ���������)")); 
    p(f1.isFile() ? "Is normal file (������� ����)" : "Might be a named pipe (����������� �������)"); 
    p(f1.isAbsolute() ? "Is absolute (����������)" : "Is not absolute (�� ����������)"); 
    p("File last modified (����� �����������): " + f1.lastModified()); 
    p("File size (������ �����): " + f1.length() + " Bytes"); 
  } 
}

