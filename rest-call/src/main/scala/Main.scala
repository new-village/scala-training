import sttp.client4.quick.*
import sttp.client4.Response
import sttp.model.Uri
import sttp.model.StatusCode
import ujson.*
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import scala.collection.mutable.Map
import scala.collection.mutable.ListBuffer
import upickle.default.*

@main def rest_call(): Unit =
  var results = ListBuffer[ujson.Obj]()
  if response.code == StatusCode.Ok then
    for (i <- 0 until timeDefines.length) {
        results += createJson(i)
    }
    println(ujson.Arr(results.toSeq: _*))
  else
    println(s"ERROR: the project get error code: ${response.code}")

// Set initial parameters
val area = "130000"
val jmaUri: Uri = uri"https://www.jma.go.jp/bosai/forecast/data/forecast/${area}.json"
val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME

// Get JSON response
val response: Response[String] = quickRequest.get(jmaUri).send()

// Extract place, timeDefines, and weathers from the JSON response
val (place, timeDefines, weathers) = try {
  val responseJson = ujson.read(response.body)(0)("timeSeries")(0)
  (
    responseJson("areas")(0)("area")("name"),
    responseJson("timeDefines").arr.map(_.str),
    responseJson("areas")(0)("weathers").arr.map(_.str)
  )
} catch {
  case e: Exception => throw new RuntimeException("Error while processing JSON response", e)
}

def createJson(i: Int): ujson.Obj = {
  val location = place
  val datetime = timeDefines(i)
  val weather = weathers(i)
  ujson.Obj("location" -> location, "datetime" -> datetime, "weather" -> weather)
}
