package dbprofilingpec

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class dbprofilingpec extends Simulation {
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
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "no-cors",
  		"Sec-Fetch-Site" -> "none",
  		"X-Goog-Api-Key" -> "AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw",
  		"X-Goog-Encode-Response-If-Executable" -> "base64"
  )
  
  private val headers_2 = Map(
  		"Accept" -> "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8",
  		"Sec-Fetch-Dest" -> "image",
  		"Sec-Fetch-Mode" -> "no-cors",
  		"Sec-Fetch-Site" -> "same-origin",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
  private val headers_3 = Map(
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
  
  private val headers_5 = Map(
  		"Accept" -> "text/css,*/*;q=0.1",
  		"Sec-Fetch-Dest" -> "style",
  		"Sec-Fetch-Mode" -> "no-cors",
  		"Sec-Fetch-Site" -> "cross-site",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
  private val headers_6 = Map(
  		"Accept" -> "*/*",
  		"Origin" -> "https://kopsingressvalidation.continuoustestplatform.com",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "cross-site",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
  private val headers_7 = Map(
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
  
  private val uri1 = "https://course-api.com/javascript-store-products"
  
  private val uri3 = "https://content-autofill.googleapis.com/v1/pages"
  
  private val uri4 = "https://fonts.googleapis.com/css2"
  
  val csvfeeder = csv( "data/concurrentusernewlogin.csv").circular
  private val scn = scenario("dbprofilingpec")
    .feed(csvfeeder)
    .exec(
      http("request_0")
        .get("/pec/")
        .headers(headers_0)
        .resources(
          http("request_1")
            .get(uri3 + "/ChVDaHJvbWUvMTEwLjAuNTQ4MS4xNzgSFwmvAHZOG37kgxIFDeeNQA4SBQ3OQUx6?alt=proto")
            .headers(headers_1),
          http("request_2")
            .get("/auth/resources/72hgs/login/customtheme/img/logo.svg")
            .headers(headers_2)
        )
    )
    .pause(7)
    .exec(
      http("request_3")
        .post("/auth/realms/devopsplatform/login-actions/authenticate?session_code=MXFgxyQsdDN1A6Y7aFRPiNcB9ThkQHRNYMslldFx4hs&execution=e3a7689d-a5c1-446c-88dd-7fd3b960a3bd&client_id=devops&tab_id=2GBc5wTnNwk")
        .headers(headers_3)
        .formParam("username", "${username}")
        .formParam("password", "${password}")
        .resources(
          http("request_4")
            .get("/pec/images/logo-white.svg")
            .headers(headers_2),
          http("request_5")
            .get(uri4 + "?family=Kaushan+Script&display=swap")
            .headers(headers_5)
        )
    )
    .pause(1)
    .exec(
      http("request_6")
        .get(uri1)
        .headers(headers_6)
        .resources(
          http("request_7")
            .get("/pec/products.html")
            .headers(headers_7),
          http("request_8")
            .get("/pec/images/logo-black.svg")
            .headers(headers_2),
          http("request_9")
            .get(uri3 + "/ChVDaHJvbWUvMTEwLjAuNTQ4MS4xNzgSEAk6gPXSlacR8RIFDZFhlU4=?alt=proto")
            .headers(headers_1)
        )
    )
    .pause(6)
    .exec(
      http("request_10")
        .get("/pec/products.html?")
        .headers(headers_7)
        .resources(
          http("request_11")
            .get("/pec/images/logo-black.svg")
            .headers(headers_2)
        )
    )
    .pause(9)
    .exec(
      http("request_12")
        .get("/pec/products.html?")
        .headers(headers_7)
        .resources(
          http("request_13")
            .get("/pec/images/logo-black.svg")
            .headers(headers_2)
        )
    )
    .pause(17)
    .exec(
      http("request_14")
        .get("/pec/about.html")
        .headers(headers_7)
        .resources(
          http("request_15")
            .get("/pec/images/logo-black.svg")
            .headers(headers_2)
        )
    )
      setUp(scn.inject(rampUsers(nbUsers) during(myRamp))).protocols(httpProtocol)
    // setUp(scn.inject(rampUsers(30) during(60))).protocols(httpProtocol)
	//etUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
