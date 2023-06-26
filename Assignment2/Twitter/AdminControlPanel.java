package Assignment2.Twitter;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import DesignPattern.UserView;
import DesignPattern.VisitMessage;
import DesignPattern.Visited;

//This class acts as the centralized panel for doing everything. Such as creating accounts and groups, as well as managing them and checking analytics.
//This would be the Singleton Design Pattern
public class AdminControlPanel extends javax.swing.JFrame implements TreeSelectionListener 
{
    //Starts a new instance of the control panel.
    private static AdminControlPanel instance = new AdminControlPanel();

    public static AdminControlPanel getInstance() 
    {
        return instance;
    }

    //Setting up the tree which will store our users and groups.
    private javax.swing.JTree tree;
    private javax.swing.JPanel treeView;
    private UserGroup root;
    private User current;
    private UserGroup currentGroup;

    //Giving the window the option to scroll as well as create options for users and groups.
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel userOptions, groupOptions;

    //Allowing the user to input names for groups and users.
    private JTextField userName, groupName;

    //Setting up buttons.
	private JButton openUserView, showUserTotal, showGroupTotal, showPosPercent, showMsgTotal;
    
    //Constructor for the control panel.
    private AdminControlPanel() 
    {
        //This is the starting point of our tree. There is nothing inside.
        root = new UserGroup("Root");
        initializeComponents();
        current = null;
    }

    private void initializeComponents() 
    {
        //Terminates the program
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //Name of the window
        setTitle("Mini Twitter: Admin Control Panel");
        
        //We do NOT need users to resize the perfectly constructed window.
        setResizable(false);

        //Setting up text fields and buttons for users and groups.
        userOptions = new javax.swing.JPanel();
        groupOptions = new javax.swing.JPanel();

        //Sets up the panel for our user/group list, starting with our root node.
        treeView = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treeNode1 = new DefaultMutableTreeNode(root);
        tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        tree.addTreeSelectionListener(this);
        scrollPane.setViewportView(tree);

        javax.swing.GroupLayout treeViewLayout = new javax.swing.GroupLayout(treeView);
        treeView.setLayout(treeViewLayout);
        treeViewLayout.setHorizontalGroup(
                treeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(treeViewLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addContainerGap()));
        treeViewLayout.setVerticalGroup(
                treeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(treeViewLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)));

        userName = new JTextField();
		JButton addUser = new JButton("Add User");
        addUser.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent event) 
            {
                addUserActionPerformed(event);
            }
        });
                        
        groupName = new JTextField();
	    JButton addGroup = new JButton("Add Group");
        addGroup.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent event) 
            {
                addGroupActionPerformed(event);
            }
        });

        openUserView = new JButton("Open User View");
        openUserView.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent event)
            {
                jButton1ActionPerformed(event);
            }
        });

        showUserTotal = new JButton("Show User Total");
        showUserTotal.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent event)
            {
                userTotalActionPerformed(event);
            }
        });

        showGroupTotal = new JButton("Show Group Total");
        showGroupTotal.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent event)
            {
                groupTotalActionPerformed(event);
            }
        });

        showMsgTotal= new JButton("Show Messages Total");
        showMsgTotal.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent event)
            {
                messageTotalActionPerformed(event);
            }
        });

        showPosPercent= new JButton("Show Positive Percentage");
        showPosPercent.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent event)
            {
                positiveAmountActionPerformed(event);
            }
        });

        javax.swing.GroupLayout userLayout = new javax.swing.GroupLayout(userOptions);
        userOptions.setLayout(userLayout);
        userLayout.setHorizontalGroup(
            userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        userLayout.setVerticalGroup(
            userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addUser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout groupLayout = new javax.swing.GroupLayout(groupOptions);
        groupOptions.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(groupName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(groupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(groupName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
 
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(treeView, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(userOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(groupOptions, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(openUserView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(showUserTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(showGroupTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addComponent(showMsgTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(showPosPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap()));

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(userOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(groupOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(openUserView, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(showUserTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(showGroupTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(1, 1, 1)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(showMsgTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(showPosPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(treeView)))
                                .addContainerGap()));
        pack();
    }

    public DefaultMutableTreeNode getCurrentGroup()
    {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (node == null) {
            node = (DefaultMutableTreeNode) tree.getModel().getRoot();
        }
        if (node.getUserObject().getClass().equals(User.class))
        {
            node = (DefaultMutableTreeNode) node.getParent();
        }
        return node;
    }

    @Override
    public void valueChanged(TreeSelectionEvent select)
    {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

        if (node == null) {
            return;
        }

        Object info = node.getUserObject();

        if (node.getUserObject().getClass().equals(User.class))
        {
            current = (User) info;
            currentGroup = UserGroup.findGroup(current.getGroup());
        }
        else
        {
            current = null;
            currentGroup = (UserGroup) info;
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent event)
    {
        if (current != null)
        {
            JFrame userWindow = new JFrame();
            userWindow.setSize(new Dimension(400, 400));
            userWindow.setTitle(current.getUserID());
            userWindow.setLayout(new BorderLayout());
            userWindow.add(new UserView(current), BorderLayout.CENTER);
            userWindow.setVisible(true);
        }
    }

    private void addUserActionPerformed(java.awt.event.ActionEvent event)
    {
        String id = this.userName.getText();
        if (currentGroup == null)
        {
            currentGroup = UserGroup.findGroup("Root");
        }
        if (!User.exists(id))
        {
            User temp = new User(id, currentGroup.getUserID());
            if (current == null)
            {
                current = temp;
            }
            currentGroup.add(temp);
            DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
            model.insertNodeInto(new DefaultMutableTreeNode(temp), this.getCurrentGroup(),
                    this.getCurrentGroup().getChildCount());

        }
    }

    private void addGroupActionPerformed(java.awt.event.ActionEvent event)
    {
        String id = this.groupName.getText();
        if (currentGroup == null)
        {
            currentGroup = UserGroup.findGroup("Root");
        }
        if (!UserGroup.exists(id))
        {
            UserGroup temp = new UserGroup(id);
            currentGroup.add(temp);
            DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
            model.insertNodeInto(new DefaultMutableTreeNode(temp), this.getCurrentGroup(),
                    this.getCurrentGroup().getChildCount());
        }
    }

    private void groupTotalActionPerformed(java.awt.event.ActionEvent event)
    {
        JOptionPane.showMessageDialog(null, "Group Total: " + UserGroup.groups.size());
    }

    private void userTotalActionPerformed(java.awt.event.ActionEvent event)
    {
        Visited uservisit = new Visited();
        if (current != null) {
            current.accept(uservisit);
        }
    }

    private void messageTotalActionPerformed(java.awt.event.ActionEvent event)
    {
        VisitMessage messagevisit = new VisitMessage();
        if (current != null) {
            current.accept(messagevisit);
        }
    }

    private void positiveAmountActionPerformed(java.awt.event.ActionEvent event)
    {
        PosVisitor positivevisit = new PosVisitor();
        if (current != null)
        {
            current.accept(positivevisit);
        }
    }
}