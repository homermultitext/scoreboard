import scala.io.Source
import java.io.PrintWriter


// Edit this list to add new manuscripts.

val mss = Vector(
  "venetusA",
  "venetusB",
  "burney86",
  "upsilon1_1"
)


def mdColumns(row: String) : Vector[String] = {
  row.replaceAll("#", "# ").split("#").toVector.map(_.trim)
}


def mdRow(columns: Vector[String]) : String = {
  "| " + columns.mkString(" | ") + " |"
}


def formatRow(row: String): String = {
  //val cols = row.replaceAll("#", "# ").split("#").toVector.map(_.trim)
  val cols = mdColumns(row)
  val html = cols.map(cell => {
    cell match {
      case "" => "<span style=\"color:#ffae42\">not tested</span>"
      case "failing" => "<span style=\"color:red\">failing</span>"
      case s: String => s"`${s}`"
    }
  })
  mdRow(html)
}


def mdHeader(header: String): String = {
  val columns = mdColumns(header)
  val bars = for (i <- 0 until columns.size) yield {
    " --- "
  }
  mdRow(columns) + "\n" + mdRow(bars.toVector) + "\n"
}

def page(fileBase: String) : Unit = {
  println("Composing web page for " + fileBase)
  val dataFile = s"data/${fileBase}.cex"
  val markdownIntro = s"mdsource/${fileBase}/index.md"
  val webPage = s"docs/${fileBase}/index.md"

  // Build data table from CEX file:
  val data = Source.fromFile(dataFile).getLines.toVector
  val tableHeader = mdHeader(data.head)
  val tableRows = data.tail.map(row =>formatRow(row))
  val table = tableHeader + tableRows.mkString("\n")

  // Compose markdown
  val intro = Source.fromFile(markdownIntro).getLines.toVector.mkString("\n") + "\n\n"

  new PrintWriter(webPage){write(intro + table);close;}
  println("Done.")
}


def pages(mss: Vector[String] = mss): Unit = {
  for (ms <- mss) { page(ms) }
}

def usage: Unit = {

  println("\nWrite web pages for default list of MSS:\n\n\tpages()\n")
  println("Write web pages for a specified list of MSS:\n\n\tpages(Vector[MS1, MS2,...])\n")
  println("Write web page for one MS:\n\n\tpage(MS)\n")
}


usage
