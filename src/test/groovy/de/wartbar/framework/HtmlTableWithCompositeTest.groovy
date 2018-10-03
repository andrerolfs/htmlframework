package de.wartbar.framework

class HtmlTableWithCompositeTest extends spock.lang.Specification {

  def "test generate()"() {
    setup:

    HtmlComposite table = new HtmlComposite("table", [
            new HtmlComposite("tr", [
              new HtmlLeaf("td", "Hello 1"),
              new HtmlLeaf("td", "World 1")]),
            new HtmlComposite("tr", [
              new HtmlComposite("td",[new HtmlLeaf("a","lo", ["href":"http://hel"])]),
              new HtmlLeaf("td", "World 2")])])

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
