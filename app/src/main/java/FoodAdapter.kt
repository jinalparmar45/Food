import android.content.Context
import android.view.*
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.food.Food
import com.example.food.R
import com.squareup.picasso.Picasso

class FoodAdapter (context : Context, val DataSourse : ArrayList<Food>): BaseAdapter() {
lateinit var context : Context
init {
    this.context = context
}
    var inflater = LayoutInflater.from(context)
    override fun getCount(): Int {

        return DataSourse.size;
    }

    override fun getItem(position: Int): Any {
        return  DataSourse[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val food = getItem(position) as Food
        val View = inflater.inflate(R.layout.list_items , parent, false)
        (View.findViewById(R.id.foodName) as TextView).text = food.name

        Picasso.with(this.context ).load(food.url)
            .resize(400, 400)
            .centerCrop()
                   .rotate(0F) .into(View.findViewById(R.id.foodthumbnail) as ImageView)
        //(View.findViewById(R.id.foodthumbnail) as ImageView)
        (View.findViewById(R.id.foodCategory) as TextView).text = food.category

        return View
    }
}