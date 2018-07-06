package de.wartbar.framework

class HtmlLink implements HtmlElement {

  private HtmlLeaf link = null

  HtmlLink(String text, String address) {
    link = new HtmlLeaf()
    link.tag = "a"
    link.content = text
    link.attributes.put("href", address)
  }

  def render(def markupBuilder) {
    return link.render(markupBuilder)
  }
}
