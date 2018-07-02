package de.wartbar.framework

class HtmlLeaf implements HtmlElement {

  String tag
  Map<String, String> attributes = new HashMap()
  String content

  def render(def markupBuilder) {
    return markupBuilder."${tag}"( attributes, content)
  }
}
