package login

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class login extends Simulation {

	val nbUsers = Integer.getInteger("users", 1)
    val myRamp = java.lang.Long.getLong("ramp", 0)
	

  private val httpProtocol = http
    .baseUrl("https://opensource-demo.orangehrmlive.com")
    .disableFollowRedirect
//    .inferHtmlResources(AllowList(), DenyList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*""", """.*\.svg"""))
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36")
  
  private val headers_2 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
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
  
   private val headers_8 = Map(
  		"Accept" -> "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Sec-Fetch-Dest" -> "image",
  		"Sec-Fetch-Mode" -> "no-cors",
  		"Sec-Fetch-Site" -> "same-origin",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
  private val headers_13 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Cache-Control" -> "max-age=0",
  		"Origin" -> "https://opensource-demo.orangehrmlive.com",
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
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "same-origin",
  		"Sec-Fetch-User" -> "?1",
  		"Upgrade-Insecure-Requests" -> "1",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
    private val headers_15 = Map(
  		"Accept" -> "application/json",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Cache-Control" -> "max-age=0",
  		"If-None-Match" -> """"lJyzdvp9dVw7AABygfsIuOb9dNUb5bV3iXeF0n5J6+s="""",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-origin",
  		"contentType" -> "application/json",
  		"sec-ch-ua" -> """"Chromium";v="110", "Not A(Brand";v="24", "Google Chrome";v="110"""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> """"Windows""""
  )
  
  private val headers_30 = Map(
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

  val csvfeeder = csv( fileName = "data/login/users.csv").circular
  val scn = scenario("login")
    .feed(csvfeeder)
    .pause(6)
    .exec(
      http("request_2")
        .get("/")
        .headers(headers_13)
		.check(status.is(302))
        .resources(
          http("request_3")
            .get("/web/index.php/auth/login")
            .headers(headers_2),
          http("request_13")
            .post("/web/index.php/auth/validate")
            .headers(headers_13)
            .formParam("_token", "ee9848ff9110008c4827f71bf1f.WmGBMg2ms2VpC4MCMKtABqpVuGx_fASC7tOxNQ3PtVk.DjD4Z1_BxiAjMs17Vc0mV-M68jxNJDzPoZfGYEGY5zQpK9BCe9b7KVA9zg")
            .formParam("username", "${username}")
            .formParam("password", "${password}")
			.check(status.is(302)),
          http("request_14")
            .get("/web/index.php/dashboard/index")
            .headers(headers_14)
			.check(status.is(302)),
		  http("request_15")
            .get("/web/index.php/core/i18n/messages")
            .headers(headers_15),
          http("request_16")
            .get("/web/images/orange.png?1672659722816")
            .headers(headers_8)
        )
    )

    .pause(3)
    .exec(
      http("request_30")
        .get("/web/index.php/admin/viewAdminModule")
        .headers(headers_30)
		.check(status.is(302))
        .resources(
          http("request_31")
            .get("/web/index.php/admin/viewSystemUsers")
            .headers(headers_30)
			.check(status.is(302))
        )
    )
    .pause(3)
    .exec(
      http("request_35")
        .get("/web/index.php/auth/logout")
        .headers(headers_30)
		.check(status.is(302))
        .resources(
          http("request_36")
            .get("/web/index.php/auth/login")
            .headers(headers_30)
        )
    )

//	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
	//setUp(scn.inject(rampUsers(30) during (60 seconds))).protocols(httpProtocol)
	setUp(scn.inject(rampUsers(nbUsers).during(myRamp)))
	
}
