package de.wartbar.framework

import groovy.xml.MarkupBuilder

class HtmlTableFrameworkTest extends spock.lang.Specification {

  def "test generate()"() {
    setup:

    def writer = new StringWriter()
    def html = new MarkupBuilder(writer)
    HtmlTableFramework table = new HtmlTableFramework()
    table.setColumns(2)
    table.addText("Hello 1")
    table.addText("World 1")
    table.addText("Hello 2")
    table.addText("World 2")
    table.getTable().render(html)
    String output = writer


    expect:
    output == '''<table>
  <tr>
    <td>Hello 1</td>
    <td>World 1</td>
  </tr>
  <tr>
    <td>Hello 2</td>
    <td>World 2</td>
  </tr>
</table>'''

  }
}
