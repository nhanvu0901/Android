public class EmailListAdapter extends RecyclerView.AdapterEmailListAdapter.EmailViewHolder {

    private ListEmail emails;

    public EmailListAdapter(ListEmail emails) {
        this.emails = emails;
    }

    @NonNull
    @Override
    public EmailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.email_item, parent, false);
        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmailViewHolder holder, int position) {
        Email email = emails.get(position);
        holder.fromTextView.setText(email.getFrom());
        holder.subjectTextView.setText(email.getSubject());
        holder.messageTextView.setText(email.getMessage());
    }

    @Override
    public int getItemCount() {
        return emails.size();
    }

    public static class EmailViewHolder extends RecyclerView.ViewHolder {
        public TextView fromTextView;
        public TextView subjectTextView;
        public TextView messageTextView;

        public EmailViewHolder(View view) {
            super(view);
            fromTextView = view.findViewById(R.id.from_text_view);
            subjectTextView = view.findViewById(R.id.subject_text_view);
            messageTextView = view.findViewById(R.id.message_text_view);
        }
    }
}