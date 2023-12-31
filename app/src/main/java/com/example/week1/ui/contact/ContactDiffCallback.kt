import androidx.recyclerview.widget.DiffUtil
import com.example.week1.ui.contact.MyItem

class ContactDiffCallback : DiffUtil.ItemCallback<MyItem>() {
    override fun areItemsTheSame(oldItem: MyItem, newItem: MyItem): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: MyItem, newItem: MyItem): Boolean {
        return oldItem.profile == newItem.profile &&
                oldItem.name == newItem.name &&
                oldItem.isFavorite == newItem.isFavorite &&
                oldItem.number == newItem.number
    }
}