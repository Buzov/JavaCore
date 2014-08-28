package JavaZip;

public class ZipMain {
	public static void main (String[] args){
		String dirName = "e:/ZipJava";// путь к папке которая упаковывается
		String zipName = "e:/ZipJava.zip";// путь и имя создаваемого архива
		double startTime = System.currentTimeMillis();
		ZipOut.zipDir(dirName, zipName);
		double stopTime = System.currentTimeMillis();
		double g = (stopTime-startTime)/1000;
		System.out.println(" Архивация длилась " + g+" с.");
	}

}
