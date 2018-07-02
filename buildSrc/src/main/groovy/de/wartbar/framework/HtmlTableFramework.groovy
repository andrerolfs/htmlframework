package de.wartbar.framework

class HtmlTableFramework {

  private HtmlComposite table = createTable()
  private HtmlComposite row = createRow()
  private int columnCount = 1

  void setColumns(int count) {
    columnCount = count
  }

  private HtmlComposite createTable() {
    table = new HtmlComposite()
    table.tag = "table"
    return table
  }

  private HtmlComposite createRow() {
    HtmlComposite row = new HtmlComposite()
    row.tag = "tr"
    return row
  }

  private void addToRow(HtmlLeaf leaf) {
    row.content.add(leaf)
    if (row.content.size() == columnCount) {
      table.content.add(row)
      row = createRow()
    }
  }

  void addText(String text) {
    addText(text, "")
  }

  void addText(String text, String classAttribute) {
    HtmlLeaf leaf = new HtmlLeaf()
    leaf.content = text
    leaf.tag = "td"
    if (!classAttribute.isEmpty()) {
      leaf.attributes.put("class", classAttribute)
    }
    addToRow(leaf)
  }

  HtmlElement getTable() {
    return table
  }
}
