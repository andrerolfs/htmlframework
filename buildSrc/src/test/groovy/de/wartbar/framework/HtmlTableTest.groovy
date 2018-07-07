package de.wartbar.framework

class HtmlTableTest extends spock.lang.Specification {

  def "test generate()"() {
    setup:

    HtmlTable table = new HtmlTable()
    table.setColumns(2)
    table.addCell("Hello 1")
    table.addCell("World 1")
    table.addCell(new HtmlLink("lo","http://hel"))
    table.addCell("World 2")
    String output = HtmlTooling.htmlText(table)

    expect:
    output == '''<html>
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
