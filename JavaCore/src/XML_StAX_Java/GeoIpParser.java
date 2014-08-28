package XML_StAX_Java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
public class GeoIpParser
{
  private static final QName countryTagName = new QName("country");
  private static final QName ipStartAttribName = new QName("ip_start");
  private static final QName ipEndAttribName = new QName("ip_end");
  private static final QName flagAttribName = new QName("flag");
  private XMLInputFactory factory = XMLInputFactory.newInstance();
  private Attribute ipStart;
  private Attribute ipEnd;
  private Attribute flag;
  private StringBuilder chars;
  private boolean isInsideCountryTag;
  private List<GeoIPv4Adress> adresses;
  public static void main(String[] args)
  {
    GeoIpParser parser = new GeoIpParser();
    try
    {
      List<GeoIPv4Adress> geoIPv4AdressList = parser.parse(new File("geo-ip.xml"));
      for(GeoIPv4Adress adress : geoIPv4AdressList)
      {
        System.out.println(adress);
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
  public List<GeoIPv4Adress> parse(File file) throws IOException, XMLStreamException
  {
    FileInputStream in = new FileInputStream(file);
    XMLEventReader eventReader = factory.createXMLEventReader(in);
    while(eventReader.hasNext())
    {
      XMLEvent xmlEvent = eventReader.nextEvent();
      switch(xmlEvent.getEventType())
      {
        case XMLStreamConstants.START_DOCUMENT:
          init();
          break;
        case XMLStreamConstants.START_ELEMENT:
          processStartElement(xmlEvent.asStartElement());
          break;
        case XMLStreamConstants.CHARACTERS:
          processCharacters(xmlEvent.asCharacters());
          break;
        case XMLStreamConstants.END_ELEMENT:
          processEndElement(xmlEvent.asEndElement());
          break;
        case XMLStreamConstants.END_DOCUMENT:
          cleanup();
          break;
      }
    }
    List<GeoIPv4Adress> result = adresses;
    adresses = null;
    return result;
  }
  private void init()
  {
    adresses = new ArrayList<GeoIPv4Adress>();
    chars = new StringBuilder();
    isInsideCountryTag = false;
  }
  private void processStartElement(StartElement element)
  {
    if(element.getName().equals(countryTagName))
    {
      ipStart = element.getAttributeByName(ipStartAttribName);
      ipEnd = element.getAttributeByName(ipEndAttribName);
      flag = element.getAttributeByName(flagAttribName);
      isInsideCountryTag = true;
    }
  }
  private void processEndElement(EndElement element)
  {
    if(element.getName().equals(countryTagName))
    {
      createGeoIPv4Adress();
      ipStart = null;
      ipEnd = null;
      flag = null;
      chars.setLength(0);
      isInsideCountryTag = false;
    }
  }
  private void createGeoIPv4Adress()
  {
    try
    {
      adresses.add(GeoIPv4Adress.parse(ipStart.getValue(), ipEnd.getValue(), flag.getValue(), chars.toString()));
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
  private void processCharacters(Characters characters)
  {
    if(isInsideCountryTag)
    {
      chars.append(characters.getData());
    }
  }
  private void cleanup()
  {
    ipStart = null;
    ipEnd = null;
    flag = null;
    chars = null;
    isInsideCountryTag = false;
  }
}