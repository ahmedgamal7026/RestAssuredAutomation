package Tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SoapXmlRequest {

	@Test
	public void ValidateSoapXML() throws IOException {


		File file =new File("./SoapMultiplyRequest/multiply.XML");
		if (file.exists()) {
			FileInputStream fis = new FileInputStream(file);
			String RequestBody= org.apache.commons.io.IOUtils.toString(fis,"UTF-8");
			given().contentType("text/xml").accept(ContentType.XML).body(RequestBody)
			.when().post("http://www.dneonline.com/calculator.asmx").then().statusCode(200).log().all()
			.and().body("//*:MultiplyResult.text()", equalTo("6"));
		}
		else {
			System.out.println("file is not existing");
		}

	}

}
