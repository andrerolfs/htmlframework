package de.wartbar.framework

import groovy.xml.MarkupBuilder

class HtmlTooling {

  static String htmlText(HtmlElement element) {
    def writer = new StringWriter()
    def htmlBuilder = new MarkupBuilder(writer)

    HtmlComposite html = new HtmlComposite()
    html.content.add(element)
    html.tag = "html"

    html.render(htmlBuilder)
    return writer
  }
}
