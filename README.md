# LedStripWebControl

Java program to control LED strips from website. It use Spring Boot to setup server and Vaadin to produce web content. You
can add your LED strips and set their parameters. Every time you add LED strip in application it sends to IP address that you have set
a message depending on parameters you have set on LED strip creation. Also every time you change strip parameters application also will
send message to it's IP address.

# Applicatin message
Application sends message as string like '001002003004' which is a combination of strip's parameters from 0 to 255 with leading zero.
Parameters used are colours red, green, blue, white.
