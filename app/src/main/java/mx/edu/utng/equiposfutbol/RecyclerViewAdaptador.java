package mx.edu.utng.equiposfutbol;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView codigo,equipo, liga;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            equipo =(TextView)itemView.findViewById(R.id.tvEquipo);
            codigo=(TextView)itemView.findViewById(R.id.tvCodigo);
            liga=(TextView)itemView.findViewById(R.id.tvLiga);


        }
    }

    public List<EquiposModelo> equiposList;

    public RecyclerViewAdaptador(List<EquiposModelo> equiposList) {
        this.equiposList = equiposList;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_equipo,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.equipo.setText(equiposList.get(position).getEquipo());
        holder.codigo.setText(equiposList.get(position).getCodigo());
        holder.liga.setText(equiposList.get(position).getLiga());


    }

    @Override
    public int getItemCount() {
        return equiposList.size();
    }
}
