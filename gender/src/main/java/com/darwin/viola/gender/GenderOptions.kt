package com.darwin.viola.gender

/**
 * The class GenderOptions
 *
 * @author Darwin Francis
 * @version 1.0
 * @since 28 Mar 2021
 */
class GenderOptions private constructor(builder: Builder) {

    val preValidateFace: Boolean
    val debug: Boolean

    init {
        this.preValidateFace = builder.preValidateFace
        this.debug = builder.debug
    }

    class Builder {
        var preValidateFace: Boolean = false
            private set
        var debug: Boolean = false
            private set

        fun enableFacePreValidation() = apply { this.preValidateFace = true }
        fun enableDebug() = apply { this.debug = true }
        fun build() = GenderOptions(this)
    }
}