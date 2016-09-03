import groovy.xml.MarkupBuilder


class Main {

	static Map langs = [
		java : 'Gosling',
		groovy : 'Strachan',
		pascal : 'Wirth',
		scala : 'Odersky'
	]

	public static void main(String[] argv) {

		String xml = new MyXmlParser(langs).parseToXml()

		File f = new File('languages.xml')
		f.write xml

		println "wrote xml out to file '${f?.getCanonicalPath()}'"
	}

}
class MyXmlParser {

	StringWriter writer = new StringWriter();
	MarkupBuilder xml = new MarkupBuilder(writer)
	Map langs

	public MyXmlParser(Map data) {
		langs = data		
	}

	public String parseToXml() {
		xml.languages {
			langs.each { lang ->
				language (name: lang.key) {
					author(lang.value)
				}
			}
		}
		writer.toString()
	}

}
