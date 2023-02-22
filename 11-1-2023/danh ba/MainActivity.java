public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Contact> contactList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < 20; i++) {
            String id = String.valueOf(i);
            String name = Faker.instance().name().fullName();
            String phone = Faker.instance().phoneNumber().cellPhone();
            String email = Faker.instance().internet().emailAddress();
            contactList.add(new Contact(id, name, phone, email));
        }

        ContactListAdapter adapter = new ContactListAdapter(contactList);
        recyclerView.setAdapter(adapter);
    }

    private class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder> {

        private ArrayList<Contact> contactList;

        public ContactListAdapter(ArrayList<Contact> contactList) {
            this.contactList = contactList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_contact, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Contact contact = contactList.get(position);
            holder.textViewName.setText(contact.getName());
            holder.textViewPhone.setText(contact.getPhone());

            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, ContactDetailActivity.class);
                intent.putExtra("contact", contact);
                startActivity(intent);
            });

            holder.itemView.setOnLongClickListener(v -> {
                showContextMenu(contact);
                return true;
            });
        }

        @Override
        public int getItemCount() {
            return contactList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView textViewName, textViewPhone;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textViewName = itemView.findViewById(R.id.text_view_name);
                textViewPhone = itemView.findViewById(R.id.text_view_phone);
            }
        }
    }

    private void showContextMenu(Contact contact) {
        registerForContextMenu(recyclerView);
        openContextMenu(recyclerView);
        unregisterForContextMenu(recyclerView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contact_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_call:
                // TODO: make a phone call
                return true;
            case R.id.menu_sms:
                // TODO: send a text message
                return true;
            case R.id.menu_email:
                // TODO: send an email
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}