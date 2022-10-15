package com.example.notebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder>{

    private static int viewHolderCount;
    private final int numberItems;

    private final Context parent;

    public NoteAdapter(int numberOfItems, Context parent) {
        numberItems = numberOfItems;
        viewHolderCount = 0;
        this.parent = parent;
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.note_list_item;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, parent, false);

        NoteHolder noteHolder = new NoteHolder(view);
        noteHolder.viewHolderIndex.setText("ViewHolderIndex: " + viewHolderCount);

        viewHolderCount++;

        return noteHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class NoteHolder extends RecyclerView.ViewHolder {

        TextView listItemsNumberView;
        TextView viewHolderIndex;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);

            listItemsNumberView = itemView.findViewById(R.id.tv_note_list_item);
            viewHolderIndex = itemView.findViewById(R.id.tv_view_holder_number);

            itemView.setOnClickListener(view -> {
                int thisElement = getAbsoluteAdapterPosition();

                Toast toast = Toast.makeText(
                        parent,
                        "You click: " + thisElement,
                        Toast.LENGTH_SHORT);
                toast.show();
            });
        }

        void bind(int listIndex) {
            listItemsNumberView.setText(String.valueOf(listIndex));
        }
    }
}
