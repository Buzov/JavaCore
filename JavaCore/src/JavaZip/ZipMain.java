package JavaZip;

public class ZipMain {
	public static void main (String[] args){
		String dirName = "e:/ZipJava";// ���� � ����� ������� �������������
		String zipName = "e:/ZipJava.zip";// ���� � ��� ������������ ������
		double startTime = System.currentTimeMillis();
		ZipOut.zipDir(dirName, zipName);
		double stopTime = System.currentTimeMillis();
		double g = (stopTime-startTime)/1000;
		System.out.println(" ��������� ������� " + g+" �.");
	}

}
