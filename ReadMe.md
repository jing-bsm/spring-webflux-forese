### Why
This is a demonstration about how to use foresee internal library in spring webflux environment.

### How
There are two end point
 
`GET /foo`
This one only do logging, if you use log4j2-aws.xml it will pipe to the kafka queue

`GET /bar`
This is an event bus example that publishes a message asynchronous.

### Note
You need very carefully do the logging configuration as well the libraries that are pulled into the pom.xml.

