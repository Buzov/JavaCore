package MyGame;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class MyFilter extends FileFilter
{
	public boolean accept(File f)
	{
		return f.getName().toLowerCase().endsWith(".txt")//является ли у файла расширение класс
				|| f.isDirectory(); //является ли это директорией
	}
	public String getDescription()
	{
		return "txt files";
	}
}
