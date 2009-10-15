package scrum.client;

import ilarkesto.gwt.client.SwitchingNavigatorWidget;
import scrum.client.admin.ProjectSelectorWidget;
import scrum.client.admin.SystemMessageManagerWidget;
import scrum.client.admin.UserConfigWidget;
import scrum.client.admin.UserListWidget;
import scrum.client.common.AScrumComponent;
import scrum.client.workspace.PagePanel;

import com.google.gwt.user.client.ui.Image;

public class HomeContext extends AScrumComponent {

	private PagePanel sidebar;
	private SwitchingNavigatorWidget navigator;
	private ProjectSelectorWidget projectSelector;
	private UserConfigWidget userConfig;
	private UserListWidget userList;
	private SystemMessageManagerWidget messageManager;

	@Override
	protected void onInitialization() {
		super.onInitialization();
		projectSelector = new ProjectSelectorWidget();
		userConfig = new UserConfigWidget();
		messageManager = new SystemMessageManagerWidget();

		navigator = new SwitchingNavigatorWidget(ComponentManager.get().getUi().getWorkspace().getWorkarea());
		navigator.addItem((Image) null, "Projects", projectSelector);
		navigator.addItem((Image) null, "Personal Preferences", userConfig);
		if (getCurrentUser().isAdmin()) {
			userList = new UserListWidget();
			navigator.addItem((Image) null, "User Management", userList);
			navigator.addItem((Image) null, "System Message Management", messageManager);
		}

		sidebar = new PagePanel();
		sidebar.addSection(navigator);
	}

	public void activate() {
		cm.getUi().show(sidebar, projectSelector);
	}

	public UserListWidget getUserList() {
		return userList;
	}

}