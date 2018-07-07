package de.wartbar.framework

class HtmlA implements HtmlElement {

  private HtmlLeaf link = null

  HtmlA(String text, String address) {
    link = new HtmlLeaf()
    link.tag = "a"
    link.content = text
    link.attributes.put("href", address)
  }

  def render(def markupBuilder) {
    return link.render(markupBuilder)
  }
}
