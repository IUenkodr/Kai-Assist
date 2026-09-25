import android.app.Activity
import com.google.android.play.core.review.ReviewManagerFactory

            manager.launchReviewFlow(activity, reviewInfo)
            val reviewInfo = task.result
        if (task.isSuccessful) {
        }
    request.addOnCompleteListener { task ->
    val manager = ReviewManagerFactory.create(activity)
    val request = manager.requestReviewFlow()
    }
fun requestReview(activity: Activity) {
package com.inspiredandroid.kai
}
