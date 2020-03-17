package com.example.opsecmessenger.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.opsecmessenger.R;
import com.example.opsecmessenger.models.NoteModal;

import java.util.ArrayList;
import java.util.List;

public class NoteRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private List<NoteModal> mNote= new ArrayList<>();

    public NoteRecyclerViewAdapter(Context mContext, List<NoteModal> mNote) {
        this.mContext = mContext;
        this.mNote = mNote;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_note_item_layout, parent, false);
        NoteRecyclerViewAdapter.ViewHolder vh = new NoteRecyclerViewAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((ViewHolder)holder).title.setText(mNote.get(position).getTitle());
        ((ViewHolder)holder).date.setText(mNote.get(position).getDate());
        ((ViewHolder)holder).note.setText(mNote.get(position).getNote());



    }

    @Override
    public int getItemCount() {
        return mNote.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView title, note, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            note = itemView.findViewById(R.id.message);
            date = itemView.findViewById(R.id.date);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            Navigation.findNavController(view).navigate(R.id.action_noteFragment_to_editNoteFragment);
        }
    }

}
