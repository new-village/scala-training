import sttp.client4.quick.*
import sttp.client4.Response
import sttp.model.Uri

import upickle.default.*
import scala.collection.mutable.ArrayBuffer

@main def rest_call(): Unit =
  transformData(jsonData).foreach(println)

// Set initial parameters
val area = "130000"
val jmaUri: Uri = uri"https://www.jma.go.jp/bosai/forecast/data/forecast/${area}.json"

// Get JSON response
val response: Response[String] = quickRequest.get(jmaUri).send()
val jsonData = ujson.read(response.body)

/**
 * The transformData function extracts specific weather information from JSON data
 * and converts it into an ArrayBuffer of formatted strings.
 * 
 * @param jsonData JSON data of type ujson.Value
 * @return ArrayBuffer[String] containing formatted weather information strings
 */
def transformData(jsonData: ujson.Value): ArrayBuffer[String] = {
  val buffer = ArrayBuffer[String]()
  val timeSeries = jsonData(0)("timeSeries")(0)

  // Extract the relevant data from the JSON
  timeSeries("areas").arr.foreach { area =>
    val areaCode = area("area")("code").str
    val location = area("area")("name").str
    val weatherCodes = area("weatherCodes").arr.map(_.str)
    val weathers = area("weathers").arr.map(_.str)
    val winds = area("winds").arr.map(_.str)
    val waves = area("waves").arr.map(_.str)

    // Match timeDefines with weather, wind, and wave information
    timeSeries("timeDefines").arr.zipWithIndex.foreach { case (time, index) =>
      val datetime = time.str.split("T")(0)
      val weather = if (index < weathers.length) weathers(index) else ""
      val wind = if (index < winds.length) winds(index) else ""
      val wave = if (index < waves.length) waves(index) else ""

      // Create a formatted string for each entry
      val entry = s"""{
        "area_code": "$areaCode",
        "location": "$location",
        "datetime": "$datetime",
        "weather": "$weather",
        "wind": "$wind",
        "wave": "$wave"
      }"""

      buffer += entry
    }
  }
  buffer
}
