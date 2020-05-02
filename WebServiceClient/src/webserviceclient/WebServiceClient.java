package webserviceclient;
import com.FileUpload;
import com.FileUpload_Service; 
import java.awt.Button;
import java.awt.Frame;
import java.awt.List;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class WebServiceClient extends Frame implements ActionListener
{ 
    Button showFileButton = new Button("ShowFile");
    Button exitButton = new Button("Exit");
    TextArea fileTextArea = new TextArea();
    List booksList = new List();
    
    FileUpload_Service service =  new FileUpload_Service();
    
    public WebServiceClient()
    {
        super("lab5");
        setLayout(null);
        setSize(340,350);
        add(showFileButton);
        add(exitButton);
        add(fileTextArea);
        add(booksList);
        
        showFileButton.setBounds(70, 320, 100, 20);
        showFileButton.addActionListener(this);
        exitButton.setBounds(190, 320, 100, 20 );
        exitButton.addActionListener(this);
        booksList.setBounds(20,200, 300, 100);
        fileTextArea.setBounds(20,50, 300, 150);
        
        for(String fileName : service.getFileUploadPort().getBooks())
        {
            booksList.add(fileName);
        }
        
        this.show();
        this.setLocationRelativeTo(null);
    }
    
    public static void main(String[] args)
    {    
        new WebServiceClient();
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == showFileButton)
        {
            String fileName = booksList.getSelectedItem();
            byte[] bytes = service.getFileUploadPort().getFile(fileName);
            ShowFile(bytes);
        }
        if(ae.getSource() == exitButton)
        {
            System.exit(0);
        }
    }
    
    private void ShowFile(byte[] bytes)
    {
        String fileToShow = new String(bytes);
        fileTextArea.setText(fileToShow);
    }
}