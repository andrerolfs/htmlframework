package de.wartbar.framework

class HtmlTableFramework {

  private List<List<TableData>> table = new ArrayList<>()
  private List<TableData> row = new ArrayList<>()
  private int columnCount = 1

  void setColumns(int count) {
    columnCount = count
  }

  private void nextRow() {
    if (row != null) {
      table.add(row)
    }
    row = new ArrayList<>()
  }

  void addText(String text) {
    addText(text, "")
  }

  void addText(String text, String config) {
    row.add(new TableData(content: text, config: config))
    if (row.size() == columnCount) {
      nextRow()
    }
  }

  void addLink(String text, String url) {
    addLink(text, url, "")
  }

  void addLink(String text, String url, String config) {
    String link = '''<a href="''' + url + '''">''' + text + '''</a>'''
    addText(text: link, config: config)
  }

  String generate() {
    String output = "<table>\n"
    table.each {
      output += "<tr>\n"
      it.each {
        output += "<td " + it.config + ">\n"
        output += it.content + "\n"
        output += "</td>\n"
      }
      output += "</tr>\n"
    }
    output += "</table>\n"
    return output
  }
}
