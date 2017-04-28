package ProblemA

import java.io.*

fun main(args: Array<String>) {
    val br = BufferedReader(FileReader(File("A-large-practice.in")))
    val pw = PrintWriter(File("output.txt"))

    solve(br, pw)

    br.close()
    pw.close()
}

fun solve(br: BufferedReader, pw: PrintWriter) {
    val testCount = br.readLine().toInt()
    for (test in 1..testCount) {
        val (patternStr, kStr) = br.readLine().split(" ")
        val pattern = patternStr.map { it == '+' }.toBooleanArray()
        val k = kStr.toInt()

        var ans = 0

        for (i in 0..pattern.size - k) {
            if (!pattern[i]) {
                ans++
                for (j in i..i + k - 1) {
                    pattern[j] = !pattern[j]
                }
            }
        }

        pw.println("Case #$test: ${if (false !in pattern) ans.toString() else "IMPOSSIBLE"}")
    }
}