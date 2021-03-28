package com.darwin.viola.gender

import android.content.Context
import org.tensorflow.lite.support.common.TensorOperator
import org.tensorflow.lite.support.common.ops.NormalizeOp

/**
 * The class GenderClassifierQuantizedEfficientNet
 *
 * @author Darwin Francis
 * @version 1.0
 * @since 27 Mar 2021
 */
internal class GenderClassifierQuantizedEfficientNet(
    context: Context,
    device: Device,
    numThreads: Int
) :
    Classifier(context, device, numThreads) {

    override fun getModelPath(): String {
        return "gender_model.tflite"
    }

    override fun getLabelPath(): String {
        return "gender_label.txt"
    }

    override fun getPreProcessNormalizeOp(): TensorOperator {
        return NormalizeOp(IMAGE_MEAN, IMAGE_STD)
    }

    override fun getPostProcessNormalizeOp(): TensorOperator {
        return NormalizeOp(PROBABILITY_MEAN, PROBABILITY_STD)
    }

    companion object {
        /**
         * The quantized model does not require normalization, thus set mean as 0.0f, and std as 255.0f to
         * bypass the normalization.
         */
        private const val IMAGE_MEAN = 0.0f
        private const val IMAGE_STD = 255f

        /**
         * Quantized MobileNet requires additional de-quantization to the output probability.
         */
        private const val PROBABILITY_MEAN = 0.0f
        private const val PROBABILITY_STD = 1.0f
    }
}