import groovy.text.*
if (!init && line.size() == 0) {
        out << new GStringTemplateEngine().createTemplate(new File("view.html").newReader("UTF-8")).make(evaluate(new File("controller.groovy"))).toString()
        return "success"
}
