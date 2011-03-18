Easy as...
==========

1) Install groovy (http://groovy.codehaus.org/Download)
2) run 'groovy -l 80 itsy-mvc.groovy" (or an alternative port)
3) point your browser to "http://localhost/"

Default Controller and View
===========================

controller.groovy - Just a groovy script. Use the full groovy language to collect data and return a map (the Model!) to the view.
view.html - A Groovy simple template (http://groovy.codehaus.org/Groovy+Templates) provides the View.

Context Binding
===============

The following attributes are bound into controllers and views:

resources: list of resources parsed from request (e.g. /foo/bar/car/dar will give ['foo', 'bar', 'car', 'dar'])
params: map of querystring parameters (e.g. ?foo=bar&goo=car will give ['foo':'bar', 'goo':'car'])
headers: map of HTTP headers (e.g. ['Host': 'localhost:80', ...]

Multiple Views and Controllers
==============================

The first resource in the url will be used to attempt to resolve a different controller and/or view.

e.g. Requesting /foo/bar will try to resolve 'foo-controller.groovy' and 'foo-view.html'. If one or both are not found it will revert to the default(s).

Static Resources
================

Static resources are not currently served. If you want external css, js, img etc you'll have to load them from an external location.
This might get added if I can do it in less than 3 lines!


Standing on the Shoulders of Giants
===================================
http://mresetar.blogspot.com/2010/04/http-server-with-logging-in-20-lines-of.html
http://markmail.org/message/vx4oncrxvmzv4zib


