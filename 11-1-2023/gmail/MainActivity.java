public class MainActivity extends AppCompatActivity {

    private RecyclerView emailList;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        emailList = findViewById(R.id.email_list);
        emailList.setLayoutManager(new LinearLayoutManager(this));

        EmailListAdapter adapter = new EmailListAdapter(getEmailList());
        emailList.setAdapter(adapter);
    }

    private List<Email> getEmailList() {
        List<Email> emails = new ArrayList<>();
        emails.add(new Email("John Smith", "Hello", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean vel magna a urna ultricies venenatis."));
        emails.add(new Email("Jane Doe", "Important message", "Nam eget sapien scelerisque, fermentum enim non, feugiat nisi."));
        emails.add(new Email("Bob Johnson", "Meeting reminder", "Etiam ullamcorper felis a velit lacinia, ac tristique tellus pulvinar. Morbi ac justo a mi faucibus sagittis."));
        return emails;
    }
}