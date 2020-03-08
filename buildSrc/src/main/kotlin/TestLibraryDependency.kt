private object TestLibraryVersion {
    const val JUNIT = "4.12"
    const val TEST_RUNNER = "1.0.2"
    const val ESPRESSO_CORE = "3.0.2"
    const val MOCKITO = "3.0.0"
    const val MOCKITO_KOTLIN = "2.1.0"
    const val ANDROID_X_TEST = "1.2.0"
    const val COROUTINES_ANDROID = "1.3.2"
    const val FRAGMENT_VERSION = "1.2.0"
}

object TestLibraryDependency {
    const val JUNIT = "junit:junit:${TestLibraryVersion.JUNIT}"
    const val TEST_RUNNER = "com.android.support.test:runner:${TestLibraryVersion.TEST_RUNNER}"
    const val ESPRESSO_CORE = "com.android.support.test.espresso:espresso-core:${TestLibraryVersion.ESPRESSO_CORE}"
    const val MOCKITO_INLINE = "org.mockito:mockito-inline:${TestLibraryVersion.MOCKITO}"
    const val MOCKITO_ANDROID = "org.mockito:mockito-android:${TestLibraryVersion.MOCKITO}"
    const val MOCKITO_KOTLIN = "com.nhaarman.mockitokotlin2:mockito-kotlin:${TestLibraryVersion.MOCKITO_KOTLIN}"
    const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${TestLibraryVersion.COROUTINES_ANDROID}"
    const val ANDROID_X_CORE_TESTING = "android.arch.core:core-testing:${TestLibraryVersion.ANDROID_X_TEST}"
    const val ANDROID_X_TEST_RULES = "androidx.test:rules:${TestLibraryVersion.ANDROID_X_TEST}"
    const val ANDROID_X_TEST_KTS = "androidx.test:core-ktx:${TestLibraryVersion.ANDROID_X_TEST}"
    const val FRAGMENT_TESTING = "androidx.fragment:fragment-testing:${TestLibraryVersion.FRAGMENT_VERSION}"
}
