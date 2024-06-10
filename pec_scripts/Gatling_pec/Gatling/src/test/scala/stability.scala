package stability

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class stability extends Simulation {

  val nbUsers = Integer.getInteger("users", 1)
  val myRamp = java.lang.Long.getLong("ramp", 0)


  private val httpProtocol = http
    .baseUrl("https://lkmdemoaut.accenture.com")
    .disableFollowRedirect
    //.inferHtmlResources(AllowList(), DenyList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*""", """.*\.svg"""))
    .userAgentHeader("Microsoft Office/16.0 (Windows NT 10.0; Microsoft Outlook 16.0.15831; Pro)")
  
  private val headers_0 = Map(
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
  
  private val headers_1 = Map(
  		"Accept" -> "*/*",
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
  
  private val headers_2 = Map(
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
  
  private val headers_5 = Map(
  		"Accept" -> "*/*",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Origin" -> "https://lkmdemoaut.accenture.com",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-origin",
  		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
  private val headers_43 = Map(
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
  
  private val headers_45 = Map(
  		"Accept" -> "*/*",
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
  
  private val headers_46 = Map(
  		"Accept" -> "*/*",
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

  val csvfeeder = csv("data/UserLogin_Stability.csv").circular
  private val scn = scenario("stability")
    .feed(csvfeeder)
    .exec(
      http("request_0")
        .get("/TestMeApp/fetchcat.htm")
        .headers(headers_0)
    )
    .pause(9)
    .exec(
      http("request_1")
        .get("/TestMeApp/fonts/fontawesome-webfont.woff?v=4.0.3")
        .headers(headers_1)
    )

    .pause(9)
    .exec(
      http("request_5")
        .post("/TestMeApp/namecheck.htm?ver=Nithin23")
        .headers(headers_5)
    )
    
    .pause(8)
    .exec(
      http("request_43")
        .post("/TestMeApp/loginhere.htm")
        .headers(headers_43)
        .formParam("userName", "${username}")
        .formParam("password", "${password}")
        .formParam("Login", "Login")
		.check(status.is(200))
        .resources(
          http("request_44")
            .get("/TestMeApp/fetchcat.htm")
            .headers(headers_0)
        )
    )
    .pause(2)
    .exec(
      http("request_45")
        .get("/TestMeApp/fonts/fontawesome-webfont.woff?v=4.0.3")
        .headers(headers_45)
    )
    .pause(3)
    .exec(
      http("request_53")
        .get("/TestMeApp/searchproduct.htm?pname=${product}")
        .headers(headers_46)
		.check(status.is(200))
    )
    .exec(
      http("request_54")
        .post("/TestMeApp/findProduct.htm")
        .headers(headers_43)
        .formParam("products", "${product}")
        .formParam("val", "FIND DETAILS")
		.check(status.is(200))
    )
    .pause(4)
    .exec(
      http("request_55")
        .get("/TestMeApp/fonts/fontawesome-webfont.woff?v=4.0.3")
        .headers(headers_1)
    )
    .pause(5)
    .exec(
      http("request_56")
        .get("/TestMeApp/checkLoginCart.htm?prodId=1")
        .headers(headers_2)
        .resources(
          http("request_57")
            .get("/TestMeApp/fetchSubCat.htm?val=search")
            .headers(headers_0)
        )
    )
    .pause(2)
    .exec(
      http("request_60")
        .get("/TestMeApp/displayCart.htm")
        .headers(headers_2)
		.check(status.is(200))
    )
    .pause(4)
    .exec(
      http("request_61")
        .get("/TestMeApp/fonts/fontawesome-webfont.woff?v=4.0.3")
        .headers(headers_45)
        .resources(
          http("request_62")
            .get("/TestMeApp/updateCart.htm?prodId=1&quantity=3")
            .headers(headers_2)
			.check(status.is(200))
        )
    )
    .pause(6)
    .exec(
      http("request_63")
        .get("/TestMeApp/checkout.htm")
        .headers(headers_2)
    )
    .pause(14)
    .exec(
      http("request_64")
        .get("/TestMeApp/fonts/fontawesome-webfont.woff?v=4.0.3")
        .headers(headers_1)
    )
    .pause(4)
    .exec(
      http("request_65")
        .get("/TestMeApp/payment.htm?ShippingAdd=+Banglore%2C+cv+raman&ShippingAdd1=")
        .headers(headers_2)
        .check(status.is(302))
        .resources(
          http("request_66")
            .get("/PaymentGateway")
            .headers(headers_2)
            .check(status.is(302)),
          http("request_67")
            .get("/PaymentGateway/")
            .headers(headers_2)
        )
    )
    .pause(3)
    .exec(
      http("request_68")
        .get("/PaymentGateway/getOrderDetails.htm")
        .headers(headers_0)
    )

    .pause(10)
    .exec(
      http("request_70")
        .post("/PaymentGateway/loginhere.htm")
        .headers(headers_43)
        .formParam("bkname", "Andhra Bank")
    )
    .pause(14)
    .exec(
      http("request_71")
        .post("/PaymentGateway/login.htm")
        .headers(headers_43)
        .formParam("username", "Admin")
        .formParam("password", "Admin12")
        .formParam("radio", "Andhra Bank")
        .check(status.is(500))
    )

//	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
	//setUp(scn.inject(rampUsers(50) during (100 seconds))).protocols(httpProtocol)
  setUp(scn.inject(rampUsers(nbUsers) during(myRamp))).protocols(httpProtocol)
}