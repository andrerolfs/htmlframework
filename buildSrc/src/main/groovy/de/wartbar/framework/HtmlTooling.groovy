package de.wartbar.framework

import groovy.xml.MarkupBuilder

class HtmlTooling {

  static String text(HtmlElement element) {
    def writer = new StringWriter()
    def html = new MarkupBuilder(writer)

    element.render(html)
    return writer
  }
}
