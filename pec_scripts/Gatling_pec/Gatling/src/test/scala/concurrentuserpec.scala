package concurrentuserpec

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class concurrentuserpec extends Simulation {

  val nbUsers = Integer.getInteger("users",1)
  val myRamp = java.lang.Long.getLong("ramp",0)

  private val httpProtocol = http
    .baseUrl("https://kopsingressvalidation.continuoustestplatform.com")
    //.inferHtmlResources(AllowList(), DenyList("", """.*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*""", "", ""))
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.9")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36")
  
  private val headers_0 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "none",
  		"Sec-Fetch-User" -> "?1",
  		"Upgrade-Insecure-Requests" -> "1",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
  private val headers_1 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
  		"Cache-Control" -> "max-age=0",
  		"Origin" -> "null",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "same-origin",
  		"Sec-Fetch-User" -> "?1",
  		"Upgrade-Insecure-Requests" -> "1",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  private val headers_4 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "same-origin",
  		"Sec-Fetch-User" -> "?1",
  		"Upgrade-Insecure-Requests" -> "1",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )  
  val csvfeeder = csv( "data/concurrentusernewlogin.csv").circular
  private val scn = scenario("concurrentuserpec")
    .feed(csvfeeder)
    .exec(
      http("request_0")
        .get("/pec/")
        .headers(headers_0)
    )
    .pause(7)
    .exec(
      http("request_1")
        .post("/auth/realms/devopsplatform/login-actions/authenticate?session_code=7_VGwcAGRcUHOCJEq_2W_T_sV-wy69OagAC_Z5QnvKA&execution=e3a7689d-a5c1-446c-88dd-7fd3b960a3bd&client_id=devops&tab_id=bmAuHy4Laa0")
        .headers(headers_1)
        .formParam("username", "${username}")
        .formParam("password", "${password}")
        
    )
    .pause(1)
    .exec(
      http("request_2")
        .get("/pec/products.html")
        .headers(headers_4)
    )
    setUp(scn.inject(rampUsers(nbUsers) during(myRamp))).protocols(httpProtocol)
	//setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
