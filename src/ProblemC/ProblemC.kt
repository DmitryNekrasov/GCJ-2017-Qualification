package ProblemC

import java.io.*

fun main(args: Array<String>) {
    val br = BufferedReader(FileReader(File("input.txt")))
    val pw = PrintWriter(File("output.txt"))

    solve(br, pw)

    br.close()
    pw.close()
}

fun solve(bf: BufferedReader, pw: PrintWriter) {
    println("Hello!")
}