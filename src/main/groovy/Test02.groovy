public class Test02 {

	def namedClosure = { text ->
		println "namedClosure says: ${text}"
	}


	def myMethod (def s, closure) {
		closure(s)
	}

	public void go() {
		

		namedClosure 'Hi!'
		myMethod 'Ho!', namedClosure

		myMethod ('Hey!') {
			println "anonymous closure says: '$it'"
		}

	}

	public static void main(String[] argv) {
		new Test02().go()
	}
}
