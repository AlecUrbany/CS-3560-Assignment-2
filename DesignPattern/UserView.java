package DesignPattern;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JOptionPane;
import Assignment2.Twitter.User;
import Assignment2.Twitter.UserGroup;

public class UserView extends javax.swing.JPanel implements Observer
{
	private User current;

	private javax.swing.JButton followButton, tweetButton;
	private javax.swing.JTextField followName, tweetInput;
	private javax.swing.JList following, newsFeed;
	private javax.swing.JPanel followPanel, followingPanel, tweetPanel, feedPanel;
	private javax.swing.JScrollPane followingScrollPane, feedScrollPane;

	public UserView(User user)
	{
		current = user;
		current.getFeed().register(this);
		start();
	}

	@SuppressWarnings("unchecked")
	private void start()
	{

		JButton creationTime = new JButton("User Creation Time");
		creationTime.addActionListener(new java.awt.event.ActionListener() 
		{
			public void actionPerformed(java.awt.event.ActionEvent evt) 
			{
				creationTimeActionPerformed(evt);
			}
		});

		followName = new javax.swing.JTextField();
		tweetInput = new javax.swing.JTextField();

		following = new javax.swing.JList();
		newsFeed = new javax.swing.JList();

		followPanel = new javax.swing.JPanel();
		followingPanel = new javax.swing.JPanel();
		followingScrollPane = new javax.swing.JScrollPane();
		
		tweetPanel = new javax.swing.JPanel();
		feedPanel = new javax.swing.JPanel();
		feedScrollPane = new javax.swing.JScrollPane();
		
		followButton = new javax.swing.JButton("Follow User");
		followButton.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				followBtnActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout followLayout = new javax.swing.GroupLayout(followPanel);
		followPanel.setLayout(followLayout);
		followLayout.setHorizontalGroup(
			followLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, followLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(followName)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(followButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addContainerGap()));
		followLayout.setVerticalGroup(
			followLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(followLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(followLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(followButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
						.addComponent(followName))
					.addContainerGap()));

		followingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Following: "));

		following.setModel(new javax.swing.DefaultListModel()
		{
		});
		updateFollowing();
		followingScrollPane.setViewportView(following);

		javax.swing.GroupLayout followingLayout = new javax.swing.GroupLayout(followingPanel);
		followingPanel.setLayout(followingLayout);
		followingLayout.setHorizontalGroup(
			followingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(followingLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(followingScrollPane)
				.addComponent(creationTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap()));
		followingLayout.setVerticalGroup(
			followingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(followingLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(followingScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(creationTime, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		tweetButton = new javax.swing.JButton("Post Tweet");
		tweetButton.addActionListener(new java.awt.event.ActionListener()
		{
		public void actionPerformed(java.awt.event.ActionEvent evt)
		{
			tweetBtnActionPerformed(evt);
		}
		});

		javax.swing.GroupLayout tweetLayout = new javax.swing.GroupLayout(tweetPanel);
		tweetPanel.setLayout(tweetLayout);
		tweetLayout.setHorizontalGroup(
			tweetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(tweetLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tweetInput, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(tweetButton, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
					.addContainerGap()));
		tweetLayout.setVerticalGroup(
			tweetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(tweetLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(tweetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(tweetButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50,
							Short.MAX_VALUE)
						.addComponent(tweetInput))
					.addContainerGap()));

		feedPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("News Feed: "));

		newsFeed.setModel(new javax.swing.DefaultListModel()
		{
		});
		updateFeed();
		feedScrollPane.setViewportView(newsFeed);

		javax.swing.GroupLayout feedLayout = new javax.swing.GroupLayout(feedPanel);
		feedPanel.setLayout(feedLayout);
		feedLayout.setHorizontalGroup(
			feedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(feedScrollPane));
		feedLayout.setVerticalGroup(
			feedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(feedScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(followPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(followingPanel, javax.swing.GroupLayout.Alignment.TRAILING,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tweetPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(feedPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap()));
		layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(followPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(followingPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(tweetPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(feedPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
						100, Short.MAX_VALUE)
					.addContainerGap()));
	}

	private void followBtnActionPerformed(java.awt.event.ActionEvent evt)
	{
		String userName = followName.getText();
		if (User.exists(userName) && !current.getUserID().equals(userName) && !current.isFollowing(userName))
		{
			current.follow(userName);
			updateFollowing();
		}
	}


	private void creationTimeActionPerformed(java.awt.event.ActionEvent event)
	{
		Long time = this.current.getTime();
		JOptionPane.showMessageDialog(null, "User Created At:\n" + time + " nanoseconds");
	}

	private void tweetBtnActionPerformed(java.awt.event.ActionEvent evt)
	{
		current.tweet(tweetInput.getText());
	}

	private void updateFollowing()
	{
		DefaultListModel model = new DefaultListModel();
		ArrayList<String> follow = current.getFollowing();
		for (String s : follow)
		{
			model.addElement(s);
		}
		following.setModel(model);
		following.setSelectedIndex(0);
	}

	private void updateFeed()
	{
		DefaultListModel model = new DefaultListModel();
		ArrayList<String> feed = current.getFeed().getFeed();
		for (String s : feed)
		{
		model.addElement(s);
		}
		newsFeed.setModel(model);
		newsFeed.setSelectedIndex(0);
	}

	@Override
	public void update(String msg, Subject subject)
	{
		updateFeed();
	}

	@Override
	public void makeMsgInNewsFeed() {}

	@Override
	public void updateUser(int user) {}

	@Override
	public void print(String print)
	{
		System.out.print(print);
	}
}
