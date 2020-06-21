package ac.lsa.lsaedu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.recyclerview.widget.RecyclerView
import java.util.*

abstract class BaseAdapter(private val type: String = "DEFAULT"): RecyclerView.Adapter<BaseViewHolder>(), LifecycleObserver {

    private val dataset = ArrayList<Any>()

    /** returns layout resources by section rows. */
    protected abstract fun layout(type: String): Int

    /** returns [RecyclerView.ViewHolder] by layouts. */
    protected abstract fun viewHolder(@LayoutRes layout: Int, view: View): BaseViewHolder

    override fun onViewDetachedFromWindow(holder: BaseViewHolder) {
        super.onViewDetachedFromWindow(holder)
    }

    override fun onViewAttachedToWindow(holder: BaseViewHolder) {
        super.onViewAttachedToWindow(holder)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, @LayoutRes layout: Int): BaseViewHolder {
        val view = inflateView(viewGroup, layout)
        return viewHolder(layout, view)
    }

    override fun onBindViewHolder(viewHolder: BaseViewHolder, position: Int) {
        val data = dataset[position]

        try {
            viewHolder.bindData(data)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return layout(type)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun getDataset(): ArrayList<Any> {
        return dataset
    }

    fun add(position: Int, item: Any) {
        dataset.add(position, item)
        notifyDataSetChanged()
    }

    fun add(item: Any) {
        dataset.add(item)
        notifyDataSetChanged()
    }

    fun update(position: Int, item: Any) {
        dataset[position] = item
        notifyItemChanged(position)
    }

    fun remove(position: Int) {
        dataset.removeAt(position)
        notifyItemRemoved(position)
    }

    fun removeAll() {
        dataset.clear()
    }

    fun setItems(items: List<Any>) {
        dataset.clear()
        addItems(items)
    }

    fun addItems(items: List<Any>) {
        for (item in items) {
            dataset.add(item)
        }
        notifyDataSetChanged()
    }

    private fun inflateView(viewGroup: ViewGroup, @LayoutRes viewType: Int): View {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        return layoutInflater.inflate(viewType, viewGroup, false)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public fun onDestroyed() {
        this.removeAll()
    }
}