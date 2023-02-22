public class ContactDetailActivity extends AppCompatActivity {
    private TextView mNameTextView;
    private TextView mPhoneTextView;
    private TextView mEmailTextView;
    private Contact mContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

      
        Intent intent = getIntent();
        mContact = (Contact) intent.getSerializableExtra("contact");

     
        mNameTextView = findViewById(R.id.text_view_name_detail);
        mPhoneTextView = findViewById(R.id.text_view_phone_detail);
        mEmailTextView = findViewById(R.id.text_view_email_detail);

      
        mNameTextView.setText(mContact.getName());
        mPhoneTextView.setText(mContact.getPhone());
        mEmailTextView.setText(mContact.getEmail());
    }
}