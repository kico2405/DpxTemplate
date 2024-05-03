package egovframework.let.main.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 템플릿 메인 페이지 컨트롤러 클래스(Sample 소스)
 * @author 실행환경 개발팀 JJY
 * @since 2011.08.31
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2011.08.31  JJY            최초 생성
 *
 * </pre>
 */

@Controller
//@RestController
public class EgovMainApiController {

	private final Logger logger = LoggerFactory.getLogger(EgovMainApiController.class);
	
	//EgovConfigRestTemplate 참조
	@Autowired
	private RestTemplate restTemplate;
	
	private final String BASE_URL = "http://localhost:8081/api/bbsList";
	/**
	 * 템플릿 메인 페이지 조회
	 * @return 메인페이지 정보 Map [key : 항목명]
	 *
	 * @throws Exception
	 */	
	@RequestMapping(value = "/")
	public String getMgtMainPage(Model model) throws Exception
	//public List<EgovMap> getMgtMainPage(Model model) throws Exception
	{
       ResponseEntity<List<EgovMap>> responseEntity = restTemplate.exchange(
                BASE_URL, 
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<EgovMap>>() {}
        );
       //HttpHeaders httpHeaders = restTemplate.headForHeaders(BASE_URL);
       List<EgovMap> bbsList = responseEntity.getBody();
       
		/*
		 * logger.debug("httpHeaders : ");
		 * 
		 * logger.debug("httpHeaders : " + httpHeaders.toString());
		 */
       model.addAttribute("bbsList", bbsList);
		
       //return bbsList;
       return "main";
	}

}