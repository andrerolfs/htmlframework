package de.wartbar.framework

import groovy.xml.MarkupBuilder

class HtmlTooling {

  static HtmlComposite createHeadLinkCss(String href) {

    HtmlLeaf link = new HtmlLeaf()
    link.tag = "link"
    link.attributes.put("rel", "stylesheet")
    link.attributes.put("type", "text/css")
    link.attributes.put("href", href)

    HtmlComposite head = new HtmlComposite()
    head.content.add(link)
    head.tag = "head"

    return head
  }

  static String htmlText(HtmlElement element, String href) {
    def writer = new StringWriter()
    def htmlBuilder = new MarkupBuilder(writer)

    HtmlComposite html = new HtmlComposite()
    html.content.add(createHeadLinkCss(href))
    html.content.add(element)
    html.tag = "html"

    html.render(htmlBuilder)
    return writer
  }
}
