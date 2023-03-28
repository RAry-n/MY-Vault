package com.aryan.vault.Adapter

import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.aryan.vault.Modules.UserId
import com.aryan.vault.PdfShowAct
import com.aryan.vault.R
import com.aryan.vault.R.drawable.pdf
import com.aryan.vault.UploadActivity


class PdfAdapter(val context: Context?, val list:ArrayList<UserId>): RecyclerView.Adapter<PdfAdapter.MyViewHolder>() {

    private val userList = ArrayList<UserId>()




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.user_iteam_pdf,
            parent,false

        )

        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = list[position]



        holder.image.setImageResource(pdf)
        holder.fileName.text = currentitem.fileName
        holder.itemView.setOnClickListener {
            val intent= Intent(context, PdfShowAct::class.java)
            intent.putExtra("URL",currentitem.url)
            it.context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateUserList(userList : List<UserId>){

        this.list.clear()
        this.list.addAll(userList)
        notifyDataSetChanged()

    }

    class  MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val fileName : TextView = itemView.findViewById(R.id.fileName)
        val image : ImageView= itemView.findViewById(R.id.fileImg)




    }
}