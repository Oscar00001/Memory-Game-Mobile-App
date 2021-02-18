package com.oscar.memorymadness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oscar.memorymadness.models.BoardSize
import com.oscar.memorymadness.utils.DEFAULT_ICONS


class MainActivity : AppCompatActivity() {
    /*
        The point of using lateinit is because right now we will have a RV but will be constructed
        int eh onCreate function NOT on the MainActivity
        time
    */
    private lateinit var rvBoard: RecyclerView
    private lateinit var tvNumMoves: TextView
    private lateinit var tvNumPairs: TextView

    private  var boardSize: BoardSize = BoardSize.EASY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvBoard= findViewById(R.id.rvBoard)
        tvNumMoves = findViewById(R.id.tvNumMoves)
        tvNumPairs = findViewById(R.id.tvNumPairs)


        val chosenImages = DEFAULT_ICONS.shuffled().take(boardSize.getNumPairs())
        val randomizedImages = (chosenImages + chosenImages).shuffled()

        rvBoard.adapter = MemoryBoardAdapter(this,boardSize,randomizedImages) // this is for dawn
        rvBoard.setHasFixedSize(true) //
        rvBoard.layoutManager = GridLayoutManager(this, boardSize.getWidth())// this goes to the sides

    }
}
