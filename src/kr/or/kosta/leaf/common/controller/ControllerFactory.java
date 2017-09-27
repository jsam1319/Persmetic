package kr.or.kosta.leaf.common.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Factory 패턴 적용 ControllerFactory
 * 
 * @author 김기정
 */
public class ControllerFactory {

	// 요청에 대한 세부 컨트롤러 클래스 생성 및 관리

	private Map<String, Controller> controllerMap = null;

	public ControllerFactory(String controllerMapperLocation) {
		controllerMap = new HashMap<String, Controller>();

	/*	// 매핑정보를 저장할 Properties 객체 생성
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(controllerMapperLocation);
			prop.load(fis);
			Iterator keyIter = prop.keySet().iterator();
			while (keyIter.hasNext()) {
				String uri = (String) keyIter.next();
				String controllerClass = prop.getProperty(uri);
				System.out.println(controllerClass);
				// 컨트롤러 생성
				Controller controllerObject = (Controller) Class.forName(controllerClass).newInstance();
				controllerMap.put(uri, controllerObject);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}*/
		
		/* DOM Factory 생성 */
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		// WhiteSpace를 무시함(XML문서에 문서유형선언이 있어야 유효)
		// DTD문서 또는 XML Schema 문서가 제공되어야 한다.
		factory.setIgnoringElementContentWhitespace(true);
		// DTD Validation 검사를 하게함
		factory.setValidating(true);
		// NameSpace를 해석하도록 함
		// factory.setNamespaceAware(true);
		
		//DOM 파서 생성(JAXP)
		DocumentBuilder parser = null;
		try {
			parser = factory.newDocumentBuilder();

			System.out.println("[디버깅]: DOM 파서 로드 완료!");
			System.out.println(parser);
		} catch (ParserConfigurationException e) {
			System.out.println("[디버깅]: " + e);
		}

		// DOM API를 이용한 DOM 처리
		String xmlPath = controllerMapperLocation;
		Document document = null;
		// 로컬 디스크의 XML문서의 구성 요소를 객체 트리로 생성
		
		try {
			document = parser.parse(xmlPath);
			System.out.println("[디버깅]: DOM 트리 객체 생성 완료:" + document);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		NodeList beanList = document.getElementsByTagName("bean");

		for (int i = 0; i < beanList.getLength(); i++) {
			Element bean = (Element) beanList.item(i);
			
			String name = bean.getAttribute("name");
			String contName = bean.getAttribute("class");
			
			Controller controllerObj = null;
			
			try {
				controllerObj = (Controller) Class.forName(contName).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			controllerMap.put(name, controllerObj);
		}
	}

	public Controller getController(String name) {
		
		return controllerMap.get(name);
	}
}
