package scrum.client.workspace;

import ilarkesto.gwt.client.AWidget;
import ilarkesto.gwt.client.NavigatorWidget;
import scrum.client.ScrumGwtApplication;
import scrum.client.admin.UserListWidget;
import scrum.client.img.Img;
import scrum.client.impediments.ImpedimentListWidget;
import scrum.client.project.ProductBacklogWidget;
import scrum.client.project.ProjectOverviewWidget;
import scrum.client.project.QualityBacklogWidget;
import scrum.client.project.Requirement;
import scrum.client.risks.RiskListWidget;
import scrum.client.sprint.NextSprintWidget;
import scrum.client.sprint.SprintBacklogWidget;
import scrum.client.test.WidgetsTesterWidget;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class WorkareaWidget extends AWidget {

	private NavigatorWidget navigator;
	private SimplePanel wrapper = new SimplePanel();
	private Widget currentWidget; // TODO AWidget

	private ProjectOverviewWidget projectOverview;
	private SprintBacklogWidget sprintBacklog;
	private ProductBacklogWidget productBacklog;
	private QualityBacklogWidget qualityBacklog;
	private NextSprintWidget nextSprint;
	private ImpedimentListWidget impedimentList;
	private RiskListWidget riskList;
	private UserListWidget userList;
	private WidgetsTesterWidget widgetsTester;

	@Override
	protected Widget onInitialization() {

		navigator = getNavigator();

		navigator.addItem(Img.bundle.project16(), "Project Overview", getProjectOverview(), new Runnable() {

			public void run() {
				show(getProjectOverview());
			}
		});

		navigator.addItem(Img.bundle.sprint16(), "Sprint Backlog", getSprintBacklog(), new Runnable() {

			public void run() {
				ScrumGwtApplication.get().callRequestRequirements();
				show(getSprintBacklog());
			}
		});

		navigator.addItem(Img.bundle.requirement16(), "Product Backlog", getProductBacklog(), new Runnable() {

			public void run() {
				ScrumGwtApplication.get().callRequestRequirements();
				show(getProductBacklog());
			}
		});

		navigator.addItem(Img.bundle.requirement16(), "Quality Backlog", getQualityBacklog(), new Runnable() {

			public void run() {
				ScrumGwtApplication.get().callRequestQualitys();
				show(getQualityBacklog());
			}
		});

		navigator.addItem(Img.bundle.impediment16(), "Impediment List", getImpedimentList(), new Runnable() {

			public void run() {
				ScrumGwtApplication.get().callRequestImpediments();
				show(getImpedimentList());
			}
		});

		navigator.addItem(Img.bundle.risk16(), "Risk Management", getRiskList(), new Runnable() {

			public void run() {
				ScrumGwtApplication.get().callRequestRisks();
				show(getRiskList());
			}
		});

		navigator.addItem(Img.bundle.sprint16(), "Next Sprint", getNextSprint(), new Runnable() {

			public void run() {
				show(getNextSprint());
			}
		});

		navigator.addItem(Img.bundle.user16(), "User Management", getUserList(), new Runnable() {

			public void run() {
				show(getUserList());
			}
		});

		navigator.addItem(Img.bundle.test16(), "WidgetsTester", getWidgetsTester(), new Runnable() {

			public void run() {
				show(getWidgetsTester());
			}
		});

		currentWidget = new Label("workarea");
		wrapper = new SimplePanel();
		wrapper.setStyleName("WorkareaWidget");
		wrapper.add(currentWidget);
		return wrapper;
	}

	@Override
	protected void onUpdate() {
		navigator.update();
		wrapper.setWidget(currentWidget);
		if (currentWidget != null && currentWidget instanceof AWidget) {
			((AWidget) currentWidget).update();
		}
	}

	public void showSprintBacklog(final Requirement r) {
		showSprintBacklog();
		getSprintBacklog().selectRequirement(r);
	}

	public void showSprintBacklog() {
		navigator.select(getSprintBacklog());
	}

	public void showProjectOverview() {
		navigator.select(getProjectOverview());
	}

	public boolean isProjectOverview() {
		return currentWidget == projectOverview;
	}

	private void show(AWidget widget) {
		currentWidget = widget;
		Ui.get().unlock();
		update();
	}

	public ProjectOverviewWidget getProjectOverview() {
		if (projectOverview == null) projectOverview = new ProjectOverviewWidget();
		return projectOverview;
	}

	public SprintBacklogWidget getSprintBacklog() {
		if (sprintBacklog == null) sprintBacklog = new SprintBacklogWidget();
		return sprintBacklog;
	}

	public NextSprintWidget getNextSprint() {
		if (nextSprint == null) nextSprint = new NextSprintWidget();
		return nextSprint;
	}

	public ProductBacklogWidget getProductBacklog() {
		if (productBacklog == null) productBacklog = new ProductBacklogWidget();
		return productBacklog;
	}

	public QualityBacklogWidget getQualityBacklog() {
		if (qualityBacklog == null) qualityBacklog = new QualityBacklogWidget();
		return qualityBacklog;
	}

	public ImpedimentListWidget getImpedimentList() {
		if (impedimentList == null) impedimentList = new ImpedimentListWidget();
		return impedimentList;
	}

	public RiskListWidget getRiskList() {
		if (riskList == null) riskList = new RiskListWidget();
		return riskList;
	}

	public UserListWidget getUserList() {
		if (userList == null) userList = new UserListWidget();
		return userList;
	}

	public WidgetsTesterWidget getWidgetsTester() {
		if (widgetsTester == null) widgetsTester = new WidgetsTesterWidget();
		return widgetsTester;
	}

	public NavigatorWidget getNavigator() {
		if (navigator == null) navigator = new NavigatorWidget();
		return navigator;
	}

	public static WorkareaWidget get() {
		return WorkspaceWidget.get().getWorkarea();
	}
}