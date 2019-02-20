
// DDD
// 소프트웨어를 만든다면 해당 도메인이 코드에도 적용되야한다.
//  DSL external internal


fun isSameAs(value1: String, value2: String) = value1 == value2
fun String.isSameAs2(value2: String) = this == value2
infix fun String.isSameAs3(value2: String) = this == value2

// KotlinTest

//class Course(val title: String = "", var description: String = "", var instructor: Instructor = Instructor())
//class Instructor(val name: String = "", var email: String = "") {
//    operator fun invoke(ƒ: Instructor.() -> Unit) {
//
//    }
//}

@DslMarker
annotation class CourseDsl

@CourseDsl
class CourseBuilder {
    var title: String = ""
    var desc: String = ""
    var instructor: InstructorBuilder = InstructorBuilder()

    fun build() = Course(title, desc, instructor.build())
}

class Course(val title: String, val description: String, val instructor: Instructor)

class Instructor(val name: String, val email: String)

@CourseDsl
class InstructorBuilder {
    var name: String = ""
    var email: String = ""

    fun build() = Instructor(name, email)
    operator fun invoke(ƒ: InstructorBuilder.() -> Unit): Instructor = apply(ƒ).build()
}

//fun course(ƒ: Course.() -> Unit) {
//
//}
fun course(ƒ: CourseBuilder.() -> Unit): Course = CourseBuilder().apply { ƒ() }.build()

fun main(args: Array<String>) {
    Course(
            "",
            "",
            Instructor(
                    "",
                    ""
            )
    )
    val target = course {
        title = "Good"
        desc = "Man"
        instructor {
            name = "Park"
            email = "@.com"
        }
    }

    println("${target.title}, ${target.description}, ${target.instructor}, ${target.instructor.name}, ${target.instructor.email}")
}

class Queue {
    operator fun invoke(f: String) {

    }
}
