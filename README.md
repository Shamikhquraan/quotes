# quotes

## Lab: 08 - OO Design and GSON

**This application** will read a JSON file which contain alot of quotes.. then each time this app will run, will print out one of these quotes randomly.

### Configuration
Java doesn't have it's own built-in JSON parser. We need to add a dependency on one Google built called GSON. Add this to your project dependencies in build.gradle.we editted the dependencies to add compile tp compile our json file to read from it .


## Lab 9 - Web requests

**This application will return** the random quote from the Api . first need to make connection with the URL using HttpURLConnection, the Java HttpURLConnection class is http specific URLConnection, you can retrieve information of any HTTP URL such as header information, status code, response code etc.