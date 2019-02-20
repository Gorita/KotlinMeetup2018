
fun printIt(value: String): Nothing {
    TODO()
}

//fun main(args: Array<String>) {
//    val p = printIt("fdfd") //  Unit return someThing
//    println(p)
//}

fun sum(x: Int, y: Int) = x + y
fun higherOrder(ƒ: (Int) -> Unit) {

}

//fun main(args: Array<String>) {
//    higherOrder { x -> x + 1 }
//    higherOrder { it + 1 }
//}

// val 이 항상 immutable 하지는 않다.
// const val 은 immutable 을 의미함
//sealed class class GetUrlResult {
//    class Success(val contents: String): GetUrlResult()
//    class Failure(val message: String): GetUrlResult()
//}
//
//fun getUrl(url: String): String {
//    if (url.isNotEmpty()) {
//        return "Contents"
//    } else {
////        throw Exception("")
//    }
//}
//
//fun divide(x: Int, y: Int): Int {
//    if (y != 0) {
//        return x / y
//    } else {
////        throw Exception("")
//    }
//}

/**
 *  library arrow, kategory
 *  arrow-kt.io
 *
 *  Either > left, right
 *
 *  Option > isDefined
 *
 *  is None
 *  is Some
 *
 *
 */
//
//fun squareItOpt(x: Option<Int>): Option<Int> {
//    when {
//        x.isDefined() -> return Option(x*x)
//        x.isEmpty() -> return Option.Empty
//    }
//}

/**
 *  same as return x.map { it * it }
 */

// Try > getOrElse

/**
 *  compose function ->
 *
 *  restriction
 *  curry() // all function has only one parameter
 *  ::sum.curry()
 *  ::sum.partially1(2)
 *  sumPartial(3) > 5
 *
 *  DI 에서 활용
 */

inline fun highOrder(ƒ: (Int, Int) -> Int) {
//    ƒ 호출하는거 말고 다른 함수의 파라미터로 쓸수 없다..
//    noinline
//    forEach 는 inline 이기때문에 return 을 쓰면 해당 함수를 나간다.
//    higerOrder( fun(x, y): Int { return x + y } )
//    crossinline non local return이 가능하지 않게 하는것
//    inline <reified T>
}

/**
 *  하스켈은 함수를 캐쉬한다.
 *  if (cache.containsKey(n)) {
 *  cache.get(n)
 *
*/

fun fibonacci(position: Int): Int =
    if (position == 0 || position == 1) 1
    else fibonacci(position - 1) + fibonacci(position - 2)


val cache = mutableMapOf<Int, Int>()
fun fibonacciCache(position: Int): Int =
    if (cache.containsKey(position))
        cache[position]!!
    else {
        if (position == 0 || position == 1) {
            cache[position] = 1
            1
        } else {
            (fibonacciCache(position - 1) + fibonacciCache(position - 2)).let {
                cache[position] = it
                it
            }
        }
    }

fun fibonacciRec(position: Int): Long {
    fun loop(position: Int, front: Long, rear: Long): Long =
        if (position == 0 || position == 1) front + rear
        else loop(position -1, front + rear, front)
    return loop(position, 1, 0)
}

fun main(args: Array<String>) {
    println(fibonacciRec(45))
    println(fibonacciCache(45))
    println(fibonacci(45))
}
//loop(2, 0) = loop(1, loop(1, 1), loop(0, 1))
/**
 *  tailrec
 * */