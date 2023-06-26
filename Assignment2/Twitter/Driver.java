package Assignment2.Twitter;

public class Driver
{
    public static void main(String[] args)
    {
        AdminControlPanel panel = AdminControlPanel.getInstance();

        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                panel.setVisible(true);
            }
        });
    }
}
