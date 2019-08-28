package xmljx;

import java.io.File;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxXml extends DefaultHandler{
	@Override
	public void startDocument() throws SAXException {
		System.out.println("开始解析");
	}
	
	@Override
	public void startElement(String arg0, String arg1, String name, Attributes attributes) throws SAXException {
		System.out.println("开始标签："+name);
		for (int i = 0; i <attributes.getLength(); i++) {
			String names=attributes.getQName(i);
			String value=attributes.getValue(i);
			System.out.println("属性："+names+" = "+value);
		}
	}
	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		System.out.println("结束标签："+arg0+" "+arg1+" "+arg2);
	}
	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		String zi=new String(arg0,arg1,arg2);
		System.out.println(zi);
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("解析完了");
	}
	public static void main(String[] args) {
		SaxXml sax=new SaxXml();
		SAXParser parser;
		try {
			parser= SAXParserFactory.newInstance().newSAXParser();
			String lj="E:\\wk2\\sy\\src\\xmljx\\urers.xml";
			parser.parse(new File(lj), sax);
		} catch (Exception e) {
			
		}
	}
}
