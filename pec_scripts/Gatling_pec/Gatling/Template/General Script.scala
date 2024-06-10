package <<cloud folder name>>
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class <<meaning full name>> extends Simulation {

	val httpProtocol = http
		.baseUrl("<<platform url>>")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36")



	val headers_1 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en-US,en;q=0.9",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "same-origin",
		"Sec-Fetch-User" -> "?1",
		"Upgrade-Insecure-Requests" -> "1")

	//LDAP CSV INPUTS
	val csvfeeder = csv( fileName = "data/LDAP Users/<<filename>>.csv").circular
	//Cartridges CSV Inputs
	val cartridges = csv( fileName = "data/Cartridges/<<filename>>.csv").circular
	
	//Start of a Scenario
	val scn = scenario("cloveui")
			.feed(csvfeeder)
		 .pause(3)
			.exec(http("Platform Login")
			.get("/login")
			.headers(headers_1)
			.basicAuth("${username}","${password}"))
				
			.exec(http("Jenkins")
			.get("/jenkinscore/")
			.headers(headers_1)
			.basicAuth("${username}","${password}"))
		
		//Give the no of cartridges are to be triggered from CSV
		.repeat(1){
			feed(cartridges)
			.exec(http("Dev Workspace")
			.get("/jenkinscore/job/Dev_Workspace/")
			.headers(headers_1)
			.basicAuth("${username}","${password}"))
		.pause(3)
		.exec(http("${cartridges} Job")
			.get("/jenkinscore/job/Dev_Workspace/job/${cartridges}/")
			.headers(headers_1)
			.basicAuth("${username}","${password}"))
		.pause(2)
		.exec(http("${cartridges} Buildjob")
			.get("/jenkinscore/job/Dev_Workspace/job/${cartridges}/job/BuildJob/")
			.headers(headers_1)
			.basicAuth("${username}","${password}"))
		
		//for how many times each cartridge to be triggered
		.repeat(1){
				
		     exec(http("${cartridges} Buildnow")
			.get("/jenkinscore/job/Dev_Workspace/job/${cartridges}/job/BuildJob/build?token=12561&delay=0sec")
			.headers(headers_1)
			.basicAuth("${username}","${password}"))
			}
			}
			
			//Simulation Setup
	setUp(scn.inject(rampUsers(<<No Of USers>>) during (<<time in seconds>>))).protocols(httpProtocol)
}