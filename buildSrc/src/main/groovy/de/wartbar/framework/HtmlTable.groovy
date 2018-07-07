package de.wartbar.framework

class HtmlTable implements HtmlElement {

  private HtmlComposite table = createTable()
  private HtmlComposite row = createRow()
  private int columnCount = 1

  void setColumns(int count) {
    columnCount = count
  }

  private static HtmlComposite createTable() {
    HtmlComposite table = new HtmlComposite()
    table.tag = "table"
    return table
  }

  private static HtmlComposite createRow() {
    HtmlComposite row = new HtmlComposite()
    row.tag = "tr"
    return row
  }

  private void addToRow(HtmlElement element) {
    row.content.add(element)
    if (row.content.size() == columnCount) {
      table.content.add(row)
      row = createRow()
    }
  }

  void addCell(String text) {
    addCell(text, "")
  }

  void addCell(String text, String classAttribute) {
    HtmlLeaf leaf = new HtmlLeaf()
    leaf.content = text
    leaf.tag = "td"
    if (!classAttribute.isEmpty()) {
      leaf.attributes.put("class", classAttribute)
    }
    addToRow(leaf)
  }

  void addCell(HtmlElement element) {
    addCell(element, "")
  }

  void addCell(HtmlElement element, String classAttribute) {
    HtmlComposite composite = new HtmlComposite()
    composite.content.add(element)
    composite.tag = "td"
    if (!classAttribute.isEmpty()) {
      composite.attributes.put("class", classAttribute)
    }
    addToRow(composite)
  }

  def render(def markupBuilder) {
    return table.render(markupBuilder)
  }

}
