package com.cn.xmlParse;

import java.io.StringReader;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class XmlParseActivity extends Activity {
    /** Called when the activity is first created. */
	public Button myButton = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        myButton=(Button) findViewById(R.id.bt);
        myButton.setOnClickListener(new MyOnClickListener());
    }
    class MyOnClickListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			HttpDownloader loader = new HttpDownloader();
			String resultStr = loader.download("http://192.168.1.102:8080/worker.xml");
			System.out.println(resultStr);
			try{
			//创建一个SAXParserFactory
			SAXParserFactory factory = SAXParserFactory.newInstance();
			XMLReader reader=factory.newSAXParser().getXMLReader();
			//为XMLReader设置内容处理器
			reader.setContentHandler(new MyContentHandler());
			reader.parse(new InputSource(new StringReader(resultStr)));
			}
			catch(Exception e){
			e.printStackTrace();
			}
			
		}
    }	
    	
}