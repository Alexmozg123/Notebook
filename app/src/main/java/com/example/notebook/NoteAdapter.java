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
    private int numberItems;

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
        noteHolder.listItemsNumberView.setText("View holder index: " + viewHolderCount);

        viewHolderCount++;

        return noteHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberNoteHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class NumberNoteHolder extends RecyclerView.ViewHolder {

        TextView listItemsNumberView;

        public NumberNoteHolder(@NonNull View itemView) {
            super(itemView);

            listItemsNumberView = itemView.findViewById(R.id.tv_note_list_item);
        }

        void bind(int listItem) {
            listItemsNumberView.setText(String.valueOf(listItem));
        }
    }
}
