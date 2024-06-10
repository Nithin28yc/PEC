package concurrentuserlogin

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class concurrentuserlogin extends Simulation {

	val nbUsers = Integer.getInteger("users",1)
  val myRamp = java.lang.Long.getLong("ramp",0)


  private val httpProtocol = http
    .baseUrl("https://lkmdemoaut.accenture.com")
 // .inferHtmlResources(AllowList(), DenyList("", """.*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*""", "", ""))
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36")
  
  private val headers_0 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "none",
  		"Sec-Fetch-User" -> "?1",
  		"Upgrade-Insecure-Requests" -> "1",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
 
  
  private val headers_3 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "same-origin",
  		"Sec-Fetch-User" -> "?1",
  		"Upgrade-Insecure-Requests" -> "1",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
  
  
  
  
  private val headers_14 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Cache-Control" -> "max-age=0",
  		"Origin" -> "https://lkmdemoaut.accenture.com",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "same-origin",
  		"Sec-Fetch-User" -> "?1",
  		"Upgrade-Insecure-Requests" -> "1",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  

 
  val csvfeeder = csv( "data/concurrentuserlogin.csv").circular
  private val scn = scenario("concurrentuserlogin")
  .feed(csvfeeder)
    .exec(
      http("request_0")
        .get("/")
        .headers(headers_0))
        
    
    .pause(8)
    .exec(
      http("request_6")
        .post("/TestMeApp/loginhere.htm")
        .headers(headers_14)
        .formParam("userName", "${username}")
        .formParam("password", "${password}")
        .formParam("Login", "Login")
        
    )
    .pause(2)
    .exec(
      http("request_9")
        .get("/TestMeApp/logout.htm")
        .headers(headers_3)
    )
    

	//setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
	//setUp(scn.inject(rampUsers(30) during (60 seconds))).protocols(httpProtocol)
	setUp(scn.inject(rampUsers(nbUsers) during(myRamp))).protocols(httpProtocol)
}
