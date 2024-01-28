import scala.collection.mutable.ArrayBuffer

// Defining the test class
class MySuite extends munit.FunSuite {
  // Success test for the transformData function
  test("Test transformData function for success") {
    // Defining the JSON data for testing
    val jsonData = ujson.read(
      """[{
          "timeSeries": [{
            "timeDefines": ["2024-01-30T00:00:00+09:00"],
            "areas": [{
              "area": {"name": "東京地方","code": "130010"},
              "weatherCodes": ["101"],
              "weathers": ["晴れ　時々　くもり"],
              "winds": ["北の風　後　北東の風"],
              "waves": ["０．５メートル"]
            }]
          }]
        }]"""
    )
      
    // Defining the expected result
    val expected = ArrayBuffer(
      """{
        "area_code": "130010",
        "location": "東京地方",
        "datetime": "2024-01-30",
        "weather": "晴れ　時々　くもり",
        "wind": "北の風　後　北東の風",
        "wave": "０．５メートル"
      }"""
    )
    // Comparing the result of the transformData function with the expected result
    assert(clue(transformData(jsonData)) == expected)
  }
}