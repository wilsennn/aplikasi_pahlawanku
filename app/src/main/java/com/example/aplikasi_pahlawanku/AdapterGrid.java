import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ahmfarisi.pahlawanku.R;
import com.ahmfarisi.pahlawanku.model.ModelPahlawan;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;
public class AdapterGrid extends
        RecyclerView.Adapter<AdapterGrid.GridViewHolder>{
    private ArrayList<ModelPahlawan> dataPahlawan;
    public AdapterGrid(ArrayList<ModelPahlawan> dataPahlawan)
    {
        this.dataPahlawan = dataPahlawan;
    }
    public interface OnItemClickCallBack {
        void onItemClicked(ModelPahlawan data);
    }
    private OnItemClickCallBack callBack;
    public void setOnItemClickCallBack(OnItemClickCallBack
                                               callBack){
        this.callBack = callBack;
    }
    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull
    ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid, parent, false);
        return new GridViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(dataPahlawan.get(position).getFoto())
                .apply(new RequestOptions().override(350,
                        550))
                .into(holder.ivGrid);
        holder.itemView.setOnClickListener(new
                65
                View.OnClickListener() {
            @Override
            public void onClick(View.view) {

                callBack.onItemClicked(dataPahlawan.get(holder.getAdapterPosi tion()));
            }
        });
    }
    @Override
    public int getItemCount() {
        return dataPahlawan.size();
    }
    public class GridViewHolder extends
            RecyclerView.ViewHolder {
        ImageView ivGrid;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGrid = itemView.findViewById(R.id.iv_grid);
        }
    }
}