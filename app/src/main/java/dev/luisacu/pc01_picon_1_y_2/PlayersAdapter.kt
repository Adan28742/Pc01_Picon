package dev.luisacu.pc01_picon_1_y_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlayersAdapter(private val players: List<Player>) : RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder>() {

    inner class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagePlayer: ImageView = itemView.findViewById(R.id.imagePlayer)
        val textFullName: TextView = itemView.findViewById(R.id.textFullName)
        val textBirthYear: TextView = itemView.findViewById(R.id.textBirthYear)
        val textAge: TextView = itemView.findViewById(R.id.textAge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_player, parent, false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]
        holder.imagePlayer.setImageResource(player.imageResId)
        holder.textFullName.text = player.fullName
        holder.textBirthYear.text = "Año de nacimiento: ${player.birthYear}"
        holder.textAge.text = "Edad: ${player.age}"
    }

    override fun getItemCount() = players.size
}
