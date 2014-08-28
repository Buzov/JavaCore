package MyGame;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class MyFilter extends FileFilter
{
	public boolean accept(File f)
	{
		return f.getName().toLowerCase().endsWith(".txt")//�������� �� � ����� ���������� �����
				|| f.isDirectory(); //�������� �� ��� �����������
	}
	public String getDescription()
	{
		return "txt files";
	}
}
