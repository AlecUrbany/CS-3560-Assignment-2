package Assignment2.Twitter;

//The driver file for our project.
public class Driver
{
    public static void main(String[] args)
    {
        //This sets up our Admin Control Panel for later.
        AdminControlPanel panel = AdminControlPanel.getInstance();

        //Actually runs the driver file.
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                //Sets the Admin controls to be actually visible.
                panel.setVisible(true);
            }
        });
    }
}
