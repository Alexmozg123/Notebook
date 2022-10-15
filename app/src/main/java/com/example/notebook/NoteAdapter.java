package com.example.notebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NumberNoteHolder>{

    private static int viewHolderCount;
    private final int numberItems;

    public NoteAdapter(int numberOfItems) {
        numberItems = numberOfItems;
        viewHolderCount = 0;
    }

    @NonNull
    @Override
    public NumberNoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.note_list_item;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, parent, false);

        NumberNoteHolder noteHolder = new NumberNoteHolder(view);
        noteHolder.viewHolderIndex.setText("ViewHolderIndex: " + viewHolderCount);

        viewHolderCount++;

        return noteHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberNoteHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    static class NumberNoteHolder extends RecyclerView.ViewHolder {

        TextView listItemsNumberView;
        TextView viewHolderIndex;

        public NumberNoteHolder(@NonNull View itemView) {
            super(itemView);

            listItemsNumberView = itemView.findViewById(R.id.tv_note_list_item);
            viewHolderIndex = itemView.findViewById(R.id.tv_view_holder_number);
        }

        void bind(int listIndex) {
            listItemsNumberView.setText(String.valueOf(listIndex));
        }
    }
}
