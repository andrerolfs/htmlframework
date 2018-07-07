package de.wartbar.framework

class HtmlDivTableTest extends spock.lang.Specification {

  def "test generate()"() {
    setup:

    HtmlDivTable table = new HtmlDivTable()
    table.setColumns(2)
    table.addHeading("Heading Column 1")
    table.addHeading("Heading Column 2")
    table.addHead("Head Column 1")
    table.addHead("Head Column 2")
    table.addCell("Cell Column 1")
    table.addCell(new HtmlA("2","http://cell/column"))
    table.addFooter("Footer Column 1")
    table.addFooter("Footer Column 2")
    String output = HtmlTooling.htmlText(table, "/Users/amos/github/htmlframework/css/divtable.css")

    expect:
    output == '''<html>
  <head>
    <link rel='stylesheet' href='/Users/amos/github/htmlframework/css/divtable.css' type='text/css' />
  </head>
  <div class='rTable'>
    <div class='rTableRow'>
      <div class='rTableHeading'>Heading Column 1</div>
      <div class='rTableHeading'>Heading Column 2</div>
    </div>
    <div class='rTableRow'>
      <div class='rTableHead'>Head Column 1</div>
      <div class='rTableHead'>Head Column 2</div>
    </div>
    <div class='rTableRow'>
      <div class='rTableCell'>Cell Column 1</div>
      <div class='rTableCell'>
        <a href='http://cell/column'>2</a>
      </div>
    </div>
    <div class='rTableRow'>
      <div class='rTableFooter'>Footer Column 1</div>
      <div class='rTableFooter'>Footer Column 2</div>
    </div>
  </div>
</html>'''

  }
}
