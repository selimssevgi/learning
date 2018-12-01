def headers = for(nameValue <- params("-h")) yield {
  def tokens = splitByEqual(nameValue)
  new BasicHeader(tokens(0), tokens(1))
}

def handleRequest = {
  val query = params("-d").mkString("&")
  val httpget = new HttpGet(s"${url}?${query}")
  headers.foreach { httpget.addHeader(_) }
  val responseBody =
    new DefaultHttpClient().execute(httpget,
      new BasicResponseHandler())
  print(responseBody)
}

def splitByEqual(nameValue: String): Array[String] = nameValue.split('=')

// command action -d key1=val1,key2=val2 -h k1=v1,k2=v2 url
def parseArgs(args: Array[String]): Map[String, List[String]] = {

  def nameValuePair(paramName: String) = {

    def values(commaSeparatedValues: String) =
      commaSeparatedValues.split(",").toList

    val index = args.findIndexOf(_ == paramName)
    (paramname, if (index == -1) Nil else values(args(index + 1)))
  }

  Map(nameValuePair("-d"), nameValuePair("-h"))
}

require(args.size >= 2,
  "at minimum you should specify action(post, get, delete, options) and url")

val command = args.head
val params = parseArgs(args)
val url = args.last

command match {
  case "post"     => handlePostRequest
  case "get"      => handleGetRequest
  case "delete"   => handleDeleteRequest
  case "options"  => handleOptionsRequest
}

