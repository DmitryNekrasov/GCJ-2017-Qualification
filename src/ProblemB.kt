import java.io.*

fun main(args: Array<String>) {
    val br = BufferedReader(FileReader(File("B-large-practice.in")))
    val pw = PrintWriter(File("output.txt"))

    solve(br, pw)

    br.close()
    pw.close()
}

fun solve(br: BufferedReader, pw: PrintWriter) {
    val testCount = br.readLine().toInt()
    for (test in 1..testCount) {
        val a = br.readLine().map(Char::toString).map(String::toLong).toLongArray()

        var nine = a.size
        for (i in a.lastIndex downTo 1) {
            if (a[i] < a[i - 1]) {
                a[i - 1]--
                nine = i
            }
        }

        for (i in nine..a.lastIndex) {
            a[i] = 9
        }

        val ans = a.map(Long::toString).fold("") { a, b -> a + b }.toLong()
        pw.println("Case #$test: $ans")
    }
}
