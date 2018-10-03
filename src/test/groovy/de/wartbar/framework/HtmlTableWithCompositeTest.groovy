package de.wartbar.framework

class HtmlTableWithCompositeTest extends spock.lang.Specification {

  def "test generate()"() {
    setup:

    //table.addCell("Hello 1")
    HtmlLeaf element1Row1 = new HtmlLeaf()
    element1Row1.tag = "td"
    element1Row1.content = "Hello 1"

    //table.addCell("World 1")
    HtmlLeaf element2Row1 = new HtmlLeaf()
    element2Row1.tag = "td"
    element2Row1.content = "World 1"

    //table.setColumns(2)
    HtmlComposite row1 = new HtmlComposite()
    row1.tag = "tr"
    row1.content.add(element1Row1)
    row1.content.add(element2Row1)

    //table.addCell(new HtmlA("lo","http://hel"))
    HtmlLeaf link = new HtmlLeaf()
    link.tag = "a"
    link.attributes.put("href", "http://hel")
    link.content = "lo"

    HtmlComposite element1Row2 = new HtmlComposite()
    element1Row2.tag = "td"
    element1Row2.content.add(link)

    //table.addCell("World 2")
    HtmlLeaf element2Row2 = new HtmlLeaf()
    element2Row2.tag = "td"
    element2Row2.content = "World 2"

    HtmlComposite row2 = new HtmlComposite()
    row2.tag = "tr"
    row2.content.add(element1Row2)
    row2.content.add(element2Row2)

    //HtmlTable table = new HtmlTable()
    HtmlComposite table = new HtmlComposite()
    table.tag = "table"
    table.content.add(row1)
    table.content.add(row2)

    String output = HtmlTooling.htmlText(table, "/Users/amos/github/htmlframework/css/divtable.css")

    expect:
    output == '''<html>
  <head>
    <link rel='stylesheet' href='/Users/amos/github/htmlframework/css/divtable.css' type='text/css' />
  </head>
  <table>
    <tr>
      <td>Hello 1</td>
      <td>World 1</td>
    </tr>
    <tr>
      <td>
        <a href='http://hel'>lo</a>
      </td>
      <td>World 2</td>
    </tr>
  </table>
</html>'''

  }
}
