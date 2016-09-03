#!/usr/bin/env groovyclient -Cq

import groovy.util.logging.Slf4j
import groovy.transform.ToString

@Grapes([
    @Grab(group='ch.qos.logback', module='logback-classic', version='1.1.7'),
	@GrabConfig(systemClassLoader=true)
])

def main = new Main()
main.go()


@Slf4j
class Main {

	public static void main(String[] argv) {
		new Main().go()
	}

	public void go() {
		
		def people = new MiniGorm()
		def dierk = new Person(first: 'Dierk', last: 'Koenig', books: [])
		def paul = new Person(first: 'Paul', last: 'King', books: [])
		people.db << dierk << paul

		def groovyBook = new Book(title: 'Groovy in Action', author: dierk)
		dierk.books << groovyBook

		log.info "${people.findByFirst('Dierk')}"
		log.info "${people.findByLast('King')}"
	}

}

@Slf4j
class MiniGorm {

	def db = []

	def methodMissing(String methodName, Object methodParameter) {
		db.find { entry ->
			def fieldName = methodName.toLowerCase() - 'findby'
			entry[fieldName] == methodParameter[0]
		}
	}
}

@ToString
class Person {
	def first
	def last
	def books

}

@ToString(excludes='author')
class Book {
	def title
	def author
}