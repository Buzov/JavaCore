package XML_StAX_Java;

public class GeoIPv4Adress
{
  private static final int SIZE = 4;
  private static final long MASK = 0xFFFFFFFFL;
  private final int startAdress;
  private final int endAdress;
  private final String countryIsoCode;
  private final String countryName;
  public GeoIPv4Adress(int startAdress, int endAdress, String countryIsoCode, String countryName)
  {
    this.startAdress = startAdress;
    this.endAdress = endAdress;
    this.countryIsoCode = countryIsoCode.intern();
    this.countryName = countryName.intern();
  }
  public GeoIPv4Adress(byte[] startAdress, byte[] endAdress, String countryIsoCode, String countryName)
  {
    this(toInt(startAdress), toInt(endAdress), countryIsoCode, countryName);
  }
  public String getCountryIsoCode()
  {
    return countryIsoCode;
  }
  public String getCountryName()
  {
    return countryName;
  }
  public int getStartAsInt()
  {
    return startAdress;
  }
  public byte[] getStartAsBytes()
  {
    return toByteArray(startAdress);
  }
  public int getEndAsInt()
  {
    return endAdress;
  }
  public byte[] getEndAsBytes()
  {
    return toByteArray(endAdress);
  }
  public boolean isInRange(final int ip)
  {
    long lip = MASK & ip;
    return ((startAdress & MASK) <= lip) && (lip >= (endAdress & MASK));
  }
  public boolean isInRange(final byte[] ip)
  {
    return isInRange(toInt(ip));
  }
  @Override
  public String toString()
  {
    StringBuilder buffer = new StringBuilder(getClass().getSimpleName()).append("[");
    buffer.append(countryName).append(" (").append(countryIsoCode).append("): ");
    appendIpAdress(buffer, getStartAsBytes());
    buffer.append(" - ");
    appendIpAdress(buffer, getEndAsBytes());
    buffer.append(']');
    return buffer.toString();
  }
  private static void appendIpAdress(StringBuilder buffer, byte[] bytes)
  {
    for(int i = 0; i < bytes.length; i++)
    {
      if(i > 0)
        buffer.append('.');
      buffer.append(Integer.toString(bytes[i] & 0xFF));
    }
  }
  public static GeoIPv4Adress parse(String startIp, String endIp, String countryIsoCode, String countryName)
  {
    return new GeoIPv4Adress(parse(startIp), parse(endIp), countryIsoCode, countryName);
  }
  public static byte[] parse(String ip)
  {
    final String[] strings = ip.split("\.");
    if(strings.length != SIZE)
      throw new IllegalArgumentException("Invalid input string - '" + ip + "'");
    byte[] bytes = new byte[SIZE];
    for(int i = 0; i < strings.length; i++)
    {
      String s = strings[i];
      int b = Integer.parseInt(s);
      if(b < 0 || b > 255)
        throw new IllegalArgumentException("Invalid input string - '" + ip + "'");
      bytes[i] = (byte) b;
    }
    return bytes;
  }
  private static byte[] toByteArray(final int i)
  {
    byte[] bytes = new byte[SIZE];
    bytes[0] = (byte) ((i >>> 24) & 0xFF);
    bytes[1] = (byte) ((i >>> 16) & 0xFF);
    bytes[2] = (byte) ((i >>> 8) & 0xFF);
    bytes[3] = (byte) (i & 0xFF);
    return bytes;
  }
  private static int toInt(final byte[] bytes)
  {
    if(bytes.length != SIZE)
      throw new IllegalArgumentException("Invalid array length, expected - 4, found - " + bytes.length);
    return ((bytes[0] & 0xFF) << 24) +
           ((bytes[1] & 0xFF) << 16) +
           ((bytes[2] & 0xFF) << 8) +
           (bytes[3] & 0xFF);
  }
}
