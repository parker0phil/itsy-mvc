"""GET /foo/bar?car=dar?ear=far HTTP/1.1
Host: localhost:1024
User-Agent: Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:1.9.2.15) Gecko/20110303 Ubuntu/10.10 (maverick) Firefox/3.6.15
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
Accept-Language: en-gb,en;q=0.5
Accept-Encoding: gzip,deflate
Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.7
Keep-Alive: 115
Connection: keep-alive

""".eachLine{

	if (init){ args = ["URL" : (line.split(" ")[1]) ]}
	else {
		if (line.size() > 0){
			args.put(line.substring(0, line.indexOf(":")).replace('-',''), line.substring(line.indexOf(":")+2)) 
	    		args.put("params", args.URL.contains("?") ? args.URL.split('\\?')[1].split('&').inject([:]){ map, qstr ->  qstr.split('=').with { arg -> map[arg[0]] = arg[1] } ; map } : [:] )
	   		args.put("contexts", (args.URL.contains("?") ? args.URL.split('\\?')[0].split('/') : args.URL.split('/')))
		}else{
			return args
		}
	}
}
