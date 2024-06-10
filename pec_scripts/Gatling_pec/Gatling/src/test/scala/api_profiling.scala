package api_profiling

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class api_profiling extends Simulation {

	
	val nbUsers = Integer.getInteger("users", 1)
    val myRamp = java.lang.Long.getLong("ramp", 0)


  private val httpProtocol= http
    .baseUrl("https://lkmdemoaut.accenture.com")
    .disableFollowRedirect
//    .inferHtmlResources(AllowList(), DenyList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*""", """.*\.svg"""))
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36")
  
  private val headers_0 = Map(
  		"Accept-Encoding" -> "gzip, deflate",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Cache-Control" -> "no-cache",
  		"Pragma" -> "no-cache",
  		"Proxy-Connection" -> "keep-alive"
  )
  
  private val headers_1 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Cache-Control" -> "max-age=0",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "none",
  		"Sec-Fetch-User" -> "?1",
  		"Upgrade-Insecure-Requests" -> "1",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
  private val headers_2 = Map(
  		"Accept" -> "*/*",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Origin" -> "https://lkmdemoaut.accenture.com",
  		"Sec-Fetch-Dest" -> "font",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-origin",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
  private val headers_3 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
  		"Accept-Encoding" -> "gzip, deflate, br",
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
  
  private val headers_4 = Map(
  		"Accept" -> "*/*",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Origin" -> "https://lkmdemoaut.accenture.com",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-origin",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )

  private val headers_8 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
  		"Accept-Encoding" -> "gzip, deflate, br",
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
  
  private val headers_9 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "same-origin",
  		"Upgrade-Insecure-Requests" -> "1",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
  private val headers_11 = Map(
  		"Accept" -> "*/*",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-origin",
  		"X-Requested-With" -> "XMLHttpRequest",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
  private val headers_13 = Map(
  		"Accept" -> "*/*",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"If-Modified-Since" -> "Thu, 28 Feb 2019 04:57:58 GMT",
  		"If-None-Match" -> """W/"43572-1551329878000"""",
  		"Origin" -> "https://lkmdemoaut.accenture.com",
  		"Sec-Fetch-Dest" -> "font",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-origin",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
  // val nbUsers = Integer.getInteger("users", 1)
  // val myRamp = java.lang.Long.getLong("ramp", 0)
  

  
  val csvfeeder = csv("data/register.csv").circular
  private val scn = scenario("testme")
	.feed(csvfeeder)
    .pause(4)
    .exec(
      http("baseUrl")
        .get("/")
        .headers(headers_2)
    )
    .repeat(2){
    feed(csvfeeder)
    .exec(
      http("Sign_up")
        .get("/TestMeApp/RegisterUser.htm")
        .headers(headers_3)
    )
//    .exec(
 //     http("request_4")
//        .post("/TestMeApp/namecheck.htm?ver=Nithin")
//        .headers(headers_4)
//    )

    .exec(
      http("Registration")
        .get("/TestMeApp/register.htm?userName=${username}&firstName=${firstname}&lastName=${lastname}&password=${password}&confirmPassword=${password}&gender=${gender}&emailAddress=${email}&mobileNumber=${number}&dob=${dob}&address=${address}&securityQuestion=411011&answer=pink&Submit=Register")
        .headers(headers_3)
		.check(status.is(200))
    )
    .pause(15)
    .exec(
      http("Sign_in")
        .post("/TestMeApp/loginhere.htm")
        .headers(headers_8)
        .formParam("userName", "${username}")
        .formParam("password", "${password}")
        .formParam("Login", "Login")
		.check(status.is(200))
        .resources(
          http("request_9")
            .get("/TestMeApp/fetchcat.htm")
            .headers(headers_9)
        )
    )
    .pause(5)
    .exec(
      http("request_10")
        .get("/TestMeApp/fonts/fontawesome-webfont.woff?v=4.0.3")
        .headers(headers_2)
    )
    .pause(3)
    .exec(
      http("request_11")
        .get("/TestMeApp/fetchSubCat1.htm?catId=11290&val=home")
        .headers(headers_11)
    )
    .pause(2)
    .exec(
      http("request_12")
        .get("/TestMeApp/fetchProd.htm?val=home&catid=11290&subcatid=112102")
        .headers(headers_3)
    )
    .pause(1)
    .exec(
      http("request_13")
        .get("/TestMeApp/fonts/fontawesome-webfont.woff?v=4.0.3")
        .headers(headers_13)
    )
}

	// setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
	//	setUp(scn.inject(rampUsers(20) during (40 seconds))).protocols(httpProtocol)
		setUp(scn.inject(rampUsers(nbUsers) during(myRamp))).protocols(httpProtocol)
		
}
