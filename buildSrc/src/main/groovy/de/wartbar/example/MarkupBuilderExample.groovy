package de.wartbar.example

import groovy.xml.MarkupBuilder

class MarkupBuilderExample {

  static void printElements(Map<String,String> elements, MarkupBuilder mb) {
    mb."${elements.tag}"(elements.content)
  }

  static void example() {
    def writer = new StringWriter()
    def htmlBuilder = new MarkupBuilder(writer)

    String tag = "a"
    Map<String, String> attributes1 = new HashMap<>()
    attributes1.put("href","http://address")
    String content1 = "this is a link"

    Map<String, String> element1 = new HashMap<>()
    element1.put("tag","b")
    element1.put("content","bold content 1")

    Map<String, String> element2 = new HashMap<>()
    element2.put("tag","b")
    element2.put("content","bold content 2")

    List<Map<String, String>> elements = new ArrayList<>()
    elements.add(element1)
    elements.add(element2)

    htmlBuilder."html" {
      "${tag}"( attributes1, content1 )
      elements.each { contentIterator ->
        printElements(contentIterator, htmlBuilder)
      }
    }

    println writer
  }
}
