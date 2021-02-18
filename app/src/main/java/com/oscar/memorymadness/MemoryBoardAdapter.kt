package com.oscar.memorymadness

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.oscar.memorymadness.models.BoardSize
import kotlin.math.min
// ViewGroup is recylver view?
class MemoryBoardAdapter(private val context: Context, private val boardSize: BoardSize,
    private val cardImages: List<Int>) :
    RecyclerView.Adapter<MemoryBoardAdapter.ViewHolder>() {

    companion object{
        private const val  MARGIN_SIZE = 50
        private const val TAG = "MemoryBoardAdapter"
    }

    /**
     * Java Docs
     * This is goin to create ONE view of recycler
     * @param parent the recycler view
     * @param viewType the
     * @return the view which is going to have
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardWidth = parent.width / boardSize.getWidth() - (2 * MARGIN_SIZE)
        val parentWidth = parent.width
        val boardWidth = boardSize.getWidth()
        Log.i(TAG, "Parent = $parentWidth boardWidth = $boardWidth")
        val cardHeight = parent.height / boardSize.getHeight() - (2 * MARGIN_SIZE)
        val squareLength = min(cardWidth,cardHeight)
        val view = LayoutInflater.from(this.context).inflate(R.layout.memory_card,parent,false)
        val layoutParams = view.findViewById<CardView>(R.id.cardView).layoutParams  as ViewGroup.MarginLayoutParams
        layoutParams.width = squareLength
        layoutParams.height = squareLength
        layoutParams.setMargins(MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE) // space between
        return  ViewHolder(view)
    }

    override fun getItemCount() = boardSize.numCards

    /**
     * Going to be responsible for taking data at the position and binding
     * it to ViewHolder
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    /**
     * Viewholder is an object that provides  access to all the views of one recycler view, ONE CARD
     */
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        private  val imageButton = itemView.findViewById<ImageButton>(R.id.imageButton)
        fun bind(position: Int) {
            imageButton.setImageResource(cardImages[position])
            imageButton.setOnClickListener {
                Log.i(TAG,"Clicked on Position $position")
            }

        }
    }

}
