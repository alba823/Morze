package com.example.morze.utils

object Constants {
    const val LONG_CLICK_DURATION = 150L
    const val LETTER_RECOGNIZE_DURATION = 500L
}

val CodeNums = mapOf(
    listOf(true, true, true, true, true)        to '0',
    listOf(false, true, true, true, true)       to '1',
    listOf(false, false, true, true, true)      to '2',
    listOf(false, false, false, true, true)     to '3',
    listOf(false, false, false, false, true)    to '4',
    listOf(false, false, false, false, false)   to '5',
    listOf(true, false, false, false, false)    to '6',
    listOf(true, true, false, false, false)     to '7',
    listOf(true, true, true, false, false)      to '8',
    listOf(true, true, true, true, false)       to '9'
)

val CodeMapUS = mapOf(
    listOf(false, true)                to 'a',
    listOf(true, false, false, false)  to 'b',
    listOf(true, false, true, false)   to 'c',
    listOf(true, false, false)         to 'd',
    listOf(false)                      to 'e',
    listOf(false, false, true, false)  to 'f',
    listOf(true, true, false)          to 'g',
    listOf(false, false, false, false) to 'h',
    listOf(false, false)               to 'i',
    listOf(false, true, true, true)    to 'j',
    listOf(true, false, true)          to 'k',
    listOf(false, true, false, false)  to 'l',
    listOf(true, true)                 to 'm',
    listOf(true, false)                to 'n',
    listOf(true, true, true)           to 'o',
    listOf(false, true, true, false)   to 'p',
    listOf(true, true, false, true)    to 'q',
    listOf(false, true, false)         to 'r',
    listOf(false, false, false)        to 's',
    listOf(true)                       to 't',
    listOf(false, false, true)         to 'u',
    listOf(false, false, false, true)  to 'v',
    listOf(false, true, true)          to 'w',
    listOf(true, false, false, true)   to 'x',
    listOf(true, false, true, true)    to 'y',
    listOf(true, true, false, false)   to 'z'
).plus(CodeNums)

val CodeMapUA = mapOf(
    listOf(false, true)                       to '??',
    listOf(true, false, false, false)         to '??',
    listOf(false, true, true)                 to '??',
    listOf(false, false, false, false)        to '??',
    listOf(true, true, false)                 to '??',
    listOf(true, false, false)                to '??',
    listOf(false)                             to '??',
    listOf(false, false, true, false, false)  to '??',
    listOf(false, false, false, true)         to '??',
    listOf(true, true, false, false)          to '??',
    listOf(true, false, true, true)           to '??',
    listOf(false, false)                      to '??',
    listOf(false, true, true, true, false)    to '??',
    listOf(false, true, true, true)           to '??',
    listOf(true, false, true)                 to '??',
    listOf(false, true, false, false)         to '??',
    listOf(true, true)                        to '??',
    listOf(true, false)                       to '??',
    listOf(true, true, true)                  to '??',
    listOf(false, true, true, false)          to '??',
    listOf(false, true, false)                to '??',
    listOf(false, false, false)               to '??',
    listOf(true)                              to '??',
    listOf(false, false, true)                to '??',
    listOf(false, false, true, false)         to '??',
    listOf(true, true, true, true)            to '??',
    listOf(true, false, true, false)          to '??',
    listOf(true, true, true, false)           to '??',
    listOf(true, true, false, true)           to '??',
    listOf(true, true, false, true, true)     to '??',
    listOf(true, false, false, true)          to '??',
    listOf(false, false, true, true)          to '??',
    listOf(false, true, false, true)          to '??'
).plus(CodeNums)