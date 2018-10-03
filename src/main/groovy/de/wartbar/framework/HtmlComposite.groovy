package de.wartbar.framework

class HtmlComposite implements HtmlElement {

  String tag
  Map<String, String> attributes = new HashMap<>()
  List<HtmlElement> content = new ArrayList<>()

  HtmlComposite() {}

  HtmlComposite(String tag, List<HtmlElement> content) {
    this.tag = tag
    this.content = content
  }

  HtmlComposite(String tag, List<HtmlElement> content, Map<String, String> attributes) {
    this.tag = tag
    this.content = content
    this.attributes = attributes
  }

  void render(def markupBuilder) {
    markupBuilder."${tag}"( attributes ) {
      content.each { element ->
        element.render(markupBuilder)
      }
    }
  }

}
