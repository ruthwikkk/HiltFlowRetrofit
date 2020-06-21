package ac.lsa.lsaedu.adapters

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(private val view: View): RecyclerView.ViewHolder(view){

    /** binds data to the view holder class. */
    @Throws(Exception::class)
    abstract fun bindData(item: Any)

    /** gets the view of the [RecyclerView.ViewHolder]. */
    fun view(): View {
        return view
    }

    /** gets the context. */
    fun context(): Context {
        return view.context
    }
}