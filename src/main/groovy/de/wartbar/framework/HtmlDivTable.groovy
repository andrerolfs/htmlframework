package de.wartbar.framework

class HtmlDivTable implements HtmlElement {

  private HtmlComposite table = createTable()
  private HtmlComposite row = createTableRow()
  private int columnCount = 1

  void setColumns(int count) {
    columnCount = count
  }

  void addToRow(HtmlElement element) {
    row.content.add(element)

    if (row.content.size() == columnCount) {
      table.content.add(row)
      row = createTableRow()
    }
  }

  void render(def markupBuilder) {
    table.render(markupBuilder)
  }

  private static HtmlComposite createTable() {
    return createForElement(null, "rTable")
  }

  private static HtmlComposite createTableRow() {
    return createForElement(null, "rTableRow")
  }

  void addHeading(String content) {
    addToRow(createForText(content, "rTableHeading"))
  }

  void addHead(String content) {
    addToRow(createForText(content, "rTableHead"))
  }

  void addCell(String content) {
    addToRow(createForText(content, "rTableCell"))
  }

  void addFooter(String content) {
    addToRow(createForText(content, "rTableFooter"))
  }


  void addCell(HtmlElement element) {
    HtmlComposite composite = new HtmlComposite()
    composite.content.add(element)
    composite.tag = "div"
    composite.attributes.put("class", "rTableCell")

    addToRow(composite)
  }

  private static HtmlComposite createForElement(HtmlElement element, String classAttribute) {
    HtmlComposite div = new HtmlComposite()
    div.tag = "div"

    if (element != null) {
      div.content.add(element)
    }

    if (classAttribute != null) {
      div.attributes.put("class", classAttribute)
    }

    return div
  }

  private static HtmlLeaf createForText(String content, String classAttribute) {
    HtmlLeaf div = new HtmlLeaf()
    div.tag = "div"
    div.content = content
    div.attributes.put("class", classAttribute)

    return div
  }

}
