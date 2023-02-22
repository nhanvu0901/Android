public class FileAdapter extends RecyclerView.Adapter<FileAdapter.ViewHolder> {
    private List<File> mFiles;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(File file);
        void onItemLongClick(File file);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView icon;

        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            icon = itemView.findViewById(R.id.icon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onItemClick(mFiles.get(position));
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onItemLongClick(mFiles.get(position));
                        return true;
                    }
                    return false;
                }
            });
        }
    }

    public FileAdapter(List<File> files) {
        mFiles = files;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v, mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        File file = mFiles.get(position);
        holder.name.setText(file.getName());

        if (file.isDirectory()) {
            holder.icon.setImageResource(R.drawable.ic_folder);
        } else if (isImageFile(file)) {
            holder.icon.setImageResource(R.drawable.ic_image);
        } else {
            holder.icon.setImageResource(R.drawable.ic_file);
        }
    }

    @Override
    public int getItemCount() {
        return mFiles.size();
    }

    private boolean isImageFile(File file) {
        String name = file.getName();
        String extension = name.substring(name.lastIndexOf(".")).toLowerCase();
        return extension.equals(".bmp") || extension.equals(".jpg") || extension.equals(".png");
    }
}