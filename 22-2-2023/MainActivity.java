public class MainActivity extends AppCompatActivity {


private List<File> getFiles(File directory) {
    List<File> files = new ArrayList<>();
    File[] fileList = directory.listFiles();
    if (fileList != null) {
        for (File file : fileList) {
            if (file.isDirectory()) {
                files.add(file);
            } else if (isTextFile(file) || isImageFile(file)) {
                files.add(file);
            }
        }
    }
    return files;
}

private boolean isTextFile(File file) {
    String name = file.getName();
    String extension = name.substring(name.lastIndexOf(".")).toLowerCase();
    return extension.equals(".txt");
}

private boolean isImageFile(File file) {
    String name = file.getName();
    String extension = name.substring(name.lastIndexOf(".")).toLowerCase();
    return extension.equals(".bmp") || extension.equals(".jpg") || extension.equals(".png");
}


private void updateList(File directory) {
    List<File> files = getFiles(directory);
    FileAdapter adapter = new FileAdapter(files);
    adapter.setOnItemClickListener(new FileAdapter.OnItemClickListener() {
    @Override
    public void onItemClick(File file) {
    if (file.isDirectory()) {
    updateList(file);
    } else {
    if (isTextFile(file)) {
    // display the content of the text file
    } else if (isImageFile(file)) {
    // display the image file
    }
    }
}
    @Override
    public void onItemLongClick(File file) {
            showFileOptionsDialog(file);
        }
    });
    recyclerView.setAdapter(adapter);
}

private void showFileOptionsDialog(final File file) {
    String[] options = {"Rename", "Delete", "Copy"};
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle(file.getName())
    .setItems(options, new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int which) {
    switch (which) {
    case 0:
    // rename 
    break;
    case 1:
    // xoa file or directory
    break;
    case 2:
    // copy file to another directory
    break;
    }
    }
    });
    builder.create().show();
}

// option menu
@Override
public boolean onCreateOptionsMenu(Menu menu) {
getMenuInflater().inflate(R.menu.menu_main, menu);
return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
switch (item.getItemId()) {
case R.id.new_folder:
// create a new directory
return true;
case R.id.new_text_file:
// create a new text file
return true;
default:
return super.onOptionsItemSelected(item);
}
}










}