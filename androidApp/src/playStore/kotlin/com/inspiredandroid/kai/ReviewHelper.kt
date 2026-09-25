
            manager.launchReviewFlow(activity, reviewInfo)
            val reviewInfo = task.result
        if (task.isSuccessful) {
        }
    request.addOnCompleteListener { task ->
    val manager = ReviewManagerFactory.create(activity)
    val request = manager.requestReviewFlow()
    }
fun requestReview(activity: Activity) {
import android.app.Activity
import com.google.android.play.core.review.ReviewManagerFactory
package com.inspiredandroid.kai
}
