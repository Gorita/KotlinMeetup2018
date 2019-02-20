
// https://github.com/importre/kotlin-flavored-buildscripts

/**
 *
 *
 *  Kotlin 일웒화 하고 싶었다.
 *  빌드스크립트/플러그인/안드로이드 일원화
 *  자동완성을 기대했다.
 *
 *  플러그인 만드는법
 *  1. build.gradle로 만들기
 *  2. buildSrc 프로젝트
 *      별다른 세팅없이 실행가능
 *      다른 프로젝트에서는 사용할 수 없음
 *      build.gradle.kts 생성
 *      커피잔 > 그래들이 인식했다.
 *      (plugins)
 *      group 오른쪽 gradle 묶을 수 잇다.
 *  3. or 독립적인 프로젝트
 *      gradle init --type basic --dsl kotlin
 *      composite build
 *      
 *
 *  Android Studio 3.1.3
 *  Android Gradle Plugin 3.2.0-beta01
 *  Gradle wrapper 4.7
 *
 *
 *  플러그인 익스텐션
 *
 *
 */
