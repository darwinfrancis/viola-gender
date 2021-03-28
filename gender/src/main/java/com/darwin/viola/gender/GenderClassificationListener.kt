package com.darwin.viola.gender

/**
 * The class GenderClassificationListener
 *
 * @author Darwin Francis
 * @version 1.0
 * @since 27 Mar 2021
 */
interface GenderClassificationListener {
    fun onGenderClassificationResult(result: List<GenderRecognition>)
    fun onGenderClassificationError(error:String)
}