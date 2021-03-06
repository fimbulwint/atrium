package ch.tutteli.atrium.api.infix.en_GB

import ch.tutteli.atrium.creating.Expect

class CharSequenceContainsNotOrAtMostExpectationsSpec :
    ch.tutteli.atrium.specs.integration.CharSequenceContainsNotOrAtMostExpectationsSpec(
        getNotOrAtMostTriple(),
        getNotOrAtMostIgnoringCaseTriple(),
        getContainsNotPair(),
        "* ", "- "
    ) {

    companion object : CharSequenceContainsSpecBase() {

        private fun getNotOrAtMostTriple() =
            { what: String, times: String -> "$contains $what $notOrAtMost $times" } to
                ("$contains o $notOrAtMost $value/$values" to Companion::containsNotOrAtMost)

        private fun containsNotOrAtMost(expect: Expect<CharSequence>, atMost: Int, a: Any, aX: Array<out Any>) =
            if (aX.isEmpty()) expect contains o notOrAtMost atMost value a
            else expect contains o notOrAtMost atMost the values(a, *aX)

        private fun getNotOrAtMostIgnoringCaseTriple() =
            { what: String, times: String -> "$contains $ignoringCase $what $notOrAtMost $times" } to
                ("$contains o $ignoringCase $notOrAtMost $value/$values" to Companion::containsNotOrAtMostIgnoringCase)

        private fun containsNotOrAtMostIgnoringCase(
            expect: Expect<CharSequence>,
            atMost: Int,
            a: Any,
            aX: Array<out Any>
        ) =
            if (aX.isEmpty()) expect contains o ignoring case notOrAtMost atMost value a
            else expect contains o ignoring case notOrAtMost atMost the values(a, *aX)


        private fun getContainsNotPair() = containsNotValues to Companion::getErrorMsgContainsNot

        private fun getErrorMsgContainsNot(times: Int) = "use `$containsNotValues` instead of `$notOrAtMost $times`"

    }
}
