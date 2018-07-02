package de.wartbar.framework

class HtmlComposite implements HtmlElement {

  String tag
  Map<String, String> attributes = new HashMap<>()
  List<HtmlElement> content = new ArrayList<>()

  def render(def markupBuilder) {
    def mb
    markupBuilder."${tag}"( attributes ) {
      content.each { element ->
        mb = element.render(markupBuilder)
      }
    }
    return mb
  }

}
