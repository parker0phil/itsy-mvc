import groovy.text.*
if (init){
	headers =[:]
        url = (line.split(" ")[1])
        params = url.contains("?") ?url.split('\\?')[1].split('&').inject([:]){ map, qstr ->  qstr.split('=').with { arg -> map[arg[0]] = arg[1] } ; map } : [:] 
        resources =  url.split('\\?')[0].substring(1).split('/')
}else if (line.size() > 0){
        headers.put(line.substring(0, line.indexOf(":")), line.substring(line.indexOf(":")+2))             
}else{
	controller = resources ? new File("${resources[0]}-controller.groovy").exists() ? new File("${resources[0]}-controller.groovy") : new File("controller.groovy") : new File("controller.groovy") 
	view =  resources ? new File("${resources[0]}-view.html").exists() ? new File("${resources[0]}-view.html") : new File("view.html") : new File("view.html")      
	out << new GStringTemplateEngine().createTemplate(view.newReader("UTF-8")).make(['resources':resources,'params':params,'headers':headers]+evaluate(controller)).toString()
        return "success"
}
