package dbprofiling

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class dbprofiling extends Simulation {

  val nbUsers = Integer.getInteger("users", 1)
  val myRamp = java.lang.Long.getLong("ramp", 0)


  private val httpProtocol = http
    .baseUrl("https://lkmdemoaut.accenture.com")
    //.inferHtmlResources(AllowList(), DenyList("", """.*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*""", "", ""))
    .acceptHeader("*/*")
  
  
  
  private val headers_1 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "none",
  		"Sec-Fetch-User" -> "?1",
  		"Upgrade-Insecure-Requests" -> "1",
  		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
  private val headers_2 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "same-origin",
  		"Upgrade-Insecure-Requests" -> "1",
  		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
  private val headers_3 = Map(
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"If-Modified-Since" -> "Thu, 28 Feb 2019 04:57:58 GMT",
  		"If-None-Match" -> """W/"43572-1551329878000"""",
  		"Origin" -> "https://lkmdemoaut.accenture.com",
  		"Sec-Fetch-Dest" -> "font",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-origin",
  		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
  private val headers_4 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "same-origin",
  		"Sec-Fetch-User" -> "?1",
  		"Upgrade-Insecure-Requests" -> "1",
  		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
  
  
  private val headers_6 = Map(
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
  		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
  private val headers_8 = Map(
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Origin" -> "https://lkmdemoaut.accenture.com",
  		"Sec-Fetch-Dest" -> "font",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-origin",
  		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
  private val headers_9 = Map(
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-origin",
  		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
  
  val csvfeeder = csv( "data/testing.csv").circular
  private val scn = scenario("dbprofiling")
    .feed(csvfeeder)
    
    .pause(2)
    .exec(
      http("request_1")
        .get("/")
        .headers(headers_1)
        .resources(
          http("request_2")
            .get("/TestMeApp/fetchcat.htm")
            .headers(headers_2),
          http("request_3")
            .get("/TestMeApp/fonts/fontawesome-webfont.woff?v=4.0.3")
            .headers(headers_3)
        )
    )
    .pause(2)
    .exec(
      http("request_4")
        .get("/TestMeApp/login.htm")
        .headers(headers_4)
    )
    
    .pause(3)
    .exec(
      http("request_6")
        .post("/TestMeApp/loginhere.htm")
        .headers(headers_6)
        .formParam("userName", "${username}")
        .formParam("password", "${password}")
        .formParam("Login", "Login")
        .resources(
          http("request_7")
            .get("/TestMeApp/fetchcat.htm")
            .headers(headers_2),
          http("request_8")
            .get("/TestMeApp/fonts/fontawesome-webfont.woff?v=4.0.3")
            .headers(headers_8)
        )
    )
    .pause(4)
    .exec(
      http("request_9")
        .get("/TestMeApp/searchproduct.htm?pname=${item}")
        .headers(headers_9)
        .resources(
          http("request_18")
            .get("/TestMeApp/searchproduct.htm?pname=${item}")
            .headers(headers_9)
        )
    )
    .pause(1)
    .exec(
      http("request_19")
        .post("/TestMeApp/findProduct.htm")
        .headers(headers_6)
        .formParam("products", "${item}")
        .formParam("val", "FIND DETAILS")
    )
    .pause(4)
    .exec(
      http("request_20")
        .get("/TestMeApp/logout.htm")
        .headers(headers_4)
    )

	//setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
  setUp(scn.inject(rampUsers(nbUsers) during(myRamp))).protocols(httpProtocol)
}
