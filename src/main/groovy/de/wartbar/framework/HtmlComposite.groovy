package de.wartbar.framework

class HtmlComposite implements HtmlElement {

  String tag
  Map<String, String> attributes = new HashMap<>()
  List<HtmlElement> content = new ArrayList<>()

  void render(def markupBuilder) {
    markupBuilder."${tag}"( attributes ) {
      content.each { element ->
        element.render(markupBuilder)
      }
    }
  }

}
