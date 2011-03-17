import groovy.text.*
if (init){ args = ["URL" : (line.split(" ")[1]) ]}
else {
	if (line.size() > 0){
		args.put(line.substring(0, line.indexOf(":")).replace('-',''), line.substring(line.indexOf(":")+2)) 
    		args.put("params", args.URL.contains("?") ? args.URL.split('\\?')[1].split('&').inject([:]){ map, qstr ->  qstr.split('=').with { arg -> map[arg[0]] = arg[1] } ; map } : [:] )
   		args.put("contexts", (args.URL.contains("?") ? args.URL.split('\\?')[0].split('/') : args.URL.split('/')))
	}else{
        	out << new GStringTemplateEngine().createTemplate(new File("view.html").newReader("UTF-8")).make(args+evaluate(new File("controller.groovy"))).toString()
        	return "success"
	}
}
