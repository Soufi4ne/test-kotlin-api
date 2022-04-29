package genderizeapp.kotlin.com.genderize

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GenderAdapter(val genderModel: GenderModel): RecyclerView.Adapter<GenderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_gender, parent, false)
        return GenderViewHolder(view)
    }

    override fun onBindViewHolder(holder: GenderViewHolder, position: Int) {
        return holder.bindView(genderModel)
    }

    override fun getItemCount(): Int {
        return 1
    }
}

class GenderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvName: TextView = itemView.findViewById(R.id.tvName)
    private val tvGender: TextView = itemView.findViewById(R.id.tvGender)
    private val tvProbability: TextView = itemView.findViewById(R.id.tvProbability)
    private val tvCount: TextView = itemView.findViewById(R.id.tvCount)

    fun bindView(genderModel: GenderModel?) {
        tvName.text = genderModel?.name
        tvGender.text = genderModel?.gender
        tvProbability.text = genderModel?.probability.toString()
        tvCount.text = genderModel?.count.toString()
    }
}