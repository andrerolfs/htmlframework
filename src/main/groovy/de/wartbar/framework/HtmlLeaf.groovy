package de.wartbar.framework

class HtmlLeaf implements HtmlElement {

  String tag
  Map<String, String> attributes = new HashMap()
  String content

  void render(def markupBuilder) {
    markupBuilder."${tag}"( attributes, content)
  }
}
