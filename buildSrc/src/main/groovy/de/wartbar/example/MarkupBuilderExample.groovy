package de.wartbar.example

import groovy.xml.MarkupBuilder

class MarkupBuilderExample {

  static void example() {
    def writer = new StringWriter()
    def htmlBuilder = new MarkupBuilder(writer)

    String tag = "a"
    Map<String, String> attributes1 = new HashMap<>()
    attributes1.put("href","http://address")
    String content1 = "this is a link"

    List<String> contentList = new ArrayList<>()
    contentList.add("bold content 1")
    contentList.add("bold content 2")

    htmlBuilder."html" {
      "${tag}"( attributes1, content1 )
      contentList.each { contentIterator ->
        b(contentIterator)
      }
    }

    println writer
  }
}
