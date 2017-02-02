package com.cn.xmlParse;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyContentHandler extends DefaultHandler{
	public String hisName, address, money, sex, state;
	public String tagName;
	public void startDocument()throws SAXException{
		System.out.println("*********begin**********");
	}
	public void endDocument()throws SAXException{
		System.out.println("*********end**********");
	}
	public void startElement(String namespaceURI, String localName, String qName, Attributes attr)throws SAXException{
		tagName = localName;
		if(localName.equals("worker")){
			for(int i=0; i<attr.getLength(); i++){
				System.out.println(attr.getLocalName(i)+"="+attr.getValue(i));
			}
		}
		
		
		
	}
	public void endElement(String namespaceURI, String localName, String qName, Attributes attr)throws SAXException{
		if(localName.equals("worker")){
			this.printOut();
		}
	}
	public void characters(char[] ch, int start, int length)throws SAXException{
		if(tagName.equals("name")){
			this.hisName = new String(ch,start,length);
		}
		else if(tagName.equals("money")){
			this.money = new String(ch,start,length);
		}
        else if(tagName.equals("address")){
			this.address = new String(ch,start,length);
		}
        else if(tagName.equals("sex")){
			this.sex = new String(ch,start,length);
		}
        else if(tagName.equals("state")){
			this.state = new String(ch,start,length);
		}
		
	}
	private void printOut() {
		// TODO Auto-generated method stub
		System.out.print("name:");
		System.out.println(hisName);
		
		System.out.print("money:");
		System.out.println(money);
		
		System.out.print("address:");
		System.out.println(address);
		
		System.out.print("sex:");
		System.out.println(sex);
		
		System.out.print("state:");
		System.out.println(state);
		
	}
	

}
