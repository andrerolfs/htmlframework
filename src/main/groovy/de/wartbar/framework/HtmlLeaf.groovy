package de.wartbar.framework

class HtmlLeaf implements HtmlElement {

  String tag
  Map<String, String> attributes = new HashMap()
  String content

  HtmlLeaf() {}

  HtmlLeaf(String tag, String content) {
    this.tag = tag
    this.content = content
  }

  HtmlLeaf(String tag, String content, Map<String,String> attributes) {
    this.tag = tag
    this.content = content
    this.attributes = attributes
  }

  void render(def markupBuilder) {
    markupBuilder."${tag}"( attributes, content)
  }
}
